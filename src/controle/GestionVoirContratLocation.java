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
                case "Valider":
				;
				contratLocataire.dispose();
                    break;
                case "Annuler":
                	contratLocataire.dispose();
                    break;
            }
        }
    }
    
    public void afficherLocataire() throws SQLException {
		Collection<ContratLocation> ContratLocation = daoContratLocation.findAll();
        DefaultTableModel tableModel = (DefaultTableModel) contratLocataire.getTable().getModel();

        // Clear existing data from the table model
        tableModel.setRowCount(0);

        // Populate the table model with data
        int ligne = 0;
        for (ContratLocation contLoc : locataires) {
            if (tableModel.getRowCount() <= ligne) {
                // Add a new row if needed
                tableModel.addRow(new Object[0]);
            }

            tableModel.setValueAt(loc.getNom(), ligne, 0);
            tableModel.setValueAt(loc.getPrenom(), ligne, 1);
            tableModel.setValueAt(loc.getTelephone(), ligne, 2);
            tableModel.setValueAt(loc.getMail(), ligne, 3);
            tableModel.setValueAt(loc.getAdresse(), ligne, 4);
            tableModel.setValueAt(loc.getCode_Postal(), ligne, 5);

            ligne++;
        }
    }
}