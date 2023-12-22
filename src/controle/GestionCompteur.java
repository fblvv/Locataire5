package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Compteur;
import modele.dao.DaoCompteur;
import vue.FenetreCompteur;

public class GestionCompteur implements ActionListener {

    private FenetreCompteur fenetreCompteur;
    private DaoCompteur daoCompteur;
    public GestionCompteur(FenetreCompteur fenetreCompteur) {
        this.fenetreCompteur = fenetreCompteur;
        this.daoCompteur = new DaoCompteur();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            switch (button.getText()) {
            	case "Annuler":
	                fenetreCompteur.dispose();
	                break;
                case "Ajouter Relevé":
                    ajouterReleve();
                    break;
                case "Valider":
                	try {
            			filtrerCompteurs();
            		} catch (SQLException ex) {
            			// TODO Auto-generated catch block
            			ex.printStackTrace();
            		}
                    break;
            }
        }
    }

    // Méthode pour ajouter une ligne vierge à la table
    private void ajouterReleve() {
        // Exemple de données par défaut (à remplacer par vos propres valeurs par défaut)
        Object[] data = {"", "", "", ""};

        // Ajout de la ligne à la table
        DefaultTableModel model = (DefaultTableModel) fenetreCompteur.getTable().getModel();
        model.addRow(data);
    }
    
    
    
    public void filtrerCompteurs() throws SQLException {
    	Collection<Compteur> compteurs = daoCompteur.findAll();
        // Récupérer les valeurs sélectionnées dans les JComboBox
    	String typeSelectionne = (String) fenetreCompteur.getTypeCompteurComboBox().getSelectedItem();
        String idBienSelectionne = (String) fenetreCompteur.getIdBienComboBox().getSelectedItem();

        // Filtrer les compteurs en fonction des critères de sélection
        List<Compteur> compteursFiltres = new ArrayList<>();
        for (Compteur compteur : compteurs) {
            boolean typeMatch = "Tout Type".equals(typeSelectionne) || typeSelectionne.equals(compteur.getTypeCompteur());
            boolean idBienMatch = "Tous".equals(idBienSelectionne) || idBienSelectionne.equals(compteur.getIdBienImm());

            if (typeMatch && idBienMatch) {
                compteursFiltres.add(compteur);
            }
        }

        // Mettre à jour le modèle de la JTable avec les compteurs filtrés
        DefaultTableModel tableModel = (DefaultTableModel) fenetreCompteur.getTable().getModel();
        tableModel.setRowCount(0);

        for (Compteur compteur : compteursFiltres) {
            tableModel.addRow(new Object[]{compteur.getIdCompteur(), compteur.getDateReleve(), compteur.getTypeCompteur(),
                    compteur.getValeur(), compteur.getIdBienImm()});
        }
    }
    
    

    
}
