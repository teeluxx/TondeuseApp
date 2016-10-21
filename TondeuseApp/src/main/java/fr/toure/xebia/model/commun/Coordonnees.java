package fr.toure.xebia.model.commun;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Coordonnees {
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
	
	@Override
	public String toString() {
		return this.abscisse + " " + this.ordonnee;
	}
	
	@Override
	public boolean equals(Object obj) {
		Coordonnees coordonnees = (Coordonnees) obj;
		if(this.abscisse == coordonnees.getAbscisse() && this.ordonnee == coordonnees.getOrdonnee())
			return true;
		return false;
	}
}
