package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import SQL.CictOracleDataSource;
import modele.Assurance;
import modele.dao.requetes.SousProgrammeInsertAssurance;

public class DaoAssurance extends DaoModele<Assurance> implements Dao<Assurance> {

	@Override
	public Collection<Assurance> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assurance findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Assurance donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Assurance donnee) throws SQLException {
		// TODO Auto-generated method stub
		SousProgrammeInsertAssurance sousProgrammeInsertAssurance = new SousProgrammeInsertAssurance();
        CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertAssurance.appelSousProgramme());
        sousProgrammeInsertAssurance.parametres(cs, donnee);
            cs.execute();
		
	}

	@Override
	public void delete(Assurance donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Assurance creerInstance(ResultSet curseur) throws SQLException {
	    Assurance assurance = new Assurance(
	        curseur.getString("numPolice"),
	        curseur.getString("tarifInitial"),
	        curseur.getString("typeAssurance"),
	        curseur.getString("dateEffetDebut"),
	        curseur.getString("idBienImm"),
	        curseur.getString("idBatiment")
	    );

	    // You may want to set other properties of Assurance based on your data model

	    return assurance;
	}


}
