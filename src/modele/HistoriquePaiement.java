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

    /**
     * Methode pour retourner l'identifiant de l'historique de paiement
     */
    public String getIdHistPaiement() {
        return idHistPaiement;
    }

    /**
     * Methode pour modifier l'identifiant de l'historique de paiement
     */
    public void setIdHistPaiement(String idHistPaiement) {
        this.idHistPaiement = idHistPaiement;
    }

    /**
     * Methode pour retourner le champ de stockage
     */
    public String getStocker() {
        return stocker;
    }

    /**
     * Methode pour modifier le champ de stockage
     */
    public void setStocker(String stocker) {
        this.stocker = stocker;
    }

    /**
     * Methode pour retourner la date de début du contrat associé à l'historique de paiement
     */
    public String getDateDebutContrat() {
        return dateDebutContrat;
    }

    /**
     * Methode pour modifier la date de début du contrat associé à l'historique de paiement
     */
    public void setDateDebutContrat(String dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }
}
