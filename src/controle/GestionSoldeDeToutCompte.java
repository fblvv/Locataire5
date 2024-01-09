package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreSoldeToutCompte;

public class GestionSoldeDeToutCompte implements ActionListener{

	private FenetreSoldeToutCompte fenetreSolde;
	
	public GestionSoldeDeToutCompte(FenetreSoldeToutCompte fenetreSolde) {
	this.fenetreSolde=fenetreSolde;
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
	    Object source = e.getSource();
	                
	    if (source instanceof JButton) {
	        JButton button = (JButton) source;
	        
	        switch (button.getText()) {
	            case "Annuler":
	                fenetreSolde.dispose();
	                break;
	                
	            case "Générer le reçu":
	                fenetreSolde.dispose();
	                break;
	        }
	    }
	}

	}

