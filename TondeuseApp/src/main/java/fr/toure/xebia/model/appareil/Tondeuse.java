package fr.toure.xebia.model.appareil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.toure.xebia.model.commun.Coordonnees;
import fr.toure.xebia.model.commun.Orientation;

@Component
@Scope("prototype")
public class Tondeuse implements IAppareil{
	
	@Autowired
	private Coordonnees positionCourante;
	
	private Orientation orientation;
	
	private int numeroDeSerie;
	
	public Coordonnees getPositionCourante() {
		return positionCourante;
	}
	
	public void setPositionCourante(Coordonnees positionCourante){
		this.positionCourante = positionCourante;
	}
	
	public void setPositionCourante(int abscisse, int ordonnee){
		this.positionCourante.setAbscisse(abscisse);
		this.positionCourante.setOrdonnee(ordonnee);
	}
	
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	public int getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(int numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}
	
	public int getAbscisse(){
		return this.positionCourante.getAbscisse();
	}

	public int getOrdonnee(){
		return this.positionCourante.getOrdonnee();
	}
	
	@Override
	public String toString() {
		return this.positionCourante.toString() + " " + this.orientation;
	}
	
	@Override
	public boolean equals(Object obj) {
		Tondeuse tondeuse = (Tondeuse) obj;
		if(this.positionCourante.getAbscisse() == tondeuse.getAbscisse()
				&& this.positionCourante.getOrdonnee() == tondeuse.getOrdonnee()
				&& this.orientation.equals(tondeuse.getOrientation()))
			return true;
		return false;
	}
}
