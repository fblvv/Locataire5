package modele;

public class ContratLocation {
    private String idLocataire;
    private String dateDebutContrat;
    private double montant;
    private double montantLoyer;
    private String dateVersementLoyer;
    private String dateEntree;
    private String dateSortie;
    private String depotDeGarantie;
    private String dateRevision;
    private String periodicitePaiement;
    private String dateFinContrat;
    private double chargesProvisionnelles; 
    private String idICC;
    private double valeurIcc;
    private double caution;
    private String idBienImm;

    public ContratLocation(String idLocataire, String dateDebutContrat, double montant, double montantLoyer,
            String dateVersementLoyer, String dateEntree, String dateSortie, String depotDeGarantie, String dateRevision,
            String periodicitePaiement, String dateFinContrat, double chargesProvisionnelles, String idICC,
            double caution, String idBienImm) {
        this.idLocataire = idLocataire;
        this.dateDebutContrat = dateDebutContrat;
        this.montant = montant;
        this.montantLoyer = montantLoyer;
        this.dateVersementLoyer = dateVersementLoyer;
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
        this.depotDeGarantie = depotDeGarantie;
        this.dateRevision = dateRevision;
        this.periodicitePaiement = periodicitePaiement;
        this.dateFinContrat = dateFinContrat;
        this.chargesProvisionnelles = chargesProvisionnelles;
        this.idICC = idICC;
        this.caution = caution;
        this.idBienImm = idBienImm;
        
    }

    /**
     * Methode pour retourner l'ID du locataire
     */
    public String getIdLocataire() {
        return idLocataire;
    }

    /**
     * Methode pour retourner la date de début du contrat
     */
    public String getDateDebutContrat() {
        return dateDebutContrat;
    }

    /**
     * Methode pour retourner le montant total du contrat
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Methode pour modifier le montant total du contrat
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Methode pour retourner le montant du loyer
     */
    public double getMontantLoyer() {
        return montantLoyer;
    }

    /**
     * Methode pour modifier le montant du loyer
     */
    public void setMontantLoyer(double montantLoyer) {
        this.montantLoyer = montantLoyer;
    }

    /**
     * Methode pour retourner la date de versement du loyer
     */
    public String getDateVersementLoyer() {
        return dateVersementLoyer;
    }

    /**
     * Methode pour modifier la date de versement du loyer
     */
    public void setDateVersementLoyer(String dateVersementLoyer) {
        this.dateVersementLoyer = dateVersementLoyer;
    }

    /**
     * Methode pour retourner la date d'entrée
     */
    public String getDateEntree() {
        return dateEntree;
    }

    /**
     * Methode pour modifier la date d'entrée
     */
    public void setDateEntree(String dateEntree) {
        this.dateEntree = dateEntree;
    }

    /**
     * Methode pour retourner la date de sortie
     */
    public String getDateSortie() {
        return dateSortie;
    }

    /**
     * Methode pour modifier la date de sortie
     */
    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    /**
     * Methode pour retourner le dépôt de garantie
     */
    public String getDepotDeGarantie() {
        return depotDeGarantie;
    }

    /**
     * Methode pour modifier le dépôt de garantie
     */
    public void setDepotDeGarantie(String depotDeGarantie) {
        this.depotDeGarantie = depotDeGarantie;
    }

    /**
     * Methode pour retourner la date de révision
     */
    public String getDateRevision() {
        return dateRevision;
    }

    /**
     * Methode pour modifier la date de révision
     */
    public void setDateRevision(String dateRevision) {
        this.dateRevision = dateRevision;
    }

    /**
     * Methode pour retourner la périodicité de paiement
     */
    public String getPeriodicitePaiement() {
        return periodicitePaiement;
    }

    /**
     * Methode pour modifier la périodicité de paiement
     */
    public void setPeriodicitePaiement(String periodicitePaiement) {
        this.periodicitePaiement = periodicitePaiement;
    }

    /**
     * Methode pour retourner la date de fin du contrat
     */
    public String getDateFinContrat() {
        return dateFinContrat;
    }

    /**
     * Methode pour modifier la date de fin du contrat
     */
    public void setDateFinContrat(String dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    /**
     * Methode pour retourner le montant des charges provisionnelles
     */
    public double getChargesProvisionnelles() {
        return chargesProvisionnelles;
    }

    /**
     * Methode pour modifier le montant des charges provisionnelles
     */
    public void setChargesProvisionnelles(double chargesProvisionnelles) {
        this.chargesProvisionnelles = chargesProvisionnelles;
    }

    /**
     * Methode pour retourner l'ID de l'ICC (Indice de coût de la construction)
     */
    public String getIdICC() {
        return idICC;
    }

    /**
     * Methode pour modifier l'ID de l'ICC
     */
    public void setIdICC(String idICC) {
        this.idICC = idICC;
    }

    /**
     * Methode pour retourner la valeur de l'ICC
     */
    public double getValeurIcc() {
        return valeurIcc;
    }

    /**
     * Methode pour modifier la valeur de l'ICC
     */
    public void setValeurIcc(double valeurIcc) {
        this.valeurIcc = valeurIcc;
    }

    /**
     * Methode pour retourner le montant de la caution
     */
    public double getCaution() {
        return caution;
    }

    /**
     * Methode pour modifier le montant de la caution
     */
    public void setCaution(double caution) {
        this.caution = caution;
    }

    /**
     * Methode pour retourner l'ID du bien immobilier lié au contrat de location
     */
    public String getIdBienImm() {
        return idBienImm;
    }

    /**
     * Methode pour modifier l'ID du bien immobilier lié au contrat de location
     */
    public void setIdBienImm(String idBienImm) {
        this.idBienImm = idBienImm;
    }
}
