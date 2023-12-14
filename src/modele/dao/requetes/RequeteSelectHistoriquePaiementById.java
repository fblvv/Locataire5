package modele.dao.requetes;

import modele.HistoriquePaiement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectHistoriquePaiementById extends Requete<HistoriquePaiement> {
    @Override
    public String requete() {
        return "SELECT * FROM HISTORIQUE_PAIEMENT WHERE ID_HIST_PAIEMENT = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, HistoriquePaiement data) throws SQLException {
        prSt.setString(1, data.getIdHistPaiement());
    }
}
