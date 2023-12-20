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

public class GestionAjoutBienImmo implements ActionListener{
	private FenetreBien detailPropriete;
    private DaoBienImmobilier daoBienI;
    private DaoAssurance daoAssurance;
    private boolean insertion;

	public GestionAjoutBienImmo(FenetreBien detailPropriete) {
		this.detailPropriete = detailPropriete;
        this.daoBienI = new DaoBienImmobilier();
        this.daoAssurance= new DaoAssurance();
        this.insertion=false;
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
                	detailPropriete.dispose();
                    break;
                    
                case "Annuler":
            
                	detailPropriete.dispose();
                    break;
            }
        }
	}
	public void ajouterBien() {
		
        try {
        String id_Bien_Imm=	detailPropriete.getTextFieldIdBienImmobilier();
        double surface= Double.parseDouble(detailPropriete.getTextFieldSurface());
        String mode_Chauffage= detailPropriete.getTextFieldModeChauffage();
        String mode_Eau= detailPropriete.getTextFieldModeEau();
        int nb_Piece= Integer.parseInt(detailPropriete.getTextFieldNbPiece());
        String type_Bien= detailPropriete.getTextFieldTypeBien();
        String nom_Proprio= detailPropriete.getTextFieldNomProprio();
        String identifiant= detailPropriete.getTextFieldIdentifiant();
        String etage= detailPropriete.getTextFieldEtage();
        JComboBox<String> comboBoxLogement = detailPropriete.getComboBoxBatiment();
        String id_Batiment = (String) comboBoxLogement.getSelectedItem();	
        
        BienImmobilier bienIm = new BienImmobilier(id_Bien_Imm, surface, mode_Chauffage, mode_Eau, nb_Piece,
        		type_Bien, nom_Proprio, identifiant, etage,id_Batiment);

			daoBienI.create(bienIm);
			System.out.println("bien ajouté!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	public void ajouterAss() {
        String numPolice = detailPropriete.getTextFieldNumeroPoliceObl();
        String tarifInitial = detailPropriete.getTextFieldTarifInitialObl();
        String typeAssurance = detailPropriete.getTextFieldTypeAssuranceObl();
        String dateEffetDebut = detailPropriete.getTextFieldDateDebutObl();
        String id_Bien_Imm=    detailPropriete.getTextFieldIdBienImmobilier();
        JComboBox<String> comboBoxLogement = detailPropriete.getComboBoxBatiment();
        String id_Batiment = (String) comboBoxLogement.getSelectedItem();

        Assurance ass = new Assurance(tarifInitial, typeAssurance, dateEffetDebut, numPolice,id_Bien_Imm,id_Batiment);
        try {
            daoAssurance.create(ass);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }



}