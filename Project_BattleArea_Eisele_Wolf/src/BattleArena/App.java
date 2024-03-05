package BattleArena;

public class App {

	public static void main(String[] args) {
		
		
		System.out.println("Spieler 1: Wähle deinen Spielcharakter");
		System.out.println();
		System.out.println("1. Dragon");
		System.out.println("2. Dwarf");
		System.out.println();
		
		
		
		Dragon d1 = new Dragon("Honig Zahn");
		Dwarf z1 = new Dwarf("Erwin");
		
		Arena Arena = new Arena(d1, z1);
		
		Arena.fight();
		
		
	}
}
