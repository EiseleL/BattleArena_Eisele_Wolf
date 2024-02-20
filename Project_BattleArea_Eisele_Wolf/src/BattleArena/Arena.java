package BattleArena;

public class Arena {
	private FighterCharacter f1;
	private FighterCharacter f2;
	private FighterCharacter Winner;
	

	public Arena(FighterCharacter f1, FighterCharacter f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		Winner = null;
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

	public void setWinner(FighterCharacter winner) {
		Winner = winner;
	}

	
	public void fight() {
		do {
			
		}
		while(Winner == null);
	}
	
	public void printInfos() {
		System.out.println("Infos Fighter1: " + f1 + "\n");
		System.out.println("Infos Fighter2: " + f2);
	}
	
	
	
}
