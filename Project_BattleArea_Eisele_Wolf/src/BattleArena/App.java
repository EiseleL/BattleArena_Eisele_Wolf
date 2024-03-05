package BattleArena;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Dragon d1 = new Dragon("Honig Zahn");
		Dwarf z1 = new Dwarf("Erwin");
		
		Arena Arena = new Arena(d1, z1);
		
		Arena.fight(scanner);
		
		scanner.close();
	}
}
