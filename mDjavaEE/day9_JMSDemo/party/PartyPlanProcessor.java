/*
Netbeans > New File > Enterprise JavaBeans > Message-Driven Bean 
> Server Destination = com.party.Q

To check on Message_Driven EJB:
Home > Deployments > JMSDemo > PartyPlanProcessor >  Monitoring
only after deploy
*/
package com.party;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "com.party.Q"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class PartyPlanProcessor implements MessageListener {

    public PartyPlanProcessor() {
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("******** from onMessage-1 ******");

        try {
            System.out.println(message.getBody(String.class));
        } catch (JMSException ex) {
            Logger.getLogger(PartyPlanProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
