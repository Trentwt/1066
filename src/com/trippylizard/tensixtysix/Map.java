package com.trippylizard.tensixtysix;

import com.trippylizard.tensixtysix.models.Model;

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
}
