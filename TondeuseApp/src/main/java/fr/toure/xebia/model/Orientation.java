package fr.toure.xebia.model;

public enum Orientation {
	NORTH('N'),
	SOUTH('S'),
	EAST('E'),
	WEST('W');
	
	private final char orientation;
	
	private Orientation(char orientation){
		this.orientation = orientation;
	}

	public char getOrientation() {
		return orientation;
	}
	
	
}