package fr.toure.xebia.model;

import org.springframework.stereotype.Component;

@Component
public class Surface {
	private Position maxCoordonnees;

	public Position getMaxCoordonnees() {
		return maxCoordonnees;
	}

	public void setMaxCoordonnees(Position maxCoordonnees) {
		this.maxCoordonnees = maxCoordonnees;
	}
	
	public int getAbscisse(){
		return maxCoordonnees.getX();
	}
	
	public int getOrdonnee(){
		return maxCoordonnees.getY();
	}
}
