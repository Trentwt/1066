package com.trippylizard.tensixtysix.nations;

import org.newdawn.slick.opengl.Texture;

import com.trippylizard.tensixtysix.utils.Color;

/**
 * 
 * Represents the superclass that is used to define the different Nations (Normans, Saxons and Vikings).
 * These different Nations are used to identify the nationalities of the fighters, and also are used to add the model of how the fighter is rendered based on the nation.
 * 
 * @author Trent
 *
 */

public class Nation {
	
	public static Nation NORMANS = Normans.construct();
	public static Nation SAXONS = Saxons.construct();
	public static Nation VIKINGS = Vikings.construct();
	
	String name;
	String description;
	Color color;
	Texture flag;
	
	public Nation(String name, String description, Color color, Texture flag) {
		this.name = name;
		this.description = description;
		this.color = color;
		this.flag = flag;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Color getColor() {
		return color;
	}
}
