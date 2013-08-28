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
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.WaveData;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.util.ResourceLoader;

import com.trippylizard.tensixtysix.fighter.Fighter;
import com.trippylizard.tensixtysix.models.*;
import com.trippylizard.tensixtysix.nations.Normans;
import com.trippylizard.tensixtysix.utils.StreamUtils;

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
			closeall();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		System.out.println(glGetString(GL_VERSION));
		
		playMenuMusic();
		
		int trianglelist = glGenLists(1);
		
		glNewList(trianglelist, GL_COMPILE);
			glBegin(GL_TRIANGLES);
				GL11.glColor3f(1.0f, 0f, 0f);
				glVertex2i(100, 100);
				GL11.glColor3f(0f, 1.0f, 0f);
				glVertex2i(WIDTH - 100, 100);
				GL11.glColor3f(0f, 0f, 1.0f);
				glVertex2i(HEIGHT - 100, WIDTH / 2);
			glEnd();
		glEndList();
		
		int testObjectList = glGenLists(1);
		glNewList(testObjectList, GL_COMPILE);
			Model m = null;
			try {
				m = OBJModelLoader.loadModel(StreamUtils.streamToFile(ResourceLoader.getResourceAsStream("res/OpenGL Monkey.obj")));
			} catch (IOException e) {
				e.printStackTrace();
				glDeleteLists(trianglelist, 1);
				alDeleteBuffers(albuffer);
				closeall();
			}
			glBegin(GL_TRIANGLES);
				for (Face f : m.faces) {
					Vector3f n1 = m.normals.get((int) f.normal.x - 1);
					glNormal3f(n1.x, n1.y, n1.z);
					Vector3f v1 = m.vertices.get((int) f.vertex.x - 1);
					glVertex3f(v1.x, v1.y, v1.z);
					Vector3f n2 = m.normals.get((int) f.normal.y - 1);
					glNormal3f(n2.x, n2.y, n2.z);
					Vector3f v2 = m.vertices.get((int) f.vertex.y - 1);
					glVertex3f(v2.x, v2.y, v2.z);
					Vector3f n3 = m.normals.get((int) f.normal.z - 1);
					glNormal3f(n3.x, n3.y, n3.z);
					Vector3f v3 = m.vertices.get((int) f.vertex.z - 1);
					glVertex3f(v3.x, v3.y, v3.z);
				}
			glEnd();
		glEndList();
		
		
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
			
			glCallList(trianglelist);
			
			Display.update();
			Display.sync(120);
		}
		
		glDeleteLists(testObjectList, 1);
		glDeleteLists(trianglelist, 1);
		alDeleteBuffers(albuffer);
		closeall();
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
	
	private void closeall() {
		AL.destroy();
		Display.destroy();
		System.exit(0);
	}

}
