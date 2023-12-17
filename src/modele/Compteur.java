package modele;

public class Compteur {
	private String idCompteur;
	private String dateReleve;
	private String typeCompteur;
	private Double valeur;
	private String idBienImm;



	public Compteur(String idCompteur,String dateReleve, String typeCompteur, Double valeur,String idBien) {
		this.dateReleve = dateReleve;
		this.typeCompteur = typeCompteur;
		this.valeur = valeur;
		this.idCompteur=idCompteur;
		this.idBienImm=idBien;
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

	public Double getValeur() {
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}

	public String getIdBienImm() {
		return idBienImm;
	}

	public void setIdBienImm(String idBienImm) {
		 this.idBienImm=idBienImm;
		
	}

}
