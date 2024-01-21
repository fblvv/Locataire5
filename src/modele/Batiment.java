package modele;

// Class for Batiment
public class Batiment {
	private String idBatiment;
	private String regime_Juridique;
	private String adresse;
	private String date_Construction;
	private String equip_Acces_Tech;
	private String enum_Parties_Communes;
	private String codePostal;

	public Batiment(String idBatiment, String regime_Juridique, String adresse, String date_Construction, String equip_Acces_Tech, String enum_Parties_Communes,String codePostal) {
		this.idBatiment = idBatiment;
		this.regime_Juridique = regime_Juridique;
		this.adresse = adresse;
		this.date_Construction = date_Construction;
		this.equip_Acces_Tech = equip_Acces_Tech;
		this.enum_Parties_Communes = enum_Parties_Communes;
		this.codePostal=codePostal;
		
	}

    /**
     * Methode pour retourner l'ID du batiment
     */
	public String getId_Batiment() {
		return idBatiment;
	}
    /**
     * Methode pour modifier l'ID du batiment
     */

	public void setIdBatiment(String idBatiment) {
		this.idBatiment = idBatiment;
	}

    /**
     * Methode pour retourner le régime juridique
     */
	public String getRegime_Juridique() {
		return regime_Juridique;
	}

    /**
     * Methode pour modifier le régime juridique
     */
	public void setRegime_Juridique(String regime_Juridique) {
		this.regime_Juridique = regime_Juridique;
	}

    /**
     * Methode pour retourner l'adresse
     */
	public String getAdresse() {
		return adresse;
	}
	
    /**
     * Methode pour retourner le code postal
     */
	public String getCodePostal() {
		return codePostal;
	}

    /**
     * Methode pour modifier l'adresse
     */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

    /**
     * Methode pour retourner la date de construction
     */
	public String getDate_Construction() {
		return date_Construction;
	}

    /**
     * Methode pour modifier la date de construction
     */
	public void setDate_Construction(String date_Construction) {
		this.date_Construction = date_Construction;
	}

    /**
     * Methode pour retourner l'équipement d'accès technique
     */
	public String getEquip_Acces_Tech() {
		return equip_Acces_Tech;
	}

    /**
     * Methode pour modifier l'équipement d'accès technique
     */
	public void setEquip_Acces_Tech(String equip_Acces_Tech) {
		this.equip_Acces_Tech = equip_Acces_Tech;
	}

    /**
     * Methode pour retourner l'énumération des parties communes
     */
	public String getEnum_Parties_Communes() {
		return enum_Parties_Communes;
	}

    /**
     * Methode pour modifier l'énumération des parties communes
     */
	public void setEnum_Parties_Communes(String enum_Parties_Communes) {
		this.enum_Parties_Communes = enum_Parties_Communes;
	}
}
