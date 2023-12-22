package vue;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;



public class FenetreLoyer extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldIdLoyer;
    private JTextField textFieldLoyerCharges;
    private JTextField textFieldCharges;
    private JTextField textFieldDatePaiement;
    private JTextField textFieldMontantPaiement;
    private JTextField textFieldDateDebutContrat;

    private JTable tableLoyer;
    private JPanel panelButton;
    private JButton btnAnnuler;
    private JComboBox comboBox;
    private JComboBox comboBox_1;
 //   private GestionFenetreBien gestionClic;

    public FenetreLoyer() {
 //       this.gestionClic = new GestionFenetreBien(this);
        setTitle("Gestion des Loyers");
        setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        // Panel principal avec BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        getContentPane().add(panel);

        // Panel Loyer avec GridLayout
        JPanel panelLoyer = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(panelLoyer, BorderLayout.NORTH);

        panelLoyer.add(new JLabel("ID Loyer:"));
        textFieldIdLoyer = new JTextField(10);
        panelLoyer.add(textFieldIdLoyer);
        
                JLabel label = new JLabel("ID Locataire:");
                panelLoyer.add(label);
        
        comboBox_1 = new JComboBox();
        panelLoyer.add(comboBox_1);

        panelLoyer.add(new JLabel("Loyer Charges:"));
        textFieldLoyerCharges = new JTextField(10);
        panelLoyer.add(textFieldLoyerCharges);

        panelLoyer.add(new JLabel("Charges:"));
        textFieldCharges = new JTextField(10);
        panelLoyer.add(textFieldCharges);

        panelLoyer.add(new JLabel("Date Paiement:"));
        textFieldDatePaiement = new JTextField(10);
        panelLoyer.add(textFieldDatePaiement);

        panelLoyer.add(new JLabel("Montant Paiement:"));
        textFieldMontantPaiement = new JTextField(10);
        panelLoyer.add(textFieldMontantPaiement);

        panelLoyer.add(new JLabel("Type Paiement:"));
        
        comboBox = new JComboBox<String>();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"CB", "Espece", "CAF"}));
        panelLoyer.add(comboBox);

        panelLoyer.add(new JLabel("Date Début Contrat:"));
        textFieldDateDebutContrat = new JTextField(10);
        panelLoyer.add(textFieldDateDebutContrat);

        // Tableau des loyers avec JScrollPane
        tableLoyer = new JTable(new DefaultTableModel(
                new Object[][] {
                        {"1", "1000.00", "200.00", "2023-01-01", "1200.00", "Type1", "1", "2", "2023-01-01"},
                        {"2", "1200.00", "250.00", "2023-02-01", "1450.00", "Type2", "3", "4", "2023-02-01"}
                },
                new String[] {
                        "ID Loyer", "Loyer Charges", "Charges", "Date Paiement", "Montant Paiement",
                        "Type Paiement", "ID Locataire", "ID Locataire 1", "Date Début Contrat"
                }
        ));
        JScrollPane scrollPane = new JScrollPane(tableLoyer);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel Button en bas
        panelButton = new JPanel();
        panel.add(panelButton, BorderLayout.SOUTH);

        btnAnnuler = new JButton("Annuler");
 //       btnAnnuler.addActionListener(this.gestionClic);
        panelButton.add(btnAnnuler);

        // Bouton Valider en bas
        JButton btnValider = new JButton("Valider");
        btnValider.setHorizontalAlignment(SwingConstants.RIGHT);
        panelButton.add(btnValider);
    }
    
    public JButton getBtnAnnuler() {
        return btnAnnuler;
    }

    public static void main(String[] args) {
        FenetreLoyer frame = new FenetreLoyer();
        frame.setVisible(true);
    }
}
