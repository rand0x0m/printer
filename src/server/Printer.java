package server;

import javax.print.attribute.PrintRequestAttributeSet;
import java.awt.print.PageFormat;
import java.rmi.Remote;

interface Printer extends Remote {
    PageFormat pageDialog(PageFormat pageFormat);
    boolean PrintDialog(PrintRequestAttributeSet printRequestAttributeSet);
}
