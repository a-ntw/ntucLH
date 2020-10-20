Module 3: Introduction to JavaScript
===
### Contents:
- Module overview
- Lesson 1:	Overview of JavaScript
- Lesson 2:	Introduction to the Document Object Model
- Exercise 1 & 2, coding

---
## Module overview

---
## Lesson 1:	Overview of JavaScript
### Lesson objectives
After completing this lesson, you will be able to:
- Explain the purpose of JavaScript.
- Describe the basic syntax of statements and comments in JavaScript.
- Declare variables and write expressions by using JavaScript operators.
- Create and call JavaScript functions.
- Use conditional statements to control execution flow.
- Use loop statements to implement repeated operations.
- Use JavaScript objects in your code.
- Use JavaScript Object Notation (JSON) syntax to define an array of objects.
### What is JavaScript?
> * JavaScript is a programming language that supports
>     - Variables
>     - Operators
>     - Functions
>     - Conditional Statements and Loops
>     - Objects
> * Use JavaScript with the Document Object Model and Browser Object Model to make web pages dynamic.
> * Use the Fetch API to make asynchronous requests to a web server.


At its heart, JavaScript is a scripting engine with the same basic features as any other programming language. It provides:
- **Variables** for storing information.
- **Operators** for performing calculations and comparisons.
- **Functions** for grouping statements into reusable chunks.
- **Conditional statements** and **loop** constructs to control program flow.
- The ability to create **objects** with properties, methods, and events.

you can use JavaScript code to:
- Add or remove items to a list displayed on a page.
- Add, change, or remove text on a page.
- Change the CSS styles applied to a set of elements on the page.
- React to events, such as a mouse clicking a button.
- Validate the contents of a form before they are sent to the web server.
- Obtain information about the browser displaying the web page, such as the manufacturer and version, and even environmental information such as the current window size and local time.
- Display an alert in the user's browser.
- the **XMLHttpRequest** API (commonly referred to as AJAX) enables a web page to make asynchronous requests back to the web server.

### JavaScript Syntax
> * A JavaScript statement represents a line of code to be run
> * Terminate statements with a semicolon
> ``` js
>     let thisVariable = 3;
>     counter = counter + 1;
>     GoDoThisThing();
>     document.write("An incredibly really \ 
>       very long greeting to the world");
> ```
> * Use comments to add noted to your scripts
> 
>     document.write("I'm learning JavaScript"); // display a message
> ```js
>     /* You can use a multi-line comment
>     to add more information *?
> ```
### Variables, Data Types, and Operators
> * Use **let** to declare variables
> ``` js
>     let answer = 3;
>     let actuallyAsString= "42";
> ```    
> * JavaScript has three simple types
>     * String, Number, and Boolean
>     * Variables can also be undefined or null
> ``` js
>     let noValue; // noValue has the value indefined
>     let nullValue = null; // null is different to undefined
> ```
> * JavaScript supports many operators
>     * Arithmetic, assignment, comparion, Boolean, conditional, and string

##### Variables
##### Data Types
1. String
    - To include special characters such as ",´, ;, \, and & in your string, escape them with a backslash. 
    Also use a backslash to split a string over two or more lines.
2. Number
3. Boolean
    - You can determine the current type of data in a variable by using the typeof operator:
##### Operators
4. Arithmetic operatos
5. Assignment operators
6. Comparison operators
    - == (is equal to)
    - === (is equal in value and in type)
7. Boolean operators
8. tenary conditional operators
    - ?: assigns one of two values to a variable based on a condition. For example, 
    the expression x = (condition)?value1:value2; sets x to value1 if condition is true, value2 otherwise.
9. string operator

### Functions
> Functions are named block of reusable code:
> ``` js
>     function aName(argument1, argument2, ..., argumentN)
>     {
>         statement1;
>         statement2;
>         ...
>         statementN;
>     }
> ```
> * Arguments are only accessible insode the function
> * A function can return a value
> * A function can also declare local variables
> * Global variables defined outside of a function are available to all functions in scripts referenced by a page

### Conditional Statements
> JavaScript provides two conditional constructs
> * if
> ``` js
>     if (TotalAmountPaid > AdvancePaid){
>         GenerateNewInvoice();
>     } else {
>         WoshGuestAPleasantJourney();
>     }
> ```
> * switch
> ``` js
>     let RoomRate;
>     switch (typeOfRoom) {
>         case "Suite":
>             RoomRate = 500;
>             break;
>         case "King":
>             RoomRate = 400;
>             break;
>         default:
>             RoomRate = 300;
>     }
> ```
### Looping Statements
> JavaScript provides three loop constructs
> * while:
> ``` js
>     while (GuestIsStillCheckedIn())
>     {
>         numberOfNightsStay += 1;
>     }
> ```
> * do while:
> ``` js
>     do {
>         eatARoundOfToast();
>     } while (StillHUngry())
> ```
> * for:
> ```js
>     for (let i=0; i<10; i++ ) {
>         plumpUpAPillow();
>     }
> ```
### Using Object Types
> * JavaScript has a number of built-in object types:
>     * String, Date, Array, RegExp
> ``` js
>     let seasonsArray = ["Spring", "Summer", "Autumn", "Winter"];
>     ...
>     let autumnLocation = seasonsArray.indexOf("Autumn");
> ```
> ``` js
>     let re = new RegExp("[dh]og");
>     if (re.test("dog")) {...}
> ```
> * JavaScript also provides singleton types
>     providing useful functionality:
>     * Math, Global

- You can determine whether an object is a member of an array by using the **indexOf** function.  
- The **RegExp** object type, which enables you to create and work with a regular expression for matching strings. 
    Use the **test** method to determine whether a string matches a regular expression.
- The **Math** object ...
- The **Global** object contains global functions and constants and is the parent object for the 
    **undefined**, **NaN**, and **Infinity** constants. It cannot be instantiated.
    - Additional Reading: You can find details for all these objects at http://go.microsoft.com/fwlink/?LinkID=267718.

### Defining Arrays of Objects by Using JSON
> * JSON is a format for serializing objects:
> ``` yaml
>     let attendees = [
>         {
>             "name": "Eric Gruber",
>             "currentTrack": "1"
>         },
>         {
>             "name": "Martin Weber",
>             "currentTrack": "2"
>         }
>     ]
> ```
> * JavaScript provides APIs for serializing and parsing JSON data

JSON has become increasingly important as it is currently the de facto format for passing data in 
an AJAX request between a web page and a web server. 
JavaScript provides APIs for converting data into JSON format (**JSON.stringify**), and for parsing JSON data (**JSON.parse**).
- Additional Reading: The full JSON syntax can be found at https://developer.mozilla.org/en-US/docs/JavaScript/Reference/Global_Objects/JSON.

### Demonstration: Creating a Simple JavaScript File that Defines Variables, Array and Functions.
#### Demonstration steps
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD03_DEMO.md.



---
## Lesson 2:	Introduction to the Document Object Model
### Lesson objectives
After completing this lesson, you will be able to:
- Describe the purpose and basic structure of the DOM.
- Select elements by using the DOM.
- Add, remove, and modify elements by using the DOM.
- Handle events for controls on a web page.

### The Document Object Model
> The DOM provides a programmatic API for controlling a browser and accessing the contents of a web page:
> * Finding and setting the values of elements on a page
> * Handling events for controls on a page
> * Modifying the styles associated with elements
> * Serializing and deserializing a page as an XML document
> * Validating and updating web pages

Most modern browsers provide access to the following APIs:
- The DOM Core, which defines the basic interfaces for accessing a document, elements, attributes, and text on a page.
- The DOM Event Model, which defines the basic set of UI and page events and how to add and remove handlers for events in general.
- The DOM Style Model, which defines a set of interfaces for accessing any type of style sheet and the CSS rules within them.
- The DOM Traversal and Range Models, which define APIs for traversing the elements in a web page and manipulating sets of elements at once rather than one at a time.
- The DOM HTML API, which defines objects and methods representing each type of element in the HTML 4.01 and XHTML 1.0 specifications.
- The DOM Load and Save API, which enables you to serialize and deserialize DOM representations of the page into an XML document.
- The DOM Validation API, which contains methods to dynamically update documents so they become valid against the HTML 4.01 specification.

### Finding Elements in the DOM
> Given the following form:
> ``` html
>     <form name = "contactform">
>         <input type = "text"name = "nameBox"id="nameBoxID" />
>     </form>
> ```
> * You can reference the form by using:
> ``` js
>     document.form[0]    // forms is a zero-based array
>     document.forms["contactForm"]
>     document.forms.contactForm
>     document.contactForm
> ```
> * You can reference the **nameBox** text box by using:
> ``` js
>     document.forms.contactForm.elements[0]
>     document.forms.contactForm.elements["nameBox"]
>     document.forms.contactForm.nameBox
>     document.contactForm.nameBox
>     document.getElementById("nameBoxId")
> ```

After a page has loaded, a common action when scripting against the DOM is to find an element or set of elements to query or manipulate. For example, you may need to obtain a reference to a list so that you can populate it with elements retrieved from a web service. The DOM represents the various parts of a document as a set of arrays:

- The **forms** array contains details of all the forms in the document.
- The **images** array contains all the images in the document.
- The **links** array contains all the hyperlinks in the document.
- The **anchors** array contains all the <a> tags in the document with a name attribute.
- The **applets** array contains all the applets in the document.

All of these collections are child properties of the document object. This object represents the document as a whole. You can use dot notation to access each collection, and any property, method, or event defined by the DOM. To access individual elements in a collection, you can use an indexer or reference it by the value of its name attribute. 

Alternatively, the DOM defines methods on the **document** object that retrieve elements based on the value of their **ID** and **name** attributes.

### Querying the DOM for Elements
> Given the following form:
> ``` html
>     <form name = "contactForm">
>         <input type = "text" class = "valid" name = "nameBox"/>
>         <input type = "email" name = "emailBox"/>
>         <input type= "number" class="valid" name="numberBox" />
>     </form>
> ```
> * You can reference the email field by using
> ```js
>     let emailInput = document.querySelector("input[type = email]");
> ```
> * You can referenece all the input elements with "valid" class attribute
> ```js
>     let validInputs = document.querySelectorAll("input.valid");
> ```

There are situations where we need to find elements based on multiple attribute values.

For instance, we would like to find a **div** element whose ID attribute value is **highlight**. Although this can be done by using common methods such **getElementById** and **getElementsByTagName**, the **document** object provides more powerful and convenient methods that enable us to perform complex queries on the DOM by using css selectors.
- **document.querySelector(cssSelectorString)**, which returns a single element whose attribute values match the css selector specified by the cssSelectorString.
- **document.querySelectorAll(cssSelectoreString)**, which returns a collection of elements whose attribute values match the css selector specified by the **cssSelectorString**.

### Adding, Removing, and Manipulating Objects in the DOM
> To modify an element on a page:
> 1. Create a new object containing the new data.
> 2. Find the parent element that should contain the new data.
> 3. Append, insert, or replace the data in the element with the new data.
> 
> To remove an element or attribute:
> 1. Find the parent element.
> 2. Use **removeChild** or **removeAttribute** to remove the data.

The DOM Core API defines several methods to create new objects for a document, including:
- **document.createElement(tagname)**
- **document.createTextNode(string)**
- **document.createAttribute(name, value)**
- **document.createDocumentFragment**

All four of these methods actually create a DOM node object, which is the generic representation of an element, text, or attribute in the DOM. After you have created the DOM node object, you add it to the DOM. The simplest way is to call **document.getElementbyId()** to retrieve the parent element to which you wish to apply this object, and then call one of the following methods on this element:
- appendChild(newNode)
- insertBefore(newNode, existingNode)
- replaceChild(newNode, existingNode)
- replaceData(offset, length, string)

To use these methods effectively and target accurately where to add new nodes, you also need to move around the document tree. You can use the following properties to navigate through the DOM:
- childNodes, which returns all the child nodes of a node.
- firstChild, which returns the first child of a node.
- lastChild, which returns the last child of a node.
- nextSibling, which returns the node immediately following the current one.
- parentNode, which returns the parent node of a node.
- previousSibling, which returns the node immediately prior to the current node.

The DOM also defines methods for removing nodes from the document tree, including:
- **removeChild(node)**, which removes the target node.
```js
    document.removeChild( 
      document.getElementById("VenueList").firstChild 
    );
```
- **removeAttribute(attributeName)**, which removes the named attribute from the element node.
``` js
    const list = document.getElementById("VenueList");
    list.removeAttribute("id");
```
- **removeAttributeNode(node)**, which removes the given attribute node from the element.
``` js
    const list = document.getElementById("VenueList");
    list.removeAttribute(list.attributes[0]);
```
To clear a text node rather than removing it completely, just set it to an empty string.

### Handling Events in the DOM
> * The DOM defines events that can be triggered by the browser or by the user
> * Many HTML elements define callbacks that run when an event occurs:
> ```js
>     let helpIcon = document.getElementById("helpIcon");
>     document.images.helpIcon.onmouseover = 
>         function() { window.alert("Some help text"); };
> ```
> * You can also define event listeners that run when an event fires:
>     * This is usefil if the same event needs to trigger multiple actions
> ``` js
>     helpIcon.addEventListener("mouseover",
>         function() { window.alert('Some help text); }, false);
> ```
> * To remove an event listener:
> ```js
>     helpIcon.removeEventListener("mouseover", ShowHelpText, false),
> ```

#### Binding an action to an event with the DOM
``` html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8" />
  <title>Binding events with JavaScript</title>
</head>
<body>
  <form>
    <p>
      <label>Write Your Name:
        <input type="text" id="NameBox" /></label></p>
    <input type="button" id="submit" value="Click to submit" />
  </form>
  <div id="thankYouArea"></div>
  
  <script type="text/javascript">
    function sayThankYou() {
      let userName = document.getElementById("NameBox").value;
  
      let thankYou = document.createElement("p");
      thankYou.textContent = "Thank you " + userName;
      document.getElementById("thankYouArea").appendChild(thankYou);
    }
  
    document.getElementById("submit").addEventListener("click", sayThankYou);
  </script>
</body>
</html>
```
The DOM is constructed by the browser while parsing the HTML markup from top to down. Some elements may block the construction of the DOM; the script element is one of these elements.

### Demonstration: Manipulating the DOM with JavaScript
#### Demonstration steps
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD03_DEMO.md.

---
## Lab:	Displaying Data and Handling Events by Using JavaScript.
#### Objectives
After completing this lab, you will be able to:
- Use JavaScript code to programmatically update the data displayed on an HTML5 page.
- Handle the events that can occur when a user interacts with a page by using JavaScript.

##### Lab setup
Estimated Time: 60 minutes

You will find the high-level steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD03_LAB_MANUAL.md.

You will find the detailed steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD03_LAK.md.

## Exercises

### Exercise 1: Displaying Data Programmatically

### Exercise 2: Handling Events

#### schedule.html exe2
```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>ContosoConf Schedule</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <nav class="page-nav">
            <div class="container">
                <a href="/index.htm">Home</a>
                <a href="/about.htm">About</a>
                <a href="/schedule.htm">Schedule</a>
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
                Show: <input type="checkbox" id="show-track-1" checked="checked" /><label for="show-track-1">Track 1</label>
                <input type="checkbox" id="show-track-2" checked="checked" /><label for="show-track-2">Track 2</label>
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
        
        <script src="/scripts/pages/schedule.js" type="text/javascript"></script>
    </body>
</html>
```
#### sites.css exe2
``` css
/* Styles used throughout the entire web site */

html {
    /* font-size 62.5% makes 1rem equal 10px for easy size calculations. */
    font-size: 62.5%;
    font-family: Calibri, Arial, sans-serif;
    background-color: #EAEEFA;
}

body {
    margin: 0;
    /* Default font-size to about 18px */
    font-size: 1.8rem;
}

.container {
    padding: 0 1rem;
    max-width: 94rem;
    /* Horizontally center containers */
    margin: 0 auto;
}

nav {
    background-color: #1d1d1d;
    line-height: 6rem;
    font-size: 1.7rem;
}

nav a {
    color: #fff;
    padding: 1rem;
}

h1 {
    font-size: 4rem;
    letter-spacing: -1px;
    margin: 1em 0 .25em 0;
}
```
#### schedule.js exe2
```js
const schedule = [
    {
        "id": "session-1",
        "title": "Registration",
        "tracks": [1, 2]
    },
    {
        "id": "session-2",
        "title": "Moving the Web forward with HTML5",
        "tracks": [1, 2]
    },
    {
        "id": "session-3",
        "title": "Diving in at the deep end with Canvas",
        "tracks": [1]
    },
    {
        "id": "session-4",
        "title": "New Technologies in Enterprise",
        "tracks": [2]
    },
    {
        "id": "session-5",
        "title": "WebSockets and You",
        "tracks": [1]
    },
    {
        "id": "session-6",
        "title": "Coffee and Cake Break",
        "tracks": [1, 2]
    },
    {
        "id": "session-7",
        "title": "Building Responsive UIs",
        "tracks": [1]
    },
    {
        "id": "session-8",
        "title": "Fun with Forms (no, really!)",
        "tracks": [2]
    },
    {
        "id": "session-9",
        "title": "A Fresh Look at Layouts",
        "tracks": [1]
    },
    {
        "id": "session-10",
        "title": "Real-world Applications of HTML5 APIs",
        "tracks": [2]
    },
    {
        "id": "session-11",
        "title": "Lunch",
        "tracks": [1, 2]
    },
    {
        "id": "session-12",
        "title": "Getting to Grips with JavaScript",
        "tracks": [1]
    },
    {
        "id": "session-13",
        "title": "Transforms and Animations",
        "tracks": [2]
    },
    {
        "id": "session-14",
        "title": "Web Design Adventures with CSS3",
        "tracks": [1]
    },
    {
        "id": "session-15",
        "title": "Introducing Data Access and Caching",
        "tracks": [2]
    },
    {
        "id": "session-16",
        "title": "Closing Thanks and Prizes",
        "tracks": [1, 2]
    }
];


// TODO: Task 2 - Get the "schedule" list element from the document
const list = document.getElementById("schedule");
const track1CheckBox = document.getElementById("show-track-1");
const track2CheckBox = document.getElementById("show-track-2");

function createSessionElement(session) {
    // TODO: Task 3 - Create a <li> element for the session.
    //       Add the session title as the <li> text content
    //       Return the <li> element
    const li = document.createElement("li");
    li.textContent = session.title;
    return li;
};

function clearList() {
    while (list.firstChild) {
        list.removeChild(list.firstChild);
    }
}

function displaySchedule() {
    clearList();
    
    // TODO: Task 4 - Loop through the schedule array
    //       Create session elements
    //       Append the elements to the list   
    for (let i = 0; i < schedule.length; i++) {
        const tracks = schedule[i].tracks;
        const isCurrentTrack = (track1CheckBox.checked && tracks.indexOf(1) >= 0) ||
                             (track2CheckBox.checked && tracks.indexOf(2) >= 0);
        if (isCurrentTrack) {
            const li = createSessionElement(schedule[i]);
            list.appendChild(li);
        }
    }
}

displaySchedule();
track1CheckBox.addEventListener("click", displaySchedule, false);
track2CheckBox.addEventListener("click", displaySchedule, false);
// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr
```



---
## Module review and takeaways
