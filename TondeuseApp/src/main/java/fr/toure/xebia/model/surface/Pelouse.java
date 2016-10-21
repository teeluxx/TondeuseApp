package fr.toure.xebia.model.surface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.toure.xebia.model.commun.Coordonnees;

@Component
public class Pelouse implements ISurface{
	
	@Autowired
	private Coordonnees taille;

	public Coordonnees getTaille() {
		return taille;
	}

	public void setTaille(Coordonnees taille) {
		this.taille = taille;
	}
	
	public void setTaille(int abscisse, int ordonnee){
		this.taille.setAbscisse(abscisse + 1);
		this.taille.setOrdonnee(ordonnee + 1);
	}

	public int getAbscisseMax(){
		return taille.getAbscisse();
	}
	
	public int getOrdonneeMax(){
		return taille.getOrdonnee();
	}
}
