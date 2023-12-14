package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import modele.Associer;
import modele.ContratLocation;

import modele.Locataire;

public class DaoAssocier extends DaoModele<Associer> implements Dao<Associer> {

	@Override
	public Collection<Associer> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Associer findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Associer donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Associer donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Associer donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Associer creerInstance(ResultSet curseur) throws SQLException {
	    boolean caution = curseur.getString("caution").equals("0") ? false : true;


	    		    Associer associer = new Associer(
	    		        curseur.getString("dateDebutContrat"),
	    		        curseur.getString("dateEntree"),
	    		        curseur.getString("dateSortie"),
	    		        curseur.getInt("caution")
	    		    );

	    		    // You may want to set other properties of Associer based on your data model

	    		    return associer;


	}

}
