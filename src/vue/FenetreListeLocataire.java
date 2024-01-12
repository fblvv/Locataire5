package vue;

import controle.GestionListeLocataire;
import modele.Locataire;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FenetreListeLocataire extends JInternalFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Locataire> locataires;
    private GestionListeLocataire gestionClic;
    private JTable table;

    public FenetreListeLocataire() {
    	setMaximizable(true);
    	setIconifiable(true);
    	setClosable(true);
        this.gestionClic = new GestionListeLocataire(this);
        locataires = new ArrayList<>();


        setTitle("Liste des Locataires");
        setSize(600, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Création du modèle de table
        String[] columnNames = {"Nom", "Prénom", "Téléphone", "Email", "Adresse", "Code Postal"};
        Object[][] data = new Object[locataires.size()][6];

        for (int i = 0; i < locataires.size(); i++) {
            Locataire locataire = locataires.get(i);
            data[i] = new Object[]{locataire.getNom(), locataire.getPrenom(), locataire.getTelephone(),
                    locataire.getMail(), locataire.getAdresse(), locataire.getCode_Postal()};
        }

        table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Boutons d'action
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton modifierButton = new JButton("Refresh");
        modifierButton.addActionListener(this.gestionClic); 
        
        JButton supprimerButton = new JButton("Supprimer");
        supprimerButton.addActionListener(this.gestionClic);
 
        JButton genererContratButton = new JButton("Générer Contrat");
        genererContratButton.addActionListener(this.gestionClic);
        

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this.gestionClic);

        btnAnnuler.setHorizontalAlignment(SwingConstants.LEFT);
        buttonPanel.add(btnAnnuler);
        buttonPanel.add(supprimerButton);
        buttonPanel.add(genererContratButton);

        JButton voirBienButton = new JButton("Voir le bien");
        voirBienButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour voir le bien immobilier du locataire sélectionné
            }
        });
        buttonPanel.add(voirBienButton);

        buttonPanel.add(modifierButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}