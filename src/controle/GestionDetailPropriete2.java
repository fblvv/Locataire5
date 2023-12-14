package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreDetailsPropriete2; // Ajout de l'importation

public class GestionDetailPropriete2 implements ActionListener {

    private FenetreDetailsPropriete2 detailPropriete;

    public GestionDetailPropriete2(FenetreDetailsPropriete2 detailPropriete) {
        this.detailPropriete = detailPropriete;
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
                    detailPropriete.dispose();
                    break;
            }
        }
    }
}
