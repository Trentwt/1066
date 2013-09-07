package com.trippylizard.tensixtysix.fighter;

import com.trippylizard.tensixtysix.nations.Nation;
import static com.trippylizard.tensixtysix.fighter.FighterClass.*;

/**
 * 
 * Represents a general fighters used as a superclass for the subclasses HumanFighter and AIFighter.
 * This class is not actually initialized in the final release except in subclasses.
 * 
 * @author Trent
 *
 */

public class Fighter {
	
	Nation nation;
	int id;
	FighterClass fclass;
	int level;
	
	double health = 20;
	
	boolean isCreated = false;
	
	private int x;
	private int z;
	
	public Fighter(Nation nation, int id, FighterClass fclass, int level) {
		this.nation = nation;
		this.id = id;
		this.fclass = fclass;
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getID() {
		return id;
	}
	
	public String getFighterClass() {
		return ((fclass == FighterClass.WARRIOR) ? "Warrior" : "General");
	}
	
	public String getNation() {
		return ((nation == Nation.NORMANS) ? "Norman" : (nation == Nation.SAXONS) ? "Saxon" : "Viking");
	}
	
	public Weapon getWeapon() {
		return Weapon.SWORD;
	}
	
	public int getX() {
		return x;
	}
	
	public int getZ() {
		return z;
	}
	
	public boolean isCreated() {
		return isCreated;
	}
	
	public void updateposition(int ix, int iz) {
		this.x += ix;
		this.z += iz;
	}
	
	public void build(int x, int z) {
		this.x = x;
		this.z = z;
		
		if (nation.equals(Nation.NORMANS)) {
			buildnorman(x, z);
		} else if (nation.equals(Nation.SAXONS)) {
			buildsaxon(x, z);
		} else if (nation.equals(Nation.VIKINGS)) {
			buildviking(x, z);
		}
		
		isCreated = true;
	}
	
	private void buildnorman(int x, int z) {
		if (fclass == WARRIOR) {
			//Build code here
		} else if (fclass == GENERAL) {
			//Build code here
		}
	}
	
	private void buildsaxon(int x, int y) {
		if (fclass == WARRIOR) {
			//Build code here
		} else if (fclass == GENERAL) {
			//Build code here
		}
	}

	private void buildviking(int x, int y) {
		if (fclass == WARRIOR) {
			//Build code here
		} else if (fclass == GENERAL) {
			//Build code here
		}
	}
	
	public void setHealth(double health) {
		this.health = health;
	}
	
	public double getHealth() {
		return health;
	}
}
