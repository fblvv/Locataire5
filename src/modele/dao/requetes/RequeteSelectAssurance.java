package modele.dao.requetes;




import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Assurance;

public class RequeteSelectAssurance extends Requete<Assurance> {
    @Override
    public String requete() {
        return "SELECT * FROM Assurance";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Assurance donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
