package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;
import modele.Batiment;
import modele.dao.SousProgramme;

public class SousProgrammeInsertBatiment implements SousProgramme<Batiment> {

    @Override
    public String appelSousProgramme() {
        return "{call INS_BATIMENT(?, ?, ?, ?, ?, ?, ?)}";
    }

    @Override
    public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
        prSt.setString(1, parametres[0]); // ID_BATIMENT
        prSt.setString(2, parametres[1]); // REGIME_JURIDIQUE
        prSt.setString(3, parametres[2]); // ADRESSE
        prSt.setString(4, parametres[3]); // DATE_CONSTRUCTION
        prSt.setString(5, parametres[4]); // EQUIP_ACCES_TECH
        prSt.setString(6, parametres[5]); // ENUM_PARTIES_COMMUNES
        prSt.setString(7, parametres[6]); // CODE_POSTAL
    }

    @Override
    public void parametres(CallableStatement prSt, Batiment batiment) throws SQLException {
        prSt.setString(1, batiment.getId_Batiment());
        prSt.setString(2, batiment.getRegime_Juridique());
        prSt.setString(3, batiment.getAdresse());
        prSt.setString(4,batiment.getDate_Construction());
        prSt.setString(5, batiment.getEquip_Acces_Tech());
        prSt.setString(6, batiment.getEnum_Parties_Communes());
        prSt.setString(7, batiment.getCodePostal());
    }
}
