package com.trippylizard.tensixtysix.fighter;

import com.trippylizard.tensixtysix.nations.Nation;

public class Fighter {
	
	Nation nation;
	int id;
	FighterClass fclass;
	int level;
	
	boolean isCreated = false;
	
	private int x;
	private int y;
	
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
	
	public int getY() {
		return y;
	}
	
	public boolean isCreated() {
		return isCreated;
	}
	
	public void updateposition(int ix, int iy) {
		this.x += ix;
		this.y += iy;
	}
	
	public enum FighterClass {
		WARRIOR, ARCHER;
	}
	
	public void build(int x, int y) {
		this.x = x;
		this.y = y;
		
		if (nation.equals(Nation.NORMANS)) {
			buildnorman(x, y);
		} else if (nation.equals(Nation.SAXONS)) {
			buildsaxon(x, y);
		} else if (nation.equals(Nation.VIKINGS)) {
			buildviking(x, y);
		}
		
		isCreated = true;
	}
	
	private void buildnorman(int x, int y) {
		switch (fclass) {
			case WARRIOR: {
				
			}
			case ARCHER: {
				
			}
		}
	}
	
	private void buildsaxon(int x, int y) {
		switch (fclass) {
			case WARRIOR: {
				
			}
			case ARCHER: {
				
			}
		}
	}

	private void buildviking(int x, int y) {
		switch (fclass) {
			case WARRIOR: {
				
			}
			case ARCHER: {
				
			}
		}
	}
}
