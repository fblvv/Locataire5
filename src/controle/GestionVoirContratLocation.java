package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import modele.Batiment;
import modele.BienImmobilier;
import modele.ContratLocation;
import modele.Locataire;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLocataire;
import vue.FenetreListeLocataire;
import vue.PageAjoutLocataire;
import vue.VoirContratLocation;

public class GestionVoirContratLocation implements ActionListener {

    private VoirContratLocation contratLocataire;
    private DaoContratLocation daoContratLocation;


    public GestionVoirContratLocation(VoirContratLocation contratLocataire) {
    	this.contratLocataire=contratLocataire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            switch (button.getText()) {
                case "Voir cette facture":
				;
				
				try {
					afficherContratLoc();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                    break;
                case "Annuler":
                	contratLocataire.dispose();
                    break;
            }
        }
    }
    
    public void afficherContratLoc() throws SQLException {
		Collection<ContratLocation> ContratLocation = daoContratLocation.findAll();
        DefaultTableModel tableModel = (DefaultTableModel) contratLocataire.getTable().getModel();

        // Clear existing data from the table model
        tableModel.setRowCount(0);

        // Populate the table model with data
        int ligne = 0;
        for (ContratLocation contLoc : ContratLocation) {
            if (tableModel.getRowCount() <= ligne) {
                // Add a new row if needed
                tableModel.addRow(new Object[0]);
            }

            tableModel.setValueAt(contLoc.getIdLocataire(), ligne, 0);
            tableModel.setValueAt(contLoc.getDateDebutContrat(), ligne, 1);
            tableModel.setValueAt(contLoc.getMontant(), ligne, 2);
            tableModel.setValueAt(contLoc.getMontantLoyer(), ligne, 3);
            tableModel.setValueAt(contLoc.getDateVersementLoyer(), ligne, 4);
            tableModel.setValueAt(contLoc.getDateEntree(), ligne, 5);
            tableModel.setValueAt(contLoc.getDateSortie(), ligne, 6);
            tableModel.setValueAt(contLoc.getDepotDeGarantie(), ligne, 7);
            tableModel.setValueAt(contLoc.getDateRevision(), ligne, 8);
            tableModel.setValueAt(contLoc.getPeriodicitePaiement(), ligne, 9);
            tableModel.setValueAt(contLoc.getDateFinContrat(), ligne, 10);
            tableModel.setValueAt(contLoc.getChargesProvisionnelles(), ligne, 11);
            tableModel.setValueAt(contLoc.getIdICC(), ligne, 12);
            tableModel.setValueAt(contLoc.getValeurIcc(), ligne, 13);
            tableModel.setValueAt(contLoc.getCaution(), ligne, 14);
            tableModel.setValueAt(contLoc.getIdBienImm(), ligne, 15);
    

            ligne++;
        }
    }
}