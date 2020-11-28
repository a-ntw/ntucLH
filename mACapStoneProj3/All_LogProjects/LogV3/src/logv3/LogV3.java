/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logv3;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author chand
 */
public class LogV3 {

    private static final Logger LOGGER = Logger.getLogger(LogV3.class.getName());

    public static void main(String[] args) {

        LOGGER.info(" Info Message From App");
        LOGGER.severe(" Severe Message From App");

        System.out.println(" Application Output ");
        LOGGER.info(" Info Message From App");
        LOGGER.severe(" Severe Message From App");

    }

}

/*
LogV3/log_v3.properties
"
handlers= java.util.logging.FileHandler,java.util.logging.ConsoleHandler

java.util.logging.FileHandler.pattern = %h/java%u.log
java.util.logging.FileHandler.limit = 100000
java.util.logging.FileHandler.count = 10
java.util.logging.FileHandler.formatter = java.util.logging.XMLFormatter
"
%h/java%u.log

log file at home directory of the users
*/

/*
properties > VM Option > Run >
-Djava.util.logging.config.file=/Users/antw/ntuc/cohortProj/All_LogProjects/LogV3/log_v3.properties

WAS:
-Djava.util.logging.config.file=C:\\SGUS\\Java_SE_II\\LogV3\\log_v3.properties
*/
