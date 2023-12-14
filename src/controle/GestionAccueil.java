package controle;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;

import SQL.CictOracleDataSource;
import vue.Accueil;
import vue.Connexion;
import vue.FenetreBien;
import vue.FenetreDetailsPropriete2;
import vue.FenetreListeLocataire;
import vue.GestionFactureWindow2;
import vue.PageAjoutLocataire;

public class GestionAccueil implements ActionListener {
    private Accueil accueil;

    public GestionAccueil(Accueil accueil) {
        this.accueil = accueil;
        ConnectionBaseDonnee(); // Appel de la méthode d'initialisation de la connexion
    }
    
    
    private void ConnectionBaseDonnee() {
        try {
            CictOracleDataSource.creerAcces("lrf4482a", "oracle");
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur de connexion (peut-être afficher un message à l'utilisateur)
        }
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        JLayeredPane layeredPane = accueil.getLayeredPane();

        switch (menuItem.getText()) {
            case "Ajouter locataire":
                afficherFenetre(new PageAjoutLocataire(), layeredPane);
                break;
            case "Consulter locataire":
                afficherFenetre(new FenetreListeLocataire(), layeredPane);
                break;
            case "Ajouter logement":
                afficherFenetre(new FenetreBien(), layeredPane);
                break;
            case "Consulter logement":
                afficherFenetre(new FenetreDetailsPropriete2(), layeredPane);
                break;
            case "Liste des locataires":
                afficherFenetre(new FenetreListeLocataire(), layeredPane);
                break;
            case "Gestion factures":
            	//GestionFactureWindow2 test = new GestionFactureWindow2();
            	//layeredPane.add(test);
            	//test.setVisible(true);
	            afficherFenetre(new GestionFactureWindow2(), layeredPane);
	            break;
            case "Connexion":
                afficherFenetre(new Connexion(), layeredPane);
                break;
        }
    }
    
    private void afficherFenetre(javax.swing.JInternalFrame fenetre, JLayeredPane layeredPane) {
        layeredPane.add(fenetre);
        fenetre.setVisible(true);
    }
}
