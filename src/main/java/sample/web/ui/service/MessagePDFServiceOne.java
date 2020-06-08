package sample.web.ui.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class MessagePDFServiceOne {
    public void createAnPDF(String pdfBody) throws FileNotFoundException, DocumentException {

        // boolean to manually throw an exception to demonstrate the adapter pattern (PDF fail-over function)
        boolean throwException = false;

        if(throwException) {
            FileNotFoundException fnf = new FileNotFoundException();
            throw fnf;
        }
        else {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("PDF_ONE.pdf"));

            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk(pdfBody, font);

            document.add(chunk);
            document.close();
        }
    }
}


