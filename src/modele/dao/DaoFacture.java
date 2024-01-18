package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.Facture;
import modele.dao.requetes.RequeteSelectFacture;
import modele.dao.requetes.RequeteSelectFactureById;
import modele.dao.requetes.SousProgrammeInsertFacture;

public class DaoFacture extends DaoModele<Facture> implements Dao<Facture> {

	@Override
	public Collection<Facture> findAll() throws SQLException {
		RequeteSelectFacture facture = new RequeteSelectFacture();
		return find(facture);
	}

	@Override
	public Facture findById(String... id) throws SQLException {
		List<Facture> facture = find(new RequeteSelectFactureById(), id);
        if (facture.isEmpty()) {
            return null;
        }
        return facture.get(0);
	}

	@Override
	public void update(Facture donnee) throws SQLException {
		
	}

	@Override
	public void create(Facture facture) throws SQLException {
		SousProgrammeInsertFacture sousProgrammeInsertFacture = new SousProgrammeInsertFacture();
	    CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertFacture.appelSousProgramme());
	    sousProgrammeInsertFacture.parametres(cs, facture);
	        cs.execute();
	}

	@Override
	public void delete(Facture donnee) throws SQLException {
		
	}

	 @Override
    protected Facture creerInstance(ResultSet curseur) throws SQLException {
        Facture facture = null;
        try {
            facture = new Facture(
            		curseur.getString("ID_FACTURE"),
            		curseur.getString("SIREN"),
                    curseur.getDouble("PRIX"),
                    curseur.getString("TYPE_ENTRETIEN"),
                    curseur.getString("DATE_FACTURE"),
                    curseur.getString("ID_BIEN_IMM"),
                    curseur.getString("ID_BATIMENT")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facture;
    }
}
