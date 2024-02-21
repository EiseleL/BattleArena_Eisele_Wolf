package BattleArena;

import java.util.concurrent.ThreadLocalRandom;

public class Dwarf extends FighterCharacter{

	public Dwarf(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	
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

	@Override
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
