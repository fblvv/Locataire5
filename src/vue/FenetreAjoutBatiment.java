package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.GestionAjoutBatiment;
import controle.GestionPageAjoutLocataire;
import modele.Batiment;
import modele.dao.DaoBatiment;

public class FenetreAjoutBatiment extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField champRegimeJuridique;
    private JTextField champAdresse;
    private JTextField champCodePostal;
    private JFormattedTextField champDateConstruction;
    private JTextField champEquipAccesTech;
    private JTextField champEnumPartiesCommunes;
    private GestionAjoutBatiment gestionClic;

    public FenetreAjoutBatiment() {
    	this.gestionClic = new GestionAjoutBatiment(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel libInfoBatiment = new JLabel("Information sur le bâtiment");
        panel.add(libInfoBatiment, BorderLayout.NORTH);

        JPanel panel_1 = new JPanel();
        panel_1.setMinimumSize(new Dimension(5, 5));
        panel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panelRegimeJuridique = new JPanel();
        panel_1.add(panelRegimeJuridique);

        JLabel libRegimeJuridique = new JLabel("Régime Juridique");
        libRegimeJuridique.setHorizontalAlignment(SwingConstants.LEFT);

        champRegimeJuridique = new JTextField();
        champRegimeJuridique.setHorizontalAlignment(SwingConstants.RIGHT);
        champRegimeJuridique.setColumns(10);
        panelRegimeJuridique.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelRegimeJuridique.add(libRegimeJuridique);
        panelRegimeJuridique.add(champRegimeJuridique);

        JPanel panelAdresse = new JPanel();
        panel_1.add(panelAdresse);

        JLabel libAdresse = new JLabel("Adresse");
        libAdresse.setHorizontalAlignment(SwingConstants.LEFT);

        champAdresse = new JTextField();
        champAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
        champAdresse.setColumns(10);
        panelAdresse.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelAdresse.add(libAdresse);
        panelAdresse.add(champAdresse);

        JPanel panelCodePostal = new JPanel();
        panel_1.add(panelCodePostal);

        JLabel libCodePostal = new JLabel("Code Postal");
        panelCodePostal.add(libCodePostal);

        champCodePostal = new JTextField();
        champCodePostal.setColumns(10);
        panelCodePostal.add(champCodePostal);

        JPanel panelDateConstruction = new JPanel();
        panel_1.add(panelDateConstruction);

        JLabel libDateConstruction = new JLabel("Date de Construction");
        panelDateConstruction.add(libDateConstruction);

        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            champDateConstruction = new JFormattedTextField(dateFormatter);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            champDateConstruction.setValue(dateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
            champDateConstruction = new JFormattedTextField();
        }

        panelDateConstruction.add(champDateConstruction);

        JPanel panelEquipAccesTech = new JPanel();
        panel_1.add(panelEquipAccesTech);

        JLabel libEquipAccesTech = new JLabel("Equip Acces Tech");
        panelEquipAccesTech.add(libEquipAccesTech);

        champEquipAccesTech = new JTextField();
        champEquipAccesTech.setColumns(10);
        panelEquipAccesTech.add(champEquipAccesTech);

        JPanel panelEnumPartiesCommunes = new JPanel();
        panel_1.add(panelEnumPartiesCommunes);

        JLabel libEnumPartiesCommunes = new JLabel("Enum Parties Communes");
        panelEnumPartiesCommunes.add(libEnumPartiesCommunes);

        champEnumPartiesCommunes = new JTextField();
        champEnumPartiesCommunes.setColumns(10);
        panelEnumPartiesCommunes.add(champEnumPartiesCommunes);

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BorderLayout(0, 0));

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this.gestionClic);
        panel_2.add(btnAnnuler, BorderLayout.WEST);

        JButton btnValider = new JButton("Valider");
        // Ajoutez l'actionListener pour valider si nécessaire
        panel_2.add(btnValider, BorderLayout.EAST);

        JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, BorderLayout.NORTH);
        panel_3.setLayout(new BorderLayout(0, 0));

        JLabel libAjouterBatiment = new JLabel("Ajouter un nouveau bâtiment");
        libAjouterBatiment.setHorizontalAlignment(SwingConstants.CENTER);
        panel_3.add(libAjouterBatiment, BorderLayout.CENTER);
    }

    public Batiment getBatimentFromInput() {
        // Créer un objet Batiment avec les données saisies
        return new Batiment(
            "",
            champRegimeJuridique.getText(),
            champAdresse.getText(),
            champCodePostal.getText(),
            champDateConstruction.getText(),
            champEquipAccesTech.getText(),
            champEnumPartiesCommunes.getText()
        );
    }
}
