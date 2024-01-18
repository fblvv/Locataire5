package vue;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.GestionSoldeToutCompte;
import modele.Locataire;
import modele.dao.DaoLocataire;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Collection;
import javax.swing.JTextField;

public class FenetreSoldeToutCompte extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JScrollPane scrollPane = new JScrollPane();
    private final JScrollPane scrollPaneSolde = new JScrollPane();
    private JTable tableauCharges;
    private GestionSoldeToutCompte gestionClic;
    private JComboBox<String> selecteurIdLocataire;
    private JTextField textSolde;
    private JTextField textRegularisation;
    private JTextField textFieldBien;
    private JButton btnGenererRecu;
    private JTable tabSoldeTable;

    public FenetreSoldeToutCompte() {
        this.gestionClic = new GestionSoldeToutCompte(this);
        setClosable(true);
        setBorder(null);
        setBackground(new Color(240, 240, 240));
        setTitle("Solde de tout compte");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 542, 399);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setLayout(null);

        setContentPane(contentPane);

        scrollPane.setBounds(291, 172, 203, 107);
        contentPane.add(scrollPane);

        tableauCharges = new JTable();
        tableauCharges.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, }, new String[] { "Date", "Libelles", "TVA", "Montant" }));
        tableauCharges.getColumnModel().getColumn(1).setPreferredWidth(206);
        tableauCharges.getColumnModel().getColumn(2).setPreferredWidth(66);
        tableauCharges.getColumnModel().getColumn(3).setPreferredWidth(102);
        scrollPane.setViewportView(tableauCharges);
        
        
        scrollPaneSolde.setBounds(20, 172, 206, 107);
        contentPane.add(scrollPaneSolde);
        
        tabSoldeTable = new JTable();
        tabSoldeTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, }, new String[] { "Date", "Libelles", "TVA", "Montant" }));
        tabSoldeTable.getColumnModel().getColumn(1).setPreferredWidth(206);
        tabSoldeTable.getColumnModel().getColumn(2).setPreferredWidth(66);
        tabSoldeTable.getColumnModel().getColumn(3).setPreferredWidth(102);
        scrollPaneSolde.setViewportView(tabSoldeTable);
        
        selecteurIdLocataire = new JComboBox<>();
        //calculerSolde();
        // Remplir la JComboBox avec les ID des locataires
        remplirSelecteurIdLocataire();
        selecteurIdLocataire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	gestionClic.afficherInfoLocataire();
                } catch (SQLException ex) {
                    ex.printStackTrace();
      
                }
            }
        });


        selecteurIdLocataire.setBackground(Color.WHITE);
        selecteurIdLocataire.setBounds(20, 72, 156, 22);
        contentPane.add(selecteurIdLocataire);

        btnGenererRecu = new JButton("Générer le reçu");
        btnGenererRecu.addActionListener(this.gestionClic);
        btnGenererRecu.setBackground(Color.WHITE);
        btnGenererRecu.setBounds(47, 312, 131, 22);
        contentPane.add(btnGenererRecu);

        JButton btnAnnulerRecu = new JButton("Annuler");
        btnAnnulerRecu.addActionListener(this.gestionClic);
        btnAnnulerRecu.setBackground(Color.WHITE);
        btnAnnulerRecu.setBounds(192, 312, 115, 22);
        contentPane.add(btnAnnulerRecu);

        JLabel lblNewLabel = new JLabel("Solde de tout compte d'un locataire");
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 11, 516, 32);
        contentPane.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 0, 128));
        separator.setBounds(163, 41, 209, 2);
        contentPane.add(separator);

        JLabel lblLocataire = new JLabel("Locataire");
        lblLocataire.setBounds(20, 53, 55, 13);
        contentPane.add(lblLocataire);
        
        textSolde = new JTextField();
        textSolde.addActionListener(gestionClic);
        textSolde.setBounds(142, 124, 81, 19);
        contentPane.add(textSolde);
        textSolde.setColumns(10);
        
        JLabel lblSoldeDeToutCompte = new JLabel("Solde de tout compte");
        lblSoldeDeToutCompte.setBounds(20, 127, 131, 13);
        contentPane.add(lblSoldeDeToutCompte);
        
        textRegularisation = new JTextField();
        textRegularisation.setBounds(401, 124, 96, 19);
        contentPane.add(textRegularisation);
        textRegularisation.setColumns(10);
        
        JLabel lblRégularisationDesCharges = new JLabel("Régularisation Des Charges");
        lblRégularisationDesCharges.setBounds(262, 127, 156, 13);
        contentPane.add(lblRégularisationDesCharges);
        
        JLabel lblNewLabel_3 = new JLabel("Coût Actuellement");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_3.setBounds(20, 104, 121, 13);
        contentPane.add(lblNewLabel_3);   
        
        textFieldBien = new JTextField();
        
        textFieldBien.setBounds(401, 74, 96, 19);
        contentPane.add(textFieldBien);
        textFieldBien.setColumns(10);
        
        JLabel lblBien = new JLabel("Bien associé");
        lblBien.setBounds(291, 77, 100, 13);
        contentPane.add(lblBien);
        
        JButton btnChangerCharges = new JButton("Mettre a jour les charges");
        btnChangerCharges.addActionListener(this.gestionClic);
        btnChangerCharges.setBounds(326, 313, 156, 21);
        contentPane.add(btnChangerCharges);
        
       
        
    }
    
    private void remplirSelecteurIdLocataire() {
        try {
            DaoLocataire daoLocataire = new DaoLocataire();
            Collection<Locataire> locataires = daoLocataire.findAll();
            for (Locataire locataire : locataires) {
                selecteurIdLocataire.addItem(locataire.getId_Locataire());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSelecteurIdLocataire() {
        return (String) selecteurIdLocataire.getSelectedItem();
    }
    
    public JTextField getTextSolde() {
		return textSolde;
	}
    
    
    public JTextField getTextBien() {
		return textFieldBien;
	}
    
    
    public JTextField getTextRegularisation() {
		return textRegularisation;
	}
    
    public JTable getTable() {
		return tableauCharges;
	}
    
    public JTable getTableSolde() {
		return tabSoldeTable;
	}
    
    public JButton getBoutonGenererReçu() {
        return btnGenererRecu;
    }


    public static void main(String[] args) {
        // Creer une instance de FenetreSoldeToutCompte et l'afficher
        FenetreSoldeToutCompte fenetre = new FenetreSoldeToutCompte();
        fenetre.setVisible(true);
    }
}