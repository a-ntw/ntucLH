/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logv2;

import java.util.logging.Logger;

/**
 *
 * @author chand
 */
public class LogV2 {

    private static final Logger LOGGER = Logger.getLogger(LogV2.class.getName());

    public static void main(String[] args) {

        LOGGER.info(" Info Message From App");
        LOGGER.severe(" Severe Message From App");
        LOGGER.warning(" WARN Message From App");
        System.out.println(" Application Output ");
        LOGGER.info(" Info Message From App");
        LOGGER.severe(" Severe Message From App");
        LOGGER.warning(" WARN Message From App");

    }

}
/*
properties > VM Option > Run >
-Djava.util.logging.config.file=/Users/antw/ntuc/cohortProj/All_LogProjects/LogV2/log_v2.properties

WAS:
-Djava.util.logging.config.file=C:\\SGUS\\Java_SE_II\\LogV2\\log_v2.properties
*/
