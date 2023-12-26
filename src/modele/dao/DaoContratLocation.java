package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import SQL.CictOracleDataSource;
import modele.ContratLocation;
import modele.dao.requetes.SousProgrammeInsertContrat;

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
	public void create(ContratLocation contrat) throws SQLException {
		// TODO Auto-generated method stub
		SousProgrammeInsertContrat sousProgrammeInsertContrat = new SousProgrammeInsertContrat();
	    CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertContrat.appelSousProgramme());
	        sousProgrammeInsertContrat.parametres(cs, contrat);
	        cs.execute();
	}

	@Override
	public void delete(ContratLocation donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	 @Override
	    protected ContratLocation creerInstance(ResultSet curseur) throws SQLException {
	        // Récupérer les valeurs de la base de données
		 	String id = curseur.getString("ID_Locataire");
	        String dateDebutContrat = curseur.getString("Date_Debut_Contrat");
	        double montant = curseur.getDouble("Montant");
	        double montantLoyer = curseur.getDouble("Montant_Loyer");
	        String dateVersementLoyer = curseur.getString("Date_Versement_Loyer");
	        String dateEntree = curseur.getString("Date_Entree");
	        String dateSortie = curseur.getString("Date_Sortie");
	        String depotGarantie = curseur.getString("Depot_Garantie");
	        String dateRevision = curseur.getString("Date_Révision");
	        String periodicitePaiement = curseur.getString("Périodicité_Paiement");
	        String dateFinContrat = curseur.getString("Date_Fin_Contrat");
	        double chargesProvisionnelles = curseur.getDouble("Charges_Provisionnelles");
	        String idICC = curseur.getString("Id_ICC");
	        double valICC= curseur.getDouble("valeur_ICC");
	        double caution = curseur.getDouble("Caution");
	        String idBien =curseur.getString("Id_Bien_Imm");

	        // Créer et retourner une nouvelle instance de ContratLocation
	        ContratLocation contratLocation = new ContratLocation(id,dateDebutContrat,montant,montantLoyer
	        		,dateVersementLoyer,dateEntree,dateSortie,depotGarantie,dateRevision,
	        		periodicitePaiement,dateFinContrat,chargesProvisionnelles,idICC,caution,valICC,
	        		idBien);

	        // Vous n'avez pas de colonne Id_Bien_Imm dans votre SELECT, donc je suppose que vous le récupérez d'une autre manière
	        // Supposons que vous avez une colonne Id_Bien_Imm dans votre table Contrat_Location


	        return contratLocation;
	    }
}
