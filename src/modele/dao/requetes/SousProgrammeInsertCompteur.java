package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;
import modele.Compteur; // Assurez-vous d'importer la classe Compteur correcte
import modele.dao.SousProgramme;

public class SousProgrammeInsertCompteur implements SousProgramme<Compteur> {

    @Override
    public String appelSousProgramme() {
        return "{call INS_COMPTEUR(?, ?, ?, ?, ?)}";
    }

    @Override
    public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
        prSt.setString(1, parametres[0]); // Id_Compteur
        prSt.setDate(2,java.sql.Date.valueOf(parametres[1])); // Date_Releve
        prSt.setString(3, parametres[2]); // Type_Compteur
        prSt.setDouble(4, Double.parseDouble(parametres[3])); // Valeur
        prSt.setString(5, parametres[4]); // Id_Bien_Imm
    }

    @Override
    public void parametres(CallableStatement prSt, Compteur compteur) throws SQLException {
        prSt.setString(1, compteur.getIdCompteur());
        prSt.setDate(2, java.sql.Date.valueOf(compteur.getDateReleve()));
        //prSt.setString(2, compteur.getDateReleve());
        prSt.setString(3, compteur.getTypeCompteur());
        prSt.setDouble(4, compteur.getValeur());
        prSt.setString(5, compteur.getIdBienImm());
    }
}
