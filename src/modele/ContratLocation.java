package modele;

public class ContratLocation {
	private String dateDebutContrat;
	private double montant;
	private double montantDernierLoyer;
	private String dateVersementLoyer;
	private String depotGarantie;
	private String dateRevision;
	private String periodicitePaiement;
	private String dateFinContrat;
	private double chargesProvisionnelles;
	private static String idICC;
	private String valeurICC;
	private static String idBienImm;

	public ContratLocation(String dateDebutContrat, double montant, double montantDernierLoyer,
			String dateVersementLoyer, String depotGarantie, String dateRevision,
			String periodicitePaiement, String dateFinContrat, double chargesProvisionnelles,
			String idICC, String valeurICC,String idBien) {
		this.dateDebutContrat = dateDebutContrat;
		this.montant = montant;
		this.montantDernierLoyer = montantDernierLoyer;
		this.dateVersementLoyer = dateVersementLoyer;
		this.depotGarantie = depotGarantie;
		this.dateRevision = dateRevision;
		this.periodicitePaiement = periodicitePaiement;
		this.dateFinContrat = dateFinContrat;
		this.chargesProvisionnelles = chargesProvisionnelles;
		this.valeurICC = valeurICC;
		this.idBienImm=idBien;
	}

	public String getDateDebutContrat() {
		return dateDebutContrat;
	}

	public void setDateDebutContrat(String dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getMontantDernierLoyer() {
		return montantDernierLoyer;
	}

	public void setMontantDernierLoyer(double montantDernierLoyer) {
		this.montantDernierLoyer = montantDernierLoyer;
	}

	public String getDateVersementLoyer() {
		return dateVersementLoyer;
	}

	public void setDateVersementLoyer(String dateVersementLoyer) {
		this.dateVersementLoyer = dateVersementLoyer;
	}

	public String getDepotGarantie() {
		return depotGarantie;
	}

	public void setDepotGarantie(String depotGarantie) {
		this.depotGarantie = depotGarantie;
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

	public String getValeurICC() {
		return valeurICC;
	}

	public void setValeurICC(String valeurICC) {
		this.valeurICC = valeurICC;
	}
	
	
	public void setIdBienImm(String idBien){
		this.idBienImm=idBien;
		
	}

	public String getIdBienImm() {
		return idBienImm;
	}
}
