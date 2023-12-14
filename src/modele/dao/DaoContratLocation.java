package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modele.ContratLocation;

public class DaoContratLocation extends DaoModele<ContratLocation> implements Dao<ContratLocation> {

	@Override
	public Collection<ContratLocation> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContratLocation findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ContratLocation donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(ContratLocation donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ContratLocation donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	 @Override
	    protected ContratLocation creerInstance(ResultSet curseur) throws SQLException {
	        // Récupérer les valeurs de la base de données
	        String dateDebutContrat = curseur.getString("Date_Debut_Contrat");
	        double montant = curseur.getDouble("Montant");
	        String montantDernierLoyer = curseur.getString("Montant_Dernier_Loyer");
	        String dateVersementLoyer = curseur.getString("Date_Versement_Loyer");
	        String depotGarantie = curseur.getString("Depot_Garantie");
	        String dateRevision = curseur.getString("Date_Revision");
	        String periodicitePaiement = curseur.getString("Periodicite_Paiement");
	        String dateFinContrat = curseur.getString("Date_Fin_Contrat");
	        double chargesProvisionnelles = curseur.getDouble("Charges_Provisionnelles");
	        String idICC = curseur.getString("Id_ICC");
	        String valeurICC = curseur.getString("Valeur_ICC");

	        // Créer et retourner une nouvelle instance de ContratLocation
	        ContratLocation contratLocation = new ContratLocation(dateDebutContrat, montant, montantDernierLoyer,
	                dateVersementLoyer, depotGarantie, dateRevision, periodicitePaiement, dateFinContrat,
	                chargesProvisionnelles, idICC, valeurICC);

	        // Vous n'avez pas de colonne Id_Bien_Imm dans votre SELECT, donc je suppose que vous le récupérez d'une autre manière
	        // Supposons que vous avez une colonne Id_Bien_Imm dans votre table Contrat_Location
	        String idBienImm = curseur.getString("Id_Bien_Imm");
	        contratLocation.setIdBienImm(idBienImm);

	        return contratLocation;
	    }
}
