package modele.dao;
import java.sql.CallableStatement;
import java.sql.SQLException;

public interface SousProgramme<T> {
    String appelSousProgramme(); // Méthode pour retourner l'ordre PL/SQL d'exécution

    public void parametres(CallableStatement prSt, String... parametres) throws SQLException;
    // Méthode pour affecter les paramètres au CallableStatement
    
    public void parametres(CallableStatement prSt, T donnee) throws SQLException;
}
