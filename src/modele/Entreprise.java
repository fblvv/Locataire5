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

	public String getSiren() {
		return siren;
	}

	public void setSiren(String siren) {
		this.siren = siren;
	}

	public String getAdresse() {
		return champAdresse;
	}

	public void setAdresse(String champAdresse) {
		this.champAdresse = champAdresse;
	}

	public String getTel() {
		return champTel;
	}

	public void setTel(String champTel) {
		this.champTel = champTel;
	}

	public String getNom() {
		return champNom;
	}

	public void setNom(String champNom) {
		this.champNom = champNom;
	}
}