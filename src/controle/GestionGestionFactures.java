package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modele.Charges;
import modele.Facture;
import modele.dao.DaoCharges;
import modele.dao.DaoFacture;
import vue.GestionFacture;

public class GestionGestionFactures implements ActionListener  {

    private GestionFacture gestionFactures;
    private DaoFacture daoFacture;

    public GestionGestionFactures(GestionFacture gestionFactures) {
        this.gestionFactures = gestionFactures;
        this.daoFacture = new DaoFacture();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton buttonValider = (JButton) source;

            switch (buttonValider.getText()) {
                case "Valider":
                	
                        try {
                            filtrerCompteurs();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    
                		break;
                case "Annuler":
                	gestionFactures.dispose();
                    break;
            }
        }
    }


    public void filtrerCompteurs() throws SQLException {
        Collection<Facture> compteurs = daoFacture.findAll();
        String typeSelectionne = (String) gestionFactures.getTypeCompteurComboBox().getSelectedItem();
        String idBienSelectionne = (String) gestionFactures.getIdBienComboBox().getSelectedItem();

        List<Facture> compteursFiltres = new ArrayList<>();
        for (Facture compteur : compteurs) {
            boolean typeMatch = "Tout Type".equals(typeSelectionne) || typeSelectionne.equals(compteur.getTypeEntretien());
            boolean idBienMatch = "Tous".equals(idBienSelectionne) || idBienSelectionne.equals(compteur.getIdBienImm());

            // For debugging purposes, print the filters and the matching condition
            System.out.println("Type Selectionne: " + typeSelectionne);
            System.out.println("IdBien Selectionne: " + idBienSelectionne);
            System.out.println("Type Match: " + typeMatch);
            System.out.println("IdBien Match: " + idBienMatch);

            if (typeMatch && idBienMatch) {
                compteursFiltres.add(compteur);
            }
        }

        // Update the table model directly
        DefaultTableModel tableModel = (DefaultTableModel) gestionFactures.getTable().getModel();
        tableModel.setRowCount(0);

        for (Facture compteur : compteursFiltres) {
            tableModel.addRow(new Object[]{compteur.getIdFacture(), compteur.getSiren(),
                    compteur.getPrix(), compteur.getTypeEntretien(),compteur.getDateFacture()});
        }
    }
    public static void main(String[] args) {
    }
}
