package BattleArena;

import java.util.concurrent.ThreadLocalRandom;

public class Dragon extends FighterCharacter {

	public Dragon(String name, int health, boolean specialAbilityActive) {
		super(name);
		
	}

	@Override
	public int attack() {
		int attacNumber = ThreadLocalRandom.current().nextInt(20,25);
		if(this.isSpecialAbilityActive()) {
			return attacNumber -= ThreadLocalRandom.current().nextInt(5,10);
		}else {
			return attacNumber;
		}
	}
	
	
	public void activateAbility() {
		this.setSpecialAbilityActive(true);
		this.setBonushealth(getBonushealth()+10);
	}
	
	public void deactivateAbility() {
		this.setSpecialAbilityActive(false);
		if(!((this.getBonushealth() - 10) >= 0)) {
			this.setBonushealth(getBonushealth()-10);
		}else {
			this.setBonushealth(0);
		}
	}

}



//TODO
	//Können schaden nehemn beim Angriff