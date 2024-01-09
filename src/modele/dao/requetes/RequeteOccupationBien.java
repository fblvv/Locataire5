package modele.dao.requetes;

import modele.BienImmobilier;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteOccupationBien extends Requete<BienImmobilier> {
    @Override
    public String requete() {
        return "SELECT isBienOccupe(?) as Statut_Du_Bien from dual";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
    }

    @Override
    public void parametres(PreparedStatement prSt, BienImmobilier data) throws SQLException {
        prSt.setString(1, data.getId_Bien_Imm());
    }
}
