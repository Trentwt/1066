package com.trippylizard.tensixtysix.fighter;

import com.trippylizard.tensixtysix.nations.Nation;

public class Fighter {
	
	Nation nation;
	int id;
	FighterClass fclass;
	int level;
	
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
		return ((fclass == FighterClass.WARRIOR) ? "Warrior" : "Archer");
	}
	
	public String getNation() {
		return ((nation == Nation.NORMANS) ? "Norman" : (nation == Nation.SAXONS) ? "Saxon" : "Viking");
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
	
	public enum FighterClass {
		WARRIOR, ARCHER;
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
		switch (fclass) {
			case WARRIOR: {
				//Build code here
			}
			case ARCHER: {
				//Build code here
			}
		}
	}
	
	private void buildsaxon(int x, int y) {
		switch (fclass) {
			case WARRIOR: {
				//Build code here
			}
			case ARCHER: {
				//Build code here
			}
		}
	}

	private void buildviking(int x, int y) {
		switch (fclass) {
			case WARRIOR: {
				//Build code here
			}
			case ARCHER: {
				//Build code here
			}
		}
	}
}
