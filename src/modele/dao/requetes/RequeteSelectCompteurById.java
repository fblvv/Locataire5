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
        prSt.setDate(2, java.sql.Date.valueOf(id[1]));
    }

    @Override
    public void parametres(PreparedStatement prSt, Compteur donnee) throws SQLException {
        prSt.setString(1, donnee.getIdCompteur());
        prSt.setDate(2, java.sql.Date.valueOf(donnee.getDateReleve()));
    }
}
