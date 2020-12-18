package com.dbs;

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
        //PrintWriter out = response.getWriter();
        //out.println(" Handling GET Method.....");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //PrintWriter out = response.getWriter();
        //out.println(" Handling POST Method.....");
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try (PrintWriter out = res.getWriter()) {
            out.println(" <html>");
            out.println(" <head><title> Seconad Servlet </title></head>");
            out.println(" <body>");
            out.println(" <table border='2'>");
            for (int i = 2, j = 1; j <= 20; j++) {
                //out.println("<br> i = " + i);
                //out.println(" <input type='button' name='button" + i + "' value='button" + i + "' />");
                out.println(" <tr><td>" + i + "</td><td>" + j + "</td><td>" + i * j + "</td></tr>");
            }
            out.println(" This is the response from Second Servlet !!!!");
            out.println(" <a href='index.html'>Take be back ... </a>");
            out.println(" </body>");
        }
    }
}
