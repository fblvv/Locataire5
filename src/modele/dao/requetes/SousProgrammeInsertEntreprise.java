package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;
import modele.Entreprise;
import modele.dao.SousProgramme;

public class SousProgrammeInsertEntreprise implements SousProgramme<Entreprise> {

    @Override
    public String appelSousProgramme() {
        return "{call INS_ENTREPRISE(?, ?, ?,?)}";
    }

    @Override
    public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
        prSt.setString(1, parametres[0]); // SIREN
        prSt.setString(2, parametres[1]); // ADRESSE_ENTREPRISE
        prSt.setString(3, parametres[2]); // TEL_ENTREPRISE
        prSt.setString(4, parametres[3]); // MAIL_ENTREPRISE
    }

    @Override
    public void parametres(CallableStatement prSt, Entreprise entreprise) throws SQLException {
        prSt.setString(1, entreprise.getSiren());
        prSt.setString(2, entreprise.getAdresse());
        prSt.setString(3, entreprise.getTel());
        prSt.setString(4,entreprise.getNom());

    }
}
