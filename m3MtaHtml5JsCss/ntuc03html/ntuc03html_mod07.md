Module 7: Creating Objects and Methods by Using JavaScript
===
Contents:
- Module overview
- Lesson 1:	Writing Well-Structured JavaScript Code
- Lesson 2:	Creating Custom Objects
- Lesson 3:	Extending Objects
- Lab:	Refining Code for Maintainability and Extensibility
- Exercise 1

## Module overview
### Objectives
After completing this module, you will be able to:
- Write well-structured JavaScript code.
- Use JavaScript code to create custom objects.
- Implement object-oriented techniques by using JavaScript idioms.

## Lesson 1: Writing Well-Structured JavaScript Code
### Lesson objectives
After completing this lesson, you will be able to:
- Explain the scoping rules for local variables, and describe how hoisting works.
- Use immediately invoked functions, strict mode, and namespaces to minimize global name clashes in a web application.
- Describe ES2015 Modules
- Use common global objects and functions available in the standard JavaScript language.

### Scoping and Hoisting
> * JavaScript variables declared with **var** have one of two scopes:
>   * Global scope
>   * Local scope within a function
> * JavaScript variables declared with **let** or **const** are block scoped.
> * Prefer **let** and **const**.

The following example demonstrates how scoping and hoisting work in JavaScript. Note the following points:
- The example declares a global variable named `num1` and assigns it the value 7.
- The `demonstrateScopingAndHoisting()` function declares a `var` local variable named `num1` and 
  another local variable named `num2` by using the `let` keyword inside an `if` statement block, 
  and assigns them the values 42 and 43. 
  This variable declared with the `var` keyword is hoisted automatically to function scope,
  as if it was declared at the start of the `demonstrateScopingAndHoisting()` function.

- After the `if` statement, the local `num1` variable is still in scope. 
  Therefore the first `alert()` function displays the local `num1` variable (42), 
  not the global `num1` variable (7).

- The local variable `num2` is block scoped to block the `if` statement, 
  so after the `if` statement `num2` is no longer in scope and 
  therefore trying to reference it will result in an exception 
  that will be handled inside the `catch` block and the second `alert()` function 
  will display the `num2 is not defined` message.
``` jsx
    <script>
        const num1 = 7;

        function demonstrateScopingAndHoisting() {
            if (true) {
                const num1 = 42;
                let num2 = 43;
            }
            alert("The value of num1 is " + num1);
            try {
                alert("The value of num2 is " + num2);    
            }
            catch(err){
                alert("num2 is not defined");
            }

        }
    ..
        demonstrateScopingAndHoisting();
    </script>
```
### Managing the Global Namespace
> * Global name clashes can be problematic in JavaScript
>   * Your global variables might conflict with other global variables elsewhere in the web application
> * JavaScript provides several mechanisms to avoid global name clashes
>   * Immediate functions
>   * Namespaces
>   * Strict mode
>   * Block scoped variables (ES2015 only)
>   * Modules (ES2015 only)

JavaScript provides several mechanisms that help you to avoid global name clashes, including:
- Immediately invoked functions
- Namespaces
- Strict mode

ECMA-262 6th edition (ES2015) introduced two more features that can help manage the `Global` namespace better:
- Block-scope variables – discussed in the previous lesson.
- Module – discussed in the next topic.

#### Immediately Invoked Functions
``` jsx
    (function() {
        // Variables defined inside the function disappear when the function finishes
        // - they will not conflict with variables defined by other scripts
        let localVar = ... ;
        let localVar2 = ...;

        // The same logic applies to functions
        // - they are destroyed when the immediately invoked function finishes
        function localFunc() {
            localVar = 99;
            ...
        }
        ...
        localFunc() ; // Run localFunc
        ...
    }) ();
```
#### Namespace
``` jsx
    const MyNamespace = {
        myFunction1: function(someParameters) {
            // Implementation code…
        },
        myFunction2: function(someParameters) {
            // Implementation code…
        },
        message: "Hello World",
        count: 42
    }
```
``` jsx
    MyNamespace.myFunction1(someParameterValues);
    MyNamespace.message = "Goodbye all";
```
#### Strict Mode
``` jsx
    function someFunction() {
        "use strict";
        // Other statements.
    }
```

### ES2015 Modules
> * ES2015 modules are written in files. One module per file and one file per module.
> * To load a JavaScript file as a `module`, we need to add a `script` tag with 
    a `type` attribute whose value is `module`.
> * Top-level varialbles and functoins are scoped locally to the module.
> * Exposing an API from the module is done explicity by using 
    the `export` declaration, whereas consuming the module API's
    will be done by using the `ìmport` declaration.

``` jsx
    <script src="mymodule.js" type="module" ></script>
```

Modules have a few key differences from regular script files

| | Scripts | Modules
| --- | :--- | :---
| Default mode | Non-strict | Strict
| Top-level variables and functions | Global | Local to the module
| Top-level value of **this** | **window** | **undefined**
| Run | Synchronously | Asynchronously

ES2015 modules are self-contained, so all top-level variables and functions are scoped locally to the module. Exposing an API from the module is done explicitly by using the `export` declaration, whereas consuming the module API’s will be done by using the `import` declaration.

There are two types of exports:
- Named exports

A `module` can export multiple functionalities by prefixing them with the `export` declaration.
``` jsx
    //------ calc.js ------

    export function sum(x,y) {
        return x + y;
    }
    export function multiply(x, y) {
        return x * y;
    }

    //------ main.js ------
    import { sum, multiply } from 'calc.js';
    console.log(sum(4,4)); // 8
    console.log(multiply(5,2)); // 10
```
A module can also be imported as a whole and its named exports will be referred by using the `property` notation.
``` jsx
    //------ main.js ------
    import * as calc from 'calc.js';
    console.log(calc.sum(4,4)); // 8
    console.log(calc.multiply(5,2)); // 10
```
- Default exports

A module can define a single default export, the main exported value.
``` jsx
//------ sum.js ------
  
export default function sum(x,y) {
    return x + y;
}
  
//------ main.js ------
import sumFunc from 'sum.js';
console.log(sumFunc(4,4)); // 8
``` 
The sum module defines the `sum` function as the default export, and it’s imported inside the `main.js` file into the `sumFunc` variable.

### Singleton Objects and Global Functions in JavaScript
> * JavaScript defines several singleton objects, such as:
>   * **Math**
>   * **JSON**
> * JavaScript also defines global functions, such as:
>   * **parseInt**()
>   * **parseFloat**()
>   * **isNan**()
  
The following example shows how to access some of the members of the **Math** object:
``` jsx
    let radius = 100 * Math.random();
    let circumference = 2 * Math.PI * radius;
    let area = Math.PI * Math.pow(radius, 2);
```
The following example shows how to use the **JSON** object:
``` jsx
    let anObject;
    ...
    let anObjectAsJsonString = JSON.stringify(anObject);
    let anObjectAgain = JSON.parse(anObjectAsJsonString);
``` 
The following example shows how to use these global functions, **parseInt**(), **parseFloat**(), and **isNan**().:
``` jsx
    let ageEnteredByUser;
    let heightEnteredByUser;
    …
    let age = parseInt(ageEnteredByUser);
    let height = parseFloat(heightEnteredByUser);
    if (isNan(age) || isNan(height))
        alert("Invalid input");
```

---
## Lesson 2: Creating Custom Objects
### Lesson objectives
After completing this lesson, you will be able to:
- Create custom objects that contain properties and methods.
- Use object literal notation to define the properties of objects.
- Define constructor functions to assign a common set of properties to objects.
- Use prototypes to implement object behavior.
- Use the `Object.create()` function to create objects based on an existing prototype.
- Describe and use ES2015 Classes

### Creating Simple Objects
> * There are several ways to create new objects in JavaScript
> ```jsx
>     let employee1 = new Object();
> ```
> ```jsx
>     let employee2 = {};
> ```
> * You can define properties and methods on an object:
> ```jsx
>     let employee1 = {};
>     employee1.name = "John Smith";
>     employee1.age = 21;
>     employee1.salary = 10000;
>     employee1.payRise = function(amount) {
>         // Inside a method, "this" means the current object.
>         this.salary += amount;
>         return this.salary;
>     }
> ```

### Using Object Literal Notation
> * Object literal notation provides a shorthand way to create new objects and assign properties and methods:
> ``` jsx
>     const employee2 = {
>         name: "Mary Jones",
>         age: 42,
>         salary: 20000,
> 
>         payRise: function(amount) {
>             this.salary += amount;
>             return this.salary; 
>         },
> 
>         displayDetails: function() {
>             alert(this.name + " is " + this.age + " and earns " + this.salary);
>         }
>     };
> ```

### Using Constructors
> * Constructor functions define the shape of objects
>   * They create and assign properties for the target object
>   * The target object is referenced by **this** keyword
> ``` jsx
>     const Account = function (id, name) {
>         this.id = id;
>         this.name = name;
>         this.balance = 0;
>         this.numTransactions = 0;
>     };
> ```
> * Use the constructor function to create new objects with the specified properties:
> ``` jsx
>     let acc1 = new Account(1, "John");
>     let acc2 = new Account(2, "Mary");
> ```

### Using Prototypes
> All objects created by using a constructor function have their own copy of the properties 
  defined by the constructor
> * All JavaScript objects, including constructors, have a special property named **prototype**  
> * Use the prototype to share function definitions between objects:
> ``` jsx
>     Account.prototype = {
>         deposit: function(amount) {
>             this.balance += amount;
>             this.numTransactions++;
>         },
>         withdraw: function(amount) {
>             this.balance -= amount;
>             this.numTransactions++;
>         },
>         displayDetails: function() {
>             alert(this.id + ", " +
>                   this.name + " balance $" +
>                   this.balance + " (" +
>                   this.numTransactions + " transactions)");
>           }
>     };
> ``` 

Constructors are just functions that create new objects.   
If you use the same constructor to create two objects, each object gets its own set of properties as defined by the constructor function.  
While this is useful for data properties, the same mechanism is not quite so useful for methods;   
each object gets its own copy of the methods defined by the constructor, despite the fact that they are logically all the same piece of code, and   
each copy of the method occupies its own space in memory and has a corresponding management overhead.   
It is clearly wasteful of resources if you create hundreds or thousands of instances of an object by using the same constructor.

Prototypes give you a way to share functions between objects created by using the same constructor.   
All JavaScript objects, including constructor functions, have a special property named **prototype**.   
The prototype is really just another object to which you can assign new properties and methods;   
you use it as a blueprint for creating new objects.   
It automatically provides a set of functions and other properties that are inherited from the prototype of the **Object** type by using a mechanism known as prototype chaining. 

Note: The prototype of the **Object** type provides useful functionality such as the `toString` method, which returns a string representation of an object.

``` jsx
    let acc1 = new Account(1, "John");
    let acc2 = new Account(2, "Mary");

    acc1.deposit(100);
    acc1.displayDetails();

    acc2.withdraw(50);
    acc2.displayDetails();
``` 

### Using the Object.create() Method
> * Use **Object.create()** to create an object based on existing prototype
>   * Pass in a prototype object
>   * Optionally pass in a properties object that specifies additional properties to add to the new object
> ``` jsx
>     let obj1 = Object.create(prototypeObject, propertiesObject)
> ``` 
> * The new object has access to all the properties defined in the specified prototype
>   * It forms the basis of the approach used by many JavaScript developers to implement inheritance.

The following example creates an object by using a `null` prototype, and adds two simple properties:
``` jsx
    let obj1 = Object.create(null, { 
        prop1: {value: "hello", writable: true}, // read/write property
        prop2: {value: "world" }                 // read-only property
    });
```
The next example creates an object called `obj2` by using the prototype of the acc1 object defined in the earlier examples.
``` jsx
    // Account constructor function, same as before.
    const Account = function (id, name) { ... };

    // Account prototype, same as before.
    Account.prototype = { ... };

    acc1 = new Account(...);

    // Create an object by using the Account prototype.
    let obj2 = Object.create(Object.getPrototypeOf(acc1));
```

### Using ES2015 Classes
> * Classes, introduced in ES2015, are merely a shorthand syntax over the existing prototype-based object-oriented model
> * Use the **class** keyword to create new class
> * Define constructor, methods and members inside the **class** body     
``` jsx
    class Account {

      constructor (id, name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
        this.numTransactions = 0;
      }

      deposit(amount) {
        this.balance += amount;
        this.numTransactions++;
      }

      withdraw(amount) {
        this.balance -= amount;
        this.numTransactions++;

      }

      displayDetails() {
        alert(this.id + ", " +
              this.name + " balance $" +
              this.balance + " (" +
              this.numTransactions + " transactions)");
      }

    }
``` 
`deposit`, `withdraw` and `displayDetails` are eventually assigned as properties to the Account prototype object, and we can invoke them as we did earlier.
``` jsx
    let acc1 = new Account(1, "John");
    let acc2 = new Account(2, "Mary");

    acc1.deposit(100);
    acc1.displayDetails();

    acc2.withdraw(50);
    acc2.displayDetails();
```
#### Best Practice: 
ES2015 classes offer a more concise and intuitive syntax for defining an object and for inheritance (discussed in detail in the next lesson). If browser compatibility is not an issue, use classes instead of the constructor functions and directly manipulating the prototype object.

---
## Lesson 3: Extending Objects
### Lesson objectives
After completing this lesson, you will be able to:
- Implement encapsulation in JavaScript.
- Implement inheritance in JavaScript.
- Implement inheritance in ES2015.
- Add functionality to existing native objects.

### Implementing Encapsulation
> * To define private members for an object, declare variables in the constructor and
  omit the **this** keyword
> * To define public accessor functions for an object, delcare methods in the constructor
  and include the **this** keyword

The following example shows how to use closures to achieve encapsulation. The `name` and `age` variables are effectively private to `Person` objects, whereas the `getName()`, `getAge()`, `setName()`, and `setAge()` methods are public.

#### Using Closures to Achieve Encapsulation
``` jsx
    const Person = function(name, age)
    {
        // Private properties.
        let _name, _age;

        // Public methods defined in the constructor have access to private properties.
        this.getName = function()
        {
            return _name;
        }

        this.setName = function(name)
        {
            _name = name;
        }

        this.getAge = function()
        {
            return _age;
        }

        this.setAge = function(age)
        {
            if (age > 0 && age < 100)
              _age = age;
        }

        // Constructor logic.
        _name = name;
        this.setAge(age);
    }

    // Public methods defined in the prototype do not have access to private properties.
    Person.prototype =
    {
        toString: function()
        {
            return this.getName() + " is " + this.getAge();
        }
    }

    // External code.
    const person1 = new Person("Joe", 21);
    alert(person1.toString());   // Displays "Joe is 21"
    alert(person1._name);       // Displays "undefined"
``` 
Note: JavaScript also provides accessor properties enabling a programmer to encapsulate data behind get and set functions by using the Object.defineProperty function. For more information, visit http://go.microsoft.com/fwlink/?LinkID=267730.

### Implementing Inheritance by Chaining Prototypes
> * Define the base constructor and prototype
> * Define the derived constructor
> * Set the **prototype** property of the derived constructor to an instance of the base object

### Implementing Inheritance in ES2015 Classes
> * Define the base class with the **class** keyword
> * Define the derived class with the **extends** keyword followed by the base class.
> * Use the **super** keyword to call the base class constructor and corresponding methods

ECMA262-6th edition (ES2015) has introduced a much simpler and intuitive syntax for inheriting classes.

In ES2015, when defining a class with the **class** keyword we can define inheritance with the **extends** keyword followed by the base **object**. An important addition in ES2015 class is the **super** keyword, that is used to call the base class constructor or corresponding methods.

The following example shows how to implement inheritance in ES2015 classes.

### Implementing inheritance in ES2015 classes
``` jsx
    // Base class.
    class Person  {
      constructor(name, age) {
         this.name = name;
         this.age = age;
      }

      haveBirthday() {
           this.age++;
      }

    }

    // Derived class.
    class Student extends Person {
       constructor(name, age, subject) {
          super(name,age);
          this.subject = subject;
        }
    } 

    // Create a derived object and invoke any methods defined in the object or one of its 
    // parents. JavaScript uses prototype chaining to locate methods up the inheritance tree.
    let aStudent = new Student("Jim", 20, "Physics");
    aStudent.subject = "BioChemistry";
    aStudent.haveBirthday();
    alert(aStudent.age); // console.log(aStudent.age); // Dispaly "21"
```

### Adding Functionality to Existing Objects
> * Get the prototype for an object
> * Assign a new property to the object
> ``` jsx
>     var Point = function(x, y) {
>         this.x = x;
>         this.y = y;
>     }
> 
>     Point.prototype.moveBy = function(deltaX, deltaY) { ... }
>     Point.prototype.moveTo = function(otherPoint) { ... }
> 
>     var p1= new Point(100, 200);
>     p1.moveBy(10, 20);
>     p1.moveTo(anotherPoint);
> ``` 
> * Use the **apply** method to resolve reference to **this** in generic functions

### Demonstration: Refining Code for Maintainability and Extensibility
#### Demonstration steps
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD07_DEMO.md.

---
## Lab: Refining Code for Maintainability and Extensibility
### Objectives
After completing this lab, you will be able to:
- Implement good practices for writing JavaScript code.
- Refactor JavaScript code to use object-oriented principles.

#### Lab setup
You will find the high-level steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD07_LAB_MANUAL.md.

You will find the detailed steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD07_LAK.md.

### Exercise 1: Refactoring JavaScript Code to Use Classes and Objects
#### schedule.js
``` jsx
// Import objects/functions from the conference namespace.
import { LocalStarStorage } from "../LocalStarStorage.js";
import { ScheduleList } from "../ScheduleList.js";

// TODO: Replace the following code by creating a ScheduleList object 
//       and calling the startDownload method.
const scheduleList = new ScheduleList(
    document.getElementById("schedule"),
     new LocalStarStorage(localStorage)
);
scheduleList.startDownload();
// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr
/// ...
```
#### scheduleList.jsx
``` jsx
import { ScheduleItem } from "./ScheduleItem.js";

export class ScheduleList {
    constructor(element, localStarStorage) {
        this.element = element;
        this.localStarStorage = localStarStorage;
    }

    async startDownload() {
        // await response of fetch call
        let response = await fetch("/schedule/list")
        // transform body to json
        let data = await response.json();

        // checking response is ok
        if (response.ok) {
            this.downloadDone(data);
        } else {
            this.downloadFailed();
        }
    }

    downloadDone(responseData) {
        this.addAll(responseData.schedule);
    }

    downloadFailed() {
        alert("Could not retrieve schedule data at this time. Please try again later.");
    }

    addAll(itemsArray) {
        itemsArray.forEach(this.add, this);
    }

    add(itemData) {
        const item = new ScheduleItem(itemData, this.localStarStorage);
        this.element.appendChild(item.element);
    }
}
// SIG // Begin signature block
// SIG // MIIdkAYJKoZIhvcNAQcCoIIdgTCCHX0CAQExCzAJBgUr
// ...
```

#### schedule.html
``` html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>ContosoConf Schedule</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
        <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
        <link href="/styles/header.css" rel="stylesheet" type="text/css" />
        <link href="/styles/footer.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/pages/schedule.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <nav class="page-nav">
            <div class="container">
                <a href="/index.htm">Home</a>
                <a href="/about.htm">About</a>
                <a href="/schedule.htm" class="active">Schedule</a>
                <a href="/register.htm">Register</a>
            </div>
        </nav>
        
        <header class="page-header">
            <div class="container">
                <h1>ContosoConf</h1>
                <p class="tag-line">A two-track conference on the latest HTML5 developments</p>
            </div>
        </header>
        
        <section class="page-section schedule">
            <div class="container">
                <h1>Schedule</h1>
                <ul id="schedule"></ul>
            </div>
        </section>

        <footer class="page-footer">
            <div class="container">
                <p>
                    Hosted by Contoso
                </p>
                <address>
                    Conference Center<br />
                    1234 Main Street<br />
                    Seattle<br />
                    WA 98999
                </address>
                <p>
                    &#169; 2012 Contoso
                </p>
            </div>
        </footer>
        
        <script id="schedule-item" type="text/x-template">
            <li class="schedule-item">
                <span data-bind="title"></span>
                <div class="star"></div>
                <div class="star-count" data-bind="starCount"></div>
            </li>
        </script>

        <script src="/scripts/pages/schedule.js" type="module"></script>
    </body>
</html>

```


---
