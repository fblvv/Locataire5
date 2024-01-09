package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

public class GestionGestionFacture implements ActionListener {

    private JInternalFrame fenetreGestionFacture;

    public GestionGestionFacture(JInternalFrame fenetreGestionFacture) {
        this.fenetreGestionFacture = fenetreGestionFacture;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton buttonValider = (JButton) source;

            switch (buttonValider.getText()) {
                case "Valider":
                    break;
                case "Annuler":
                	fenetreGestionFacture.dispose();
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
