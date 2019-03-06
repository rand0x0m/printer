import javax.print.attribute.PrintRequestAttributeSet;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.rmi.RemoteException;

public class PrinterImpl implements PrinterProxy {

    private PrinterJob printerJob;

    public PrinterImpl() {
        printerJob = PrinterJob.getPrinterJob();
        //System.out.println
    }

    @Override
    public PageFormat pageDialog(PrintRequestAttributeSet pras) throws RemoteException {
        return printerJob.pageDialog(pras);
    }
}
public interface Interf<T> {
    default void method() {
        System.out.println(this.getClass().getName());
        Class<T> tClass = (Class<T>) this.getClass();
    }
}
