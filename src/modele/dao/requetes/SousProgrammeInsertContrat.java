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
		prSt.setString(1, contrat.getDateDebutContrat());
	    prSt.setDouble(2, contrat.getMontant());
	    prSt.setDouble(3, contrat.getMontantDernierLoyer());
	    prSt.setString(4, contrat.getDateVersementLoyer());
	    prSt.setString(5, contrat.getDepotGarantie());
	    prSt.setString(6, contrat.getDateRevision());
	    prSt.setString(7, contrat.getPeriodicitePaiement());
	    prSt.setString(8, contrat.getDateFinContrat());
	    prSt.setDouble(9, contrat.getChargesProvisionnelles());
	    prSt.setString(10, contrat.getIdICC());
	    prSt.setString(11, contrat.getValeurICC());
	    prSt.setString(12, contrat.getIdBienImm());
	}
}
