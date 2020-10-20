Module 5: Communicating with a Remote Server
===
Contents:
- Lesson 1:	Async Programming in JavaScript
- Lesson 2:	Sending and Receiving Data by Using the XMLHttpRequest Object
- Lesson 3:	Sending and Receiving Data by Using the Fetch API
- Lab:	Communicating with a Remote Data Source
- Exercise 1: Retrieving Data
- Exercise 2: Serializing and Transmitting Data
- Exercise 3: Refactoring the Code by Using the async fetch Method
- Module review and takeaways
- myNote

---
## Module overview
In this module, you will learn how to access a web service by using JavaScript code and 
to incorporate remote data into your web applications. 
You will look at two technologies for achieving this: the **XMLHttpRequest** object, 
which acts as a programmatic wrapper around HTTP requests to remote web sites, and 
**Fetch API**, which simplifies many of the tasks involved in sending requests and receiving data. 
Because the **Fetch API** and **XMLHttpRequest** objects are asynchronous API, 
you will first learn about how to handle asynchronous tasks with the **Promise** object, 
**arrow functions** and the new **async**/**await** syntax that lets you handle asynchronous request as 
    if they were synchronous.

### Objectives
After completing this module, you will be able to:
- Handle asynchronous JavaScript tasks by using the new async programing technologies.
- Send data to a web service and receive data from a web service by using an XMLHttpRequest object.
- Send data to a web service and receive data from a web service by using the Fetch API object.

---
## Lesson 1:	Async Programming in JavaScript
### Lesson objectives
After completing this lesson, you will be able to:
- Explain arrow functions and how to use them to shorten JavaScript code.
- Describe **Promise** and how it helps to deal with asynchronous tasks.
- Create a new **Promise** object and use its methods to resolve or reject it.
- Use the **async**/**await** syntax to get synchronous-like behavior for asynchronous code.

### Arrow Functions
> * Arrow functions are a concise way to write JavaScript functions.
> * They help to shorten code length and save typing long code.
> * They are useful for small anonymous functions.
> * They use the **this** value of their enclosing execution context.

##### An old-style function expression
```jsx
    const combineText = function(text){
        return "I love to " + text;
    };
    combineText("eat"); // will return: "I love to eat".
```
##### An arrow function style of a function expression.
``` jsx
    let combineText = (text) => {
        return "I love to " + text;
    };
    combineText("eat"); 
```
##### Omit the return keyword and the curly brackets:
``` jsx 
    let combineText = text => "I love to " + text;
    combineText("eat"); 
```
When we have no parameters for the function, empty parentheses are required:

The following code example shows how you can write an arrow function without parameters.

##### Parameterless arrow function:
``` jsx 
    let logToConsole = () => console.log("logging…");
    logToConsole ();
```

### What is a Promise?
> * Promises help to handle asynchornous tasks.
> * A **Promise** object is a proxy for a future value.
> * It can be in one of four states:
>     * Fulfilled
>     * Rejected
>     * Pending
>     * Settled

The **Promise** object can be in one of the following states:
- Resolved. The task related to the **Promise** succeeded.
- Rejected. The task related to the **Promise** failed.
- Pending. The task related to the **Promise** is not yet fulfilled or rejected.
- Settled. The task related to the **Promise** is fulfilled or rejected.

##### Wrapping setTimeout
``` jsx
    let getPromise = timeToWait => new Promise(resolve => setTimeout(resolve, timeToWait, "bar"));
    getPromise(5000).then(data => console.log(data));
```
### The Promise Object
> * A **promise** object is initialed by its constructor and supplied by an executor.
> * A **Promise** object's **resolve**() and **reject**() methods indicate success or failure of the promise.
> * A **Promise** object's **then**() method is used for reactions when a promise is fulfilled or rejected, 
    and for chaining promises.
> * A **Promise** object's **all**() method is used to resolve multiple promises at the same time, 
regardless to their order.

##### Initiate new Promise using its constructor:
``` jsx
    let newPromise = new Promise((resolve, reject) => {

    });
```

This example shows how to wrap XMLHttpRequest functionality with a Promise object:

##### Using promises with XMLHttpRequest
``` jsx 
    let getRemoteData = url => new Promise((resolve, reject) => {
        let request = new XMLHttpRequest();

        request.onload = () => {
          if (request.status === 200){
            resolve(request.response);
          }
          else {
            reject(Error(request.statusText));
          }
        };

        // Handle network errors
        request.onerror = () =>  {
          reject(Error("Network error occurred"));
        };

         request.open("GET", url);
         request.send();
    });
```
This example shows how to handle the promise returned from the function.

##### Handling promises
``` jsx
    getRemoteData("http://contoso.com/resources/...")
    .then(data => console.log("success!", data))
    .catch(error => console.log("failed!", error));
```
#### The then() method
#### Chaining promises
##### Chaining promises
``` jsx
    getRemoteData("http://contoso.com/resources/...")
    .then(result => getMoreRemoteData("http://fake.com/resources/...", result))
    .then(newResult => getOtherKindOfRemoteData("http://dummy.com/resources/...", newResult))
    .then(finalResult => console.log('Final result arrived', finalResult));
``` 
##### Using Promise.all()
``` jsx 
    Promise.all([
        getForecast(/* here will come the first url */),
        getFootballScores(/* here will come the second url */),
        getShirtsPrices(/* here will come the third url */)
    ]).then(results => console.log('All results arrived!', results));
```

### Async/await
> * **Async/await** statements were built on top of promises.
    They allow us to write asynchronous code as it it were synchronous
> * Using **async/await** syntax make our code cleaner, and 
    let us debug and handle errors the same way we do in synchronous code.
> * The **Await** statement is allowed only within an **async** function. 
    An **async** function is defined by using the **async** keyword.
> * **Await** statements are run in serial, one at a time.
    For running a few promises concurrently, 
    you should use the the **Promise.all** method.

This includes:
- Using **try**/**catch** blocks.
- The ability to debug the code by putting a breakpoint at the beginning of the asynchronous code statements 
    and move to the next statements as if they were synchronous calls.

##### Async/await example
``` jsx
    let myAsyncFunc = async function(url1, url2, url3){
        try{
            let result = await getRemoteData(url1);
            let newResult = await getMoreRemoteData(url2, result);
            let finalResult = await getOtherKindOfRmoteData(url3, newResult);
            console.log("Final result arrived", finalResult);
        }
        catch(error)
        {
            //handle errors here
        }
    }

    Let url1 = "http://contoso.com/resources/...";
    Let url2 = "http://fake.com/resources/...";
    Let url3 = "http://dummy.com/resources/...";
    myAsyncFunc(url1, url2, url3);
```

---
## Lesson 2:	Sending and Receiving Data by Using the XMLHttpRequest Object
### Lesson objectives
After completing this lesson, you will be able to:
- Explain how a browser uses HTTP **GET** requests to retrieve remote data.
- Explain how to use the **XMLHttpRequest** object to send a request to a remote server.
- Describe how to handle errors that can occur when sending requests and receiving responses.
- Handle the data returned by a server in response to a request.
- Process the received data asynchronously.
- Send messages that transmit data to a server.

### How a Browser Retrieves Web Pages
> * A web browser issues HTTP **GET** requests to fetch a web page to display
>     * The response is parsed into a DOM structure
>     * The browser renders the DOM structure
>     * Elements with a **src** attribute can initiale further HTTP **GET** requests
>    * JavaScript code can trigger HTTP **GET** requests

### Using the XMLHttpRequest Object to Access Remote Data
> * To send an HTTP request:
>     1. Create a new **XMLHTTPRequest** object
>     2. Specify the HTTP method and URL
>     3. Set the request header
>     4. Send the request
> ``` jsx
>         var request = new XMLHTTPRequest();
>         var url = "http://contoso.com/resources/...";
>         request.open("GET", url);
>         request.send();
> ```
> * Requests are asynchronous by default
>     * To block and wait for a response:
> ```jsx
>         request.open(method, url, false);
> ```
The **open()** method defines the HTTP method and the url for this request. 
The HTTP method can be set to either **GET**, **POST**, or **HEAD**. 
You use **GET** to request a known resource without parameters, 
while you use **POST** to send parameterized data to the server, most commonly form data, 
to be parsed as part of the request. **HEAD** specifies that the response should only be header information, and can be useful, for example, to get a summary of a large resource ahead of actually downloading it.

To transmit the request, call the **send()** method. Note that the browser automatically handles the sending of any cookies associated with the domain, based on the value of the URL.

### Handling HTTP Errors
> * Check the status code of the **XMLHttpRequest** object to verify that the request has been sent:
> ```jsx
>     var request = new XMLHttpRequest();
>     request.open("GET", "/luckydip/enter");
>     request.send();
>     ...
>     if (request.status != 200) {
>         alert("Error " + request.status + " - " + request.statusText); 
>     }
> ```
> * Wrap your code in a **try ... catch** block to handle any unexpected betwoek erros

``` jsx
    try {
      /* JavaScript code that might trigger an exception */
      ...
    } catch (exception) {
      /* Handle any exceptions here. This example displays the exception to the user */
      alert(exception);
    }
```

Additional Reading: For more information about the different HTTP status codes that can occur, and their meaning, see https://aka.ms/moc-20480c-m5-pg1

### Consuming the Response
> * Determine the type of data in the response
> * Read the response data from the **responseText** property
> ``` jsx
>     var request = new XMLHttpRequest();
>     ...   
>     var type = request.getResponseHeader();
>     switch( type ) {
>         case "text/xml" :
>             return request.responseXML;
>         case "text/json" :
>             return JSON.parse(request.responseText);
>         default :
>             return request.responseText;
>     }
> ```

### Handling an Asynchronous Response
> * Create an event handler for the **readystatechange** event
> * Check that the **readyState** of the **XMLHttpRequest** object is set to 4
> ``` jsx
>     request.onreadystatechange = function() {
>         if (request.readyState === 4) {
>             const response = JSON.parse(request.responseText);
>             ...
>         }
>     };
> ``` 
The **XMLHttpRequest** object has a **readyState** property that can have one of the following values:
- **0**: The **XMLHttpRequest** object is has not been opened.
- **1**: The **XMLHttpRequest** object has been opened.
- **2**: The **XMLHttpRequest** object has sent a request.
- **3**: The **XMLHttpRequest** object has started to receive a response.
- **4**: The **XMLHttpRequest** object has finished receiving a response.

### Transmitting Data with a Request
> To send data to a Server:
> 1. Serialize the data
> 2. Set the **Contacnt-Type** property of the request header
> 3. Transmit the data by using the HTTP **POST** method
> ``` jsx
>     var data = JSON.stringify(...);
>     var request = new XMLHTTPRequest();
>     var url = ...;
>     request.open("POST", url);
>     request.setRequestHeader("Content-Type", "text/plain");
>     request.send(data);
>  ```

---
## Lesson 3:	Sending and Receiving Data by Using the Fetch API
### Lesson objectives
After completing this lesson, you will be able to:
- Explain how to use **Fetch API** to transmit and receive data from a server.
- Combine **Fetch API**, arrow functions and **async**/**await** to get a clean and readable code.
- Describe how **Fetch API** uses promises to handle server response.

### Using the Fetch API to Send Asynchronous Requests
> Use **fetch()** method to get a resource from server:
> * For a **GET** request, supply a URL as the forst argument.
> * For a **POST** request, supply the URL and an **options** object with the initial settings.
> These may include values for: **headers**, **body** and **credentials**.
> ``` jsx
>     fetch( url, {
>         body: JSON.stringify(data),
>         credentials: "include",
>         headers: {
>             "Content-Type": "application/json"
>         },
>         method "POST"
>     });
> ```

### Handling Promises
> * When callinf **fetch**(), it returs a **Promise** object.
> * This object can be used within a **then**() call, to get access to the **Respinse** object returned by the server.
> * A **Promise** object resolved to server data is available by calling **response.json**().

### Using async functions
> **Fetch API** and **async**/**await** techniques can combine together to make cleaner code:
> ``` jsx
>     let getResponse = async () => {
>         let response = await fetch("http://contoso.com/resources/...");
>         let json = await response.json();
>         console.log(json);
>     };
> ``` 

### Demonstration: Communicating with a Remote Data Source
#### emonstration steps
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD05_DEMO.md.

---
## Lab:	Communicating with a Remote Data Source
### Objectives
After completing this lab, you will be able to:
1. Write JavaScript code to retrieve data from a remote data source.
2. Write JavaScript code to send data to a remote data source.
3. Use the async fetch method to simplify code that performs remote communications.

#### Lab setup
Estimated Time: 60 minutes

You will find the high-level steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD05_LAB_MANUAL.md

You will find the detailed steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD05_LAK.md

### Exercise 1: Retrieving Data
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod05/Labfiles/Solution/Exercise%201/ContosoConf/scripts/pages/schedule.js
#### schedule.js
``` jsx
let schedule = [];
const list = document.getElementById("schedule");
const track1CheckBox = document.getElementById("show-track-1");
const track2CheckBox = document.getElementById("show-track-2");

// TODO: Create a function called downloadSchedule
//       Use an XMLHttpRequest to GET "/schedule/list"
//       The response will be a JSON object of the form "{ schedule: [ ... ] }"
//       Save the array into the schedule variable
//       Then call displaySchedule()
function downloadSchedule() {
    const request = new XMLHttpRequest();
    request.open("GET", "/schedule/list", true);
    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            try {
                const response = JSON.parse(request.responseText);
                if (request.status === 200) {
                    schedule = response.schedule;
                    displaySchedule();
                } else {
                    alert(response.message);
                }
            } catch (exception) {
                alert("Schedule list not available.");
            }
        }
    };
    request.send();
}

function createSessionElement(session) {
    const li = document.createElement("li");

    li.sessionId = session.id;

    const star = document.createElement("a");
    star.setAttribute("href", "#");
    star.setAttribute("class", "star");
    li.appendChild(star);

    const title = document.createElement("span");
    title.textContent = session.title;
    li.appendChild(title);

    return li;
};

function clearList() {
    while (list.firstChild) {
        list.removeChild(list.firstChild);
    }
}

function displaySchedule() {
    clearList();
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

function saveStar(sessionId, isStarred) {
    // TODO: Create an XMLHttpRequest that POSTs to "/schedule/star/{sessionId}"
    //       The request body must have the content type "application/x-www-form-urlencoded"
    //       e.g. "starred=true" or "starred=false"
    //       The response contains a JSON object "{ starCount: <number> }"
    //       If the star count is more than 50, warn the user about this being a busy session.
}

function handleListClick(event) {
    const isStarElement = event.srcElement.classList.contains("star");
    if (isStarElement) {
        event.preventDefault(); // Stop the browser following the clicked <a> element's href.

        const listItem = event.srcElement.parentNode;
        if (listItem.classList.contains("starred")) {
            listItem.classList.remove("starred");
            saveStar(listItem.sessionId, false);
        } else {
            listItem.classList.add("starred");
            saveStar(listItem.sessionId, true);
        }
    }
}

track1CheckBox.addEventListener("click", displaySchedule, false);
track2CheckBox.addEventListener("click", displaySchedule, false);
list.addEventListener("click", handleListClick, false);

downloadSchedule();
// SIG // Begin signature block
// SIG // MIIaaAYJKoZIhvcNAQcCoIIaWTCCGlUCAQExCzAJBgUr
```

### Exercise 2: Serializing and Transmitting Data
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod05/Labfiles/Solution/Exercise%202/ContosoConf/scripts/pages/schedule.js
#### schedule.js
``` jsx
let schedule = [];
const list = document.getElementById("schedule");
const track1CheckBox = document.getElementById("show-track-1");
const track2CheckBox = document.getElementById("show-track-2");

function downloadSchedule() {
    const request = new XMLHttpRequest();
    request.open("GET", "/schedule/list", true);
    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            try {
                const response = JSON.parse(request.responseText);
                if (request.status === 200) {
                    schedule = response.schedule;
                    displaySchedule();
                } else {
                    alert(response.message);
                }
            } catch (exception) {
                alert("Schedule list not available.");
            }
        }
    };
    request.send();
}

function createSessionElement(session) {
    const li = document.createElement("li");

    li.sessionId = session.id;

    const star = document.createElement("a");
    star.setAttribute("href", "#");
    star.setAttribute("class", "star");
    li.appendChild(star);

    const title = document.createElement("span");
    title.textContent = session.title;
    li.appendChild(title);

    return li;
};

function clearList() {
    while (list.firstChild) {
        list.removeChild(list.firstChild);
    }
}

function displaySchedule() {
    clearList();
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

function saveStar(sessionId, isStarred) {
    // TODO: Create an XMLHttpRequest that POSTs to "/schedule/star/{sessionId}"
    //       The request body must have the content type "application/x-www-form-urlencoded"
    //       e.g. "starred=true" or "starred=false"
    //       The response contains a JSON object "{ starCount: <number> }"
    //       If the star count is more than 50, warn the user about this being a busy session.
    const request = new XMLHttpRequest();
    request.open("POST", "/schedule/star/" + sessionId, true);
    if (isStarred) {
        request.onreadystatechange = function() {
            if (request.readyState === 4 && request.status === 200) {
                const response = JSON.parse(request.responseText);
                if (response.starCount > 50) {
                    alert("This session is very popular! Be sure to arrive early to get a seat.");
                }
            }
        };
    }
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    const data = "starred=" + isStarred;
    request.send(data);
}

function handleListClick(event) {
    const isStarElement = event.srcElement.classList.contains("star");
    if (isStarElement) {
        event.preventDefault(); // Stop the browser following the clicked <a> element's href.

        const listItem = event.srcElement.parentNode;
        if (listItem.classList.contains("starred")) {
            listItem.classList.remove("starred");
            saveStar(listItem.sessionId, false);
        } else {
            listItem.classList.add("starred");
            saveStar(listItem.sessionId, true);
        }
    }
}

track1CheckBox.addEventListener("click", displaySchedule, false);
track2CheckBox.addEventListener("click", displaySchedule, false);
list.addEventListener("click", handleListClick, false);

downloadSchedule();

// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr
```

### Exercise 3: Refactoring the Code by Using the async fetch Method
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod05/Labfiles/Solution/Exercise%203/ContosoConf/scripts/pages/schedule.js
#### schedule.js
``` jsx
let schedules = [];
const list = document.getElementById("schedule");
const track1CheckBox = document.getElementById("show-track-1");
const track2CheckBox = document.getElementById("show-track-2");

const downloadSchedule = async () => {
       // await response of fetch call
       let response = await fetch("/schedule/list");

       // checking response is ok
       if (response.ok) {
           // transform body to json
           let data = await response.json();
           schedules = data.schedule;
           displaySchedule();
       }
       else
           alert("Schedule list not available.");
}

const createSessionElement = (session) => {
    const li = document.createElement("li");

    li.sessionId = session.id;

    const star = document.createElement("a");
    star.setAttribute("href", "#");
    star.setAttribute("class", "star");
    li.appendChild(star);

    const title = document.createElement("span");
    title.textContent = session.title;
    li.appendChild(title);

    return li;
}

const clearList = () => {
    while (list.firstChild) {
        list.removeChild(list.firstChild);
    }
}

const displaySchedule = () => {
    clearList();
    for (let schedule of schedules) {
        const tracks = schedule.tracks;
        const isCurrentTrack = track1CheckBox.checked && tracks.indexOf(1) >= 0 ||
                             track2CheckBox.checked && tracks.indexOf(2) >= 0;
        if (isCurrentTrack) {
            const li = createSessionElement(schedule);
            list.appendChild(li);
        }
    }
}

const saveStar = async (sessionId, isStarred) => {

    const headers = new Headers({
        "Content-Type": "application/x-www-form-urlencoded"
    })


    const options = {
        method: 'POST',
        headers: headers,
        body: "starred=" + isStarred
    }

    const response = await fetch("/schedule/star/" + sessionId, options);

    if (isStarred) {
        if (response.ok) {
            const data = await response.json();
            if (data.starCount > 50)
                alert("This session is very popular! Be sure to arrive early to get a seat.");
        }
    }
}


const handleListClick = async (event) => {
    const isStarElement = event.srcElement.classList.contains("star");
    if (isStarElement) {
        event.preventDefault(); // Stop the browser following the clicked <a> element's href.

        const listItem = event.srcElement.parentNode;
        if (listItem.classList.contains("starred")) {
            listItem.classList.remove("starred");
            await saveStar(listItem.sessionId, false);
        } else {
            listItem.classList.add("starred");
            await saveStar(listItem.sessionId, true);
        }
    }
}

track1CheckBox.addEventListener("click", displaySchedule, false);
track2CheckBox.addEventListener("click", displaySchedule, false);
list.addEventListener("click", handleListClick, false);

downloadSchedule();
// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr

```


---
## Module review and takeaways
In this module, you have learned how to write better asynchronous code using **promises**, **arrow functions** and **async**/**await**.

You have learned how to use the **XMLHttpRequest** object to send a request to a remote server and handle any response that is returned. You have seen how to perform these operations synchronously and asynchronously, and you have also learned how to catch and handle any error that might occur when a web application sends a request to a remote server.

You have seen how to use the **Fetch API** to simplify many of the operations associated with sending and receiving data, and in particular you have learned how to use the **fetch**() function to perform these tasks in a concise manner.

---
### myNote
#### What are the examples of asynchronous?
An asynchronous communication service or application does not require a constant bit rate. 
Examples are file transfer, email and the World Wide Web. 
An example of the opposite, a synchronous communication service, is realtime streaming media, 
for example IP telephony, IP-TV and video conferencing.
https://en.wikipedia.org/wiki/Asynchronous_communication
