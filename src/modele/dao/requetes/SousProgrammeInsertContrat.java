package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.ContratLocation;
import modele.Locataire;
import modele.dao.SousProgramme;

public class SousProgrammeInsertContrat implements SousProgramme<ContratLocation> {

	@Override
    public String appelSousProgramme() {
        return "{call INS_CONTRATLOCATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    }

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametres(CallableStatement prSt, ContratLocation contrat) throws SQLException {
		// TODO Auto-generated method stub
		prSt.setString(1, contrat.getIdLocataire());
		prSt.setString(2, contrat.getDateDebutContrat());
	    prSt.setDouble(3, contrat.getMontant());
	    prSt.setDouble(4, contrat.getMontantLoyer());
	    prSt.setString(5, contrat.getDateVersementLoyer());
	    prSt.setString(6, contrat.getDepotDeGarantie());
	    prSt.setString(7, contrat.getDateRevision());
	    prSt.setString(8, contrat.getPeriodicitePaiement());
	    prSt.setString(9, contrat.getDateFinContrat());
	    prSt.setDouble(10, contrat.getChargesProvisionnelles());
	    prSt.setString(11, contrat.getIdICC());
	    prSt.setDouble(12, contrat.getValeurIcc());
	    prSt.setString(13, contrat.getIdBienImm());
	}
}
