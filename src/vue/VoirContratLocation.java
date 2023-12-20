package vue;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import controle.GestionAjoutBatiment;
import controle.GestionVoirContratLocation;
import modele.ContratLocation;
import modele.Locataire;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VoirContratLocation extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ContratLocation> contratLocation;
	private GestionVoirContratLocation gestionClic;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VoirContratLocation() {
		gestionClic = new GestionVoirContratLocation(this);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel voirContratLocation = new JLabel("Voir Contrat Location");
		voirContratLocation.setHorizontalAlignment(SwingConstants.CENTER);
		voirContratLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(voirContratLocation, BorderLayout.NORTH);
		
		JList list = new JList();
		getContentPane().add(list, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(gestionClic);
		panel.add(annuler);
		
		JButton VoirFacture_1 = new JButton("voir cette facture");
		VoirFacture_1.addActionListener(gestionClic);
		panel.add(VoirFacture_1);
			
			
		};
		
		

	}
