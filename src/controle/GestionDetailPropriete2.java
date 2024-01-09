package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modele.Batiment;
import modele.BienImmobilier;
import modele.Compteur;
import modele.ContratLocation;
import modele.Locataire;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoCompteur;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLocataire;
import modele.dao.requetes.RequeteSelectBienImmobilierById;
import vue.FenetreDetailsPropriete2; // Ajout de l'importation

public class GestionDetailPropriete2 implements ActionListener {

    private FenetreDetailsPropriete2 detailPropriete;
    private DaoBienImmobilier daoBienI;
    private DaoBatiment daoBat;
    private DaoCompteur daoCompteur;
    private DaoContratLocation daoContrat;


    public GestionDetailPropriete2(FenetreDetailsPropriete2 detailPropriete) {
        this.detailPropriete = detailPropriete;
        this.daoBienI = new DaoBienImmobilier();
        this.daoBat = new DaoBatiment();
        this.daoCompteur = new DaoCompteur();
        this.daoContrat = new DaoContratLocation();
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
    	//ContratLocation contratLoc = daoContrat.findById(bienImmo.getId_Bien_Imm());
    	//Compteur compt = daoCompteur.findById(nbBat);
        String adresse = bat.getAdresse();
        String commentaire  = "";
        //String Compteur = compt.getTypeCompteur();
        //String ContratsServices = compt.getIdCompteur();
        //String DateDebut = contratLoc.getDateDebutContrat();
        //String DateFin = contratLoc.getDateFinContrat();
        String Equipements = bat.getEquip_Acces_Tech();
        String NombrePieces = ""+bienImmo.getNb_Piece();
        String StatutOccupation=daoBienI.estOccupe(bienImmo.getId_Bien_Imm());
        
        String Surface =""+ bienImmo.getSurface();
        String Type = bienImmo.getType_Bien();
        
    	detailPropriete.getChampAdresse().setText(adresse);
    	detailPropriete.getChampCommentaires().setText(commentaire);
    	detailPropriete.getChampCompteur().setText("Compteur");
    	detailPropriete.getChampContratsServices().setText("Contrat");
    	detailPropriete.getChampDateDebut().setText("debut");
    	detailPropriete.getChampDateFin().setText("fin");
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