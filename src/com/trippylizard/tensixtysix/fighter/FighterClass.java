package com.trippylizard.tensixtysix.fighter;

public class FighterClass {
	
	public static FighterClass WARRIOR = new FighterClass(Weapon.SWORD);
	public static FighterClass GENERAL = new FighterClass(Weapon.SWORD);
	
	public Weapon weapon;
	
	public FighterClass(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
}
