package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;

import modele.Batiment;
import modele.BienImmobilier;
import modele.Locataire;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoLocataire;
import vue.PageAjoutLocataire;

public class GestionPageAjoutLocataire implements ActionListener {

    private PageAjoutLocataire ajoutLocataire;
    private DaoLocataire daoLocataire;
    private DaoBienImmobilier daoBien;

    public GestionPageAjoutLocataire(PageAjoutLocataire ajoutLocataire) {
        this.ajoutLocataire = ajoutLocataire;
        this.daoLocataire = new DaoLocataire();
        this.daoBien = new DaoBienImmobilier();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            switch (button.getText()) {
                case "Valider":
				try {
					createLocataire();
					ajoutLocataire.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                    break;
                case "Annuler":
                    ajoutLocataire.dispose();
                    break;
            }
        }
    }

    private void createLocataire() throws SQLException {
        JComboBox<String> comboBoxLogement = ajoutLocataire.getComboBoxLogement();
        String bienId = (String) comboBoxLogement.getSelectedItem();

        System.out.println("Selected Batiment ID: " + bienId);

        DaoBienImmobilier daoBien = new DaoBienImmobilier();
        BienImmobilier logementSelectionne = daoBien.findById(bienId);
        
        String idBat = logementSelectionne.getId_Batiment();
        DaoBatiment daoBat = new DaoBatiment();
        Batiment bat = daoBat.findById(idBat);

            String adresse = bat.getAdresse();
            String codePostal = bat.getCodePostal();
        // Récupérer les valeurs des champs depuis PageAjoutLocataire
        String nom = ajoutLocataire.getChampNom();
        String prenom = ajoutLocataire.getChampPrenom();
        String telephone = ajoutLocataire.getChampTelephone().getText();
        String mail = ajoutLocataire.getChampMail();

        String id=nom+prenom;//id du locataire
        // Créer une instance de Locataire avec les valeurs récupérées
        Locataire locataire = new Locataire(id,nom, prenom, telephone, mail, adresse, codePostal);

        // Appeler la méthode create du DAO pour insérer le locataire dans la base de données
        DaoLocataire daoLocataire = new DaoLocataire();
        try {
			daoLocataire.create(locataire);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        ajouterLaListe(id,bienId);
		// Afficher un message de succès ou effectuer d'autres actions si nécessaire
		System.out.println("Locataire ajouté avec succès !");
    }
    
    
    public void ajouterLaListe (String idLocataire,String idBien) throws SQLException{
    	Locataire locataire = daoLocataire.findById(idLocataire);
    	BienImmobilier bien = daoBien.findById(idBien);
    	bien.ajoutLocataire(locataire);
    }
 }


