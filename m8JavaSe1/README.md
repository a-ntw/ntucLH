### Assessment

### Unified Modelling Language
201102 
#### ClassName, Field, Methods
<img src="img/201102UML-drawio.PNG"> 

---
### UML use case diagram
201103
#### Online banking application has two primary operations:
1. Manage accounts that consist of submodules "opening account" and "transfer funds".
2. Generate history transaction report that consist of "monthly transaction report by accounts" and "monthly transaction reports by date".

Two groups will use the applications:
1. Bank's customer who will be responsible for "manage account" and "generate history transaction"
2. Bank's teller who is responsible for "manage account"

With the above scenario, create uml (Unified Modelling Language) use case diagram, that show relationship both groups and application. 

<img src="img/201103CaseSenario.PNG">

---
### java project application
201104
#### Create a java project application with following specifications:
1. create java application name Customer.java
2. in the Customer.java, create the following variables:
   - name of type String
   - address of type String with a default value of "-Singapore-"
   - gender of type char
   - age of type int with default value of 0
3. In the Customer.java, create a method name "printCustomerInf" 
   that displays the value of "name", "address", "gender" and "age"
4. create a unit test / main class java application name "CustomerTest.java"
5. In the "CustomerTest.java", instantiate the Customer class and 
    call the method "printCustomerInf".
6. Compile and run the CustomerTest application.
7. Place breakpoint at where you instantiate the Customer object
8. Show the variables of Customer objec

<img src="img/201104Java-A.PNG"> 
<img src="img/201104Java-B.PNG"> 
<img src="img/201104Java-C.PNG"> 

console
``` console
run:
Name: George Yeo
Address: USA
Gender: M
Age: 35
BUILD SUCCESSFUL (total time: 0 seconds)
```
Customer.java
``` java
package ntuc;

public class Customer {
    public String name;
    public String address = "-Singapore-"; // default value
    public char gender;
    public int age = 0;
    
    // method to display the value
    public void printCustomerinf() {
        System.out.println("Name: " + name + 
                "\nAddress: " + address + 
                "\nGender: " + gender + 
                "\nAge: " + age);
    }
    
}
```
CustomerTest.java
``` java
package ntuc;

public class CustomerTest {

    public static void main(String[] args) {
        // instantiate new customer 
        Customer cust1 = new Customer();
        
        cust1.name = "George Yeo";
        cust1.address = "USA";
        cust1.age = 35;
        cust1.gender = '\u004D'; //  Unicode of  'M'
        
        // call the customer.java method to display value
        cust1.printCustomerinf();
    }
}
```

---
### Console Application
201105
#### Create a console application with following specification:  
1. Create a java application name InputFromConsole.java
2. Prompt user to input 2 words. Input "Hello" and "thankyou"
3. Obtain the entered string and get the total length of 2 words.
4. Display the inputs and length of each word and the total length of 2 words.
5. Compile and run the application.

<img src="img/201105JavaConsole.PNG"> 

console
``` console
antw@Mac-mini ~ % ls                                                              
Applications    Downloads       Music           ntuc                              
antw@Mac-mini m8JavaSe1 % javac InputFromConsole.java                             
antw@Mac-mini m8JavaSe1 % java InputFromConsole                                   
Please key in the first word: Hello                                               
Please key in the second word: thankyou                                           
The length of 'Hello' is 5 chars.                                                 
The length of 'thankyou' is 8 chars.                                              
The total length of 'Hello' and 'thankyou' is 13 chars.                           
antw@Mac-mini m8JavaSe1 %  
```

InputFrontConsole.java
``` java
import java.util.Scanner;

public class InputFromConsole {

    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);
        
        System.out.print("Please key in the first word: ");
        String s1 = scn.next();
        
        System.out.print("Please key in the second word: ");
        String s2 = scn.next();
        
        int lgth1 = s1.length();
        int lgth2 = s2.length();
        
        System.out.format("The length of '%s' is %d chars.\n", s1, lgth1);
        System.out.format("The length of '%s' is %d chars.\n", s2, lgth2);
        
        System.out.format( "The total length of '%s' and '%s' is %d chars.\n",
                s1, s2, (lgth1 + lgth2));
       
    }
}
```

---
