package com.dbs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Second extends HttpServlet {

    public Second() {
        System.out.println("This is Constructor");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        PrintWriter out = response.getWriter();
        out.println(" <html>");
        out.println(" <head><title> Seconad Servlet </title></head>");
        out.println(" <body>");
        out.println(" This is the response from Second Servlet !!!!");
        out.println(" <a href='index.html'>Take be back ... </a>");
        out.println(" </body>");
        
    }
}
