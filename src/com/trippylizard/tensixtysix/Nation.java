package com.trippylizard.tensixtysix;

import java.awt.Color;

import org.newdawn.slick.opengl.Texture;

import com.trippylizard.tensixtysix.nations.Normans;

public class Nation {
	
	public static Nation NORMANS = Normans.construct();
	//public static Nation ENGLISH;
	//public static Nation VIKINGS;
	
	String name;
	String description;
	Color color;
	Texture flag;
	
	public Nation(String name, String description, Color color, Texture flag) {
		//ENGLISH = new English();
		//VIKINGS = new Vikings();
		
		this.name = name;
		this.description = description;
		this.color = color;
		this.flag = flag;
	}
	
}
