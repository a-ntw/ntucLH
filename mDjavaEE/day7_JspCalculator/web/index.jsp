<%-- 
    Document   : index
    Created on : 22-Dec-2020, 13:44:50
    Author     : antw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="GET" action="Calc">
            <br> Enter First Number here <input type="text" name="num1"/> <br>
            <br> Enter Second Number here <input type="text" name="num2"/> 
            <br> <br>Click an operation  
            &nbsp;&nbsp;&nbsp;<input type="submit" name="op" value="+"/> 
            &nbsp;&nbsp;&nbsp;<input type="submit" name="op" value="-"/> 
            &nbsp;&nbsp;&nbsp;<input type="submit" name="op" value="*"/> 
            &nbsp;&nbsp;&nbsp;<input type="submit" name="op" value="/"/> <br><br>
            <br> Results are here .....<%= request.getAttribute("result") == null ? 0 : request.getAttribute("result")%>

            <%
                out.println("<br><br><br><br>Your IP address is " + request.getRemoteAddr());
            %>
        </form> 
    </body>
</html>
