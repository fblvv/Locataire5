package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.Batiment;
import modele.Locataire;
import modele.dao.requetes.RequeteSelectBatimentById;
import modele.dao.requetes.RequeteSelectLocataire;
import modele.dao.requetes.RequeteSelectLocataireById;
import modele.dao.requetes.SousProgrammeDeleteLocataire;
import modele.dao.requetes.SousProgrammeInsertLocataire;

public class DaoLocataire extends DaoModele<Locataire> implements Dao<Locataire> {

	@Override
	public Collection<Locataire> findAll() throws SQLException {

		RequeteSelectLocataire locataire = new RequeteSelectLocataire();
		return find(locataire);

	}

	@Override
	public Locataire findById(String... id) throws SQLException {
    	Locataire locataire = findById(new RequeteSelectLocataireById(), id);
        return locataire;
	}

	@Override
	public void update(Locataire donnee) throws SQLException {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void create(Locataire locataire) throws SQLException {
	    SousProgrammeInsertLocataire sousProgrammeInsertLocataire = new SousProgrammeInsertLocataire();
	    CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertLocataire.appelSousProgramme());
	        sousProgrammeInsertLocataire.parametres(cs, locataire);
	        cs.execute();
	  
	}



    
    @Override
    public void delete(Locataire locataire) throws SQLException {
        SousProgrammeDeleteLocataire sousProgrammeDeleteLocataire = new SousProgrammeDeleteLocataire();
        try (CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeDeleteLocataire.appelSousProgramme())) {
            sousProgrammeDeleteLocataire.parametres(cs, locataire);
            cs.execute();
        }
    }


	@Override
	protected Locataire creerInstance(ResultSet curseur) throws SQLException {
		Locataire locataire = null;
		try {
			locataire = new Locataire(
					curseur.getString("ID_LOCATAIRE"),
					curseur.getString("NOM"),
					curseur.getString("PRENOM"),
					curseur.getString("TELEPHONE"),
					curseur.getString("MAIL"),
					curseur.getString("ADRESSE"),
					curseur.getString("CODE_POSTAL")
					);
		} catch (SQLException e) {
			// Handle the exception appropriately, e.g., log or throw a custom exception
			e.printStackTrace();
		}
		return locataire;
	}



}
