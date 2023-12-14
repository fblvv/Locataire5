package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modele.Compteur;

public class DaoCompteur extends DaoModele<Compteur> implements Dao<Compteur> {

	@Override
	public Collection<Compteur> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
	public void create(Compteur donnee) throws SQLException {
		// TODO Auto-generated method stub
		
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
        double valeur = curseur.getDouble("Valeur");

        // Créer et retourner une nouvelle instance de Compteur
        Compteur compteur = new Compteur(idCompteur, dateReleve, typeCompteur, valeur);
        
        
        String idBienImm = curseur.getString("Id_Bien_Imm");
        compteur.setIdBienImm(idBienImm);

        return compteur;
    }
}
