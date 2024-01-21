package modele;

public class Loyer {
    private String idLoyer;
    private double loyerCharges;
    private double charges;
    private String datePaiement;
    private double montantPaiement;
    private String typePaiement;
    private String idLocataire;
    private String dateDebutContrat;

    public Loyer(String idLoyer, double loyerCharges, double charges, String datePaiement, double montantPaiement,
            String typePaiement, String idLocataire, String dateDebutContrat) {
        this.idLoyer = idLoyer;
        this.loyerCharges = loyerCharges;
        this.charges = charges;
        this.datePaiement = datePaiement;
        this.montantPaiement = montantPaiement;
        this.typePaiement = typePaiement;
        this.idLocataire = idLocataire;
        this.dateDebutContrat = dateDebutContrat;
    }
    /**
     * Methode pour retourner l'identifiant du paiement de loyer
     */
    public String getIdLoyer() {
        return idLoyer;
    }

    /**
     * Methode pour retourner le montant total du loyer avec charges
     */
    public double getLoyerCharges() {
        return loyerCharges;
    }

    /**
     * Methode pour modifier le montant total du loyer avec charges
     */
    public void setLoyerCharges(double loyerCharges) {
        this.loyerCharges = loyerCharges;
    }

    /**
     * Methode pour retourner le montant des charges
     */
    public double getCharges() {
        return charges;
    }

    /**
     * Methode pour modifier le montant des charges
     */
    public void setCharges(double charges) {
        this.charges = charges;
    }

    /**
     * Methode pour retourner la date du paiement
     */
    public String getDatePaiement() {
        return datePaiement;
    }

    /**
     * Methode pour modifier la date du paiement
     */
    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement;
    }

    /**
     * Methode pour retourner le montant payé
     */
    public double getMontantPaiement() {
        return montantPaiement;
    }

    /**
     * Methode pour modifier le montant payé
     */
    public void setMontantPaiement(double montantPaiement) {
        this.montantPaiement = montantPaiement;
    }

    /**
     * Methode pour retourner le type de paiement
     */
    public String getTypePaiement() {
        return typePaiement;
    }

    /**
     * Methode pour modifier le type de paiement
     */
    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }

    /**
     * Methode pour retourner l'identifiant du locataire
     */
    public String getIdLocataire() {
        return idLocataire;
    }

    /**
     * Methode pour modifier l'identifiant du locataire
     */
    public void setIdLocataire(String idLocataire) {
        this.idLocataire = idLocataire;
    }

    /**
     * Methode pour retourner la date de début du contrat lié au paiement
     */
    public String getDateDebutContrat() {
        return dateDebutContrat;
    }

    /**
     * Methode pour modifier la date de début du contrat lié au paiement
     */
    public void setDateDebutContrat(String dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }
}
