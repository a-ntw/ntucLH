<%-- 
    Document   : second
    Created on : 23-Dec-2020, 10:21:02
    Author     : antw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>second jsp Page</title>
    </head>
    <body>
        <h3>this is second.jsp</h3>
        <%
            //String pid = request.getAttribute("PID").toString();

            if (request.getAttribute("PID") == null) {
                out.println("<h1>Fresh Request </h1>");
            } else {
                out.println("<h2> Included Request</h2>");
            }
        %>
        <br><br> 
        
        <!-- added Context, APP_PARAM parameter in web.xlm -->      
        Application Parameter <%= application.getInitParameter("APP_PARAM")%> 
        <br><br><br>
        
        <%-- Expression Scriptlet, from NewJSP_Dy...jsp --%>
        Session Attribute Value is  <%= session.getAttribute("ATT1")%>
        <br><br><br>
        Request Parameter Value is <%= request.getParameter("uid")%>
        <br><br><br>
        Request Attribure Value is <%= request.getAttribute("PID")%>
        <br><br><br>
        <a href="/JSPDemo/home">Go back to Home Page </a>

    </body>
</html>
