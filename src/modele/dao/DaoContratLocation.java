package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.Batiment;
import modele.ContratLocation;
import modele.dao.requetes.RequeteSelectBatimentById;
import modele.dao.requetes.RequeteSelectContratLocation;
import modele.dao.requetes.RequeteSelectContratLocationById;
import modele.dao.requetes.SousProgrammeInsertContrat;

public class DaoContratLocation extends DaoModele<ContratLocation> implements Dao<ContratLocation> {

	@Override
	public Collection<ContratLocation> findAll() throws SQLException {
    	RequeteSelectContratLocation contratLocation = new RequeteSelectContratLocation();
		return find(contratLocation);
	}

	@Override
	public ContratLocation findById(String... id) throws SQLException {
    	List<ContratLocation> contratLocation = find(new RequeteSelectContratLocationById(), id);
        if (contratLocation.isEmpty()) {
            return null;
        }
        return contratLocation.get(0);
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
	        String dateVersementLoyer = curseur.getString("Date_De_Versement_Loyer");
	        String dateEntree = curseur.getString("Date_Entree");
	        String dateSortie = curseur.getString("Date_Sortie");
	        String depotGarantie = curseur.getString("Depot_De_Garantie");
	        String dateRevision = curseur.getString("Date_Revision");
	        String periodicitePaiement = curseur.getString("Periodicite_Paiement");
	        String dateFinContrat = curseur.getString("Date_Fin_Contrat");
	        double chargesProvisionnelles = curseur.getDouble("Charges_Provisionnelles");
	        String idICC = curseur.getString("Id_ICC");
	        double caution = curseur.getDouble("Caution");
	        String idBien =curseur.getString("IdBien");

	        // Créer et retourner une nouvelle instance de ContratLocation
	        ContratLocation contratLocation = new ContratLocation(id,dateDebutContrat,montant,montantLoyer
	        		,dateVersementLoyer,dateEntree,dateSortie,depotGarantie,dateRevision,
	        		periodicitePaiement,dateFinContrat,chargesProvisionnelles,idICC,caution,
	        		idBien);

	        // Vous n'avez pas de colonne Id_Bien_Imm dans votre SELECT, donc je suppose que vous le récupérez d'une autre manière
	        // Supposons que vous avez une colonne Id_Bien_Imm dans votre table Contrat_Location


	        return contratLocation;
	    }
}
