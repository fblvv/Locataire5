package modele.dao.requetes;

import modele.Contenir;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectContenir extends Requete<Contenir> {
    @Override
    public String requete() {
        return "SELECT * FROM Contenir";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Contenir donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
