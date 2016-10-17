package fr.toure.xebia.business;

import org.springframework.stereotype.Service;

import fr.toure.xebia.model.Coordonnees;
import fr.toure.xebia.model.Surface;

@Service
public class Tondeuse extends Appareil{

	@Override
	public void avancer(Surface surface) {
		switch (getOrientation()) {
		case NORTH:
			if(positionSuivanteCorrecte(surface, getAbscisse(), getOrdonnee() + 1)){
				setCurrentPosition(new Coordonnees(getAbscisse(), getOrdonnee() + 1));
			}
			break;
		case SOUTH:
			if(positionSuivanteCorrecte(surface, getAbscisse(), getOrdonnee() - 1)){
				setCurrentPosition(new Coordonnees(getAbscisse(), getOrdonnee() - 1));
			}
			break;
		case EAST:
			if(positionSuivanteCorrecte(surface, getAbscisse() + 1, getOrdonnee())){
				setCurrentPosition(new Coordonnees(getAbscisse() + 1, getOrdonnee()));
			}
			break;
		case WEST:
			if(positionSuivanteCorrecte(surface, getAbscisse() - 1, getOrdonnee())){
				setCurrentPosition(new Coordonnees(getAbscisse() - 1, getOrdonnee()));
			}
			break;
		default:
			break;
		}
	}
}
