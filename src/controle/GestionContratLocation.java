package controle;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.util.logging.Logger;


import modele.ContratLocation;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLocataire;
import modele.GenererContratDeLocation;
import vue.FenetreContratLocation;
import vue.FenetreAjoutLocataire;

public class GestionContratLocation implements ActionListener{

	private FenetreContratLocation contratLocation;
    private FenetreAjoutLocataire pageAjoutLocataire;
    private DaoContratLocation daoContrat;
    private DaoLocataire daoLocataire;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private ContratLocation contratActuel; // Ajout de l'attribut


	public GestionContratLocation(FenetreContratLocation contratLocation, FenetreAjoutLocataire pageAjoutLocataire) {
		this.contratLocation = contratLocation;
        this.pageAjoutLocataire = pageAjoutLocataire;
        this.daoContrat = new DaoContratLocation();
        this.daoLocataire = new DaoLocataire();
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
                        createContratLocation();
                        JOptionPane.showMessageDialog(contratLocation, "Locataire et contrat ajoutés avec succès");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Fermer":
                    contratLocation.dispose();
                    break;
                default:
                    break;
            }
        }
    }




	//*****************************************//
	//Methode pour creer le CONTRAT DE LOCATION//
	//*****************************************//

	private void createContratLocation() throws SQLException{

		String dateDebutContrat = contratLocation.getChampDateDebutContrat().getText();
		String montantText = contratLocation.getChampMontant().getText();
		double montant = montantText.isEmpty() ? 0.0 : Double.parseDouble(montantText);

		String montantLoyerText = contratLocation.getChampMontantLoyer().getText();
		double montantLoyer = montantLoyerText.isEmpty() ? 0.0 : Double.parseDouble(montantLoyerText);
		String dateVersementLoyer = contratLocation.getChampDateVersementLoyer().getText();
		String dateEntree = contratLocation.getChampDateEntree().getText();
		String dateSortie = contratLocation.getChampDateSortie().getText();
		String depotGarantie = contratLocation.getChampDepotGarantie().getText();
		String dateRevision = contratLocation.getChampDateRevision().getText();
		String periodicitePaiement = contratLocation.getChampPeriodicitePaiement().getText();
		String dateFinContrat = contratLocation.getChampDateFinContrat().getText();
		double chargesProvisionnelles = Double.parseDouble(contratLocation.getChampChargesProvisionnelles().getText());
		String idICC = contratLocation.getChampIdICC().getText();
		double caution = Double.parseDouble(contratLocation.getChampMontantLoyer().getText());
		String idBienImm = contratLocation.getChampIdBienImm().getText();


		String idLocataire=contratLocation.getLocataire();
		logger.info(idLocataire);

		ContratLocation contrat = new ContratLocation(idLocataire,dateDebutContrat,montant,montantLoyer,dateVersementLoyer,dateEntree,dateSortie,depotGarantie
				,dateRevision,periodicitePaiement,dateFinContrat,chargesProvisionnelles,idICC,caution,idBienImm);

		this.contratActuel = contrat;
		
		try {
			daoContrat.create(contrat);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Ajout de la génération du contrat PDF
        genererContratPDF(contratLocation.getLocataire());
    }

    private void genererContratPDF(String idLocataire) {
        // Utilisation de la classe GenererContratDeLocation pour générer le PDF
        GenererContratDeLocation genererContrat = new GenererContratDeLocation();
        genererContrat.genererPdf(idLocataire, this.contratActuel);

    }


	}






