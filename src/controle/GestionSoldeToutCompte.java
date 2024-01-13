package controle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import SQL.CictOracleDataSource;
import modele.Compteur;
import modele.ContratLocation;
import modele.Locataire;
import modele.dao.DaoCompteur;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLocataire;
import vue.FenetreCompteur;
import vue.FenetreSoldeToutCompte;

public class GestionSoldeToutCompte implements ActionListener {
	private Logger logger = Logger.getLogger(getClass().getName());
	private FenetreSoldeToutCompte fenetreSolde;
	private DaoCompteur daoCompteur;

	public GestionSoldeToutCompte(FenetreSoldeToutCompte fenetreRegularisation) {
		this.fenetreSolde = fenetreRegularisation;
		this.daoCompteur = new DaoCompteur();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton button = (JButton) source;

			switch (button.getText()) {
			case "Annuler":
				fenetreSolde.dispose();
				break;
			case "Générer le reçu":
				regulariser();
				break;
			default:
				break;
			}
		}
	}

	public void afficherInfoLocataire() throws SQLException {
		String idLocataire = fenetreSolde.getSelecteurIdLocataire();

		// Utilisez l'ID du locataire sélectionné pour récupérer les informations du locataire
		DaoLocataire daoLocataire = new DaoLocataire(); // Créez une instance de DaoLocataire
		Locataire locataire = daoLocataire.findById(idLocataire); // Appelez la méthode findById sur l'instance

		if (locataire != null) {
			// Vous pouvez maintenant accéder aux propriétés du locataire
			String nom = locataire.getNom();
			String prenom = locataire.getPrenom();
			// ...

			// Affichez ou utilisez les informations du locataire comme nécessaire
			logger.info("Nom du locataire : " + nom);
			logger.info("Prénom du locataire : " + prenom); 
		} else {
			logger.info("Locataire non trouvé pour l'ID : " + idLocataire); 
		}
		
		DaoContratLocation daoContrat = new DaoContratLocation();
		ContratLocation contrat = daoContrat.findById(locataire.getId_Locataire());
		if (contrat !=null) {
		fenetreSolde.getTextBien().setText(contrat.getIdBienImm());
		calculerSolde();
		}else {
		fenetreSolde.getTextBien().setText("");
		fenetreSolde.getTextRegularisation().setText("");
		}
		
		mettreAJourJTable(fenetreSolde.getTextBien().getText());
	}
	
	
	
	private void calculerSolde() {
        String idBien = fenetreSolde.getTextBien().getText();
        System.out.println("Voici l'id du bien"+idBien);
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        System.out.println("Voici la date" + date);

        try {
            // Préparez l'appel à la fonction SQL
            String sql = "{ ? = call function1(?, ?) }";
            CallableStatement callableStatement = CictOracleDataSource.getConnectionBD().prepareCall(sql);

            // Définissez les paramètres d'entrée
            callableStatement.registerOutParameter(1, Types.NUMERIC); // Paramètre de sortie
            callableStatement.setString(2, idBien);
            callableStatement.setDate(3, date);

            // Exécutez la fonction SQL
            callableStatement.execute();

            // Récupérez le résultat
            double resultat = callableStatement.getDouble(1);

            // Mettez à jour le champ de texte textSolde avec le résultat
            fenetreSolde.getTextRegularisation().setText(Double.toString(resultat));
            fenetreSolde.getTextRegularisation().setForeground(Color.GREEN);
            if (resultat<=0){
            	fenetreSolde.getTextRegularisation().setForeground(Color.RED);
            }
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	
	
	private void regulariser() {
        String idBien = fenetreSolde.getTextBien().getText();
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

        try {
            // Appeler la procédure PL/SQL
            CallableStatement callableStatement = CictOracleDataSource.getConnectionBD().prepareCall("{call regularisation_charges(?, ?)}");
            callableStatement.setString(1, idBien);
            callableStatement.setDate(2, date);
            callableStatement.execute();

            // Mettre à jour la JTable avec les nouvelles données
            mettreAJourJTable(idBien);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void mettreAJourJTable(String idBien) {
        try {
            // Effectuer la requête pour récupérer les données de la régularisation
            String sql = "SELECT * FROM regularisation WHERE idbien = ?";
            PreparedStatement preparedStatement = CictOracleDataSource.getConnectionBD().prepareStatement(sql);
            preparedStatement.setString(1, idBien);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Mettre à jour la JTable avec les nouvelles données
            DefaultTableModel model = (DefaultTableModel) fenetreSolde.getTable().getModel();
            model.setRowCount(0); // Effacer les données actuelles

            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getDate("date_regularisation"),"regu"+ resultSet.getString("idbien"),
                        "20%",
                        resultSet.getDouble("montant")
                        // Ajouter d'autres colonnes si nécessaire
                };
                model.addRow(rowData);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	
	
    
	
    
    

}
