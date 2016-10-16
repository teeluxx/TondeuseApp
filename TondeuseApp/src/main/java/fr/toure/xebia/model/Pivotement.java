package fr.toure.xebia.model;

public enum Pivotement {
	DROITE('D'),
	GAUCHE('G');

	private final char pivotement;

	private Pivotement(char pivotement){
		this.pivotement = pivotement;
	}

	public char getPivotement() {
		return pivotement;
	}
}
