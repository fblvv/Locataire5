package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Logger;

import modele.ContratLocation;
import modele.Loyer;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLoyer;
import vue.FenetreLoyer;

public class GestionFenetreLoyer implements ActionListener {
	private FenetreLoyer fenetreloyer;
	private Logger logger = Logger.getLogger(getClass().getName());

	public GestionFenetreLoyer(FenetreLoyer fenetreloyer)  {
		this.fenetreloyer=fenetreloyer;

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton button = (JButton) source;

			switch (button.getText()) {
			case "Ajouter":
				ajouterLoyer();
				fenetreloyer.dispose();
				break;

			case "Annuler":
				fenetreloyer.dispose();
				break;
			default:
				break;
			}
		} else if (source instanceof JComboBox) {
			// Handle JComboBox selection change
			try {
				updateTableData();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}


	private void updateTableData() throws SQLException {
		// Get the selected tenant ID from the JComboBox
		
		String locataireId = fenetreloyer.getComboBoxLocataire();

		DaoContratLocation daoContrat= new DaoContratLocation();
		ContratLocation contratLoc = daoContrat.findById(locataireId);
		if (!(contratLoc==null)) {
		String dateContrat=contratLoc.getDateDebutContrat().substring(0,10);
		fenetreloyer.getTextFieldDateDebutContrat().setText(dateContrat);
		fenetreloyer.getBtnAjouter().setEnabled(true);
		}else {
		fenetreloyer.getTextFieldDateDebutContrat().setText("Aucun Contrat");
		fenetreloyer.getBtnAjouter().setEnabled(false);
		}
		DaoLoyer daoLoyer = new DaoLoyer();
		
		Collection<Loyer> loyers = daoLoyer.findByIds(locataireId);
		if (loyers.isEmpty()) {
			// If there are no rent records, clear the JTable
			DefaultTableModel model = (DefaultTableModel) fenetreloyer.getTableloyer().getModel();
			model.setRowCount(0);

		}else {
			updateJTable(loyers);
		}
	}

	// Add this method to update the JTable with new data
	private void updateJTable(Collection<Loyer> loyers) {
		// Clear existing data in the JTable
		DefaultTableModel model = (DefaultTableModel) fenetreloyer.getTableloyer().getModel();
		model.setRowCount(0);

		// Add new data to the JTable
		for (Loyer loyer : loyers) {
			model.addRow(new Object[] {
					loyer.getIdLoyer(),loyer.getLoyerCharges(),loyer.getCharges(),
					loyer.getDatePaiement(), loyer.getMontantPaiement(),loyer.getTypePaiement()
			});
		}
	}




	public void ajouterLoyer() {
		try {


			String idLoyer = fenetreloyer.getTextFieldIdLoyer();
			Double loyerMontant = Double.parseDouble(fenetreloyer.getTextFieldLoyerCharges());
			Double charges = Double.parseDouble(fenetreloyer.getTextFieldCharges());
			String datePaiement = fenetreloyer.getTextFieldDatePaiement();
			Double montant=  Double.parseDouble(fenetreloyer.getTextFieldMontantPaiement());
			String typePaiement = fenetreloyer.getComboBoxPaiement();
			String idLocataire = fenetreloyer.getComboBoxLocataire();
			String dateDebut = fenetreloyer.getTextFieldDateDebutContrat().getText();     

			Loyer loyer = new Loyer(idLoyer,loyerMontant,charges,datePaiement,montant,typePaiement,idLocataire,dateDebut);

			DaoLoyer daoLoyer = new DaoLoyer();
			daoLoyer.create(loyer);
			logger.info("loyer ajouté");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
