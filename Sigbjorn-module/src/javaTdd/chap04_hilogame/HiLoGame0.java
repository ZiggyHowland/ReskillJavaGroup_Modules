package javaTdd.chap04_hilogame;

import javaTdd.chap04_hilogame.dependencies.SecretNumber;
import javaTdd.chap04_hilogame.dependencies.UserGuess;

import java.util.ArrayList;
import java.util.List;

public class HiLoGame0 {
	public static final int UPPER_LIMIT = 100;
	public static final String CORRECT_STRING = "Correct! ";
	private SecretNumber secretNumber;
	private UserGuess userGuess;
	private List<Integer> guesses;


	public HiLoGame0(SecretNumber sn, UserGuess ug) { // Dependecy injection (reals or stubs)
		// External dependencies
		this.secretNumber = sn;
		this.userGuess = ug;

		// Internal data
		guesses = new ArrayList<>();
	}


	public void start() {
		int magicNumber = this.secretNumber.createSecretNumber(UPPER_LIMIT);
		int thisGuess;
		printToConsole(String.format("Guess a number between 1 and %d: ", UPPER_LIMIT));

		while (true) {
			thisGuess = this.userGuess.nextGuess();
			guesses.add(thisGuess);
			String status = this.evaluateGuess(thisGuess, magicNumber);
			printToConsole(status);
			if (status.equalsIgnoreCase(CORRECT_STRING)) {
				break;
			}
		}

		printToConsole(getSummaryString());

	}

	private String evaluateGuess(int thisGuess, int magicNumber) {
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

	private String getSummaryString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("You took %d guesses: ", this.guesses.size()));
		for (int n : this.guesses) {
			sb.append(String.format("%d ", n));
		}
		return sb.toString();
	}


	private static void printToConsole(String s) {
		System.out.print(s);
	}


}
