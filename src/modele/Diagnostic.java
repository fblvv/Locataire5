package modele;

public class Diagnostic {
	private String refDiagnostic;
	private String typeDiagnostic;
	private String diagnostiqueur;
	private String dateVisite;
	private String dateValidite;
	private String natureTravaux;
	private String depensesReparations;
	private static String idBienImm;

	public Diagnostic(String refDiagnostic, String typeDiagnostic, String diagnostiqueur, String dateVisite,
			String dateValidite, String natureTravaux, String depensesReparations) {
		this.refDiagnostic = refDiagnostic;
		this.typeDiagnostic = typeDiagnostic;
		this.diagnostiqueur = diagnostiqueur;
		this.dateVisite = dateVisite;
		this.dateValidite = dateValidite;
		this.natureTravaux = natureTravaux;
		this.depensesReparations = depensesReparations;
	}


    /**
     * Methode pour retourner la référence du diagnostic
     */
    public String getRefDiagnostic() {
        return refDiagnostic;
    }

    /**
     * Methode pour modifier la référence du diagnostic
     */
    public void setRefDiagnostic(String refDiagnostic) {
        this.refDiagnostic = refDiagnostic;
    }

    /**
     * Methode pour retourner le type de diagnostic
     */
    public String getTypeDiagnostic() {
        return typeDiagnostic;
    }

    /**
     * Methode pour modifier le type de diagnostic
     */
    public void setTypeDiagnostic(String typeDiagnostic) {
        this.typeDiagnostic = typeDiagnostic;
    }

    /**
     * Methode pour retourner le diagnostiqueur
     */
    public String getDiagnostiqueur() {
        return diagnostiqueur;
    }

    /**
     * Methode pour modifier le diagnostiqueur
     */
    public void setDiagnostiqueur(String diagnostiqueur) {
        this.diagnostiqueur = diagnostiqueur;
    }

    /**
     * Methode pour retourner la date de visite
     */
    public String getDateVisite() {
        return dateVisite;
    }

    /**
     * Methode pour modifier la date de visite
     */
    public void setDateVisite(String dateVisite) {
        this.dateVisite = dateVisite;
    }

    /**
     * Methode pour retourner la date de validité
     */
    public String getDateValidite() {
        return dateValidite;
    }

    /**
     * Methode pour modifier la date de validité
     */
    public void setDateValidite(String dateValidite) {
        this.dateValidite = dateValidite;
    }

    /**
     * Methode pour retourner la nature des travaux
     */
    public String getNatureTravaux() {
        return natureTravaux;
    }

    /**
     * Methode pour modifier la nature des travaux
     */
    public void setNatureTravaux(String natureTravaux) {
        this.natureTravaux = natureTravaux;
    }

    /**
     * Methode pour retourner les dépenses de réparations
     */
    public String getDepensesReparations() {
        return depensesReparations;
    }

    /**
     * Methode pour modifier les dépenses de réparations
     */
    public void setDepensesReparations(String depensesReparations) {
        this.depensesReparations = depensesReparations;
    }

    /**
     * Methode pour retourner l'ID du bien immobilier lié au diagnostic
     */
    public String getIdBienImm() {
        return idBienImm;
    }
}
