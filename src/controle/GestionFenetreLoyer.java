package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
			//Mettre à jour le filtrage 
			try {
				filtrerTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}


	private void filtrerTable() throws SQLException {
		
		//Récupération de l'id du locataire dans la Jcombobox
		String locataireId = fenetreloyer.getComboBoxLocataire();

		DaoContratLocation daoContrat= new DaoContratLocation();
		ContratLocation contratLoc = daoContrat.findById(locataireId);
		if (!(contratLoc==null)) {
			
		String dateContrat=contratLoc.getDateDebutContrat().substring(0,10);
		
		DateTimeFormatter ancienformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter nouveauformat = DateTimeFormatter.ofPattern("dd/MM/yy");

        LocalDate dateDebutContrat = LocalDate.parse(dateContrat, ancienformat);
        String dateformat = dateDebutContrat.format(nouveauformat);

        fenetreloyer.getTextFieldDateDebutContrat().setText(dateformat);
		fenetreloyer.getLoyer().setText(String.valueOf(contratLoc.getMontant()));
		fenetreloyer.getCharges().setText(String.valueOf(contratLoc.getChargesProvisionnelles()));
		fenetreloyer.getBtnAjouter().setEnabled(true);
		}else {
		fenetreloyer.getTextFieldDateDebutContrat().setText("Aucun Contrat");
		fenetreloyer.getBtnAjouter().setEnabled(false);
		}
		DaoLoyer daoLoyer = new DaoLoyer();
		
		Collection<Loyer> loyers = daoLoyer.findByIds(locataireId);
		if (loyers.isEmpty()) {
			//si pas de loyers vider la table 
			DefaultTableModel model = (DefaultTableModel) fenetreloyer.getTableloyer().getModel();
			model.setRowCount(0);

		}else {
			updateJTable(loyers);
		}
	}

	//mise à jour des loyers par locataire
	private void updateJTable(Collection<Loyer> loyers) {
		//vider la table existante 
		DefaultTableModel model = (DefaultTableModel) fenetreloyer.getTableloyer().getModel();
		model.setRowCount(0);

		//completer la table avec les loyers
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
