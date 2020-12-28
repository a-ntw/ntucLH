
package singleton;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/TestServlet" })
public class TestServlet extends HttpServlet {

    @Inject
    MySingleton bean1;
    @Inject
    MySingletonBeanManagedConcurrency bean2;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Singleton Bean</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Singleton Bean</h1>");
            out.println("<h2>Container-managed Concurrency</h2>");
            out.println(bean1.readSomething("bean1") + "<br>");
            out.println(bean1.writeSomething("Duke") + "<br>");
            out.println("<h2>Bean-managed Concurrency</h2>");
            out.println(bean2.readSomething("bean2") + "<br>");
            out.println(bean2.writeSomething("Duke"));
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
    }
}