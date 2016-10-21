package fr.toure.xebia.service.appareil;

import java.util.Map;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.appareil.Instructions;
import fr.toure.xebia.model.surface.ISurface;

public interface IAppareilSevice {

	public void setAppareilsInstructions(Map<IAppareil, Instructions> appareilsInstructions);

	public Map<IAppareil, Instructions> getAppareilsInstructions();
	
	public void setSurface(ISurface surface);
	
	public void setSurface(int abscisse, int ordonnee);
	
	public ISurface getSurface();
	
	public void afficher();

	public void executerAppareilsInstructions();

	public boolean positionSuivanteCorrecte(int abscisse, int ordonnee);
}
