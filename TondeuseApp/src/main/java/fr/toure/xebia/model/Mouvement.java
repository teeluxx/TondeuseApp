package fr.toure.xebia.model;

public enum Mouvement {
	DROITE('D'),
	GAUCHE('G'),
	AVANT('A');

	private final char mouvement;

	private Mouvement(char mouvement){
		this.mouvement = mouvement;
	}

	public char getPivotement() {
		return mouvement;
	}
}
