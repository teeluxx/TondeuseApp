package fr.toure.xebia.service.appareil;

import java.util.Map;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.appareil.Instructions;
import fr.toure.xebia.model.surface.ISurface;

public interface IAppareilSevice {

	public void setAppareilsInstructions(Map<IAppareil, Instructions> appareilsInstructions);

	public Map<IAppareil, Instructions> getAppareilsInstructions();
	
	public void setSurface(int abscisse, int ordonnee);
	
	public ISurface getSurface();
	
	/**
	 * affiche la position courante de tous les appareils qui se trouve dans la map appareilsInstructions
	 */
	public void afficherAppareilsPositions();

	/**
	 * Applique les instructions correspondant à chacun des appareils de la map appareilsInstructions
	 */
	public void executerAppareilsInstructions();

	/**
	 * test si la position suivante est correcte
	 * @param abscisse de la position suivante
	 * @param ordonnee de la position suivante
	 * @return true si la position abscisse-ordonnee est dans la surface courante, false sinon
	 */
	public boolean positionSuivanteCorrecte(int abscisse, int ordonnee);
}
