package com.dbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EnumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println(" <html>");
            out.println(" <head><title>Servlet ThirdServlet</title></head>");
            out.println(" <body>");
            out.println(" <table border='2'>");

            int i = 0, j = 0;
            Enumeration<String> names = req.getParameterNames();
            while (names.hasMoreElements()) {
                String param = names.nextElement();
                if (param.equals("i")) {
                    i = Integer.parseInt(req.getParameter(param));
                } else if (param.equals("j")) {
                    j = Integer.parseInt(req.getParameter(param));
                }

                String value = req.getParameter(param).toString();
                out.println("<h3> Paramenters : " + param + " Value " + value + "</h3>");
            }

            HttpSession session = req.getSession(true);
            session.setAttribute("ivar", i);
            session.setAttribute("jvar", j);

            for (int c = 1; c <= j; c++) {
                out.println("<tr><td>" + i + "</td><td>" + c + " </td> <td> " + i * c + "</td></tr>");
            }
            out.println(" </table>");
            out.println(" <a href='index.html'>Take be back ... </a>");
            out.println("</body></html>");
        }
    }

}
