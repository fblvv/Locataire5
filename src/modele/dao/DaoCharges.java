package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modele.Charges;

public class DaoCharges extends DaoModele<Charges> implements Dao<Charges> {

	@Override
	public Collection<Charges> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Charges findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Charges donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Charges donnee) throws SQLException {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void delete(Charges donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
    protected Charges creerInstance(ResultSet curseur) throws SQLException {
        // Récupérer les valeurs de la base de données
        String idBienImm = curseur.getString("Id_Bien_Imm");
        double montant = curseur.getDouble("Montant");
        String dateCharge = curseur.getString("Date_Charge");
        String typeCharge = curseur.getString("Type_Charge");
        String pourcentagePartEntretien = curseur.getString("Pourcentage_Part_Entretien");

        // Créer et retourner une nouvelle instance de Charges
        return new Charges(idBienImm, montant, dateCharge, typeCharge, pourcentagePartEntretien);
    }
}

