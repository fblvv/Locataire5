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
	}

	public String getDateDebutContrat() {
		return dateDebutContrat;
	}

	public void setDateDebutContrat(String dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}

	public String getIdLocataire() {
		return idLocataire;
	}


	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	public String getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getCaution() {
		return caution;
	}

	public void setCaution(int caution) {
		this.caution = caution;
	}
}
