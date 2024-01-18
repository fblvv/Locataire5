package vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controle.GestionVoirContratLocation;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class VoirContratLocation extends JInternalFrame {
	private static final long serialVersionUID = -9192848899552060881L;
	/**
	 * 
	 */

	private JTable table;
	private GestionVoirContratLocation gestionClic;


	/**
	 * Lancer l'applicatio
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoirContratLocation frame = new VoirContratLocation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VoirContratLocation() {
		gestionClic = new GestionVoirContratLocation(this);
		
		setSize(1100, 700);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNord = new JPanel();
		getContentPane().add(panelNord, BorderLayout.NORTH);
		
		JLabel voirContratLocation = new JLabel("Voir Contrat Location");
		voirContratLocation.setHorizontalAlignment(SwingConstants.CENTER);
		panelNord.add(voirContratLocation);
		
		
		
		JPanel panelCentre = new JPanel();
		panelCentre.setLayout(new FlowLayout(FlowLayout.CENTER, 100, FlowLayout.CENTER));
        getContentPane().add(panelCentre, BorderLayout.CENTER);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setPreferredSize(new Dimension(1080, 600));
		panelCentre.add(scrollPaneTable);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Locataire", "Date Debut Contrat", "Montant", "Montant Loyer", "Date Versement Loyer", "Date d'Entree", "Date de Sortie", "Depot De Garantie", "Date Revision", "Periodicite Paiement", "Date Fin Contrat", "Charges Provisionnelles", "Valeur ICC", "Caution", "ID Bien Immo"
			}
		) {
			private static final long serialVersionUID = 6313996867541529343L;
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true, false, true, false, true, true, true, true, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPaneTable.setViewportView(table);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(gestionClic);
		panel.add(annuler);
		
		JButton voirFacture = new JButton("Voir cette facture");
		voirFacture.addActionListener(gestionClic);
		panel.add(voirFacture);
		
		JButton btnModifier = new JButton("Modifier");
		panel.add(btnModifier);

	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}