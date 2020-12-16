#### JNDI Name

Home > Environment, Servers > AdminServer(admin) > View JNDI Tree

    J java
    N naming
    D directory
    I interface

Initial Context Root Directory

C: com ubs DS 

ExApp.java
``` java
      // Look up the data source
      javax.sql.DataSource ds
          = (javax.sql.DataSource) ctx.lookup("com.ubs.DS");
```

WebLogic Specific Protocol
```
    String url = "t3://localhost:7001";
```
#### JDBC datasource
    2 contaniners for webLogic Server:
    Web Container
    Static: html, css, js
    Dynamic: Servlets, Java Server Pages[JSP], Java Server Faces [JSP]
     EJB Container
    Session Beans, Timer Beans, JPA

    Application Client : JRMP // t3

    Web Client’s: http’s

#### Exercise: create Enterprise Application, EA1

    Netbean > New project > Java EE > Enterprise Application
    Server: Oracle WebLogic Server
    Java EE 7
    Create EJB Module: EA1-EJB1
    Create Web Application Module: EA1=WEB1
    
Enterprise Application contain EJB and Web APP

  EAR : Enterprise App
  WAR - Web Appl
  JAR - Java Appl

  WebLogic > Deployment
  C:\SGUS\JavaEE\temp
    myApp.ear
    myEJBApp.jar
    myWebApp.war

#### Timer
Right-click EA1-EJB1   > Timer Session Bean > 

    EJB Name: StockTicker
    Package Name: com.ubs
    Session Type: Stateless
    Method Schedule: minute="*", second="0", dayOfMonth="*", month="*", year="*", 
    hour="*", dayOfWeek=“*"

    > idempotence is stateless, eg 2x2=4

#### EA3/EA1-EJB1/src/java/com/ubs/StockTicker.java 
``` java
public class StockTicker {
    static int counter = 0;
    @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", 
    year = "*", minute = "*", second = "0")
    public void myTimer() {  
        System.out.println("**********************************************");
        System.out.println("Timer event: " + LocalDateTime.now());
        System.out.println("Timer event: " + counter++);
        System.out.println("**********************************************");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
```

### NetBean > right click EA1 > Deploy
```
...
post-run-deploy:
run-deploy:
BUILD SUCCESSFUL (total time: 1 minute 16 seconds)
```
#### WebLogic Server > Deployments > +EA1 > / > Testing > +
  or `http://localhost:7001/`


#### Monitoring
WebLogic Server > Deployments > +EA1 > / > Monitoring

### Servlet
EA1-WEB1 > Sources Packages > New > Servlet

    Class Name:     firstServlet
    Project:    EA1-WEB1
    Package:    com.ubs

click: Add information to deployment ...

right EA1 to deploy
    after successful 
    go to web logic select Web_ea1

    web > testing > context root 

#### EA3/EA1-WEB1/Source Packages/com.ubs/firstServlet.java
``` java
public class firstServlet extends HttpServlet {
    int cntr = 1;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession(true);
            sess.setAttribute("CNTR", cntr);
            
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Session Mgmt</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2> Username : " + request.getParameter("usr")+ "</h2>");
            out.println("<h2> Password :" + request.getParameter("pwd") + "</h2>");
            out.println("<h2>Servlet firstServlet at " + sess.getAttribute("CNTR") + "</h2>");
            out.println("<br><a href='/second.html'> Click here to go back...  </a> ");
            out.println("</body>");
            out.println("</html>");
        }
    }
...
```
#### EA3/EA1-WEB1/Web Pages/index.java
``` html
  ...
    <body>
        <table>
            <tr><td>
                    <form method="post" action="/firstServlet">
                       username
                        <input type="text" name="usr" /> <br> 
                        password 
                        <input type="text" name="pwd" /> <br>
                        <input type=submit value="       Login here...   "> <br>
                    </form> </td>
               </tr>
            
        </table>
    </body>
    ...
```
#### EA3/EA1-WEB1/Web Pages/WEB-INF/web.xml
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.1" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd">
    <servlet>
        <servlet-name>firstServlet</servlet-name>
        <servlet-class>com.ubs.firstServlet</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>secondServlet</servlet-name>
        <servlet-class>com.ubs.secondServlet</servlet-class>
    </servlet>
    ...
```
#### EA3/EA1-WEB1/Web Pages/WEB-INF/weblogic.xml
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<weblogic-web-app xmlns="http://xmlns.oracle.com/weblogic/weblogic-web-app" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd http://xmlns.oracle.com/weblogic/weblogic-web-app http://xmlns.oracle.com/weblogic/weblogic-web-app/1.8/weblogic-web-app.xsd">
  <jsp-descriptor>
    <keepgenerated>true</keepgenerated>
    <debug>true</debug>
  </jsp-descriptor>
  <context-root>/</context-root>
</weblogic-web-app>
```
to set index.html 
  WebApp - WEB-ING /weblogic.xml
  Ear App  - configuration Files

### Sessions
  before login = no session
  afetr login = new session
  
—
#### practise 3

https://learning.oracle.com/player/play?in_sessionid=12J13A8J54A33214&classroom_id=113879359


#### EA1_2
    http://localhost:7001/
    index.html
    firstServlet.java

    4pm
    EA1-v2.zip
    getsession
    session - no of users.
----
