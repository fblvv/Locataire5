package modele;

public class Associer {
	private String dateDebutContrat;
	private static String idLocataire;
	private String dateEntree;
	private String dateSortie;
	private int caution;


	public Associer(String dateDebutContrat, String dateEntree, String dateSortie, int caution) {
		this.dateDebutContrat = dateDebutContrat;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.caution = caution;
		// s
	}
	/**
	 * Methode pour retourner la date du debut de contrat
	 */
	public String getDateDebutContrat() {
		return dateDebutContrat;
	}

	/**
	 * Methode pour modifier la date du debut de contrat
	 */
	public void setDateDebutContrat(String dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}
	/**
	 * Methode pour retourner l'id du locataire
	 */

	public String getIdLocataire() {
		return idLocataire;
	}

	/**
	 * Methode pour retourner la date d'entree
	 */

	public String getDateEntree() {
		return dateEntree;
	}

	/**
	 * Methode pour modifier la date d'entree
	 */

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	/**
	 * Methode pour retourner la date de sortie
	 */

	public String getDateSortie() {
		return dateSortie;
	}
	/**
	 * Methode pour modifier la date de sortie
	 */

	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	/**
	 * Methode pour retourner la caution
	 */

	public int getCaution() {
		return caution;
	}

	/**
	 * Methode pour modifier la caution
	 */

	public void setCaution(int caution) {
		this.caution = caution;
	}
}
