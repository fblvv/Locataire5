package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.BienImmobilier;
import modele.dao.requetes.RequeteOccupationBien;
import modele.dao.requetes.RequeteSelectBatiment;
import modele.dao.requetes.RequeteSelectBienImmobilier;
import modele.dao.requetes.RequeteSelectBienImmobilierById;
import modele.dao.requetes.SousProgrammeInsertBienImmobilier;

public class DaoBienImmobilier  extends DaoModele<BienImmobilier> implements Dao<BienImmobilier> {

	@Override
	public Collection<BienImmobilier> findAll() throws SQLException {
		// TODO Auto-generated method stub
		RequeteSelectBienImmobilier bienImmobilier = new RequeteSelectBienImmobilier();
		return find(bienImmobilier);
	}

	@Override
	public BienImmobilier findById(String... id) throws SQLException {
		List<BienImmobilier> bienImmobilier = find(new RequeteSelectBienImmobilierById(), id);
        if (bienImmobilier.isEmpty()) {
            return null;
        }
        return bienImmobilier.get(0);
	}
	
	

	@Override
	public void update(BienImmobilier donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(BienImmobilier bien) throws SQLException {
		// TODO Auto-generated method stub
		SousProgrammeInsertBienImmobilier sousProgrammeInsertBienImmobilier = new SousProgrammeInsertBienImmobilier();
	    CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgrammeInsertBienImmobilier.appelSousProgramme());
	        sousProgrammeInsertBienImmobilier.parametres(cs, bien);
	        cs.execute();
	}

	@Override
	public void delete(BienImmobilier donnee) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
    protected BienImmobilier creerInstance(ResultSet curseur) throws SQLException {
        // Récupérer les valeurs de la base de données
        String idBienImm = curseur.getString("Id_Bien_Imm");
        double surface = curseur.getDouble("Surface");
        String modeChauffage = curseur.getString("Mode_Chauffage");
        String modeEau = curseur.getString("Mode_Eau");
        int nbPiece = curseur.getInt("Nb_Piece");
        String typeBien = curseur.getString("Type_Bien");
        String nomProprio = curseur.getString("Nom_Proprio");
        String identifiant = curseur.getString("Identifiant");
        String etage = curseur.getString("Etage");
        String idBatiment = curseur.getString("Id_Batiment");

        // Créer et retourner une nouvelle instance de BienImmobilier
        BienImmobilier bienImmobilier = new BienImmobilier(idBienImm, surface, modeChauffage, modeEau, nbPiece, typeBien, nomProprio, identifiant, etage,idBatiment);
        

        return bienImmobilier;
    }
	
	//savoir si un bien est occupé 
	public String estOccupe(String id) {
	    RequeteOccupationBien occupation = new RequeteOccupationBien();
	    
	    try (PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(occupation.requete())) {
	        occupation.parametres(st, id);

	        List<String> statut = new ArrayList<>();
	        try (ResultSet curseur = st.executeQuery()) {
	            while (curseur.next()) {
	                String instance = curseur.getString("Statut_Du_Bien");
	                statut.add(instance);
	            }
	        }

	        return statut.isEmpty() ? "inconnu" : statut.get(0);
	    } catch (SQLException e) {
	        e.printStackTrace(); // Handle the exception according to your needs
	        return "erreur";
	    }
	}
}
