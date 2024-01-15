import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modele.dao.DaoCharges;


import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class GenererRecuSoldeDeToutCompte {

    private DaoCharges dCharges;

    public GenererRecuSoldeDeToutCompte() {
    	dCharges = new DaoCharges();
    }

    public void genererPdf(String idBien) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Recu_" + idBien + ".pdf"));
            document.open();

            // En-tête
            Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Paragraph header = new Paragraph("M. Paul DUPONT\n18 rue des Lilas\n31000 TOULOUSE\nTél : 05 xx xx xx xx\n\n", headerFont);
            document.add(header);

            // Objet
            Font subjectFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Paragraph subject = new Paragraph("Objet : Solde de tout compte\n\n", subjectFont);
            subject.setAlignment(Element.ALIGN_CENTER);
            document.add(subject);

            // Information destinataire
            Paragraph recipient = new Paragraph("à\nMme DURANT Fleur\n40 rue des Alpes\n31120 PORTET SUR GARONNE\n\n", headerFont);
            document.add(recipient);

            // Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            Paragraph date = new Paragraph("Toulouse le " + sdf.format(new Date()) + "\n\n", headerFont);
            document.add(date);

            // Salutation
            Paragraph salutation = new Paragraph("Madame,\n\n", headerFont);
            document.add(salutation);

            // Introduction au détail des charges
            Font contentFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Paragraph intro = new Paragraph("Je vous prie de bien vouloir trouver ci-dessous le détail du solde de tout compte. Les charges énumérées ci-dessous porte sur la période allant du [date début] au [date fin].\n", contentFont);
            		document.add(intro);

            		// Détail des charges
            		// Ajoutez ici le détail des charges comme l'eau, les ordures ménagères, etc., avec les dates et calculs spécifiques

            		// Sous-total
            		Paragraph sousTotal = new Paragraph("Soit un sous-total de [Montant Sous-total] Euros\n\n", contentFont);
            		document.add(sousTotal);

            		// Déductions
            		Paragraph deductions = new Paragraph("A déduire\nles provisions pour charges [période] : [Montant Déductions]\n\n", contentFont);
            		document.add(deductions);
            		
            		DaoCharges daoCharges = new DaoCharges();
            		Collection<Charges> charges = daoCharges.findAll();
            		Collection<Charges> chargesEau = new LinkedList<>();
            		Collection<Charges> chargesOrdure = new LinkedList<>();
            		Collection<Charges> chargesEntretien = new LinkedList<>();
            		Collection<Charges> chargesEclairage = new LinkedList<>();
            		
            		for (Charges charge : charges) {
            			if( charge.getIdBienImm().equals(idBien)) {
            				if(charge.getTypeCharge().equals("Eau")) {
            				chargesEau.add(charge);
            			}else if (charge.getTypeCharge().equals("Ordures ménagères")) {
            				chargesOrdure.add(charge);
            			}else if (charge.getTypeCharge().equals("Entretien parties communes")) {
            				chargesEntretien.add(charge);
            			}else if (charge.getTypeCharge().equals("Eclairage parties communes")) {
            				chargesEclairage.add(charge);
            			}
            				
            		}
            		// Déductions
            		Paragraph eau = new Paragraph("Eau : 	", contentFont);
            		document.add(deductions);
            		
            		// Déductions
            		Paragraph ordureMenagere = new Paragraph("A déduire\nles provisions pour charges [période] : [Montant Déductions]\n\n", contentFont);
            		document.add(deductions);
            		
            		// Déductions
            		Paragraph entretien = new Paragraph("A déduire\nles provisions pour charges [période] : [Montant Déductions]\n\n", contentFont);
            		document.add(deductions);
            		
            		// Déductions
            		Paragraph eclairage = new Paragraph("A déduire\nles provisions pour charges [période] : [Montant Déductions]\n\n", contentFont);
            		document.add(deductions);

            		// Total et méthode de paiement
            		Paragraph total = new Paragraph("Nous restons vous devoir : [Montant Total] Euros.\nSolde de tout compte remis ce jour à l’intéressée par [méthode de paiement].\n\n", contentFont);
            		document.add(total);

            		// Clôture
            		Paragraph closing = new Paragraph("Je vous prie de croire, Madame, à ma considération distinguée.\n", contentFont);
            		document.add(closing);

            		document.close();
            		} catch (DocumentException | IOException e) {
            		    e.printStackTrace();
            		} catch (SQLException e) {
            		    e.printStackTrace();
            		}
            		}

            		public static void main(String[] args) {
            		    GenererRecuSoldeDeToutCompte genererRecu = new GenererRecuSoldeDeToutCompte();
            		    genererRecu.genererPdf("123"); // Remplacez "123" par l'ID du locataire
            		}
            		}
