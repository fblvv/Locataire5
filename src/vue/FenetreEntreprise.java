package vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import controle.GestionEntreprise;

public class FenetreEntreprise extends JInternalFrame {
    private JTable table;
    private JButton btnAjouter, btnSupprimer, btnCharger, btnFermer;

    public FenetreEntreprise() {
        // Configuration initiale de la fenêtre...
        setBounds(100, 100, 450, 300);
        JLabel lblHeader = new JLabel("Gestion des Entreprises");
        lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblHeader, BorderLayout.NORTH);

        // Tableau...
        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        String[] columnNames = {"Siren", "Adresse", "Tel", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        scrollPane.setViewportView(table);

        // Panneau de boutons...
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);

        // Boutons...
        btnAjouter = new JButton("Ajouter");
        panel.add(btnAjouter);

        btnSupprimer = new JButton("Supprimer");
        panel.add(btnSupprimer);

        btnCharger = new JButton("Charger");
        panel.add(btnCharger);

        btnFermer = new JButton("Fermer");
        panel.add(btnFermer);

        // Associer le gestionnaire d'événements
        GestionEntreprise gestionnaire = new GestionEntreprise(this);
    }

    // Getters pour les composants...
    public JTable getTable() {
        return table;
    }

    public JButton getBtnAjouter() {
        return btnAjouter;
    }

    public JButton getBtnSupprimer() {
        return btnSupprimer;
    }

    public JButton getBtnCharger() {
        return btnCharger;
    }

    public JButton getBtnFermer() {
        return btnFermer;
    }

    // Méthode principale pour tester la fenêtre...
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FenetreEntreprise frame = new FenetreEntreprise();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
