package com.trippylizard.tensixtysix;

import java.util.List;
import java.util.TimerTask;

import com.trippylizard.tensixtysix.fighter.Fighter;

/**
 * Represents the TimerTask responsible for timing the fighter move events.
 * 
 * @author Trent
 *
 */

public class ScheduledFighterMove extends TimerTask {

	List<Fighter> fighters;
	Map map;
	
	public ScheduledFighterMove(List<Fighter> fighters, Map map) {
		this.fighters = fighters;
		this.map = map;
	}
	
	@Override
	public void run() {
		for (final Fighter f : fighters) {
			if (f.isCreated()) {
				boolean successful = false;
				while (!successful) {
					int rand = Main.random(4, 1);
					if (rand == 1) {
						if (!(Math.floor(f.getX()) + 1 > map.getMapLength())) {
							int pastx = f.getX();
							int pastz = f.getZ();
					
							f.updateposition(1, 0);
							System.out.println(f.getNation() + " " + f.getFighterClass() + " has moved from " + pastx + "," + pastz + " to " + f.getX() + "," + f.getZ() + " with the id " + f.getID() + ".");
							successful = true;
							break;
						}
					} else if (rand == 2) {
						if (!(Math.floor(f.getX()) - 1 < 0)) {
							int pastx = f.getX();
							int pastz = f.getZ();
							
							f.updateposition(-1, 0);
							System.out.println(f.getNation() + " " + f.getFighterClass() + " has moved from " + pastx + "," + pastz + " to " + f.getX() + "," + f.getZ() + " with the id " + f.getID() + ".");
							successful = true;
							break;
						}
					} else if (rand == 3) {
						if (!(Math.floor(f.getZ()) + 1 > map.getMapWidth())) {
							int pastx = f.getX();
							int pastz = f.getZ();
					
							f.updateposition(0, 1);
							System.out.println(f.getNation() + " " + f.getFighterClass() + " has moved from " + pastx + "," + pastz + " to " + f.getX() + "," + f.getZ() + " with the id " + f.getID() + ".");
							successful = true;
							break;
						}
					} else if (rand == 4) {
						if (!(Math.floor(f.getZ()) - 1 < 0)) {
							int pastx = f.getX();
							int pastz = f.getZ();
					
							f.updateposition(0, -1);
							System.out.println(f.getNation() + " " + f.getFighterClass() + " has moved from " + pastx + "," + pastz + " to " + f.getX() + "," + f.getZ() + " with the id " + f.getID() + ".");
							successful = true;
							break;
						}
					}
					successful = false;
				}
			}
		}
	}

}
