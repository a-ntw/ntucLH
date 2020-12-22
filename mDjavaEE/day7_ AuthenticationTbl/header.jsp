<%-- 
    Document   : header
    Created on : 22-Dec-2020, 15:00:13
    Author     : antw
--%>
<%!
    int pageCount = 0;

    void addCount() {
        pageCount++;
    }
%>

<% addCount();%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><title>Welcome Page</title>
    <table width="100%">
        <tr><td> <img src="images/Duke.svg.png" style="width:80px;"/> </td>
            <td>
                <h1> Welcome to AuthN App </h1>
            </td>
            <td>
                Welcome <% if (session.getAttribute("user") == null) {
                        out.println("Guest");
                    } else {
                        out.println(session.getAttribute("user").toString());
                    }%>
            </td>
        </tr>
    </table>
</head>
<body>
    <!-- h1>Hello World!</h1>
</body>
</html -->
