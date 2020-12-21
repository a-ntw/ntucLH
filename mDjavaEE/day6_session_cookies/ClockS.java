package com.dbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ClockS", urlPatterns = {"/ClockS"})
public class ClockS extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setIntHeader("Refresh", 10); // refresh every 1 sec
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html>");
            out.println("<head><title>Servlet ClockServlet</title></head>");
            out.println("<body>");

            HttpSession session = request.getSession(true);
            String num1 = request.getParameter("ivar");
            String num2 = request.getParameter("jvar");
            int i = (num1 == null) || (num1.equals("")) ? 2 : Integer.parseInt(num1);
            int j = (num2 == null) || (num2.equals("")) ? 2 : Integer.parseInt(num2);
            out.println("<br>ivar = " + i);
            out.println("<br>jvar = " + j);
            LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getCreationTime()), ZoneId.systemDefault());
            out.println("<br>Creation Time  = " + ldt.toString());
            out.println("<br><br>Session ID = " + session.getId());

            ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getLastAccessedTime()), ZoneId.systemDefault());
            out.println("<br><br>Last Accessed Time = " + ldt);

            out.println("<h1>" + LocalDateTime.now() + "</h1>");
            
            out.println(" <br> <a href='index.html'>Take be back ... </a>");
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
