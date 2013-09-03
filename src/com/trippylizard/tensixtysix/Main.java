package com.trippylizard.tensixtysix;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.opengl.GL11.*;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.*;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.WaveData;
import org.newdawn.slick.util.ResourceLoader;

import com.trippylizard.tensixtysix.fighter.*;
import com.trippylizard.tensixtysix.utils.models.*;
import com.trippylizard.tensixtysix.nations.*;
import com.trippylizard.tensixtysix.utils.StreamUtils;

public class Main {

	private static int WIDTH = 1280;
	private static int HEIGHT = 768;
	private static int albuffer;
	private static int menuthemesource;
	private static int fightercount = 0;
	private static int customnationsize = 6;
	
	private static boolean musicon = true;
	
	private static final List<Fighter> fighters = new ArrayList<Fighter>();
	
	private static final String MAPPATH_DEFAULT = "res/terrain.obj";
	private static final String MAPPATH_CAR = "res/car.obj";
	private static final String MAPPATH_MONKEY = "res/OpenGL Monkey.obj";
	
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(Main.class.getName());
	
	Timer timer = new Timer();
	
	Map map;
	
	public Main() throws InterruptedException, IOException {
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
		
		try {
			switchMap(MAPPATH_DEFAULT);
		} catch (IOException ex) {
			ex.printStackTrace();
			closeall();
		}
		
		playMenuMusic();
		
		int trianglelist = glGenLists(1);
		
		spawnfighters();
		
		glNewList(trianglelist, GL_COMPILE);
			glBegin(GL_TRIANGLES);
				glColor3f(1.0f, 0f, 0f);
				glVertex2i(100, 100);
				glColor3f(0f, 1.0f, 0f);
				glVertex2i(WIDTH - 100, 100);
				glColor3f(0f, 0f, 1.0f);
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
				OBJModelLoader.renderModel(m);
			glEnd();
		glEndList();
		
		Normans.construct();
		Saxons.construct();
		Vikings.construct();
		
		timer.scheduleAtFixedRate(new ScheduledFighterMove(fighters, map), 5000, 5000);
		
		while (!Display.isCloseRequested()) {
			//Render Code
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
				alDeleteBuffers(albuffer);
				closeall();
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
				} else if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
					timer.cancel();
					timer = new Timer();
					fighters.clear();
					fightercount = 0;
					switchMap(MAPPATH_DEFAULT);
					spawnfighters();
					timer.scheduleAtFixedRate(new ScheduledFighterMove(fighters, map), 5000, 5000);
				} else if (Keyboard.isKeyDown(Keyboard.KEY_2)) {
					timer.cancel();
					timer = new Timer();
					fighters.clear();
					fightercount = 0;
					switchMap(MAPPATH_CAR);
					spawnfighters();
					timer.scheduleAtFixedRate(new ScheduledFighterMove(fighters, map), 5000, 5000);
				} else if (Keyboard.isKeyDown(Keyboard.KEY_3)) {
					timer.cancel();
					timer = new Timer();
					fighters.clear();
					fightercount = 0;
					switchMap(MAPPATH_MONKEY);
					spawnfighters();
					timer.scheduleAtFixedRate(new ScheduledFighterMove(fighters, map), 5000, 5000);
				}
			}
			
			for (final Fighter f : fighters) {
				if (!f.isCreated()) {
					f.build(random((int) Math.floor(map.getMapLength()), 0), random((int) Math.floor(map.getMapWidth()), 0));
					System.out.println(f.getNation() + " " + f.getFighterClass() + " has spawned at " + f.getX() + "," + f.getZ() + " with the id " + f.getID() + ".");
				}
			}
			
			glCallList(trianglelist);
			
			Display.update();
			Display.sync(60);
		}
		
		glDeleteLists(testObjectList, 1);
		glDeleteLists(trianglelist, 1);
		alDeleteBuffers(albuffer);
		closeall();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
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
	
	private static void closeall() {
		AL.destroy();
		Display.destroy();
		System.exit(0);
	}
	
	public static int random(int max, int min) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
	private void switchMap(String path) throws IOException {
		System.out.println();
		System.out.println("Reading map file, this may take a while...");
		System.out.println("WARNING: CPU usage spike will occur!");
		long time = System.nanoTime();
		map = new Map(OBJModelLoader.loadModel(StreamUtils.streamToFile(ResourceLoader.getResourceAsStream(path))));
		time = System.nanoTime() - time;
		System.out.println("Map Loaded: '" + path + "'! (" + time / 1000000 + " ms)");
		System.out.println("Rounded Map Size: X=" + Math.rint(map.getMapWidth()) + " Y=" + Math.rint(map.getMapHeight()) + " Z=" + Math.rint(map.getMapLength()));
		System.out.println();
	}
	
	private void spawnfighters() {
		for(int i = 0; i < customnationsize; i++) {
			fighters.add(new Fighter(Nation.NORMANS, (fightercount++) + 1, FighterClass.WARRIOR, 1));
			fighters.add(new Fighter(Nation.SAXONS, (fightercount++) + 1, FighterClass.WARRIOR, 1));
			fighters.add(new Fighter(Nation.VIKINGS, (fightercount++) + 1, FighterClass.WARRIOR, 1));
		}
	}
}
