package modele;

// Class for Entreprise
public class Entreprise {
	private String siren;
	private String champAdresse;
	private String champTel;
	private String champNom;

	public Entreprise(String siren, String champAdresse, String champTel, String champNom) {
		this.champAdresse = champAdresse;
		this.champTel = champTel;
		this.champNom = champNom;
		this.siren=siren;
	}

    /**
     * Methode pour retourner le numéro SIREN de l'entreprise
     */
    public String getSiren() {
        return siren;
    }

    /**
     * Methode pour modifier le numéro SIREN de l'entreprise
     */
    public void setSiren(String siren) {
        this.siren = siren;
    }

    /**
     * Methode pour retourner l'adresse de l'entreprise
     */
    public String getAdresse() {
        return champAdresse;
    }

    /**
     * Methode pour modifier l'adresse de l'entreprise
     */
    public void setAdresse(String champAdresse) {
        this.champAdresse = champAdresse;
    }

    /**
     * Methode pour retourner le numéro de téléphone de l'entreprise
     */
    public String getTel() {
        return champTel;
    }

    /**
     * Methode pour modifier le numéro de téléphone de l'entreprise
     */
    public void setTel(String champTel) {
        this.champTel = champTel;
    }

    /**
     * Methode pour retourner le nom de l'entreprise
     */
    public String getNom() {
        return champNom;
    }

    /**
     * Methode pour modifier le nom de l'entreprise
     */
    public void setNom(String champNom) {
        this.champNom = champNom;
    }
}