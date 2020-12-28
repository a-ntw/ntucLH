/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.monday;

import javax.ejb.Local;
import javax.jms.JMSException;

/**
 *
 * @author chand
 */
@Local
public interface ClassicMessageSenderLocal {

    void sendMessage(String msg) throws JMSException;

    String receiveMessage() throws Exception;
    
}
