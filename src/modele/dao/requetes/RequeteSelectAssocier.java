package modele.dao.requetes;

import modele.Associer;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectAssocier extends Requete<Associer> {
    @Override
    public String requete() {
        return "SELECT * FROM Associer";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Associer donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
