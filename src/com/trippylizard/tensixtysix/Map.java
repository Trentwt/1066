package com.trippylizard.tensixtysix;

import com.trippylizard.tensixtysix.utils.models.Model;

/**
 * Represents a 1066 Map used to store data such as the map width, length or height and is constructed using the Model class to initialize the map.
 * 
 * @author Trent
 */

public class Map {

	double width;
	double length;
	double height;
	
	Model model;
	
	public Map(Model model) {
		this.model = model;
		this.width = model.getMaxX();
		this.length = model.getMaxZ();
		this.height = model.getMaxY();
	}
	
	public double getMapWidth() {
		return width;
	}
	
	public double getMapLength() {
		return length;
	}

	public double getMapHeight() {
		return height;
	}
	
	public Model getModel() {
		return model;
	}
}
