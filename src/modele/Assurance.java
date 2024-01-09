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

	public String getNumPolice() {
		return numPolice;
	}

	public void setNumPolice(String numPolice) {
		this.numPolice = numPolice;
	}

	public String getTarifInitial() {
		return tarifInitial;
	}

	public void setTarifInitial(String tarifInitial) {
		this.tarifInitial = tarifInitial;
	}

	public String getTypeAssurance() {
		return typeAssurance;
	}

	public void setTypeAssurance(String typeAssurance) {
		this.typeAssurance = typeAssurance;
	}

	public String getDateEffetDebut() {
		return dateEffetDebut;
	}

	public void setDateEffetDebut(String dateEffetDebut) {
		this.dateEffetDebut = dateEffetDebut;
	}

	public String getIdBienImm() {
		return idBienImm;
	}


	public String getIdBatiment() {
		return idBatiment;
	}


}
