package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.logging.Logger;


import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modele.Charges;
import modele.dao.DaoCharges;
import vue.FenetreCharges;

public class GestionCharges implements ActionListener , ItemListener {

	private Logger logger = Logger.getLogger(getClass().getName());

	private FenetreCharges gestionCharges;
	private DaoCharges daocharge;

	public GestionCharges(FenetreCharges gestionCharges) {
		this.gestionCharges = gestionCharges;
		this.daocharge = new DaoCharges();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton buttonValider = (JButton) source;

			switch (buttonValider.getText()) {
			case "Valider":

				try {
					insererCharge();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				break;

			case "Ajouter Charge":
				ajouterReleve();
				break;
			case "Annuler":
				gestionCharges.dispose();
				break;
			default:
				break;
			}
		}
	}


	/**
	 * Ajoute une ligne en plus sur la table pour un potentiel insert 
	 */
	private void ajouterReleve() {		
		String typecharge = (String) gestionCharges.getTypeCompteurComboBox().getSelectedItem();
		DefaultTableModel model = (DefaultTableModel) gestionCharges.getTable().getModel();
		model.addRow(new Object[]{"", "", "", typecharge, ""});	
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == gestionCharges.getTypeCompteurComboBox()
				|| e.getSource() == gestionCharges.getIdBienComboBox()) {
			try {
				filtrerCharges();
				activerBoutonAjouter();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}


	/**
	 * Ajoute d'une charge a la suite d'un ajout d'une ligne
	 */
	private void insererCharge() throws SQLException {
		DefaultTableModel model = (DefaultTableModel) gestionCharges.getTable().getModel();
		int selectedRow = gestionCharges.getTable().getSelectedRow();

		// Ajouter une charge avec les infromations : ID, Date, Type, Valeur, ID_Bien
		Object[] rowData = new Object[5];
		for (int i = 0; i < 5; i++) {
			rowData[i] = model.getValueAt(selectedRow, i);
		}
		String idCharge = (String)rowData[0];
		Double montant = Double.parseDouble((String)rowData[1]);
		String date  = (String)rowData[2];
		String type = (String)rowData[3];
		String pourcentage = (String)rowData[4];

		String idBienSelectionne = (String) gestionCharges.getIdBienComboBox().getSelectedItem();
		logger.info(idBienSelectionne);



		Charges charge = new Charges(idCharge,idBienSelectionne,montant,date,type,pourcentage);

		this.daocharge.create(charge);

		filtrerCharges();
	}

	/**
	 * Active les bouton
	 */
	private void activerBoutonAjouter() {
		String idBienSelectionne = (String) gestionCharges.getIdBienComboBox().getSelectedItem();
		String typecharge = (String) gestionCharges.getTypeCompteurComboBox().getSelectedItem();


		// Activer le bouton si un bien est sélectionné, sinon le désactiver
		gestionCharges.getAjouterButton().setEnabled(!"Tous".equals(idBienSelectionne) && !"Tout Type".equals(typecharge));
	}

	/**
	 * Filtres des charges suivant les types et 
	 * et du comboBox 
	 */
	public void filtrerCharges() throws SQLException {
		Collection<Charges> charges = daocharge.findAll();
		String typeSelectionne = (String) gestionCharges.getTypeCompteurComboBox().getSelectedItem();
		String idBienSelectionne = (String) gestionCharges.getIdBienComboBox().getSelectedItem();

		List<Charges> chargesFiltres = new ArrayList<>();
		for (Charges charge : charges) {
			boolean typeMatch = "Tout Type".equals(typeSelectionne) || typeSelectionne.equals(charge.getTypeCharge());
			boolean idBienMatch = "Tous".equals(idBienSelectionne) || idBienSelectionne.equals(charge.getIdBienImm());



			if (typeMatch && idBienMatch) {
				chargesFiltres.add(charge);
			}
		}

		//Remplissage du tableau 
		DefaultTableModel tableModel = (DefaultTableModel) gestionCharges.getTable().getModel();
		tableModel.setRowCount(0);

		for (Charges charge : chargesFiltres) {
			tableModel.addRow(new Object[]{charge.getIdCharges(), charge.getMontant(),
					charge.getDateCharge(), charge.getTypeCharge(),charge.getPourcentagePartEntretien()});
		}
	}

}
