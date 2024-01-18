package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controle.GestionAjoutEntreprise;
import modele.Entreprise;

public class FenetreAjoutEntreprise extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField champSiren;
    private JTextField champAdresse;
    private JTextField champTel;
    private JTextField champNom;
    private GestionAjoutEntreprise gestionClic;
    private static final String POLICE = "Tahoma";

    public FenetreAjoutEntreprise() {
        gestionClic = new GestionAjoutEntreprise(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel libAjouterBatiment = new JLabel("Ajouter une entreprise");
        libAjouterBatiment.setFont(new Font(POLICE, Font.BOLD, 18));
        libAjouterBatiment.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(libAjouterBatiment, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBackground(new Color(238, 237, 238));
        contentPane.add(panel, BorderLayout.CENTER);

        // Champ pour le Siren de l'entreprise
        JLabel lblSiren = new JLabel("Siren Entreprise");
        lblSiren.setFont(new Font(POLICE, Font.PLAIN, 14));
        champSiren = new JTextField();
        panel.add(lblSiren);
        panel.add(champSiren);

        // Champ pour l'adresse de l'entreprise
        JLabel libAdresse = new JLabel("Adresse Entreprise");
        libAdresse.setFont(new Font(POLICE, Font.PLAIN, 14));
        champAdresse = new JTextField();
        panel.add(libAdresse);
        panel.add(champAdresse);

        // Champ pour le numéro de téléphone de l'entreprise
        JLabel libTel = new JLabel("Tel Entreprise");
        libTel.setFont(new Font(POLICE, Font.PLAIN, 14));
        champTel = new JTextField();
        panel.add(libTel);
        panel.add(champTel);

        // Champ pour le nom de l'entreprise
        JLabel libEntreprise = new JLabel("Nom Entreprise");
        libEntreprise.setFont(new Font(POLICE, Font.PLAIN, 14));
        champNom = new JTextField();
        panel.add(libEntreprise);
        panel.add(champNom);

        // Boutons Annuler et Valider
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelButtons.setBackground(new Color(238, 237, 237));

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setFont(new Font(POLICE, Font.PLAIN, 14));
        btnAnnuler.addActionListener(gestionClic);
        panelButtons.add(btnAnnuler);

        JButton btnValider = new JButton("Valider");
        btnValider.setFont(new Font(POLICE, Font.PLAIN, 14));
        btnValider.addActionListener(gestionClic);
        panelButtons.add(btnValider);

        contentPane.add(panelButtons, BorderLayout.SOUTH);
    }

    public Entreprise getEntrepriseFromInput() {
        // Créer un objet Entreprise avec les données saisies
        return new Entreprise(
            champSiren.getText(),
            champAdresse.getText(),
            champTel.getText(),
            champNom.getText()
        );
    }

    // Méthodes pour récupérer les valeurs des champs de saisie
    public String getSiren() {
        return champSiren.getText();
    }

    public String getAdresse() {
        return champAdresse.getText();
    }

    public String getTel() {
        return champTel.getText();
    }

    public String getNom() {
        return champNom.getText();
    }
}
