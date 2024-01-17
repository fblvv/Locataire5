package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.Entreprise;

import modele.dao.DaoEntreprise;

import vue.FenetreEntreprise;

public class GestionEntreprise implements ActionListener {

    private FenetreEntreprise entrepriseFenetre;

    public GestionEntreprise(FenetreEntreprise entrepriseFenetre) {
        this.entrepriseFenetre = entrepriseFenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            switch (button.getText()) {
                case "Valider":
                    ajouterEntreprise();
                    entrepriseFenetre.dispose();
                    break;

                case "Annuler":
                	entrepriseFenetre.dispose();
                    break;
                default:
                    break;
            }
        }
    }

    // Vérification que les champs sont correctement écrits
    public void ajouterEntreprise() {
    	 try {
            String nomSiren = entrepriseFenetre.getSiren();
            String nomAdresse = entrepriseFenetre.getAdresse();
            String tel = entrepriseFenetre.getTel();
            String nom = entrepriseFenetre.getNom();

            Entreprise entreprise = new Entreprise(nomSiren, nomAdresse, tel, nom);

            DaoEntreprise daoEntreprise = new DaoEntreprise();
            daoEntreprise.create(entreprise);

            Logger logger = Logger.getLogger(getClass().getName());
            logger.info("Entreprise ajoutée avec succès !");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'entreprise : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
