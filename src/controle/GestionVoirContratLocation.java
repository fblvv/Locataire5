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
}