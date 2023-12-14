package modele.dao.requetes;

import modele.Locataire;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectLocataireById extends Requete<Locataire> {
    @Override
    public String requete() {
        return "SELECT * FROM LOCATAIRE WHERE ID_LOCATAIRE = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
        prSt.setString(1, data.getId_Locataire());
    }
}
