package com.trippylizard.tensixtysix;

import com.trippylizard.tensixtysix.nations.Normans;

public class Nation {
	
	public static final Nation normans = new Normans();
	//public static final Nation english = new English();
	//public static final Nation vikings = new Vikings();
	
	String name;
	String description;
	
	public Nation(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
}
