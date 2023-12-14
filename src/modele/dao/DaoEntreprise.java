package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modele.Entreprise;

public class DaoEntreprise extends DaoModele<Entreprise> implements Dao<Entreprise> {

	@Override
	public Collection<Entreprise> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entreprise findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Entreprise donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Entreprise donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Entreprise donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
    protected Entreprise creerInstance(ResultSet curseur) throws SQLException {
        Entreprise entreprise = null;
        try {
            entreprise = new Entreprise(
                    curseur.getString("SIREN"),
                    curseur.getString("ADRESSE_ENTREPRISE"),
                    curseur.getString("TEL_ENTREPRISE"),
                    curseur.getString("MAIL_ENTREPRISE")
            );
        } catch (SQLException e) {
            // Handle the exception appropriately, e.g., log or throw a custom exception
            e.printStackTrace();
        }
        return entreprise;
    }

}
