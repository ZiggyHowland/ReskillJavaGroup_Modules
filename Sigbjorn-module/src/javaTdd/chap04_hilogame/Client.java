package javaTdd.chap04_hilogame;

import javaTdd.chap04_hilogame.dependencies.SecretNumber;
import javaTdd.chap04_hilogame.dependencies.UserGuess;

public class Client {
    public static void main(String[] args) {
        // Real implementation (for running this)
        SecretNumber sn = new SecretNumber();
        UserGuess ug = new UserGuess();

        // Create object
        HiLoGame0 game = new HiLoGame0(sn, ug);
        game.start();
    }
}
