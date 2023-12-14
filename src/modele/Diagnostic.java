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

	public String getRefDiagnostic() {
		return refDiagnostic;
	}

	public void setRefDiagnostic(String refDiagnostic) {
		this.refDiagnostic = refDiagnostic;
	}

	public String getTypeDiagnostic() {
		return typeDiagnostic;
	}

	public void setTypeDiagnostic(String typeDiagnostic) {
		this.typeDiagnostic = typeDiagnostic;
	}

	public String getDiagnostiqueur() {
		return diagnostiqueur;
	}

	public void setDiagnostiqueur(String diagnostiqueur) {
		this.diagnostiqueur = diagnostiqueur;
	}

	public String getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(String dateVisite) {
		this.dateVisite = dateVisite;
	}

	public String getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(String dateValidite) {
		this.dateValidite = dateValidite;
	}

	public String getNatureTravaux() {
		return natureTravaux;
	}

	public void setNatureTravaux(String natureTravaux) {
		this.natureTravaux = natureTravaux;
	}

	public String getDepensesReparations() {
		return depensesReparations;
	}

	public void setDepensesReparations(String depensesReparations) {
		this.depensesReparations = depensesReparations;
	}

	public String getIdBienImm() {
		return idBienImm;
	}
}
