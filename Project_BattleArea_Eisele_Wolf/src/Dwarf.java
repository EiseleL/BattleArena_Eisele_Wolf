package Project_BattleArea_Eisele_Wolf.src;

import java.util.concurrent.ThreadLocalRandom;

import BattleArena.FighterCharacter;

public class Dwarf extends FighterCharacter{

	public Dwarf(String name) {
		super(name);
	}

	/**
	 * Method activate Ability if health < 50 
	 */
	public void activateAbility() {
		if(this.getHealth() < 50) {
			this.setSpecialAbilityActive(true);
		}
		
		
	}

	/**
	 * Method deactivate Ability
	 */
	public void deactivateAbility() {
		this.setSpecialAbilityActive(false);
		
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
/*
	public String toString() {
		return this.toString();
	}
*/
}
