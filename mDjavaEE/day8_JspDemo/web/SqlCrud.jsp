<%-- 
    Document   : Sqlinsert
    Created on : 23-Dec-2020, 16:11:44
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
        <title>SQL CRUD JSP Page</title>
    </head>
    <body>
        <h3>Sql C R U D </h3>
        
        <!--
        userid is <%= request.getParameter("userid") %><br>
        pwd is <%= request.getParameter("pwd") %><br>
        user is <%= request.getParameter("user") %><br>
        -->
        <c:set var="op" value='<%=request.getParameter("action")%>' /> 
        
        <sql:setDataSource var="myDBAccess" user="hr" password="oracle"
            url="jdbc:oracle:thin:@//localhost:1521/orcl"
            driver="oracle.jdbc.OracleDriver"/>
        <!-- INSERT INTO HR.HR_AUTHEN VALUES ('userE', 'welcome1', 'Mr_E', 0)  -->

        
        <c:if test="${op == 'Create_User'}">
            <h3>** Create_User **</h3>
            <sql:update dataSource="${myDBAccess}" var="count">
                INSERT INTO HR.HR_AUTHEN (USERID,PASSWORD,USERNAME,INUSE)
                VALUES ('<%= request.getParameter("userid") %>',
                        '<%= request.getParameter("pwd") %>',
                        '<%= request.getParameter("user") %>', 0)
            </sql:update>
            <h4> ${count} Record Inserted Successfully! </h4>
        </c:if>
        <br> 

        <c:if test="${op == 'UnLock_User'}">
            <h3>** UnLock_User **</h3>
            <sql:update dataSource="${myDBAccess}" var="count">
                UPDATE HR.HR_AUTHEN SET INUSE = 0
                WHERE USERID = '<%= request.getParameter("userid") %>' 
            </sql:update> 
            <h4> ${count} Record updated Successfully </h4>
        </c:if>
        
         <!-- DELETE FROM HR.HR_AUTHEN where userid = 'userZ' -->   
        <c:if test="${op == 'Delete_User'}">
            <sql:query dataSource="${myDBAccess}" var="rs">
                SELECT USERID, PASSWORD, USERNAME, INUSE FROM HR.HR_AUTHEN
                WHERE USERID = '<%= request.getParameter("userid") %>' 
            </sql:query>
            <c:forEach var="row" items="${rs.rows}"> 
                <c:if test="${row.inuse == 0}">    
                    <h3>** Delete_User **</h3>
                    <sql:update dataSource="${myDBAccess}" var="row">
                        DELETE FROM HR.HR_AUTHEN
                        WHERE USERID = '<%= request.getParameter("userid") %>' 
                    </sql:update> 
                    <h4> ${row} Record DELETED Successfully </h4>
                </c:if>
            </c:forEach>  
        </c:if> 
            
        <c:if test="${op == 'List_all_users'}">
            <h3>** List_all_users **</h3>
            <sql:query dataSource="${myDBAccess}" var="rs">
                SELECT USERID, PASSWORD, USERNAME, INUSE FROM HR.HR_AUTHEN
            </sql:query>
                : USERID : PASSWORD : USERNAME : INUSE : <br>
            <c:forEach var="row" items="${rs.rows}">  
                  :  <c:out value="${row.userid}" />
                  :  <c:out value='${row.password}'/>
                  :  <c:out value='${row.username}'/>
                  :  <c:out value='${row.inuse}'/>   :<br>
            </c:forEach>  

        </c:if>
            
        <br>
        <a href="/JSPDemo/SqlUser.jsp">Go back to SqlUser Page </a>
    </body>
</html>
