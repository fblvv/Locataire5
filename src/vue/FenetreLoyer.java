package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Collection;

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

import controle.GestionFenetreLoyer;
import modele.Locataire;
import modele.dao.DaoLocataire;
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
    private GestionFenetreLoyer gestionClic;
    private JComboBox<String> comboBoxLocataire; // Change to JComboBox<String>
    private JComboBox<String> comboBoxPaiement;
    private JButton btnAjouter;

    public FenetreLoyer() {
        this.gestionClic = new GestionFenetreLoyer(this);
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

        JLabel lblIdLocataire = new JLabel("ID Locataire:");
        panelLoyer.add(lblIdLocataire);

        initComboBox();
        panelLoyer.add(comboBoxLocataire);
        comboBoxLocataire.addActionListener(this.gestionClic);


        panelLoyer.add(new JLabel("Loyer Charges:"));
        textFieldLoyerCharges = new JTextField(10);
        panelLoyer.add(textFieldLoyerCharges);

        panelLoyer.add(new JLabel("Charges:"));
        textFieldCharges = new JTextField(10);
        panelLoyer.add(textFieldCharges);

        panelLoyer.add(new JLabel("Date Paiement:"));
        textFieldDatePaiement = new JTextField(20);
        panelLoyer.add(textFieldDatePaiement);

        panelLoyer.add(new JLabel("Montant Paiement:"));
        textFieldMontantPaiement = new JTextField(10);
        panelLoyer.add(textFieldMontantPaiement);

        panelLoyer.add(new JLabel("Type Paiement:"));
        
        comboBoxPaiement = new JComboBox<>();
        comboBoxPaiement.setModel(new DefaultComboBoxModel<>(new String[] {"CB", "Chèque", "Espèce"}));
        panelLoyer.add(comboBoxPaiement);

        panelLoyer.add(new JLabel("Date Début Contrat:"));
        textFieldDateDebutContrat = new JTextField(20);
        panelLoyer.add(textFieldDateDebutContrat);

        // Tableau des loyers avec JScrollPane
        tableLoyer = new JTable(new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "ID Loyer", "Loyer Charges", "Charges", "Date Paiement", "Montant Paiement",
                        "Type Paiement"
                }
        ));
        
        
        JScrollPane scrollPane = new JScrollPane(tableLoyer);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel Button en bas
        panelButton = new JPanel();
        panel.add(panelButton, BorderLayout.SOUTH);

        btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this.gestionClic);
        panelButton.add(btnAnnuler);

        // Bouton Valider en bas
        JButton btnValider = new JButton("Valider");
        btnValider.setHorizontalAlignment(SwingConstants.RIGHT);
        panelButton.add(btnValider);
        
        btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(this.gestionClic);
        panelButton.add(btnAjouter);
    }

    public JButton getBtnAnnuler() {
        return btnAnnuler;
    }
    
    
    public String getTextFieldIdLoyer() {
        return textFieldIdLoyer.getText();
    }

    public String getTextFieldLoyerCharges() {
        return textFieldLoyerCharges.getText();
    }

    public String getTextFieldCharges() {
        return textFieldCharges.getText();
    }

    public String getTextFieldDatePaiement() {
        return textFieldDatePaiement.getText();
    }

    public String getTextFieldMontantPaiement() {
        return textFieldMontantPaiement.getText();
    }

    public JTextField getTextFieldDateDebutContrat() {
        return textFieldDateDebutContrat;
    }
    
    public JButton getBtnAjouter() {
    	return btnAjouter;
    }

    public String getComboBoxLocataire() {
        return (String) comboBoxLocataire.getSelectedItem();
    }

    public String getComboBoxPaiement() {
        return (String) comboBoxPaiement.getSelectedItem();
    }
    
    public JTable getTableloyer() {
    	return tableLoyer;
    }

    public static void main(String[] args) {
        FenetreLoyer frame = new FenetreLoyer();
        frame.setVisible(true);
    }

    private void initComboBox() {
        DaoLocataire daoLocataire = new DaoLocataire();
        try {
            // Récupérer tous les locataires
            Collection<Locataire> locataires = daoLocataire.findAll();

            // Créer un tableau pour stocker les identifiants des locataires
            String[] locataireId = new String[locataires.size()];

            // Remplir le tableau avec les identifiants des locataires
            int i = 0;
            for (Locataire loca : locataires) {
                locataireId[i] = loca.getId_Locataire();
                i++;
            }

            // Créer une JComboBox avec les identifiants des locataires
            comboBoxLocataire = new JComboBox<>(locataireId);

        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception, par exemple, afficher un message d'erreur à l'utilisateur
        }
    }
}