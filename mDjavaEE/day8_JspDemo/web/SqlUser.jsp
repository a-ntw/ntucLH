<%-- 
    Document   : sqlUser
    Created on : 23-Dec-2020, 16:01:42
    Author     : antw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SQL user JSP Page</title>
    </head>
    <body>
        <h3>SQL user</h3>


        <form action="SqlCrud.jsp" method="POST" -->
            <br> Click here to <input type="submit" name="action" value="List_all_users">
            <br>
            <br> Enter UserID <input type="text" name="userid">
            <br>
            <br> Click here to <input type="submit" name="action" value="UnLock_User">
            <br>
            <br> Click here to <input type="submit" name="action" value="Delete_User">
            <br>
            <br> Enter Password <input type="text" name="pwd" >
            <br> Enter Username <input type="text" name="user">
            <br> Click here to <input type="submit" name="action" value="Create_User">
        </form>

        <br><br><br>
        <a href="/JSPDemo/home">Go back to Home Page </a>

    </body>
</html>
