package modele;

import SQL.CictOracleDataSource;
import modele.dao.DaoContratLocation;

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

            String sql = "INSERT INTO LOYER (ID_LOYER, LOYER_CHARGES, CHARGES, DATE_PAIEMENT, MONTANT_PAIEMENT, TYPE_PAIEMENT, ID_LOCATAIRE, DATE_DEBUT_CONTRAT) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            lineReader = new BufferedReader(new FileReader(csvFilePath));
            lineReader.readLine(); // Skip header line

            String lineText;
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                
                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].replace("\"", ""); // Supprimer les guillemets doubles
                }
                
                String stt ="Loyer"+ data[0]+data[2];
                System.out.println(stt);
                statement.setString(1,"Loyer"+ data[0]+data[2]);
                statement.setDouble(2, Double.parseDouble(data[3]));
                statement.setDouble(3, Double.parseDouble(data[4]));
                statement.setDate(4, java.sql.Date.valueOf(data[2]));
                System.out.println(data[2]);
                statement.setDouble(5, Double.parseDouble(data[3])+Double.parseDouble(data[4]));
                statement.setString(6, "CB");
                statement.setString(7, data[1]);
                String idLoc = data[1]; // Assigner la valeur de data[1] à la variable idLoc
                System.out.println(idLoc);
                DaoContratLocation contrat = new DaoContratLocation();
                ContratLocation contratLoc = contrat.findById(idLoc);
                String str = contratLoc.getDateDebutContrat();
                String sousChaine;
                sousChaine = str.substring(0, 10);
                statement.setDate(8,java.sql.Date.valueOf(sousChaine));
                System.out.println(sousChaine);
                

                statement.addBatch();
                if (++count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
            
          
            
            statement.executeBatch();
            connection.commit();
            System.out.println("Informations ajoutés");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("Informations non ajoutés");
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException en) {
                    en.printStackTrace();
                
       
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
    }
}
