package javaTdd.chap04_hilogame.dependencies;

import java.util.Scanner;

public class UserGuess implements NextGuessGenerator{
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public int nextGuess() {
        return scanner.nextInt();
    }
}
