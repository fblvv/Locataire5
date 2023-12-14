package modele.dao.requetes;

import modele.Charges;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectCharges extends Requete<Charges> {
    @Override
    public String requete() {
        return "SELECT * FROM Charges";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Charges donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
