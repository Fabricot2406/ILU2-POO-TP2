package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import villagegaulois.Village;
import personnages.Gaulois;
import personnages.Druide;
import personnages.Chef;

class ControlAfficherVillageTest {
	private Village village;
	private Gaulois bonemine;
	private Chef abraracourcix;
	private Druide panoramix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		panoramix = new Druide("Panoramix", 10, 1, 5);
		village.ajouterHabitant(panoramix);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNomsVillageois(), "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNomVillage(), "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNbEtals(), "Constructeur ne renvoie pas null");
	}

}
