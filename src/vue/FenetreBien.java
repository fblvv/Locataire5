package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.GestionAjoutBienImmo;
import modele.Batiment;
import modele.dao.DaoBatiment;

public class FenetreBien extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    // JTextFields for Assurance Obligatoire
    private JTextField textFieldNumeroPoliceObl;
    private JTextField textFieldTarifInitialObl;
    private JTextField textFieldTypeAssuranceObl;
    private JTextField textFieldDateDebutObl;

    // JTextFields for Assurance Optionnelle
    private JTextField textFieldNumeroPoliceOpt;
    private JTextField textFieldTarifInitialOpt;
    private JTextField textFieldTypeAssuranceOpt;
    private JTextField textFieldDateDebutOpt;

    // JTextFields for Autres informations
    private JTextField textFieldIdBienImmobilier;
    private JTextField textFieldSurface;
    private JTextField textFieldModeChauffage;
    private JTextField textFieldModeEau;
    private JTextField textFieldNbPiece;
    private JTextField textFieldNomProprio;
    private JTextField textFieldIdentifiant;

    private JPanel panelButton;
    private JButton btnAnnuler;
    private JButton btnValider;
    private GestionAjoutBienImmo gestionClic;

    private JComboBox<String> comboBoxBatiment;
    private JComboBox<String> comboBoxTypeBien; 
    private JSpinner spinnerEtage;
    
    Logger logger = Logger.getLogger(getClass().getName());

    public FenetreBien() {
        this.gestionClic = new GestionAjoutBienImmo(this);
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
        panelAssurance.add(textFieldDateDebutObl = new JTextField(25));

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
        
        panelAutres.add(new JLabel("Bâtiment:", SwingConstants.RIGHT));
        initComboBoxBatiment();
        panelAutres.add(comboBoxBatiment);
        
        initComboBoxBatiment();


     // Ajout des autres champs SQL
        panelAutres.add(new JLabel("Id Bien Immobilier:", SwingConstants.RIGHT));
        textFieldIdBienImmobilier = new JTextField(10);
        panelAutres.add(textFieldIdBienImmobilier);

        panelAutres.add(new JLabel("Surface:", SwingConstants.RIGHT));
        textFieldSurface = new JTextField(10);
        panelAutres.add(textFieldSurface);

        panelAutres.add(new JLabel("Mode Chauffage:", SwingConstants.RIGHT));
        textFieldModeChauffage = new JTextField(10);
        panelAutres.add(textFieldModeChauffage);

        panelAutres.add(new JLabel("Mode Eau:", SwingConstants.RIGHT));
        textFieldModeEau = new JTextField(10);
        panelAutres.add(textFieldModeEau);

        panelAutres.add(new JLabel("Nb Piece:", SwingConstants.RIGHT));
        textFieldNbPiece = new JTextField(10);
        panelAutres.add(textFieldNbPiece);

        panelAutres.add(new JLabel("Type de Bien:", SwingConstants.RIGHT));
        
        // La JComboBox avec les valeurs de T1 à T4
        String[] typesBien = {"T1", "T2", "T3", "T4"};
        comboBoxTypeBien = new JComboBox<>(typesBien);
        panelAutres.add(comboBoxTypeBien);

        panelAutres.add(new JLabel("Nom Proprio:", SwingConstants.RIGHT));
        textFieldNomProprio = new JTextField(10);
        panelAutres.add(textFieldNomProprio);

        panelAutres.add(new JLabel("Identifiant:", SwingConstants.RIGHT));
        textFieldIdentifiant = new JTextField(10);
        panelAutres.add(textFieldIdentifiant);

        panelAutres.add(new JLabel("Étage:", SwingConstants.RIGHT));
        SpinnerNumberModel etageModel = new SpinnerNumberModel(0, 0, 20, 1); 
        spinnerEtage = new JSpinner(etageModel);
        panelAutres.add(spinnerEtage);


        // Panel de boutons en bas
        panelButton = new JPanel();
        mainPanel.add(panelButton, BorderLayout.SOUTH);

        btnValider = new JButton("Valider");
        btnValider.addActionListener(this.gestionClic);
        panelButton.add(btnValider);

        btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this.gestionClic);
        panelButton.add(btnAnnuler);
        

    }
    

    public String getTextFieldNumeroPoliceObl() {
		return textFieldNumeroPoliceObl.getText();
	}


	public void setTextFieldNumeroPoliceObl(JTextField textFieldNumeroPoliceObl) {
		this.textFieldNumeroPoliceObl = textFieldNumeroPoliceObl;
	}


	public String getTextFieldTarifInitialObl() {
		return textFieldTarifInitialObl.getText();
	}


	public void setTextFieldTarifInitialObl(JTextField textFieldTarifInitialObl) {
		this.textFieldTarifInitialObl = textFieldTarifInitialObl;
	}


	public String getTextFieldTypeAssuranceObl() {
		return textFieldTypeAssuranceObl.getText();
	}


	public void setTextFieldTypeAssuranceObl(JTextField textFieldTypeAssuranceObl) {
		this.textFieldTypeAssuranceObl = textFieldTypeAssuranceObl;
	}


	public String getTextFieldDateDebutObl() {
		return textFieldDateDebutObl.getText();
	}


	public void setTextFieldDateDebutObl(JTextField textFieldDateDebutObl) {
		this.textFieldDateDebutObl = textFieldDateDebutObl;
	}


	public String getTextFieldNumeroPoliceOpt() {
		return textFieldNumeroPoliceOpt.getText();
	}


	public void setTextFieldNumeroPoliceOpt(JTextField textFieldNumeroPoliceOpt) {
		this.textFieldNumeroPoliceOpt = textFieldNumeroPoliceOpt;
	}


	public String getTextFieldTarifInitialOpt() {
		return textFieldTarifInitialOpt.getText();
	}


	public void setTextFieldTarifInitialOpt(JTextField textFieldTarifInitialOpt) {
		this.textFieldTarifInitialOpt = textFieldTarifInitialOpt;
	}


	public String getTextFieldTypeAssuranceOpt() {
		return textFieldTypeAssuranceOpt.getText();
	}


	public void setTextFieldTypeAssuranceOpt(JTextField textFieldTypeAssuranceOpt) {
		this.textFieldTypeAssuranceOpt = textFieldTypeAssuranceOpt;
	}


	public String getTextFieldDateDebutOpt() {
		return textFieldDateDebutOpt.getText();
	}


	public void setTextFieldDateDebutOpt(JTextField textFieldDateDebutOpt) {
		this.textFieldDateDebutOpt = textFieldDateDebutOpt;
	}


	public String getTextFieldIdBienImmobilier() {
		return textFieldIdBienImmobilier.getText();
	}


	public void setTextFieldIdBienImmobilier(JTextField textFieldIdBienImmobilier) {
		this.textFieldIdBienImmobilier = textFieldIdBienImmobilier;
	}


	public String getTextFieldSurface() {
		return textFieldSurface.getText();
	}


	public void setTextFieldSurface(JTextField textFieldSurface) {
		this.textFieldSurface = textFieldSurface;
	}


	public String getTextFieldModeChauffage() {
		return textFieldModeChauffage.getText();
	}


	public void setTextFieldModeChauffage(JTextField textFieldModeChauffage) {
		this.textFieldModeChauffage = textFieldModeChauffage;
	}


	public String getTextFieldModeEau() {
		return textFieldModeEau.getText();
	}


	public void setTextFieldModeEau(JTextField textFieldModeEau) {
		this.textFieldModeEau = textFieldModeEau;
	}


	public String getTextFieldNbPiece() {
		return textFieldNbPiece.getText();
	}


	public void setTextFieldNbPiece(JTextField textFieldNbPiece) {
		this.textFieldNbPiece = textFieldNbPiece;
	}


	public String getTextFieldTypeBien() {
		return comboBoxTypeBien.getSelectedItem().toString();
	}


	public String getTextFieldNomProprio() {
		return textFieldNomProprio.getText();
	}


	public void setTextFieldNomProprio(JTextField textFieldNomProprio) {
		this.textFieldNomProprio = textFieldNomProprio;
	}


	public String getTextFieldIdentifiant() {
		return textFieldIdentifiant.getText();
	}


	public void setTextFieldIdentifiant(JTextField textFieldIdentifiant) {
		this.textFieldIdentifiant = textFieldIdentifiant;
	}


	public String getTextFieldEtage() {
		return spinnerEtage.getName();
	}


	public JComboBox<String> getComboBoxBatiment() {
		return comboBoxBatiment;
	}


	public void setComboBoxBatiment(JComboBox<String> comboBoxBatiment) {
		this.comboBoxBatiment = comboBoxBatiment;
	}
	
	
	private void initComboBoxBatiment() {
        DaoBatiment daoBatiment = new DaoBatiment();

        try {
            // Récupérer tous les bâtiments
            Collection<Batiment> batiments = daoBatiment.findAll();

            // Créer un tableau pour stocker les identifiants des bâtiments
            String[] idBats = new String[batiments.size()];

            // Remplir le tableau avec les identifiants des bâtiments
            int i = 0;
            for (Batiment batiment : batiments) {
                idBats[i] = String.valueOf(batiment.getId_Batiment());
                logger.info(idBats[i]);
                i++;
            }

            // Créer une JComboBox avec les identifiants des bâtiments
            comboBoxBatiment = new JComboBox<>(idBats);

        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception, par exemple, afficher un message d'erreur à l'utilisateur
        }
    }


	public static void main(String[] args) {
        FenetreBien frame = new FenetreBien();
        frame.setVisible(true);
    }
}