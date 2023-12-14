package modele.dao.requetes;

import modele.Compteur;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectCompteur extends Requete<Compteur> {
    @Override
    public String requete() {
        return "SELECT * FROM Compteur";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Compteur donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
