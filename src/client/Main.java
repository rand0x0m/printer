package client;

import client.adapters.DocumentFormat;
import client.adapters.DocumentFormatNotSupported;
import client.adapters.pdf.ServiceNotFoundException;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length == 4) {
            File file = new File(args[1]);
            if (file.exists()) {
                Client client = new Client();
                if (args[1].contains(".")) {
                    String[] splitted = args[1].split(".");
                    try {
                        client.printDocument(file, DocumentFormat.valueOf(splitted[splitted.length-1]), args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (DocumentFormatNotSupported documentFormatNotSupported) {
                        documentFormatNotSupported.printStackTrace();
                    } catch (ServiceNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
