package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modele.Locataire;
import modele.Taxe;
public class DaoTaxe extends DaoModele<Taxe> implements Dao<Taxe> {

	@Override
	public Collection<Taxe> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Taxe findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Taxe donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Taxe donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Taxe donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Taxe creerInstance(ResultSet curseur) throws SQLException {
        Taxe taxe = null;
        try {
            taxe = new Taxe(
                    curseur.getString("ID_TAXE_FONCIERE"),
                    curseur.getDouble("BASE_IMPOSITION"),
                    curseur.getDouble("TYPE_TAXE"),
                    curseur.getDouble("TAUX"),
                    curseur.getString("DATE_TAXE")
            );
        } catch (SQLException e) {
            // Handle the exception appropriately, e.g., log or throw a custom exception
            e.printStackTrace();
        }
        return taxe;
    }


}
