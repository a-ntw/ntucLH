/*
Netbeans > session bean > stateless > Local
right click insert code > Add Business Method > Int > Parameter

To check JNDI Name from WebLogic Server
Domain Structure > Services > Messaging > JMS Modules > m1 > JNDI Name
*/

package com.party;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;

@Stateless
public class MSG_Sender implements MSG_SenderLocal {

    @Resource(mappedName = "com.party.Q")
    private Destination queue;// Generic name used to represent Q or Topic 

    @Resource(mappedName = "com.party.CF")
    private ConnectionFactory conf;

    @Override
    public int sendMsg(String msg) {
        try {
            Connection con = conf.createConnection(); 
            Session sess = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer mp = sess.createProducer(queue);
            mp.send(sess.createTextMessage(msg));
            con.close();
        } catch (Exception e) {
            System.out.println(" Exception from MSG_Sender SLSB -> sendMsg");
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

}
