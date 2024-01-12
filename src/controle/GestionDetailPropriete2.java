package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import java.util.logging.Logger;


import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modele.Batiment;
import modele.BienImmobilier;
import modele.ContratLocation;
import modele.Locataire;
import modele.Loyer;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLocataire;
import modele.dao.DaoLoyer;
import vue.FenetreDetailsPropriete2; // Ajout de l'importation

public class GestionDetailPropriete2 implements ActionListener {

	private Logger logger = Logger.getLogger(getClass().getName());
	private FenetreDetailsPropriete2 detailPropriete;
	private DaoBienImmobilier daoBienI;
	private DaoBatiment daoBat;
	private DaoContratLocation daoContrat;
	private DaoLocataire daoLocataire;
	private DaoLoyer daoLoyer;


	public GestionDetailPropriete2(FenetreDetailsPropriete2 detailPropriete) {
		this.detailPropriete = detailPropriete;
		this.daoBienI = new DaoBienImmobilier();
		this.daoBat = new DaoBatiment();
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
			default:
				break;
			}
		}

	}
	public void afficherInfoLogement() throws SQLException {
		String get = detailPropriete.getSelecteurIdBien();
		BienImmobilier bienImmo = daoBienI.findById(get);
		String nbBat = bienImmo.getId_Batiment();
		Batiment bat = daoBat.findById(nbBat);
		logger.info(get);
		logger.info(nbBat);

		ContratLocation contratLoc =null;

		//informations du contrat à partir de l'id du bien
		Collection<ContratLocation>contrats=new LinkedList<>();

		contrats=daoContrat.findAll();

		for (ContratLocation contrat:contrats) {
			if (contrat.getIdBienImm().equals(get)) {
				contratLoc=contrat;
			}
		}

		String adresse = bat.getAdresse();
		String commentaire  = "";
		String dateDebut = "";
		String dateFin ="";
		if(contratLoc!=null) {
			dateDebut = contratLoc.getDateDebutContrat();
			dateFin = contratLoc.getDateFinContrat();

			//recuperation des infos du locataire 
			Locataire locataire =daoLocataire.findById(contratLoc.getIdLocataire());

			//remplissage du tableau 
			DefaultTableModel tableModel = (DefaultTableModel)detailPropriete.getTableLocataire().getModel();
			tableModel.setRowCount(0);

			tableModel.addRow(new Object[]{locataire.getId_Locataire(),locataire.getNom()+" "+locataire.getPrenom(),"xxx"});

			//recuperation des loyers
			Collection<Loyer>loyers=new LinkedList<>();
			loyers =daoLoyer.findByIds(contratLoc.getIdLocataire());

			//remplissage du tableau 
			DefaultTableModel tableMode2 = (DefaultTableModel)detailPropriete.getTablePaiement().getModel();
			tableMode2.setRowCount(0);

			for(Loyer loyer:loyers) {
				tableMode2.addRow(new Object[]{loyer.getDatePaiement(),loyer.getMontantPaiement(),loyer.getTypePaiement()});
			}
		}


		String equipements = bat.getEquip_Acces_Tech();
		String nombrePieces = ""+bienImmo.getNb_Piece();
		String statutOccupation=daoBienI.estOccupe(bienImmo.getId_Bien_Imm());

		String surface =""+ bienImmo.getSurface();
		String type = bienImmo.getType_Bien();






		detailPropriete.getChampAdresse().setText(adresse);
		detailPropriete.getChampCommentaires().setText(commentaire);
		detailPropriete.getChampCompteur().setText("Compteur");
		detailPropriete.getChampContratsServices().setText(dateDebut);
		detailPropriete.getChampDateDebut().setText(dateDebut);
		detailPropriete.getChampDateFin().setText(dateFin);
		detailPropriete.getChampEquipements().setText(equipements);
		detailPropriete.getChampNombrePieces().setText(nombrePieces);
		detailPropriete.getChampStatutOccupation().setText(statutOccupation);
		detailPropriete.getChampSurface().setText(surface);
		detailPropriete.getChampType().setText(type);
		for(Locataire l:bienImmo.voirLocataires()) {
			logger.info(l.getPrenom());
		}



	}
}