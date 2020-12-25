<%-- 
    Document   : EL_JSP
    Created on : 23-Dec-2020, 14:41:54
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
        <title>Expression Language, EL Page</title>
    </head>
    <body>
        <%
            String[] arr = {"Hello", "World", "Here"};
            for (String s : arr) {
                out.println(s);
            }
        %>
        <!--  converting java cpde to html -->
        <c:out value="This is a test" />

        <%-- for(int j=1; j<=3; j++) --%>
        <c:forEach var="j" begin="1" end="3">
            <br>Item <c:out value="${j}"/><p>
            </c:forEach>

            <!-- Tags Function Library--->
            ${fn:toUpperCase('Hello')}
            ${fn:toLowerCase('HELLO')}     

            <!-- Tags SQL Library--->  
            <sql:setDataSource var="myDBAccess" user="hr" password="oracle"
                               url="jdbc:oracle:thin:@//localhost:1521/orcl"
                               driver="oracle.jdbc.OracleDriver"/>

            <sql:query dataSource="${myDBAccess}" var="rs">
                SELECT USERID, PASSWORD, USERNAME, INUSE FROM HR.HR_AUTHEN
            </sql:query>

        <table border="2" width="100%" contenteditable="true" style="text-align: center;">  
            <tr>  
                <th>User_ID</th>  
                <th>Password</th>  
                <th>User Name</th>  
                <th>inUSE</th>  

            </tr>  
            <c:forEach var="row" items="${rs.rows}">  
                <tr>  
                    <td ><c:out value="${row.userid}" /></td>  
                    <td><c:out value='${row.password}'/></td>  
                    <td><c:out value='${row.username}'/></td>  
                    <td><c:out value='${row.inuse}'/></td>  
                </tr>  
            </c:forEach>  
        </table>  

        <!-- ﻿select count(*) from hr_authen -->

        <br><br><br>
        <a href="/JSPDemo/home">Go back to Home Page </a>            
    </body>
</html>
