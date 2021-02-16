package TicTacToe;

import TicTacToe.Dependencies.Ui;
import TicTacToe.Dependencies.UiFromConsole;


//import java.util.Scanner;

public class Menu {
    private Gameboard gameboard = new Gameboard();
    private String player = "Player 1";
    private String playerSymbol = "X";
    private Ui ui;

    public String updateBoard;
    public Menu(Ui c) {
        this.ui = c;
    }

    public void mainMenu() {
        printGameInstructions();

        boolean activeMenu = true;
        System.out.println(gameboard.printBoardAsString());
        while (activeMenu) {

            boolean menuLoop = true;
            int i = 2;
            while (menuLoop) {

                // if turncount is even: player 1, if odd: player 2
                setPlayer1or2_followTurnCount(i);

                System.out.printf("%s, enter your choice: ", player);

                //input from user
                String select = getInputFromUser();


                //  checks if input is a valid input and not already taken.
                if (gameboard.checkIfInputIsValid(select) == false) {
                    System.out.printf("%s is not a valid choice, try again.\n", select);
                    i--;

                } else {
                    updateBoard = validInput_updateGameboard(select);


                    if (updateBoard == ("Victory")) {
                        System.out.printf("\nCongratulations %s! \nThree %s's in a row.\n", player, playerSymbol);
                        menuLoop = false;
                        break;
                    }
                    if (updateBoard == ("Draw")) {
                        menuLoop = false;
                        break;
                    }
                }
                i++;
            }
            System.out.println("\nGAME OVER");
            break;
//no further menu options at this point
        }
    }

    public void setPlayer1or2_followTurnCount(int i) {
        if (i % 2 == 0) {
            setPlayer("Player 1");
            setPlayerSymbol("X");
        } else {
            setPlayer("Player 2");
            setPlayerSymbol("O");
        }
    }

    public String getInputFromUser() {
        String select = ui.inputFromUser().toLowerCase();
        return select;
    }

    public String validInput_updateGameboard(String select) {
        System.out.println("You selected " + select);
        String updateBoard = gameboard.editBoard(select, playerSymbol);

        System.out.println(updateBoard);
        return updateBoard;
    }



    public void printGameInstructions() {
        System.out.println("Welcome to this Tic-Tac-Toe game!\n \n" +
                "Please type the field you select (i.e. c3 for the bottom right corner.\n" +
                "\nPlayer 1 goes first, then player 2.\n");

    }

    public String getPlayer() {
        return player;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setPlayerSymbol(String playerSymbol) {
        this.playerSymbol = playerSymbol;
    }
}


