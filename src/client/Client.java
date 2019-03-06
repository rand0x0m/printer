package client;

import client.adapters.DocumentFactory;
import client.adapters.DocumentFormat;
import client.adapters.DocumentFormatNotSupported;
import client.adapters.pdf.ServiceNotFoundException;
import shared.Document;
import shared.ObjectNotFoundException;
import shared.helpers.RMIHelper;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

public class Client implements Observer {

    public Client() {}

    public boolean printDocument(File file, DocumentFormat format, String remoteHost, int remotePort, int localPort) throws IOException, DocumentFormatNotSupported, ServiceNotFoundException {
        Document document = DocumentFactory.createDocument(format, file);
        registerDocument(document, localPort, "document");

        PrinterJob printerJob = null;
        try {
            printerJob = getPrinterJob(remoteHost, remotePort,"printer");
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PageFormat pf = printerJob.pageDialog(pras);

        if (pf != null) {
//            try {
//                //printerJob.print(pras);
//                return true;
//            } catch (PrinterException e) {
//                e.printStackTrace();
//            }
        }

        return false;
    }

    private PrinterJob getPrinterJob(String host, int remotePort, String objectName) throws ObjectNotFoundException {
        return (PrinterJob) RMIHelper.getObject(host, remotePort, objectName);
    }

    private boolean registerDocument(Document document, int localPort, String bindName) {
        return RMIHelper.createRegistry(localPort) && RMIHelper.bindObject(document, bindName) && document.addObserver(this);
    }

    @Override
    public void update(Observable observable) {
        RMIHelper.unbindObject(observable.getName());
    }
}
