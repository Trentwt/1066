package com.trippylizard.tensixtysix.utils.models;

import static org.lwjgl.opengl.GL11.glNormal3f;
import static org.lwjgl.opengl.GL11.glVertex3f;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

public class OBJModelLoader {
	public static Model loadModel(File f) throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new FileReader(f));
		Model m = new Model();
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.startsWith("v ")) {
				float x = Float.valueOf(line.split(" ")[1]);
				float y = Float.valueOf(line.split(" ")[2]);
				float z = Float.valueOf(line.split(" ")[3]);
				m.vertices.add(new Vector3f(x, y, z));
			} else if (line.startsWith("vn ")) {
				float x = Float.valueOf(line.split(" ")[1]);
				float y = Float.valueOf(line.split(" ")[2]);
				float z = Float.valueOf(line.split(" ")[3]);
				m.normals.add(new Vector3f(x, y, z));
			} else if (line.startsWith("f ")) {
				Vector3f vertexIndices = new Vector3f(
						Float.valueOf(line.split(" ")[1].split("/")[0]),
						Float.valueOf(line.split(" ")[2].split("/")[0]),
						Float.valueOf(line.split(" ")[3].split("/")[0]));
				Vector3f normalIndices = new Vector3f(
						Float.valueOf(line.split(" ")[1].split("/")[2]),
						Float.valueOf(line.split(" ")[2].split("/")[2]),
						Float.valueOf(line.split(" ")[3].split("/")[2]));
				m.faces.add(new Face(vertexIndices, normalIndices));
			}
		}
		reader.close();
		return m;
	}
	
	public static void renderModel(Model m) {
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
	}
}
