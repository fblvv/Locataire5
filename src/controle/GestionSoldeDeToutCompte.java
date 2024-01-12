package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.logging.Logger;


import javax.swing.JButton;

import modele.Locataire;
import modele.dao.DaoLocataire;
import vue.FenetreSoldeToutCompte;

public class GestionSoldeDeToutCompte implements ActionListener {
	private Logger logger = Logger.getLogger(getClass().getName());
	private FenetreSoldeToutCompte fenetreSolde;

	public GestionSoldeDeToutCompte(FenetreSoldeToutCompte fenetreSolde) {
		this.fenetreSolde = fenetreSolde;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton button = (JButton) source;

			switch (button.getText()) {
			case "Annuler":
				fenetreSolde.dispose();
				break;
			case "Générer le reçu":
				fenetreSolde.dispose();
				break;
			default:
				break;
			}
		}
	}

	public void afficherInfoLocataire() throws SQLException {
		String idLocataire = fenetreSolde.getSelecteurIdLocataire();

		// Utilisez l'ID du locataire sélectionné pour récupérer les informations du locataire
		DaoLocataire daoLocataire = new DaoLocataire(); // Créez une instance de DaoLocataire
		Locataire locataire = daoLocataire.findById(idLocataire); // Appelez la méthode findById sur l'instance

		if (locataire != null) {
			// Vous pouvez maintenant accéder aux propriétés du locataire
			String nom = locataire.getNom();
			String prenom = locataire.getPrenom();
			// ...

			// Affichez ou utilisez les informations du locataire comme nécessaire
			logger.info("Nom du locataire : " + nom);
			logger.info("Prénom du locataire : " + prenom); 
		} else {
			logger.info("Locataire non trouvé pour l'ID : " + idLocataire); 
		}
	}
}
