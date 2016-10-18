package fr.toure.xebia.service.fichier;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.appareil.Tondeuse;
import fr.toure.xebia.model.commun.Coordonnees;
import fr.toure.xebia.model.commun.Orientation;
import fr.toure.xebia.model.fichier.FichierAppareil;
import fr.toure.xebia.model.fichier.IFichier;
import fr.toure.xebia.model.surface.ISurface;

@Service
public class LecteurFichierAppareilService {
	
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	
	private FichierAppareil fichier;

	public IFichier lire(String nomFichier){
		Path fichierChemin = Paths.get(nomFichier);
		
		try (Scanner scanner =  new Scanner(fichierChemin, ENCODING.name())){
			// Map des appareils et leurs instructions
			Map <IAppareil, String> appareilsInstructions = new HashMap<IAppareil, String>();
			
			// détermine si on lit l'en-tete ou pas
			boolean isEntete = true;
			
			while (scanner.hasNextLine()){
				// lecture en-tete
				if(isEntete){
					fichier.setEnTete(getEnTete(scanner.nextLine()));
					isEntete = false;
				}
				// lecture de la position de l'appareil et de ses instructions
				else{
					IAppareil appareil = getAppareil(scanner.nextLine());
					String instructions = getInstructions(scanner.nextLine());

					appareilsInstructions.put(appareil, instructions);
				}
			}
			scanner.close();
			fichier.setAppareilsInstructions(appareilsInstructions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fichier;
	}

	private Coordonnees getEnTete(String ligne){
		Scanner scanner = new Scanner(ligne);
		scanner.useDelimiter(" ");

		int abscisse = scanner.nextInt();
		int ordonnee = scanner.nextInt();

		return new Coordonnees(abscisse, ordonnee);
	}

	private IAppareil getAppareil(String ligne){
		Scanner scanner = new Scanner(ligne);
		scanner.useDelimiter(" ");
		
		int abscisse = scanner.nextInt();
		int ordonnee = scanner.nextInt();
		
		Coordonnees coordonnees = new Coordonnees(abscisse, ordonnee);
		Orientation orientation = Orientation.getOrientation(scanner.next());
		
		return new Tondeuse(coordonnees, orientation);
	}

	private String getInstructions(String ligne){
		return ligne; 
	}
}
