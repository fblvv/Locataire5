package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.ContratLocation;
import modele.Loyer;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLoyer;
import vue.FenetreRegulariserCharges;

public class GestionRegulariserCharges implements ActionListener {
    private FenetreRegulariserCharges regulariserCharges;
    
    public GestionRegulariserCharges(FenetreRegulariserCharges regulariserCharges) {
        this.regulariserCharges = regulariserCharges;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            switch (button.getText()) {
                case "Valider":
                    JOptionPane.showMessageDialog(regulariserCharges, "Contrat modifié avec succès !");
                    
                    break;
                case "Annuler":
                    regulariserCharges.dispose();
                    break;
                default:
                    break;
            }
        }
        

    }

	/**
	 * Methode pour afficher les ancienne valeurs
	 */
    public void afficherAnciennesValeurs() throws SQLException {
        DaoContratLocation daoContrat = new DaoContratLocation();
        
        DaoLoyer daoLoyer = new DaoLoyer();
        Collection<Loyer> loyers = daoLoyer.findByIds(regulariserCharges.getIdLocataire());
        Double sommeLoyers = 0.0;
        Integer mois=0;
        Double provisions =0.0;
        
        // Obtenez l'année actuelle
        int anneeActuelle = LocalDate.now().getYear();
        
        // Parcourez la liste des loyers
        for (Loyer loyer : loyers) {
        	// Obtenez l'année du paiement
        	int anneePaiement = AnneeDate(loyer.getDatePaiement());
        	
        	// Vérifiez si l'année de paiement est la même que l'année actuelle
        	if (anneePaiement == anneeActuelle) {
        		// Ajoutez le loyer à la somme
        		sommeLoyers += loyer.getCharges();
        		provisions = loyer.getCharges();
        		mois++;
        	}
        }
        double nouveauMontant = regulariserCharges.getMontantRegularisation()/mois;
        ContratLocation contrat = daoContrat.findById(regulariserCharges.getIdLocataire());
        if (contrat != null) {
            regulariserCharges.getChampAncienLoyer().setText(String.valueOf(contrat.getMontant()));
            regulariserCharges.getChampAnciennesCharges().setText(String.valueOf(contrat.getChargesProvisionnelles()));
            regulariserCharges.getChampNouvellesCharges().setText(String.valueOf(nouveauMontant));
        } else {
            regulariserCharges.getChampAncienLoyer().setText("");
            regulariserCharges.getChampAnciennesCharges().setText("");
        }
        
    }
    
	/**
	 * Methode pour le format de la date
	 */
    private int AnneeDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date.getYear();
    }
    
    
}
