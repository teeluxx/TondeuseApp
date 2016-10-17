package fr.toure.xebia.model;

import java.util.Map;

public class Fichier {
	private FichierEnTete enTete;
	private Map<FichierAppareilPosition, FichierInstructions> donneesAppareil;
	public FichierEnTete getEnTete() {
		return enTete;
	}
	public void setEnTete(FichierEnTete enTete) {
		this.enTete = enTete;
	}
	public Map<FichierAppareilPosition, FichierInstructions> getDonneesAppareil() {
		return donneesAppareil;
	}
	public void setDonneesAppareil(Map<FichierAppareilPosition, FichierInstructions> donneesAppareil) {
		this.donneesAppareil = donneesAppareil;
	}

	public void ajouterInstructionAppareil(FichierAppareilPosition appareil, FichierInstructions intructions){
		this.donneesAppareil.put(appareil, intructions);
	}
}
