package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;


import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


import modele.Entreprise;
import modele.dao.DaoEntreprise;
import vue.FenetreEntreprise;

public class GestionEntreprise implements ActionListener  {

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
					// appele de la methode affichage entreprise
					afficherEntreprise();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "Fermer":
				entrepriseFenetre.dispose();
				break;
			default:
				break;
			}
		}
	}



	/**
	 * affiche une entreprise
	 */
	private void afficherEntreprise()throws SQLException {

		Collection<Entreprise> entreprises = daoEntreprise.findAll();
		DefaultTableModel tableModel = (DefaultTableModel) entrepriseFenetre.getTable().getModel();

		// Nettoyage table
		tableModel.setRowCount(0);

		// Remplir la table
		for (Entreprise ent : entreprises) {

			// Ajout nouvelle ligne
			tableModel.addRow(new Object[] {ent.getSiren(),ent.getAdresse(),ent.getTel(),ent.getNom()});



		}
	
	}

}