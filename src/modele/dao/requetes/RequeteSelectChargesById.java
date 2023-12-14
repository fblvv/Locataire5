package modele.dao.requetes;

import modele.Charges;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectChargesById extends Requete<Charges> {
    @Override
    public String requete() {
        return "SELECT * FROM CHARGES WHERE ID_BIEN_IMM = ? AND ID_CHARGES = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Charges data) throws SQLException {
        prSt.setString(1, data.getIdBienImm());
        prSt.setString(2, data.getIdCharges());
    }
}
