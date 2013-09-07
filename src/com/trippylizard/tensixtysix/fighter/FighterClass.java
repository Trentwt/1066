package com.trippylizard.tensixtysix.fighter;

/**
 * 
 * Represents the class of which a fighter is assigned to. (e.g. Warrior, General)
 * 
 * @author Trent
 *
 */

public class FighterClass {
	
	public static FighterClass WARRIOR = new FighterClass(Weapon.SWORD);
	public static FighterClass GENERAL = new FighterClass(Weapon.SWORD);
	
	public Weapon weapon;
	
	public FighterClass(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
}
