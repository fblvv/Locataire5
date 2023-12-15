package modele.dao.requetes;

import modele.Associer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSelectAssocierById extends Requete<Associer> {
    @Override
    public String requete() {
        return "SELECT * FROM ASSOCIER WHERE DATE_DEBUT_CONTRAT = ? AND ID_LOCATAIRE = ? AND DATE_ENTREE = ?";
    }

    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setDate(1, java.sql.Date.valueOf(id[0]));  
        prSt.setInt(2, Integer.parseInt(id[1])); 
        prSt.setDate(3, java.sql.Date.valueOf(id[2]));  
    }

    @Override
    public void parametres(PreparedStatement prSt, Associer data) throws SQLException {
        prSt.setDate(1, java.sql.Date.valueOf(data.getDateDebutContrat()));
        prSt.setString(2, data.getIdLocataire());
        prSt.setDate(3, java.sql.Date.valueOf(data.getDateEntree()));
    }
}
