/*
To check the available session open and run
WebLogic Server > Deployment > Monitoring >
WebSocket Appl > Session Statistics > +  Oprn Session
 */
package com.web;

import java.time.LocalDateTime;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author antw
 */
@ServerEndpoint("/endpoint")
public class NewEndpoint {
    
    private static int counter = 0;

    @OnMessage
    public String onMessage(Session session, String message) throws Exception {

        while (true) {
            for (Session sess : session.getOpenSessions()) {
                if (sess.isOpen()) {
                    message = LocalDateTime.now().toString();
                    sess.getBasicRemote().sendText(message);
                    System.out.println(" Msg to Client" + message);
                    Thread.sleep(1000);
                }
                    
            }
        }
//        return message;
    }
    
}
