import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modele.dao.DaoCharges;
import modele.Charges;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenererRecuSoldeDeToutCompte {

    public void genererPdf(String idLocataire) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Recu_" + idLocataire + ".pdf"));
            document.open();

            // En-tête
            Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Paragraph header = new Paragraph("M. Paul DUPONT\n18 rue des Lilas\n31000 TOULOUSE\nTél : 05 xx xx xx xx\n\n", headerFont);
            document.add(header);

            // Reste du code pour générer le reçu...

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GenererRecuSoldeDeToutCompte genererRecu = new GenererRecuSoldeDeToutCompte();
        genererRecu.genererPdf("123"); // Remplacez "123" par l'ID du locataire
    }
}
