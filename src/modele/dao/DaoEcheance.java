package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modele.Echeance;

public class DaoEcheance extends DaoModele<Echeance> implements Dao<Echeance> {

	@Override
	public Collection<Echeance> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Echeance findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Echeance donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Echeance donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Echeance donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
    protected Echeance creerInstance(ResultSet curseur) throws SQLException {
        Echeance echeance = null;
        try {
            echeance = new Echeance(
                    curseur.getString("DATE_ECHEANCE"),
                    curseur.getDouble("MONTANT")
            );
        } catch (SQLException e) {
            // Handle the exception appropriately, e.g., log or throw a custom exception
            e.printStackTrace();
        }
        return echeance;
    }


}
