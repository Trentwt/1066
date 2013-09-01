package com.trippylizard.tensixtysix;

import com.trippylizard.tensixtysix.models.Model;

public class Map {

	double width;
	double length;
	Model model;
	
	public Map(Model model) {
		this.model = model;
		this.width = model.getMaxX();
		this.length = model.getMaxZ();
	}
	
	public double getMapWidth() {
		return width;
	}
	
	public double getMapLength() {
		return length;
	}
}
