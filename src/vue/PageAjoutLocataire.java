package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

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
import modele.Batiment;
import modele.BienImmobilier;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienImmobilier;

public class PageAjoutLocataire extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField champNom;
    private JTextField champPrenom;
    private JTextField champTelephone;
    private JTextField champMail;
    private JTextField textField_9;
    private GestionPageAjoutLocataire gestionClic;
    private JComboBox<String> comboBoxLogement;
    private JFormattedTextField champDateEntree;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    PageAjoutLocataire frame = new PageAjoutLocataire();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PageAjoutLocataire() {
        this.gestionClic = new GestionPageAjoutLocataire(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel libInfoLocataire = new JLabel("Information sur le locataire");
        panel.add(libInfoLocataire, BorderLayout.NORTH);

        JPanel panel_1 = new JPanel();
        panel_1.setMinimumSize(new Dimension(5, 5));
        panel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panelNom = new JPanel();
        panel_1.add(panelNom);

        JLabel libNom = new JLabel("Nom");
        libNom.setHorizontalAlignment(SwingConstants.LEFT);

        champNom = new JTextField();
        champNom.setHorizontalAlignment(SwingConstants.RIGHT);
        champNom.setColumns(10);
        panelNom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelNom.add(libNom);
        panelNom.add(champNom);

        JPanel panelPrenom = new JPanel();
        panel_1.add(panelPrenom);

        JLabel libPrenom = new JLabel("Prénom");
        libPrenom.setHorizontalAlignment(SwingConstants.LEFT);

        champPrenom = new JTextField();
        champPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
        champPrenom.setColumns(10);
        panelPrenom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelPrenom.add(libPrenom);
        panelPrenom.add(champPrenom);

        JPanel panelTelephone = new JPanel();
        panel_1.add(panelTelephone);

        JLabel libTelephone = new JLabel("Télephone");
        panelTelephone.add(libTelephone);

        champTelephone = new JTextField();
        champTelephone.setColumns(10);
        panelTelephone.add(champTelephone);

        JPanel panelMail = new JPanel();
        panel_1.add(panelMail);

        JLabel libMail = new JLabel("Mail");
        panelMail.add(libMail);

        champMail = new JTextField();
        champMail.setColumns(10);
        panelMail.add(champMail);

        JPanel panelDateEntree = new JPanel();
        panel_1.add(panelDateEntree);

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

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BorderLayout(0, 0));

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this.gestionClic);
        panel_2.add(btnAnnuler, BorderLayout.WEST);

        JButton btnValider = new JButton("Valider");
        btnValider.addActionListener(this.gestionClic);
        panel_2.add(btnValider, BorderLayout.EAST);

        JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, BorderLayout.NORTH);
        panel_3.setLayout(new BorderLayout(0, 0));

        JLabel libAjouterLocataire = new JLabel("Ajouter un nouveau locataire");
        libAjouterLocataire.setHorizontalAlignment(SwingConstants.CENTER);
        panel_3.add(libAjouterLocataire, BorderLayout.CENTER);

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
            // Fetch all batiments
            Collection<BienImmobilier> biens = daoBienImmobilier.findAll();

            // Create an array to store building IDs
            String[] idBat = new String[biens.size()];

            // Populate the array with building IDs
            int i=0;
            for (BienImmobilier bien : biens) {
                idBat[i] = bien.getId_Bien_Imm();
                System.out.println(idBat[i]);
                i++;
            }

            // Create JComboBox with building IDs
            comboBoxLogement = new JComboBox<>(idBat);

            // Add the JComboBox to your UI
            // Assuming you have a panel where you want to add it
            // Modify this part according to your UI structure
            JPanel panelComboBoxLogement = new JPanel();
            panelComboBoxLogement.add(comboBoxLogement);
            contentPane.add(panelComboBoxLogement, BorderLayout.CENTER);

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, e.g., show an error message to the user
        }
    }
}
