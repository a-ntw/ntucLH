/*
Enterprise JavaBeans > Session Beans:
    MSG_Sender
    Package: com.web
    Session Type: Stateless
    Create Interface: Local
 */
package com.Msg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author antw
 */
@WebServlet(name = "MsgServlet", urlPatterns = {"/ms"})
public class MsgServlet extends HttpServlet {

    @EJB
    ClassicMessageSenderLocal cmsl;    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String msg = request.getParameter("jms_messsage");
            System.out.println(" Inside Servlet picking up the message to send to EJB !!! ");
            cmsl.sendMessage(msg);
            System.out.println(" Message in Servlet :: " + cmsl.receiveMessage());
        } catch (Exception e) {
            System.out.println(" Servlet Exception " + e.getMessage());
        }
        response.sendRedirect("MSG_Processor.html");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
