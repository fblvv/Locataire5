package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FenetreCompteur extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboBoxTypeCompteur;
    private JTable tableCompteur;

    public FenetreCompteur() {
        setTitle("Gestion des Compteurs");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE); // Correction ici
        setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(mainPanel);

        // Panel pour la JComboBox
        JPanel panelComboBox = new JPanel();
        mainPanel.add(panelComboBox, BorderLayout.NORTH);

        panelComboBox.add(new JLabel("Type de Compteur:", SwingConstants.RIGHT));
        comboBoxTypeCompteur = new JComboBox<>(new String[]{"Eau", "Gaz", "Electricite"});
        panelComboBox.add(comboBoxTypeCompteur);

        // Tableau pour les compteurs
        String[] columnNames = {"idCompteur", "Date de relevé", "Valeur", "id Bien"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        tableCompteur = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableCompteur);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Remplissage de la table (exemple de données)
        tableModel.addRow(new Object[]{"1", "01/01/2021", "100", "B1"});
        tableModel.addRow(new Object[]{"2", "01/02/2021", "150", "B2"});
        // Ajoutez plus de lignes selon vos données
    }

    public static void main(String[] args) {
        FenetreCompteur frame = new FenetreCompteur();
        frame.setVisible(true);
    }
}
