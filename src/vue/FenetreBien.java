package vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.GestionFenetreBien;

public class FenetreBien extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldAdresse;
    private JTextField textFieldCodePostal;
    private JTextField textFieldEtage;
    private JTextField textFieldDescription;

    private JTextField textFieldNumeroPoliceObl;
    private JTextField textFieldTarifInitialObl;
    private JTextField textFieldTypeAssuranceObl;
    private JTextField textFieldDateDebutObl;

    private JTextField textFieldNumeroPoliceOpt;
    private JTextField textFieldTarifInitialOpt;
    private JTextField textFieldTypeAssuranceOpt;
    private JTextField textFieldDateDebutOpt;

    private JPanel panelButton;
    private JButton btnAnnuler;
    private GestionFenetreBien gestionClic;

    private JComboBox<String> comboBoxBatiment;

    public FenetreBien() {
        this.gestionClic = new GestionFenetreBien(this);
        setTitle("Gestion de Logement");
        setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(mainPanel);

        // Panel Assurance à gauche
        JPanel panelAssurance = new JPanel(new GridLayout(0, 1, 10, 10));
        mainPanel.add(panelAssurance, BorderLayout.WEST);

        // Assurance obligatoire
        panelAssurance.add(new JLabel("Assurance Obligatoire", SwingConstants.CENTER));

        panelAssurance.add(new JLabel("Numéro de Police", SwingConstants.RIGHT));
        panelAssurance.add(textFieldNumeroPoliceObl = new JTextField(10));

        panelAssurance.add(new JLabel("Tarif Initial", SwingConstants.RIGHT));
        panelAssurance.add(textFieldTarifInitialObl = new JTextField(5));

        panelAssurance.add(new JLabel("Type d'Assurance", SwingConstants.RIGHT));
        panelAssurance.add(textFieldTypeAssuranceObl = new JTextField(10));

        panelAssurance.add(new JLabel("Date d'Effet (Début)", SwingConstants.RIGHT));
        panelAssurance.add(textFieldDateDebutObl = new JTextField(10));

        // Assurance optionnelle
        panelAssurance.add(new JLabel("Assurance Optionnelle", SwingConstants.CENTER));

        panelAssurance.add(new JLabel("Numéro de Police", SwingConstants.RIGHT));
        panelAssurance.add(textFieldNumeroPoliceOpt = new JTextField(10));

        panelAssurance.add(new JLabel("Tarif Initial", SwingConstants.RIGHT));
        panelAssurance.add(textFieldTarifInitialOpt = new JTextField(5));

        panelAssurance.add(new JLabel("Type d'Assurance", SwingConstants.RIGHT));
        panelAssurance.add(textFieldTypeAssuranceOpt = new JTextField(10));

        panelAssurance.add(new JLabel("Date d'Effet (Début)", SwingConstants.RIGHT));
        panelAssurance.add(textFieldDateDebutOpt = new JTextField(10));

     // Panel Autres informations à droite
        JPanel panelAutres = new JPanel(new GridLayout(0, 2, 10, 10));
        mainPanel.add(panelAutres, BorderLayout.EAST);

        // Combobox pour les bâtiments
        panelAutres.add(new JLabel("Bâtiment:", SwingConstants.RIGHT));
        comboBoxBatiment = new JComboBox<>();
        comboBoxBatiment.addItem("Bâtiment 1");
        comboBoxBatiment.addItem("Bâtiment 2");
        comboBoxBatiment.addItem("Bâtiment 3");
        panelAutres.add(comboBoxBatiment);

        // Ajout des autres champs SQL
        panelAutres.add(new JLabel("Id Bien Immobilier:", SwingConstants.RIGHT));
        panelAutres.add(new JTextField(10));

        panelAutres.add(new JLabel("Surface:", SwingConstants.RIGHT));
        panelAutres.add(new JTextField(10));

        panelAutres.add(new JLabel("Mode Chauffage:", SwingConstants.RIGHT));
        panelAutres.add(new JTextField(10));

        panelAutres.add(new JLabel("Mode Eau:", SwingConstants.RIGHT));
        panelAutres.add(new JTextField(10));

        panelAutres.add(new JLabel("Nb Piece:", SwingConstants.RIGHT));
        panelAutres.add(new JTextField(10));

        panelAutres.add(new JLabel("Type Bien:", SwingConstants.RIGHT));
        panelAutres.add(new JTextField(10));

        panelAutres.add(new JLabel("Nom Proprio:", SwingConstants.RIGHT));
        panelAutres.add(new JTextField(10));

        panelAutres.add(new JLabel("Identifiant:", SwingConstants.RIGHT));
        panelAutres.add(new JTextField(10));

        panelAutres.add(new JLabel("Etage:", SwingConstants.RIGHT));
        panelAutres.add(new JTextField(10));


        // Panel de boutons en bas
        panelButton = new JPanel();
        mainPanel.add(panelButton, BorderLayout.SOUTH);

        btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this.gestionClic);
        panelButton.add(btnAnnuler);

        JButton btnValider = new JButton("Valider");
        panelButton.add(btnValider);
    }

    public static void main(String[] args) {
        FenetreBien frame = new FenetreBien();
        frame.setVisible(true);
    }
}
