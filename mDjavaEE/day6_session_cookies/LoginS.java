
package com.dbs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginS", urlPatterns = {"/LoginS"})
public class LoginS extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginS</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String username = request.getParameter("usrN");
            String password = request.getParameter("pWd");
            out.println("User name: " + username + " Pwd: " + password);
            out.println("<h1>Servlet LoginServlet you have logged in as " + request.getContextPath() + "</h1>");
            
            Cookie c = new Cookie ("USRNAME", username);
            c.setMaxAge(3600);
            response.addCookie(c);
            
            out.println(" <a href='/day6Prac/Welcome.html'> Click here to continue </a> ");
            out.println("</body>");
            out.println("</html>");
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
