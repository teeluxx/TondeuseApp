package fr.toure.xebia.model.commun;

import java.util.HashMap;
import java.util.Map;

public enum Mouvement {
	DROITE, GAUCHE, AVANT;

	private static final Map<String,Mouvement> map = new HashMap<String,Mouvement>(); 

	static {
		map.put("D", DROITE);
		map.put("G", GAUCHE);
		map.put("A", AVANT);
	}

	public static Mouvement getMouvement(String key){
		return map.get(key);
	}
}
