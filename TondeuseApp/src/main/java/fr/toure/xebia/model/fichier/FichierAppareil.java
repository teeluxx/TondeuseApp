package fr.toure.xebia.model.fichier;

import java.util.Map;

import org.springframework.stereotype.Component;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.commun.Coordonnees;

@Component
public class FichierAppareil implements IFichier{
	
	private Coordonnees enTete;
	private Map<IAppareil, String> appareilsInstructions;
	
	public Coordonnees getEnTete() {
		return enTete;
	}
	public void setEnTete(Coordonnees enTete) {
		this.enTete = enTete;
	}
	public Map<IAppareil, String> getAppareilsInstructions() {
		return appareilsInstructions;
	}
	public void setAppareilsInstructions(Map<IAppareil, String> appareilsInstructions) {
		this.appareilsInstructions = appareilsInstructions;
	}
	
	
}
