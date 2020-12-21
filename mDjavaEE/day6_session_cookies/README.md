## day6Prac
Create new project
  Project Namr: day6Prac
  Context Path: /day6Parc

For html pages pr images, need to be outside the Web-inf

images folder 
  day6Prac/Web Pages > right-click > New Folder 
  Folder Name: images
  
#### AboutCookie
  New File > Web Servlet > 
    Class Name: LoginS
    Package:  com.dbs
    
#### edit Index.html
``` hmtl
    <body>
        <form action="LoginS" method="get">
            <br>Enter User Name <input type="text" name="usrN"/>
            <br>Enter Pass-word <input type="password" name="pWd"/>
            <br> <input type="submit" name="login" value="Login Here" />
            <br> <input type="reset" name="resets" value="Cancel Here" />             
        </form>
    </body>
```
#### edit LoginS.java
``` java
            out.println("<body>");
            
            String username = request.getParameter("usrN");
            String password = request.getParameter("pWd");
            out.println("User name: " + username + " Pwd: " + password);
            out.println("<h1>Servlet LoginServlet you have logged in as " + request.getContextPath() + "</h1>");
            
            Cookie c = new Cookie ("USRNAME", username);
            c.setMaxAge(3600);
            response.addCookie(c);
            
            out.println(" <a href='/AboutCookie/welcome.html'> Click here to continue </a> ");
            out.println("</body>");
```
Clean and Build > Deploy

#### Browser 
> Right-Click > Inspect > Application > shown the Cookies 

#### WebLogic
Services > Oracle WebLogic Server > View Admin Console
> Deployment > day6Parc
> Monitoring > session > shown the sessions ??


#### Welcome.html
New Html > 
HTML File Name: Welcome
> save files

### ClockServlet
New Servlet >
Class Name : ClockS
Package: com.dbs
``` java
            HttpSession session = request.getSession(true);
            String num1 = request.getParameter("ivar");
            String num2 = request.getParameter("jvar");
            int i = (num1 == null) || (num1.equals("")) ? 2 : Integer.parseInt(num1);
            int j = (num2 == null) || (num2.equals("")) ? 2 : Integer.parseInt(num2);
            out.println("<br>ivar = " + i);
            out.println("<br>jvar = " + j);
            LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getCreationTime()), ZoneId.systemDefault());
            out.println("<br>Creation Time  = " + ldt.toString());
            out.println("<br><br>Session ID = " + session.getId());

            ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getLastAccessedTime()), ZoneId.systemDefault());
            out.println("<br><br>Last Accessed Time = " + ldt);

            out.println("<h1>" + LocalDateTime.now() + "</h1>");
```
edit index.html
``` html
        <form action="ClockS" method="get">
            <br> Enter the first number :: <input type="text" name="ivar"/>
            <br> Enter the second number :: <input type="text" name="jvar"/>
            <br> <input type="submit" name="button1" value="GET_Request to Clock Serlet"  />
            <br> <input type="reset" name="button2" value="CancelClicked"  />
            <br> <a href="ClockS"> Go to Clock Servlet ... </a>
        </form>
```



