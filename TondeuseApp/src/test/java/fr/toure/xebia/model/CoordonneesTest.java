package fr.toure.xebia.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.commun.Coordonnees;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/spring-context.xml")
public class CoordonneesTest {
	@Autowired
	private Coordonnees coordonnees1;
	
	@Autowired
	private Coordonnees coordonnees2;
	
	private int abscisse;
	private int ordonnee;
	
	@Before
	public void init(){
		this.abscisse = 6;
		this.ordonnee = 21;
		
		coordonnees1.setAbscisse(this.abscisse);
		coordonnees1.setOrdonnee(this.ordonnee);
		
		coordonnees2.setAbscisse(this.abscisse);
		coordonnees2.setOrdonnee(this.ordonnee);
	}
	
	@Test
	public void getAndSetAbscisseTest(){
		assertEquals(6, coordonnees1.getAbscisse());
		coordonnees1.setAbscisse(3);
		assertEquals(3, coordonnees1.getAbscisse());
	}
	
	@Test
	public void getAndSetOrdonneeTest(){
		assertEquals(21, coordonnees1.getOrdonnee());
		coordonnees1.setOrdonnee(9);
		assertEquals(9, coordonnees1.getOrdonnee());
	}
	
	@Test
	public void equalsTest(){
		assertTrue(coordonnees1.equals(coordonnees2));
		coordonnees1.setAbscisse(27);
		assertFalse(coordonnees1.equals(coordonnees2));
	}
	
	@Test
	public void toStringTest(){
		String s = "6 21";
		assertEquals(s, coordonnees1.toString());
	}
}
