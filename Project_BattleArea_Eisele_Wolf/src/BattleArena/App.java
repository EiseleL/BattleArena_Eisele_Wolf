package BattleArena;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int wahl = 0;
		String name = "";
		
		FighterCharacter p1 = null;
		FighterCharacter p2 = null;
		
		for(int i = 1; i < 3; i++) {
			System.out.println("Spieler " + i +": Wähle deinen Spielcharakter");
			System.out.println();
			System.out.println("1. Dragon");
			System.out.println("2. Dwarf");
			System.out.println();
			boolean fw = true;
			
			do {
				 wahl = scanner.nextInt();
				if(wahl == 1|| wahl == 2  ){
					fw =false;
				}} while(fw);
			
			System.out.println("Spieler " + i +": Gib deinen Spielnamen an:");
			
			
			do {
				 name = scanner.next();
				
				} while(name.equals(""));
			
				if(p1 != null) {
					wahl += 10;
				}
				switch (wahl) {
				case 1: 
					p1 = new Dragon(name);
					break;
					
				case 2:
					 p1 = new Dwarf(name);
					break;
					
				case 11: 
					p2 = new Dragon(name);
					break;
					
				case 12:
					p2 = new Dwarf(name);
					break;
				}
		}
		
		Arena Arena = new Arena(p1, p2);
		
		Arena.fight(scanner);
		
		scanner.close();
		
		
		
	}
}
