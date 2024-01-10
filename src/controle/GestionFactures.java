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
import javax.swing.table.DefaultTableModel;

import modele.BienImmobilier;
import modele.Charges;
import modele.Compteur;
import modele.Facture;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoCharges;
import modele.dao.DaoFacture;
import vue.FenetreFacture;

public class GestionFactures implements ActionListener , ItemListener  {

	private FenetreFacture gestionFactures;
	private DaoFacture daoFacture;
	private DaoBienImmobilier daoBienImmobilier;
	private Boolean ajouterLigne;

	public GestionFactures(FenetreFacture gestionFactures) {
		this.gestionFactures = gestionFactures;
		this.daoFacture = new DaoFacture();
		this.daoBienImmobilier = new DaoBienImmobilier();
		this.ajouterLigne = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton buttonValider = (JButton) source;

			switch (buttonValider.getText()) {
			case "Valider":
                try {
                    insererFacture();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
				break;
			case "Ajouter Facture":
				ajouterReleve();
				break;
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
		System.out.println(idBienSelectionne);
		BienImmobilier bat = daoBienImmobilier.findById(idBienSelectionne);
		String idBat = bat.getId_Batiment();
		System.out.println(idBat);


		Facture facture = new Facture(idFacture,Siren,prix,Type,Date,idBienSelectionne,idBat);

		daoFacture.create(facture);

		filtrerFactures();
	}

	
	
    @Override
    public void itemStateChanged(ItemEvent e) {
        // Handle the item state change event for comboboxes
        if (e.getSource() == gestionFactures.getTypefactureComboBox()
                || e.getSource() == gestionFactures.getIdBienComboBox()) {
            try {
                filtrerFactures();
                activerBoutonAjouter();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    private void activerBoutonAjouter() {
        String idBienSelectionne = (String) gestionFactures.getIdBienComboBox().getSelectedItem();
        
        // Activer le bouton si un bien est sélectionné, sinon le désactiver
        gestionFactures.getAjouterButton().setEnabled(!"Tous".equals(idBienSelectionne));
    }


	public void filtrerFactures() throws SQLException {
		Collection<Facture> compteurs = daoFacture.findAll();
		String typeSelectionne = (String) gestionFactures.getTypefactureComboBox().getSelectedItem();
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
