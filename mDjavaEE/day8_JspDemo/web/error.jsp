<%-- 
    Document   : error
    Created on : 23-Dec-2020, 14:30:58
    Author     : antw
--%>

<%@page isErrorPage="true"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is error page</h1>
        <%= exception.getStackTrace() %>
        <br>
        <%= exception.getMessage() %>
        <br>
        
        <a href="/JSPDemo/Third.jsp"> Go Back to Third.jsp</a>
        <br>
        <a href="/JSPDemo/home">Go back to Home Page </a>

    </body>
</html>
