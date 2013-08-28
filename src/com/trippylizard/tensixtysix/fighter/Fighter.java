package com.trippylizard.tensixtysix.fighter;

import com.trippylizard.tensixtysix.Nation;

public class Fighter {
	
	Nation nation;
	int id;
	FightingClass fclass;
	int level;
	
	private int x;
	private int y;
	
	public Fighter(Nation nation, int id, FightingClass fclass, int level) {
		this.setNation(nation);
		this.setId(id);
		this.fclass = fclass;
		this.level = level;
	}
	
	public FightingClass getFightingClass() {
		return fclass;
	}

	public void setFightingClass(FightingClass fclass) {
		this.fclass = fclass;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		//build code here
	}
	
	private void buildsaxon(int x, int y) {
		//build code here
	}

	private void buildviking(int x, int y) {
		//build code here
	}
}
