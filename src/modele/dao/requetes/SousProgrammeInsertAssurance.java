package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Assurance;
import modele.dao.SousProgramme;

public class SousProgrammeInsertAssurance implements SousProgramme<Assurance>{

    public SousProgrammeInsertAssurance() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public String appelSousProgramme() {
        return "{call INS_ASSURANCE(?, ?, ?, ?, ?, ?)}";
    }

    @Override
    public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
        prSt.setString(1, parametres[0]); // 
        prSt.setString(2, parametres[1]); // 
        prSt.setString(3, parametres[2]); // 
        prSt.setString(4, parametres[3]); // 
        prSt.setString(5, parametres[4]); // 
        prSt.setString(6, parametres[5]); // 

    }

    @Override
    public void parametres(CallableStatement prSt, Assurance donnee) throws SQLException {
        prSt.setString(1, donnee.getNumPolice());
        prSt.setString(2, donnee.getTarifInitial());
        prSt.setString(3, donnee.getTypeAssurance());
        prSt.setString(4,donnee.getDateEffetDebut());
        prSt.setString(5, donnee.getIdBienImm());
        prSt.setString(6, donnee.getIdBatiment());


    }

}