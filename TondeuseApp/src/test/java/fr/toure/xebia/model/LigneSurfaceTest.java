package fr.toure.xebia.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.fichier.LigneSurface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/spring-context.xml")
public class LigneSurfaceTest {

	@Autowired
	private LigneSurface ligneSurface;
	
	private int abscisse;

	private int ordonnee;

	@Before
	public void init(){
		this.abscisse = 3;
		this.ordonnee = 21;
		this.ligneSurface.setAbscisse(abscisse);
		this.ligneSurface.setOrdonnee(ordonnee);
	}

	@Test
	public void getAndSetAbscisse(){
		assertEquals(3, this.ligneSurface.getAbscisse());
		this.ligneSurface.setAbscisse(6);
		assertEquals(6, this.ligneSurface.getAbscisse());
	}
	
	@Test
	public void getAndSetOrdonnee(){
		assertEquals(21, this.ligneSurface.getOrdonnee());
		this.ligneSurface.setOrdonnee(6);;
		assertEquals(6, this.ligneSurface.getOrdonnee());
	}
}
