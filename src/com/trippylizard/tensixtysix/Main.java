package com.trippylizard.tensixtysix;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.opengl.GL11.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.WaveData;
import org.newdawn.slick.util.ResourceLoader;

import com.trippylizard.tensixtysix.fighter.Fighter;
import com.trippylizard.tensixtysix.fighter.Fighter.FightingClass;
import com.trippylizard.tensixtysix.fighter.HumanFighter;
import com.trippylizard.tensixtysix.nations.Normans;

public class Main {

	int WIDTH = 1280;
	int HEIGHT = 768;
	
	int albuffer;
	int menuthemesource;
	
	boolean musicon = true;
	
	private static final List<Fighter> fighters = new ArrayList<Fighter>();
	
	public Main() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("1066 - Alpha Version 0.0.1");
			Display.create();
			AL.create();
		} catch (LWJGLException ex) {
			ex.printStackTrace();
			Display.destroy();
			AL.destroy();
			System.exit(1);
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		System.out.println(glGetString(GL_VERSION));
		
		playMenuMusic();
		
		Normans.construct();
		
		while (!Display.isCloseRequested()) {
			//Render Code
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
				alDeleteBuffers(albuffer);
				AL.destroy();
				Display.destroy();
				System.exit(0);
			}
			
			while (Keyboard.next()) {
				if (Keyboard.isKeyDown(Keyboard.KEY_F10)) {
					if (Keyboard.getEventKeyState()) {
						if (musicon) {
							alSourcePause(menuthemesource);
							musicon = false;
						} else {
							AL10.alSourcePlay(menuthemesource);
							musicon = true;
						}
					}
				}
			}
			
			for (final Fighter f : fighters) {
				Random gen = new Random();
				f.build(gen.nextInt(), gen.nextInt());
			}
			
			glBegin(GL_TRIANGLES);
				glVertex2i(100, 100);
				glVertex2i(WIDTH - 100, 100);
				glVertex2i(HEIGHT - 100, WIDTH / 2);
			glEnd();
			
			Display.update();
			Display.sync(120);
		}
		
		alDeleteBuffers(albuffer);
		AL.destroy();
		Display.destroy();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	private void playMenuMusic() {
		BufferedInputStream stream = new BufferedInputStream(ResourceLoader.getResourceAsStream("res/theme.wav"));
		WaveData data = WaveData.create(stream);
		albuffer = alGenBuffers();
		alBufferData(albuffer, data.format, data.data, data.samplerate);
		data.dispose();
		menuthemesource = alGenSources();
		
		alSourcef(menuthemesource, AL_BUFFER, albuffer);
		
		alSourcePlay(menuthemesource);
	}

}
