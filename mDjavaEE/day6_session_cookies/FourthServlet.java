package com.dbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FourthServlet", urlPatterns = {"/FourthServlet"},
        initParams = {
            @WebInitParam(name = "countryCode", value = "SG")
            ,
    @WebInitParam(name = "IDDCode", value = "+65")})

public class FourthServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            ServletConfig config = this.getServletConfig();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FourthServlet</title>");
            out.println("</head>");
            out.println("<body>");
            Enumeration<String> names = config.getInitParameterNames();
            while (names.hasMoreElements()) {
                String param = names.nextElement();
                String value = config.getInitParameter(param);
                out.println("<h2> Init Param : " + param + "  Value " + value + "</h2>");
            }
            names = request.getParameterNames();
            while (names.hasMoreElements()) {
                String param = names.nextElement();
                String value = request.getParameter(param);
                out.println("<br><h2> Request Param : " + param + "  Value " + value + "</h2>");
            }
            out.println("</body>");
            out.println("</html>");
            // right-click to run from `/FourthServlet?a=10&b=20&c=30`
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
