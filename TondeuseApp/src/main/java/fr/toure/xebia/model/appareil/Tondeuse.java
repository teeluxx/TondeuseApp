package fr.toure.xebia.model.appareil;

import fr.toure.xebia.model.commun.Coordonnees;
import fr.toure.xebia.model.commun.Orientation;

public class Tondeuse implements IAppareil{
	private Coordonnees positionCourante;
	private Orientation orientation;

	public Tondeuse(Coordonnees positionCourante, Orientation orientation) {
		this.positionCourante = positionCourante;
		this.orientation = orientation;
	}
	
	public Coordonnees getPositionCourante() {
		return positionCourante;
	}
	public void setPositionCourante(Coordonnees positionCourante) {
		this.positionCourante = positionCourante;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	public int getAbscisse(){
		return this.positionCourante.getX();
	}

	public int getOrdonnee(){
		return this.positionCourante.getY();
	}
	
	@Override
	public String toString() {
		return "X : " + getAbscisse() + ", " + "Y : " +getOrdonnee();
	}

	public boolean equals(Object obj){
		Tondeuse tondeuse = (Tondeuse) obj;
		if(this.getOrdonnee() == tondeuse.getOrdonnee() && this.getAbscisse() == tondeuse.getAbscisse()
				&& this.getOrientation().equals(tondeuse.getOrientation()))
			return true;
		return false;
	}
}
