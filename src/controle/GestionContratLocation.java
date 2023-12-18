package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import modele.Batiment;
import modele.BienImmobilier;
import modele.ContratLocation;
import modele.Locataire;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoLocataire;
import modele.dao.DaoContratLocation;
import vue.FenetreContratLocation;
import vue.PageAjoutLocataire;
import controle.GestionPageAjoutLocataire;

public class GestionContratLocation implements ActionListener{
	
	private FenetreContratLocation contratLocation;
	private PageAjoutLocataire ajoutLocataire;
	private DaoLocataire daoLocataire;
	private DaoContratLocation daoContrat;
    private DaoBienImmobilier daoBien;

	public GestionContratLocation(FenetreContratLocation contratLocation, PageAjoutLocataire ajoutLocataire) {
		this.contratLocation=contratLocation;
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
                case "Ajouter Locataire":
				try {
					JLayeredPane layeredPane = contratLocation.getLayeredPane();
					createLocataire();
					createContratLocation();
					JOptionPane.showMessageDialog(contratLocation, "Locataire et contrat ajoutés avec succès");
					//ajoutLocataire.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                    break;
                case "Fermer":
                    contratLocation.dispose();
                    break;
            }
        }
        
    }
	
	//*****************************//
    //Methode pour creer le LOCATAIRE//
    //*****************************//
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
        
        ajouterLaListeLocataire(id,bienId);
		// Afficher un message de succès ou effectuer d'autres actions si nécessaire
		System.out.println("Locataire ajouté avec succès !");
    }
	
	public void ajouterLaListeLocataire (String idLocataire,String idBien) throws SQLException{
    	Locataire locataire = daoLocataire.findById(idLocataire);
    	BienImmobilier bien = daoBien.findById(idBien);
    	bien.ajoutLocataire(locataire);
    }
	
	
	//*****************************************//
    //Methode pour creer le CONTRAT DE LOCATION//
    //*****************************************//
	
	private void createContratLocation() throws SQLException{
		
		String dateDebutContrat = contratLocation.getChampDateDebutContrat().getText();
	    double montant = Double.parseDouble(contratLocation.getChampMontant().getText());
	    double montantDernierLoyer = Double.parseDouble(contratLocation.getChampMontantDernierLoyer().getText());
	    String dateVersementLoyer = contratLocation.getChampDateVersementLoyer().getText();
	    String depotGarantie = contratLocation.getChampDepotGarantie().getText();
	    String dateRevision = contratLocation.getChampDateRevision().getText();
	    String periodicitePaiement = contratLocation.getChampPeriodicitePaiement().getText();
	    String dateFinContrat = contratLocation.getChampDateFinContrat().getText();
	    double chargesProvisionnelles = Double.parseDouble(contratLocation.getChampChargesProvisionnelles().getText());
	    String idICC = contratLocation.getChampIdICC().getText();
	    String valeurICC = contratLocation.getChampValeurICC().getText();
	    String idBienImm = contratLocation.getChampIdBienImm().getText();
	    
	    String id= dateDebutContrat;
	    
	    ContratLocation contrat = new ContratLocation(id,montant,montantDernierLoyer,dateVersementLoyer,depotGarantie
	    		,dateRevision,periodicitePaiement,dateFinContrat,chargesProvisionnelles,idICC,valeurICC,idBienImm);

	    
	    DaoContratLocation daoContrat = new DaoContratLocation();
	    try {
	    	daoContrat.create(contrat);
	    }catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    
	}
	    
	    
	}
	


