
package com.bank;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Second extends HttpServlet{
    
    public Second() {
        System.out.println(" This is the Constructor ....");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println(" <html>");
        out.println(" <head> <title> Second Servlet </title> </head>");
        out.println(" <body>");
        out.println(" <br> <a href='index.html'> Take me back .... </a> ");
        out.println(" </body></html>");
    }
}
