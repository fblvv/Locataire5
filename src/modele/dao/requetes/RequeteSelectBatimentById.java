package modele.dao.requetes;

import modele.Batiment;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectBatimentById extends Requete<Batiment> {
    @Override
    public String requete() {
        return "SELECT * FROM BATIMENT WHERE ID_BATIMENT = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Batiment data) throws SQLException {
        prSt.setString(1, data.getId_Batiment());
    }
}
