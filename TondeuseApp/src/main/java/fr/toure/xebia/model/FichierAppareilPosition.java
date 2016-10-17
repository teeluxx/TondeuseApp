package fr.toure.xebia.model;

public class FichierAppareilPosition {
	private int abscisse;
	private int ordonnee;
	private Orientation orientation;
	
	
	public FichierAppareilPosition(int abscisse, int ordonnee, Orientation orientation) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.orientation = orientation;
	}
	
	public int getAbscisse() {
		return abscisse;
	}
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}
	public int getOrdonnee() {
		return ordonnee;
	}
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	
}
