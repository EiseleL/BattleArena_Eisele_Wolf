package BattleArena;

public abstract class FighterCharacter {

	private String name;
	private int health;
	private int bonushealth;
	private boolean specialAbilityActive;

	public FighterCharacter(String name) {
		super();
		this.name = name;
		this.health = 100;
		this.specialAbilityActive = false;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}
	

	public int getBonushealth() {
		return bonushealth;
	}

	public boolean isSpecialAbilityActive() {
		return specialAbilityActive;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	

	public void setBonushealth(int bonushealth) {
		this.bonushealth = bonushealth;
	}

	public void setSpecialAbilityActive(boolean specialAbilityActive) {
		this.specialAbilityActive = specialAbilityActive;
	}
	
	/**
	 * Method deducts life from the FighterCharacter depending on how many lives he has.
	 * If more lives are to be deducted than are available, the life counter is set to 0.
	 * If bonus lives (bonushealth) are available, these will be deducted beforehand.
	 * @param points
	 */
	public void gotDamage(int points) {
		
		if(this.bonushealth > 0) {
			if(!((this.bonushealth - points) <= 0)) {
				this.bonushealth -= points;
				points = 0;
			}else {
				points -= this.bonushealth;
				this.bonushealth = 0;
			}
		}
		if(!((this.health - points) < 0)) {
			this.health -= points;
			}else{
				this.health = 0;
			}
	}
	
	public String toString() {
		return "FighterCharacter: "+ this.getClassName() + ": " + name + "\n"+
				"Leben + Bonus Leben: " + (health + bonushealth) + "\n"+
				"Spezialfertigkeit: " + specialAbilityActive + "\n";
	}
	
	public abstract String getClassName(); 

	public abstract void activateAbility();
	
	public abstract void deactivateAbility();
	
	public abstract int attack();
	
}
