package modele.dao.requetes;

import modele.GarantCaution;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectGarantCaution extends Requete<GarantCaution> {
    @Override
    public String requete() {
        return "SELECT * FROM Garant_Caution";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, GarantCaution donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
