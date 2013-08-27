package com.trippylizard.tensixtysix;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;

public class Main {

	int WIDTH = 1280;
	int HEIGHT = 768;
	
	public Main() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("1066 - Alpha Version 0.0.1");
			Display.create();
		} catch (LWJGLException ex) {
			ex.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
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
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
