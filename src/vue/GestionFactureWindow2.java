package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.GestionGestionFacture;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class GestionFactureWindow2 extends JInternalFrame {
    
    private GestionGestionFacture gestionClic;
    private JPanel contentPane;
    private JTable tableEau;
    private JTable tableElectricite;
    private JTable tablePartiesCommunes;
    private JTable tableTaxesFoncieres;
    private JComboBox<String> comboBox; // Ajout de la JComboBox

    GestionGestionFacture gestionGestionFacture = new GestionGestionFacture(this);

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GestionFactureWindow2 frame = new GestionFactureWindow2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GestionFactureWindow2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 802, 526);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 350, 30, 350 };
        gbl_contentPane.rowHeights = new int[] { 0, 300, 30 };
        gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0 };
        gbl_contentPane.rowWeights = new double[] { 0.0, 1.0 };
        contentPane.setLayout(gbl_contentPane);

        // Ajout de la JComboBox à la barre supérieure
        String[] options = { "Logement 1", "Logement 2", "Logement 3" }; // Remplacez par vos options
        comboBox = new JComboBox<>(options);
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.anchor = GridBagConstraints.EAST;
        gbc_comboBox.gridx = 2; // Position en colonne
        gbc_comboBox.gridy = 0; // Position en ligne
        contentPane.add(comboBox, gbc_comboBox);

        JLabel labelTitre = new JLabel("Gestion des Factures");
        labelTitre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GridBagConstraints gbc_labelTitre = new GridBagConstraints();
        gbc_labelTitre.gridwidth = 3;
        gbc_labelTitre.insets = new Insets(0, 0, 5, 0);
        gbc_labelTitre.gridx = 0;
        gbc_labelTitre.gridy = 0;
        contentPane.add(labelTitre, gbc_labelTitre);
		
		JPanel panelGauche = new JPanel();
		GridBagConstraints gbc_panelGauche = new GridBagConstraints();
		gbc_panelGauche.insets = new Insets(0, 0, 5, 5);
		gbc_panelGauche.fill = GridBagConstraints.BOTH;
		gbc_panelGauche.gridx = 0;
		gbc_panelGauche.gridy = 1;
		contentPane.add(panelGauche, gbc_panelGauche);
		GridBagLayout gbl_panelGauche = new GridBagLayout();
		gbl_panelGauche.columnWidths = new int[]{0, 0};
		gbl_panelGauche.rowHeights = new int[] {30, 30, 30, 30};
		gbl_panelGauche.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelGauche.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		panelGauche.setLayout(gbl_panelGauche);
		
		JLabel labelEau = new JLabel("Gestion de l'eau");
		labelEau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_labelEau = new GridBagConstraints();
		gbc_labelEau.anchor = GridBagConstraints.WEST;
		gbc_labelEau.insets = new Insets(0, 0, 5, 0);
		gbc_labelEau.gridx = 0;
		gbc_labelEau.gridy = 0;
		panelGauche.add(labelEau, gbc_labelEau);
		
		JScrollPane scrollPaneEau = new JScrollPane();
		GridBagConstraints gbc_scrollPaneEau = new GridBagConstraints();
		gbc_scrollPaneEau.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneEau.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneEau.gridx = 0;
		gbc_scrollPaneEau.gridy = 1;
		panelGauche.add(scrollPaneEau, gbc_scrollPaneEau);
		
		tableEau = new JTable();
		tableEau.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Mois", "Consommation", "Facture"
			}
		));
		scrollPaneEau.setViewportView(tableEau);
		
		JLabel labelElectricite = new JLabel("Gestion Electricité");
		labelElectricite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_labelElectricite = new GridBagConstraints();
		gbc_labelElectricite.insets = new Insets(0, 0, 5, 0);
		gbc_labelElectricite.anchor = GridBagConstraints.WEST;
		gbc_labelElectricite.gridx = 0;
		gbc_labelElectricite.gridy = 2;
		panelGauche.add(labelElectricite, gbc_labelElectricite);
		
		JScrollPane scrollPaneElectricite = new JScrollPane();
		GridBagConstraints gbc_scrollPaneElectricite = new GridBagConstraints();
		gbc_scrollPaneElectricite.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneElectricite.gridx = 0;
		gbc_scrollPaneElectricite.gridy = 3;
		panelGauche.add(scrollPaneElectricite, gbc_scrollPaneElectricite);
		
		tableElectricite = new JTable();
		tableElectricite.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Mois", "Coût total"
			}
		));
		scrollPaneElectricite.setViewportView(tableElectricite);
		
		JPanel panelMilieu = new JPanel();
		GridBagConstraints gbc_panelMilieu = new GridBagConstraints();
		gbc_panelMilieu.insets = new Insets(0, 0, 5, 5);
		gbc_panelMilieu.fill = GridBagConstraints.BOTH;
		gbc_panelMilieu.gridx = 1;
		gbc_panelMilieu.gridy = 1;
		contentPane.add(panelMilieu, gbc_panelMilieu);
		
		JPanel panelDroite = new JPanel();
		GridBagConstraints gbc_panelDroite = new GridBagConstraints();
		gbc_panelDroite.insets = new Insets(0, 0, 5, 0);
		gbc_panelDroite.fill = GridBagConstraints.BOTH;
		gbc_panelDroite.gridx = 2;
		gbc_panelDroite.gridy = 1;
		contentPane.add(panelDroite, gbc_panelDroite);
		GridBagLayout gbl_panelDroite = new GridBagLayout();
		gbl_panelDroite.columnWidths = new int[]{0, 0};
		gbl_panelDroite.rowHeights = new int[] {30, 30, 30, 30};
		gbl_panelDroite.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDroite.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		panelDroite.setLayout(gbl_panelDroite);
		
		JLabel labelPartiesCommunes = new JLabel("Gestion parties communes ");
		labelPartiesCommunes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_labelPartiesCommunes = new GridBagConstraints();
		gbc_labelPartiesCommunes.insets = new Insets(0, 0, 5, 0);
		gbc_labelPartiesCommunes.anchor = GridBagConstraints.WEST;
		gbc_labelPartiesCommunes.gridx = 0;
		gbc_labelPartiesCommunes.gridy = 0;
		panelDroite.add(labelPartiesCommunes, gbc_labelPartiesCommunes);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panelDroite.add(scrollPane, gbc_scrollPane);
		
		tablePartiesCommunes = new JTable();
		tablePartiesCommunes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Description", "Coût", "Répartition"
			}
		));
		scrollPane.setViewportView(tablePartiesCommunes);
		
		JLabel labelPartiesCommunes_1 = new JLabel("Gestion parties communes ");
		labelPartiesCommunes_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_labelPartiesCommunes_1 = new GridBagConstraints();
		gbc_labelPartiesCommunes_1.anchor = GridBagConstraints.WEST;
		gbc_labelPartiesCommunes_1.insets = new Insets(0, 0, 5, 0);
		gbc_labelPartiesCommunes_1.gridx = 0;
		gbc_labelPartiesCommunes_1.gridy = 2;
		panelDroite.add(labelPartiesCommunes_1, gbc_labelPartiesCommunes_1);
		
		JScrollPane scrollPaneTaxesFoncieres = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTaxesFoncieres = new GridBagConstraints();
		gbc_scrollPaneTaxesFoncieres.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTaxesFoncieres.gridx = 0;
		gbc_scrollPaneTaxesFoncieres.gridy = 3;
		panelDroite.add(scrollPaneTaxesFoncieres, gbc_scrollPaneTaxesFoncieres);
		
		tableTaxesFoncieres = new JTable();
		tableTaxesFoncieres.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Logement/Bâtiment", "Montant Total", "Montant Sans Ordures Ménagères"
			}
		));
		scrollPaneTaxesFoncieres.setViewportView(tableTaxesFoncieres);
		
	    JButton btnAnnuler = new JButton("Annuler");
	    GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
	    gbc_btnAnnuler.fill = GridBagConstraints.HORIZONTAL;
	    gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
	    gbc_btnAnnuler.gridx = 0;
	    gbc_btnAnnuler.gridy = 2;
	    contentPane.add(btnAnnuler, gbc_btnAnnuler);
	    
	    
	    btnAnnuler.addActionListener(gestionGestionFacture);

		
		JButton btnImprimer = new JButton("Imprimer Facture");
		GridBagConstraints gbc_btnImprimer = new GridBagConstraints();
		gbc_btnImprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImprimer.gridx = 2;
		gbc_btnImprimer.gridy = 2;
		contentPane.add(btnImprimer, gbc_btnImprimer);
	}

}
