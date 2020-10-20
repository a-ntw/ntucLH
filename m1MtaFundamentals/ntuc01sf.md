SGUS - MTA: Software Development Fundamentals
===
[top]: topOfThePage

#### Microsoft Visual Studio 2008
### Lesson Keywords
* [LESSON 1: Introduction to Programming](#lesson-1)
* [LESSON 2: Introduction to Object- Oriented Programming](#lesson-2)
* [LESSON 3 : Understanding General Software Development](#lesson-3)
* [LESSON 4 : Understanding Web Applications](#lesson-4)
* [LESSON 5 : Understanding Desktop Applications](#lesson-5)
* [LESSON 6 : Understanding Databases](#lesson-6)

### Practice
* [AddNumbers.sln](#addnumberssln)
* [CompareNumbers.sln](#comparenumberssln)
* [Loops.sln](#loopssln)
* [Scenario 1-1](#scenario-1-1)
* [Exception_Handling.sln](#exception_handlingsln)
* [WebApplication1](#webapplication1)
* [Windows Form](#windows-form)
* [Debug examples, Test, Flow-Chart](#debug-examples)
* [parctice1.sln](#parctice1sln)
* [**Assessment**](#assessment)

## Keywords
##### Lesson 1
## Lesson 1: Introduction to Programming
### Understanding Computer Programming - Understand computer storage and data types.
- Algorithms
    - Flowcharts
    - Decision Tables
    - C# - .NEY Framework
        - start Visual Studio
            - File > New Project > Visual C# Console Application
            - Debud > Start Without Debugging (Ctrl-F5)
            - Every C# statement must end with a semicolon (;).
            - The Main method must be declared as static. A static method is callable on a class even when no instance of the class has been created.
            
*CERTIFICATION READY*: Do you understand the core elements of programming, such as variables, data types, operators, and methods? 1.1

### Understanding Decision Structures 
- Variables, Constants, Data Types, Arrays, Operators
    - Unary operators - ex ++x, x++, isEven
    - Binary operators - ex x + y, x > y
    - Ternary operators - ex ?:
- Methods
    - Methods are code blocks containing a series of statements. Methods can receive input via arguments and can return a value to the caller.
- Decision Structures
    - If statement, If-else statement, Switch statement   
*CERTIFICATION READY*: Do you understand computer decision structures, such as branching and repetition .2

### Understanding Repetition Structures 
- While loop, D0-while loop, For loop, Foreach loop
- Recursion   

*CERTIFICATION READY*: an you identify the appropriate methods for handling repetition? 1.3

### Understanding Exception Handling
- The .NET Framework supports standard exception handling to raise and handle runtime errors. In this section, you’ll learn how to use the try, catch, and finally keywords to handle exceptions.
- Try-Catch-Finally   
:CERTIFICATION READY*: Do you understand how to handle errors in your programs? 1.4

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* An algorithm is a set of ordered and finite steps to solve a given problem. You may find it useful to express an algorithm as a flowchart or a decision table before you develop a formal computer program.
* The C# programming language is a part of the .NET Framework and benefits from the runtime support and class libraries provided by the .NET Framework.
* Main is a special method because it also serves as an entry point to a program. When the runtime executes a program, it always starts at the Main method.
* Variables in C# are placeholders used to store values. A variable has a name and a data type. A variable’s data type determines what value it can contain and what kind of operations may be performed on it.
* Operators are symbols, such as +, -, *, and /, that specify which operation to perform on one or more operands before returning a result.
* If-else statements allow a program to perform one action if the Boolean expression evaluates to true and a different action if the Boolean expression evaluates to false.
* The switch statement allows multi-way branching. In many cases, using a switch statement can simplify a complex combination of if-else statements.
* C# has four different control structures that allow programs to perform repetitive tasks: the while loop, the do-while loop, the for loop, and the foreach loop.
* The while and do-while loops repeatedly execute a block of statements until a specified Boolean expression evaluates to false. The do-while loop tests the condition at the bottom of the loop.
* The for loop combines the three elements of iteration—the initialization statement, the termination condition, and the increment/decrement statement—into more readable code.
* The foreach loop is useful for iterating through the elements of a collection.
* Recursion is a programming technique that causes a method to call itself in order to compute a result.
* The .NET Framework supports standard exception handling to raise and handle runtime errors. To handle exceptions, place the code that throws exceptions inside a try block, and place the code that handles the exceptions inside a catch block.
* The finally block is used in association with the try block. The finally block is always executed regardless of whether an exception is thrown. The finally block is often used to write clean-up code.

---
[:top: Top](#top)
##### LESSON 2
## LESSON 2 : Introduction to Object- Oriented Programming
### Understanding Objects - Understand the fundamentals of classes.
- Object-oriented programming is a programming technique that makes use of objects.
- Ojects are self-contained data structures that consist of properties, methods, and events. 
    - Properties specify the data represented by an object, 
    - methods specify an object’s behavior, and 
    - events provide communication between objects.
- Class
    - A class is the template from which individual objects are created.
- method
    - A method is a block of code containing a series of statements.
        - A method’s name, its parameter list, and the order of data types of the parameters are collectively recognized as the method’s signature.
        - A method signature must be unique within a class.
- Constructors
    - Constructors are used to initialize the data members of the object.
        - A constructor that takes no arguments is called the default constructor.
- Object
    - Objects are created from the templates defined by classes.
- Properties
    - Classes and objects are different. 
        - A class defines the template for an object but is not an object itself. On the other hand,
        - an object is a concrete instance of a class but is not a class itself.
    - Properties allow you to access class data in a safe and flexible way.
        - A property has two accessors, get and set
- Auto-implemented properties
- The *This* keyword
    - The this keyword can be used to access members from within constructors, instance methods, and accessors of instance properties.
- Delegates
    - Delegates are special types that are used to encapsulate a method with a specific signature.
- Events
    - Events are a way for a class to notify other classes or objects when something of interest happens. 
    - The class that sends the notification is called a publisher of the event. 
    - The class that receives the notification is called the subscriber of the event.
- Namespaces
    - A namespace allows you to organize code and create unique class names.
- Static Members
    - Static members belong to a class itself rather than individual objects.   

*CERTIFICATION READY*: Do you understand the fundamentals of classes? 2.1

### Understanding Values and References - Understand computer storage and data types
- A value type directly stores a value, whereas a reference type only stores a reference to an actual value.
- Structs
    - The keyword struct is used to create user-defined types that consist of small groups of related fields. Structs are value types—as opposed to classes, which are reference types.
 - Memory Allocation
    - Structs are mostly used to create simple types.
    - If you find yourself creating a very complex struct, you should consider using a class instead.
*CERTIFICATION READY*: Do you understand data types and memory allocation? 1.1

### Understanding Encapsulation
- Encapsulation is an information-hiding mechanism that makes code easy to maintain and understand.
- Access Modifiers
    - Access modifiers control where a type or type member can be used.

*CERTIFICATION READY*: Do you understand encapsulation? 2.4    

### Understanding Inheritance
- Inheritance
    - Inheritance is a feature of object-oriented programming that allows you to develop a class once, and then reuse that code over and over as the basis of new classes. 
    - Inheritance enables you to create new classes that reuse, extend, and modify the functionality defined in existing classes. 
    - The class that inherits the functionality is called a derived class, and
    - the class whose functionality is inherited is called a base class. 
    - A derived class inherits all the functionality of the base class and can also define additional features that make it different from the base class.
- Abstract and Sealed Classes
    - The abstract classes provide a common definition of a base class that can be shared by multiple derived classes. 
    - The sealed classes, on the other hand, provide complete functionality but cannot be used as base classes.
- Inheriting from the Object Class
    - The Object class is the ultimate base class of all the classes in the .NET Framework.
- Casting between Types
    - In C#, the runtime allows you to cast an object to any of its base types.
- using the *IS* operator
- using the *AS* operator

*CERTIFICATION READY*: Do you understand inheritance? 2.2

### Understanding Polymorphism
- Polymorphism is the ability of derived classes to share common functionality with base classes but still define their own unique behavior.
- the *Override* and *New* Keywords
    - The override keyword replaces a base class member in a derived class. 
    - The new keyword creates a new member of the same name in the derived class and hides the base class implementation.

*CERTIFICATION READY*: Do you understand polymorphism? 2.3

### Understanding Interfaces
- Interfaces are used to establish contracts through which objects can interact with each other without knowing the implementation details.

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* Objected-oriented programming is a programming technique that makes use of objects.
    * Objects are self-contained data structures that consist of properties, methods, and events.
    * Properties specify the data represented by an object, methods specify an object’s behavior, and       * events provide communication between the objects.
* A class is the template from which individual objects are created.
* Constructors are used to initialize the data members of an object.
* The *this* keyword can be used to access members from within constructors, instance methods, and the accessors of instance properties.
* Delegates are special types that are used to encapsulate a method with a specific signature.
* Events are a way for a class to notify other classes or objects when something of interest happens. The class that sends a notification is called the publisher of the event, and the class that receives the notification is called the subscriber of the event.
* Namespaces allow you to organize code and create unique class names.
* The *static* keyword is used to declare members that do not belong to individual objects but to a class itself.
* A *value* type directly stores a value, whereas a *reference* type only stores a reference to an actual value.
* The keyword *struct* is used to create user-defined types that consist of small groups of related fields. Structs are value types, whereas classes are reference types.
* Encapsulation is a mechanism to restrict access to a class or class members in order to hide design decisions that are likely to change. Encapsulation provides class designers with the flexibility to change a section of code as needed without changing all other code that makes use of that code.
* An access modifier specifies what region of the code will have access to a field. For example, a public access modifier does not limit access, but a private access modifier limits access within the class in which the field is defined.
* Inheritance enables you to create new classes that reuse, extend, and modify the functionality defined in existing classes. The class that inherits functionality is called a derived class, and the class whose functionality is inherited is called a base class.
* Polymorphism is the ability of derived classes to share common functionality with base classes but still define their own unique behavior.
* The override keyword replaces a base-class member in a derived class. The new keyword creates a new member with the same name in the derived class and hides the base-class implementation.

---
[:top: Top](#top)
##### LESSON 3
## LESSON 3 : Understanding General Software Development
### Application Lifecycle Management
- Application lifecycle management (ALM) is the set of activities that revolve around a new software product, from its inception to when the product matures and perhaps retires.
- RdDtm
- Requirements Analysis
	- Requirements analysis is the process of determining the detailed business requirements for a new software system.
- Design Process
	- The design process is used to create plans, models, and architecture for how the software will be implemented.
	    - Archtect
	    - User-experience designer
- Software Development
	- The software development activity involves implementing design by creating software code, databases, and other related content.
	    - Developers
	    - Databaseadminstrators (DBMs)
	    - Technical writers
	    - Content developers
- Software Testing
	- Software testing verifies that the implementation matches the requirements of the system.
- Release Management
	- The release management activity is used to manage the deployment, delivery, and support of software releases.
	    - Release manager
	    - Operation staff
	    - Technical support staff

*CERTIFICATION READY*: Do you understand application lifecycle management and its activities? 3.1
    
### Understanding Testing
- Software testing is the process of verifying software against its requirements. Testing takes place after most development work is completed.
- Testing Methods
    - Software testing methods are generally divided into two categories: white-box and black-box testing.
        - Black-box testing
        - White-box testing
-Testing Levels
    - Testing is performed at various phases of the application development lifecycle. Different testing levels specify where in the lifecycle a particular test takes place, as well as what kind of test is being performed.
    - Five distinct levels of testing exist:
        - Unit testing: verifies the functionality of a unit of code.
        - Integration testing: assesses the interface between software components.
        - System testing: is the overall testing of the software system.
        - Acceptance testing: This level of testing is often performed by the customers themselves
            - alpha testing
            - beta testing
        - Regression testing: With every new fix, software testers usually run a battery of regression tests to make sure that each functionality that was already known to work correctly is still working.
    
*CERTIFICATION READY*: Do you understand the various software testing methods? 3.1

### Understanding Data Structures
- Data structures are techniques for organizing and storing data in computer memory.
- How the data is stored affects how the data is retrieved and manipulated. Understanding a data structure involves not only understanding the storage pattern, but also knowing what methods are used to create, access, and manipulate the data structure.
- Arrays
    - An array is a collection of items stored in a contiguous memory location and addressed using one or more indices.
    - Common operations
        - Allocation
        - Access
- Queues
    - A queue is a collection of items in which the first item added to the collection is the first one to be removed. (FILO)
    - Common operations: 
        - Enqueue
        - Dequeue
        - Peek 
        - Contains
- Stacks
    - A stack is a collection of items in which the last item added to the collection is the first one to be removed. (LIFO)
    - Common operations
        - Push
        - Pop
        - Peek
        - Contains
- Linked Lists
    - A linked list is a collection of nodes arranged so that each node contains a **link** to the next node in the sequence.
    - Coomon operations
        - Add
        - Remove
        - Find

*CERTIFICATION READY*: Do you understand the common data structures? 3.2
    
### Understanding Sorting Algorithms
- Sorting algorithms, such as BubbleSort and QuickSort, arrange items in a list in a particular order. Understanding sorting algorithms can help you understand, analyze, and compare different methods of problem solving.
- BubbleSort
    - The BubbleSort algorithm uses a series of **comparison and swap** operations to arrange the elements of a list in the correct order.
- QuickSort
    - The QuickSort algorithm uses the **partitioning and comparison** operations to arrange the elements of a list in the correct order.

*CERTIFICATION READY*: Do you understand common sorting algorithms? 3.3
    

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* Application lifecycle management (ALM) refers to the various activities that revolve around a new software product from its inception to the time when it matures and perhaps retires.
* Software testing is the process of verifying software against its requirements. Testing takes place after most developmental work is complete.
* Data structures are techniques for organizing and storing data in computer memory. How the data is stored affects how it is retrieved and manipulated. Understanding a data structure involves understanding not only the storage pattern, but also the methods used to create, access, and manipulate the structure.
* An array is a collection of items of the same data type that are stored in a contiguous memory location and addressed using one or more indices.
* A queue is a collection of items in which the first item added to the collection is the first one to be removed.
* A stack is a collection of items in which the last item added to the collection is the first one to be removed.
* A linked list is a collection of nodes arranged in such a way that each node contains a link to the next node in the sequence.
* The BubbleSort algorithm uses a series of comparison and swap operations to arrange the elements of a list in the correct order.
* The QuickSort algorithm uses partitioning and comparison operations to arrange the elements of a list in the correct order.

---
[:top: Top](#top)
##### LESSON 4
## LESSON 4 : Understanding Web Applications
### Understanding Web Page Development
- A Web page is a document that is served over the World Wide Web (WWW) and can be displayed by a Web browser. Web pages are developed using the Hypertext Markup Language (HTML) and are stored on a Web server. Web browsers download the requested HTML from the Web server and render it on the user’s screen.
- HTML
    - Hypertext Markup Language (HTML) is the language used by Web servers and browsers to describe a Web page.
        - HTML consists of a set of tags (also called as HTML elements) that define the structure and content of a page.
        - An HTML page has two distinct parts: a header and a body.
        - the <img> tag specifies additional attributes.
        -  `<a href="http:`//en.wikipedia.org/wiki/Mimas_(moon)">Sa- turn’smoon <``/a>`
        - `<a>` is the anchor tag, which is used to create hyperl- inks on a Web page. 
        - The href attribute associated with this tag specifies the target URL, and the text within the anchor tag is that which is displayed as a link.
   
- Cascading Style Sheets
    - Cascading style sheets (CSS) enable you to store a Web page’s style and formatting information separate from the HTML code. This separation makes it easier to update the look and feel of your Web site. Visual Studio includes tools to build and preview your style sheets.
- JavaScript   
    - JavaScript is a client-side scripting language that runs inside Web browsers to help create far more interactive Web pages than are possible with only HTML. JavaScript is used in millions of Web pages and is supported by all modern Web browsers.
    - JavaScript is used to make Web sites more responsive and Web pages more interactive. JavaScript accomplishes this by executing the code on the client side (the Web browser) and by minimizing unnecessary round-trips to and from the Web server.
- Client-Side vs. Server-Side Programming    
    - Whether a program is client-side or server-side depends on where the program is ultimately executed.

*CERTIFICATION READY*: Do you understand how to use HTML, JavaScript, and CSS for Web page development? 4.1

### Understanding ASP.NET Application Development - Understand Microsoft ASP.NET Web application development.
- ASP.NET is the part of the .NET Framework that enables you to develop programmable Web forms and Web services. As with any .NET Framework application, you can develop ASP.NET applications in any language that is compatible with the .NET common language runtime, including Visual Basic and C#.
- ASP.NET Page Life Cycle and Event Model
    - During its execution, an ASP.NET page passes through many distinct stages of processing. Each of these stages itself goes through specific processing steps, such as initialization, loading, running event-handler code, and rendering.
    - Table 4-1 Important stages in the ASP.NET page life cycle. Stage:
        - Page request
        - Start
        - Initialization
        - Load
        - Postback event handling
        - Prerenderin
        - Rendering
        - Unload   
    - UNDERSTAND THE ASP.NET PAGE LIFE CYCLE
        - In the HTML markup for the page (WebForm1.aspx), make sure that the AutoEventWireup attribute for the @Page directive is set to true:
        - `<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="PageEvents.WebForm1" %>`
        - The @Page directive specifies various attributes that control how ASP.NET will render a page
- State Management
    -  is the process of maintaining state for a Web page across round-trips. The values of the variables and controls collectively make up the state of a Web page.
    - State management is an important issue for Web applications because of the disconnected nature of HTTP. There are both client-side and server-side techniques available for state management.
    - CLIENT-SIDE STATE MANAGEMENT
        - Query strings
            - state is maintained by putting the data as a set of key-value pairs in the query string portion of a page URL
        - Cookies
            - Cookies are commonly employed to store user preferences and shopping cart contents and to give users a personalized browsing experience on subsequent visits to a Web page.
        - Hidden fields
            - Hidden fields can be created by using the <input type=“hidden”> HTML element. The ASP.NET HTML Server control HtmlInputHidden also maps to this HTML element.
        - ViewState
            - ViewState is the mechanism ASP.NET uses to maintain the state of controls across page postbacks.
            - ViewState is enabled in an ASP.NET application. You can disable ViewState at the level of a control by setting the EnableViewState property of the control to false
    - SERVER-SIDE STATE MANAGEMENT
        - ASP.NET supports server-side state management at two levels:
            - Session state
                -  The ability to uniquely identify and relate requests can be used to store session-specific data that is also known as the session state of the Web application. 
            - Application state
                - Application state is used to store data that is used throughout an application. Application state can be easily accessed through the Application property of the Page class

*CERTIFICATION READY*: Do you understand the basics of Microsoft ASP.NET Web application development? 4.2

### Understanding IIS Web Hosting - Understand Web hosting.
- Web hosting involves setting up a Web server with correct code files and settings so that remote users can successfully access a Web application.
- ASP.NET applications must be deployed on an Internet Information Services (IIS) Web server. IIS is an integral part of Windows Server operating systems and provides functionality for hosting Web site
- Internet Information Services
    - Internet Information Services (IIS) is a Web server for hosting Web applications on the Windows operating system. An IIS server uses the concepts of sites, applications, and virtual directories.
- Creating Virtual Directories and Web Sites
    - A Web site is a container of applications and virtual directories. A virtual directory is an alias that maps to a physical directory on the Web server.
    - When IIS receives a request for such a URL, it maps the virtual directory to the physical location of the files. 
- Deploying Web Applications
    - Deployment of simple Web sites is accomplished by copying the files to the correct location. To install a complex Web site, you may need to use Windows Installer.
    - Using xcopy or FTP
    - Using Windows Installe

*CERTIFICATION READY*: Do you understand the basics of Web hosting with the IIS Web server? 4.3

### Understanding Web Services Development
- A Web service is a software component that can be accessed over a network using standard network protocols such as HTTP. Web services are described using the Web services description language (WSDL).
    - Q9: Each method that is exposed from the Web service also needs to have a WebMethod attribute. The methods marked with **WebMethod** attributes are also known as Web methods
- Introducing Simple Object Access Protocol (SOAP)
    - SOAP is the protocol for exchanging structured information in a Web service communication between two remote computers.
    - Q10: SOAP relies on **XML** as its message format and uses **HTTP** for message transmission.
- Introducing WSDL, Web services description language
    - WSDL is an XML-based language for describing Web services.
- Creating Web Services
    -  each class that is exposed as an XML Web service needs to have a WebService attribute.
    - Each method that is exposed from the Web service also needs to have a WebMethod attribute. The methods marked with WebMethod attributes are also known as Web methods. 
- Consuming Web Services
    - to call a Web service programmatically from within an ASP.NET client application.
    - Visual Studio creates a local proxy that represents the remote service. The proxy simplifies communication with the Web service by accepting messages, forwarding them to the Web service, and returning results from the Web service.


*CERTIFICATION READY*: Do you understand the basics of Web services development? 4.4

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* A Web page is a document that is served over the World Wide Web (WWW) and can be displayed by a Web browser.
* Hypertext Markup Language (HTML) is the language used by Web servers and browsers to describe a Web page.
* Cascading style sheets (CSS) enable you to store style and formatting information separate from HTML code. This separation makes it easy to update a Web site. Visual Studio includes tools to build and preview your style sheets.
* JavaScript is a client-side scripting language that runs inside a Web browser to help create far more interactive Web pages than are possible with only HTML.
* Client-side state management techniques such as query strings, cookies, hidden fields, and ViewState use HTML and the capabilities of Web browsers to store state information on client computers.
* Server-side state management techniques such as session state and application state use server resources for state management.
* Internet Information Services (IIS) is a Web server for hosting Web applications on the Windows operating system. An IIS server uses the concepts of sites, applications, and virtual directories.
* Web services provide a way to invoke remote objects using standard technologies such as XML and HTTP.
* SOAP is the protocol that defines how remote computers exchange messages as part of Web service communication. SOAP relies on XML for its message format and uses HTTP for message transmission.
* WSDL provides a standard by which a Web service can tell its client what kinds of messages it will accept and what results will be returned.

---
[:top: Top](#top)
##### LESSON 5
## LESSON 5 : Understanding Desktop Applications
### Understanding Objects - Understanding Windows Forms Applications
- Q: **Windows Forms** applications are smart client applications consisting of one or more forms that display a visual interface to the user. These applications integrate well with the operating system, use connected devices, and can work whether connected to the Internet or not.
    - Windows Form Event Model
        - Event handling plays a key role in user interface-based programming; through event handling, you respond to various events that are fired as a result of user actions and thus make programs interactive. 
        - The Windows Forms event model uses .NET Framework delegates to bind events to their respective event handlers.
        - Q: A delegate can be bound to any method whose signature matches that of the **event handler**.
        - Q:  the .NET Framework supports multicast delegates in which a **delegate** can be bound to more than one method, thus allowing one-to-many notifications when an event is fired.
    - Using Visual Inheritance
        - Q: **Visual inheritance** allows you to reuse existing functionality and layout for Windows Forms.
    - Understanding Multiple Document Interface (MDI) Applications
        * Q: **Multiple Document Interface (MDI)** applications are applications in which multiple child windows reside under a single parent window.

*CERTIFICATION READY*: Do you understand how to develop Windows Forms applications? 5.1

### Understanding Values and References - Understanding Console-Based Applications
- Q: **Console-based** applications do not have a graphical user interface and use a text-mode console window to interact with the user. These applications are best suited for tasks that require minimal or no user interface.

*CERTIFICATION READY*: Do you understand how to develop console-based applications? 5.2

### Understanding Encapsulation - Understanding Windows Services
- Q: A **Windows service** is an application that runs in the background and does not have any user interface.
- The nature of Windows services make them ideal for creating long-running programs that run in the background and do not directly provide any user interaction. 
- A Windows service can be started, paused, restarted, and stopped. 
- A Windows service can also be set to start automatically when the computer is started.    
- Creatng a Windows Service
    - All Windows services must derive from the ServiceBase class. 
    - This base class provides the basic structure and functionality for creating a Windows service. 
    - You can override the base class methods OnStart, OnStop, OnPause, and OnContinue to add your own custom logic that executes in response to changes in service states.
    - CREATE A WINDOWS SERVICE
        - Q: set the Source property of the event log component to the name of the event source. The Log property of the event log component, eventLog1, is used to specify the event log used to record the messages
    - ADD AN INSTALLER TO A WINDOWS SERVICE
        - When you add an installer to a Windows Service project, the ServiceProcessInstaller and the ServiceInstaller classes are added to the project. 
        - The ServiceProcessInstaller class performs installation tasks that are common to all the Windows services in an application. 
         - This includes setting the login account for the Windows service. 
         - The ServiceInstaller class, on the other hand, performs the installation tasks that are specific to a single Windows service, such as setting the ServiceName and StartType.
         - Q: The Account property of the ServiceProcessInstaller class specifies the type of account under which the services run. 
         - The Account property is of the type ServiceAccount enumeration where the possible values are LocalService, LocalSystem, NetworkService, and User. 
         - Q: The LocalSystem value specifies a highly privileged account, whereas the **LocalService** account acts as a nonprivileged user.
         - Q: Installing a Windows service requires access to Windows Registry. Therefore, be sure to run **installUtil.exe** as an administrator.
    
*CERTIFICATION READY*: Do you understand how to develop Windows services? 5.3

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* A Windows Form is a visual surface that can display a variety of controls, such as text boxes, buttons, and menus. Visual Studio provides a drag-and-drop Windows Forms designer that you can use to create applications.
* In Windows Forms, each form and control exposes a predefined set of events. When an event occurs, the code in the associated event handler is invoked. The Windows Forms event model uses .NET Framework delegates to bind events to their respective event handlers.
* Visual inheritance allows you to reuse existing functionality and layout for Windows Forms.
* Multiple document interface (MDI) applications are applications in which multiple child windows reside under a single parent window.
* Console-based applications do not have a graphical user interface and use a text-mode console window to interact with the user. These applications are best suited for tasks that require minimal or no user interface.
* Windows services are ideal for creating long-running applications that run in the background and do not have any user interface.
* You can create Windows services using Visual Studio’s Windows Services template.
* Before a Windows service can be used, it must be installed in Windows Registry. To do this, add the Installer component to the Windows Service Application. This will allow you to install the Windows service using an installation tool such as InstallUtil.exe.

---
[:top: Top](#top)
##### LESSON 6
## LESSON 6 : Understanding Databases
### Understanding Objects - Understand relational database management systems
- A relational database is a collection of interrelated data based on the relational model developed by E. F. Codd. This model defines distinct data entities, their attributes, and relationships among entities.
- Understanding Databases
	- A database is an organized collection of interrelated data that is managed as a single unit.
	- A database management system (DBMS), on the other hand, is software that organizes databases and provides features such as storage, data access, security, backup, etc. Examples of popular DBMSs include Microsoft SQL Server, Microsoft Access, Oracle, and MySql.
	- DBMSs based on relational models are called relational DBMSs (RDBMSs). SQL Server, Access, Oracle, and MySql are all RDBMSs.
	- Relational DBMSs use Structured Query Language (SQL) to retrieve and manipulate data.
- Understanding Relational Database Concepts
	- A relational database organizes data in two-dimensional tables consisting of columns and rows.
- Understanding Relational Database Design
	- Relational database design is the process of determining the appropriate relational database structure to satisfy business requirements.
	- design a database, one of the guiding principles is to ensure database integrity.
	- The database design process consists of the following steps:
		- Develop a mission statement for the database
		- Determine the data that needs to be store
		- Divide the data into tables and columns
		- Choose primary keys
		- Identify relationships
		- Apply the normalization process
- Understanding Entity-Relationship Diagrams
	- Entity-relationship diagrams (ERDs) are used to model entities, their attributes, and the relationships among entities. Entity-relationship diagrams can help you determine what data needs to be stored in a database.
	- The basic building blocks of an ERD are **entity, attribute, and relationship**
	- ERDs use certain design conventions. In particular:
		- A rectangle represents an entity set.
		- An ellipse represents an attribute.
		- A diamond represents a relationship set.
		- Solid lines link entity sets to relationship sets and entity sets to attributes.
	- MAPPING ERDs TO A RELATIONAL DATABASE
- Understanding Data Normalization
	- The process of data normalization ensures that a database design is free of any problems that could lead to loss of data integrity.
	- suffers from three problems
		- Insert anomaly
		- Delete anomaly
		- Update anomaly
	- UNDERSTANDING THE FIRST NORMAL FORM (1NF)
		- Q: In order for a table to be in the first normal form (**1NF**), none of the columns in the table should have multiple values in the same row of data. 
	- UNDERSTANDING THE SECOND NORMAL FORM (2NF)
		-  it must first meet the requirements for 1NF
		-  **2NF** requires that all non-key columns are functionally dependent on the entire primary key.
		- 2NF only applies to tables that have composite primary keys
	- UNDERSTANDING THE THIRD NORMAL FORM (3NF)
		- The third normal form (**3NF**) requires that 2NF is met and that there is no functional dependency between non-key attributes
		-each non-key attribute should be dependent on only the primary key and nothing else

*CERTIFICATION READY*: Do you understand the basics of relational database management systems? 6.1

### Understanding Values and References - Understand database query methods.
- Data is at the core of many business applications, and, as a developer, you will likely spend a lot of time working on data-related tasks. In this section, you will learn how to use Structured Query Language (SQL) and SQL Server-stored procedures to select, insert, update, and delete data.
- SQL is an ANSI (American National Standards Institute) standard, but different database vendors have implemented their own extensions to standard SQL. Microsoft SQL Server’s implementation of SQL is called Transact-SQL (T-SQL).
- Working with SQL Queries
	- SELECT, INSERT, UPDATE, and DELETE statements are the four main types of SQL statements used to manipulate SQL Server data.
	- Conneecting to a SQL server Database
	- CONNECT TO THE NORTHWIND DATABASE
	- RUNNING SQL QUERIES
		- Visual Studio Integrated Development Environment (IDE)
		- C# application
		- SQL Query Analyze
		- osql command prompt utility
	- SELECTING DATA
		- The SELECT statement is used to retrieve data from one or more database tables.
		- Each of these lines of code in the SELECT statement is called a **clause**. The SELECT and FROM clauses are required, but the rest are optional.
- Working with Stored Procedures	
	- A stored procedure is a set of SQL statements that is stored in a database. Stored procedures can be used by multiple applications.
	- CREATING AND RUNNING A STORED PROCEDURE
	- WORKING WITH PARAMETERIZED STORED PROCEDURES
		- Parameterized stored procedures allow you to pass runtime arguments to the SQL Server.
	- RUN PARAMETERIZED STORED PROCEDURES FROM C#
		- The object used with the *using* statement must implement the **IDisposable** interface.
	
*CERTIFICATION READY*: Do you understand the various database query methods? 6.2

*CERTIFICATION READY*: Do you understand database connection methods? 6.3

### Understanding Encapsulation - Understand database connection methods.
- Business applications may require data in various formats. For example, you may need to work with flat files, XML files, and in-memory objects.
- Working with Flat Files
	- A flat file is a database table that is stored inside a stand-alone disk file.
		- File-based input and output in the .NET Framework revolves around the concept of streams and backing store.
		- A stream is a flow of raw data, and a backing store is the source or destination of the stream.
		- A backing store might be a disk file, memory, network connection, etc.
		- Although binary files are not human-readable like text files, they are capable of storing a variety of data, such as images, sounds, video, etc. 
			- The BinaryReader and BinaryWriter classes provide you with an easy way to manipulate binary files.
- Working with XML
	- Extensible Markup Language (XML) is a text-based format for representing structured data.
	- XML consists of tags (contained within angle brackets) and data. Tags always appear in pairs, with each opening tag matched by a closing tag.
	- The first line of an XML document is the XML declaration: `<?xml version="1.0" encoding="utf-8"?>`
	- XML tags that begin with <? are called *processing instructions*. This processing instruction tells us that the document is an XML document, conforms to the XML version 1.0 specifications, and uses the UTF-8 character set for its data elements.
	- An opening tag and closing tag together with their contents is called an *element*. For example, the following is a single XML element from the above document: `<Phone>030-0074321</Phone>`
- Working with DataSet
	- A DataSet is an in-memory representation of relational data.

*CERTIFICATION READY*: Do you understand the various database connection methods? 6.3

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* A relational database organizes information into tables. A table is a list of rows and columns.
* Relational database design is the process of determining the appropriate relational database structure to satisfy the business requirements.
* Entity-relationship diagrams are used to model the entities, their attributes, and the relationships among entities. The entity-relationship diagrams can help you in determine what data needs to be stored in a database.
* The process of data normalization ensures that a database design is free of any problems that could lead to loss of data integrity. Most design issues can be resolved by ensuring that the tables satisfy the requirements of the third normal form.
* The Structured Query Language (SQL) provides statements such as SELECT, INSERT, UPDATE, and DELETE to work with relational data.
* A stored procedure is a set of SQL statements that is stored in a database. Stored procedures can be used by multiple applications.
* The XmlReader and XmlWriter classes provide a fast, noncached, forward-only way to read or write XML data. The XmlDocument class is an in-memory representation of XML data and allows navigation and editing of the XML document.
* The DataSet class represents an in-memory representation of relational data. The DataAdapter class acts as a bridge between the data source and the DataSet. The DataAdapter stores the data connection and data commands needed to connect to the data source.



---
[:top: Top](#top)
### AddNumbers.sln
``` c#
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AddNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            // ask the user for number
            Console.WriteLine("Please enter a number");
            string firstNumber = Console.ReadLine();
            int N1 = Convert.ToInt32(firstNumber);
            
            // ask user for another number
            Console.WriteLine("Please enter another number");
            string secondNumber = Console.ReadLine();
            int N2 = Convert.ToInt32(secondNumber);
            
            // add the numbers
            int sum = N1 + N2;
            Console.WriteLine("The sum is " + sum);

        }
    }
}
```
---
### CompareNumbers.sln
``` c#
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CompareNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World");
            // comments
            // declaring variables
            int x = 100;
            int y = 100;
            
            // ask the user for values
            Console.WriteLine("Enter the first number");
            string firstNumber = Console.ReadLine();
            x = Convert.ToInt32(firstNumber);
            
            // ask user for another number
            Console.WriteLine("Enter the second number");
            string secondNumber = Console.ReadLine();
            y = Convert.ToInt32(secondNumber);
            
            // compare the numbers
            if (x > y)
                 Console.WriteLine("X is bigger than Y");
            else if (x == y)
                 Console.WriteLine("X is equal to y");
            else
                Console.WriteLine("X is smaller than Y");
                
        }
    }
}
```
---
[:top: Top](#top)
### Loops.sln
``` c#
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Loops
{
    class Program
    {
        static void Main(string[] args)
        {
            WhileTest ();
            DoWhileTest ();
            ForTest ();
            ForEachTest ();
        }
        
        static void WhileTest ()
        {
            // initial value
            int i = 1;
            // condition
            while (i <= 5)
            {
                 Console.WriteLine("While Test, the value of i is " + i);
                 // increment
                 i++;
            }
        }
        
        static void DoWhileTest ()
        {
            // initial value
            int i = 1;
            do 
            {
                Console.WriteLine("While Test, the value of i is " + i);
                // increment
                i++;
            }
            while (i<5); // condition
        }
        
        static void ForTest ()
        {
            // initial value, condition, increment
            for (int i = 1; i < 5; i++)
            {
                Console.WriteLine("ForTest, The value of i is {0}", i);
            }
        }
        
        static void ForEachTest ()
        {
        // to loop through a collection, list, array
            // creat the array
            int[] numbers = { 10, 20, 30, 40, 50, 60 };
            foreach (int i in numbers)
            {
                Console.WriteLine("ForEachTest, The value of i = {0}", i);
            }
            
            // third item in the list
            Console.WriteLine("third item = {0}", numbers[2]);
            // total size of the array
            Console.WriteLine("The total size = {0}",numbers.Length);
            // last item in the list
            Console.WriteLine("Last item = {0}", numbers[numbers.Length - 1]);
        }
        
    } // end of class
} // end of namespace
```
---
[:top: Top](#top)
### Scenario 1-1
**Scenario 1-1: Converting a Decision Table into a C# Program**

| Quantity < 10 | Y | N | N | N |
| ---: | --- | --- | --- | --- |
| Quantity < 50 | Y | Y | N | N |
| Quantity < 100 | Y | Y | Y | N |
| Discount | 5% | 10% | 15% | 20% |

``` c#
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Senario1
{
    class Program
    {
        static void Main(string[] args)
        {
             Console.WriteLine("Enter the quantity: ");
             string quantity = Console.ReadLine ();
             int Qty = Convert.ToInt32(quantity);
             
             int Discount;
             
             if (Qty < 10)
             {
                Discount = 5;
             }
             else if (Qty < 50)
             {
                Discount = 10;
             }             
             else if (Qty < 100)
             {
                Discount = 15;
             }             
             else
             {
                Discount = 20;
             }
             
             Console.WriteLine("Discount is {0}%", Discount);
             
        }
    }
}
```
---
[:top: Top](#top)
### Exception_Handling.sln
``` c#
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exception_Handling
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                string firstnumber = Console.ReadLine () ;
                int x = Convert.ToInt32(firstnumber);
                Console.WriteLine("Your number is " + x);
                
            }
            catch (Exception)
            {
                Console.WriteLine("That's not a number.");
            }

        }
    }
}
```

---
[:top: Top](#top)
### WebApplication1
File > New Project > 
``` html
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Saturn's Moon</title>
    </head>

    <body>
        <h1>Mimas Cassini</h1>
        The img tag is used to display the picture of a
            <a href="http://en.wikipedia.org/wiki/Mimas_(moon)">
            Saturn’s moon</a>: <br />
        <img height="400px" width="400px"
          alt="Mimas Cassini"
          src="http://goo.gl/3BeK"/>
    </body>
</html>
```
---
[:top: Top](#top)
### Windows Form
Create a new project based on the Windows Forms Application template.   
File > New > Project... > Visual C# > Windows Form Application   
Fill in the form with label amd button, just `(Namw)` and`Text` 
from side tab `Properties`. Double click the Button to add code to Form1.cs

``` cs
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializaComponent ();
        }
        
        private void btnSubmit_Click(object sender, EventArgs e)
        {
            string firstNum = txtFirstNumber.Text;
            string secondNum = txtSecondNumber.Text;
            
            int N1 = Convert.ToInt32(firstNum);
            int N2 = Convert.ToInt32(secondNum) ;
            
            int sum = N1 + N2;
            txtResult.Text = sum.ToString ();
        }
    }
}
```        
   
 
---
[:top: Top](#top)
#### Debug examples
* add breakpoints
#### test
* right-click on code area, select 'Create Unit Tests ...
* Run > All Tests in Solution.

photo taking for window, use **Snipping tools**, rectangle snip

#### Flow-Chart
draw.io

---
[:top: Top](#top)
### parctice1.sln
``` c#
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CompareNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
             Console.WriteLine("Please enter a number");
             string myNumber = Console.ReadLine ();
             int N1 = Convert.ToInt32(myNumber);
             
             // based on the result, print on the console
             int r1 = Calculation(N1);
             
             Console.WriteLine("Result is {0}", r1);
        }
        
        // Calculation method
        static Int32 Calculation(int x)
        {
            int remainder = x % 5;
            if (remainder != 0)
                x = x * 100;
                
            return x;
        }
    }
}
```
---
## Assessment
#### Q1: Flowchart, Coding, Exception Handling

<img src="img/200905 ntuc MTA examQ1a FlowChart.PNG" alt="Q1 Flowchart" height="150">
<p float="left">	
<img src="img/200905 ntuc MTA examQ1b Coding1B.PNG" alt="Q1 Coding" height="150">
<img src="img/200905 ntuc MTA examQ1b Coding2B.PNG" alt="Q1 Coding" height="150">
<img src="img/200905 ntuc MTA examQ1b Coding3B.PNG" alt="Q1 Coding" height="150">
</p>
<img src="img/200905 ntuc MTA examQ1d Exception Handling.PNG" alt="Q1 Exception" height="150"> 

#### Q2: Unit Test
<img src="img/200905 ntuc MTA examQ2 UnitTestB.PNG" alt="Q2 Unit Test" height="150"> 

#### Q3: Debug
<p float="left">
<img src="img/200905 ntuc MTA examQ3a 1996-1.PNG" alt="Q3 Debug 1" height="72"> 
<img src="img/200905 ntuc MTA examQ3b 1996-2.PNG" alt="Q3 Debug 2" height="72"> 
<img src="img/200905 ntuc MTA examQ3c 1996-3.PNG" alt="Q3 Debug 3" height="150"> 
</p><p float="left">
<img src="img/200905 ntuc MTA examQ3d 1997-1.PNG" alt="Q3 Debug 4" height="72"> 
<img src="img/200905 ntuc MTA examQ3e 1997-2.PNG" alt="Q3 Debug 5" height="72"> 
<img src="img/200905 ntuc MTA examQ3f 1997-3.PNG" alt="Q3 Debug 6" height="150"> 
</p>
#### Q4: ERM
<img src="img/200905 ntuc MTA examQ4 ERM.PNG" alt="Q3 ERM" height="72"> 
 


---
