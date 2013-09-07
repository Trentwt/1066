package com.trippylizard.tensixtysix.utils;

/**
 * 
 * Represents a color with red, green and blue attributes. Used when showing the colour of a nation in-game.
 * 
 * @author Trent
 *
 */

public class Color {
	
	int red;
	int green;
	int blue;
	
	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public int getRed() {
		return red;
	}
	
	public int getGreen() {
		return green;
	}
	
	public int getBlue() {
		return blue;
	}
}
