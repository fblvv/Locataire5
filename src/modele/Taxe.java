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

	public String getIdTaxeFonciere() {
		return idTaxeFonciere;
	}

	public void setidTaxeFonciere(String idTaxeFonciere) {
		this.idTaxeFonciere = idTaxeFonciere;
	}

	public double getBaseImposition() {
		return baseImposition;
	}

	public void setBaseImposition(double baseImposition) {
		this.baseImposition = baseImposition;
	}

	public double getTypeTaxe() {
		return typeTaxe;
	}

	public void setTypeTaxe(double typeTaxe) {
		this.typeTaxe = typeTaxe;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public String getDateTaxe() {
		return dateTaxe;
	}

	public void setDateTaxe(String dateTaxe) {
		this.dateTaxe = dateTaxe;
	}

	public String getIdBienImm() {
		return idBienImm;
	}

}
