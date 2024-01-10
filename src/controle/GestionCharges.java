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
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import modele.Charges;
import modele.Compteur;
import modele.dao.DaoCharges;
import vue.FenetreCharges;
import vue.FenetreFacture;

public class GestionCharges implements ActionListener , ItemListener {

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
                            filtrerCompteurs();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    
                		break;
                case "Annuler":
                	gestionCharges.dispose();
                    break;
            }
        }
    }
    
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        // Handle the item state change event for comboboxes
        if (e.getSource() == gestionCharges.getTypeCompteurComboBox()
                || e.getSource() == gestionCharges.getIdBienComboBox()) {
            try {
                filtrerCompteurs();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void filtrerCompteurs() throws SQLException {
        Collection<Charges> compteurs = daocharge.findAll();
        String typeSelectionne = (String) gestionCharges.getTypeCompteurComboBox().getSelectedItem();
        String idBienSelectionne = (String) gestionCharges.getIdBienComboBox().getSelectedItem();

        List<Charges> compteursFiltres = new ArrayList<>();
        for (Charges compteur : compteurs) {
            boolean typeMatch = "Tout Type".equals(typeSelectionne) || typeSelectionne.equals(compteur.getTypeCharge());
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
        DefaultTableModel tableModel = (DefaultTableModel) gestionCharges.getTable().getModel();
        tableModel.setRowCount(0);

        for (Charges compteur : compteursFiltres) {
            tableModel.addRow(new Object[]{compteur.getIdCharges(), compteur.getMontant(),
                    compteur.getDateCharge(), compteur.getTypeCharge(),compteur.getPourcentagePartEntretien()});
        }
    }
    public static void main(String[] args) {
    }
}
