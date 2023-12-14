package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modele.Diagnostic;

public class DaoDiagnostic extends DaoModele<Diagnostic> implements Dao<Diagnostic> {

	@Override
	public Collection<Diagnostic> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diagnostic findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Diagnostic donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Diagnostic donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Diagnostic donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Diagnostic creerInstance(ResultSet cursor) throws SQLException {
	    Diagnostic diagnostic = null;
	    try {
	        diagnostic = new Diagnostic(
	                cursor.getString("REF_DIAGNOSTIC"),
	                cursor.getString("TYPE_DIAGNOSTIC"),
	                cursor.getString("DIAGNOSTIQUEUR"),
	                cursor.getString("DATE_VISITE"),
	                cursor.getString("DATE_VALIDITE"),
	                cursor.getString("NATURE_TRAVAUX"),
	                cursor.getString("DEPENSES_REPARATIONS")
	        );
	    } catch (SQLException e) {
	        // Handle the exception appropriately, e.g., log or throw a custom exception
	        e.printStackTrace();
	    }
	    return diagnostic;
	}

}
