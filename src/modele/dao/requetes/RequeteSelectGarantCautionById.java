package modele.dao.requetes;

import modele.GarantCaution;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectGarantCautionById extends Requete<GarantCaution> {
    @Override
    public String requete() {
        return "SELECT * FROM GARANT_CAUTION WHERE ID_CAUTION = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, GarantCaution data) throws SQLException {
        prSt.setString(1, data.getidCaution());
    }
}
