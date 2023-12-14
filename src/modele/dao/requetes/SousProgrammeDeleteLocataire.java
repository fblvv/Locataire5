package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Locataire;
import modele.dao.SousProgramme;

public class SousProgrammeDeleteLocataire implements SousProgramme<Locataire> {

    // ... autres méthodes existantes ...

	@Override
	public String appelSousProgramme() {
		return "{call DEL_LOCATAIRE(?)}";
	}


	@Override
	public void parametres(CallableStatement prSt, Locataire locataire) throws SQLException {
		prSt.setString(1, locataire.getId_Locataire());
		
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}

