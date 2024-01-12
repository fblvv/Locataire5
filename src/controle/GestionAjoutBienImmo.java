package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import modele.Assurance;
import modele.BienImmobilier;
import modele.dao.DaoAssurance;
import modele.dao.DaoBienImmobilier;
import vue.FenetreBien;

import java.util.logging.Logger;


public class GestionAjoutBienImmo implements ActionListener{
	private FenetreBien detailPropriete;
	private DaoBienImmobilier daoBienI;
	private DaoAssurance daoAssurance;
	private boolean insertion;
	private boolean insertion1;
	private Logger logger = Logger.getLogger(getClass().getName());


	public GestionAjoutBienImmo(FenetreBien detailPropriete) {
		this.detailPropriete = detailPropriete;
		this.daoBienI = new DaoBienImmobilier();
		this.daoAssurance= new DaoAssurance();
		this.insertion=false;
		this.insertion1=false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton button = (JButton) source;

			switch (button.getText()) {
			case "Valider":
				// Code à exécuter pour le bouton "Autre Section"
				ajouterBien();
				if (this.insertion) {
					ajouterAssurance(); 
					if (!this.insertion1) {
						supprimerBien();
					}
				}
				detailPropriete.dispose();
				break;

			case "Annuler":

				detailPropriete.dispose();
				break;
			default:
				break;
			}
		}
	}
	public void ajouterBien() {

		try {
			String idBienImm=	detailPropriete.getTextFieldIdBienImmobilier();
			double surface= Double.parseDouble(detailPropriete.getTextFieldSurface());
			String modeChauffage= detailPropriete.getTextFieldModeChauffage();
			String modeEau= detailPropriete.getTextFieldModeEau();
			int nbPiece= Integer.parseInt(detailPropriete.getTextFieldNbPiece());
			String typeBien= detailPropriete.getTextFieldTypeBien();
			String nomProprio= detailPropriete.getTextFieldNomProprio();
			String identifiant= detailPropriete.getTextFieldIdentifiant();
			String etage= detailPropriete.getTextFieldEtage();
			JComboBox<String> comboBoxLogement = detailPropriete.getComboBoxBatiment();
			String idBatiment = (String) comboBoxLogement.getSelectedItem();	

			BienImmobilier bienIm = new BienImmobilier(idBienImm, surface, modeChauffage, modeEau, nbPiece,
					typeBien, nomProprio, identifiant, etage,idBatiment);

			daoBienI.create(bienIm);
			this.insertion = true;
			logger.info("bien ajouté!");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}



	public void ajouterAssurance() {
		try {
			String numPolice = detailPropriete.getTextFieldNumeroPoliceObl();
			String tarifInitial = detailPropriete.getTextFieldTarifInitialObl();
			String typeAssurance = detailPropriete.getTextFieldTypeAssuranceObl();
			String dateEffetDebut = detailPropriete.getTextFieldDateDebutObl();
			String idBienImm=    detailPropriete.getTextFieldIdBienImmobilier();
			JComboBox<String> comboBoxLogement = detailPropriete.getComboBoxBatiment();
			String idBatiment = (String) comboBoxLogement.getSelectedItem();

			Assurance assurance = new Assurance(numPolice,tarifInitial, typeAssurance, dateEffetDebut,idBienImm,idBatiment);

			daoAssurance.create(assurance);
			this.insertion1=true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void supprimerBien() {

		try {
			String idBienImm=	detailPropriete.getTextFieldIdBienImmobilier();
			double surface= Double.parseDouble(detailPropriete.getTextFieldSurface());
			String modeChauffage= detailPropriete.getTextFieldModeChauffage();
			String modeEau= detailPropriete.getTextFieldModeEau();
			int nbPiece= Integer.parseInt(detailPropriete.getTextFieldNbPiece());
			String typeBien= detailPropriete.getTextFieldTypeBien();
			String nomProprio= detailPropriete.getTextFieldNomProprio();
			String identifiant= detailPropriete.getTextFieldIdentifiant();
			String etage= detailPropriete.getTextFieldEtage();
			JComboBox<String> comboBoxLogement = detailPropriete.getComboBoxBatiment();
			String idBatiment = (String) comboBoxLogement.getSelectedItem();	

			BienImmobilier bienIm = new BienImmobilier(idBienImm, surface, modeChauffage, modeEau, nbPiece,
					typeBien, nomProprio, identifiant, etage,idBatiment);

			daoBienI.delete(bienIm);
			this.insertion = true;
			logger.info("bien ajouté!");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}



}