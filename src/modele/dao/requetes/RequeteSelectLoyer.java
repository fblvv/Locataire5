package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Associer;
import modele.Assurance;
import modele.Loyer;

public class RequeteSelectLoyer extends Requete<Loyer> {

	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return "SELECT * from Loyer";
	}
	
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

    @Override
    public void parametres(PreparedStatement prSt, Loyer donnee) throws SQLException {
        // Empty body, as there are no parameters for this query
    }

}
