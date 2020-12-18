### Building Web App thru Netbean
#### New Web App Project
    Select New Project > Java Web + Web Application
      Name and Location
        Project Name: 
        Project Location:
        Server and Setting > next
        Frameworks > Finish

#### WebLogic.xml
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
      
SimpleServlet.java
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

edit ThirdServlet.java
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
From Chandra to Everyone: (12:14 PM)
out.println(" <html>");
            out.println(" <head> <title> Third Servlet </title> </head>");
            out.println(" <body>");
            out.println(" <table border='2'>");
            for(int i = 2, j=1; j<= 20 ;j++){
                out.println("<tr><td>" +  i  +  "</td><td>" + j + " </td> <td> " + i*j + "</td></tr>");
            }
            out.println(" </table>");
            out.println(" <br> <a href='index.html'> Take me back .... </a> ");
            out.println(" </body></html>");

http://localhost:7001/hw/tx?
the question mark `?` is Query String

2pm

> jar -tvf HelloWordl123.war



#### ClockServlet
Select File > New File
Select Web and Servlet
Name and Location
File Name:
Configure Servlet
Add info

#### Check for url at web.xml
Web Pages > WEB-INF

#### Auto refresh
`response.setIntHeader("R",0);`

#### Enumeration
From Chandra to Everyone: (2:46 PM) 
 Enumeration <String> names = req.getParameterNames(); while (names.hasMoreElements()) { String param = names.nextElement(); String value = req.getParameter(param).toString(); out.println("<h2> Parameters : " + param + " Value " + value + "</h2>"); }

From Chandra to Everyone: (2:58 PM)  int i = 0, j = 0; Enumeration <String> names = req.getParameterNames(); while (names.hasMoreElements()) { String param = names.nextElement(); if(param.equals("i")) i = Integer.parseInt(req.getParameter(param));                 else if(param.equals("j")) j = Integer.parseInt(req.getParameter(param)); else { String value = req.getParameter(param); out.println("<h2> Parameters : " + param + " Value " + value + "</h2>"); } } for (int c = 1; c <= j; c++) { out.println("<tr><td>" + i + "</td><td>" + c + " </td> <td> " + i * c + "</td></tr>"); } 

#### HttpSession
``` java
            HttpSession session = req.getSession(true);
            
            session.setAttribute("ivar", i);
            session.setAttribute("jvar", j);
```

### error on my clock due to 
missing doGet, and doPost

#### Serlet1.java
addded Init(), destroy() , contractor 

``` java
@WebServlet(name = "Server1", urlPatterns = {"/s1"})
public class Servlet1 extends HttpServlet {
    
    public Servlet1() {
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

Stop server in WebLogic …
	should show destroy statement

Start Server
	click Servlet1
	should show loging statement
