<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Employee Information System</title>
        </head>
        <body>
            <h:form>
                <h2>Employee Information System</h2>
                <table>
                    <tr>
                        <td>Employee Name:</td>
                        <td>
                            <h:inputText label="Employee Name" 
                                         id="ename" value="#{employeeBean.empName}"     
                                         required="true"/>
                            <h:message for="ename" style="color: red"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Gender:</td>
                        <td>
                            <h:selectOneRadio label="Gender" 
                                              id="gender" value="#{employeeBean.gender}" required="true">
                                <f:selectItem itemLabel="Male" itemValue="male" />
                                <f:selectItem itemLabel="Female" itemValue="female" />
                            </h:selectOneRadio>
                            <h:message for="gender" style="color: red"/>             
                        </td>
                    </tr>

                    <tr>
                        <td>Date of Birth:</td>
                        <td>
                            <h:inputText label="Date of Birth"
                                         id="dob" value="#{employeeBean.dob}" required="true">
                                <f:convertDateTime pattern="MM-dd-yy" />
                            </h:inputText> (mm-dd-yy)
                            <h:message for="dob" style="color: red"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Marital Status:</td>
                        <td>
                            <h:selectOneRadio label="Marital Status" 
                                              id="mstatus" value="#{employeeBean.maritalStatus}" required="true">
                                <f:selectItem itemLabel="Single" itemValue="single" />
                                <f:selectItem itemLabel="Married" itemValue="married" />
                            </h:selectOneRadio>
                            <h:message for="mstatus" style="color: red"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Address:</td>
                        <td>
                            <h:inputText label="Address"
                                         id="address" value="#{employeeBean.address}"
                                         required="true"/>
                            <h:message for="address" style="color: red"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Email Address:</td>
                        <td>
                            <h:inputText label="Email Address"
                                         id="email" value="#{employeeBean.emailAddress}" required="true"
                                         validator="#{employeeBean.validateEmail}"/>
                            <h:message for="email" style="color: red"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Mobile Number:</td>
                        <td>
                            <h:inputText label="Mobile Number"
                                         id="mobileno" value="#{employeeBean.mobileNumber}" required="true">
                            </h:inputText>
                            <h:message for="mobileno" style="color: red"/>
                        </td>
                    </tr>


                    <tr>
                        <td>Designation:</td>
                        <td>
                            <h:selectOneMenu label="Designation"
                                             value="#{employeeBean.designation}">
                                <f:selectItem itemLabel="Manager" itemValue="manager" />
                                <f:selectItem itemLabel="Executive" itemValue="executive" />
                                <f:selectItem itemLabel="Sr. Manager" itemValue="srmanager" />
                            </h:selectOneMenu>
                        </td>
                    </tr>

                    <tr>
                        <td>Department:</td>
                        <td>
                            <h:selectOneMenu label="Department"
                                             value="#{employeeBean.department}">
                                <f:selectItem itemLabel="Accounts" itemValue="accounts" />
                                <f:selectItem itemLabel="Sales" itemValue="sales" />
                                <f:selectItem itemLabel="Marketing" itemValue="marketing" />
                            </h:selectOneMenu>
                        </td>
                    </tr>
                    <tr>
                        <td>Is Permanent?:</td>
                        <td>
                            <h:selectBooleanCheckbox value="#{employeeBean.employeeType}" />
                        </td>
                    </tr>

                </table>
                <p><h:commandButton value="Submit" action="#{employeeBean.storeEmployeeInfo}" /></p>
            </h:form>
        </body>
    </html>
</f:view>
