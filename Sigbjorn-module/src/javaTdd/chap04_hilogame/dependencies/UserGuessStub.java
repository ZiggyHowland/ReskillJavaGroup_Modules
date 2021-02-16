package javaTdd.chap04_hilogame.dependencies;

import java.util.Scanner;

public class UserGuessStub implements NextGuessGenerator{
    int guesses[];
    int index = 0;

    public UserGuessStub(int... guesses) {
        this.guesses = guesses;
    }

    @Override
    public int nextGuess() {
        return this.guesses[index++];
    }
}
