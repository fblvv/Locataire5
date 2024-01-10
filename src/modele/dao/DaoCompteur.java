package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import SQL.CictOracleDataSource;
import modele.Compteur;
import modele.dao.requetes.RequeteSelectCompteur;
import modele.dao.requetes.SousProgrammeInsertCompteur;

public class DaoCompteur extends DaoModele<Compteur> implements Dao<Compteur> {

	@Override
	public Collection<Compteur> findAll() throws SQLException {
		// TODO Auto-generated method stub
		RequeteSelectCompteur compteur = new RequeteSelectCompteur();
		return find(compteur);
	}

	@Override
	public Compteur findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Compteur donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Compteur compteur) throws SQLException {
		// TODO Auto-generated method stub
		SousProgrammeInsertCompteur sousProgrammeInsertCompteur = new SousProgrammeInsertCompteur();
	    CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertCompteur.appelSousProgramme());
	        sousProgrammeInsertCompteur.parametres(cs, compteur);
	        cs.execute();
		
	}

	@Override
	public void delete(Compteur donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

    protected Compteur creerInstance(ResultSet curseur) throws SQLException {
        // Récupérer les valeurs de la base de données
    	String idCompteur = curseur.getString("Id_Compteur");
    	String dateReleve = curseur.getString("Date_Releve");
    	String typeCompteur = curseur.getString("Type_Compteur");
    	Double valeur = curseur.getDouble("Valeur");
    	String idBienImm = curseur.getString("Id_Bien_Imm");


        // Créer et retourner une nouvelle instance de Compteur
        Compteur compteur = new Compteur(idCompteur, dateReleve, typeCompteur, valeur,idBienImm);
        

        return compteur;
    }
}
