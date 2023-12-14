package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modele.Contenir;

public class DaoContenir extends DaoModele<Contenir> implements Dao<Contenir> {

	@Override
	public Collection<Contenir> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contenir findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Contenir donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Contenir donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Contenir donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Contenir creerInstance(ResultSet curseur) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
