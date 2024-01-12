package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controle.GestionAjoutBatiment;
import modele.Batiment;

public class FenetreAjoutBatiment extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField champRegimeJuridique;
    private JTextField champAdresse;
    private JTextField champCodePostal;
    private JTextField champEquipAccesTech;
    private JTextField champEnumPartiesCommunes;
    private JTextField textNomBatiment;
    private JTextField champDateConstruction;
    private GestionAjoutBatiment gestionClic;
    private static final String POLICE = "Tahoma";

    public FenetreAjoutBatiment() {
        gestionClic = new GestionAjoutBatiment(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel libAjouterBatiment = new JLabel("Ajouter un nouveau bâtiment");
        libAjouterBatiment.setFont(new Font(POLICE, Font.BOLD, 18));
        libAjouterBatiment.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(libAjouterBatiment, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBackground(new Color(238, 237, 238));
        contentPane.add(panel, BorderLayout.CENTER);

        // Champ pour le nom du bâtiment
        JLabel lblNomBatiment = new JLabel("Nom Bâtiment");
        lblNomBatiment.setFont(new Font(POLICE, Font.PLAIN, 14));
        textNomBatiment = new JTextField();
        panel.add(lblNomBatiment);
        panel.add(textNomBatiment);

        // Champ pour le régime juridique
        JLabel libRegimeJuridique = new JLabel("Régime Juridique");
        libRegimeJuridique.setFont(new Font(POLICE, Font.PLAIN, 14));
        champRegimeJuridique = new JTextField();
        panel.add(libRegimeJuridique);
        panel.add(champRegimeJuridique);

        // Champ pour l'adresse
        JLabel libAdresse = new JLabel("Adresse");
        libAdresse.setFont(new Font(POLICE, Font.PLAIN, 14));
        champAdresse = new JTextField();
        panel.add(libAdresse);
        panel.add(champAdresse);

        // Champ pour le code postal
        JLabel libCodePostal = new JLabel("Code Postal");
        libCodePostal.setFont(new Font(POLICE, Font.PLAIN, 14));
        champCodePostal = new JTextField("12345");
        panel.add(libCodePostal);
        panel.add(champCodePostal);

     // Champ pour la date de construction
        JLabel libDateConstruction = new JLabel("Date de Construction");
        libDateConstruction.setFont(new Font(POLICE, Font.PLAIN, 14));
        champDateConstruction = new JTextField("DD/MM/YYYY"); 
        panel.add(libDateConstruction);
        panel.add(champDateConstruction);

        // Champ pour l'équipement d'accès technique
        JLabel libEquipAccesTech = new JLabel("Équip. Accès Tech.");
        libEquipAccesTech.setFont(new Font(POLICE, Font.PLAIN, 14));
        champEquipAccesTech = new JTextField();
        panel.add(libEquipAccesTech);
        panel.add(champEquipAccesTech);

        // Champ pour les parties communes
        JLabel libEnumPartiesCommunes = new JLabel("Parties Communes");
        libEnumPartiesCommunes.setFont(new Font(POLICE, Font.PLAIN, 14));
        champEnumPartiesCommunes = new JTextField();
        panel.add(libEnumPartiesCommunes);
        panel.add(champEnumPartiesCommunes);

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

    public Batiment getBatimentFromInput() {
        // Créer un objet Batiment avec les données saisies
        return new Batiment(
            textNomBatiment.getText(),
            champRegimeJuridique.getText(),
            champAdresse.getText(),
            champCodePostal.getText(),
            champDateConstruction.getText(),
            champEquipAccesTech.getText(),
            champEnumPartiesCommunes.getText()
        );
    }

	public String getIdBatiment() {
		return textNomBatiment.getText() ;
	}

	public String getRegimeJuridique() {
		return champRegimeJuridique.getText();
	}

	public String getAdresse() {
		return champAdresse.getText();
	            
	}

	public String getCodePostal() {
		return champCodePostal.getText();
	            
	}

	public String getDateConstruction() {
		return champDateConstruction.getText();
	            
	}

	public String getEquipAccesTech() {
		return champEquipAccesTech.getText();
	            
	}

	public String getEnumPartiesCommunes() {
		return champEnumPartiesCommunes.getText();
	}
}