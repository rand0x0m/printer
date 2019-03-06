package server;

import shared.Document;
import shared.ObjectNotFoundException;
import shared.helpers.RMIHelper;

import java.awt.print.PrinterJob;

public class Server {
    public boolean startServer(int localPort) {
        return false;
    }

    private Document getDocument(String host, int remotePort, String objectName) throws ObjectNotFoundException {
        return (Document) RMIHelper.getObject(host, remotePort, objectName);
    }

    private boolean registerPrinterJob(PrinterJob printer, int localPort, String bindName) {
        //return RMIHelper.createRegistry(localPort) && RMIHelper.bindObject(printer, bindName);
        return false;
    }
}
