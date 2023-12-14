package modele.dao.requetes;

import modele.Contenir;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectContenirById extends Requete<Contenir> {
    @Override
    public String requete() {
        return "SELECT * FROM CONTENIR WHERE ID_CAUTION = ? AND DATE_DEBUT_CONTRAT = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Contenir data) throws SQLException {
        prSt.setString(1, data.getIdCaution());
        prSt.setDate(2, java.sql.Date.valueOf(data.getDateDebutContrat()));
    }
}
