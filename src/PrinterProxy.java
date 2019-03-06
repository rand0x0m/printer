import javax.print.attribute.PrintRequestAttributeSet;
import java.awt.print.PageFormat;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrinterProxy extends Remote {
    PageFormat pageDialog(PrintRequestAttributeSet pageFormat) throws RemoteException;
}