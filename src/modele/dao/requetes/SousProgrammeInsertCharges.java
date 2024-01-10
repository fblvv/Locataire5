package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;
import modele.Charges; // Assurez-vous d'importer la classe Charges correcte
import modele.dao.SousProgramme;

public class SousProgrammeInsertCharges implements SousProgramme<Charges> {

    @Override
    public String appelSousProgramme() {
        return "{call INS_CHARGE(?, ?, ?, ?, ?, ?)}";
    }

    @Override
    public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
        prSt.setString(1, parametres[0]); // ID_BIEN_IMM
        prSt.setString(2, parametres[1]); // ID_CHARGES
        prSt.setDouble(3, Double.parseDouble(parametres[2])); // MONTANT
        prSt.setDate(4, java.sql.Date.valueOf(parametres[3])); // DATE_CHARGE
        prSt.setString(5, parametres[4]); // TYPE_CHARGE
        prSt.setString(6, parametres[5]);
    }

    @Override
    public void parametres(CallableStatement prSt, Charges charges) throws SQLException {
        prSt.setString(1, charges.getIdBienImm());
        prSt.setString(2, charges.getIdCharges());
        prSt.setDouble(3, charges.getMontant());
        prSt.setDate(4, java.sql.Date.valueOf(charges.getDateCharge()));
        prSt.setString(5, charges.getTypeCharge());
        prSt.setString(6, charges.getPourcentagePartEntretien());
    }
}
