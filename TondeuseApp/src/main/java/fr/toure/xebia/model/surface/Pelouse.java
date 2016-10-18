package fr.toure.xebia.model.surface;

import org.springframework.stereotype.Component;

import fr.toure.xebia.model.commun.Coordonnees;

@Component
public class Pelouse implements ISurface{
	private Coordonnees taille;
	
	public Pelouse(){
		super();
	}
	
	public Pelouse(Coordonnees taille) {
		super();
		this.taille = taille;
	}

	public Coordonnees getTaille() {
		return taille;
	}

	public void setTaille(Coordonnees taille) {
		this.taille = taille;
	}

	public int getAbscisseMax(){
		return taille.getX();
	}
	
	public int getOrdonneeMax(){
		return taille.getY();
	}
}
