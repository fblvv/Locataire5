package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Requete<T> {

    // Méthode abstraite pour obtenir la requête SQL correspondant à l'action
    public abstract String requete();

    // Méthode pour affecter les paramètres de la requête avec un tableau d'identifiants
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        // Par défaut, cette méthode n'implémente rien. Les classes dérivées peuvent la remplacer.
    }

    // Méthode pour affecter les paramètres de la requête avec les attributs de l'objet de type T
    public void parametres(PreparedStatement prSt, T donnee) throws SQLException {
        // Par défaut, cette méthode n'implémente rien. Les classes dérivées peuvent la remplacer.
    }
}