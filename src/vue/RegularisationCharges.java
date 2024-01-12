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

        JLabel lblProvisions = new JLabel("Montant des provisions pour charges :");
        lblProvisions.setBounds(10, 11, 250, 20);
        panel.add(lblProvisions);

        champProvisions = new JTextField();
        champProvisions.setBounds(270, 11, 150, 20);
        panel.add(champProvisions);
        champProvisions.setColumns(10);

        JLabel lblChargesReelles = new JLabel("Montant réel des charges :");
        lblChargesReelles.setBounds(10, 42, 200, 20);
        panel.add(lblChargesReelles);

        champChargesReelles = new JTextField();
        champChargesReelles.setBounds(270, 42, 150, 20);
        panel.add(champChargesReelles);
        champChargesReelles.setColumns(10);

        boutonCalculer = new JButton("Calculer");
        boutonCalculer.setBounds(10, 73, 150, 23);
        panel.add(boutonCalculer);

        zoneResultat = new JTextArea();
        zoneResultat.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zoneResultat);
        scrollPane.setBounds(10, 107, 410, 150);
        panel.add(scrollPane);

        boutonCalculer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculerRegularisation();
            }
        });
    }

    private void calculerRegularisation() {
        try {
            double provisions = Double.parseDouble(champProvisions.getText());
            double chargesReelles = Double.parseDouble(champChargesReelles.getText());

            double difference = chargesReelles - provisions;

            if (difference > 0) {
                zoneResultat.setText("Le locataire doit rembourser : " + difference + " euros.");
            } else if (difference < 0) {
                zoneResultat.setText("Le locataire a droit à un complément de : " + (-difference) + " euros.");
            } else {
                zoneResultat.setText("Pas de régularisation nécessaire.");
            }

        } catch (NumberFormatException ex) {
            zoneResultat.setText("Veuillez saisir des valeurs valides pour les montants.");
        }
    }
}
