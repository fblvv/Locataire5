package vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;

import controle.GestionEntreprise;

public class FenetreEntreprise extends JInternalFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestionEntreprise gestionClic;
    private JTable table;
    private JButton btnAjouter, btnSupprimer, btnCharger, btnFermer;

    public FenetreEntreprise() {
        this.gestionClic = new GestionEntreprise(this);
        setBounds(100, 100, 450, 300);
        JLabel lblHeader = new JLabel("Gestion des Entreprises");
        lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblHeader, BorderLayout.NORTH);

        // Tableau
        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        String[] columnNames = {"Siren", "Adresse", "Tel", "Nom Entreprise"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        scrollPane.setViewportView(table);

        // Panneau de boutons
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);

        btnCharger = new JButton("Charger");
        btnCharger.addActionListener(this.gestionClic);
        panel.add(btnCharger);

        btnFermer = new JButton("Fermer");
        panel.add(btnFermer);

            }

    // Getters pour les composants
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

    // Méthode principale pour tester la fenêtre
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
    public void actionPerformed(ActionEvent e) {
        gestionClic.actionPerformed(e);
    }
}