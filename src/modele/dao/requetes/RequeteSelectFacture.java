package modele.dao.requetes;

import modele.Facture;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectFacture extends Requete<Facture> {
    @Override
    public String requete() {
        return "SELECT * FROM Facture";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Facture donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
