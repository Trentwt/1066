package com.trippylizard.tensixtysix.fighter;

public class Weapon {
	public static Weapon SWORD = new Weapon(3.0);
	
	double damage;
	
	public Weapon(double damage) {
		this.damage = damage;
	}
}