package vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controle.GestionCharges;
import modele.BienImmobilier;
import modele.Charges;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoCharges;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class FenetreCharges extends JInternalFrame { 

	private static final long serialVersionUID = 4570267966938554819L;
	private JComboBox<String> typeCompteurComboBox;
    private JComboBox<String> idBienComboBox;
    private JTable chargeTable;
    private JButton imprimerButton;
    private JButton validerButton;
    private JButton annulerButton;
    private DaoCharges daoCharge;
    private JPanel panelBoutons;
    private GestionCharges gestionClic;
    private JButton ajouterButton;


    public FenetreCharges() {
        super("Charges", true, true, true, true);
        setSize(800, 600);

        this.gestionClic = new GestionCharges(this);
        this.daoCharge = new DaoCharges();
        new ArrayList<>(); 

        JPanel panel = new JPanel(new FlowLayout());
        String[] typesCompteur = {"Tout Type", "Eau", "Electricite", "Gaz"};
        typeCompteurComboBox = new JComboBox<>(typesCompteur);
        panel.add(new JLabel("Type de Charge :"));
        panel.add(typeCompteurComboBox);

        idBienComboBox = new JComboBox<>();
        panel.add(new JLabel("ID du Bien: "));
        panel.add(idBienComboBox);
        idBienComboBox.addItem("Tous");

        // Modification ici pour utiliser BorderLayout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        
        typeCompteurComboBox.addItemListener(this.gestionClic);
        idBienComboBox.addItemListener(this.gestionClic);

        chargeTable = new JTable(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID Charge", "Montant", "Date", "Type", "Pourcentage Entretien"
        	}
        ));
        JScrollPane scrollPane = new JScrollPane(chargeTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Initialisation et ajout de panelBoutons en bas
        panelBoutons = new JPanel(new FlowLayout());
        annulerButton = new JButton("Annuler");
        panelBoutons.add(annulerButton);
        imprimerButton = 	new JButton("Imprimer La Facture");
        panelBoutons.add(imprimerButton);
        
        ajouterButton = new JButton("Ajouter Charge");
        ajouterButton.setEnabled(false);
        ajouterButton.addActionListener(this.gestionClic);
        
        panelBoutons.add(ajouterButton);
        validerButton = new JButton("Valider");
        panelBoutons.add(validerButton);
        getContentPane().add(panelBoutons, BorderLayout.SOUTH);

        validerButton.addActionListener(this.gestionClic);
        imprimerButton.addActionListener(this.gestionClic);
        annulerButton.addActionListener(this.gestionClic);

        initComboBoxIdBien();

		
		  try { afficherCompteurs(); } catch (SQLException e) { e.printStackTrace(); }
		 
    }

    private void initComboBoxIdBien() {
        DaoBienImmobilier daoBienImmobilier = new DaoBienImmobilier();
        try {
            Collection<BienImmobilier> biens = daoBienImmobilier.findAll();
            for (BienImmobilier bien : biens) {
                idBienComboBox.addItem(bien.getId_Bien_Imm());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afficherCompteurs() throws SQLException {
        Collection<Charges> compteurs = daoCharge.findAll();
        DefaultTableModel tableModel = (DefaultTableModel) chargeTable.getModel();
        
        tableModel.setRowCount(0);
        for (Charges compteur : compteurs) {
            tableModel.addRow(new Object[]{compteur.getIdCharges(), compteur.getMontant(),
                    compteur.getDateCharge(), compteur.getTypeCharge(),compteur.getPourcentagePartEntretien()});
        }
    }

    public JComboBox<String> getTypeCompteurComboBox() {
        return typeCompteurComboBox;
    }

    public JComboBox<String> getIdBienComboBox() {
        return idBienComboBox;
    }

    public JTable getTable() {
        return chargeTable;
    }
    
    public JButton getAjouterButton() {
        return ajouterButton;
    }
}