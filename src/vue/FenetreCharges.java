package vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class FenetreCharges extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreCharges frame = new FenetreCharges();
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
	public FenetreCharges() {
		setBounds(100, 100, 450, 300);

	}

}
