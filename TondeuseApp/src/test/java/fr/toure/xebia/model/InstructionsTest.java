package fr.toure.xebia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.toure.xebia.model.appareil.Instructions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/spring-context.xml")
public class InstructionsTest {
	
	@Autowired
	private Instructions instructions;
	
	private String description;
	
	private String descriptionNouvelle;
	
	@Before
	public void init(){
		this.description = "AGGGADGA";
		this.descriptionNouvelle = "ADDGA";
		
		this.instructions.setDescription(description);
	}
	
	@Test
	public void getAndSetDecriptionTest(){
		assertEquals(description, this.instructions.getDescription());
		this.instructions.setDescription(descriptionNouvelle);
		assertEquals(descriptionNouvelle, this.instructions.getDescription());
	}

}
