package modele;

public class Contenir {
	private static String idCaution;
	private static String dateDebutContrat;


	public Contenir() {
	}

    /**
     * Methode pour retourner l'ID de la caution
     */
    public String getIdCaution() {
        return idCaution;
    }

    /**
     * Methode pour retourner la date de début du contrat
     */
    public String getDateDebutContrat() {
        return dateDebutContrat;
    }
}
