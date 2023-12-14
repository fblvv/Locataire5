package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import SQL.CictOracleDataSource;
import vue.Connexion;
import vue.Accueil;

public class GestionConnexion implements ActionListener{
    private Connexion connexion;
    private Boolean connect;

    public GestionConnexion(Connexion c) {
        this.connexion = c;
        this.connect = false;
    }
    public void actionPerformed(ActionEvent e) {
        JLayeredPane layeredPane = connexion.getLayeredPane();
        JMenu bou = (JMenu) e.getSource();
        switch (bou.getText()) {
        case "Connecter":
            Accueil fenetre = (Accueil) connexion.getTopLevelAncestor() ;
            String log = this.connexion.getValeurChLogin();
            String mdp = this.connexion.getValeurPasswordField();
            try {
                CictOracleDataSource.creerAcces(log, mdp);
                this.connect = true;
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(connexion, "Login ou mot de passe incorrect", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            }

            connexion.dispose();
            break;
        case "Annuler":
            connexion.dispose();
            break;
            }

    }
}