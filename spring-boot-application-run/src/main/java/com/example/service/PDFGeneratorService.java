// package com.example.service;


// import com.lowagie.text.*;
// import com.lowagie.text.pdf.PdfWriter;
// import org.springframework.stereotype.Service;

// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;

// @Service
// public class PDFGeneratorService {
//     public void export(HttpServletResponse response) throws IOException {
//         Document document = new Document(PageSize.A4);
//         PdfWriter.getInstance(document, response.getOutputStream());

//         document.open();
//         Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//         fontTitle.setSize(18);

//         Paragraph paragraph = new Paragraph("This is a title.", fontTitle);
//         paragraph.setAlignment(Paragraph.ALIGN_CENTER);

//         Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
//         fontParagraph.setSize(12);

//         Paragraph paragraph2 = new Paragraph("This is a paragraph.", fontParagraph);
//         paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

//         document.add(paragraph);
//         document.add(paragraph2);
//         document.close();
//     }
// }

package com.example.service;


// import com.lowagie.text.*;
// import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;

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
