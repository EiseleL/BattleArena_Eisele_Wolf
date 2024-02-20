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
	
	public void gotDamage(int points) {
		if(this.bonushealth < 0) {
			if(!((this.bonushealth - points) >= 0)) {
				points -= this.bonushealth;
				this.bonushealth = 0;
				
				if(!((this.health - points) < 0)) {
					this.health -= points;
				}else{
					this.health = 0;
				}
			}
		}
		
		
	}
	
	public abstract void activateAbility();
	
	public abstract void deactivateAbility();
	
	public abstract int attack();
	
	
	
	
	
	

}
