package shared.logging;

import java.util.logging.Logger;


//Singleton
public class AppLogger {
    static {
        logger = Logger.getLogger("client-logger");
    }

    private static Logger logger;

    private AppLogger() {}

    public static Logger getLogger() {
        return logger;
    }
}
