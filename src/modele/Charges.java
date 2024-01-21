package modele;

public class Charges {
	private String idBienImm;
	private String idCharges;
	private double montant;
	private String dateCharge;
	private String typeCharge;
	private String pourcentagePartEntretien;


	public Charges(String idCharge,String idBienImm,double montant, String dateCharge, String typeCharge,
			String pourcentagePartEntretien) {
		this.idCharges = idCharge;
		this.montant = montant;
		this.dateCharge = dateCharge;
		this.typeCharge = typeCharge;
		this.pourcentagePartEntretien = pourcentagePartEntretien;
		this.idBienImm = idBienImm;
	}

	/**
     * Methode pour retourner l'ID du bien immobilier
     */
    public String getIdBienImm() {
        return idBienImm;
    }

    /**
     * Methode pour retourner l'ID des charges
     */
    public String getIdCharges() {
        return idCharges;
    }

    /**
     * Methode pour retourner le montant des charges
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Methode pour modifier le montant des charges
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Methode pour modifier l'ID du bien immobilier
     */
    public void setIdBienImm(String idBienImm) {
        this.idBienImm = idBienImm;
    }

    /**
     * Methode pour retourner la date des charges
     */
    public String getDateCharge() {
        return dateCharge;
    }

    /**
     * Methode pour modifier la date des charges
     */
    public void setDateCharge(String dateCharge) {
        this.dateCharge = dateCharge;
    }

    /**
     * Methode pour retourner le type des charges
     */
    public String getTypeCharge() {
        return typeCharge;
    }

    /**
     * Methode pour modifier le type des charges
     */
    public void setTypeCharge(String typeCharge) {
        this.typeCharge = typeCharge;
    }

    /**
     * Methode pour retourner le pourcentage de la part d'entretien
     */
    public String getPourcentagePartEntretien() {
        return pourcentagePartEntretien;
    }

    /**
     * Methode pour modifier le pourcentage de la part d'entretien
     */
    public void setPourcentagePartEntretien(String pourcentagePartEntretien) {
        this.pourcentagePartEntretien = pourcentagePartEntretien;
    }
}
