package oop.quantumleapinc.vms.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;


import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;


@Service
public class PDFGeneratorService {
    public void export(HttpServletResponse response, String html) throws IOException,  DocumentException {

        // String html = "<h1>HTML to PDF</h1><p>This is an example of HTML to PDF conversion using iText.</p> <ol> <li>First item</li> <li>Second item</li> <li>Third item</li> </ol> <p>Here is an image: <img src=\"https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png\" alt=\"Google logo\" /> </p> <p>Here is a link to <a href=\"https://www.google.com/\">Google</a>.</p> "  ;
        Document document = new Document(PageSize.A4);
        OutputStream out = response.getOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, out);

        document.open();

        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(html));

        document.close();
        out.flush();
    }
}