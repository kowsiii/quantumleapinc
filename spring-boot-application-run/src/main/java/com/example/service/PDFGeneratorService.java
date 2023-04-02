package com.example.service;

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

    public void generatePDFFromHTML(HttpServletResponse response, String htmlString) throws IOException, DocumentException {
        // Create a new PDF document and writer
        Document document = new Document(PageSize.A4);
        OutputStream out = response.getOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, out);

        // Open the PDF document
        document.open();
        
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(htmlString));

        // Close the PDF document
        document.close();
        out.flush();

        System.out.println();
        System.out.println("--------------------------------finished pdf generation--------------------------------");
        System.out.println();
    }

    public void export(HttpServletResponse response, String html) {
    }
}