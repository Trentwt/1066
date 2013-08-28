package com.trippylizard.tensixtysix.fighter;

import com.trippylizard.tensixtysix.nations.Nation;

public class Fighter {
	
	Nation nation;
	int id;
	FightingClass fclass;
	int level;
	
	@SuppressWarnings("unused")
	private int x;
	@SuppressWarnings("unused")
	private int y;
	
	public Fighter(Nation nation, int id, FightingClass fclass, int level) {
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
	
	public void updatepos(int ix, int iy) {
		this.x += ix;
		this.y += iy;
	}
	
	public enum FightingClass {
		WARRIOR, ARCHER;
	}
	
	public void build(int x, int y) {
		if (nation.equals(Nation.NORMANS)) {
			buildnorman(x, y);
		} else if (nation.equals(Nation.SAXONS)) {
			buildsaxon(x, y);
		} else if (nation.equals(Nation.VIKINGS)) {
			buildviking(x, y);
		}
	}
	
	private void buildnorman(int x, int y) {
		switch (fclass) {
			case WARRIOR:
				
			case ARCHER:
				
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
