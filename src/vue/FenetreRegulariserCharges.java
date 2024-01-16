package vue;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import controle.GestionRegulariserCharges;
import modele.Locataire;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreRegulariserCharges extends JInternalFrame {
    private JTextField champAncienLoyer;
    private JTextField champAnciennesCharges;
    private JTextField champNouveauLoyer;
    private JTextField champNouvellesCharges;
    private GestionRegulariserCharges gestionClic;

    public FenetreRegulariserCharges() {
        setBounds(0, 0, 500, 350);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panelNord = new JPanel();
        getContentPane().add(panelNord, BorderLayout.NORTH);

        JLabel lblRegulariserCharges = new JLabel("Regulariser les charges");
        lblRegulariserCharges.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panelNord.add(lblRegulariserCharges);

        JPanel panelCentre = new JPanel();
        getContentPane().add(panelCentre, BorderLayout.CENTER);
        panelCentre.setLayout(new GridLayout(0, 3, 0, 0));

        JPanel panelCentreGauche = new JPanel();
        panelCentre.add(panelCentreGauche);
        panelCentreGauche.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblAncienLoyer = new JLabel("Ancien Loyer");
        panelCentreGauche.add(lblAncienLoyer);

        champAncienLoyer = new JTextField();
        panelCentreGauche.add(champAncienLoyer);
        champAncienLoyer.addActionListener(gestionClic);
        champAncienLoyer.setColumns(10);

        JLabel lblAncienncesCharges = new JLabel("Anciennes Charges");
        panelCentreGauche.add(lblAncienncesCharges);

        champAnciennesCharges = new JTextField();
        champAnciennesCharges.addActionListener(gestionClic);
        panelCentreGauche.add(champAnciennesCharges);
        champAnciennesCharges.setColumns(10);

        JPanel panelCentre2 = new JPanel();
        panelCentre.add(panelCentre2);

        JPanel panelCentreDroite = new JPanel();
        panelCentre.add(panelCentreDroite);

        JLabel lblNouveauLoyer = new JLabel("Nouveau Loyer");
        panelCentreDroite.add(lblNouveauLoyer);

        champNouveauLoyer = new JTextField();
        champNouveauLoyer.setColumns(10);
        panelCentreDroite.add(champNouveauLoyer);

        JLabel lblNouvellesCharges = new JLabel("Nouvelles Charges");
        panelCentreDroite.add(lblNouvellesCharges);

        champNouvellesCharges = new JTextField();
        champNouvellesCharges.setColumns(10);
        panelCentreDroite.add(champNouvellesCharges);

        JPanel panelSud = new JPanel();
        getContentPane().add(panelSud, BorderLayout.SOUTH);

        // Créez l'instance de GestionRegulariserCharges avant d'ajouter les ActionListener
        gestionClic = new GestionRegulariserCharges(this);

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(gestionClic);
        panelSud.add(btnAnnuler);

        JButton btnValider = new JButton("Valider");
        btnValider.addActionListener(gestionClic);
        panelSud.add(btnValider);
    }

	public JTextField getChampAncienLoyer() {
		return champAncienLoyer;
	}

	public void setChampAncienLoyer(JTextField champAncienLoyer) {
		this.champAncienLoyer = champAncienLoyer;
	}

	public JTextField getChampAnciennesCharges() {
		return champAnciennesCharges;
	}

	public void setChampAnciennesCharges(JTextField champAnciennesCharges) {
		this.champAnciennesCharges = champAnciennesCharges;
	}

	public JTextField getChampNouveauLoyer() {
		return champNouveauLoyer;
	}

	public void setChampNouveauLoyer(JTextField champNouveauLoyer) {
		this.champNouveauLoyer = champNouveauLoyer;
	}

	public JTextField getChampNouvellesCharges() {
		return champNouvellesCharges;
	}

	public void setChampNouvellesCharges(JTextField champNouvellesCharges) {
		this.champNouvellesCharges = champNouvellesCharges;
	}

	public GestionRegulariserCharges getGestionClic() {
		return gestionClic;
	}

	public void setGestionClic(GestionRegulariserCharges gestionClic) {
		this.gestionClic = gestionClic;
	}
    
    

}
