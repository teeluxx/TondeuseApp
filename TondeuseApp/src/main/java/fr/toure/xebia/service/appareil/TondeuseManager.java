package fr.toure.xebia.service.appareil;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.appareil.Instructions;
import fr.toure.xebia.model.commun.Mouvement;
import fr.toure.xebia.model.commun.Orientation;
import fr.toure.xebia.model.surface.ISurface;


/**
 * @author younoussatoure
 *
 */
@Service
public class TondeuseManager implements IAppareilSevice{

	private Map<IAppareil, Instructions> appareilsInstructions;

	@Autowired
	private ISurface surface;

	public void executerAppareilsInstructions(){
		for (IAppareil appareil : appareilsInstructions.keySet()) {
			executerAppareilInstructions(appareil, appareilsInstructions.get(appareil));
		}
	}

	/**
	 * Applique les intructions a l'appareil
	 * @param appareil sur lequel appliquer les instructions
	 * @param instructions de l'appareil
	 */
	public void executerAppareilInstructions(IAppareil appareil, Instructions instructions){
		for (char m : instructions.getDescription().toCharArray()) {
			Mouvement mouvement = Mouvement.getMouvement(String.valueOf(m));
			bouger(appareil, mouvement);
		}
	}

	/**
	 * Deplace l'appareil selon le mouvement
	 * @param appareil sur lequel appliquer le mouvement
	 * @param mouvement a effectuer
	 */
	public void bouger(IAppareil appareil, Mouvement mouvement){
		switch (mouvement) {
		case DROITE:
			tournerADroite(appareil);
			break;
		case GAUCHE:
			tournerAGauche(appareil);
			break;
		case AVANT:
			avancer(appareil);
			break;
		default:
			break;
		}
	}

	/**
	 * Avance l'appareil d'une case dans le sens de son orientation
	 * @param appareil a avancer
	 */
	public void avancer(IAppareil appareil) {
		switch (appareil.getOrientation()) {
		case NORTH:
			if(positionSuivanteCorrecte(appareil.getAbscisse(), appareil.getOrdonnee() + 1)){
				appareil.setPositionCourante(appareil.getAbscisse(), appareil.getOrdonnee() + 1);
			}
			break;
		case SOUTH:
			if(positionSuivanteCorrecte(appareil.getAbscisse(), appareil.getOrdonnee() - 1)){
				appareil.setPositionCourante(appareil.getAbscisse(), appareil.getOrdonnee() - 1);
			}
			break;
		case EAST:
			if(positionSuivanteCorrecte(appareil.getAbscisse() + 1, appareil.getOrdonnee())){
				appareil.setPositionCourante(appareil.getAbscisse() + 1, appareil.getOrdonnee());
			}
			break;
		case WEST:
			if(positionSuivanteCorrecte(appareil.getAbscisse() - 1, appareil.getOrdonnee())){
				appareil.setPositionCourante(appareil.getAbscisse() - 1, appareil.getOrdonnee());
			}
			break;
		default:
			break;
		}
	}

	/**
	 * change l'orientation de l'appareil de 90 degres vers la droite
	 * @param appareil qui change d'orientation
	 */
	public void tournerADroite(IAppareil appareil){
		switch (appareil.getOrientation()) {
		case NORTH:
			appareil.setOrientation(Orientation.EAST);
			break;
		case SOUTH:
			appareil.setOrientation(Orientation.WEST);
			break;
		case EAST:
			appareil.setOrientation(Orientation.SOUTH);
			break;
		case WEST:
			appareil.setOrientation(Orientation.NORTH);
			break;
		default:
			break;
		}
	}

	/**
	 * change l'orientation de l'appareil de 90 degres vers la gauche
	 * @param appareil qui change d'orientation
	 */
	public void tournerAGauche(IAppareil appareil) {
		switch (appareil.getOrientation()) {
		case NORTH:
			appareil.setOrientation(Orientation.WEST);
			break;
		case SOUTH:
			appareil.setOrientation(Orientation.EAST);
			break;
		case EAST:
			appareil.setOrientation(Orientation.NORTH);
			break;
		case WEST:
			appareil.setOrientation(Orientation.SOUTH);
			break;
		default:
			break;
		}
	}

	public boolean positionSuivanteCorrecte(int abscisse, int ordonnee){
		if(abscisse < this.surface.getAbscisseMax() && ordonnee < this.surface.getOrdonneeMax()
				&& abscisse >= 0 && ordonnee >= 0){
			return true;
		}
		return false;
	}

	public void afficherAppareilsPositions() {
		for (IAppareil appareil : appareilsInstructions.keySet()) {
			System.out.println(appareil);
		}
	}
	
	public Map<IAppareil, Instructions> getAppareilsInstructions() {
		return appareilsInstructions;
	}

	public void setAppareilsInstructions(Map<IAppareil, Instructions> appareilsInstructions) {
		this.appareilsInstructions = appareilsInstructions;
	}

	public void setSurface(int abscisse, int ordonnee){
		this.surface.setTaille(abscisse, ordonnee);
	}

	public ISurface getSurface(){
		return this.surface;
	}
}
