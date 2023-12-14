package modele.dao.requetes;

import modele.Taxe;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectTaxeById extends Requete<Taxe> {
    @Override
    public String requete() {
        return "SELECT * FROM TAXE WHERE ID_TAXE_FONCIERE = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Taxe data) throws SQLException {
        prSt.setString(1, data.getIdTaxeFonciere());
    }
}
