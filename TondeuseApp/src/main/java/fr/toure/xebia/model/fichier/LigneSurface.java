package fr.toure.xebia.model.fichier;

import org.springframework.stereotype.Component;

@Component
public class LigneSurface {
	private int abscisse;

	private int ordonnee;

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
}
