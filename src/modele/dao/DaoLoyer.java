package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.Loyer;
import modele.Locataire;
import modele.Loyer;
import modele.dao.requetes.RequeteSelectLoyer;
import modele.dao.requetes.RequeteSelectLoyerById;
import modele.dao.requetes.SousProgrammeInsertLoyer;

public class DaoLoyer extends DaoModele<Loyer> implements Dao<Loyer> {
	
	
	
	@Override
	public Collection<Loyer> findAll() throws SQLException {
		// TODO Auto-generated method stub
		RequeteSelectLoyer sketuveux = new RequeteSelectLoyer();
		return find(sketuveux);
	}

	@Override
	public Loyer findById(String... id) throws SQLException {
		List<Loyer> bien = find(new RequeteSelectLoyerById(), id);
        if (bien.isEmpty()) {
            return null;
        }
        return bien.get(0);
	}

	@Override
	public void update(Loyer donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Loyer bien) throws SQLException {
		// TODO Auto-generated method stub
		SousProgrammeInsertLoyer sousProgrammeInsertLoyer = new SousProgrammeInsertLoyer();
	    CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertLoyer.appelSousProgramme());
	        sousProgrammeInsertLoyer.parametres(cs, bien);
	        cs.execute();
	}

	@Override
	public void delete(Loyer donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Loyer creerInstance(ResultSet curseur) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
