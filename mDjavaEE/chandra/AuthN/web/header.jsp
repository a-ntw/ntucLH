<%!
    int pageCount = 0;

    void addCount() {
        pageCount++;
    }
%>

<% addCount();%>

<html>
    <head><title>Login App</title>
    <table width="100%">
        <tr><td>
                <img src="images/duke.png" /> </td><td>
                <h1> Welcome to AuthN App </h1>
            </td>
            <td>
                Welcome <%  if(session.getAttribute("user") == null)
                                out.println("Guest");  
                         else {
                               out.println(session.getAttribute("user").toString()); 
             }%> 
            </td>
  
    </table>
</head>
<body>