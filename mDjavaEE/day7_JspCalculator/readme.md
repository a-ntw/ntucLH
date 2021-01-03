### JSP Calculator

201222_calc.png <img src="201222_calc.png">

#### GET, input, index.jsp
``` jsp
        <form method="GET" action="Calc">
            <br> Enter First Number here <input type="text" name="num1"/> <br>
            <br> Enter Second Number here <input type="text" name="num2"/> 
            <br> <br>Click an operation  
            &nbsp;&nbsp;&nbsp;<input type="submit" name="op" value="+"/> 
            &nbsp;&nbsp;&nbsp;<input type="submit" name="op" value="-"/> 
            &nbsp;&nbsp;&nbsp;<input type="submit" name="op" value="*"/> 
            &nbsp;&nbsp;&nbsp;<input type="submit" name="op" value="/"/> <br><br>
            <br> Results are here .....<%= request.getAttribute("result") == null ? 0 : request.getAttribute("result")%>
```
#### request, setAttribute, Calc.java(servlet)
``` java
public class Calc extends HttpServlet {
    ...
        String n1 = request.getParameter("num1");
        String n2 = request.getParameter("num2");
        String op = request.getParameter("op");

        int i = (n1 == null) || (n1.equals("")) ? 0 : Integer.parseInt(n1);
        int j = (n2 == null) || (n2.equals("")) ? 0 : Integer.parseInt(n2);
        int result = 0;
        if (op.equals("+")) {
            result = i + j;
        } else if (op.equals("-")) {
            result = i - j;
        } else if (op.equals("*")) {
            result = i * j;
        } else if (op.equals("/")) {
            result = i / j;
        }
        
        request.setAttribute("result", result);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }
```
