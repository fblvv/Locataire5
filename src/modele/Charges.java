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

	public String getIdBienImm() {
		return idBienImm;
	}

	public String getIdCharges() {
		return idCharges;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public void setIdBienImm(String idBienImm) {
		this.idBienImm = idBienImm;
	}


	public String getDateCharge() {
		return dateCharge;
	}

	public void setDateCharge(String dateCharge) {
		this.dateCharge = dateCharge;
	}

	public String getTypeCharge() {
		return typeCharge;
	}

	public void setTypeCharge(String typeCharge) {
		this.typeCharge = typeCharge;
	}

	public String getPourcentagePartEntretien() {
		return pourcentagePartEntretien;
	}

	public void setPourcentagePartEntretien(String pourcentagePartEntretien) {
		this.pourcentagePartEntretien = pourcentagePartEntretien;
	}
}
