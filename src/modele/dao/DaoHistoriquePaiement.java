package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modele.HistoriquePaiement;

public class DaoHistoriquePaiement extends DaoModele<HistoriquePaiement> implements Dao<HistoriquePaiement> {

	@Override
	public Collection<HistoriquePaiement> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistoriquePaiement findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HistoriquePaiement donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(HistoriquePaiement donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(HistoriquePaiement donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
    protected HistoriquePaiement creerInstance(ResultSet curseur) throws SQLException {
        HistoriquePaiement historiquePaiement = null;
        try {
            historiquePaiement = new HistoriquePaiement(
                    curseur.getString("ID_HIST_PAIEMENT"),
                    curseur.getString("STOCKER"),
                    curseur.getString("DATE_DEBUT_CONTRAT")
            );
        } catch (SQLException e) {
            // Handle the exception appropriately, e.g., log or throw a custom exception
            e.printStackTrace();
        }
        return historiquePaiement;
    }


}
