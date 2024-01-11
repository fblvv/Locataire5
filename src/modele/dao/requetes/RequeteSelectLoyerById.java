package modele.dao.requetes;

import modele.Loyer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectLoyerById extends Requete<Loyer> {
    @Override
    public String requete() {
        return "SELECT * FROM Loyer WHERE Id_Locataire = ? order by Date_paiement desc";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Loyer data) throws SQLException {
        prSt.setString(1, data.getIdLocataire());
    }
}
