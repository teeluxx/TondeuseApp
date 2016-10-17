package fr.toure.xebia.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.toure.xebia.model.Fichier;
import fr.toure.xebia.model.Surface;

@Service
public class Engine {
	private static Fichier fichier;
	
	@Autowired
	private static Surface surface;
	
	public static void main(String[] args) {
		construireFichier(args[0]);
		
		construireSurface();
		
		lancerTraitement();
	}
	
	private static void construireFichier(String nomFichier){
		LecteurFichier lecteur = new LecteurFichier(nomFichier);
		fichier = lecteur.lire();
	}
	
	private static void construireSurface(){
		surface.setMaxCoordonnees(fichier.getEnTete().getCoordonneesMax());
	}
	
	private static void lancerTraitement(){
		
	}
}
