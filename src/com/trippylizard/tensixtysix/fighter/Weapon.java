package com.trippylizard.tensixtysix.fighter;

/**
 * 
 * Represents the weapon used by a fighter assigned to a specific FighterClass.
 * Weapons have specific properties assigned such as attack damage.
 * 
 * @author Trent
 *
 */

public class Weapon {
	public static Weapon SWORD = new Weapon(3.0);
	
	double damage;
	
	public Weapon(double damage) {
		this.damage = damage;
	}
}