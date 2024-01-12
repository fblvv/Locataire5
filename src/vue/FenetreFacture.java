package vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controle.GestionFactures;
import modele.BienImmobilier;

import modele.Facture;
import modele.dao.DaoBienImmobilier;
import modele.dao.DaoFacture;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FenetreFacture extends JInternalFrame { 

    private static final long serialVersionUID = 4265026694822721451L;
	private JComboBox<String> typefactureComboBox;
    private JComboBox<String> idBienComboBox;
    private JTable factureTable;
    private JButton ajouterButton;
    private JButton validerButton;
    private JButton annulerButton;
    private DaoFacture daoFacture;
    private List<Facture> factures; 
    private JPanel panelBoutons;
    private GestionFactures gestionClic;


    public FenetreFacture() {
        super("Factures", true, true, true, true);
        setSize(800, 600);

        this.gestionClic = new GestionFactures(this);
        this.daoFacture = new DaoFacture();
        this.factures = new ArrayList<>(); 

        JPanel panel = new JPanel(new FlowLayout());
        String[] typesfacture = {"Tout Type", "Entretien", "Travaux"};
        typefactureComboBox = new JComboBox<>(typesfacture);
        panel.add(new JLabel("Type de Factures :"));
        panel.add(typefactureComboBox);

        idBienComboBox = new JComboBox<>();
        panel.add(new JLabel("ID du Bien: "));
        panel.add(idBienComboBox);
        idBienComboBox.addItem("Tous");

        // Modification ici pour utiliser BorderLayout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);

        typefactureComboBox.addItemListener(this.gestionClic);
        idBienComboBox.addItemListener(this.gestionClic);

        String[] columnNames = {"ID Facture","Siren","Prix","Type","Date "};
        Object[][] data = new Object[factures.size()][5];
        factureTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(factureTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Initialisation et ajout de panelBoutons en bas
        panelBoutons = new JPanel(new FlowLayout());
        annulerButton = new JButton("Annuler");
        panelBoutons.add(annulerButton);
        ajouterButton = 	new JButton("Ajouter Facture");
        ajouterButton.setEnabled(false);
        panelBoutons.add(ajouterButton);
        validerButton = new JButton("Valider");
        panelBoutons.add(validerButton);
        getContentPane().add(panelBoutons, BorderLayout.SOUTH);

        validerButton.addActionListener(this.gestionClic);
        ajouterButton.addActionListener(this.gestionClic);
        annulerButton.addActionListener(this.gestionClic);

         initComboBoxIdBien();

		
		  try { afficherFactures(); } catch (SQLException e) { e.printStackTrace(); }
		 
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

    public void afficherFactures() throws SQLException {
        Collection<Facture> factures = daoFacture.findAll();
        DefaultTableModel tableModel = (DefaultTableModel) factureTable.getModel();
        
        tableModel.setRowCount(0);
        for (Facture facture : factures) {
            tableModel.addRow(new Object[]{facture.getIdFacture(), facture.getSiren(),
                    facture.getPrix(), facture.getTypeEntretien(),facture.getDateFacture()});
        }
    }

    public JComboBox<String> getTypefactureComboBox() {
        return typefactureComboBox;
    }

    public JComboBox<String> getIdBienComboBox() {
        return idBienComboBox;
    }

    public JTable getTable() {
        return factureTable;
    }
    
    public JButton getAjouterButton() {
        return ajouterButton;
    }
}