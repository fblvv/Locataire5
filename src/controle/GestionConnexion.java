package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JOptionPane;

import SQL.CictOracleDataSource;
import vue.Connexion;

public class GestionConnexion implements ActionListener{
	private Connexion connexion;
	public GestionConnexion(Connexion c) {
		this.connexion = c;
	}
	public void actionPerformed(ActionEvent e) {
		connexion.getLayeredPane();
		JMenu bou = (JMenu) e.getSource();
		switch (bou.getText()) {
		case "Connecter":
			connexion.getTopLevelAncestor();
			String log = this.connexion.getValeurChLogin();
			String mdp = this.connexion.getValeurPasswordField();
			try {
				CictOracleDataSource.creerAcces(log, mdp);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(connexion, "Login ou mot de passe incorrect", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}

			connexion.dispose();
			break;
		case "Annuler":
			connexion.dispose();
			break;
		default:
			break;
		}


	}
}