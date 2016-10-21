package fr.toure.xebia.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.appareil.IAppareil;
import fr.toure.xebia.model.appareil.Instructions;
import fr.toure.xebia.model.appareil.Tondeuse;
import fr.toure.xebia.model.commun.Coordonnees;
import fr.toure.xebia.model.commun.Mouvement;
import fr.toure.xebia.model.commun.Orientation;
import fr.toure.xebia.model.surface.Pelouse;
import fr.toure.xebia.service.appareil.TondeuseManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/ressources/spring-context.xml")
public class TondeuseManagerTest {
	
	@Autowired
	private TondeuseManager tondeuseManager;
	
	@Autowired
	private Pelouse pelouse;
	
	@Autowired
	private Tondeuse tondeuse1;
	
	@Autowired
	private Tondeuse tondeuse2;
	
	@Autowired
	private Instructions instructions1;
	
	@Autowired
	private Instructions instructions2;
	
	@Autowired
	private Coordonnees taillePelouse;
	
	private Map<IAppareil, Instructions> tondeusesInstructions;

	@Before
	public void init(){
		this.taillePelouse.setAbscisse(25);
		this.taillePelouse.setOrdonnee(31);
		
		this.pelouse.setTaille(this.taillePelouse);
		
		this.tondeuse1.setPositionCourante(6, 21);
		this.tondeuse2.setPositionCourante(3, 9);
		this.tondeuse1.setOrientation(Orientation.NORTH);
		this.tondeuse2.setOrientation(Orientation.EAST);
		
		this.instructions1.setDescription("DADGGA");
		this.instructions2.setDescription("AADDADDGA");
		
		this.tondeusesInstructions = new HashMap<IAppareil, Instructions>();
		this.tondeusesInstructions.put(tondeuse1, instructions1);
		this.tondeusesInstructions.put(tondeuse2, instructions2);
		
		this.tondeuseManager.setAppareilsInstructions(tondeusesInstructions);
		this.tondeuseManager.setSurface(pelouse);
	}
	
	@Test
	public void positionSuivanteCorrecteTest(){
		assertTrue(tondeuseManager.positionSuivanteCorrecte(11, 12));
		assertFalse(tondeuseManager.positionSuivanteCorrecte(13, 31));
	}
	
	@Test
	public void tournerAGaucheTest(){
		this.tondeuseManager.tournerAGauche(tondeuse1);
		assertEquals(Orientation.WEST, tondeuse1.getOrientation());
		
		this.tondeuseManager.tournerAGauche(tondeuse1);
		this.tondeuseManager.tournerAGauche(tondeuse1);
		assertEquals(Orientation.EAST, tondeuse1.getOrientation());
		
	}
	
	@Test
	public void tournerADroiteTest(){
		this.tondeuseManager.tournerADroite(tondeuse1);
		assertEquals(Orientation.EAST, tondeuse1.getOrientation());
		
		this.tondeuseManager.tournerADroite(tondeuse1);
		this.tondeuseManager.tournerADroite(tondeuse1);
		assertEquals(Orientation.WEST, tondeuse1.getOrientation());
	}
	
	@Test
	public void avancerTest(){
		this.tondeuseManager.avancer(tondeuse1);
		assertEquals(22, tondeuse1.getOrdonnee());
		assertEquals(6, tondeuse1.getAbscisse());
		
		this.tondeuseManager.tournerADroite(tondeuse1);
		this.tondeuseManager.avancer(tondeuse1);
		this.tondeuseManager.avancer(tondeuse1);
		assertEquals(22, tondeuse1.getOrdonnee());
		assertEquals(8, tondeuse1.getAbscisse());
	}
	
	@Test
	public void bougerTest(){
		this.tondeuseManager.bouger(tondeuse1, Mouvement.GAUCHE);
		this.tondeuseManager.bouger(tondeuse1, Mouvement.GAUCHE);
		assertEquals(Orientation.SOUTH, tondeuse1.getOrientation());
		
		this.tondeuseManager.bouger(tondeuse1, Mouvement.DROITE);
		assertEquals(Orientation.WEST, tondeuse1.getOrientation());
		
		this.tondeuseManager.bouger(tondeuse1, Mouvement.AVANT);
	}
	
	@Test
	public void getAndSetSurfaceTest(){
		
	}
	
	@Test
	public void afficherTest(){
		
	}
}
