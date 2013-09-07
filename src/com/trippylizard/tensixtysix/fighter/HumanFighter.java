package com.trippylizard.tensixtysix.fighter;

import com.trippylizard.tensixtysix.nations.Nation;

/**
 * 
 * Represents a fighter controlled by an actual user/client, and is not AI Controlled.
 * 
 * @author Trent
 *
 */

public class HumanFighter extends Fighter{

	public HumanFighter(Nation nation, int id, FighterClass fclass, int level) {
		super(nation, id, fclass, level);
	}
}
