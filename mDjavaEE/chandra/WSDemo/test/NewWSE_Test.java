/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.time.LocalDateTime;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author chand
 */
@ServerEndpoint("/endpoint")
public class NewWSE_Test {

    private static int counter = 0;

    @OnMessage
    public String onMessage(Session session, String message) throws Exception {

        while (true) {
            for (Session sess : session.getOpenSessions()) {
                if (sess.isOpen()) {
                    message = LocalDateTime.now().toString();
                    sess.getBasicRemote().sendText(message);
                    Thread.sleep(1000);
                }
                    System.out.println(" Msg to Client" + message);
            }
        }
//        return message;
    }

}
