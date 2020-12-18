
package com.bank;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ThirdServlet", urlPatterns = {"/ts"})
public class ThirdServlet extends HttpServlet {
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
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
         try(PrintWriter out = res.getWriter()){
            out.println(" <html>");
            out.println(" <head> <title> Third Servlet </title> </head>");
            out.println(" <body>");
            out.println(" <table border='2'>");
            int i = Integer.parseInt(req.getParameter("num1").toString());
            int j = Integer.parseInt(req.getParameter("num2").toString());
            for(int c =1; c <= j; c++){
                out.println("<tr><td>" +  i  +  "</td><td>" + c + " </td> <td> " + i*c + "</td></tr>");
            }
            out.println(" </table>");
            out.println(" <br> <a href='index.html'> Take me back .... </a> ");
            out.println(" </body></html>");
        }
    }
}
