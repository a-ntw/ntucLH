package com.dbs;

import com.logic.ConversionSLSBLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Conversion extends HttpServlet {

    double cel, fah, kel;

    @EJB
    ConversionSLSBLocal conv;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String celStr = request.getParameter("cel");
            String fahStr = request.getParameter("fah");
            String kelStr = request.getParameter("kel");
            String act = request.getParameter("action");

            if (act == null) {
                cel = fah = kel = 0.0;
            } else if (act.equals("cel")) {
                cel = Double.parseDouble(celStr);
                fah = conv.convert_C2F(cel);
                kel = conv.convert_C2K(cel);
            } else if (act.equals("fah")) {
                fah = Double.parseDouble(fahStr);
                cel = conv.convert_F2C(fah);
                kel = conv.convert_F2K(fah);
            } else if (act.equals("kel")) {
                kel = Double.parseDouble(kelStr);
                cel = conv.convert_K2C(kel);
                fah = conv.convert_K2F(kel);
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Conversion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("     \n"
                    + "        <form action='conv' method='get'>\n"
                    + "                        <br> Temp in Celsius    <input type='text' name='cel' value='"
                    + cel + "'> &nbsp;&nbsp;&nbsp; <input type='submit' name='action' value='cel' />\n"
                    + "                        <br> Temp in Fahrenheit <input type='text' name='fah' value='"
                    + fah + "'> &nbsp;&nbsp;&nbsp; <input type='submit' name='action' value='fah'/>\n"
                    + "                        <br> Temp in Kelvin     <input type='text' name='kel' value='"
                    + kel + "'> &nbsp;&nbsp;&nbsp; <input type='submit' name='action' value='kel'/>\n"
                    + "        </form>");
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
