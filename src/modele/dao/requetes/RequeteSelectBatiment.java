package modele.dao.requetes;

import modele.Batiment;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectBatiment extends Requete<Batiment> {
    @Override
    public String requete() {
        return "SELECT * FROM Batiment";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Batiment donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
