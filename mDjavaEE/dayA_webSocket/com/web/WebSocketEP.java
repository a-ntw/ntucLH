
package com.web;

import java.time.LocalDateTime;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/wsep")
public class WebSocketEP {
    private static int msgCounter=0;
    @OnMessage
    public String onMessage(Session session, String message) {
        //System.out.println(session.getMaxIdleTimeout());
//        session.setMaxIdleTimeout(300000);
        System.out.println("Sesion Ping Interval " + LocalDateTime.now() + " : " 
                + session.getMaxIdleTimeout());

        return message.toUpperCase() + ":" + msgCounter++;
    }
    
}
