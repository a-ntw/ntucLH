<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
<html>
<head>
	<title>JavaServer Faces Registration Application</title>
</head>
<body>
		<h4>Employee Information System</h4>
		<table>
			<tr>
				<td>Name:</td>
				<td><h:outputText value="#{employeeBean.empName}" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><h:outputText value="#{employeeBean.gender}" /></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><h:outputText value="#{employeeBean.dob}" /></td>
			</tr>
			<tr>
				<td>Marital Status:</td>
				<td><h:outputText value="#{employeeBean.maritalStatus}" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><h:outputText value="#{employeeBean.address}" /></td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td><h:outputText value="#{employeeBean.emailAddress}" /></td>
			</tr>
			<tr>
				<td>Mobile Number:</td>
				<td><h:outputText value="#{employeeBean.mobileNumber}" /></td>
			</tr>
			<tr>
				<td>Designation:</td>
				<td><h:outputText value="#{employeeBean.designation}" /></td>
			</tr>
			<tr>
				<td>Department:</td>
				<td><h:outputText value="#{employeeBean.department}" /></td>
			</tr>
			<tr>
				<td>Is Permanent?:</td>
				<td><h:outputText value="#{employeeBean.employeeType}" /></td>
			</tr>
		</table>
	</body>
</html>
</f:view>
