package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.GestionPageAjoutLocataire;
import modele.BienImmobilier;
import modele.dao.DaoBienImmobilier;

public class PageAjoutLocataire extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField champNom;
    private JTextField champPrenom;
    private JTextField champTelephone;
    private JTextField champMail;
    private GestionPageAjoutLocataire gestionClic;
    private JComboBox<String> comboBoxLogement;
    private JFormattedTextField champDateEntree;
    
    Logger logger = Logger.getLogger(getClass().getName());

    public PageAjoutLocataire() {
        this.gestionClic = new GestionPageAjoutLocataire(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel libInfoLocataire = new JLabel("Information sur le locataire");
        panel.add(libInfoLocataire, BorderLayout.NORTH);

        JPanel panel1 = new JPanel();
        panel1.setMinimumSize(new Dimension(5, 5));
        panel.add(panel1, BorderLayout.CENTER);
        panel1.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panelNom = new JPanel();
        panel1.add(panelNom);

        JLabel libNom = new JLabel("Nom");
        libNom.setHorizontalAlignment(SwingConstants.LEFT);

        champNom = new JTextField();
        champNom.setHorizontalAlignment(SwingConstants.RIGHT);
        champNom.setColumns(10);
        panelNom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelNom.add(libNom);
        panelNom.add(champNom);

        JPanel panelPrenom = new JPanel();
        panel1.add(panelPrenom);

        JLabel libPrenom = new JLabel("Prénom");
        libPrenom.setHorizontalAlignment(SwingConstants.LEFT);

        champPrenom = new JTextField();
        champPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
        champPrenom.setColumns(10);
        panelPrenom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelPrenom.add(libPrenom);
        panelPrenom.add(champPrenom);

        JPanel panelTelephone = new JPanel();
        panel1.add(panelTelephone);

        JLabel libTelephone = new JLabel("Télephone");
        panelTelephone.add(libTelephone);

        champTelephone = new JTextField();
        champTelephone.setColumns(10);
        panelTelephone.add(champTelephone);

        JPanel panelMail = new JPanel();
        panel1.add(panelMail);

        JLabel libMail = new JLabel("Mail");
        panelMail.add(libMail);

        champMail = new JTextField();
        champMail.setColumns(10);
        panelMail.add(champMail);

        JPanel panelDateEntree = new JPanel();
        panel1.add(panelDateEntree);

        JLabel libDateEntree = new JLabel("Date d'entrée");
        panelDateEntree.add(libDateEntree);

        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            champDateEntree = new JFormattedTextField(dateFormatter);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            champDateEntree.setValue(dateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
            champDateEntree = new JFormattedTextField();
        }

        panelDateEntree.add(champDateEntree);

        JPanel panel2 = new JPanel();
        contentPane.add(panel2, BorderLayout.SOUTH);
        panel2.setLayout(new BorderLayout(0, 0));

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this.gestionClic);
        panel2.add(btnAnnuler, BorderLayout.WEST);

        JButton btnValider = new JButton("Valider");
        btnValider.addActionListener(this.gestionClic);
        panel2.add(btnValider, BorderLayout.EAST);

        JPanel panel3 = new JPanel();
        contentPane.add(panel3, BorderLayout.NORTH);
        panel3.setLayout(new BorderLayout(0, 0));

        JLabel libAjouterLocataire = new JLabel("Ajouter un nouveau locataire");
        libAjouterLocataire.setHorizontalAlignment(SwingConstants.CENTER);
        panel3.add(libAjouterLocataire, BorderLayout.CENTER);

        JPanel panelLogementAssocie = new JPanel();
        contentPane.add(panelLogementAssocie, BorderLayout.EAST);
        panelLogementAssocie.setLayout(new BorderLayout(0, 0));

        JPanel panelInfosLogementAssocie = new JPanel();
        panelLogementAssocie.add(panelInfosLogementAssocie, BorderLayout.WEST);
        panelInfosLogementAssocie.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panelLogement = new JPanel();
        panelInfosLogementAssocie.add(panelLogement);
        panelLogement.setLayout(new BorderLayout(0, 0));

        JLabel labelLogement = new JLabel("Logement associé");
        panelLogement.add(labelLogement, BorderLayout.NORTH);

        initComboBox();
        JPanel panelComboBoxLogement = new JPanel();
        panelLogement.add(panelComboBoxLogement, BorderLayout.CENTER);
        panelComboBoxLogement.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelComboBoxLogement.add(comboBoxLogement);

    }

    public JComboBox<String> getComboBoxLogement() {
        return comboBoxLogement;
    }

    public String getChampNom() {
        return champNom.getText();
    }

    public void setChampNom(JTextField champNom) {
        this.champNom = champNom;
    }

    public String getChampPrenom() {
        return champPrenom.getText();
    }

    public void setChampPrenom(JTextField champPrenom) {
        this.champPrenom = champPrenom;
    }

    public JTextField getChampTelephone() {
        return champTelephone;
    }

    public void setChampTelephone(JTextField champTelephone) {
        this.champTelephone = champTelephone;
    }

    public String getChampMail() {
        return champMail.getText();
    }

    public void setChampMail(JTextField champMail) {
        this.champMail = champMail;
    }

    private void initComboBox() {
        DaoBienImmobilier daoBienImmobilier = new DaoBienImmobilier();
        try {
            // Récupérer tous les biens immobiliers
            Collection<BienImmobilier> biens = daoBienImmobilier.findAll();

            // Créer un tableau pour stocker les identifiants des bâtiments
            String[] idBat = new String[biens.size()];

            // Remplir le tableau avec les identifiants des bâtiments
            int i = 0;
            for (BienImmobilier bien : biens) {
                idBat[i] = bien.getId_Bien_Imm();
                logger.info(idBat[i]);
                i++;
            }

            // Créer une JComboBox avec les identifiants des bâtiments
            comboBoxLogement = new JComboBox<>(idBat);

            // Ajouter la JComboBox à votre interface utilisateur
            // En supposant que vous ayez un panneau où vous voulez l'ajouter
            // Modifiez cette partie en fonction de votre structure d'interface utilisateur
            JPanel panelComboBoxLogement = new JPanel();
            panelComboBoxLogement.add(comboBoxLogement);
            contentPane.add(panelComboBoxLogement, BorderLayout.CENTER);

        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception, par exemple, afficher un message d'erreur à l'utilisateur
        }
    }
}