<%-- 
    Document   : login.jsp
    Created on : Dec 21, 2020, 10:47:21 PM
    Author     : chand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<jsp:include page="header.jsp" />

<form action="AuthServlet" method="POST">
    <label style="color: brown; "> <%= request.getAttribute("status") != null ? "User Already Logged in " + request.getAttribute("status") : "" %></label>
    <br> Enter Username <input type="text" name="usrn" /> <label style="color: red; font-weight: bold; "> <%= request.getAttribute("error") != null ? "Invalid Credentials" : "" %></label>
    <br> Enter Password <input type="text" name="pwd" />  <label style="color: red; font-weight: bold; ">  <%= request.getAttribute("error") != null ? "Invalid Credentials" : "" %></label>
    <br>    <input type="reset" value="Reset" /> &nbsp;&nbsp;&nbsp; <input type="submit" name="action" value="Login" />
</form>

<jsp:include page="footer.jsp" />