package fr.toure.xebia.model.commun;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

public enum Orientation {
	NORTH, SOUTH, EAST, WEST;

	private static final Map<String,Orientation> map = new HashMap<String,Orientation>(); 

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