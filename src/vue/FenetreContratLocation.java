package vue;

import javax.swing.*;

import controle.GestionContratLocation;
import modele.BienImmobilier;
import modele.Locataire;

import java.awt.*;


public class FenetreContratLocation extends JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField champDateDebutContrat;
    private JTextField champMontant;
    private JTextField champMontantLoyer;
    private JTextField champDateVersementLoyer;
    private JTextField champDepotGarantie;
    private JTextField champDateRevision;
    private JTextField champPeriodicitePaiement;
    private JTextField champDateFinContrat;
    private JTextField champChargesProvisionnelles;
    private JTextField champIdICC;
    private JTextField champValeurICC;
    private JTextField champIdBienImm;
    private JTextField champDateEntree;
    private JTextField champDateSortie;
    private JTextField champCaution;
    private JButton ajouterLocataireButton;
    private BienImmobilier bienImmobilier;
    private Locataire locataire;
    private PageAjoutLocataire pageAjoutLocataire;
    private GestionContratLocation gestionClic;
    

    public FenetreContratLocation(BienImmobilier bienImmobilier, Locataire locataire) {
        // Initialiser les champs du bien immobilier et du locataire
        this.bienImmobilier = bienImmobilier;
        this.locataire = locataire;
        this.gestionClic= new GestionContratLocation(this,this.pageAjoutLocataire);

    	setBounds(0, 0, 550, 400);

        // Ajout des champs de texte
        champDateDebutContrat = new JTextField("DD-MM-YYYY", 15);
        champMontant=new JTextField(15);
        champMontantLoyer = new JTextField(15);
        champDateVersementLoyer = new JTextField("DD-MM-YYYY", 15);
        champDepotGarantie = new JTextField(15);
        champDateRevision = new JTextField("DD-MM-YYYY", 15);
        champPeriodicitePaiement = new JTextField(15);
        champDateFinContrat = new JTextField("DD-MM-YYYY", 15);
        champChargesProvisionnelles = new JTextField(15);
        champIdICC = new JTextField(15);
        champValeurICC = new JTextField(15);
        champIdBienImm = new JTextField(15);
        champDateEntree = new JTextField("DD-MM-YYYY", 15);
        champDateSortie = new JTextField("DD-MM-YYYY", 15);
        champCaution = new JTextField(15);
        
        ajouterLocataireButton = new JButton("Ajouter Locataire");
        ajouterLocataireButton.addActionListener(this.gestionClic);
            

        // Bouton pour fermer la fenêtre
        JButton btnFermer = new JButton("Fermer");
        btnFermer.addActionListener(this.gestionClic);
        
        
        // Utilisation d'un GridLayout avec deux colonnes
        getContentPane().setLayout(new GridLayout(0, 2, 5, 5));
        getContentPane().add(new JLabel("Date Début Contrat (DD-MM-YYYY):"));
        getContentPane().add(champDateDebutContrat);
        getContentPane().add(new JLabel("Montant du Loyer:"));
        getContentPane().add(champMontant);
        getContentPane().add(new JLabel("Montant du dernier Loyer:"));
        getContentPane().add(champMontantLoyer);
        getContentPane().add(new JLabel("Date Versement Loyer (DD-MM-YYYY):"));
        getContentPane().add(champDateVersementLoyer);
        getContentPane().add(new JLabel("Dépôt Garantie:"));
        getContentPane().add(champDepotGarantie);
        getContentPane().add(new JLabel("Date Révision:"));
        getContentPane().add(champDateRevision);
        getContentPane().add(new JLabel("Périodicité Paiement:"));
        getContentPane().add(champPeriodicitePaiement);
        getContentPane().add(new JLabel("Date Fin Contrat (DD-MM-YYYY):"));
        getContentPane().add(champDateFinContrat);
        getContentPane().add(new JLabel("Charges Provisionnelles:"));
        getContentPane().add(champChargesProvisionnelles);
        getContentPane().add(new JLabel("ID ICC:"));
        getContentPane().add(champIdICC);
        getContentPane().add(new Label("Valeur ICC:"));
        getContentPane().add(champValeurICC);
        getContentPane().add(new JLabel("ID Bien Imm:"));
        getContentPane().add(champIdBienImm);
        getContentPane().add(new JLabel("Date Entrée (DD-MM-YYYY):"));
        getContentPane().add(champDateEntree);
        getContentPane().add(new JLabel("Date Sortie (DD-MM-YYYY):"));
        getContentPane().add(champDateSortie);
        getContentPane().add(new JLabel("Caution:"));
        getContentPane().add(champCaution);
        getContentPane().add(ajouterLocataireButton);
        getContentPane().add(btnFermer);
        champIdBienImm.setText(bienImmobilier.getId_Bien_Imm());
    }
    
    //*****************************//
    //GETTERS ET SETTERS DES CHAMPS//
    //*****************************//
	public JTextField getChampDateDebutContrat() {
		return champDateDebutContrat;
	}

	public void setChampDateDebutContrat(JTextField champDateDebutContrat) {
		this.champDateDebutContrat = champDateDebutContrat;
	}

	public JTextField getChampMontant() {
		return champMontant;
	}

	public void setChampMontant(JTextField champMontant) {
		this.champMontant = champMontant;
	}

	public JTextField getChampMontantLoyer() {
		return champMontantLoyer;
	}

	public void setChampMontantDernierLoyer(JTextField champMontantDernierLoyer) {
		this.champMontantLoyer = champMontantDernierLoyer;
	}

	public JTextField getChampDateVersementLoyer() {
		return champDateVersementLoyer;
	}

	public void setChampDateVersementLoyer(JTextField champDateVersementLoyer) {
		this.champDateVersementLoyer = champDateVersementLoyer;
	}

	public JTextField getChampDepotGarantie() {
		return champDepotGarantie;
	}

	public void setChampDepotGarantie(JTextField champDepotGarantie) {
		this.champDepotGarantie = champDepotGarantie;
	}

	public JTextField getChampDateRevision() {
		return champDateRevision;
	}

	public void setChampDateRevision(JTextField champDateRevision) {
		this.champDateRevision = champDateRevision;
	}

	public JTextField getChampPeriodicitePaiement() {
		return champPeriodicitePaiement;
	}

	public void setChampPeriodicitePaiement(JTextField champPeriodicitePaiement) {
		this.champPeriodicitePaiement = champPeriodicitePaiement;
	}

	public JTextField getChampDateFinContrat() {
		return champDateFinContrat;
	}

	public void setChampDateFinContrat(JTextField champDateFinContrat) {
		this.champDateFinContrat = champDateFinContrat;
	}

	public JTextField getChampChargesProvisionnelles() {
		return champChargesProvisionnelles;
	}

	public void setChampChargesProvisionnelles(JTextField champChargesProvisionnelles) {
		this.champChargesProvisionnelles = champChargesProvisionnelles;
	}

	public JTextField getChampIdICC() {
		return champIdICC;
	}

	public void setChampIdICC(JTextField champIdICC) {
		this.champIdICC = champIdICC;
	}

	public JTextField getChampValeurICC() {
		return champValeurICC;
	}

	public void setChampValeurICC(JTextField champValeurICC) {
		this.champValeurICC = champValeurICC;
	}

	public JTextField getChampIdBienImm() {
		return champIdBienImm;
	}

	public void setChampIdBienImm(JTextField champIdBienImm) {
		this.champIdBienImm = champIdBienImm;
	}

	public JTextField getChampDateEntree() {
		return champDateEntree;
	}

	public void setChampDateEntree(JTextField champDateEntree) {
		this.champDateEntree = champDateEntree;
	}

	public JTextField getChampDateSortie() {
		return champDateSortie;
	}

	public void setChampDateSortie(JTextField champDateSortie) {
		this.champDateSortie = champDateSortie;
	}

	public JTextField getChampCaution() {
		return champCaution;
	}

	public void setChampCaution(JTextField champCaution) {
		this.champCaution = champCaution;
	}

	public JButton getAjouterLocataireButton() {
		return ajouterLocataireButton;
	}

	public void setAjouterLocataireButton(JButton ajouterLocataireButton) {
		this.ajouterLocataireButton = ajouterLocataireButton;
	}
	
	
	public String getLocataire() {
		return this.locataire.getId_Locataire();
	}
	
	public String getBien_Immo() {
		return this.bienImmobilier.getId_Bien_Imm();
	}
	
	    
	
    
    
    
    
}