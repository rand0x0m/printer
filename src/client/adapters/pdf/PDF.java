package client.adapters.pdf;

import shared.Document;
import shared.Page;
import client.adapters.ImageFormat;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PDF extends Document {

    private List<Page> pages;

    public PDF(File file) throws IOException {
        super(file);

        PDDocument document = PDDocument.load(file);
        PDFRenderer pdfRenderer = new PDFRenderer(document);

        pages = new ArrayList<>();

        for (int i=0; i<document.getNumberOfPages(); i++) {
            pages.add(new PDFPage(pdfRenderer.renderImage(i), ImageFormat.PNG));
        }
    }

    @Override
    protected int size() {
        return pages.size();
    }

    @Override
    public Iterator<Page> iterator() {
        return pages.iterator();
    }
}
