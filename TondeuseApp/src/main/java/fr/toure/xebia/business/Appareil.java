package fr.toure.xebia.business;

import fr.toure.xebia.model.Orientation;
import fr.toure.xebia.model.Mouvement;
import fr.toure.xebia.model.Coordonnees;
import fr.toure.xebia.model.Surface;

public abstract class Appareil {
	
	private Coordonnees positionCourante;
	private Orientation orientation;
	
	public abstract void avancer(Surface surface);

	public void tourner(Mouvement pivotement){
		switch (pivotement) {
		case DROITE:
			tournerADroite();
			break;
		case GAUCHE:
			tournerAGauche();
			break;
		default:
			break;
		}
	}

	public void tournerADroite(){
		switch (this.orientation) {
		case NORTH:
			this.orientation = Orientation.EAST;
			break;
		case SOUTH:
			this.orientation = Orientation.WEST;
			break;
		case EAST:
			this.orientation = Orientation.SOUTH;
			break;
		case WEST:
			this.orientation = Orientation.NORTH;
			break;
		default:
			break;
		}
	}

	public void tournerAGauche(){
		switch (this.orientation) {
		case NORTH:
			this.orientation = Orientation.WEST;
			break;
		case SOUTH:
			this.orientation = Orientation.EAST;
			break;
		case EAST:
			this.orientation = Orientation.NORTH;
			break;
		case WEST:
			this.orientation = Orientation.SOUTH;
			break;
		default:
			break;
		}
	}

	public boolean positionSuivanteCorrecte(Surface surface, int x, int y){
		if(x < surface.getAbscisse() && y < surface.getOrdonnee() && x >= 0 && y >= 0){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String etat = "Position => ";
		return etat + getCurrentPosition();
	}

	public Coordonnees getCurrentPosition() {
		return positionCourante;
	}
	public void setCurrentPosition(Coordonnees currentPosition) {
		this.positionCourante = currentPosition;
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
}
