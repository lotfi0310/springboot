package tn.esprit.services.classes;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import tn.esprit.persistance.Contrat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ExportContratService {

    public static ByteArrayInputStream contratsPDFReport(List<Contrat> contrats){
        Document document = new com.itextpdf.text.Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document,out);
            document.open();
            //add text to pdf file
            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER,14, BaseColor.BLACK);
            Paragraph para = new Paragraph("Contrats List",font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(1);
            //make column table
            Stream.of("montantContrat").forEach(headermontantContrat -> {
                PdfPCell header = new PdfPCell();
                com.itextpdf.text.Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(1);
                header.setPhrase(new  Phrase(headermontantContrat,headFont));
                table.addCell(header);

            });

            for(Contrat cont:contrats){
                System.out.println(cont.getMontantContrat());
                Integer testt=cont.getMontantContrat();
                PdfPCell montantCell = new PdfPCell(new Phrase(testt));
                System.out.println(montantCell);
                montantCell.setPaddingLeft(1);
                montantCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                montantCell.setVerticalAlignment(Element.ALIGN_LEFT);
                table.addCell(String.valueOf(testt));

            }

        document.add(table);
            document.close();

        }catch (DocumentException ex) {

            ex.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
