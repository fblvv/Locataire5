package modele.dao.requetes;

import modele.Echeance;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectEcheanceById extends Requete<Echeance> {
    @Override
    public String requete() {
        return "SELECT * FROM ECHEANCE WHERE NUM_POLICE = ? AND DATE_ECHEANCE = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setDate(2, java.sql.Date.valueOf(id[1]));  // Assurez-vous que id[1] est une chaîne représentant une date valide
    }

    @Override
    public void parametres(PreparedStatement prSt, Echeance data) throws SQLException {
        prSt.setString(1, data.getNumPolice());
        prSt.setDate(2, java.sql.Date.valueOf(data.getDateEcheance()));
    }
}

