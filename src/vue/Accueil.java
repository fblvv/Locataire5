
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
import javax.swing.JButton;

public class Accueil extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private GestionAccueil gestionClic;

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
        this.gestionClic = new GestionAccueil(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 1080);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Image backgroundImage = new ImageIcon(this.getClass().getResource("/imageBgAcceuil.jpeg")).getImage();

        JLabel lblImageBG = new JLabel("imageBg");
        lblImageBG.setIcon(new ImageIcon(backgroundImage));
        lblImageBG.setBounds(54, 84, 612, 500);
        contentPane.add(lblImageBG);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        menuBar.setBounds(20, 30, 1200, 30);
        contentPane.add(menuBar);

        //q
        JMenu mnLocataire = new JMenu("Locataire");
        mnLocataire.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        menuBar.add(mnLocataire);

        JMenuItem mntmAjouterLocataire = new JMenuItem("Ajouter locataire");
        mntmAjouterLocataire.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mntmAjouterLocataire.addActionListener(this.gestionClic);
        mnLocataire.add(mntmAjouterLocataire);

        JMenuItem mntmConsultation = new JMenuItem("Liste des locataires");
        mntmConsultation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mntmConsultation.addActionListener(this.gestionClic);
        mnLocataire.add(mntmConsultation);
        
        JMenuItem mntmConsultationLocation = new JMenuItem("Consulter contrat de location");
        mntmConsultationLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mntmConsultationLocation.addActionListener(this.gestionClic);
        mnLocataire.add(mntmConsultationLocation);

        JMenu mnLogement = new JMenu("Logement");
        mnLogement.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        menuBar.add(mnLogement);

        JMenuItem mntmAjouterLogement = new JMenuItem("Ajouter logement");
        mntmAjouterLogement.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mntmAjouterLogement.addActionListener(this.gestionClic);
        mnLogement.add(mntmAjouterLogement);

        JMenuItem mntmConsulterLogement = new JMenuItem("Consulter logement");
        mntmConsulterLogement.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mntmConsulterLogement.addActionListener(this.gestionClic);
        mnLogement.add(mntmConsulterLogement);

        JMenu mnDocument = new JMenu("Documents");
        mnDocument.setFont(new Font("Lucida Grande", Font.BOLD, 19));
        menuBar.add(mnDocument);

        JMenuItem mntmGestionFacture = new JMenuItem("Gestion factures");
        mntmGestionFacture.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mntmGestionFacture.addActionListener(this.gestionClic);
        mnDocument.add(mntmGestionFacture);
        
        JMenuItem mntmGestionLoyer = new JMenuItem("Ajouter loyers");
        mntmGestionLoyer.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mntmGestionLoyer.addActionListener(this.gestionClic);
        mnDocument.add(mntmGestionLoyer);
        
        JMenu mnAjouterBatiment = new JMenu("Ajouter Batiment");
        mnAjouterBatiment.setFont(new Font("Lucida Grande", Font.BOLD, 19));
        menuBar.add(mnAjouterBatiment);
        
        JMenuItem mntmAjouterBatiment = new JMenuItem("Ajouter Nouveau Batiment");
        mntmAjouterBatiment.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mntmAjouterBatiment.addActionListener(this.gestionClic);
        mnAjouterBatiment.add(mntmAjouterBatiment);
        
        JMenu mnGestionCompteur = new JMenu("Gestion Compteur");
        mnGestionCompteur.setFont(new Font("Lucida Grande", Font.BOLD, 19));
        menuBar.add(mnGestionCompteur);
        
        JMenuItem mntmCompteur = new JMenuItem("Gestion des Compteurs");
        mntmCompteur.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mntmCompteur.addActionListener(this.gestionClic);
        mnGestionCompteur.add(mntmCompteur);
    
        JMenu mnLireCSV = new JMenu("CSV");
        mnLireCSV.setFont(new Font("Lucida Grande", Font.BOLD, 19));
        menuBar.add(mnLireCSV);
        
        JMenuItem mntmLireCSV = new JMenuItem("Lire fichier CSV");
        mntmLireCSV.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mntmLireCSV.addActionListener(this.gestionClic);
        mnLireCSV.add(mntmLireCSV);
    

    }

    public void actionPerformed(ActionEvent e) {
        gestionClic.actionPerformed(e);
    }
}
