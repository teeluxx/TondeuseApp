package fr.toure.xebia.service.appareil;

import java.util.List;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.commun.Coordonnees;
import fr.toure.xebia.model.commun.Mouvement;
import fr.toure.xebia.model.fichier.IFichier;
import fr.toure.xebia.model.surface.ISurface;

public abstract class AbstractAppareilSevice {

	public abstract void bouger(Mouvement mouvement, ISurface surface);
	
	public abstract void avancer(ISurface surface);
	
	public abstract void setAppareil(IAppareil appareil);
	
	public abstract IAppareil getAppareil();
	
	public abstract void lireInstructions(String instructions, ISurface surface);
	
	public boolean positionSuivanteCorrecte(ISurface surface, Coordonnees coordonnees){
		if(coordonnees.getX() < surface.getAbscisseMax() && coordonnees.getY() < surface.getOrdonneeMax()
				&& coordonnees.getX() >= 0 && coordonnees.getY() >= 0){
			return true;
		}
		return false;
	}

}
