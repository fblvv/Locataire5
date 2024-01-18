package vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularisationCharges extends JInternalFrame {

    private static final long serialVersionUID = 6013966151528868138L;
    private JTextField champProvisions;
    private JTextField champChargesReelles;
    private JButton boutonCalculer;
    private JTextArea zoneResultat;

    public RegularisationCharges() {
        super("Fenêtre de régularisation des charges", true, true, true, true);
        initialiserComposants();
    }

    private void initialiserComposants() {
        JPanel panel = new JPanel();
        getContentPane().add(panel, "Center");
        panel.setLayout(null);

        // Libellé pour le montant des provisions pour charges
        JLabel lblProvisions = new JLabel("Montant des provisions pour charges :");
        lblProvisions.setBounds(10, 11, 250, 20);
        panel.add(lblProvisions);

        // Champ de saisie pour le montant des provisions
        champProvisions = new JTextField();
        champProvisions.setBounds(270, 11, 150, 20);
        panel.add(champProvisions);
        champProvisions.setColumns(10);

        // Libellé pour le montant réel des charges
        JLabel lblChargesReelles = new JLabel("Montant réel des charges :");
        lblChargesReelles.setBounds(10, 42, 200, 20);
        panel.add(lblChargesReelles);

        // Champ de saisie pour le montant réel des charges
        champChargesReelles = new JTextField();
        champChargesReelles.setBounds(270, 42, 150, 20);
        panel.add(champChargesReelles);
        champChargesReelles.setColumns(10);

        // Bouton pour calculer la régularisation
        boutonCalculer = new JButton("Calculer");
        boutonCalculer.setBounds(10, 73, 150, 23);
        panel.add(boutonCalculer);

        // Zone de résultat (affiche le résultat de la régularisation)
        zoneResultat = new JTextArea();
        zoneResultat.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zoneResultat);
        scrollPane.setBounds(10, 107, 410, 150);
        panel.add(scrollPane);

        // Ajout d'un ActionListener au bouton de calcul
        boutonCalculer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculerRegularisation();
            }
        });
    }

    private void calculerRegularisation() {
        try {
            // Récupération des montants saisis dans les champs de texte
            double provisions = Double.parseDouble(champProvisions.getText());
            double chargesReelles = Double.parseDouble(champChargesReelles.getText());

            // Calcul de la différence entre les provisions et les charges réelles
            double difference = chargesReelles - provisions;

            // Affichage du résultat de la régularisation en fonction de la différence
            if (difference > 0) {
                zoneResultat.setText("Le locataire doit rembourser : " + difference + " euros.");
            } else if (difference < 0) {
                zoneResultat.setText("Le locataire a droit à un complément de : " + (-difference) + " euros.");
            } else {
                zoneResultat.setText("Pas de régularisation nécessaire.");
            }

        } catch (NumberFormatException ex) {
            // En cas d'erreur de saisie, affichage d'un message d'erreur
            zoneResultat.setText("Veuillez saisir des valeurs valides pour les montants.");
        }
    }
}
