package fr.toure.xebia.model;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Orientation {
	NORTH, SOUTH, EAST, WEST;

	private static final Map<String,Orientation> map = new LinkedHashMap<String,Orientation>(); 
	
	static {
			map.put("N", NORTH);
			map.put("S", SOUTH);
			map.put("E", EAST);
			map.put("W", WEST);
	}
	
	public static Orientation getOrientation(String key){
		return map.get(key);
	}

}