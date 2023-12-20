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

    public String getIdLoyer() {
        return idLoyer;
    }

    public double getLoyerCharges() {
        return loyerCharges;
    }

    public void setLoyerCharges(double loyerCharges) {
        this.loyerCharges = loyerCharges;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontantPaiement() {
        return montantPaiement;
    }

    public void setMontantPaiement(double montantPaiement) {
        this.montantPaiement = montantPaiement;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }

    public String getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(String idLocataire) {
        this.idLocataire = idLocataire;
    }

    public String getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(String dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }
}
