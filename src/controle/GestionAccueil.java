package controle;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import SQL.CictOracleDataSource;
import modele.LireCSV;
import vue.Accueil;
import vue.FenetreAjoutBatiment;
import vue.FenetreBien;
import vue.FenetreCompteur;
import vue.FenetreDetailsPropriete2;
import vue.FenetreListeLocataire;
import vue.FenetreLoyer;

import vue.FenetreSoldeToutCompte;
import vue.FenetreCharges;
import vue.FenetreFacture;
import vue.PageAjoutLocataire;
import vue.VoirContratLocation;

public class GestionAccueil implements ActionListener {
	private Accueil accueil;

	public GestionAccueil(Accueil accueil) {
		this.accueil = accueil;
		connectionBaseDonnee(); // Appel de la méthode d'initialisation de la connexion
	}


	private void connectionBaseDonnee() {
		try {
			CictOracleDataSource.creerAcces("lrf4482a", "oracle");
		} catch (SQLException e) {
			e.printStackTrace();
			// Gérer l'erreur de connexion (peut-être afficher un message à l'utilisateur)
		}
	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem menuItem = (JMenuItem) e.getSource();
		JLayeredPane layeredPane = accueil.getLayeredPane();

		switch (menuItem.getText()) {
		case "Ajouter locataire":
			afficherFenetre(new PageAjoutLocataire(), layeredPane);
			break;
		case "Consulter locataire":
			afficherFenetre(new FenetreListeLocataire(), layeredPane);
			break;
		case "Ajouter logement":
			afficherFenetre(new FenetreBien(), layeredPane);
			break;
		case "Consulter contrat de location":
			afficherFenetre(new VoirContratLocation(), layeredPane);
			break;
		case "Consulter logement":
			afficherFenetre(new FenetreDetailsPropriete2(), layeredPane);
			break;
		case "Liste des locataires":
			afficherFenetre(new FenetreListeLocataire(), layeredPane);
			break;
		case "Gestion Factures":
			afficherFenetre(new FenetreFacture(), layeredPane);
			break;
		case "Gestion Charges":
			afficherFenetre(new FenetreCharges(), layeredPane);
			break;
		case "Ajouter loyers":
			afficherFenetre(new FenetreLoyer(), layeredPane);
			break;
		case "Ajouter Nouveau Batiment":
			afficherFenetre(new FenetreAjoutBatiment(), layeredPane);
			break;
		case "Gestion des Compteurs":
			afficherFenetre(new FenetreCompteur(), layeredPane);
			break;
		case "Lire fichier CSV":
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers CSV", "csv"));
			int result = fileChooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				String csvFilePath = fileChooser.getSelectedFile().getAbsolutePath();
				new LireCSV().lireEtInsererCSV(csvFilePath);
			}
			break;
		case "Vérifier le Solde de tout compte":
			afficherFenetre(new FenetreSoldeToutCompte(), layeredPane);
			break;
		default:
			break;
		}
	}

	private void afficherFenetre(javax.swing.JInternalFrame fenetre, JLayeredPane layeredPane) {
		layeredPane.add(fenetre);
		fenetre.setVisible(true);
	}
}
