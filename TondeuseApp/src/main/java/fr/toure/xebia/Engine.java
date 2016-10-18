package fr.toure.xebia;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.toure.xebia.service.fichier.LecteurFichierAppareilService;


public class Engine {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("../ressources/spring.xml");
		LecteurFichierAppareilService lecteurFichierAppareilService = (LecteurFichierAppareilService) context.getBean("lecteurFichierAppareilService");
		lecteurFichierAppareilService.lire(args[0]);
	}
}
