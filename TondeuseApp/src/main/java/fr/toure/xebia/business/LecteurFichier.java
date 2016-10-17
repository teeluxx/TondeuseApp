package fr.toure.xebia.business;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import fr.toure.xebia.model.Coordonnees;
import fr.toure.xebia.model.Fichier;
import fr.toure.xebia.model.FichierAppareilPosition;
import fr.toure.xebia.model.FichierEnTete;
import fr.toure.xebia.model.FichierInstructions;
import fr.toure.xebia.model.Orientation;

@Service
public class LecteurFichier {
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	private  Path fichierChemin;

	public LecteurFichier(String nomFichier){
		this.fichierChemin = Paths.get(nomFichier);
	}

	public Fichier lire(){
		Fichier fichier = new Fichier();
		try (Scanner scanner =  new Scanner(fichierChemin, ENCODING.name())){
			// détermine si on lit l'en-tete ou pas
			boolean isEntete = true;
			while (scanner.hasNextLine()){
				// lecture en-tete
				if(isEntete){
					fichier.setEnTete(getEnTete(scanner.nextLine()));
					isEntete = false;
				}
				// lecture position appareil et de ses instructions
				else{
					FichierAppareilPosition appareilPosition = getAppareilPosition(scanner.nextLine());
					FichierInstructions instructions = getInstructions(scanner.nextLine());
					fichier.ajouterInstructionAppareil(appareilPosition, instructions);
				}
			}
			scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fichier;
	}

	private FichierEnTete getEnTete(String ligne){
		Scanner scanner = new Scanner(ligne);
		scanner.useDelimiter(" ");

		int abscisse = scanner.nextInt();
		int ordonnee = scanner.nextInt();

		return new FichierEnTete(new Coordonnees(abscisse, ordonnee));
	}

	private FichierAppareilPosition getAppareilPosition(String ligne){
		Scanner scanner = new Scanner(ligne);
		scanner.useDelimiter(" ");
		
		int abscisse = scanner.nextInt();
		int ordonnee = scanner.nextInt();
		Orientation orientation = Orientation.getOrientation(scanner.next());
		
		return new FichierAppareilPosition(abscisse, ordonnee, orientation);
	}

	private FichierInstructions getInstructions(String ligne){
		return new FichierInstructions(ligne); 
	}
}
