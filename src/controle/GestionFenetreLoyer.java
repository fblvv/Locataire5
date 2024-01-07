package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import modele.Assurance;
import modele.Loyer;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoCompteur;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLoyer;
import vue.FenetreDetailsPropriete2;
import vue.FenetreLoyer;

public class GestionFenetreLoyer implements ActionListener {
	private FenetreLoyer fenetreloyer;
	
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
                    // Code à exécuter pour le bouton "Autre Section"
                	ajouterLoyer();
                	fenetreloyer.dispose();
                	
                    break;
                    
                case "Annuler":
                    fenetreloyer.dispose();
                    break;
            }
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
     String dateDebut = fenetreloyer.getTextFieldDateDebutContrat();     

     Loyer loyer = new Loyer(idLoyer,loyerMontant,charges,datePaiement,montant,typePaiement,idLocataire,dateDebut);
     	
     	DaoLoyer daoLoyer = new DaoLoyer();
         daoLoyer.create(loyer);
         System.out.println("loyer ajouté");
     } catch (SQLException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
     }
 }

}
