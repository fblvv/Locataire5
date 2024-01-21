package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.Entreprise;

import modele.dao.DaoEntreprise;
import vue.FenetreAjoutEntreprise;

public class GestionAjoutEntreprise implements ActionListener {

	private FenetreAjoutEntreprise entrepriseFenetre;

	public GestionAjoutEntreprise(FenetreAjoutEntreprise entrepriseFenetre) {
		this.entrepriseFenetre = entrepriseFenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton button = (JButton) source;

			switch (button.getText()) {
			case "Valider":
				ajouterEntreprise();
				entrepriseFenetre.dispose();
				break;

			case "Annuler":
				entrepriseFenetre.dispose();
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Ajoute une entreprise
	 */
	// Ajoute une entreprise à la base de données en récupérant les données du formulaire
	public void ajouterEntreprise() {
		try {


			String nomSiren = entrepriseFenetre.getSiren();
			String nomAdresse = entrepriseFenetre.getAdresse();
			String tel= entrepriseFenetre.getTel();
			String nom = entrepriseFenetre.getNom();


			Entreprise entreprise = new Entreprise(nomSiren, nomAdresse, tel, nom);

			DaoEntreprise daoEntreprise = new DaoEntreprise();

			// Ajout de l'entreprise dans la base de données
			daoEntreprise.create(entreprise);

			Logger logger = Logger.getLogger(getClass().getName());
			logger.info("Entreprise ajouté avec succès !");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'entreprise : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}

	}
}


