import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FenetreContratLocation extends JInternalFrame {

    private JTextField champDateDebutContrat;
    private JTextField champMontant;
    private JTextField champMontantDernierLoyer;
    private JTextField champDateVersementLoyer;
    private JTextField champDepotGarantie;
    private JTextField champDateRevision;
    private JTextField champPeriodicitePaiement;
    private JTextField champDateFinContrat;
    private JTextField champChargesProvisionnelles;
    private JTextField champIdICC;
    private JTextField champValeurICC;
    private JTextField champIdBienImm;
    private JTextField champDateEntree;
    private JTextField champDateSortie;
    private JTextField champCaution;

    private JCheckBox optionnelCheckbox;
    private JTextField champNom;
    private JTextField champPrenom;
    private JTextField champNumeroTelephone;

    public FenetreContratLocation(String locataire, String bien) {
        super("Contrat de Location - Locataire: " + locataire + ", Bien: " + bien, true, true, true, true);
        setSize(600, 400);

        // Ajout des champs de texte
        champDateDebutContrat = new JTextField("YYYY-MM-DD", 15);
        champMontantDernierLoyer = new JTextField(15);
        champDateVersementLoyer = new JTextField("YYYY-MM-DD", 15);
        champDepotGarantie = new JTextField(15);
        champDateRevision = new JTextField(15);
        champPeriodicitePaiement = new JTextField(15);
        champDateFinContrat = new JTextField("YYYY-MM-DD", 15);
        champChargesProvisionnelles = new JTextField(15);
        champIdICC = new JTextField(15);
        champValeurICC = new JTextField(15);
        champIdBienImm = new JTextField(15);
        champDateEntree = new JTextField("YYYY-MM-DD", 15);
        champDateSortie = new JTextField("YYYY-MM-DD", 15);
        champCaution = new JTextField(15);
        champNom = new JTextField(15);
        champPrenom = new JTextField(15);
        champNumeroTelephone = new JTextField(15);

        // Bouton pour fermer la fenêtre
        JButton fermerButton = new JButton("Fermer");
        fermerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        getContentPane().add(champDateDebutContrat);
        getContentPane().add(new JLabel("Montant Dernier Loyer:"));
        JLabel label = new JLabel("Montant:");
        getContentPane().add(label);
        getContentPane().add(champMontantDernierLoyer);
        champMontant = new JTextField(15);
        getContentPane().add(champMontant);
        getContentPane().add(new JLabel("Date Versement Loyer (YYYY-MM-DD):"));
        getContentPane().add(champDateVersementLoyer);
        getContentPane().add(new JLabel("Dépôt Garantie:"));
        getContentPane().add(champDepotGarantie);
        getContentPane().add(new JLabel("Date Révision:"));
        getContentPane().add(champDateRevision);
        getContentPane().add(new JLabel("Périodicité Paiement:"));
        getContentPane().add(champPeriodicitePaiement);
        getContentPane().add(new JLabel("Date Fin Contrat (YYYY-MM-DD):"));
        getContentPane().add(champDateFinContrat);
        getContentPane().add(new JLabel("Charges Provisionnelles:"));
        getContentPane().add(champChargesProvisionnelles);
        getContentPane().add(new JLabel("ID ICC:"));
        getContentPane().add(champIdICC);
        getContentPane().add(new JLabel("Valeur ICC:"));
        getContentPane().add(champValeurICC);
        getContentPane().add(new JLabel("ID Bien Imm:"));
        getContentPane().add(champIdBienImm);
        getContentPane().add(new JLabel("Date Entrée (YYYY-MM-DD):"));
        getContentPane().add(champDateEntree);
        getContentPane().add(new JLabel("Date Sortie (YYYY-MM-DD):"));
        getContentPane().add(champDateSortie);
        getContentPane().add(new JLabel("Caution:"));
        getContentPane().add(champCaution);
        getContentPane().add(new JLabel("Nom:"));
        getContentPane().add(champNom);
        getContentPane().add(new JLabel("Prénom:"));
        getContentPane().add(champPrenom);
        
                // Ajout des champs optionnels
                optionnelCheckbox = new JCheckBox("Partie Optionnelle");
                optionnelCheckbox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        activerChampsOptionnels(optionnelCheckbox.isSelected());
                    }
                });
                getContentPane().add(optionnelCheckbox);
        
                // Ajout des composants à la fenêtre
                JLabel label_1 = new JLabel("Date Début Contrat (YYYY-MM-DD):");
                getContentPane().add(label_1);
        getContentPane().add(new JLabel("Numéro de Téléphone:"));
        getContentPane().add(champNumeroTelephone);
        getContentPane().add(fermerButton);

        // Activer/Désactiver les champs optionnels initialement
        activerChampsOptionnels(false);
    }

    private void activerChampsOptionnels(boolean activer) {
        champNom.setEnabled(activer);
        champPrenom.setEnabled(activer);
        champNumeroTelephone.setEnabled(activer);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Test FenetreContratLocation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FenetreContratLocation fenetreContratLocation = new FenetreContratLocation("John Doe", "Appartement A");
        frame.getContentPane().add(fenetreContratLocation);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
