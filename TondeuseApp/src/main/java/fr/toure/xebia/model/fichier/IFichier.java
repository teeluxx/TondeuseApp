package fr.toure.xebia.model.fichier;

import java.util.Map;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.commun.Coordonnees;

public interface IFichier {
	public Coordonnees getEnTete();
	
	public Map<IAppareil, String> getAppareilsInstructions();
	
	public void setEnTete(Coordonnees enTete);
	
	public void setAppareilsInstructions(Map<IAppareil, String> appareilsInstructions);
}
