package modele;

// Class for Locataire
public class Locataire {
	private String id_Locataire;
	private String nom;
	private String prenom;
	private String telephone;
	private String mail;
	private String adresse;
	private String code_Postal;

	public Locataire(String idLocataire,String nom, String prenom, String telephone, String mail, String adresse, String code_Postal) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
		this.adresse = adresse;
		this.code_Postal = code_Postal;
		this.id_Locataire=idLocataire;
	}


    /**
     * Methode pour retourner l'identifiant du locataire
     */
    public String getId_Locataire() {
        return id_Locataire;
    }

    /**
     * Methode pour modifier l'identifiant du locataire
     */
    public void setIdLocataire(String idLocataire) {
        this.id_Locataire = idLocataire;
    }

    /**
     * Methode pour retourner le nom du locataire
     */
    public String getNom() {
        return nom;
    }

    /**
     * Methode pour modifier le nom du locataire
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Methode pour retourner le prénom du locataire
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Methode pour modifier le prénom du locataire
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Methode pour retourner le numéro de téléphone du locataire
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Methode pour modifier le numéro de téléphone du locataire
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Methode pour retourner l'adresse e-mail du locataire
     */
    public String getMail() {
        return mail;
    }

    /**
     * Methode pour modifier l'adresse e-mail du locataire
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Methode pour retourner l'adresse du locataire
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Methode pour modifier l'adresse du locataire
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Methode pour retourner le code postal du locataire
     */
    public String getCode_Postal() {
        return code_Postal;
    }

    /**
     * Methode pour modifier le code postal du locataire
     */
    public void setCode_Postal(String code_Postal) {
        this.code_Postal = code_Postal;
    }
}