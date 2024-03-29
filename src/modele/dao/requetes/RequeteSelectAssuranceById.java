package modele.dao.requetes;

import modele.Assurance;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectAssuranceById extends Requete<Assurance> {
    @Override
    public String requete() {
        return "SELECT * FROM ASSURANCE WHERE ID_BIEN_IMM = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Assurance data) throws SQLException {
        prSt.setString(1, data.getNumPolice());
    }
}
