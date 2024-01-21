package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Logger;


import modele.BienImmobilier;
import modele.Facture;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoFacture;
import vue.FenetreFacture;

public class GestionFactures implements ActionListener , ItemListener  {

	private FenetreFacture gestionFactures;
	private DaoFacture daoFacture;
	private DaoBienImmobilier daoBienImmobilier;
	private Logger logger = Logger.getLogger(getClass().getName());

	public GestionFactures(FenetreFacture gestionFacture) {
		this.gestionFactures = gestionFacture;
		this.daoFacture = new DaoFacture();
		this.daoBienImmobilier = new DaoBienImmobilier();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton buttonValider = (JButton) source;

			switch (buttonValider.getText()) {
			case "Valider":
				try {
					insererFacture();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				break;
			case "Ajouter Facture":
				ajouterReleve();
				break;
			case "Annuler":
				gestionFactures.dispose();
				break;
			default:
				break;
			}
		}
	}


	/**
	 * Methode pour ajouter un relever
	 */
	private void ajouterReleve() {		
		String typeFacture = (String) gestionFactures.getTypefactureComboBox().getSelectedItem();
		DefaultTableModel model = (DefaultTableModel) gestionFactures.getTable().getModel();
		model.addRow(new Object[]{"", "", "", "typeFacture", ""});	
	}

	/**
	 * Methode pour ajouter une facture
	 */
	private void insererFacture() throws SQLException {
		DefaultTableModel model = (DefaultTableModel) gestionFactures.getTable().getModel();
		int selectedRow = gestionFactures.getTable().getSelectedRow();

		//Ajouter dans la BD la facture avec les infos suivantes : ID, Date, Type, Valeur, ID_Bien
		Object[] rowData = new Object[5];
		for (int i = 0; i < 5; i++) {
			rowData[i] = model.getValueAt(selectedRow, i);
		}
		String idFacture = (String)rowData[0];
		String siren = (String)rowData[1];
		Double prix = Double.parseDouble((String)rowData[2]);
		String type = (String)rowData[3];
		String date =(String)rowData[4];
		String idBienSelectionne = (String) gestionFactures.getIdBienComboBox().getSelectedItem();
		logger.info(idBienSelectionne);
		BienImmobilier bat = daoBienImmobilier.findById(idBienSelectionne);
		String idBat = bat.getId_Batiment();
		logger.info(idBat);


		Facture facture = new Facture(idFacture,siren,prix,type,date,idBienSelectionne,idBat);

		daoFacture.create(facture);

		filtrerFactures();
	}


	/**
	 * Methode pour charger la page sans apuyer sur un boutton
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		//Filtrer avec les Jcombobox
		if (e.getSource() == gestionFactures.getTypefactureComboBox()
				|| e.getSource() == gestionFactures.getIdBienComboBox()) {
			try {
				filtrerFactures();
				activerBoutonAjouter();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Methode pour activer le boutton ajouter
	 */
	private void activerBoutonAjouter() {
		String idBienSelectionne = (String) gestionFactures.getIdBienComboBox().getSelectedItem();
		String typeFacture = (String) gestionFactures.getTypefactureComboBox().getSelectedItem();
		// Activer le bouton si un bien est sélectionné, sinon le désactiver
		gestionFactures.getAjouterButton().setEnabled(!"Tous".equals(idBienSelectionne) && !"Tout Type".equals(typeFacture));
	}


	/**
	 * Methode pour filtere les facture 
	 */
	public void filtrerFactures() throws SQLException {
		Collection<Facture> compteurs = daoFacture.findAll();
		String typeSelectionne = (String) gestionFactures.getTypefactureComboBox().getSelectedItem();
		String idBienSelectionne = (String) gestionFactures.getIdBienComboBox().getSelectedItem();

		List<Facture> compteursFiltres = new ArrayList<>();
		for (Facture compteur : compteurs) {
			boolean typeMatch = "Tout Type".equals(typeSelectionne) || typeSelectionne.equals(compteur.getTypeEntretien());
			boolean idBienMatch = "Tous".equals(idBienSelectionne) || idBienSelectionne.equals(compteur.getIdBienImm());

			//Affichage pour le debugging 
			logger.info("Type Selectionne: " + typeSelectionne);
			logger.info("IdBien Selectionne: " + idBienSelectionne);
			logger.info("Type Match: " + typeMatch);
			logger.info("IdBien Match: " + idBienMatch);

			if (typeMatch && idBienMatch) {
				compteursFiltres.add(compteur);
			}
		}

		//remplissage de la table avec les filtes 
		DefaultTableModel tableModel = (DefaultTableModel) gestionFactures.getTable().getModel();
		tableModel.setRowCount(0);

		for (Facture compteur : compteursFiltres) {
			tableModel.addRow(new Object[]{compteur.getIdFacture(), compteur.getSiren(),
					compteur.getPrix(), compteur.getTypeEntretien(),compteur.getDateFacture()});
		}
	}

}
