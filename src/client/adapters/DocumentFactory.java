package client.adapters;

import shared.Document;
import client.adapters.pdf.PDF;

import java.io.File;
import java.io.IOException;

public class DocumentFactory {

    public static Document createDocument(DocumentFormat format, File file) throws IOException, DocumentFormatNotSupported {
        Document document = null;

        switch (format) {
            case PDF:
                document = new PDF(file);
                break;
            case DOC:
                document = null;
            default:
                throw new DocumentFormatNotSupported(format.toString());
        }

        return document;
    }
}
