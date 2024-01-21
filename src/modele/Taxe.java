package modele;

public class Taxe {
	private String idTaxeFonciere;
	private double baseImposition;
	private double typeTaxe;
	private double taux;
	private String dateTaxe;
	private static String idBienImm;

	public Taxe(String idTaxeFonciere, double baseImposition, double typeTaxe, double taux, String dateTaxe) {
		this.baseImposition = baseImposition;
		this.typeTaxe = typeTaxe;
		this.taux = taux;
		this.dateTaxe = dateTaxe;
		this.idTaxeFonciere=idTaxeFonciere;
	}

    /**
     * Methode pour retourner l'identifiant de la taxe foncière
     */
    public String getIdTaxeFonciere() {
        return idTaxeFonciere;
    }

    /**
     * Methode pour modifier l'identifiant de la taxe foncière
     */
    public void setidTaxeFonciere(String idTaxeFonciere) {
        this.idTaxeFonciere = idTaxeFonciere;
    }

    /**
     * Methode pour retourner la base d'imposition de la taxe
     */
    public double getBaseImposition() {
        return baseImposition;
    }

    /**
     * Methode pour modifier la base d'imposition de la taxe
     */
    public void setBaseImposition(double baseImposition) {
        this.baseImposition = baseImposition;
    }

    /**
     * Methode pour retourner le type de taxe
     */
    public double getTypeTaxe() {
        return typeTaxe;
    }

    /**
     * Methode pour modifier le type de taxe
     */
    public void setTypeTaxe(double typeTaxe) {
        this.typeTaxe = typeTaxe;
    }

    /**
     * Methode pour retourner le taux de la taxe
     */
    public double getTaux() {
        return taux;
    }

    /**
     * Methode pour modifier le taux de la taxe
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

    /**
     * Methode pour retourner la date de la taxe
     */
    public String getDateTaxe() {
        return dateTaxe;
    }

    /**
     * Methode pour modifier la date de la taxe
     */
    public void setDateTaxe(String dateTaxe) {
        this.dateTaxe = dateTaxe;
    }

    /**
     * Methode pour retourner l'identifiant du bien immobilier lié à la taxe
     */
    public String getIdBienImm() {
        return idBienImm;
    }

}
