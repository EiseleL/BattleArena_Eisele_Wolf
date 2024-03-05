package BattleArena;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Arena {
	private FighterCharacter f1;
	private FighterCharacter f2;
	private FighterCharacter Winner;
	private boolean SelectedFighter;

	public Arena(FighterCharacter f1, FighterCharacter f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		Winner = null;
		SelectedFighter = randomFighter();
	}

	public FighterCharacter getF1() {
		return f1;
	}

	public void setF1(FighterCharacter f1) {
		this.f1 = f1;
	}

	public FighterCharacter getF2() {
		return f2;
	}

	public void setF2(FighterCharacter f2) {
		this.f2 = f2;
	}

	public FighterCharacter getWinner() {
		return Winner;
	}

	private void setWinner(FighterCharacter winner) {
		Winner = winner;
	}

	/**
	 * Randomly selects a fighter to be the initial attacker.
	 *
	 * @return False if the second fighter is selected as the initial attacker, true
	 *         otherwise.
	 */
	private boolean randomFighter() {
		int random = ThreadLocalRandom.current().nextInt(1, 3);//Endwert ist immer exklusive
		if (random == 1) {
			return false;
		} else
			return true;
	}

	/**
	 * Initiates a fight between two fighter characters, allowing them to take turns
	 * attacking each other until a winner is determined. The fight proceeds with
	 * each fighter alternately attacking the other until one of them wins.
	 * 
	 */
	public void fight(Scanner scanner) {
		
		FighterCharacter attacker;
		FighterCharacter victim;
		do {
			if (this.SelectedFighter == true) {
				attacker = f1;
				victim = f2;
			} else {
				attacker = f2;
				victim = f1;
			}
			printInfo();
			simulateCombat(attacker, victim, scanner);

			this.setWinner(checkWinner());
			this.SelectedFighter = !this.SelectedFighter;
		} while (this.getWinner() == null);

		System.out.println("--- Das Spiel ist vorbei! ---");
		System.out.println(this.Winner.getClassName() + " " + this.Winner.getName() + " hat gewonnen");
	}

	/**
	 * Checks for a winner based on the health status of the fighter characters.
	 *
	 * @return The winning fighter character if one's health reaches or falls below
	 *         0; otherwise, returns null.
	 */
	private FighterCharacter checkWinner() {
		if (f1.getHealth() <= 0) {
			return f2;
		} else if (f2.getHealth() <= 0) {
			return f1;
		} else
			return null;
	}

	/**
	 * Simulates combat between two fighter characters, where the attacker performs
	 * actions based on user input.
	 *
	 * @param attacker The fighter character initiating the attack.
	 * @param victim   The fighter character being attacked.
	 * @param scanner  The Scanner object for taking user input.
	 */
	private void simulateCombat(FighterCharacter attacker, FighterCharacter victim, Scanner scanner) {
		System.out.println(attacker.getName() + " ist an der Reihe");
		System.out.println("Bitte geben Sie ihren Zug an(1=angreifen, 2=Faehigkeit toggeln)");
		int Input = ConsoleInput(scanner);
		switch (Input) {
		case 1: // angreifen
			int value = attacker.attack();
			victim.gotDamage(value);
			break;
		case 2: // aktivieren
			if (attacker.isSpecialAbilityActive()) {
				attacker.deactivateAbility();
			} else {
				if (!attacker.activateAbility()) {
					simulateCombat(attacker, victim, scanner);
				}
			}
			break;
		default:
			System.err.println("Bitte gültigen Wert eingeben!");
			simulateCombat(attacker, victim, scanner);
			break;

		}

	}

	/**
	 * Reads an integer input from the console using the provided Scanner object.
	 *
	 * @param scanner The Scanner object used for reading input from the console.
	 * @return The integer value entered by the user.
	 */
	private int ConsoleInput(Scanner scanner) {
		int a = scanner.nextInt();
		return a;
	}

	/**
	 * Prints information about the two fighter characters participating in the
	 * fight. This method outputs the details of both fighter characters to the
	 * console.
	 */
	public void printInfo() {
		System.out.println(f1);
		System.out.println(f2);
	}

}
