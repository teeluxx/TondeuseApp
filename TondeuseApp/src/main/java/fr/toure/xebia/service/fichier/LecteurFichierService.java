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

import fr.toure.xebia.Utilitaire;
import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.appareil.Instructions;
import fr.toure.xebia.model.commun.Orientation;
import fr.toure.xebia.model.fichier.LigneAppareil;
import fr.toure.xebia.model.fichier.LigneInstructions;
import fr.toure.xebia.model.fichier.LigneSurface;
import fr.toure.xebia.model.surface.ISurface;
import fr.toure.xebia.service.appareil.IAppareilSevice;

@Service
public class LecteurFichierService {
	private final static Charset ENCODING = StandardCharsets.UTF_8;

	@Autowired
	private IAppareilSevice appareilService;

	public void lancer(){
		this.appareilService.executerAppareilsInstructions();
		this.appareilService.afficher();
	}

	public void lire(String nomFichier){
		Path path = Paths.get(nomFichier);

		try (Scanner scanner =  new Scanner(path, ENCODING.name())){
			Map<IAppareil, Instructions> appareilsInstructions = new HashMap<>();
			boolean isEntete = true;
			while (scanner.hasNextLine()){
				if(isEntete){
					setServiceSurface(scanner.nextLine());
					isEntete = false;
				}else{
					LigneAppareil ligneAppareil = getLigneAppareil(scanner.nextLine());
					Instructions instructions = getInstructions(scanner.nextLine());

					appareilsInstructions.put(ligneAppareil.getAppareil(), instructions);
				}
			}
			setServiceAppareilsInstructions(appareilsInstructions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setServiceSurface(String ligne){
		Scanner scanner = new Scanner(ligne);
		try {
			scanner.useDelimiter(" ");

			int abscisse = scanner.nextInt();
			int ordonnee = scanner.nextInt();

			this.appareilService.setSurface(abscisse, ordonnee);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			scanner.close();
		}
	}

	public void setServiceAppareilsInstructions(Map<IAppareil, Instructions> appareilsInstructions){
		this.appareilService.setAppareilsInstructions(appareilsInstructions);
	}

	public LigneAppareil getLigneAppareil(String ligne){
		LigneAppareil ligneAppareil = (LigneAppareil) Utilitaire.CONTEXT.getBean("ligneAppareil");
		
		Scanner scanner = new Scanner(ligne);
		try {
			scanner.useDelimiter(" ");

			int abscisse = scanner.nextInt();
			int ordonnee = scanner.nextInt();

			Orientation orientation = Orientation.getOrientation(String.valueOf(scanner.next()));

			ligneAppareil.setAppareil(abscisse, ordonnee, orientation);
		} finally {
			scanner.close();
		}
		
		return ligneAppareil;
	}

	public Instructions getInstructions(String ligne){
		LigneInstructions ligneInstructions = (LigneInstructions) Utilitaire.CONTEXT.getBean("ligneInstructions");
		ligneInstructions.setDescription(ligne);

		return ligneInstructions.getInstructions();
	}

	public IAppareilSevice getAppareilService() {
		return appareilService;
	}

	public void setAppareilService(IAppareilSevice appareilService) {
		this.appareilService = appareilService;
	}
}
