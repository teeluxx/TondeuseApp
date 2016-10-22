package fr.toure.xebia.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.fichier.LigneAppareil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/spring-context.xml")
public class LigneAppareilTest {

	@Autowired
	private LigneAppareil ligneAppareil;

	private int abscisse;

	private int ordonnee;

	private String orientation;

	@Before
	public void init(){
		this.abscisse = 6;
		this.ordonnee = 21;
		this.orientation = "E";
		this.ligneAppareil.setAbscisse(abscisse);
		this.ligneAppareil.setOrdonnee(ordonnee);
		this.ligneAppareil.setOrientation(orientation);
	}
	
	@Test
	public void getAndSetAbscisse(){
		assertEquals(6, this.ligneAppareil.getAbscisse());
		this.ligneAppareil.setAbscisse(9);
		assertEquals(9, this.ligneAppareil.getAbscisse());
	}
	
	@Test
	public void getAndSetOrdonnee(){
		assertEquals(21, this.ligneAppareil.getOrdonnee());
		this.ligneAppareil.setOrdonnee(4);
		assertEquals(4, this.ligneAppareil.getOrdonnee());
	}
	
	@Test
	public void getAndSetOrientation(){
		assertEquals("E", this.ligneAppareil.getOrientation());
		this.ligneAppareil.setOrientation("W");
		assertEquals("W", this.ligneAppareil.getOrientation());
	}
}
