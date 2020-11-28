/*
 */
package util;

/**
 *
 * @author Chandra
 */
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author chand
 */
public class LogUtil {

    public static final Logger IL = Logger.getLogger(LogUtil.class.getName());
    public static final Logger SL = Logger.getLogger(LogUtil.class.getName());

    static {
        try {
            IL.setUseParentHandlers(false);
            //Handler iH = new FileHandler("C:\\Temp\\infoLogger.log", 2000000, 5);
            Handler iH = new FileHandler("/Users/antw/infologger", 2000000, 5);
            iH.setFormatter(new SimpleFormatter());
            iH.setLevel(Level.INFO);
            IL.addHandler(iH);

            SL.setUseParentHandlers(false);
            Handler sH = new FileHandler("/Users/antw/severeLogger", 2000000, 5);
            sH.setFormatter(new SimpleFormatter());
            sH.setLevel(Level.SEVERE);
            //setting custom filter for FileHandler
            SL.addHandler(sH);
        } catch (Exception e) {
            System.out.println(" In the LogUtil Static Init :: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void doInfoLog(String s) {
        IL.info(s);
    }

    public static void doErrorLog(String s) {

    }

    public static void doWarnLog(String s) {

    }

    public static void doSevereLog(String s) {

    }

    public static void doExceptionLog(String s) {

    }

    public static void loadLogConfig() {
        // Do all log configuration - .properties 
        // Handlers 
        //
    }

    public static void main(String[] args) {
        SL.severe(" This is a severe message");
        IL.info(" This is a info message");
    }

}
