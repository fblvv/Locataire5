package vue;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.GestionAccueil;

public class Accueil extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private GestionAccueil gestionClic;
    private static final String POLICE = "Tahoma";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Accueil frame = new Accueil();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Accueil() {
        // Initialisation de la gestion des clics
        this.gestionClic = new GestionAccueil(this);
        
        // Configuration de la fenêtre principale
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 1080);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Chargement de l'image de fond
        Image backgroundImage = new ImageIcon(this.getClass().getResource("/imageBgAcceuil.jpeg")).getImage();

        // Affichage de l'image de fond
        JLabel lblImageBG = new JLabel("imageBg");
        lblImageBG.setIcon(new ImageIcon(backgroundImage));
        lblImageBG.setBounds(54, 84, 612, 500);
        contentPane.add(lblImageBG);

        // Configuration de la barre de menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font(POLICE, Font.BOLD, 18));
        menuBar.setBounds(20, 30, 1200, 30);
        contentPane.add(menuBar);

        // Menu "Locataire"
        JMenu mnLocataire = new JMenu("Locataire");
        mnLocataire.setFont(new Font(POLICE, Font.BOLD, 18));
        menuBar.add(mnLocataire);

        // Sous-menu "Ajouter locataire"
        JMenuItem mntmAjouterLocataire = new JMenuItem("Ajouter locataire");
        mntmAjouterLocataire.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmAjouterLocataire.addActionListener(this.gestionClic);
        mnLocataire.add(mntmAjouterLocataire);

        // Sous-menu "Liste des locataires"
        JMenuItem mntmConsultation = new JMenuItem("Liste des locataires");
        mntmConsultation.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmConsultation.addActionListener(this.gestionClic);
        mnLocataire.add(mntmConsultation);
        
        // Sous-menu "Consulter contrat de location"
        JMenuItem mntmConsultationLocation = new JMenuItem("Consulter contrat de location");
        mntmConsultationLocation.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmConsultationLocation.addActionListener(this.gestionClic);
        mnLocataire.add(mntmConsultationLocation);

        // Menu "Logement"
        JMenu mnLogement = new JMenu("Logement");
        mnLogement.setFont(new Font(POLICE, Font.BOLD, 18));
        menuBar.add(mnLogement);

        // Sous-menu "Ajouter logement"
        JMenuItem mntmAjouterLogement = new JMenuItem("Ajouter logement");
        mntmAjouterLogement.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmAjouterLogement.addActionListener(this.gestionClic);
        mnLogement.add(mntmAjouterLogement);

        // Sous-menu "Consulter logement"
        JMenuItem mntmConsulterLogement = new JMenuItem("Consulter logement");
        mntmConsulterLogement.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmConsulterLogement.addActionListener(this.gestionClic);
        mnLogement.add(mntmConsulterLogement);

        // Menu "Documents"
        JMenu mnDocument = new JMenu("Documents");
        mnDocument.setFont(new Font(POLICE, Font.BOLD, 19));
        menuBar.add(mnDocument);

        // Sous-menu "Gestion Charges"
        JMenuItem mntmGestionFacture = new JMenuItem("Gestion Charges");
        mntmGestionFacture.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmGestionFacture.addActionListener(this.gestionClic);
        mnDocument.add(mntmGestionFacture);
        
        // Sous-menu "Ajouter loyers"
        JMenuItem mntmGestionLoyer = new JMenuItem("Ajouter loyers");
        mntmGestionLoyer.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmGestionLoyer.addActionListener(this.gestionClic);
        mnDocument.add(mntmGestionLoyer);
        
        // Sous-menu "Gestion Factures"
        JMenuItem mntmNewMenuItem = new JMenuItem("Gestion Factures");
        mntmNewMenuItem.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmNewMenuItem.addActionListener(this.gestionClic);
        mnDocument.add(mntmNewMenuItem);
        
        // Menu "Ajouter Batiment"
        JMenu mnAjouterBatiment = new JMenu("Ajouter Batiment");
        mnAjouterBatiment.setFont(new Font(POLICE, Font.BOLD, 19));
        menuBar.add(mnAjouterBatiment);
        
        // Sous-menu "Ajouter Nouveau Batiment"
        JMenuItem mntmAjouterBatiment = new JMenuItem("Ajouter Nouveau Batiment");
        mntmAjouterBatiment.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmAjouterBatiment.addActionListener(this.gestionClic);
        mnAjouterBatiment.add(mntmAjouterBatiment);
        
        // Menu "Gestion Compteur"
        JMenu mnGestionCompteur = new JMenu("Gestion Compteur");
        mnGestionCompteur.setFont(new Font(POLICE, Font.BOLD, 19));
        menuBar.add(mnGestionCompteur);
        
        // Sous-menu "Gestion des Compteurs"
        JMenuItem mntmCompteur = new JMenuItem("Gestion des Compteurs");
        mntmCompteur.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmCompteur.addActionListener(this.gestionClic);
        mnGestionCompteur.add(mntmCompteur);
    
        // Menu "CSV"
        JMenu mnLireCSV = new JMenu("CSV");
        mnLireCSV.setFont(new Font(POLICE, Font.BOLD, 19));
        menuBar.add(mnLireCSV);
        
        // Sous-menu "Lire fichier CSV"
        JMenuItem mntmLireCSV = new JMenuItem("Lire fichier CSV");
        mntmLireCSV.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmLireCSV.addActionListener(this.gestionClic);
        mnLireCSV.add(mntmLireCSV);
        
        // Menu "Solde de tout compte"
        JMenu mnSoldeDeToutCompte = new JMenu("Solde de tout compte");
        mnSoldeDeToutCompte.setFont(new Font(POLICE, Font.BOLD, 19));
        menuBar.add(mnSoldeDeToutCompte);
        
        // Sous-menu "Vérifier le Solde de tout compte"
        JMenuItem mntmSoldeDeToutCompte = new JMenuItem("Vérifier le Solde de tout compte");
        mntmSoldeDeToutCompte.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmSoldeDeToutCompte.addActionListener(this.gestionClic);
        mnSoldeDeToutCompte.add(mntmSoldeDeToutCompte);
        
        // Menu "Entreprise"
        JMenu mnEntreprise = new JMenu("Entreprise");
        mnEntreprise.setFont(new Font("Tahoma", Font.BOLD, 19));
        mnEntreprise.addActionListener(this.gestionClic);
        menuBar.add(mnEntreprise);
        
        // Sous-menu "Consulter"
        JMenuItem mntmConsulter = new JMenuItem("Consulter");
        mntmConsulter.setFont(new Font("Tahoma", Font.PLAIN, 15));
        mntmConsulter.addActionListener(this.gestionClic);
        mnEntreprise.add(mntmConsulter);
    
        // Sous-menu "Ajouter Une Entreprise"
        JMenuItem mntmAjouterEntreprise = new JMenuItem("Ajouter Une Entreprise");
        mntmAjouterEntreprise.setFont(new Font(POLICE, Font.PLAIN, 15));
        mntmAjouterEntreprise.addActionListener(this.gestionClic);
        mnEntreprise.add(mntmAjouterEntreprise);
    }

    public void actionPerformed(ActionEvent e) {
        gestionClic.actionPerformed(e);
    }
}
