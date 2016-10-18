package fr.toure.xebia.model.appareil;

import fr.toure.xebia.model.commun.Orientation;

public interface IAppareil {
	public int getAbscisse();

	public int getOrdonnee();
	
	public Orientation getOrientation();
}
