package fr.toure.xebia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.appareil.Tondeuse;
import fr.toure.xebia.model.commun.Coordonnees;
import fr.toure.xebia.model.commun.Mouvement;
import fr.toure.xebia.model.commun.Orientation;
import fr.toure.xebia.model.surface.ISurface;
import fr.toure.xebia.model.surface.Pelouse;
import fr.toure.xebia.service.AbstractAppareilSevice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TondeuseServiceTest {

	@Autowired
	private AbstractAppareilSevice tondeuseService;

	private ISurface pelouse;

	@Before
	public void init(){
		//Tondeuse
		Coordonnees tonsdeusePositionInitiale = new Coordonnees(1, 0);
		Tondeuse tondeuse = new Tondeuse(tonsdeusePositionInitiale, Orientation.NORTH);
		tondeuseService.setAppareil(tondeuse);

		//Surface
		Coordonnees taille = new Coordonnees(6, 2);
		pelouse = new Pelouse(taille);
	}

	@Test
	public void tournerPlusieursFoisTest(){
		// Action
		tondeuseService.bouger(Mouvement.GAUCHE, pelouse);
		tondeuseService.bouger(Mouvement.GAUCHE, pelouse);
		tondeuseService.bouger(Mouvement.GAUCHE, pelouse);
		tondeuseService.bouger(Mouvement.DROITE, pelouse);

		//Assertion
		assertEquals(Orientation.SOUTH, tondeuseService.getAppareil().getOrientation());
	}

	@Test
	public void avancerTest(){
		// Action
		tondeuseService.avancer(pelouse);

		//Assertion
		assertEquals(1, tondeuseService.getAppareil().getAbscisse());
		assertEquals(1, tondeuseService.getAppareil().getOrdonnee());
	}

	@Test
	public void avancerDansSurfaceTest(){
		// Action
		tondeuseService.bouger(Mouvement.AVANT, pelouse);
		tondeuseService.bouger(Mouvement.DROITE, pelouse);
		tondeuseService.bouger(Mouvement.AVANT, pelouse);

		//Assertion
		assertEquals(2, tondeuseService.getAppareil().getAbscisse());
		assertEquals(1, tondeuseService.getAppareil().getOrdonnee());
		assertEquals(Orientation.EAST, tondeuseService.getAppareil().getOrientation());
	}

	@Test
	public void avancerHorsSurfaceTest(){
		// Action
		tondeuseService.bouger(Mouvement.GAUCHE, pelouse);
		tondeuseService.bouger(Mouvement.AVANT, pelouse);
		tondeuseService.bouger(Mouvement.AVANT, pelouse);

		//Assertion
		assertEquals(0, tondeuseService.getAppareil().getAbscisse());
		assertEquals(0, tondeuseService.getAppareil().getOrdonnee());
		assertEquals(Orientation.WEST, tondeuseService.getAppareil().getOrientation());
	}
}
