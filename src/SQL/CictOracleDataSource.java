package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource ;

public class CictOracleDataSource extends OracleDataSource {
     
    
    private static Connection connection;

    private CictOracleDataSource(String login, String mdp) throws SQLException {
        this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr" +
                ":1521:etupre");

        this.setUser(login);
        this.setPassword(mdp);
    }


    public static void creerAcces(String login, String mdp)throws SQLException {
        
            // Exemple de code pour la connexion (à adapter selon votre configuration):CictOracleDataSource db = new CictOracleDataSource(login, mdp);
    		CictOracleDataSource db = new CictOracleDataSource(login,mdp);
            CictOracleDataSource.connection = db.getConnection();

    }

    public static Connection getConnectionBD() {
        return connection;
    }

    public void deconnecter() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Gérer l'exception de manière appropriée dans une application réelle.
            } finally {
                connection = null;
            }
        }
    }
}
