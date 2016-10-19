package fr.toure.xebia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.appareil.Tondeuse;
import fr.toure.xebia.model.commun.Coordonnees;
import fr.toure.xebia.model.commun.Orientation;
import fr.toure.xebia.service.fichier.LecteurFichierAppareilService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class LecteurFichierAppareilServiceTest {
	@Autowired
	private LecteurFichierAppareilService lecteurFichierAppareilService;

	private String enTete;
	private String appareilInitialisation;
	private String appareilIntructions;

	private Coordonnees coordonneesSurface;
	private Coordonnees coordonneesAppareil;
	private Orientation orientationAppareil;
	private IAppareil appareil;

	@Before
	public void init(){
		enTete = "5 8";
		appareilInitialisation = "3 1 E";
		appareilIntructions = "DAGGAGADDA";

		coordonneesSurface = new Coordonnees(5, 8);
		coordonneesAppareil = new Coordonnees(3, 1);
		orientationAppareil = Orientation.EAST;
		appareil = new Tondeuse(coordonneesAppareil, orientationAppareil);
	}

	@Test
	public void getEnTeteTest(){
		//Action
		Coordonnees coordonnees = lecteurFichierAppareilService.getEnTete(enTete);

		//Assertion
		assertTrue(coordonneesSurface.equals(coordonnees));
	}

	@Test
	public void getAppareilTest(){
		//Action
		IAppareil tondeuse = lecteurFichierAppareilService.getAppareil(appareilInitialisation);
		
		//Assertion
		assertTrue(appareil.equals(tondeuse));
	}

	@Test
	public void getInstructionsTest(){
		//Action
		String instructions = lecteurFichierAppareilService.getInstructions(appareilIntructions);

		//Assertion
		assertTrue(appareilIntructions.equals(instructions));
	}
}
