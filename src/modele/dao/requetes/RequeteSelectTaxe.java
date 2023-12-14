package modele.dao.requetes;

import modele.Taxe;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectTaxe extends Requete<Taxe> {
    @Override
    public String requete() {
        return "SELECT * FROM Taxe";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Taxe donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
