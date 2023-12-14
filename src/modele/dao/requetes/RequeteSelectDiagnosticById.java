package modele.dao.requetes;

import modele.Diagnostic;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectDiagnosticById extends Requete<Diagnostic> {
    @Override
    public String requete() {
        return "SELECT * FROM DIAGNOSTIC WHERE REF_DIAGNOSTIC = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Diagnostic data) throws SQLException {
        prSt.setString(1, data.getRefDiagnostic());
    }
}
