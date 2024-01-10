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

import modele.BienImmobilier;
import modele.Charges;
import modele.Facture;
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
            }
        }
    }
    
    
    
    private void ajouterReleve() {		
	    DefaultTableModel model = (DefaultTableModel) gestionCharges.getTable().getModel();
	    model.addRow(new Object[]{"", "", "", "", ""});	
	}
    
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        // Handle the item state change event for comboboxes
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
    
    
    private void insererCharge() throws SQLException {
		DefaultTableModel model = (DefaultTableModel) gestionCharges.getTable().getModel();
		int selectedRow = gestionCharges.getTable().getSelectedRow();

		// Assuming your columns are in the order of ID, Date, Type, Valeur, ID_Bien
		Object[] rowData = new Object[5];
		for (int i = 0; i < 5; i++) {
			rowData[i] = model.getValueAt(selectedRow, i);
		}
		String idCharge = (String)rowData[0];
		Double montant = Double.parseDouble((String)rowData[1]);
		String date  = (String)rowData[2];
		String type = (String)rowData[3];
		String pourcentage = (String)rowData[3];

		String idBienSelectionne = (String) gestionCharges.getIdBienComboBox().getSelectedItem();
		System.out.println(idBienSelectionne);


		Charges charge = new Charges(idCharge,idBienSelectionne,montant,date,type,pourcentage);

		this.daocharge.create(charge);

		filtrerCharges();
	}
    
    
    private void activerBoutonAjouter() {
        String idBienSelectionne = (String) gestionCharges.getIdBienComboBox().getSelectedItem();
        
        // Activer le bouton si un bien est sélectionné, sinon le désactiver
        gestionCharges.getAjouterButton().setEnabled(!"Tous".equals(idBienSelectionne));
    }


    public void filtrerCharges() throws SQLException {
        Collection<Charges> charges = daocharge.findAll();
        String typeSelectionne = (String) gestionCharges.getTypeCompteurComboBox().getSelectedItem();
        String idBienSelectionne = (String) gestionCharges.getIdBienComboBox().getSelectedItem();

        List<Charges> chargesFiltres = new ArrayList<>();
        for (Charges charge : charges) {
            boolean typeMatch = "Tout Type".equals(typeSelectionne) || typeSelectionne.equals(charge.getTypeCharge());
            boolean idBienMatch = "Tous".equals(idBienSelectionne) || idBienSelectionne.equals(charge.getIdBienImm());

            // For debugging purposes, print the filters and the matching condition
            System.out.println("Type Selectionne: " + typeSelectionne);
            System.out.println("IdBien Selectionne: " + idBienSelectionne);
            System.out.println("Type Match: " + typeMatch);
            System.out.println("IdBien Match: " + idBienMatch);

            if (typeMatch && idBienMatch) {
                chargesFiltres.add(charge);
            }
        }

        // Update the table model directly
        DefaultTableModel tableModel = (DefaultTableModel) gestionCharges.getTable().getModel();
        tableModel.setRowCount(0);

        for (Charges charge : chargesFiltres) {
            tableModel.addRow(new Object[]{charge.getIdCharges(), charge.getMontant(),
                    charge.getDateCharge(), charge.getTypeCharge(),charge.getPourcentagePartEntretien()});
        }
    }
    public static void main(String[] args) {
    }
}
