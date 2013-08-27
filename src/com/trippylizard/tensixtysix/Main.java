package com.trippylizard.tensixtysix;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.opengl.GL11.*;

import java.io.BufferedInputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.WaveData;

public class Main {

	int WIDTH = 1280;
	int HEIGHT = 768;
	
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
		
		BufferedInputStream stream = new BufferedInputStream(this.getClass().getResourceAsStream("theme.wav"));
		WaveData data = WaveData.create(stream);
		System.out.println(data == null);
		int buffer = alGenBuffers();
		alBufferData(buffer, data.format, data.data, data.samplerate);
		data.dispose();
		int source = alGenSources();
		
		alSourcef(source, AL_BUFFER, buffer);
		
		alSourcePlay(source);
		
		while (!Display.isCloseRequested()) {
			//Render Code
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			glBegin(GL_TRIANGLES);
				glVertex2i(100, 100);
				glVertex2i(WIDTH - 100, 100);
				glVertex2i(HEIGHT - 100, WIDTH / 2);
			glEnd();
			
			Display.update();
			Display.sync(120);
		}
		
		alDeleteBuffers(buffer);
		AL.destroy();
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
