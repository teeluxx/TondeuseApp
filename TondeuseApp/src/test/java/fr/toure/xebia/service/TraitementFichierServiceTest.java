package fr.toure.xebia.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.appareil.Instructions;
import fr.toure.xebia.model.commun.Orientation;
import fr.toure.xebia.model.fichier.LigneAppareil;
import fr.toure.xebia.model.fichier.LigneInstructions;
import fr.toure.xebia.model.fichier.LigneSurface;
import fr.toure.xebia.service.fichier.TraitementFichierService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/spring-context.xml")
public class TraitementFichierServiceTest {

	@Autowired
	private TraitementFichierService traitement;

	@Autowired
	private LigneSurface ligneSurface;

	@Autowired
	private LigneAppareil ligneAppareil1;

	@Autowired
	private LigneAppareil ligneAppareil2;

	@Autowired
	private LigneInstructions ligneInstructions1;

	@Autowired
	private LigneInstructions ligneInstructions2;

	private String description1;

	private String description2;

	private String appareil1;

	private String appareil2;
	
	private String surface;

	@Before
	public void init(){
		description1 = "GGADADAA";
		description2 = "AADAGGA";

		appareil1 = "12 2 N";
		appareil2 = "0 23 W";
		
		surface = "28 23";

		ligneInstructions1.setDescription(description1);
		ligneInstructions2.setDescription(description2);
		
		ligneAppareil1.setAbscisse(12);
		ligneAppareil1.setOrdonnee(2);
		ligneAppareil1.setOrientation("N");
		
		ligneAppareil2.setAbscisse(0);
		ligneAppareil2.setOrdonnee(23);
		ligneAppareil2.setOrientation("W");
		
		ligneSurface.setAbscisse(28);
		ligneSurface.setOrdonnee(33);
	}

	@Test
	public void getLigneInstructionsTest(){
		LigneInstructions ligneIntructions = traitement.getLigneInstructions(description1);
		assertEquals(description1, ligneIntructions.getDescription());
	}

	@Test
	public void getLigneAppareilTest(){
		LigneAppareil ligneAppareil = traitement.getLigneAppareil(appareil1);

		assertEquals(12, ligneAppareil.getAbscisse());
		assertEquals(2, ligneAppareil.getOrdonnee());
		assertEquals("N", ligneAppareil.getOrientation());
	}

	@Test
	public void getLigneSurfaceTest(){
		LigneSurface ligneSurface = traitement.getLigneSurface(surface);
		
		assertEquals(28, ligneSurface.getAbscisse());
		assertEquals(23, ligneSurface.getOrdonnee());
	}
	
	@Test
	public void getAppareilFromLigneAppareilTest(){
		IAppareil appareil = traitement.getAppareilFromLigneAppareil(ligneAppareil1);
		
		assertEquals(12, appareil.getAbscisse());
		assertEquals(2, appareil.getOrdonnee());
		assertEquals(Orientation.NORTH, appareil.getOrientation());
	}
	
	@Test
	public void getInstructionsFromLigneInstructionsTest(){
		Instructions instructions = traitement.getInstructionsFromLigneInstructions(ligneInstructions1);
		
		assertEquals("GGADADAA", instructions.getDescription());
	}
}
