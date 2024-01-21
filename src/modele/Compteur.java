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

	/**
     * Methode pour retourner l'ID du compteur
     */
    public String getIdCompteur() {
        return idCompteur;
    }

    /**
     * Methode pour modifier l'ID du compteur
     */
    public void setIdCompteur(String idCompteur) {
        this.idCompteur = idCompteur;
    }

    /**
     * Methode pour retourner la date du relevé
     */
    public String getDateReleve() {
        return dateReleve;
    }

    /**
     * Methode pour modifier la date du relevé
     */
    public void setDateReleve(String dateReleve) {
        this.dateReleve = dateReleve;
    }

    /**
     * Methode pour retourner le type du compteur
     */
    public String getTypeCompteur() {
        return typeCompteur;
    }

    /**
     * Methode pour modifier le type du compteur
     */
    public void setTypeCompteur(String typeCompteur) {
        this.typeCompteur = typeCompteur;
    }

    /**
     * Methode pour retourner la valeur du compteur
     */
    public Double getValeur() {
        return valeur;
    }

    /**
     * Methode pour modifier la valeur du compteur
     */
    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    /**
     * Methode pour retourner l'ID du bien immobilier lié au compteur
     */
    public String getIdBienImm() {
        return idBienImm;
    }

    /**
     * Methode pour modifier l'ID du bien immobilier lié au compteur
     */
    public void setIdBienImm(String idBienImm) {
        this.idBienImm = idBienImm;
    }

}
