<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL Examples Page</title>
    </head>
    <body>
        <sql:setDataSource var="myDBAccess"  user="hr" password="hr"
                           url="jdbc:oracle:thin:@//localhost:1521/XEPDB1"
                           driver="oracle.jdbc.OracleDriver"/>
        <sql:query dataSource="${myDBAccess}" var="rs">
            SELECT USERID, PASSWORD, USERNAME, INUSE FROM HR.AUTHENTICATIONTBL ORDER BY USERID
        </sql:query>
        <table border="2" width="100%" contenteditable="true" style="text-align: center;">  
            <tr style=" font-weight: 800; background-color: lightblue">  
                <th>User_ID</th>  
                <th>Password</th>  
                <th>User Name</th>  
                <th>inUSE</th>   
                <th>Operations</th>   
            </tr>  
            <c:forEach var="row" items="${rs.rows}">  
                <tr>  
                    <td><c:out value="${fn:trim(row.userid)}" /></td>  
                    <td><c:out value='${fn:trim(row.password)}'/></td>  
                    <td><c:out value='${fn:trim(row.username)}'/></td>  
                    <td><c:out value='${fn:trim(row.inuse)}'/></td>  
                <form action="UserRegJSP.jsp" method="POST">

                    <input type="hidden" name="userid" value="${fn:trim(row.userid)}">
                    <td><input type="submit" name="action" value="Delete">
                        <c:if test="${row.inuse == 1}">
                            <input type="submit" name="action" value="Unlock">
                        </c:if>
                </form>
            </td>
        </tr>  
    </c:forEach>  
    <tr>
    <form action="UserRegJSP.jsp" method="POST">
        <td><input type="text" name="usr"></td>
        <td><input type="text" name="pwd"></td>
        <td><input type="text" name="user"></td>
        <td colspan="2"><input type="submit" name="action" value="Add"></td>      
    </form>
</tr>
</table>  
</form>
</body>
</html>