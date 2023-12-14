package modele;

public class HistoriquePaiement {
	private String idHistPaiement;
	private String stocker;
	private String dateDebutContrat;

	public HistoriquePaiement(String idHistPaiement,String stocker, String dateDebutContrat) {
		this.stocker = stocker;
		this.dateDebutContrat = dateDebutContrat;
		this.idHistPaiement=idHistPaiement;
	}

	public String getIdHistPaiement() {
		return idHistPaiement;
	}

	public void setIdHistPaiement(String idHistPaiement) {
		this.idHistPaiement = idHistPaiement;
	}

	public String getStocker() {
		return stocker;
	}

	public void setStocker(String stocker) {
		this.stocker = stocker;
	}

	public String getDateDebutContrat() {
		return dateDebutContrat;
	}

	public void setDateDebutContrat(String dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}
}
