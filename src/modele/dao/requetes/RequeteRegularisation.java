package modele.dao.requetes;

import modele.BienImmobilier;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteRegularisation extends Requete<BienImmobilier> {
    @Override
    public String requete() {
        return "SELECT Regularisation_charges(?,?) as montant_regularisation from dual";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]);
        prSt.setDate(2,java.sql.Date.valueOf(id[1]));
    }

    
    public void parametres(PreparedStatement prSt, BienImmobilier data, String date) throws SQLException {
        prSt.setString(1, data.getId_Bien_Imm());
        prSt.setDate(2,java.sql.Date.valueOf(date));
    }
}
