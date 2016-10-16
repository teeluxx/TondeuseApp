package fr.toure.xebia.business;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.Appareil;
import fr.toure.xebia.model.Orientation;
import fr.toure.xebia.model.Pivotement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AppareilTest {
	
	@Autowired
	private Appareil tondeuse;

	@Before
	public void initialisation(){
		tondeuse.setOrientation(Orientation.NORTH);
	}
	
	@Test
	public void tournerAGaucheTest(){
		// Action
		tondeuse.tourner(Pivotement.GAUCHE);
		
		//Assertion
		assertEquals(Orientation.WEST, tondeuse.getOrientation());
	}

	@Test
	public void tournerADroiteTest(){
		tondeuse.tourner(Pivotement.DROITE);
		
		assertEquals(Orientation.EAST, tondeuse.getOrientation());
	}
}
