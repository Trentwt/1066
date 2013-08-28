package com.trippylizard.tensixtysix.nations;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Vikings extends Nation {

	private static String desc_vikings = "insert viking poetry here :D";
	private static Texture flag;
	
	public static Vikings construct() {
		try {
			flag = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Flag_of_Vikings.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
			Display.destroy();
			AL.destroy();
			System.exit(1);
		}
		return new Vikings();
	}
	
	public Vikings() {
		super("Vikings", desc_vikings, Color.GREEN, flag);
	}

}
