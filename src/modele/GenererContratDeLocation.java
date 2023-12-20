package modele;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import modele.dao.DaoLocataire;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class GenererContratDeLocation {

    private DaoLocataire daoLocataire;

    public GenererContratDeLocation() {
        daoLocataire = new DaoLocataire();
    }

    public void genererPdf(String idLocataire) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("contratLocation" + idLocataire + ".pdf"));
            document.open();

            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Font subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font smallItalic = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);

            // Entête légale
            Paragraph legalHeader = new Paragraph("Contrat de location\n" +
                    "Soumis au titre Ier de la loi du 6 juillet 1989 tendant à améliorer les rapports locatifs", smallItalic);
            legalHeader.setAlignment(Element.ALIGN_CENTER);
            document.add(legalHeader);

            // Titre du contrat
            Paragraph title = new Paragraph("LOCAUX VIDES A USAGE D'HABITATION", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Espace après le titre
            document.add(Chunk.NEWLINE);

            // Section I. Désignation des parties
            Paragraph section1 = new Paragraph("I. Désignation des parties", subTitleFont);
            document.add(section1);

            // Informations du bailleur
            document.add(new Paragraph("Le bailleur: [nom et prénom, ou dénomination du bailleur / domicile ou siège social / qualité du bailleur (personne physique, personne morale) / adresse électronique (facultatif)]", normalFont));

            // Informations du locataire
            Locataire locataire = daoLocataire.findById(idLocataire); // Simulé, remplacer par votre logique de récupération
            if (locataire != null) {
                document.add(new Paragraph(String.format("Le locataire: %s %s, Téléphone: %s, Email: %s, Adresse: %s, Code Postal: %s",
                        locataire.getNom(), locataire.getPrenom(), locataire.getTelephone(), locataire.getMail(), locataire.getAdresse(), locataire.getCode_Postal()), normalFont));
            } else {
                System.err.println("Aucun locataire trouvé avec l'ID: " + idLocataire);
                return; // Sortie anticipée si aucun locataire n'est trouvé
            }

            // Autres sections
            // ...

            // Signature
            document.add(Chunk.NEWLINE);
            document.add(new LineSeparator());
            document.add(new Paragraph("Signature du bailleur", normalFont));
            document.add(Chunk.NEWLINE);
            document.add(new LineSeparator());
            document.add(new Paragraph("Signature du locataire", normalFont));

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
