package fr.toure.xebia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.appareil.Tondeuse;
import fr.toure.xebia.model.commun.Coordonnees;
import fr.toure.xebia.model.commun.Orientation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/spring-context.xml")
public class TondeuseTest {

	@Autowired
	private Tondeuse tondeuse;

	@Autowired
	private Coordonnees positionCourante;

	private Orientation orientation;

	@Before
	public void init(){
		this.positionCourante.setAbscisse(6);
		this.positionCourante.setOrdonnee(21);
		this.orientation = Orientation.EAST;

		this.tondeuse.setPositionCourante(this.positionCourante);
		this.tondeuse.setOrientation(this.orientation);
	}
	
	@Test
	public void getAbscisseTest(){
		assertEquals(6, this.tondeuse.getAbscisse());
	}
	
	@Test
	public void getOrdonneeTest(){
		assertEquals(21, this.tondeuse.getOrdonnee());
	}
	
	@Test
	public void getAndSetOrientationTest(){
		assertEquals(Orientation.EAST, this.tondeuse.getOrientation());
		this.tondeuse.setOrientation(Orientation.SOUTH);
		assertEquals(Orientation.SOUTH, this.tondeuse.getOrientation());
	}

	@Test
	public void getAndSetPositionCouranteTest(){
		assertEquals(positionCourante, tondeuse.getPositionCourante());
		this.tondeuse.setPositionCourante(4, 9);
		assertEquals(4, tondeuse.getAbscisse());
		assertEquals(9, tondeuse.getOrdonnee());
	}
	
	@Test
	public void toStringTest(){
		String s = "6 21 E";
		assertEquals(s, tondeuse.toString());
	}

}
