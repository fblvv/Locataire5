package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import modele.Batiment;
import modele.dao.DaoBatiment;
import vue.FenetreAjoutBatiment;
import vue.FenetreDetailsPropriete2;

public class GestionAjoutBatiment implements ActionListener {

    private FenetreAjoutBatiment ajoutBatiment;

    public GestionAjoutBatiment(FenetreAjoutBatiment ajoutBatiment) {
        this.ajoutBatiment = ajoutBatiment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            switch (button.getText()) {
                case "Valider":
                    // Code à exécuter pour le bouton "Autre Section"
                	ajouterBatiment();
                	ajoutBatiment.dispose();
                    break;
                    
                case "Annuler":
                    ajoutBatiment.dispose();
                    break;
            }
        }
    }
    
    
    public void ajouterBatiment() {
    	
    try {
        // 1. Récupérer les valeurs des champs depuis la fenêtre
        String nomBatiment = ajoutBatiment.getIdBatiment();
        String regimeJuridique = ajoutBatiment.getRegimeJuridique();
        String adresse = ajoutBatiment.getAdresse();
        String codePostal = ajoutBatiment.getCodePostal();
        String dateConstruction = ajoutBatiment.getDateConstruction();
        String equipAccesTech = ajoutBatiment.getEquipAccesTech();
        String enumPartiesCommunes = ajoutBatiment.getEnumPartiesCommunes();

        // 2. Créer une instance de la classe Batiment avec les valeurs récupérées
        Batiment batiment = new Batiment(nomBatiment, regimeJuridique, adresse,
                dateConstruction, equipAccesTech, enumPartiesCommunes,codePostal);

        // 3. Appeler la méthode de DAO pour insérer le bâtiment dans la base de données
        DaoBatiment daoBatiment = new DaoBatiment();
        daoBatiment.create(batiment);

        // 4. Afficher un message de succès ou gérer les erreurs si nécessaire
        System.out.println("Bâtiment ajouté avec succès !");
    } catch (SQLException ex) {
        // Gérer les erreurs liées à l'ajout du bâtiment
        ex.printStackTrace();
    }
    }
    
    
    
}
