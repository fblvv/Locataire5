package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;
import modele.Locataire;
import modele.dao.SousProgramme;

public class SousProgrammeInsertLocataire implements SousProgramme<Locataire> {

    @Override
    public String appelSousProgramme() {
        return "{call INS_LOCATAIRE(?,?, ?, ?, ?, ?, ?)}";
    }


    @Override
    public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
        // TODO Auto-generated method stub
    }

    @Override
    public void parametres(CallableStatement prSt, Locataire locataire) throws SQLException {
        // TODO Auto-generated method stub
    	prSt.setString(1, locataire.getId_Locataire());
        prSt.setString(2, locataire.getNom());
        prSt.setString(3, locataire.getPrenom());
        prSt.setString(4, locataire.getTelephone());
        prSt.setString(5, locataire.getMail());
        prSt.setString(6, locataire.getAdresse());
        prSt.setString(7, locataire.getCode_Postal());
    }
}
