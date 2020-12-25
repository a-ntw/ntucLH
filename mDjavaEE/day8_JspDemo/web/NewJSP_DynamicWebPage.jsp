
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page session="true" %>

<!-- HTML Comment -->

<%-- JSP Comment --%>

<!--
Servlet Parameters added:
web.xml > Servlet > 
Servlet Name: First Page
JSP File: NewJSP_DynamicWebPage.jsp
URL Pattern: /home
Initialization Parameter: 
    Parameter Name:     CONFIG_INIT_PARAM1
    Parameter Value:    SAMSUNG

Context Parameters added:
web.xml > General > 
Session Timeout: 5 ??
Context Parameters: 
    Parameter Name:     CTX_PARAM
    Parameter Value:    ROG
    Parameter Name:     APP_PARAM
    Parameter Value:    ASUS

Welcome Page
web.xml > Pages > Welcome Files: NewJSP_DynamicWebPage.jsp, /home
-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            // Regular Scriptlet
            session.setAttribute("ATT1", "Panasonic");

            request.setAttribute("PID", "20201223");

            // application is at server level..
            application.setAttribute("Bottle","Starbuck");

            //request.getRequestDispatcher("second.jsp").forward(request, response);
            // forwarding -  it just go to the senod page

            //request.getRequestDispatcher("second.jsp").include(request, response);
            // include - it inlcude the second.jsp 

            %>
            <a href="second.jsp">click here to go to Second.jsp</a><br><br>
            <a href="second.jsp?PID=20201223">click here to go to Second.jsp?PID=20201223</a><br><br>
            <a href="Third.jsp">click here to go to Third.jsp, about Error page </a><br><br>
            <a href="EL_JSP.jsp">click here to go to EL_JSP.jsp, for SQL table </a><br><br>
            <a href="SqlUser.jsp">click here to go to SqlUser.jsp, SqlCRUD </a><br><br>
            
            <!-- added Context, CTX_PARAM parameter in web.xlm -->            
            <br><br> Application/ServletContext  Parameter : <%= application.getInitParameter("CTX_PARAM") %> 

            <br><br>Servlet / JSP Configuration Init Parameter
            <br>
            
            CONFIG INIT PARAM1 : <%= config.getInitParameter("CONFIG_INIT_PARAM1") %>
            <br><br><br>
            <form action="second.jsp" method="GET">
                <input type="text" name="uid">
                <input type="submit" name="action" value="SendUID">
            </form>
    </body>
</html>
