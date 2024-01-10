package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.Batiment;
import modele.BienImmobilier;
import modele.dao.requetes.RequeteSelectBatiment;
import modele.dao.requetes.RequeteSelectBatimentById;
import modele.dao.requetes.RequeteSelectBienImmobilierById;
import modele.dao.requetes.RequeteSelectLocataire;
import modele.dao.requetes.SousProgrammeInsertBatiment;
import modele.dao.requetes.SousProgrammeInsertLocataire;

public class DaoBatiment extends DaoModele<Batiment> implements Dao<Batiment> {

    @Override
    public Collection<Batiment> findAll() throws SQLException {
        // TODO: Implémenter la récupération de tous les enregistrements de la table Batiment
    	RequeteSelectBatiment batiment = new RequeteSelectBatiment();
		return find(batiment);
    }

    @Override
    public Batiment findById(String... id) throws SQLException {
        // TODO: Implémenter la récupération d'un enregistrement par ID
    	List<Batiment> batiment = find(new RequeteSelectBatimentById(), id);
        if (batiment.isEmpty()) {
            return null;
        }
        return batiment.get(0);
    }
    @Override
    public void update(Batiment donnee) throws SQLException {
        // TODO: Implémenter la mise à jour d'un enregistrement
    }

    @Override
    public void create(Batiment batiment) throws SQLException {
        // TODO: Implémenter la création d'un nouvel enregistrement
    	SousProgrammeInsertBatiment sousProgrammeInsertBatiment = new SousProgrammeInsertBatiment();
	    CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertBatiment.appelSousProgramme());
	        sousProgrammeInsertBatiment.parametres(cs,batiment);
	        cs.execute();
    }

    @Override
    public void delete(Batiment donnee) throws SQLException {
        // TODO: Implémenter la suppression d'un enregistrement
    }

    @Override
    protected Batiment creerInstance(ResultSet curseur) throws SQLException {
        // Récupérer les valeurs de la base de données
        String idBatiment = curseur.getString("Id_Batiment");
        String regimeJuridique = curseur.getString("Regime_Juridique");
        String adresse = curseur.getString("Adresse");
        String codePostal = curseur.getString("Code_postal");
        String dateConstruction = curseur.getString("Date_Construction");
        String equipAccesTech = curseur.getString("Equip_Acces_Tech");
        String enumPartiesCommunes = curseur.getString("Enum_Parties_Communes");
        

        // Créer et retourner une nouvelle instance de Batiment
        return new Batiment(idBatiment, regimeJuridique, adresse,dateConstruction, equipAccesTech, enumPartiesCommunes,codePostal);
    }
}
