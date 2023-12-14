package modele.dao.requetes;

import modele.Compteur;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectCompteurById extends Requete<Compteur> {
    @Override
    public String requete() {
        return "SELECT * FROM COMPTEUR WHERE ID_COMPTEUR = ? AND DATE_RELEVE = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setString(2, id[1]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Compteur data) throws SQLException {
        prSt.setString(1, data.getIdCompteur());
        prSt.setDate(2, java.sql.Date.valueOf(data.getDateReleve()));
    }
}
