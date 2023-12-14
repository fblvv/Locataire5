package modele.dao.requetes;

import modele.HistoriquePaiement;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectHistoriquePaiement extends Requete<HistoriquePaiement> {
    @Override
    public String requete() {
        return "SELECT * FROM Historique_Paiement";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, HistoriquePaiement donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
