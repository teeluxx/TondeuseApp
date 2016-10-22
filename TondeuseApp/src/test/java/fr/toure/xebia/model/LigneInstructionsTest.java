package fr.toure.xebia.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.fichier.LigneInstructions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/spring-context.xml")
public class LigneInstructionsTest {
	
	@Autowired
	private LigneInstructions ligneInstructions;
	
	private String description;
	
	@Before
	public void init(){
		this.description = "DGAGDDAA";
		this.ligneInstructions.setDescription(description);
	}
	
	@Test
	public void getAndSetDescrption(){
		assertEquals("DGAGDDAA", this.ligneInstructions.getDescription());
		this.ligneInstructions.setDescription("AAGGGADA");
		assertEquals("AAGGGADA", this.ligneInstructions.getDescription());
	}
}
