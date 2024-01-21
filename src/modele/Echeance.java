package modele;

public class Echeance {
	private static String numPolice;
	private String dateEcheance;
	private double montant;


	public Echeance(String dateEcheance, double montant) {
		this.dateEcheance = dateEcheance;
		this.montant = montant;
	}

    /**
     * Methode pour retourner le numéro de police
     */
    public String getNumPolice() {
        return numPolice;
    }

    /**
     * Methode pour retourner la date de l'échéance
     */
    public String getDateEcheance() {
        return dateEcheance;
    }

    /**
     * Methode pour modifier la date de l'échéance
     */
    public void setDateEcheance(String dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    /**
     * Methode pour retourner le montant de l'échéance
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Methode pour modifier le montant de l'échéance
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }
}
