package modele.dao.requetes;

import modele.Entreprise;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectEntreprise extends Requete<Entreprise> {
    @Override
    public String requete() {
        return "SELECT * FROM Entreprise";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Entreprise donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
