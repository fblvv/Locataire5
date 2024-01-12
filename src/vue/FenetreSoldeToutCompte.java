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

import SQL.CictOracleDataSource;
import controle.GestionSoldeDeToutCompte;
import modele.Locataire;
import modele.dao.DaoLocataire;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import javax.swing.JTextField;

public class FenetreSoldeToutCompte extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JScrollPane scrollPane = new JScrollPane();
    private JTable tableauCharges;
    private GestionSoldeDeToutCompte gestionClic;
    private JComboBox<String> selecteurIdLocataire;
    private JTextField textSolde;
    private JTextField textRegularisation;

    public FenetreSoldeToutCompte() {
        this.gestionClic = new GestionSoldeDeToutCompte(this);
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

        scrollPane.setBounds(20, 177, 203, 107);
        contentPane.add(scrollPane);

        tableauCharges = new JTable();
        tableauCharges.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, }, new String[] { "Date", "Libelles", "TVA", "Montant" }));
        tableauCharges.getColumnModel().getColumn(1).setPreferredWidth(206);
        tableauCharges.getColumnModel().getColumn(2).setPreferredWidth(66);
        tableauCharges.getColumnModel().getColumn(3).setPreferredWidth(102);
        scrollPane.setViewportView(tableauCharges);
        
        selecteurIdLocataire = new JComboBox<>();
        calculerSolde();
        // Remplissez la JComboBox avec les ID des locataires ici
        remplirSelecteurIdLocataire();
        selecteurIdLocataire.addActionListener(new ActionListener() {
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

        JButton btnGenererRecu = new JButton("Générer le reçu");
        btnGenererRecu.addActionListener(this.gestionClic);
        btnGenererRecu.setBackground(Color.WHITE);
        btnGenererRecu.setBounds(115, 311, 131, 22);
        contentPane.add(btnGenererRecu);

        JButton btnAnnulerRecu = new JButton("Annuler");
        btnAnnulerRecu.addActionListener(this.gestionClic);
        btnAnnulerRecu.setBackground(Color.WHITE);
        btnAnnulerRecu.setBounds(260, 311, 115, 22);
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
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(260, 177, 203, 107);
        contentPane.add(scrollPane_1);
    }
    
    private void remplirSelecteurIdLocataire() {
        // Vous devrez peut-être récupérer les ID des locataires depuis votre source de données (base de données, fichier, etc.) 
        // et les ajouter à la JComboBox ici.
        // Par exemple, vous pouvez utiliser la méthode findAll() de votre DAO pour obtenir tous les locataires et les ajouter à la JComboBox.
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

    private void calculerSolde() {
        String idBien = getSelecteurIdLocataire();
        System.out.println("Voici l'id du bien"+idBien);
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        System.out.println("Voici la date" + date);

        try {
            // Préparez l'appel à la fonction SQL
            String sql = "{ ? = call regularisation_charge(?, ?) }";
            CallableStatement callableStatement = CictOracleDataSource.getConnectionBD().prepareCall(sql);

            // Définissez les paramètres d'entrée
            callableStatement.registerOutParameter(1, Types.NUMERIC); // Paramètre de sortie
            callableStatement.setString(2, idBien);
            callableStatement.setDate(3, date);

            // Exécutez la fonction SQL
            callableStatement.execute();

            // Récupérez le résultat
            double resultat = callableStatement.getDouble(1);

            // Mettez à jour le champ de texte textSolde avec le résultat
            textSolde.setText(Double.toString(resultat));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public String getSelecteurIdLocataire() {
        return (String) selecteurIdLocataire.getSelectedItem();
    }
    
   

    public static void main(String[] args) {
        // Create an instance of your FenetreSoldeToutCompte class and display it.
        FenetreSoldeToutCompte fenetre = new FenetreSoldeToutCompte();
        fenetre.setVisible(true);
    }
}