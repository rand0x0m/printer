import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String args[]) {
        try {
            System.setSecurityManager(new SecurityManager());
            PrinterImpl printer = new PrinterImpl();
            PrinterProxy printerProxy = (PrinterProxy) UnicastRemoteObject.exportObject(printer, 0);

            Registry registry = LocateRegistry.createRegistry(12345);
            registry.bind("printer", printerProxy);
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

        System.out.println("Finished");
    }
}