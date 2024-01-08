package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.Loyer;
import modele.dao.requetes.RequeteSelectLoyer;
import modele.dao.requetes.RequeteSelectLoyerById;
import modele.dao.requetes.SousProgrammeInsertLoyer;

public class DaoLoyer extends DaoModele<Loyer> implements Dao<Loyer> {
	
	@Override
	public Collection<Loyer> findAll() throws SQLException {
		RequeteSelectLoyer requeteSelectLoyer = new RequeteSelectLoyer();
		return find(requeteSelectLoyer);
	}

	@Override
	public Loyer findById(String... id) throws SQLException {
		List<Loyer> loyers = find(new RequeteSelectLoyerById(), id);
		if (loyers.isEmpty()) {
			return null;
		}
		return loyers.get(0);
	}
	
	
	public Collection<Loyer> findByIds(String... id) throws SQLException {
		Collection<Loyer> loyers = find(new RequeteSelectLoyerById(), id);
		if (loyers.isEmpty()) {
			return Collections.emptyList();
		}
		return loyers;
	}


	@Override
	public void update(Loyer loyer) throws SQLException {
		// TODO: Implémentez la mise à jour du loyer dans la base de données
	}

	@Override
	public void create(Loyer loyer) throws SQLException {
		SousProgrammeInsertLoyer sousProgrammeInsertLoyer = new SousProgrammeInsertLoyer();
		CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertLoyer.appelSousProgramme());
		sousProgrammeInsertLoyer.parametres(cs, loyer);
		cs.execute();
	}

	@Override
	public void delete(Loyer loyer) throws SQLException {
		// TODO: Implémentez la suppression du loyer de la base de données
	}

	@Override
	protected Loyer creerInstance(ResultSet curseur) throws SQLException {
		Loyer loyer = new Loyer(
			curseur.getString("Id_Loyer"),
			curseur.getDouble("Loyer_charges"),
			curseur.getDouble("Charges"),
			curseur.getString("Date_paiement"),
			curseur.getDouble("Montant_paiement"),
			curseur.getString("Type_paiement"),
			curseur.getString("Id_locataire"),
			curseur.getString("Date_Debut_Contrat")
		);
		return loyer;
	}
}
