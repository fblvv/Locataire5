package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.Batiment;
import modele.dao.DaoBatiment;
import vue.FenetreAjoutBatiment;

public class GestionAjoutBatiment implements ActionListener {

	private FenetreAjoutBatiment ajoutBatiment;

	public GestionAjoutBatiment(FenetreAjoutBatiment ajoutBatiment) {
		this.ajoutBatiment = ajoutBatiment;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton button = (JButton) source;

			switch (button.getText()) {
			case "Valider":
				ajouterBatiment();
				ajoutBatiment.dispose();
				break;

			case "Annuler":
				ajoutBatiment.dispose();
				break;
			default:
				break;
			}	


		}
	}



	//Vérification que les champs sont correctement ecrits
	public void ajouterBatiment() {
		try {
			String dateText = ajoutBatiment.getDateConstruction();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);

			try {
				Date date = sdf.parse(dateText);
			} catch (ParseException ex) {
				JOptionPane.showMessageDialog(ajoutBatiment, "Le format de la date n'est pas valide (jj/mm/aaaa).", "Erreur de Format", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String nomBatiment = ajoutBatiment.getIdBatiment();
			String regimeJuridique = ajoutBatiment.getRegimeJuridique();
			String adresse = ajoutBatiment.getAdresse();
			String codePostal = ajoutBatiment.getCodePostal();
			String equipAccesTech = ajoutBatiment.getEquipAccesTech();
			String enumPartiesCommunes = ajoutBatiment.getEnumPartiesCommunes();

			// Vérifier que le code postal contient exactement 5 chiffres
			if (!codePostal.matches("\\d{5}")) {
				JOptionPane.showMessageDialog(ajoutBatiment, "Le code postal doit contenir exactement 5 chiffres.", "Erreur de Format", JOptionPane.ERROR_MESSAGE);
				return;
			}

			Batiment batiment = new Batiment(nomBatiment, regimeJuridique, adresse,
					dateText, equipAccesTech, enumPartiesCommunes, codePostal);

			DaoBatiment daoBatiment = new DaoBatiment();
			daoBatiment.create(batiment);

			Logger logger = Logger.getLogger(getClass().getName());
			logger.info("Bâtiment ajouté avec succès !");


			// Afficher un pop-up de confirmation
			JOptionPane.showMessageDialog(ajoutBatiment, "Bâtiment ajouté avec succès !", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
