package fr.toure.xebia;

import fr.toure.xebia.service.fichier.LecteurFichierService;

public class App {
	public static void main(String[] args) {
		LecteurFichierService lecteur = (LecteurFichierService) Utilitaire.CONTEXT.getBean("lecteurFichierService");
		lecteur.lire(args[0]);
		lecteur.lancer();
	}
}
