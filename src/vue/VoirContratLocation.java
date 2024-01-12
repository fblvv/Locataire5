package vue;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;

import controle.GestionVoirContratLocation;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;


public class VoirContratLocation extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private GestionVoirContratLocation gestionClic;
	private JTable table;

	public VoirContratLocation() {
		gestionClic = new GestionVoirContratLocation(this);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1207, 634);
		
		JLabel voirContratLocation = new JLabel("Voir Contrat Location");
		voirContratLocation.setHorizontalAlignment(SwingConstants.CENTER);
		voirContratLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(voirContratLocation, BorderLayout.NORTH);
		
		JList<String> list = new JList<>();
		getContentPane().add(list, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(gestionClic);
		panel.add(annuler);
		
		JButton voirFacture = new JButton("Voir cette facture");
		voirFacture.addActionListener(gestionClic);
		panel.add(voirFacture);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Locataire", "Date Debut Contrat", "Montant", "Montant Loyer", "Date Versement Loyer", "Date d'Entree", "Date de Sortie", "Depot De Garantie", "Date Revision", "Periodicite Paiement", "Date Fin Contrat", "Charges Provisionnelles", "Valeur ICC", "Caution", "ID Bien Immo"
			}
		));
		getContentPane().add(table, BorderLayout.WEST);
			
			
		}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}