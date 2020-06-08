package sample.web.ui.service;

import org.dom4j.DocumentException;
import sample.web.ui.domain.Message;

import java.io.IOException;

public interface IMessageToPDF {
        Message message = null;
        void generatePDF(Message message) throws IOException, DocumentException;
    }


