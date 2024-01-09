package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modele.BienImmobilier;
import modele.Charges;
import modele.Compteur;
import modele.Facture;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoCharges;
import modele.dao.DaoFacture;
import vue.GestionFacture;

public class GestionGestionFactures implements ActionListener  {

    private GestionFacture gestionFactures;
    private DaoFacture daoFacture;
    private DaoBienImmobilier daoBienImmobilier;

    public GestionGestionFactures(GestionFacture gestionFactures) {
        this.gestionFactures = gestionFactures;
        this.daoFacture = new DaoFacture();
        this.daoBienImmobilier = new DaoBienImmobilier();
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
                            insererFacture();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    
                		break;
                case "Ajouter Facture":
                	ajouterReleve();
                case "Annuler":
                	gestionFactures.dispose();
                    break;
            }
        }
    }


    private void ajouterReleve() {
        DefaultTableModel model = (DefaultTableModel) gestionFactures.getTable().getModel();
        model.addRow(new Object[]{"", "", "", "", ""});
    }

    private void insererFacture() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) gestionFactures.getTable().getModel();
        int selectedRow = gestionFactures.getTable().getSelectedRow();

        // Assuming your columns are in the order of ID, Date, Type, Valeur, ID_Bien
        Object[] rowData = new Object[5];
        for (int i = 0; i < 5; i++) {
            rowData[i] = model.getValueAt(selectedRow, i);
        }
    	String idFacture = (String)rowData[0];
    	String Siren = (String)rowData[1];
    	Double prix = Double.parseDouble((String)rowData[2]);
    	String Type = (String)rowData[3];
    	String Date =(String)rowData[4];
        String idBienSelectionne = (String) gestionFactures.getIdBienComboBox().getSelectedItem();
        BienImmobilier bat = daoBienImmobilier.findById(idBienSelectionne);
        String idBat = bat.getId_Batiment();

    	
        Facture facture = new Facture(idFacture,Siren,prix,Type,Date,idBienSelectionne,idBat);

        daoFacture.create(facture);

        gestionFactures.afficherCompteurs();
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
