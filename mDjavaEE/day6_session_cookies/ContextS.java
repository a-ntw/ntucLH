
package com.dbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 at web.xml >  General > Context Parameters >
 * add Context Parameter
 * Parameter Name = CTX_P1
 * Parameter Value = Global Application Value
 */
@WebServlet(name = "ContextS", urlPatterns = {"/cs"})
public class ContextS extends HttpServlet {

    public ContextS() {
        System.out.println(" ************** Constructor Method ************** ");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(" ************** Inside Init Method ************** ");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println(" ************** Inside destroy Method ************** ");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContextS</title>");            
            out.println("</head>");
            out.println("<body>");
            
            ServletConfig cfg = this.getServletConfig();
            Enumeration<String> names = cfg.getInitParameterNames();
            while (names.hasMoreElements()) {
                String param = names.nextElement();
                String value = cfg.getInitParameter(param);
                out.println("<h2> Config Init Param : " + param + "  Value " + value + "</h2>");
            }

            ServletContext ctx = this.getServletContext();
            names = ctx.getInitParameterNames();
            while (names.hasMoreElements()) {
                String param = names.nextElement();
                String value = ctx.getInitParameter(param);
                out.println("<h2> Context Init Param : " + param + "  Value " + value + "</h2>");
            }
            //out.println(" Servlet Context Parameters " + ctx.getInitParameter("CTX_P1"));
            out.println("<h1>Servlet Server1 at " + request.getContextPath() + "</h1>");
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
