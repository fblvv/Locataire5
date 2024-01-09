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

	public String getSiren() {
		return siren;
	}

	public String getIdFacture() {
		return idFacture;
	}

	public void setidFacture(String idFacture) {
		this.idFacture = idFacture;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getTypeEntretien() {
		return typeEntretien;
	}

	public void setTypeEntretien(String typeEntretien) {
		this.typeEntretien = typeEntretien;
	}

	public String getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(String dateFacture) {
		this.dateFacture = dateFacture;
	}

	public String getIdBienImm() {
		return idBienImm;
	}



	public String getIdBatiment() {
		return idBatiment;
	}

}
