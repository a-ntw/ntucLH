/*
from classmate
 */
package util;

import java.util.logging.*;

public class LogUtil2 {

    private static final Logger LOGGER = Logger.getLogger(LogUtil2.class.getName());

    static {
        try {
            LogUtil2.loadLogConfig();
        } catch (Exception ex) {
            LogUtil2.doExceptionLog(Level.SEVERE, "Failed to initialize logger configs", ex);
        }
    }

    public static void doInfoLog(String s) {
        LOGGER.info(s);
    }

    public static void doErrorLog(String s) {

    }

    public static void doWarnLog(String s) {

    }

    public static void doSevereLog(String s) {

    }

    public static void doExceptionLog(Level x, String s, Exception e) {
        LOGGER.log(x, s, e);
    }

    public static void loadLogConfig() throws Exception {
        LOGGER.setUseParentHandlers(false);

        Handler consoleHandler = new ConsoleHandler();
        Handler fileHandler = new FileHandler("/Users/antw/loggerlog", 20000, 5);
        //Handler fileHandler = new FileHandler("logger.log", 20000, 5); 
        LOGGER.addHandler(fileHandler);
        LOGGER.addHandler(consoleHandler);

        consoleHandler.setLevel(Level.SEVERE);
        fileHandler.setLevel(Level.ALL);
        LogUtil2.doInfoLog("Logger Configuration Done");

    }
}
