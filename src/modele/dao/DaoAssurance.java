package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.Assurance;
import modele.Batiment;
import modele.dao.requetes.RequeteSelectAssuranceById;
import modele.dao.requetes.RequeteSelectBatimentById;
import modele.dao.requetes.SousProgrammeInsertAssurance;

public class DaoAssurance extends DaoModele<Assurance> implements Dao<Assurance> {

	@Override
	public Collection<Assurance> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assurance findById(String... id) throws SQLException {
		// TODO: Implémenter la récupération d'un enregistrement par ID
    	return findById(new RequeteSelectAssuranceById(), id);
        
    }

	@Override
	public void update(Assurance donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Assurance donnee) throws SQLException {
		// TODO Auto-generated method stub
		SousProgrammeInsertAssurance sousProgrammeInsertAssurance = new SousProgrammeInsertAssurance();
        CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertAssurance.appelSousProgramme());
        sousProgrammeInsertAssurance.parametres(cs, donnee);
            cs.execute();
		
	}

	@Override
	public void delete(Assurance donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Assurance creerInstance(ResultSet curseur) throws SQLException {
	    Assurance assurance = new Assurance(
	        curseur.getString("num_Police"),
	        curseur.getString("tarif_Initial"),
	        curseur.getString("type_Assurance"),
	        curseur.getString("date_Effet_Debut"),
	        curseur.getString("id_Bien_Imm"),
	        curseur.getString("id_Batiment")
	    );

	    

	    return assurance;
	}


}
