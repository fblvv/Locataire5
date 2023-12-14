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

	public String getId_Locataire() {
		return id_Locataire;
	}

	public void setIdLocataire(String idLocataire) {
		this.id_Locataire = idLocataire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCode_Postal() {
		return code_Postal;
	}

	public void setCode_Postal(String code_Postal) {
		this.code_Postal = code_Postal;
	}
}