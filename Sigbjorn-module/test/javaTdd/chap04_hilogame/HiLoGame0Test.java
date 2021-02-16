package javaTdd.chap04_hilogame;

import javaTdd.chap04_hilogame.dependencies.NextGuessGenerator;
import javaTdd.chap04_hilogame.dependencies.RandomNumberGenerator;
import javaTdd.chap04_hilogame.dependencies.SecretNumberStub;
import javaTdd.chap04_hilogame.dependencies.UserGuessStub;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HiLoGame0Test {
    HiLoGame0 fixture;
    RandomNumberGenerator secretNumber = new SecretNumberStub();

    @Before
    public void setupTest() {
        fixture = new HiLoGame0(secretNumber, null);
    }

    @Test
    public void examineGuess_tooLow_returnsHigher() {
        assertThat(fixture.evaluateGuess(40, 60 ), equalTo("Higher! "));
    }

    @Test
    public void examineGuess_tooHigh_returnsLower() {
        assertThat(fixture.evaluateGuess(60, 40), equalTo("Lower! "));
    }

    @Test
    public void examineGuess_correct_returnsCorrect() {
        assertThat(fixture.evaluateGuess(50, 50), equalTo("Correct! "));
    }

    @Test
    public void formatResultMessage_severalGuesses_returnsStringOfGuesses() {
        List<Integer> guesses = Arrays.asList(10, 70, 50, 30, 22);
        String actual = fixture.getSummaryString(guesses);
        String expected = "You took 5 guesses: 10 70 50 30 22 ";
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void formatResultMessage_singleGuess_returnsStringOfSingularGuess() {

    }

    @Test
    public void playGame_severalGuesses_returnsStringOfGuesses() {
        NextGuessGenerator guesses = new UserGuessStub(10, 70, 50, 30, 22, 26);
        HiLoGame0 game = new HiLoGame0(secretNumber, guesses);
        String actual = game.start(52); // Magic number is half
        String expected = "You took 6 guesses: 10 70 50 30 22 26 ";
        assertEquals(expected, actual);

    }
}