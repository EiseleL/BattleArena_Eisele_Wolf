package BattleArena;

public abstract class FighterCharacter {

	private String name;
	private int health;
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

	public boolean isSpecialAbilityActive() {
		return specialAbilityActive;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setSpecialAbilityActive(boolean specialAbilityActive) {
		this.specialAbilityActive = specialAbilityActive;
	}
	
	public void gotDamage(int points) {
		if(!((this.health - points) < 0)) {
			this.health -= points;
		}
	}
	
	public void activateAbility() {
		this.setSpecialAbilityActive(true);
	}
	
	public void deactivateAbility() {
		this.setSpecialAbilityActive(false);
	}
	
	
	public abstract void attack();
	
	
	
	
	

}
