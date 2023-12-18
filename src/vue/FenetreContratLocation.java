package vue;

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
    private JButton ajouterLocataireButton;

    public FenetreContratLocation() {
    	setBounds(0, 0, 550, 400);

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

        // Bouton pour fermer la fenêtre
        JButton fermerButton = new JButton("Fermer");
        fermerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Ajout du bouton "Ajouter Locataire"
        ajouterLocataireButton = new JButton("Ajouter Locataire");
        ajouterLocataireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FenetreContratLocation.this, "Bouton marche, faut juste ajouter le locataire dans la base");
            }
        });

        // Utilisation d'un GridLayout avec deux colonnes
        getContentPane().setLayout(new GridLayout(0, 2, 5, 5));
        getContentPane().add(new JLabel("Date Début Contrat (YYYY-MM-DD):"));
        getContentPane().add(champDateDebutContrat);
        getContentPane().add(new JLabel("Montant Dernier Loyer:"));
        getContentPane().add(champMontantDernierLoyer);
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
        getContentPane().add(new Label("Valeur ICC:"));
        getContentPane().add(champValeurICC);
        getContentPane().add(new JLabel("ID Bien Imm:"));
        getContentPane().add(champIdBienImm);
        getContentPane().add(new JLabel("Date Entrée (YYYY-MM-DD):"));
        getContentPane().add(champDateEntree);
        getContentPane().add(new JLabel("Date Sortie (YYYY-MM-DD):"));
        getContentPane().add(champDateSortie);
        getContentPane().add(new JLabel("Caution:"));
        getContentPane().add(champCaution);
        getContentPane().add(ajouterLocataireButton);
        getContentPane().add(fermerButton);
    }
}