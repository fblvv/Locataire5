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

import modele.ContratLocation;
import modele.Entreprise;
import modele.dao.DaoEntreprise;
import vue.FenetreEntreprise;

public class GestionEntreprise implements ActionListener  {

	private Logger logger = Logger.getLogger(getClass().getName());

	private FenetreEntreprise entrepriseFenetre;
	private DaoEntreprise daoEntreprise;

	public GestionEntreprise(FenetreEntreprise entrepriseFenetre) {
		this.entrepriseFenetre = entrepriseFenetre;
		this.daoEntreprise = new DaoEntreprise();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton buttonValider = (JButton) source;

			switch (buttonValider.getText()) {
			case "Charger":
				try {
					afficherEntreprise();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "Annuler":
				entrepriseFenetre.dispose();
				break;
			default:
				break;
			}
		}
	}



	private void afficherEntreprise()throws SQLException {

		Collection<Entreprise> entreprises = daoEntreprise.findAll();
		DefaultTableModel tableModel = (DefaultTableModel) entrepriseFenetre.getTable().getModel();

		// Clear existing data from the table model
		tableModel.setRowCount(0);

		// Populate the table model with data
		for (Entreprise ent : entreprises) {

			// Add a new row if needed
			tableModel.addRow(new Object[] {ent.getSiren(),ent.getAdresse_Entreprise(),ent.getTel_Entreprise(),ent.getMail_Entreprise()});



		}
	
	}





	private void insererCharge() throws SQLException {}


	private void activerBoutonAjouter() {}



}
