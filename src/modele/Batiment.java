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

	public String getId_Batiment() {
		return idBatiment;
	}

	public void setIdBatiment(String idBatiment) {
		this.idBatiment = idBatiment;
	}

	public String getRegime_Juridique() {
		return regime_Juridique;
	}

	public void setRegime_Juridique(String regime_Juridique) {
		this.regime_Juridique = regime_Juridique;
	}

	public String getAdresse() {
		return adresse;
	}
	
	public String getCodePostal() {
		return codePostal;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDate_Construction() {
		return date_Construction;
	}

	public void setDate_Construction(String date_Construction) {
		this.date_Construction = date_Construction;
	}

	public String getEquip_Acces_Tech() {
		return equip_Acces_Tech;
	}

	public void setEquip_Acces_Tech(String equip_Acces_Tech) {
		this.equip_Acces_Tech = equip_Acces_Tech;
	}

	public String getEnum_Parties_Communes() {
		return enum_Parties_Communes;
	}

	public void setEnum_Parties_Communes(String enum_Parties_Communes) {
		this.enum_Parties_Communes = enum_Parties_Communes;
	}
}
