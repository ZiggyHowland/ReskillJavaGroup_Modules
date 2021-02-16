package TicTacToe.Dependencies;

import java.util.Scanner;

public class UiFromConsole implements Ui {

    private Scanner input = new Scanner(System.in);

    @Override
    public String inputFromUser(){
        return input.next();
    }
}
