package modele;

public class Echeance {
	private static String numPolice;
	private String dateEcheance;
	private double montant;


	public Echeance(String dateEcheance, double montant) {
		this.dateEcheance = dateEcheance;
		this.montant = montant;
	}

	public String getNumPolice() {
		return numPolice;
	}

	public String getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(String dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
}
