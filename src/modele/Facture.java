package modele;

public class Facture {
	private String siren;
	private String idFacture;
	private double prix;
	private String typeEntretien;
	private String dateFacture;
	private String idBienImm;
	private String idBatiment;

	public Facture(String idFacture,String siren,double prix, String typeEntretien, String dateFacture,String idBienImm,String idBatiment) {
		this.prix = prix;
		this.typeEntretien = typeEntretien;
		this.dateFacture = dateFacture;
		this.idFacture=idFacture;
		this.siren = siren;
		this.idBienImm = idBienImm;
		this.idBatiment = idBatiment;
		
	}

    /**
     * Methode pour retourner le numéro SIREN associé à la facture
     */
    public String getSiren() {
        return siren;
    }

    /**
     * Methode pour retourner l'identifiant de la facture
     */
    public String getIdFacture() {
        return idFacture;
    }

    /**
     * Methode pour modifier l'identifiant de la facture
     */
    public void setIdFacture(String idFacture) {
        this.idFacture = idFacture;
    }

    /**
     * Methode pour retourner le prix de la facture
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Methode pour modifier le prix de la facture
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Methode pour retourner le type d'entretien associé à la facture
     */
    public String getTypeEntretien() {
        return typeEntretien;
    }

    /**
     * Methode pour modifier le type d'entretien associé à la facture
     */
    public void setTypeEntretien(String typeEntretien) {
        this.typeEntretien = typeEntretien;
    }

    /**
     * Methode pour retourner la date de la facture
     */
    public String getDateFacture() {
        return dateFacture;
    }

    /**
     * Methode pour modifier la date de la facture
     */
    public void setDateFacture(String dateFacture) {
        this.dateFacture = dateFacture;
    }

    /**
     * Methode pour retourner l'identifiant du bien immobilier associé à la facture
     */
    public String getIdBienImm() {
        return idBienImm;
    }

    /**
     * Methode pour retourner l'identifiant du bâtiment associé à la facture
     */
    public String getIdBatiment() {
        return idBatiment;
    }

}
