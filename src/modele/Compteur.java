package modele;

public class Compteur {
	private String idCompteur;
	private String dateReleve;
	private String typeCompteur;
	private double valeur;
	private static String idBienImm;


	public Compteur(String idCompteur,String dateReleve, String typeCompteur, double valeur) {
		this.dateReleve = dateReleve;
		this.typeCompteur = typeCompteur;
		this.valeur = valeur;
		this.idCompteur=idCompteur;
	}

	public String getIdCompteur() {
		return idCompteur;
	}

	public void setIdCompteur(String idCompteur) {
		this.idCompteur = idCompteur;
	}

	public String getDateReleve() {
		return dateReleve;
	}

	public void setDateReleve(String dateReleve) {
		this.dateReleve = dateReleve;
	}

	public String getTypeCompteur() {
		return typeCompteur;
	}

	public void setTypeCompteur(String typeCompteur) {
		this.typeCompteur = typeCompteur;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public String getIdBienImm() {
		return idBienImm;
	}

	public void setIdBienImm(String idBienImm) {
		 this.idBienImm=idBienImm;
		
	}

}
