package fr.toure.xebia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.fichier.IFichier;
import fr.toure.xebia.model.surface.ISurface;
import fr.toure.xebia.model.surface.Pelouse;
import fr.toure.xebia.service.appareil.AbstractAppareilSevice;
import fr.toure.xebia.service.fichier.LecteurFichierAppareilService;

@Service
public class Gestionnaire {
	@Autowired
	private IFichier fichier;
	
	@Autowired
	private ISurface surface;
	
	@Autowired
	private LecteurFichierAppareilService lecteurFichierAppareilService;
	
	@Autowired
	private AbstractAppareilSevice appareilService;

	public void gestion(String nomFichier){
		fichier = lecteurFichierAppareilService.lire(nomFichier);
		
		surface = new Pelouse(fichier.getEnTete());
		
		for (IAppareil appareil : fichier.getAppareilsInstructions().keySet()) {
			appareilService.lireInstructions(fichier.getAppareilsInstructions().get(appareil), surface);
		}
	}
	
	public void afficheEtatFinal(){
		for (IAppareil appareil : fichier.getAppareilsInstructions().keySet()) {
			System.out.println(fichier.getAppareilsInstructions().get(appareil));
		}
	}
}
