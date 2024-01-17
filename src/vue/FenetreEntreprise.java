package vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class FenetreEntreprise extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreEntreprise frame = new FenetreEntreprise();
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
	public FenetreEntreprise() {
		setBounds(100, 100, 450, 300);

	}

}
