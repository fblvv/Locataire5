package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modele.ContratLocation;
import modele.dao.DaoContratLocation;
import vue.VoirContratLocation;

public class GestionVoirContratLocation implements ActionListener {

	private VoirContratLocation contratLocataire;
	private DaoContratLocation daoContratLocation;


	public GestionVoirContratLocation(VoirContratLocation contratLocataire) {
		this.contratLocataire=contratLocataire;
		this.daoContratLocation = new DaoContratLocation();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton button = (JButton) source;

			switch (button.getText()) {
			case "Voir cette facture":


				try {
					afficherContratLoc();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "Annuler":
				contratLocataire.dispose();
				break;
			case "Modifier":
				modifLigne();
			default:
				break;
			} 
		}
	}

	public void afficherContratLoc() throws SQLException {
		Collection<ContratLocation> contratLocation = daoContratLocation.findAll();
		DefaultTableModel tableModel = (DefaultTableModel) contratLocataire.getTable().getModel();

		// Clear existing data from the table model
		tableModel.setRowCount(0);

		// Populate the table model with data
		for (ContratLocation contLoc : contratLocation) {

			// Add a new row if needed
			tableModel.addRow(new Object[] {contLoc.getIdLocataire(),contLoc.getDateDebutContrat(),contLoc.getMontant(),contLoc.getMontantLoyer(),
					contLoc.getDateVersementLoyer(),contLoc.getDateEntree(),contLoc.getDateSortie(),contLoc.getDepotDeGarantie(),
					contLoc.getDateRevision(),contLoc.getPeriodicitePaiement(),contLoc.getDateFinContrat(),contLoc.getChargesProvisionnelles(),
					contLoc.getIdICC(),contLoc.getCaution(),contLoc.getIdBienImm()});



		}
	}
	public void modifLigne() {
		DefaultTableModel tableModel = (DefaultTableModel) contratLocataire.getTable().getModel();
		int row = contratLocataire.getTable().getSelectedRow();
		String idLocataire =(String)tableModel.getValueAt(row, 0);
		String dateDebut =(String)tableModel.getValueAt(row, 1);
		double montant =(double)tableModel.getValueAt(row, 2);
		double montantLoyer =(double)tableModel.getValueAt(row, 3);
		String dateVersement =(String)tableModel.getValueAt(row, 4);
		String dateEntree =(String)tableModel.getValueAt(row, 5);
		String dateSortie =(String)tableModel.getValueAt(row, 6);
		String depotGarantie =(String)tableModel.getValueAt(row, 7);
		String dateRevison =(String)tableModel.getValueAt(row, 8);
		String periodicite =(String)tableModel.getValueAt(row, 9);
		String dateFinContrat =(String)tableModel.getValueAt(row, 10);
		double charges =(double)tableModel.getValueAt(row, 11);
		String valeurICC =(String)tableModel.getValueAt(row, 12);
		double caution =(double)tableModel.getValueAt(row, 13);
		String idBienImmo =(String)tableModel.getValueAt(row, 14);
		ContratLocation contratLocation = new ContratLocation(idLocataire,dateDebut,montant,montantLoyer,dateVersement,dateEntree,dateSortie,depotGarantie,dateRevison,periodicite,dateFinContrat,charges,valeurICC,caution,idBienImmo);
		try {
			daoContratLocation.update(contratLocation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}