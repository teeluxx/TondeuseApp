package fr.toure.xebia.model;

public class FichierEnTete {
	private Coordonnees coordonneesMax;
	
	public FichierEnTete(Coordonnees coordonneesMax) {
		this.coordonneesMax = coordonneesMax;
	}

	public Coordonnees getCoordonneesMax() {
		return coordonneesMax;
	}

	public void setCoordonneesMax(Coordonnees coordonneesMax) {
		this.coordonneesMax = coordonneesMax;
	}
	
}
