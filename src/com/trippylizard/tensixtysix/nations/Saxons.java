package com.trippylizard.tensixtysix.nations;

import java.io.IOException;

import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.trippylizard.tensixtysix.utils.Color;

/**
 * 
 * Represents the Saxons Nation.
 * 
 * @author Trent
 *
 */

public class Saxons extends Nation {

	private static String desc_saxons = "insert saxon poetry here :D";
	private static Texture flag;
	
	public static Saxons construct() {
		try {
			flag = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Flag_of_England.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
			Display.destroy();
			AL.destroy();
			System.exit(1);
		}
		return new Saxons();
	}
	
	public Saxons() {
		super("Saxons", desc_saxons, new Color(220, 20, 60), flag);
	}

}
