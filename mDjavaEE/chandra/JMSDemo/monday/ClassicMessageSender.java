/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.monday;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;

/**
 *
 * @author chand
 */
@Stateless
public class ClassicMessageSender implements ClassicMessageSenderLocal {

    @Inject
    JMSContext context;

    @Resource(lookup = "com.party.syncQ")
    Destination queue;

    @Override
    public void sendMessage(String msg) throws JMSException {

        JMSProducer producer = context.createProducer();
        producer.setProperty("toRcv", "r2");

        producer.setTimeToLive(10000);
        producer.send(queue, msg);
        System.out.println(" Message Delivered   to Q inside EJB");
    }

    @Override
    public String receiveMessage() throws Exception {
        JMSConsumer consumer = context.createConsumer(queue, "toRcv='r2'");
        Message message = consumer.receiveNoWait();
        if (message != null) {
            String msg = message.getBody(String.class);
            System.out.println(" Message Received from Q " + msg);
            return msg;
        }
        return null;
    }

}
