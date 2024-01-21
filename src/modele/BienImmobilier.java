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
	private String id_Batiment;
	private String diagnostique;
	private String garage;
	private List<Locataire> locataires=new LinkedList<>();

	public BienImmobilier(String idBienImm, double surface, String mode_Chauffage, String mode_Eau, int nb_Piece,
			String type_Bien, String nom_Proprio, String identifiant, String etage,String id_Batiment, String diagnostique, String garage) {
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
		this.diagnostique =diagnostique;
		this.garage = garage;
	}

    /**
     * Methode pour retourner l'ID du bien immobilier
     */
	public String getId_Bien_Imm() {
		return idBienImm;
	}

    /**
     * Methode pour modifier l'ID du bien immobilier
     */
	public void setIdBienImm(String idBienImm) {
		this.idBienImm = idBienImm;
	}

    /**
     * Methode pour retourner la surface
     */
	public double getSurface() {
		return surface;
	}

	 /**
     * Methode pour modifier la surface
     */
	public void setSurface(double surface) {
		this.surface = surface;
	}

    /**
     * Methode pour retourner le mode de chauffage
     */
	public String getMode_Chauffage() {
		return mode_Chauffage;
	}

    /**
     * Methode pour modifier le mode de chauffage
     */
	public void setMode_Chauffage(String mode_Chauffage) {
		this.mode_Chauffage = mode_Chauffage;
	}

    /**
     * Methode pour retourner le mode d'eau
     */
	public String getMode_Eau() {
		return mode_Eau;
	}

    /**
     * Methode pour modifier le mode d'eau
     */
	public void setMode_Eau(String mode_Eau) {
		this.mode_Eau = mode_Eau;
	}

    /**
     * Methode pour retourner le nombre de pièces
     */
	public int getNb_Piece() {
		return nb_Piece;
	}

    /**
     * Methode pour modifier le nombre de pièces
     */
	public void setNb_Piece(int nb_Piece) {
		this.nb_Piece = nb_Piece;
	}

    /**
     * Methode pour retourner le type de bien
     */
	public String getType_Bien() {
		return type_Bien;
	}

    /**
     * Methode pour modifier le type de bien
     */
	public void setType_Bien(String type_Bien) {
		this.type_Bien = type_Bien;
	}

    /**
     * Methode pour retourner le nom du propriétaire
     */
	public String getNom_Proprio() {
		return nom_Proprio;
	}

    /**
     * Methode pour modifier le nom du propriétaire
     */
	public void setNom_Proprio(String nom_Proprio) {
		this.nom_Proprio = nom_Proprio;
	}

    /**
     * Methode pour retourner l'identifiant
     */
	public String getIdentifiant() {
		return identifiant;
	}

    /**
     * Methode pour modifier l'identifiant
     */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

    /**
     * Methode pour retourner l'étage
     */

	public String getEtage() {
		return etage;
	}

    /**
     * Methode pour modifier l'étage
     */
	public void setEtage(String etage) {
		this.etage = etage;
	}

    /**
     * Methode pour retourner l'ID du batiment
     */
	public String getId_Batiment() {
		return id_Batiment;
	}
	
    /**
     * Methode pour ajouter un locataire à la liste
     */
	public void ajoutLocataire(Locataire locataire) {
		this.locataires.add(locataire);
	}
	
    /**
     * Methode pour voir la liste des locataires
     */
	public List<Locataire> voirLocataires(){
		return this.locataires;
	}

    /**
     * Methode pour retourner le diagnostic
     */
	public String getDIAGNOSTIQUE() {
		return diagnostique;
	}
    /**
     * Methode pour modifier le diagnostic
     */
	public void setDIAGNOSTIQUE(String dIAGNOSTIQUE) {
		diagnostique = dIAGNOSTIQUE;
	}

    /**
     * Methode pour retourner l'information sur le garage
     */
	public String getGarage() {
		return garage;
	}

    /**
     * Methode pour modifier l'information sur le garage
     */
	public void setGarage(String garage) {
		this.garage = garage;
	}
	

}
