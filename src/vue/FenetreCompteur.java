package vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controle.GestionCompteur;
import modele.BienImmobilier;
import modele.Compteur;
import modele.Locataire;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoCompteur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FenetreCompteur extends JInternalFrame {

    private JComboBox<String> typeCompteurComboBox;
    private JComboBox<String> idBienComboBox;
    private JTable compteurTable;
    private GestionCompteur gestionClic;
    private JButton ajouterButton;
    private JButton validerButton;
    private DaoCompteur daoCompteur;
    private List<Compteur> compteurs;

    public FenetreCompteur() {
        super("Fenetre Compteur", true, true, true, true);
        setSize(600, 400);

        // Initialisation du gestionnaire d'événements
        this.gestionClic = new GestionCompteur(this);
        this.daoCompteur = new DaoCompteur(); // Ajout de l'initialisation de daoCompteur
        this.compteurs=new ArrayList<>();

        // Panel pour les composants
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // JComboBox pour le type de compteur
        String[] typesCompteur = {"Tout Type","Eau", "Électricité", "Gaz"};
        typeCompteurComboBox = new JComboBox<>(new DefaultComboBoxModel<>(typesCompteur));
        panel.add(new JLabel("Type de Compteur: "));
        panel.add(typeCompteurComboBox);

        // JComboBox pour les ID des biens
        idBienComboBox = new JComboBox<>(); // On crée une JComboBox vide
        panel.add(new JLabel("ID du Bien: "));
        panel.add(idBienComboBox);
        idBienComboBox.addItem("Tous");

        // Bouton pour ajouter un relevé de compteur (vous pouvez ajouter d'autres fonctionnalités)
        ajouterButton = new JButton("Ajouter Relevé");
        ajouterButton.addActionListener(this.gestionClic);
        panel.add(ajouterButton);

        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        getContentPane().add(panel);

        validerButton = new JButton("Valider");
        validerButton.addActionListener(this.gestionClic);
        panel.add(validerButton);

        // Table pour afficher les relevés de compteur
        String[] columnNames = {"ID Compteur", "Date de Relevé","Type","Valeur", "ID Bien"};
        Object[][] data = new Object[compteurs.size()][5];
        for (int i = 0; i < compteurs.size(); i++) {
            Compteur compteur = compteurs.get(i);
            data[i] = new Object[]{compteur.getIdCompteur(), compteur.getDateReleve(), compteur.getTypeCompteur(),
                    compteur.getValeur(), compteur.getIdBienImm()};
        }
        compteurTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(compteurTable);
        getContentPane().add(scrollPane);

        // Initialiser la JComboBox des ID des biens
        initComboBoxIdBien();
        

        
        //remplir le tableau
        try {
			afficherCompteurs();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
    }
    


    private void initComboBoxIdBien() {
        DaoBienImmobilier daoBienImmobilier = new DaoBienImmobilier();
        try {
            // Fetch all biens
            Collection<BienImmobilier> biens = daoBienImmobilier.findAll();

            // Populate the JComboBox with bien IDs
            for (BienImmobilier bien : biens) {
                idBienComboBox.addItem(bien.getId_Bien_Imm());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, e.g., show an error message to the user
        }
    }
    
    
    
    public void afficherCompteurs() throws SQLException {
        Collection<Compteur> compteurs = daoCompteur.findAll();
        DefaultTableModel tableModel = (DefaultTableModel) compteurTable.getModel();

        // Clear existing data from the table model
        tableModel.setRowCount(0);

        // Populate the table model with data
        int ligne = 0;
        for (Compteur compteur : compteurs) {
            if (tableModel.getRowCount() <= ligne) {
                // Add a new row if needed
                tableModel.addRow(new Object[0]);
            }

            tableModel.setValueAt(compteur.getIdCompteur(), ligne, 0);
            tableModel.setValueAt(compteur.getDateReleve(), ligne, 1);
            tableModel.setValueAt(compteur.getTypeCompteur(), ligne, 2);
            tableModel.setValueAt(compteur.getValeur(), ligne, 3);
            tableModel.setValueAt(compteur.getIdBienImm(), ligne, 4);

            ligne++;
        }
    }
    
    
    
    public JComboBox<String> getTypeCompteurComboBox() {
        return typeCompteurComboBox;
    }

    public JComboBox<String> getIdBienComboBox() {
        return idBienComboBox;
    }


   
    
    public JTable getTable() {
		return compteurTable;
	}




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FenetreCompteur();
            }
        });
    }
}
