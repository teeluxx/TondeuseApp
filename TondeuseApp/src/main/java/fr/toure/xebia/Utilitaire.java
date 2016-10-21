package fr.toure.xebia;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Utilitaire {
	public static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("spring.xml");
}
