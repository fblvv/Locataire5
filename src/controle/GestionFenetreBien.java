package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

public class GestionFenetreBien implements ActionListener {

    private JInternalFrame fenetreBien;

    public GestionFenetreBien(JInternalFrame fenetreBien) {
        this.fenetreBien = fenetreBien;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton buttonValider = (JButton) source;

            switch (buttonValider.getText()) {
                case "Valider":
                    // Ajoutez ici le code à exécuter lorsque le bouton "Valider" est cliqué
                    break;
                case "Annuler":
                    fenetreBien.dispose();
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
