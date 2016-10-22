package fr.toure.xebia.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.commun.Coordonnees;
import fr.toure.xebia.model.surface.Pelouse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/spring-context.xml")
public class PelouseTest {
	
	@Autowired
	private Pelouse pelouse;
	
	@Autowired
	private Coordonnees taille;
	
	@Autowired
	private Coordonnees tailleNouvelle;
	
	@Before
	public void init(){
		this.taille.setAbscisse(6);
		this.taille.setOrdonnee(21);
		this.tailleNouvelle.setAbscisse(17);
		this.tailleNouvelle.setOrdonnee(4);
		
		this.pelouse.setTaille(taille);
	}
	
	@Test
	public void getAbscisseMaxTest(){
		assertEquals(6, this.pelouse.getAbscisseMax());
	}
	
	@Test
	public void getOrdonneeMaxTest(){
		assertEquals(21, this.pelouse.getOrdonneeMax());
	}
	
	@Test
	public void getAndSetTailleTest(){
		assertEquals(taille, pelouse.getTaille());
		this.pelouse.setTaille(tailleNouvelle);
		assertEquals(tailleNouvelle, pelouse.getTaille());
	}
}
