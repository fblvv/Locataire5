package modele.dao.requetes;

import modele.Facture;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectFactureById extends Requete<Facture> {
    @Override
    public String requete() {
        return "SELECT * FROM FACTURE WHERE SIREN = ? AND ID_FACTURE = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Facture data) throws SQLException {
        prSt.setString(1, data.getSiren());
        prSt.setString(2, data.getIdFacture());
    }
}
