package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import modele.BienImmobilier;
import modele.dao.DaoBienImmobilier;
import vue.FenetreBien;

public class GestionAjoutBienImmo implements ActionListener{
	private FenetreBien detailPropriete;
    private DaoBienImmobilier daoBienI;

	public GestionAjoutBienImmo(FenetreBien detailPropriete) {
		this.detailPropriete = detailPropriete;
        this.daoBienI = new DaoBienImmobilier();	}

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



}