<%-- 
    Document   : home
    Created on : 22-Dec-2020, 15:00:25
    Author     : antw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="header.jsp"/>


<form action="AuthServlet" method="POST">
    <input type="hidden" name="userid" value='<%=request.getAttribute("username") %>'  />
    <br>   Click here to Logout &nbsp;&nbsp;&nbsp; <input type="submit" name="action" value="Logout" />

</form>


<jsp:include page="footer.jsp"/>
