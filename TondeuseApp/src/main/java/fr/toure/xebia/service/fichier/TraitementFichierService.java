package fr.toure.xebia.service.fichier;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.toure.xebia.Utilitaire;
import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.appareil.Instructions;
import fr.toure.xebia.model.appareil.Tondeuse;
import fr.toure.xebia.model.commun.Orientation;
import fr.toure.xebia.model.fichier.LigneAppareil;
import fr.toure.xebia.model.fichier.LigneInstructions;
import fr.toure.xebia.model.fichier.LigneSurface;
import fr.toure.xebia.service.appareil.IAppareilSevice;

@Service
public class TraitementFichierService {
	private final static Charset ENCODING = StandardCharsets.UTF_8;

	@Autowired
	private IAppareilSevice appareilService;

	/**
	 * Applique les informations du fichier et les affiche
	 */
	public void lancer(){
		this.appareilService.executerAppareilsInstructions();
		this.appareilService.afficherAppareilsPositions();
	}

	/**
	 * lit le fichier et mets à jour les données de tondeuseManager
	 * @param nomFichier le fichier à lire
	 */
	public void lire(String nomFichier){
		Path path = Paths.get(nomFichier);

		try (Scanner scanner =  new Scanner(path, ENCODING.name())){
			Map<IAppareil, Instructions> appareilsInstructions = new Hashtable<>();
			boolean isEntete = true;
			while (scanner.hasNextLine()){
				if(isEntete){
					LigneSurface ligneSurface = getLigneSurface(scanner.nextLine());
					setServiceSurface(ligneSurface.getAbscisse(), ligneSurface.getOrdonnee());
					
					isEntete = false;
				}else{
					LigneAppareil ligneAppareil = getLigneAppareil(scanner.nextLine());
					LigneInstructions ligneInstructions = getLigneInstructions(scanner.nextLine());
					IAppareil appareil = getAppareilFromLigneAppareil(ligneAppareil);
					Instructions instructions = getInstructionsFromLigneInstructions(ligneInstructions);

					appareilsInstructions.put(appareil, instructions);
				}
			}
			setServiceAppareilsInstructions(appareilsInstructions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *recupere le bean ligneSurface
	 * @param ligne la chaine de caractere de la ligne pour la surface
	 * @return le bean cree
	 */
	public LigneSurface getLigneSurface(String ligne){
		LigneSurface ligneSurface = (LigneSurface) Utilitaire.CONTEXT.getBean("ligneSurface");
		
		Scanner scanner = new Scanner(ligne);
		try {
			scanner.useDelimiter(" ");

			int abscisse = scanner.nextInt();
			int ordonnee = scanner.nextInt();

			ligneSurface.setAbscisse(abscisse);
			ligneSurface.setOrdonnee(ordonnee);
		} finally {
			scanner.close();
		}
		return ligneSurface;
	}

	/**
	 *cree un bean ligneAppareil
	 * @param ligne la chaine de caractere d'une ligne d'appareil
	 * @return le bean cree
	 */
	public LigneAppareil getLigneAppareil(String ligne){
		LigneAppareil ligneAppareil = (LigneAppareil) Utilitaire.CONTEXT.getBean("ligneAppareil");
		
		Scanner scanner = new Scanner(ligne);
		try {
			scanner.useDelimiter(" ");

			int abscisse = scanner.nextInt();
			int ordonnee = scanner.nextInt();

			String orientation = String.valueOf(scanner.next());

			ligneAppareil.setAbscisse(abscisse);
			ligneAppareil.setOrdonnee(ordonnee);
			ligneAppareil.setOrientation(orientation);
		} finally {
			scanner.close();
		}
		
		return ligneAppareil;
	}

	/**
	 *cree un bean ligneInstructions
	 * @param ligne la chaine de caractere d'une ligne d'instructions
	 * @return le bean cree
	 */
	public LigneInstructions getLigneInstructions(String ligne){
		LigneInstructions ligneInstructions = (LigneInstructions) Utilitaire.CONTEXT.getBean("ligneInstructions");
		
		ligneInstructions.setDescription(ligne);

		return ligneInstructions;
	}
	
	/**
	 * cree un nouveau bean tondeuse et le met a jour avec les elements de la ligne du fichier
	 * @param ligneAppareil contient les informations de depart de l'appareil
	 * @return le bean tondeuse cree
	 */
	public IAppareil getAppareilFromLigneAppareil(LigneAppareil ligneAppareil){
		IAppareil appareil = (Tondeuse) Utilitaire.CONTEXT.getBean("tondeuse");
		
		appareil.setPositionCourante(ligneAppareil.getAbscisse(), ligneAppareil.getOrdonnee());
		appareil.setOrientation(Orientation.getOrientation(ligneAppareil.getOrientation()));
		
		return appareil;
	}
	
	/**
	 * cree un nouveau bean instructions et le met a jour avec les elements de la ligne du fichier 
	 * @param ligneInstructions contient les intructions
	 * @return le bean instructions cree
	 */
	public Instructions getInstructionsFromLigneInstructions(LigneInstructions ligneInstructions){
		Instructions instructions = (Instructions) Utilitaire.CONTEXT.getBean("instructions");
		
		instructions.setDescription(ligneInstructions.getDescription());
		
		return instructions;
	}
	
	/**
	 * Met a jour la surface du service des appareils sur laquelle les appareils vont travailler
	 * @param abscisse l'abscisse du coin max droit de la surface
	 * @param ordonnee l'ordonnee du coin max droit de la surface
	 */
	public void setServiceSurface(int abscisse, int ordonnee){
		this.appareilService.setSurface(abscisse, ordonnee);
	}
	
	/**
	 * met a jour la map du service des appareils dans laquelle se trouvent les appareils et leurs instructions
	 * @param appareilsInstructions la map des appareils et leurs instructions
	 */
	public void setServiceAppareilsInstructions(Map<IAppareil, Instructions> appareilsInstructions){
		this.appareilService.setAppareilsInstructions(appareilsInstructions);
	}

	public IAppareilSevice getAppareilService() {
		return appareilService;
	}

	public void setAppareilService(IAppareilSevice appareilService) {
		this.appareilService = appareilService;
	}
}
