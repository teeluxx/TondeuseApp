package fr.toure.xebia.business;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import fr.toure.xebia.model.FichierEnTete;

@Service
public class LecteurFichier {
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	private  Path fichierChemin;
	
	public LecteurFichier(String nomFichier){
		this.fichierChemin = Paths.get(nomFichier);
	}
	
	public static FichierEnTete getEnTete(String ligne){
		return null;
	}
}
