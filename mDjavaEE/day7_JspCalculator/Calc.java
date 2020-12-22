
package com.myApp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calc extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                String n1 = request.getParameter("num1");
        String n2 = request.getParameter("num2");
        String op = request.getParameter("op");

        int i = (n1 == null) || (n1.equals("")) ? 0 : Integer.parseInt(n1);
        int j = (n2 == null) || (n2.equals("")) ? 0 : Integer.parseInt(n2);
        int result = 0;
        if (op.equals("+")) {
            result = i + j;
        } else if (op.equals("-")) {
            result = i - j;
        } else if (op.equals("*")) {
            result = i * j;
        } else if (op.equals("/")) {
            result = i / j;
        }
        
        request.setAttribute("result", result);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
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
