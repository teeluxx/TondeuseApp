package fr.toure.xebia.model.fichier;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.toure.xebia.Utilitaire;
import fr.toure.xebia.model.appareil.Instructions;

@Component
@Scope("prototype")
public class LigneInstructions {

	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instructions getInstructions(){
		Instructions instructions = (Instructions) Utilitaire.CONTEXT.getBean("instructions");
		instructions.setDescription(this.description);
		return instructions;
	}
}
