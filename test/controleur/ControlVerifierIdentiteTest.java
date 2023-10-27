package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

class ControlVerifierIdentiteTest {
	private Village village;
	private Gaulois bonemine;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		bonemine = new Gaulois("Bonemine", 10);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.ajouterHabitant(bonemine);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Obelix"));
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
	}

}
