package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Batiment;
import modele.BienImmobilier;
import modele.dao.SousProgramme;

public class SousProgrammeInsertBienImmobilier implements SousProgramme<BienImmobilier>{

    public SousProgrammeInsertBienImmobilier() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String appelSousProgramme() {
        return "{call INS_BIENIMMOBILIER(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    }

    @Override
    public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
        prSt.setString(1, parametres[0]); // 
        prSt.setString(2, parametres[1]); // 
        prSt.setString(3, parametres[2]); // 
        prSt.setString(4, parametres[3]); // 
        prSt.setString(5, parametres[4]); // 
        prSt.setString(6, parametres[5]); // 
        prSt.setString(7, parametres[6]); // 
        prSt.setString(4, parametres[7]); // 
        prSt.setString(5, parametres[8]); // 
        prSt.setString(6, parametres[9]); // 
    }

    @Override
    public void parametres(CallableStatement prSt, BienImmobilier donnee) throws SQLException {
        prSt.setString(1, donnee.getId_Bien_Imm());
        prSt.setDouble(2, donnee.getSurface());
        prSt.setString(3, donnee.getMode_Chauffage());
        prSt.setString(4, donnee.getMode_Eau());
        prSt.setInt(5, donnee.getNb_Piece());
        prSt.setString(6, donnee.getType_Bien());
        prSt.setString(7, donnee.getNom_Proprio());        
        prSt.setString(8, donnee.getIdentifiant());        
        prSt.setString(9, donnee.getEtage());        
        prSt.setString(10, donnee.getId_Batiment());        

    }

}