import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;

public class bienImmo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JTextField textField;
    private JLabel lblNewLabel_1;
    private JTextField textField_1;
    private JLabel lblNewLabel_2;
    private JTextField textField_2;
    private JPanel panel_Gauche;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_3;
    private JTextField textField_3;
    private JPanel panel_Droite;
    private JTextPane textPaneMaps;
    private JLabel lblNewLabel_4;
    private JTable tableLogements;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bienImmo frame = new bienImmo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public bienImmo() {
        this.setSize(2400, 1350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1080, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new GridLayout(4, 2, 0, 0));

        lblNewLabel = new JLabel("Adresse");
        panel.add(lblNewLabel);

        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);

        lblNewLabel_1 = new JLabel("Code Postal");
        panel.add(lblNewLabel_1);

        textField_1 = new JTextField();
        panel.add(textField_1);
        textField_1.setColumns(10);

        lblNewLabel_2 = new JLabel("Batiment");
        panel.add(lblNewLabel_2);

        textField_2 = new JTextField();
        panel.add(textField_2);
        textField_2.setColumns(10);

        lblNewLabel_3 = new JLabel("Étage");
        panel.add(lblNewLabel_3);

        textField_3 = new JTextField();
        panel.add(textField_3);
        textField_3.setColumns(10);

        panel_Gauche = new JPanel();
        contentPane.add(panel_Gauche, BorderLayout.SOUTH);

        btnNewButton = new JButton("Précédent");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
        panel_Gauche.add(btnNewButton);

        btnNewButton_1 = new JButton("Suivant");
        btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_Gauche.add(btnNewButton_1);

        panel_Droite = new JPanel();
        contentPane.add(panel_Droite, BorderLayout.EAST);
        panel_Droite.setLayout(new GridLayout(3, 0, 0, 0));

        textPaneMaps = new JTextPane();
        panel_Droite.add(textPaneMaps);

        lblNewLabel_4 = new JLabel("Historique Locataire");
        panel_Droite.add(lblNewLabel_4);

        tableLogements = new JTable();
        panel_Droite.add(new JScrollPane(tableLogements)); // Utilisation d'un JScrollPane pour permettre le défilement
        tableLogements.setEnabled(false);
        tableLogements.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableLogements.setBackground(Color.WHITE);
        tableLogements.setModel(new DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                },
                new String[] {
                        "Nom", "Prenom", "Date_entrée", "Date_sortie"
                }
        ));
    }
}
