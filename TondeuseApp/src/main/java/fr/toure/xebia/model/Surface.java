package fr.toure.xebia.model;

import org.springframework.stereotype.Component;

@Component
public class Surface {
	private Coordonnees maxCoordonnees;

	public Coordonnees getMaxCoordonnees() {
		return maxCoordonnees;
	}

	public void setMaxCoordonnees(Coordonnees maxCoordonnees) {
		this.maxCoordonnees = maxCoordonnees;
	}
	
	public int getAbscisse(){
		return maxCoordonnees.getX();
	}
	
	public int getOrdonnee(){
		return maxCoordonnees.getY();
	}
}
