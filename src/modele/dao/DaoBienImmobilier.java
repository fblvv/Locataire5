package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.BienImmobilier;
import modele.dao.requetes.RequeteSelectBatiment;
import modele.dao.requetes.RequeteSelectBienImmobilier;
import modele.dao.requetes.RequeteSelectBienImmobilierById;
import modele.dao.requetes.SousProgrammeInsertBienImmobilier;

public class DaoBienImmobilier  extends DaoModele<BienImmobilier> implements Dao<BienImmobilier> {

	@Override
	public Collection<BienImmobilier> findAll() throws SQLException {
		// TODO Auto-generated method stub
		RequeteSelectBienImmobilier sketuveux = new RequeteSelectBienImmobilier();
		return find(sketuveux);
	}

	@Override
	public BienImmobilier findById(String... id) throws SQLException {
		List<BienImmobilier> bien = find(new RequeteSelectBienImmobilierById(), id);
        if (bien.isEmpty()) {
            return null;
        }
        return bien.get(0);
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
}
