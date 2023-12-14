package modele.dao.requetes;

import modele.ContratLocation;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectContratLocation extends Requete<ContratLocation> {
    @Override
    public String requete() {
        return "SELECT * FROM Contrat_Location";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, ContratLocation donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }
}
