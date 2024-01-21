package modele;

public class Assurance {
	private String numPolice;
	private String tarifInitial;
	private String typeAssurance;
	private String dateEffetDebut;
	private static String idBienImm;
	private static String idBatiment;

	public Assurance(String numPolice,String tarifInitial, String typeAssurance, String dateEffetDebut,String idBienImm,String idBatiment) {
		this.tarifInitial = tarifInitial;
		this.typeAssurance = typeAssurance;
		this.dateEffetDebut = dateEffetDebut;
		this.numPolice = numPolice;
		this.idBienImm=idBienImm;
		this.idBatiment=idBatiment;
	}

    /**
     * Methode pour retourner le numéro de police
     */
	public String getNumPolice() {
		return numPolice;
	}

    /**
     * Methode pour modifier le numéro de police
     */
	public void setNumPolice(String numPolice) {
		this.numPolice = numPolice;
	}

    /**
     * Methode pour retourner le tarif initial
     */
	public String getTarifInitial() {
		return tarifInitial;
	}

    /**
     * Methode pour modifier le tarif initial
     */
	public void setTarifInitial(String tarifInitial) {
		this.tarifInitial = tarifInitial;
	}

    /**
     * Methode pour retourner le type d'assurance
     */
	public String getTypeAssurance() {
		return typeAssurance;
	}
    /**
     * Methode pour modifier le type d'assurance
     */
	public void setTypeAssurance(String typeAssurance) {
		this.typeAssurance = typeAssurance;
	}

    /**
     * Methode pour retourner la date d'effet de début
     */
	public String getDateEffetDebut() {
		return dateEffetDebut;
	}
    /**
     * Methode pour modifier la date d'effet de début
     */
	public void setDateEffetDebut(String dateEffetDebut) {
		this.dateEffetDebut = dateEffetDebut;
	}

    /**
     * Methode pour retourner l'ID du bien immobilier
     */
	public String getIdBienImm() {
		return idBienImm;
	}


    /**
     * Methode pour retourner l'ID du batiment
     */
	public String getIdBatiment() {
		return idBatiment;
	}


}
