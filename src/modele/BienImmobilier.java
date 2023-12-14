package modele;

import java.util.LinkedList;
import java.util.List;

// Class for Bien_Immobilier
public class BienImmobilier {
	private String idBienImm;
	private double surface;
	private String mode_Chauffage;
	private String mode_Eau;
	private int nb_Piece;
	private String type_Bien;
	private String nom_Proprio;
	private String identifiant;
	private String etage;
	private static String id_Batiment;
	private List<Locataire> locataires=new LinkedList<>();

	public BienImmobilier(String idBienImm, double surface, String mode_Chauffage, String mode_Eau, int nb_Piece,
			String type_Bien, String nom_Proprio, String identifiant, String etage,String id_Batiment) {
		this.identifiant=identifiant;
		this.surface = surface;
		this.mode_Chauffage = mode_Chauffage;
		this.mode_Eau = mode_Eau;
		this.nb_Piece = nb_Piece;
		this.type_Bien = type_Bien;
		this.nom_Proprio = nom_Proprio;
		this.etage = etage;
		this.idBienImm= idBienImm;
		this.id_Batiment=id_Batiment;
	}

	public String getId_Bien_Imm() {
		return idBienImm;
	}

	public void setIdBienImm(String idBienImm) {
		this.idBienImm = idBienImm;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public String getMode_Chauffage() {
		return mode_Chauffage;
	}

	public void setMode_Chauffage(String mode_Chauffage) {
		this.mode_Chauffage = mode_Chauffage;
	}

	public String getMode_Eau() {
		return mode_Eau;
	}

	public void setMode_Eau(String mode_Eau) {
		this.mode_Eau = mode_Eau;
	}

	public int getNb_Piece() {
		return nb_Piece;
	}

	public void setNb_Piece(int nb_Piece) {
		this.nb_Piece = nb_Piece;
	}

	public String getType_Bien() {
		return type_Bien;
	}

	public void setType_Bien(String type_Bien) {
		this.type_Bien = type_Bien;
	}

	public String getNom_Proprio() {
		return nom_Proprio;
	}

	public void setNom_Proprio(String nom_Proprio) {
		this.nom_Proprio = nom_Proprio;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getEtage() {
		return etage;
	}

	public void setEtage(String etage) {
		this.etage = etage;
	}

	public String getId_Batiment() {
		return id_Batiment;
	}
	
	public void ajoutLocataire(Locataire locataire) {
		this.locataires.add(locataire);
	}
	
	public List<Locataire> voirLocataires(){
		return this.locataires;
	}

}
