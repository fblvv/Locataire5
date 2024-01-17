package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import SQL.CictOracleDataSource;
import modele.Entreprise;
import modele.dao.requetes.RequeteSelectEntreprise;
import modele.dao.requetes.RequeteSelectEntrepriseById;
import modele.dao.requetes.SousProgrammeInsertEntreprise;
// Other imports as necessary

public class DaoEntreprise extends DaoModele<Entreprise> implements Dao<Entreprise> {

    @Override
    public Collection<Entreprise> findAll() throws SQLException {
        RequeteSelectEntreprise requete = new RequeteSelectEntreprise();
        return find(requete);
    }

    @Override
    public Entreprise findById(String... id) throws SQLException {
        List<Entreprise> entreprises = find(new RequeteSelectEntrepriseById(), id);
        if (entreprises.isEmpty()) {
            return null;
        }
        return entreprises.get(0);
    }

    @Override
    public void create(Entreprise entreprise) throws SQLException {
        SousProgrammeInsertEntreprise sousProgramme = new SousProgrammeInsertEntreprise();
        CallableStatement cs = CictOracleDataSource.getConnectionBD().prepareCall(sousProgramme.appelSousProgramme());
        sousProgramme.parametres(cs, entreprise);
        cs.execute();
    }

    @Override
    public void update(Entreprise entreprise) throws SQLException {
        // Implement the update logic here
    }

    @Override
    public void delete(Entreprise entreprise) throws SQLException {
        // Implement the delete logic here
    }

    @Override
    protected Entreprise creerInstance(ResultSet curseur) throws SQLException {
        Entreprise entreprise = null;
        try {
            entreprise = new Entreprise(
                curseur.getString("SIREN"),
                curseur.getString("ADRESSE_ENTREPRISE"),
                curseur.getString("TEL_ENTREPRISE"),
                curseur.getString("MAIL_ENTREPRISE")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entreprise;
    }

    // Additional methods or inner classes as required
}
