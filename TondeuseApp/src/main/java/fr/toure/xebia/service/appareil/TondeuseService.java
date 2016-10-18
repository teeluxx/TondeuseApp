package fr.toure.xebia.service.appareil;

import org.springframework.stereotype.Service;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.appareil.Tondeuse;
import fr.toure.xebia.model.commun.Coordonnees;
import fr.toure.xebia.model.commun.Mouvement;
import fr.toure.xebia.model.commun.Orientation;
import fr.toure.xebia.model.surface.ISurface;
import fr.toure.xebia.service.AbstractAppareilSevice;

@Service
public class TondeuseService extends AbstractAppareilSevice{
	
	private Tondeuse tondeuse;

	public void bouger(Mouvement mouvement, ISurface surface){
		switch (mouvement) {
		case DROITE:
			tournerADroite();
			break;
		case GAUCHE:
			tournerAGauche();
			break;
		case AVANT:
			avancer(surface);
			break;
		default:
			break;
		}
	}

	public void avancer(ISurface surface) {
		Coordonnees coordonnees = new Coordonnees(tondeuse.getAbscisse(), tondeuse.getOrdonnee());
		
		switch (tondeuse.getOrientation()) {
		case NORTH:
			coordonnees.setY(coordonnees.getY() + 1);
			if(positionSuivanteCorrecte(surface, coordonnees)){
				tondeuse.setPositionCourante(coordonnees);
			}
			break;
		case SOUTH:
			coordonnees.setY(coordonnees.getY() - 1);
			if(positionSuivanteCorrecte(surface, coordonnees)){
				tondeuse.setPositionCourante(coordonnees);
			}
			break;
		case EAST:
			coordonnees.setX(coordonnees.getX() + 1);
			if(positionSuivanteCorrecte(surface, coordonnees)){
				tondeuse.setPositionCourante(coordonnees);
			}
			break;
		case WEST:
			coordonnees.setX(coordonnees.getX() - 1);
			if(positionSuivanteCorrecte(surface, coordonnees)){
				tondeuse.setPositionCourante(coordonnees);
			}
			break;
		default:
			break;
		}
	}

	public void tournerADroite(){
		switch (tondeuse.getOrientation()) {
		case NORTH:
			tondeuse.setOrientation(Orientation.EAST);
			break;
		case SOUTH:
			tondeuse.setOrientation(Orientation.WEST);
			break;
		case EAST:
			tondeuse.setOrientation(Orientation.SOUTH);
			break;
		case WEST:
			tondeuse.setOrientation(Orientation.NORTH);
			break;
		default:
			break;
		}
	}

	public void tournerAGauche() {
		switch (tondeuse.getOrientation()) {
		case NORTH:
			tondeuse.setOrientation(Orientation.WEST);
			break;
		case SOUTH:
			tondeuse.setOrientation(Orientation.EAST);
			break;
		case EAST:
			tondeuse.setOrientation(Orientation.NORTH);
			break;
		case WEST:
			tondeuse.setOrientation(Orientation.SOUTH);
			break;
		default:
			break;
		}
	}
	
	public String afficher() {
		String position = "Position => " + tondeuse;
		return position;
	}
	
	public void setAppareil(IAppareil appareil){
		this.tondeuse = (Tondeuse) appareil;
	}
	
	public IAppareil getAppareil(){
		return this.tondeuse;
	}
}
