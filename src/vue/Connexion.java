package vue;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import controle.GestionConnexion;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Connexion extends JInternalFrame {
    private GestionConnexion gestionConnexion; // Gestion de la connexion
    private GestionConnexion gestionClic; // Gestion des clics
    private static final long serialVersionUID = 1L;
    private JTextField textField; // Champ de saisie du login
    private JPasswordField passwordField; // Champ de saisie du mot de passe

    /**
     * Méthode principale pour lancer l'application
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Connexion frame = new Connexion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructeur de la fenêtre de connexion
     */
    public Connexion() {
        this.gestionClic = new GestionConnexion(this);
        setClosable(true);
        setTitle("Connexion");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(212, 86, 195, 19);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnConnnecter = new JButton("Connecter");
        btnConnnecter.addActionListener(this.gestionClic);
        btnConnnecter.setBounds(67, 240, 97, 21);
        getContentPane().add(btnConnnecter);
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this.gestionClic);
        btnAnnuler.setBounds(256, 240, 97, 21);
        getContentPane().add(btnAnnuler);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(212, 151, 195, 19);
        getContentPane().add(passwordField);
        
        JLabel lblLogin = new JLabel("Login :");
        lblLogin.setBounds(67, 89, 60, 22);
        getContentPane().add(lblLogin);
        
        JLabel lblMdp = new JLabel("Mot de passe :");
        lblMdp.setBounds(70, 154, 82, 19);
        getContentPane().add(lblMdp);
    }

    // Méthode pour gérer les actions des boutons
    public void actionPerformed(ActionEvent e) {
        gestionConnexion.actionPerformed(e);
    }

    // Méthode pour obtenir la valeur du champ de saisie du login
    public String getValeurChLogin() {
        return this.textField.getText();
    }

    // Méthode pour obtenir la valeur du champ de saisie du mot de passe
    public String getValeurPasswordField() {
        return new String(this.passwordField.getPassword());
    }
}
