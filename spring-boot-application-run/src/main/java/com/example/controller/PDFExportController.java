package com.example.controller;

import com.example.service.PDFGeneratorService;
import com.itextpdf.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PDFExportController {

      private final PDFGeneratorService pdfGeneratorService;

      @Autowired
      public PDFExportController(PDFGeneratorService pdfGeneratorService) {
            this.pdfGeneratorService = pdfGeneratorService;
      }

      @GetMapping("/pdf/generate")
      public void generatePDF(HttpServletResponse response, @RequestBody String html) throws IOException, DocumentException {
            response.setContentType("application/pdf");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());
      
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
            response.setHeader(headerKey, headerValue);
      
      
            this.pdfGeneratorService.export(response , html);   
      }
}