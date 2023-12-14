package modele.dao.requetes;

import modele.Diagnostic;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectDiagnostic extends Requete<Diagnostic> {
    @Override
    public String requete() {
        return "SELECT * FROM Diagnostic";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Diagnostic donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
