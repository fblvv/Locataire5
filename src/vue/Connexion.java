package vue;
import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controle.GestionConnexion;
import controle.GestionAccueil;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Connexion extends JInternalFrame  {
    private GestionConnexion gestionConnexion;
	private GestionConnexion gestionClic;
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
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
	 * Create the frame.
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
		
		JButton btnNewButton = new JButton("Connecter");
		btnNewButton.addActionListener(this.gestionClic);
		btnNewButton.setBounds(67, 240, 97, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(this.gestionClic);
		btnNewButton_1.setBounds(256, 240, 97, 21);
		getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 151, 195, 19);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Login :");
		lblNewLabel.setBounds(67, 89, 60, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setBounds(70, 154, 82, 19);
		getContentPane().add(lblNewLabel_1);

	}
	public void actionPerformed(ActionEvent e) {
		gestionConnexion.actionPerformed(e);
	
	}
	public String getValeurChLogin() {
		return this.textField.getText();
	}
	public String getValeurPasswordField() {
		return new String(this.passwordField.getPassword());
	}
}
