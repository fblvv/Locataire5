package modele;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modele.dao.DaoCharges;
import modele.dao.DaoLoyer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class GenererRecuSoldeDeToutCompte {


    public GenererRecuSoldeDeToutCompte() {
    	
    }

    public void genererPdf(String idBien,String idLoc) {
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
            Paragraph subject = new Paragraph("Objet : Régulairsation des charges\n\n", subjectFont);
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
            Paragraph intro = new Paragraph("Je vous prie de bien vouloir trouver ci-dessous le détail de la régularisation. Les charges énumérées ci-dessous porte sur la période allant"+genererPeriode()+".\n", contentFont);
            		document.add(intro);

            		// Détail des charges
            		// Ajoutez ici le détail des charges comme l'eau, les ordures ménagères, etc., avec les dates et calculs spécifiques
            		DaoCharges daoCharges = new DaoCharges();
            		Collection<Charges> charges = daoCharges.findAll();
            		Collection<Charges> chargesEau = new LinkedList<>();
            		Collection<Charges> chargesOrdure = new LinkedList<>();
            		Collection<Charges> chargesEntretien = new LinkedList<>();
            		Collection<Charges> chargesEclairage = new LinkedList<>();

            		
            		Double sommesEau = 0.0;
            		Double sommesOrdure = 0.0;
            		Double sommesGaz = 0.0;
            		Double sommesEntretien = 0.0;
            		Double sommesEclairage = 0.0;
            		Double sommesAutres = 0.0;
            		Double sommesDegats = 0.0;
            		Double totalCharges=0.0;
            		
            		for (Charges charge : charges) {
            			if( charge.getIdBienImm().equals(idBien)) {
            				if(charge.getTypeCharge().equals("Eau")) {
            				chargesEau.add(charge);
            				sommesEau+=charge.getMontant();
            			}else if (charge.getTypeCharge().equals("Ordures menageres")) {
            				chargesOrdure.add(charge);
            				sommesOrdure+=charge.getMontant();
            			}else if (charge.getTypeCharge().equals("Entretien parties communes")) {
            				chargesEntretien.add(charge);
            				sommesEntretien+=charge.getMontant();
            			}else if (charge.getTypeCharge().equals("Eclairage parties communes")) {
            				chargesEclairage.add(charge);
            				sommesEclairage+=charge.getMontant();
            			}else if (charge.getTypeCharge().equals("Autres")) {
            				sommesAutres+=charge.getMontant();
            			}else if (charge.getTypeCharge().equals("Degats")) {
            				sommesDegats+=charge.getMontant();
            			}else if (charge.getTypeCharge().equals("Gaz")) {
            				sommesGaz+=charge.getMontant();
            			}
            			}
            		}
            		
            		totalCharges+=sommesEau+sommesOrdure+sommesEntretien+sommesEclairage+sommesAutres+sommesDegats+sommesGaz;
            		
            			
            		
            		// Charges
            		Paragraph eau = new Paragraph("Eau :"+sommesEau + "€", contentFont);
            		document.add(eau);
            		
            		// Charges
            		Paragraph ordureMenagere = new Paragraph("Ordures ménagères : " + sommesOrdure.toString() + "€", contentFont);
            		document.add(ordureMenagere);
            		
            		// Charges
            		Paragraph gaz = new Paragraph("Gaz : " + sommesGaz.toString() + "€", contentFont);
            		document.add(gaz);
            		
            		// Charges
            		Paragraph entretien = new Paragraph("Entretien : " + sommesEntretien.toString() + "€", contentFont);
            		document.add(entretien);
            		
            		// Charges
            		Paragraph eclairage = new Paragraph("Eclairage : " + sommesEclairage.toString() + "€", contentFont);
            		document.add(eclairage);
            		
            		Paragraph autres = new Paragraph("Autres : " + sommesAutres.toString() + "€", contentFont);
            		document.add(autres);
            		
            		Paragraph degats = new Paragraph("Degats : " + sommesDegats.toString() + "€", contentFont);
            		document.add(degats);

            		// Sous-total
            		Paragraph sousTotal = new Paragraph("Soit un sous-total de" +totalCharges.toString()+" € \n\n", contentFont);
            		document.add(sousTotal);

            		
            		//calcul loyers sur la période
            		DaoLoyer daoLoyer = new DaoLoyer();
            		Collection<Loyer> loyers = daoLoyer.findByIds(idLoc);
            		Double sommeLoyers = 0.0;
            		Integer mois=0;
            		Double provisions =0.0;

                    // Obtenez l'année actuelle
                    int anneeActuelle = LocalDate.now().getYear();

                    // Parcourez la liste des loyers
                    for (Loyer loyer : loyers) {
                        // Obtenez l'année du paiement
                        int anneePaiement = AnneeDate(loyer.getDatePaiement());

                        // Vérifiez si l'année de paiement est la même que l'année actuelle
                        if (anneePaiement == anneeActuelle) {
                            // Ajoutez le loyer à la somme
                            sommeLoyers += loyer.getCharges();
                            provisions = loyer.getCharges();
                            mois++;
                        }
                    }

                    
                
            		// Déductions
            		Paragraph deductions = new Paragraph("A déduire\nles provisions pour charges"+genererPeriode()+" :"+provisions.toString()+"*"+mois+"="+sommeLoyers.toString()+"€\n\n", contentFont);
            		document.add(deductions);
            		
            		

            		// Total et méthode de paiement
            		Paragraph total = new Paragraph("Nous restons vous devoir :"+totalCharges.toString()+"Euros.\nSolde de tout compte remis ce jour à l’intéressée par [méthode de paiement].\n\n", contentFont);
            		document.add(total);

            		// Clôture
            		Paragraph closing = new Paragraph("Je vous prie de croire, Madame, à ma considération distinguée.\n", contentFont);
            		document.add(closing);

            		document.close();
        }catch (DocumentException | IOException | SQLException e) {
            	            e.printStackTrace();
            			}
            	    }

            		

            		public static void main(String[] args) {
            		    GenererRecuSoldeDeToutCompte genererRecu = new GenererRecuSoldeDeToutCompte();
            		    genererRecu.genererPdf("123","id"); // Remplacez "123" par l'ID du locataire
            		}
            		
            		
            		private int AnneeDate(String dateString) {
            		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            		    LocalDate date = LocalDate.parse(dateString, formatter);
            		    return date.getYear();
            		}
            		
            		
            		private static String genererPeriode() {
            			LocalDate currentDate = LocalDate.now();
            	        int currentYear = currentDate.getYear();

            	        LocalDate startDate = LocalDate.of(currentYear, 1, 1);

            	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            	        String formattedStartDate = startDate.format(formatter);
            	        String formattedEndDate = currentDate.format(formatter);

            	        return "du " + formattedStartDate + " à " + formattedEndDate;
            	    }
            		
            		
            		

            	}
            		
