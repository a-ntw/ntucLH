package com.dbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClockServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setIntHeader("Refresh", 1); // refresh every 1 sec
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html>");
            out.println("<head><title>Servlet ClockServlet</title></head>");
            out.println("<body>");
            
//            HttpSession session = request.getSession(false);
//            out.println("ivar = " + session.getAttribute("ivar"));
//            out.println("jvar = " + session.getAttribute("jvar"));
            out.println("<h1>" + LocalDateTime.now() + "</h1>");
            
            out.println("</body></html>");
        }
    }

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

}
