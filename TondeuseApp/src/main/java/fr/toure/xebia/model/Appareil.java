package fr.toure.xebia.model;

import org.springframework.stereotype.Component;

@Component
public abstract class Appareil {
	
	private Position positionCourante;
	private Orientation orientation;

	public void tourner(Pivotement pivotement){
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
		if(x <= surface.getAbscisse() && y <= surface.getOrdonnee() && x>= 0 && y >= 0){
			return true;
		}
		return false;
	}

	public abstract void avancer(Surface surface);

	public Position getCurrentPosition() {
		return positionCourante;
	}
	public void setCurrentPosition(Position currentPosition) {
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
