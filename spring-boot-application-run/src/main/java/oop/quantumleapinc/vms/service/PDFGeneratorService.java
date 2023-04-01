package oop.quantumleapinc.vms.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class PDFGeneratorService {
    public void export(HttpServletResponse response) throws IOException {

        String html = "<h1>HTML to PDF</h1><p>This is an example of HTML to PDF conversion using iText.</p>";
        Document document = new Document(PageSize.A4);
        OutputStream out = response.getOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("This is a title.", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("testing pdf", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph2);


        
        document.close();
        out.flush();
    }
}