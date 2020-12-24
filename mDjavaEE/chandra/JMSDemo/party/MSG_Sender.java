/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.party;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 *
 * @author chand
 */
@Stateless
public class MSG_Sender implements MSG_SenderLocal {

    @Resource(mappedName="com.party.Q")
    private Destination queue; // Generic name used to represent Q or Topic 
    
    @Resource(mappedName="com.party.CF")
    private ConnectionFactory conf;
    
    @Override
    public int sendMsg(String msg) {
        try{
            Connection con = conf.createConnection();
            Session sess = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer mp = sess.createProducer(queue);
            mp.send(sess.createTextMessage(msg));
            con.close();
        }catch(Exception e){
            System.out.println(" Exception from MSG_Sender SLSB -> sendMsg");
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

 }
