package modele.dao.requetes;

import modele.Entreprise;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectEntrepriseById extends Requete<Entreprise> {
    @Override
    public String requete() {
        return "SELECT * FROM ENTREPRISE WHERE SIREN = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, Entreprise data) throws SQLException {
        prSt.setString(1, data.getSiren());
    }
}
