package fr.toure.xebia.service.appareil;

import java.util.Map;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.fichier.Instructions;
import fr.toure.xebia.model.surface.ISurface;

public interface IAppareilSevice {

	public void setAppareilsInstructions(Map<? extends IAppareil, Instructions> appareilsInstructions);

	public Map<? extends IAppareil, Instructions> getAppareilsInstructions();
	
	public void setSurface(ISurface surface);
	
	public ISurface getSurface();
	
	public void afficher();

	public void executerAppareilsInstructions();

	public boolean positionSuivanteCorrecte(int abscisse, int ordonnee);
}
