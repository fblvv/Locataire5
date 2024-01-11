package modele.dao.requetes;

import modele.ContratLocation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectContratLocationById extends Requete<ContratLocation> {
    @Override
    public String requete() {
        return "SELECT * FROM CONTRAT_LOCATION WHERE ID_Locataire = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, ContratLocation data) throws SQLException {
        prSt.setString(1,data.getIdLocataire());
    }
}
