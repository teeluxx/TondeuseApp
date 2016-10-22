package fr.toure.xebia.model.fichier;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LigneAppareil {

	private int abscisse;

	private int ordonnee;
	
	private String orientation;

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

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
}
