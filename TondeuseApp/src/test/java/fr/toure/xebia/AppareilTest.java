package fr.toure.xebia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.business.Appareil;
import fr.toure.xebia.model.Orientation;
import fr.toure.xebia.model.Mouvement;
import fr.toure.xebia.model.Coordonnees;
import fr.toure.xebia.model.Surface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AppareilTest {

	@Autowired
	private Appareil tondeuse;
	
	@Autowired
	private Surface surface;

	@Before
	public void init(){
		//Appareil
		Coordonnees tonsdeusePositionInitiale = new Coordonnees(1, 0);
		tondeuse.setOrientation(Orientation.NORTH);
		tondeuse.setCurrentPosition(tonsdeusePositionInitiale);
		
		//Surface
		Coordonnees taille = new Coordonnees(6, 2);
		surface.setMaxCoordonnees(taille);
	}
	
	@Test
	public void tournerAGaucheTest(){
		// Action
		tondeuse.tourner(Mouvement.GAUCHE);

		//Assertion
		assertEquals(Orientation.WEST, tondeuse.getOrientation());
	}

	@Test
	public void tournerADroiteTest(){
		// Action
		tondeuse.tourner(Mouvement.DROITE);

		//Assertion
		assertEquals(Orientation.EAST, tondeuse.getOrientation());
	}

	@Test
	public void tournerPlusieursFoisTest(){
		// Action
		tondeuse.tourner(Mouvement.GAUCHE);
		tondeuse.tourner(Mouvement.GAUCHE);
		tondeuse.tourner(Mouvement.GAUCHE);
		tondeuse.tourner(Mouvement.DROITE);

		//Assertion
		assertEquals(Orientation.SOUTH, tondeuse.getOrientation());
	}
	
	@Test
	public void avancerDansSurfaceTest(){
		// Action
		tondeuse.avancer(surface);
		tondeuse.tournerADroite();
		tondeuse.avancer(surface);
		
		//Assertion
		assertEquals(2, tondeuse.getAbscisse());
		assertEquals(1, tondeuse.getOrdonnee());
		assertEquals(Orientation.EAST, tondeuse.getOrientation());
	}
	
	@Test
	public void avancerHorsSurfaceTest(){
		// Action
		tondeuse.tournerAGauche();
		tondeuse.avancer(surface);
		tondeuse.avancer(surface);
		
		//Assertion
		assertEquals(0, tondeuse.getAbscisse());
		assertEquals(0, tondeuse.getOrdonnee());
		assertEquals(Orientation.WEST, tondeuse.getOrientation());
	}
}
