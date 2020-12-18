### Building Web App thru Netbean
#### New Web App Project
    Select New Project > Java Web + Web Application
      Name and Location
        Project Name: 
        Project Location:
        Server and Setting > next
        Frameworks > Finish

#### [WebLogic.xml](/mDjavaEE/day5_web/helloServlet/web/WEB-INF/weblogic.xml)
    Web Pages > WEB-INF > webLogic.xml
      <context-roots>/hs</context-roots>
    Clean and build > Deploy > index.html Run File
      http://localhost:7001/hs/
        Any changes in html, will show in browser.
        
#### Servlet
    Select File > New File
    Select **Web** and **Servlet**
      Name and Locatiom
        Class Name: NewServlet1
        Package: com.dbs
    Configure Servlet Deployment
      Select `Add information to web.xml`
      URL Patterns(s): /ns
    modify index.html
      <a href="ns"> Go to NewServlet1 ... </a>

#### check url directory
  Root Directoty 
      > weblogic.xml
  serlvet url
      > web.xml > Servlets 

#### SimpleServlet
    Select File > New File
    Select Web and Servlet
      Name and Locatiom
        Class Name: SimpleServlet
        Package: com.dbs
    Configure Servlet Deployment
      Select `Add information to web.xml`
      URL Patterns(s): /ss
    modify index.html
      <a href="ss"> Go to SimpleServlet ... </a>
      
[SimpleServlet.java](/mDjavaEE/day5_web/helloServlet/dbs/SimpleServlet.java)
``` java
public class SimpleServlet extends HttpServlet {

    public SimpleServlet() {
        System.out.println("This is Constructor");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet SimpleServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet SimpleServlet at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
```

### GET or POST
#### ThirdServer.java
    Select File > New File
    Select Web and Servlet
      Name and Locatiom
        Class Name: ThirdServlet
        Package: com.dbs
    Configure Servlet Deployment
      Select `Add information to web.xml`
      URL Patterns(s): /ts
    modify index.html with get and post form

edit index.html
``` html
        <form action="ts" method="get">
            <input type="submit" name="button1"
                   value="GET_Request" 
                   />
        </form>
        <form action="ts" method="post">
            <input type="submit" name="button2"
                   value="POST_Request" 
                   />
```      

edit [ThirdServlet.java](/mDjavaEE/day5_web/WebApplication1/dbs/ThirdServlet.java)
``` java
public class ThirdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(" Handling GET Method.....");
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(" Handling POST Method.....");
        //processRequest(request, response);
    }
```

> if click on `GET_Request`, url show `http://localhost:7001/hs/ts?button1=GET_Request`
>>    browser shown ` Handling GET Method.....`
    
> if click on `POST_Request`, url show `http://localhost:7001/hs/ts`
>>    browser shown ` Handling POST Method.....`

### Java in Servlet
edit [ThirdServlet.java](/mDjavaEE/day5_web/WebApplication1/dbs/ThirdServlet.java)
``` java
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        out.println(" Handling POST Method.....");
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println(" <html>");
            out.println(" <head><title>Servlet ThirdServlet</title></head>");
            out.println(" <body>");
            out.println(" <table border='2'>");
            for (int i = 2, j = 1; j <= 20; j++) {
                out.println("<tr><td>" + i + "</td><td>" + j
                        + " </td> <td> " + i * j + "</td></tr>");
            }
            out.println(" </table>");
            out.println(" <a href='index.html'>Take be back ... </a>");
            out.println("</body></html>");
        }
    }
```



#### ClockServlet
    Select File > New File
    Select Web and Servlet
      Name and Locatiom
        Class Name: ClockServlet
        Package: com.dbs
    Configure Servlet Deployment
      Select `Add information to web.xml`
      URL Patterns(s): /cs
    modify index.html
      <a href="cs"> Go to ClockServlet ... </a>

edit [ClockServlet.java](/mDjavaEE/day5_web/helloServlet/dbs/ClockServlet.java) at processRequest, session
``` java
response.setIntHeader("Refresh",1); // refresh every 1 sec
...
out.println("<h1> " + LocalDateTime.now() + "</h1>");
```

#### Dynamic input for ThirdServlet
edit index.html
``` html
    <body>
        <div>Welcome to my helloServlet page</div>
        <a href="ns"> Go to NewServlet1 ... </a> <br>
        <a href="ss"> Go to SimpleServlet ... </a> <br>
        <a href="cs"> Go to ClockServlet ... </a> <br>

        <form action="ts" method="get">
            <br> Enter the first number :: <input type="text" name="num1"/>
            <br> Enter the second number :: <input type="text" name="num2"/>
            <br> <input type="submit" name="button1" value="GET_Request"  />
        </form>
    </body>
```
edit [ThirdServlet.java](/mDjavaEE/day5_web/helloServlet/dbs/ThirdServlet.java), using
##### int i = (num2 == null) || (num1.equals("")) ? 2 : Integer.parseInt(num1); 
``` java
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        out.println(" Handling GET Method.....");
        processRequest(request, response);
    }
...

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println(" <html>");
            out.println(" <head><title>Servlet ThirdServlet</title></head>");
            out.println(" <body>");
            out.println(" <table border='2'>");
            
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            int i = (num2 == null) || (num1.equals("")) ? 2 : Integer.parseInt(num1);
            int j = (num2 == null) || (num2.equals("")) ? 2 : Integer.parseInt(num2);
            
            for (int c = 1; c <= j; c++) {
                out.println("<tr><td>" + i + "</td><td>" + c + " </td> <td> " + i * c + "</td></tr>");
            }
            out.println(" </table>");
            out.println(" <a href='index.html'>Take be back ... </a>");
            out.println("</body></html>");
        }
    }
```
#### Enumeration
    Select File > New File
    Select Web and Servlet
      Name and Locatiom
        Class Name: EnumServlet
        Package: com.dbs
    Configure Servlet Deployment
      Select `Add information to web.xml`
      URL Patterns(s): /es
    modify index.html with get and post form

edit [index.html](/mDjavaEE/day5_web/helloServlet/web/index.html)
``` html
        <form action="es" method="get">
            <br> Enter the first number :: <input type="text" name="i"/>
            <br> Enter the second number :: <input type="text" name="j"/>
            <br> Enter the third number :: <input type="text" name="num3"/>
            <br> Enter the fourth number :: <input type="text" name="num4"/>
            <br> Enter the fifth number :: <input type="text" name="num5"/>
            <br> Enter the sixth number :: <input type="text" name="num6"/>
            <br> Enter the seven number :: <input type="text" name="num7"/>
            <br> Enter the eight number :: <input type="text" name="num8"/>
            <br> <input type="submit" name="button1" value="GET_Request"  />
            <br> <input type="reset" name="button2" value="CancelClicked"  />
        </form>
```
edit [EnumServlet.java](/mDjavaEE/day5_web/helloServlet/dbs/EnumServlet.java), modifed from ThirdServlet
``` java
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    ...

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
	...
            int i = 0, j = 0;
            Enumeration<String> names = req.getParameterNames();
            while (names.hasMoreElements()) {
                String param = names.nextElement();
                if (param.equals("i")) {
                    i = Integer.parseInt(req.getParameter(param));
                } else if (param.equals("j")) {
                    j = Integer.parseInt(req.getParameter(param));
                }

                String value = req.getParameter(param).toString();
                out.println("<h3> Paramenters : " + param + " Value " + value + "</h3>");
            }

            HttpSession session = req.getSession(true);
            session.setAttribute("ivar", i);
            session.setAttribute("jvar", j);

            for (int c = 1; c <= j; c++) {
	    ...
```

#### HttpSession
``` java
            HttpSession session = req.getSession(true);
            
            session.setAttribute("ivar", i);
            session.setAttribute("jvar", j);
```

#### LogServlet.java
added Init(), destroy() , constructor 

    Select File > New File
    Select Web and Servlet
      Name and Locatiom
        Class Name: EnumServlet
        Package: com.dbs
    Configure Servlet Deployment
      NOT Select `Add information to web.xml`
      URL Patterns(s): /os
    modify index.html with get and post form

[LogServlet.java](/mDjavaEE/day5_web/helloServlet/dbs/LogServlet.java)
``` java
@WebServlet(name = "LogServlet", urlPatterns = {"/os"})
public class LogServlet extends HttpServlet {
    
    public LogServlet() {
        System.out.println(" ************** Constructor Method ************** ");
    }

    @Override
    public void init() throws ServletException{
        super.init();
        System.out.println(" ************** Inside Init Method ************** ");
    }
    
    @Override
    public void destroy(){
        super.destroy();
        System.out.println(" ************** Inside destroy Method ************** ");
    }            
```
* Netbeans > Services
Stop server in WebLogic …
	should show destroy statement

Start Server
	click LogServlet
	should show loging statement


#### Others

http://localhost:7001/hs/ts?

the question mark `?` is Query String

> jar -tvf HelloWordl123.war


Check for url at web.xml
> Web Pages > WEB-INF


error on my clock due to 
> missing doGet, and doPost

