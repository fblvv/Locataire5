package modele.dao.requetes;

import modele.Echeance;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectEcheance extends Requete<Echeance> {
    @Override
    public String requete() {
        return "SELECT * FROM Echeance";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Echeance donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
