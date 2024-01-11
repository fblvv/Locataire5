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
    private double chargesProvisionnelles; //voila
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

    public String getIdLocataire() {
        return idLocataire;
    }

    public String getDateDebutContrat() {
        return dateDebutContrat;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontantLoyer() {
        return montantLoyer;
    }

    public void setMontantLoyer(double montantLoyer) {
        this.montantLoyer = montantLoyer;
    }

    public String getDateVersementLoyer() {
        return dateVersementLoyer;
    }

    public void setDateVersementLoyer(String dateVersementLoyer) {
        this.dateVersementLoyer = dateVersementLoyer;
    }

    public String getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(String dateEntree) {
        this.dateEntree = dateEntree;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getDepotDeGarantie() {
        return depotDeGarantie;
    }

    public void setDepotDeGarantie(String depotDeGarantie) {
        this.depotDeGarantie = depotDeGarantie;
    }

    public String getDateRevision() {
        return dateRevision;
    }

    public void setDateRevision(String dateRevision) {
        this.dateRevision = dateRevision;
    }

    public String getPeriodicitePaiement() {
        return periodicitePaiement;
    }

    public void setPeriodicitePaiement(String periodicitePaiement) {
        this.periodicitePaiement = periodicitePaiement;
    }

    public String getDateFinContrat() {
        return dateFinContrat;
    }

    public void setDateFinContrat(String dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public double getChargesProvisionnelles() {
        return chargesProvisionnelles;
    }

    public void setChargesProvisionnelles(double chargesProvisionnelles) {
        this.chargesProvisionnelles = chargesProvisionnelles;
    }

    public String getIdICC() {
        return idICC;
    }

    public void setIdICC(String idICC) {
        this.idICC = idICC;
    }

    public double getCaution() {
        return caution;
    }

    public void setCaution(double caution) {
        this.caution = caution;
    }

    public String getIdBienImm() {
        return idBienImm;
    }

    public void setIdBienImm(String idBienImm) {
        this.idBienImm = idBienImm;
    }

	public double getValeurIcc() {
		return valeurIcc;
	}

	public void setValeurIcc(double valeurIcc) {
		this.valeurIcc = valeurIcc;
	}
}
