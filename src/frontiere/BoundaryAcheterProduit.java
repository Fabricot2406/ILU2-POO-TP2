package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			StringBuilder question = new StringBuilder();
			question.append("Quel produit voulez-vous acheter ?\n");
			String produit = Clavier.inputOutput(question.toString());
			question.setLength(0);
			String[] infosMarche = controlAcheterProduit.donnerInfosMarche(produit);
			if (infosMarche.length != 0) {
				question.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
				for (int i = 0; i < infosMarche.length; i += 3) {
					question.append(((i/3) + 1) + " - " + infosMarche[i] +"\n");
				}
				int choix = Clavier.entrerEntier(question.toString());
				Etal etal = controlAcheterProduit.trouverEtalVendeur(infosMarche[(choix-1) * 3]);
				question.setLength(0);
				question.append(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + etal.getVendeur().getNom() + ".\n");
				question.append("Bonjour " + nomAcheteur + ".\n");
				question.append("Combien de " + produit + " voulez-vous acheter ?\n");
				int nbProduits = Clavier.entrerEntier(question.toString());
				if (etal.getQuantite() == 0) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduits + " " + produit + ", malheureusement il n'y en a plus !\n");
				} else if (nbProduits <= etal.getQuantite()) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduits + " " + produit + ", malheureusement " + etal.getVendeur().getNom() + " n'en a plus que " + etal.getQuantite() + ". " + nomAcheteur + " achète tout le stock de " + etal.getVendeur().getNom() + ".\n");
					controlAcheterProduit.acheterProduit(etal, etal.getQuantite());
				} else {
					System.out.println(nomAcheteur + " achète " + nbProduits + " " + produit + " à " + etal.getVendeur().getNom() + ".\n");
					controlAcheterProduit.acheterProduit(etal, nbProduits);
				}
			} else {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
		} else {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.\n");
		}
	}
}
