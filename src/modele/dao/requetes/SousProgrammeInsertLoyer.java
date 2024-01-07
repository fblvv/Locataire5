package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;
import modele.Loyer;
import modele.dao.SousProgramme;


public class SousProgrammeInsertLoyer implements SousProgramme<Loyer> {

    @Override
    public String appelSousProgramme() {
        return "{call INS_LOYER(?, ?, ?, ?, ?, ?, ?, ?)}";
    }

    @Override
    public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
        // Gérer les paramètres si nécessaire
    }

    @Override
    public void parametres(CallableStatement prSt, Loyer loyer) throws SQLException {
        prSt.setString(1, loyer.getIdLoyer());
        prSt.setDouble(2, loyer.getLoyerCharges());
        prSt.setDouble(3, loyer.getCharges());
        prSt.setString(4,loyer.getDatePaiement()); // Convert LocalDate to SQL Date
        prSt.setDouble(5, loyer.getMontantPaiement());
        prSt.setString(6, loyer.getTypePaiement());
        prSt.setString(7, loyer.getIdLocataire());
        prSt.setString(8,loyer.getDateDebutContrat()); // Convert LocalDate to SQL Date
    }

}
