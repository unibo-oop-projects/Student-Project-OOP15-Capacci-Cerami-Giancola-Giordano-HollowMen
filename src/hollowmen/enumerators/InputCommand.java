package hollowmen.enumerators;

import hollowmen.model.Actor;

/**
 * Contains the list of possible command from the player
 * 
 * @author Giordo
 *
 */
public enum InputCommand {
	
	ABILITY1(Actor.Action.ABILITY1.toString()),
	ABILITY2(Actor.Action.ABILITY2.toString()),
	ABILITY3(Actor.Action.ABILITY3.toString()),
	ATTACK(Actor.Action.ATTACK.toString()),
	JUMP(Actor.Action.JUMP.toString()),
	LEFT(Actor.Direction.LEFT.toString()),
	RIGHT(Actor.Direction.RIGHT.toString()),
	BACK("back"),
	CONSUMABLE("consumable"),
	EQUIP("equip"),
	INTERACT("interact"),
	TRADE("trade");
	
	private String s;
	
	private InputCommand(String s){
		this.s=s;
	}
	
	/**
	 * @return String that represent the command
	 */
	public String getString(){
		return this.s;
	}
}
