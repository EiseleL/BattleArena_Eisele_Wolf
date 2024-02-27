package BattleArena;

import java.util.Scanner;

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
		randomFighter();
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

	private boolean randomFighter() {
		double random = Math.random();
		if (random > 0.4) {
			return false;
		} else
			return true; 
	}

	public void fight() {
		Scanner scanner = new Scanner(System.in);
		FighterCharacter attacker;
		FighterCharacter victim;
		do {
			if (this.SelectedFighter) {
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
	}

	private FighterCharacter checkWinner() {
		if (f1.getHealth() <= 0) {
			return f2;
		} else if (f2.getHealth() <= 0) {
			return f1;
		} else
			return null;
	}

	private void simulateCombat(FighterCharacter attacker, FighterCharacter victim, Scanner scanner) {
		System.out.println(attacker.getName() + " ist an der Reihe");
		System.out.println("Bitte geben Sie ihren Zug an(1=angreifen, 2=Faehigkeit toggeln)");
		int Input = ConsoleInput(scanner);
		switch (Input) {
		case 1: //angreifen
			int value = attacker.attack();
			victim.gotDamage(value);
			break;
		case 2: // aktivieren
			if(attacker.isSpecialAbilityActive()) {
				attacker.setSpecialAbilityActive(false);
			}
			else {
				attacker.setSpecialAbilityActive(true);
			}
			break;
		default:
			System.err.println("Bitte gültigen Wert eingeben!");
			simulateCombat(attacker, victim, scanner);
			break;
			
		}
		
	}

	private int ConsoleInput(Scanner scanner) {
		int a = scanner.nextInt();
		return a;
	}

	public void printInfo() {
		System.out.println(f1);
		System.out.println(f2);
	}

}
