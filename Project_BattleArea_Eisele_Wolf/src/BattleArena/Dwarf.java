package BattleArena;

import java.util.concurrent.ThreadLocalRandom;

public class Dwarf extends BattleArena.FighterCharacter{

	public Dwarf(String name) {
		super(name);
	}
	
	public String getClassName() {
		return "Dwarf";
	}

	/**
	 * Method activate Ability if health < 50 
	 */
	public boolean activateAbility() {
		if(this.getHealth() < 50) {
			this.setSpecialAbilityActive(true);
			return true;
		}else{
			System.err.println("Ein Zwerg kann erst ab 50 Lebenspunkte, seine Spezialfähigkeiten einsetzen");
			return false;
		}
		
		
	}

	/**
	 * Method deactivate Ability
	 */
	public boolean deactivateAbility() {
		this.setSpecialAbilityActive(false);
		return true;
	}

	/**
	 * Method calculate attackNumber random between 20 - 25, If the health is below a limit, the probability of a double attack value is increased when the special effect is activated. 
	 */
	public int attack() {
		int attackNumber = ThreadLocalRandom.current().nextInt(20,25);
		if(this.isSpecialAbilityActive()) {
			double random = Math.random();
			if(this.getHealth() <= 10) {
				if(random <= 0.7) {
					return attackNumber*2;
				}	
			}else if(this.getHealth() <= 20) {
				if(random <= 0.5) {
					return attackNumber*2;
				}	
			}else if(this.getHealth() <= 50) {
				if(random <= 0.3) {
					return attackNumber*2;
				}	
			}else{
				return attackNumber/2;
			}
		}
		return attackNumber;
	}

}
