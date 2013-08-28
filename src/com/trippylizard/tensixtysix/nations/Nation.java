package com.trippylizard.tensixtysix.nations;

import java.awt.Color;

import org.newdawn.slick.opengl.Texture;

public class Nation {
	
	public static Nation NORMANS = Normans.construct();
	public static Nation SAXONS = new Saxons();
	public static Nation VIKINGS = new Vikings();
	
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
	
}
