package sample.web.ui.domain;

import com.itextpdf.text.DocumentException;
import sample.web.ui.service.IMessageToPDF;
import sample.web.ui.service.MessagePDFServiceOne;
import sample.web.ui.service.MessagePDFServiceTwo;

import java.io.IOException;

public class MessageToPDFAdapter implements IMessageToPDF {
    Message message;

    public MessageToPDFAdapter(Message message) {
        message = message;
    }

    @Override
    public void generatePDF(Message message) throws IOException {
        MessagePDFServiceOne onePDF = new MessagePDFServiceOne();
        MessagePDFServiceTwo twoPDF = new MessagePDFServiceTwo();

        String pdfBody = "This is a PDF from message with ID: " + message.getId() + "The Message reads: " + message.getSummary() + " - " + message.getText();

            try {
                    onePDF.createAnPDF(pdfBody);

            } catch (Exception e) {
                System.out.println("Oh no! PDF_ONE failed, will try PDF_TWO now...");
                twoPDF.createAnotherPDF(pdfBody);
            }
        }
    }
