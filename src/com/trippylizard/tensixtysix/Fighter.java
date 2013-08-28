package com.trippylizard.tensixtysix;

import com.trippylizard.tensixtysix.Nation;

public class Fighter {
	
	Nation nation;
	int id;
	FightingClass fclass;
	int level;
	
	public Fighter(Nation nation, int id, FightingClass fclass, int level) {
		this.setNation(nation);
		this.setId(id);
		this.fclass = fclass;
		this.level = level;
	}
	
	public FightingClass getFclass() {
		return fclass;
	}

	public void setFightningClass(FightingClass fclass) {
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
	
	public enum FightingClass {
		WARRIOR, ARCHER;
	}
}
