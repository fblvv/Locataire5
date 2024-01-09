package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Facture;
import modele.dao.SousProgramme;

public class SousProgrammeInsertFacture implements SousProgramme<Facture>{


	@Override
	public String appelSousProgramme() {
		return "{call INS_FACTURE(?, ?, ?, ?, ?,?,?)}";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		 prSt.setString(1, parametres[0]); // Id_Compteur
	     prSt.setString(2, parametres[1]); // Type_Compteur
         prSt.setDouble(3, Double.parseDouble(parametres[2])); // Valeur
         prSt.setString(4, parametres[3]); // Id_Bien_Imm
         prSt.setDate(5,java.sql.Date.valueOf(parametres[4])); // Date_Releve
	     prSt.setString(2, parametres[5]); // Type_Compteur
	     prSt.setString(2, parametres[6]); // Type_Compteur
	}

	@Override
	public void parametres(CallableStatement prSt, Facture facture) throws SQLException {
		prSt.setString(1, facture.getSiren());
        prSt.setString(2, facture.getIdFacture());
        prSt.setDouble(3, facture.getPrix());
        prSt.setString(4, facture.getTypeEntretien());
        prSt.setDate(5, java.sql.Date.valueOf(facture.getDateFacture()));
        prSt.setString(6, facture.getIdBienImm());
        prSt.setString(7, facture.getIdBatiment());
	}

}
