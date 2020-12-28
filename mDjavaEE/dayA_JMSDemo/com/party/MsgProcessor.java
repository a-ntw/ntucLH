package com.party;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MsgProcessor extends HttpServlet {

    @EJB
    MSG_SenderLocal msl;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // do note "jms_messsage" has triple 's'. same as  in index.html
        String jmsMSG = request.getParameter("jms_messsage");
        if (jmsMSG != null) {
            System.out.println(" Received a JMS MSG to the Servlet");
            System.out.println(" It needs to be processed");
            System.out.println(" JMS Message " + jmsMSG);
            if (msl.sendMsg(jmsMSG) == 1) {
                System.out.println("Message Send Successfully .....");
            }
        }
        response.sendRedirect("index.html");
            //Dispatching response back to the client
        //request.getRequestDispatcher("index.html").forward(request, response);
    }   //chaining of Request


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
