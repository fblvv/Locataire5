package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.ContratLocation;
import modele.Locataire;
import modele.Loyer;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLocataire;
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
                    JOptionPane.showMessageDialog(regulariserCharges, "Gestion de régularisation à finir");
                    break;
                case "Annuler":
                    regulariserCharges.dispose();
                    break;
                default:
                    break;
            }
        }
        
        // Vous pouvez appeler la méthode ici ou dans le constructeur, selon vos besoins
        // afficherAnciennesValeurs();
    }

    public void afficherAnciennesValeurs() throws SQLException {
        DaoLoyer daoLoyer = new DaoLoyer();
        Loyer loyer = daoLoyer.findById(locataire.getId_Locataire());
        if (loyer != null) {
            regulariserCharges.getChampAncienLoyer().setText(loyer.getMontantPaiement());
            regulariserCharges.getChampAnciennesCharges().setText(loyer.getLoyerCharges());
        } else {
            regulariserCharges.getChampAncienLoyer().setText("");
            regulariserCharges.getChampAnciennesCharges().setText("");
        }
    }
}
