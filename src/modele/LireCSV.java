package modele;

import SQL.CictOracleDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class LireCSV {

    public void lireEtInsererCSV(String csvFilePath) {
        int batchSize = 20;
        Connection connection = null;
        PreparedStatement statement = null;
        BufferedReader lineReader = null;
        int count = 0;

        try {
            CictOracleDataSource.creerAcces("lrf4482a", "oracle");
            connection = CictOracleDataSource.getConnectionBD();
            connection.setAutoCommit(false);

            String sql = "INSERT INTO Loyer2 (IdLogement, IdLocataire, DateCol, Loyer,Provision) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            lineReader = new BufferedReader(new FileReader(csvFilePath));
            lineReader.readLine(); // Skip header line

            String lineText;
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                statement.setString(1, data[0]);
                statement.setString(2, data[1]);
                statement.setString(3, data[2]);
                statement.setString(4, data[3]);
                statement.setString(5, data[4]);

                statement.addBatch();
                if (++count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
            statement.executeBatch();
            connection.commit();
            System.out.println("Informations ajoutés");
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            System.out.println("Informations non ajoutés");
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                if (lineReader != null) lineReader.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close(); // Ferme la connexion ici
            } catch (SQLException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
