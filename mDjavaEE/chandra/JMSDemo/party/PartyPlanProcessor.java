/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.party;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author chand
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "com.party.Q"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class PartyPlanProcessor implements MessageListener {
    
    public PartyPlanProcessor() {
    }
    
    @Override
    public void onMessage(Message message) {
           try {
            System.out.println(message.getBody(String.class));
        } catch (JMSException ex) {
            Logger.getLogger(PartyPlanProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
