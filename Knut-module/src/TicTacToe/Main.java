package TicTacToe;

import TicTacToe.Dependencies.UiFromConsole;

public class Main {

    public static void main(String[] args) {

        //launch menu class
        Menu startMenu = new Menu(new UiFromConsole());
        startMenu.mainMenu();




    }
}

