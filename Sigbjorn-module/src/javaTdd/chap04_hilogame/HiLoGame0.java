package javaTdd.chap04_hilogame;

import javaTdd.chap04_hilogame.dependencies.NextGuessGenerator;
import javaTdd.chap04_hilogame.dependencies.RandomNumberGenerator;
import javaTdd.chap04_hilogame.dependencies.SecretNumber;
import javaTdd.chap04_hilogame.dependencies.UserGuess;

import java.util.ArrayList;
import java.util.List;

public class HiLoGame0 {
	public static final String CORRECT_STRING = "Correct! ";
	private RandomNumberGenerator secretNumber;
	private NextGuessGenerator userGuess;
	private List<Integer> guesses;


	public HiLoGame0(RandomNumberGenerator sn, NextGuessGenerator ug) { // Dependecy injection (reals or stubs)
		// External dependencies
		this.secretNumber = sn;
		this.userGuess = ug;

		// Internal data
		guesses = new ArrayList<>();
	}


	public String start(int upperLimit) {
		int magicNumber = this.secretNumber.createSecretNumber(upperLimit);
		int thisGuess;
		printToConsole(String.format("Guess a number between 1 and %d: ", upperLimit));

		while (true) {
			thisGuess = this.userGuess.nextGuess();
			guesses.add(thisGuess);
			String status = this.evaluateGuess(thisGuess, magicNumber);
			printToConsole(status);
			if (status.equalsIgnoreCase(CORRECT_STRING)) {
				break;
			}
		}

		String summaryString = getSummaryString(this.guesses);
		printToConsole(summaryString);
		return summaryString; // For testing purposes


	}

	public String evaluateGuess(int thisGuess, int magicNumber) {
		if (thisGuess > magicNumber) {
			return "Lower! ";
		}
		else if (thisGuess < magicNumber) {
			return "Higher! ";
		}
		else {
			return CORRECT_STRING;
		}
	}

	public String getSummaryString(List<Integer> guesses) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("You took %d guesses: ", guesses.size()));
		for (int n : guesses) {
			sb.append(String.format("%d ", n));
		}
		return sb.toString();
	}


	private static void printToConsole(String s) {
		System.out.print(s);
	}


}
