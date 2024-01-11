package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modele.Batiment;
import modele.BienImmobilier;
import modele.Compteur;
import modele.ContratLocation;
import modele.Locataire;
import modele.Loyer;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoCompteur;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLocataire;
import modele.dao.DaoLoyer;
import modele.dao.requetes.RequeteSelectBienImmobilierById;
import vue.FenetreDetailsPropriete2; // Ajout de l'importation

public class GestionDetailPropriete2 implements ActionListener {

    private FenetreDetailsPropriete2 detailPropriete;
    private DaoBienImmobilier daoBienI;
    private DaoBatiment daoBat;
    private DaoCompteur daoCompteur;
    private DaoContratLocation daoContrat;
    private DaoLocataire daoLocataire;
    private DaoLoyer daoLoyer;
    

    public GestionDetailPropriete2(FenetreDetailsPropriete2 detailPropriete) {
        this.detailPropriete = detailPropriete;
        this.daoBienI = new DaoBienImmobilier();
        this.daoBat = new DaoBatiment();
        this.daoCompteur = new DaoCompteur();
        this.daoContrat = new DaoContratLocation();
        this.daoLocataire = new DaoLocataire();
        this.daoLoyer=new DaoLoyer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            switch (button.getText()) {
                case "Autre Section":
                    // Code à exécuter pour le bouton "Autre Section"
                    break;
                case "Annuler":
                    detailPropriete.dispose();
                    break;
            }
        }
        
    }
    public void afficherInfoLogement() throws SQLException {
    	String get = detailPropriete.getSelecteurIdBien();
    	BienImmobilier bienImmo = daoBienI.findById(get);
    	String nbBat = bienImmo.getId_Batiment();
    	Batiment bat = daoBat.findById(nbBat);
    	System.out.println(get);
    	System.out.println(nbBat);
    	
    	ContratLocation contratLoc =null;
    	
    	//informations du contrat à partir de l'id du bien
    	Collection<ContratLocation>contrats=new LinkedList<>();
    	
    	contrats=daoContrat.findAll();
    	
    	for (ContratLocation contrat:contrats) {
    		if (contrat.getIdBienImm().equals(get)) {
    			contratLoc=contrat;
    		}
    	}
    	
    	 

    	//Compteur compt = daoCompteur.findById(nbBat);
        String adresse = bat.getAdresse();
        String commentaire  = "";
        //String Compteur = compt.getTypeCompteur();
        //String ContratsServices = compt.getIdCompteur();
        String DateDebut = "";
        String DateFin ="";
        if(!(contratLoc==null)) {
         DateDebut = contratLoc.getDateDebutContrat();
         DateFin = contratLoc.getDateFinContrat();
         
       //recuperation des infos du locataire 
         Locataire locataire =daoLocataire.findById(contratLoc.getIdLocataire());
         
         //remplissage du tableau 
         DefaultTableModel tableModel = (DefaultTableModel)detailPropriete.getTableLocataire().getModel();
         tableModel.setRowCount(0);

         tableModel.addRow(new Object[]{locataire.getId_Locataire(),locataire.getNom()+locataire.getPrenom(),"xxx"});
         
        //recuperation des loyers
         Collection<Loyer>loyers=new LinkedList<>();
         loyers =daoLoyer.findByIds(contratLoc.getIdLocataire());
         
         //remplissage du tableau 
         DefaultTableModel tableModel_2 = (DefaultTableModel)detailPropriete.getTablePaiement().getModel();
         tableModel_2.setRowCount(0);
         
         for(Loyer loyer:loyers) {
         tableModel_2.addRow(new Object[]{loyer.getDatePaiement(),loyer.getMontantPaiement(),loyer.getTypePaiement()});
         }
        }
        
        
        String Equipements = bat.getEquip_Acces_Tech();
        String NombrePieces = ""+bienImmo.getNb_Piece();
        String StatutOccupation=daoBienI.estOccupe(bienImmo.getId_Bien_Imm());
        
        String Surface =""+ bienImmo.getSurface();
        String Type = bienImmo.getType_Bien();
        
        
        
        
        
     
    	detailPropriete.getChampAdresse().setText(adresse);
    	detailPropriete.getChampCommentaires().setText(commentaire);
    	detailPropriete.getChampCompteur().setText("Compteur");
    	detailPropriete.getChampContratsServices().setText(DateDebut);
    	detailPropriete.getChampDateDebut().setText(DateDebut);
    	detailPropriete.getChampDateFin().setText(DateFin);
    	detailPropriete.getChampEquipements().setText(Equipements);
    	detailPropriete.getChampNombrePieces().setText(NombrePieces);
    	detailPropriete.getChampStatutOccupation().setText(StatutOccupation);
    	detailPropriete.getChampSurface().setText(Surface);
    	detailPropriete.getChampType().setText(Type);
    	for(Locataire l:bienImmo.voirLocataires()) {
    		System.out.println(l.getPrenom());
    	}
    	


    }
}