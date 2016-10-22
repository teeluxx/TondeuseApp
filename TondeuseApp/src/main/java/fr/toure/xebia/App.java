package fr.toure.xebia;

import fr.toure.xebia.service.fichier.TraitementFichierService;

public class App {
	public static void main(String[] args) {
		TraitementFichierService traitementFichier = (TraitementFichierService) Utilitaire.CONTEXT.getBean("traitementFichierService");
		traitementFichier.lire(args[0]);
		traitementFichier.lancer();
	}
}
