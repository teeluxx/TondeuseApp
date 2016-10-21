package fr.toure.xebia.model.fichier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.commun.Orientation;

@Component
@Scope("prototype")
public class LigneAppareil {

	@Autowired
	private IAppareil appareil;

	public void setAppareil(int abscisse, int ordonnee, Orientation orientation){
		this.appareil.setPositionCourante(abscisse, ordonnee);
		this.appareil.setOrientation(orientation);
	}
	
	public IAppareil getAppareil(){
		return this.appareil;
	}
}
