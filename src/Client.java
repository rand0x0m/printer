import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.awt.print.PageFormat;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.2.46", 12345);
            PrinterProxy printer = (PrinterProxy) registry.lookup("printer");

            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            PageFormat pf = printer.pageDialog(pras);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

        System.out.println("Finished");
    }
}