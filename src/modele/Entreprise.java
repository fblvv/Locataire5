package modele;

// Class for Entreprise
public class Entreprise {
	private String siren;
	private String adresse_Entreprise;
	private String tel_Entreprise;
	private String mail_Entreprise;

	public Entreprise(String siren, String adresse_Entreprise, String tel_Entreprise, String mail_Entreprise) {
		this.adresse_Entreprise = adresse_Entreprise;
		this.tel_Entreprise = tel_Entreprise;
		this.mail_Entreprise = mail_Entreprise;
		this.siren=siren;
	}

	public String getSiren() {
		return siren;
	}

	public void setSiren(String siren) {
		this.siren = siren;
	}

	public String getAdresse_Entreprise() {
		return adresse_Entreprise;
	}

	public void setAdresse_Entreprise(String adresse_Entreprise) {
		this.adresse_Entreprise = adresse_Entreprise;
	}

	public String getTel_Entreprise() {
		return tel_Entreprise;
	}

	public void setTel_Entreprise(String tel_Entreprise) {
		this.tel_Entreprise = tel_Entreprise;
	}

	public String getMail_Entreprise() {
		return mail_Entreprise;
	}

	public void setMail_Entreprise(String mail_Entreprise) {
		this.mail_Entreprise = mail_Entreprise;
	}
}