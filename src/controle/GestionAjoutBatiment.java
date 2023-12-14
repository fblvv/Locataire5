package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjoutBatiment;
import vue.FenetreDetailsPropriete2;

public class GestionAjoutBatiment implements ActionListener {

    private FenetreAjoutBatiment ajoutBatiment;

    public GestionAjoutBatiment(FenetreAjoutBatiment ajoutBatiment) {
        this.ajoutBatiment = ajoutBatiment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;

            switch (button.getText()) {
                case "Autre Section":
                    // Code à exécuter pour le bouton "Autre Section"
                    break;
                case "Annuler":
                    ajoutBatiment.dispose();
                    break;
            }
        }
    }
}
