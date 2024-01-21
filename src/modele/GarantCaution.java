package modele;

// Class for Garant_Caution
public class GarantCaution {
	private String idCaution;
	private String nom;
	private String prenom;
	private String numero_Telephone;

	public GarantCaution(String idCaution, String nom, String prenom, String numero_Telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.numero_Telephone = numero_Telephone;
		this.idCaution=idCaution;
	}

    /**
     * Methode pour retourner l'identifiant de la caution
     */
    public String getidCaution() {
        return idCaution;
    }

    /**
     * Methode pour modifier l'identifiant de la caution
     */
    public void setIdCaution(String idCaution) {
        this.idCaution = idCaution;
    }

    /**
     * Methode pour retourner le nom du garant caution
     */
    public String getNom() {
        return nom;
    }

    /**
     * Methode pour modifier le nom du garant caution
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Methode pour retourner le prénom du garant caution
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Methode pour modifier le prénom du garant caution
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Methode pour retourner le numéro de téléphone du garant caution
     */
    public String getNumero_Telephone() {
        return numero_Telephone;
    }

    /**
     * Methode pour modifier le numéro de téléphone du garant caution
     */
    public void setNumero_Telephone(String numero_Telephone) {
        this.numero_Telephone = numero_Telephone;
    }
}
