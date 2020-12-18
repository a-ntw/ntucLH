package com.dbs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        out.println(" Handling GET Method.....");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        out.println(" Handling POST Method.....");
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println(" <html>");
            out.println(" <head><title>Servlet ThirdServlet</title></head>");
            out.println(" <body>");
            out.println(" <table border='2'>");
            
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            int i = (num2 == null) || (num1.equals("")) ? 2 : Integer.parseInt(num1);
            int j = (num2 == null) || (num2.equals("")) ? 2 : Integer.parseInt(num2);
            
            for (int c = 1; c <= j; c++) {
                out.println("<tr><td>" + i + "</td><td>" + c + " </td> <td> " + i * c + "</td></tr>");
            }
            out.println(" </table>");
            out.println(" <a href='index.html'>Take be back ... </a>");
            out.println("</body></html>");
        }
    }

}
