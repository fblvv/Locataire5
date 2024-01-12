package vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controle.GestionCompteur;
import modele.BienImmobilier;
import modele.Compteur;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoCompteur;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FenetreCompteur extends JInternalFrame {

    private static final long serialVersionUID = -1022228749473052973L;
	private JComboBox<String> typeCompteurComboBox;
    private JComboBox<String> idBienComboBox;
    private JTable compteurTable;
    private GestionCompteur gestionClic;
    private JButton ajouterButton;
    private JButton validerButton;
    private JButton annulerButton;
    private DaoCompteur daoCompteur;
    private List<Compteur> compteurs;
    private JPanel panelBoutons;

    public FenetreCompteur() {
        super("Fenetre Compteur", true, true, true, true);
        setSize(800, 600);

        this.gestionClic = new GestionCompteur(this);
        this.daoCompteur = new DaoCompteur();
        this.compteurs = new ArrayList<>();

        JPanel panel = new JPanel(new FlowLayout());
        String[] typesCompteur = {"Tout Type", "Eau", "Electricite", "Gaz"};
        typeCompteurComboBox = new JComboBox<>(new DefaultComboBoxModel<>(typesCompteur));
        panel.add(new JLabel("Type de Compteur: "));
        panel.add(typeCompteurComboBox);

        idBienComboBox = new JComboBox<>();
        panel.add(new JLabel("ID du Bien: "));
        panel.add(idBienComboBox);
        idBienComboBox.addItem("Tous");
        
        typeCompteurComboBox.addItemListener(this.gestionClic);
        idBienComboBox.addItemListener(this.gestionClic);

        // Modification ici pour utiliser BorderLayout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);

        String[] columnNames = {"ID Compteur", "Date de Releve", "Type", "Valeur", "ID Bien"};
        Object[][] data = new Object[compteurs.size()][5];
        compteurTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(compteurTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Initialisation et ajout de panelBoutons en bas
        panelBoutons = new JPanel(new FlowLayout());
        annulerButton= new JButton("Annuler");
        panelBoutons.add(annulerButton);
        ajouterButton = new JButton("Ajouter Relevé");
        ajouterButton.setEnabled(false);
        panelBoutons.add(ajouterButton);
        
        validerButton = new JButton("Valider");
        panelBoutons.add(validerButton);
        getContentPane().add(panelBoutons, BorderLayout.SOUTH);

        validerButton.addActionListener(this.gestionClic);
        ajouterButton.addActionListener(this.gestionClic);
        annulerButton.addActionListener(this.gestionClic);

        initComboBoxIdBien();

        try {
            afficherCompteurs();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initComboBoxIdBien() {
        DaoBienImmobilier daoBienImmobilier = new DaoBienImmobilier();
        try {
            Collection<BienImmobilier> biens = daoBienImmobilier.findAll();
            for (BienImmobilier bien : biens) {
                idBienComboBox.addItem(bien.getId_Bien_Imm());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afficherCompteurs() throws SQLException {
        Collection<Compteur> compteurs = daoCompteur.findAll();
        DefaultTableModel tableModel = (DefaultTableModel) compteurTable.getModel();
        tableModel.setRowCount(0);
        for (Compteur compteur : compteurs) {
            tableModel.addRow(new Object[]{compteur.getIdCompteur(), compteur.getDateReleve(),
                    compteur.getTypeCompteur(), compteur.getValeur(), compteur.getIdBienImm()});
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
    
    public JButton getAjouterButton() {
    	return ajouterButton;
    }
}