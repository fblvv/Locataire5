package modele.dao.requetes;


import modele.Locataire;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectLocataire extends Requete<Locataire> {
    @Override
    public String requete() {
        return "SELECT * FROM Locataire";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {}

	@Override
	public void parametres(PreparedStatement prSt, Locataire data) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
