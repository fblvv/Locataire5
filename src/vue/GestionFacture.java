package vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controle.GestionCompteur;
import modele.BienImmobilier;
import modele.Charges;
import modele.Compteur;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoCompteur;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GestionFacture extends JInternalFrame implements ActionListener { // Ajout de l'implémentation de ActionListener

    private JComboBox<String> typeCompteurComboBox;
    private JComboBox<String> idBienComboBox;
    private JTable compteurTable;
    private JButton ajouterButton;
    private JButton validerButton;
    private JButton annulerButton;
    private DaoCompteur daoCompteur;
    private List<Compteur> compteurs; // Utilisation d'une liste de Compteur plutôt que Charges
    private JPanel panelBoutons;

    public GestionFacture() {
        super("Fenetre Compteur", true, true, true, true);
        setSize(800, 600);

        this.daoCompteur = new DaoCompteur();
        this.compteurs = new ArrayList<>(); // Initialisation de la liste de compteurs

        JPanel panel = new JPanel(new FlowLayout());
        String[] typesCompteur = {"Tout Type", "Eau", "Électricité", "Gaz"};
        typeCompteurComboBox = new JComboBox<>(typesCompteur);
        panel.add(new JLabel("Type de Compteur: "));
        panel.add(typeCompteurComboBox);

        idBienComboBox = new JComboBox<>();
        panel.add(new JLabel("ID du Bien: "));
        panel.add(idBienComboBox);
        idBienComboBox.addItem("Tous");

        // Modification ici pour utiliser BorderLayout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);

        String[] columnNames = {"ID Compteur", "Date de Relevé", "Type", "Valeur", "ID Bien"};
        Object[][] data = new Object[compteurs.size()][5]; // Utilisation de la liste de compteurs
        compteurTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(compteurTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Initialisation et ajout de panelBoutons en bas
        panelBoutons = new JPanel(new FlowLayout());
        annulerButton = new JButton("Annuler");
        panelBoutons.add(annulerButton);
        ajouterButton = new JButton("Ajouter Relevé");
        panelBoutons.add(ajouterButton);
        validerButton = new JButton("Valider");
        panelBoutons.add(validerButton);
        getContentPane().add(panelBoutons, BorderLayout.SOUTH);

        validerButton.addActionListener(this);
        ajouterButton.addActionListener(this);
        annulerButton.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent e) { // Ajout de la méthode actionPerformed pour gérer les actions des boutons
        if (e.getSource() == ajouterButton) {
            // Code à exécuter lorsque le bouton "Ajouter Relevé" est cliqué
        } else if (e.getSource() == validerButton) {
            // Code à exécuter lorsque le bouton "Valider" est cliqué
        } else if (e.getSource() == annulerButton) {
            // Code à exécuter lorsque le bouton "Annuler" est cliqué
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionFacture().setVisible(true); // Assurez-vous que la fenêtre est visible
            }
        });
    }
}
