<%-- 
    Document   : Third
    Created on : 23-Dec-2020, 12:33:58
    Author     : antw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %> <!-- any error will send to this jsp -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            session.getAttribute("JUNKVALUE").toString();
        %>
    </body>
</html>
