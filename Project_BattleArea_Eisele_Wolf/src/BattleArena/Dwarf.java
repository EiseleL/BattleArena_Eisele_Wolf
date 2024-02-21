package BattleArena;

import java.util.concurrent.ThreadLocalRandom;

public class Dwarf extends FighterCharacter{

	public Dwarf(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activateAbility() {
		if(this.getHealth() < 50) {
			this.setSpecialAbilityActive(true);
		}
		
		
	}

	@Override
	public void deactivateAbility() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int attack() {
		int attacNumber = ThreadLocalRandom.current().nextInt(20,25);
		if(this.isSpecialAbilityActive()) {
			double random = Math.random();
			if(this.getHealth() <= 10) {
				if(random <= 0.7) {
					return attacNumber*2;
				}	
			}else if(this.getHealth() <= 20) {
				if(random <= 0.5) {
					return attacNumber*2;
				}	
			}else if(this.getHealth() <= 50) {
				if(random <= 0.3) {
					return attacNumber*2;
				}	
			}else{
				return attacNumber/2;
			}
		}
		return attacNumber;
	}
	
	
	
	
	
	

}
