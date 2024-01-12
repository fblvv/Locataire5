package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.BienImmobilier;
import modele.Charges;
import modele.dao.requetes.RequeteSelectBienImmobilier;
import modele.dao.requetes.RequeteSelectBienImmobilierById;
import modele.dao.requetes.RequeteSelectCharges;
import modele.dao.requetes.RequeteSelectChargesById;
import modele.dao.requetes.SousProgrammeInsertCharges;

public class DaoCharges extends DaoModele<Charges> implements Dao<Charges> {

	@Override
	public Collection<Charges> findAll() throws SQLException {
		RequeteSelectCharges charge = new RequeteSelectCharges();
		return find(charge);
	}

	@Override
	public Charges findById(String... id) throws SQLException {
		List<Charges> charge = find(new RequeteSelectChargesById(), id);
        if (charge.isEmpty()) {
            return null;
        }
        return charge.get(0);
	}

	@Override
	public void update(Charges donnee) throws SQLException {
		
	}

	@Override
	public void create(Charges charge) throws SQLException {
		SousProgrammeInsertCharges sousProgrammeInsertCharges = new SousProgrammeInsertCharges();
	    CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertCharges.appelSousProgramme());
	        sousProgrammeInsertCharges.parametres(cs, charge);
	        cs.execute();
		
		
	}

	@Override
	public void delete(Charges donnee) throws SQLException {
 }

	
	@Override
    protected Charges creerInstance(ResultSet curseur) throws SQLException {
        // Récupérer les valeurs de la base de données
		String idCharge = curseur.getString("ID_CHARGES");
        String idBienImm = curseur.getString("Id_Bien_Imm");
        double montant = curseur.getDouble("Montant");
        String dateCharge = curseur.getString("Date_Charge");
        String typeCharge = curseur.getString("Type_Charge");
        String pourcentagePartEntretien = curseur.getString("Pourcentage_Part_Entretien");

        // Créer et retourner une nouvelle instance de Charges
        return new Charges(idCharge,idBienImm, montant, dateCharge, typeCharge, pourcentagePartEntretien);
    }
}

