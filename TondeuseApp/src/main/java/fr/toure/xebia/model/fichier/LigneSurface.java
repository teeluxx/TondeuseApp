package fr.toure.xebia.model.fichier;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LigneSurface {
	private int abscisse;

	private int ordonnees;

	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnees() {
		return ordonnees;
	}

	public void setOrdonnees(int ordonnees) {
		this.ordonnees = ordonnees;
	}
}
