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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modele.Compteur;
import modele.dao.DaoCompteur;
import vue.FenetreCompteur;

public class GestionCompteur implements ActionListener, ItemListener {

	private FenetreCompteur fenetreCompteur;
	private DaoCompteur daoCompteur;

	public GestionCompteur(FenetreCompteur fenetreCompteur) {
		this.fenetreCompteur = fenetreCompteur;
		this.daoCompteur = new DaoCompteur();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton button = (JButton) source;

			switch (button.getText()) {
			case "Annuler":
				fenetreCompteur.dispose();
				break;
			case "Ajouter Relevé":
				ajouterReleve();
				break;
			case "Valider":
				try {
					insererCompteur();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				break;
			default:
				break;
			}
		}
	}

	private void ajouterReleve() {
		DefaultTableModel model = (DefaultTableModel) fenetreCompteur.getTable().getModel();
		String typeCompteur = (String) fenetreCompteur.getTypeCompteurComboBox().getSelectedItem();
		String idBien = (String) fenetreCompteur.getIdBienComboBox().getSelectedItem();

		Object[] newRow = new Object[]{
				"sketuveux", 
				"YYYY-MM-DD", 
				"Tout Type".equals(typeCompteur) ? "" : typeCompteur, 
						"Integer", 
						"Tous".equals(idBien) ? "" : idBien
		};

		model.addRow(newRow);
	}



	private void insererCompteur() throws SQLException {
		DefaultTableModel model = (DefaultTableModel) fenetreCompteur.getTable().getModel();
		int selectedRow = fenetreCompteur.getTable().getSelectedRow();

		// Vérifier si une ligne est sélectionnée
		if (selectedRow >= 0) {
			// Assuming your columns are in the order of ID, Date, Type, Valeur, ID_Bien
			Object[] rowData = new Object[5];
			for (int i = 0; i < 5; i++) {
				rowData[i] = model.getValueAt(selectedRow, i);
			}
			String idCompteur = (String) rowData[0];
			String dateReleve = (String) rowData[1];
			String typeCompteur = (String) rowData[2];
			Double valeur = Double.parseDouble((String) rowData[3]);
			String idBienImm = (String) rowData[4];

			Compteur compteur = new Compteur(idCompteur, dateReleve, typeCompteur, valeur, idBienImm);

			daoCompteur.create(compteur);

			filtrerCompteurs();
		} else {
			JOptionPane.showMessageDialog(fenetreCompteur, "Aucune ligne sélectionnée. Veuillez sélectionner une ligne à insérer.", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// Handle the item state change event for comboboxes
		if (e.getSource() == fenetreCompteur.getTypeCompteurComboBox()
				|| e.getSource() == fenetreCompteur.getIdBienComboBox()) {
			try {
				filtrerCompteurs();
				activerBoutonAjouter();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}


	private void activerBoutonAjouter() {
		String idBienSelectionne = (String) fenetreCompteur.getIdBienComboBox().getSelectedItem();

		// Activer le bouton si un bien est sélectionné, sinon le désactiver
		fenetreCompteur.getAjouterButton().setEnabled(!"Tous".equals(idBienSelectionne));
	}

	public void filtrerCompteurs() throws SQLException {
		Collection<Compteur> compteurs = daoCompteur.findAll();
		String typeSelectionne = (String) fenetreCompteur.getTypeCompteurComboBox().getSelectedItem();
		String idBienSelectionne = (String) fenetreCompteur.getIdBienComboBox().getSelectedItem();

		List<Compteur> compteursFiltres = new ArrayList<>();
		for (Compteur compteur : compteurs) {
			boolean typeMatch = "Tout Type".equals(typeSelectionne) || typeSelectionne.equals(compteur.getTypeCompteur());
			boolean idBienMatch = "Tous".equals(idBienSelectionne) || idBienSelectionne.equals(compteur.getIdBienImm());

			if (typeMatch && idBienMatch) {
				compteursFiltres.add(compteur);
			}
		}

		// Update the table model directly
		DefaultTableModel tableModel = (DefaultTableModel) fenetreCompteur.getTable().getModel();
		tableModel.setRowCount(0);

		for (Compteur compteur : compteursFiltres) {
			tableModel.addRow(new Object[]{compteur.getIdCompteur(), compteur.getDateReleve(), compteur.getTypeCompteur(),
					compteur.getValeur(), compteur.getIdBienImm()});
		}
	}
}
