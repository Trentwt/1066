package com.trippylizard.tensixtysix.nations;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.trippylizard.tensixtysix.Nation;

public class Normans extends Nation {

	private static String desc_normans = "insert norman poetry here :D";
	private static Texture flag;
	
	public static Normans construct() {
		try {
			flag = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Flag_of_France.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
			Display.destroy();
			AL.destroy();
			System.exit(1);
		}
		return new Normans();
	}
	
	public Normans() {
		super("Normans", desc_normans, Color.BLUE, flag);
	}

}
