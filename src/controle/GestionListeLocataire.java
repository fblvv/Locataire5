package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import SQL.CictOracleDataSource;
import modele.ContratLocation;
import modele.GenererContratDeLocation;
import modele.Locataire;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLocataire;
import vue.FenetreDetailsPropriete2;
import vue.FenetreListeLocataire;

public class GestionListeLocataire implements ActionListener {

    private Logger logger = Logger.getLogger(getClass().getName());
    private FenetreListeLocataire listeLocataire;
    private DaoLocataire daoLocataire;

    public GestionListeLocataire(FenetreListeLocataire listeLocataire) {
        this.listeLocataire = listeLocataire;
        this.daoLocataire = new DaoLocataire();
        connectionBaseDonnee();
    }
    
	private void connectionBaseDonnee() {
		try {
			CictOracleDataSource.creerAcces("lrf4482a", "oracle");
		} catch (SQLException e) {
			e.printStackTrace();
			// Gérer l'erreur de connexion (peut-être afficher un message à l'utilisateur)
		}
	}

    public GestionListeLocataire(FenetreListeLocataire listeLocataire, JLayeredPane layeredPane) {
        this.listeLocataire = listeLocataire;
        this.daoLocataire = new DaoLocataire();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            switch (button.getText()) {
                case "Voir le bien":
				try {
					detailBien();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                    
                    break;
                case "Refresh":
                    try {
                        this.afficherLocataire();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    break;
                case "Supprimer":
                    this.supprimerLocTable();
                    break;

                case "Annuler":
                    listeLocataire.dispose();
                    break;

                case "Générer Contrat":
                    genererContratPourLocataireSelectionne();
                    break;
                default:
                    break;
            }
        }
    }

    public void afficherLocataire() throws SQLException {
        Collection<Locataire> locataires = daoLocataire.findAll();
        DefaultTableModel tableModel = (DefaultTableModel) listeLocataire.getTable().getModel();

        // Clear existing data from the table model
        tableModel.setRowCount(0);

        // Populate the table model with data
        int ligne = 0;
        for (Locataire loc : locataires) {
            if (tableModel.getRowCount() <= ligne) {
                // Add a new row if needed
                tableModel.addRow(new Object[0]);
            }

            tableModel.setValueAt(loc.getNom(), ligne, 0);
            tableModel.setValueAt(loc.getPrenom(), ligne, 1);
            tableModel.setValueAt(loc.getTelephone(), ligne, 2);
            tableModel.setValueAt(loc.getMail(), ligne, 3);
            tableModel.setValueAt(loc.getAdresse(), ligne, 4);
            tableModel.setValueAt(loc.getCode_Postal(), ligne, 5);

            ligne++;
        }
    }

    public void supprimerLocTable() {
        int selectedRow = listeLocataire.getTable().getSelectedRow();
        if (selectedRow != -1) {
            String nom = (String) listeLocataire.getTable().getValueAt(selectedRow, 0);
            String prenom = (String) listeLocataire.getTable().getValueAt(selectedRow, 1);
            String idLoc = nom + prenom;

            try {
                // Récupérer l'identifiant du locataire à partir du nom et du prénom
                Locataire locataireToDelete = daoLocataire.findById(idLoc);

                // Supprimer le locataire de la base de données
                daoLocataire.delete(locataireToDelete);
                logger.info("Locataire supprimé avec l'ID : " + idLoc);
                // Rafraîchir l'affichage de la liste des locataires
                this.afficherLocataire();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void genererContratPourLocataireSelectionne() {
        int selectedRow = listeLocataire.getTable().getSelectedRow();
        if (selectedRow != -1) {
            String nom = (String) listeLocataire.getTable().getValueAt(selectedRow, 0);
            String prenom = (String) listeLocataire.getTable().getValueAt(selectedRow, 1);
            String id = nom + prenom;
            try {
                GenererContratDeLocation genererContrat = new GenererContratDeLocation();
                genererContrat.genererPdf(id);
                logger.info("Contrat généré pour le locataire ID: " + id);
                logger.info(id);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(listeLocataire, "Erreur lors de la génération du contrat", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(listeLocataire, "Veuillez sélectionner un locataire", "Aucun locataire sélectionné", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void afficherFenetre(javax.swing.JInternalFrame fenetre, JLayeredPane layeredPane) {
        layeredPane.add(fenetre);
        fenetre.setVisible(true);
    }
    
    private void detailBien () throws SQLException {
    	FenetreDetailsPropriete2 fenetreDetail=new FenetreDetailsPropriete2();
    	int selectedRow = listeLocataire.getTable().getSelectedRow();
    	if (selectedRow != -1) {
    		String nom = (String) listeLocataire.getTable().getValueAt(selectedRow, 0);
            String prenom = (String) listeLocataire.getTable().getValueAt(selectedRow, 1);
            DaoLocataire daoLoc = new DaoLocataire();
            Collection<Locataire> locataires = daoLoc.findAll();
            Locataire monLoc=null;
            
            for (Locataire locataire : locataires) {
            	if(locataire.getNom().equals(nom) && locataire.getPrenom().equals(prenom)) {
            		monLoc=locataire;
            	}
            }
            
            
            String id = monLoc.getId_Locataire();
            DaoContratLocation daoContrat = new DaoContratLocation();
            ContratLocation contrat = daoContrat.findById(id);
            if (contrat!=null) {
            String bien = contrat.getIdBienImm();
            
           
            fenetreDetail.getSelecteur().setSelectedItem(bien);
            fenetreDetail.getGestionClic().afficherInfoLogement();
            
            afficherFenetre(fenetreDetail, listeLocataire.getLayeredPane());
            
            }
            
    	}
    }
}
