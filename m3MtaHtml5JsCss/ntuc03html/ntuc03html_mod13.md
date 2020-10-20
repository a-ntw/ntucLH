Module 13: Implementing Real-time Communication by Using WebSockets
===
Contents:
- Module overview
- Lesson 1:	Introduction to WebSockets
- Lesson 2:	Using the WebSocket API
- Lab:	Performing Real-time Communication by Using WebSockets
- Module review and takeaways

## Module overview
### Objectives
After completing this module, you will be able to:
- Describe how using WebSockets helps to enable real-time communications between a web page and a web server.
- Use the WebSockets API to connect to a web server from a web page, and exchange messages between the web page 
and the web server.

## Lesson 1: Introduction to WebSockets
### Lesson objectives
After completing this lesson, you will be able to:
- Explain the problems that WebSockets are intended to solve.
- Describe how a client application connects to a server and exchanges data by using a WebSocket.

Additional Reading: You can read RFC6455 at http://go.microsoft.com/fwlink/?LinkID=267756 and the latest copy 
of the WebSockets API at http://go.microsoft.com/fwlink/?LinkID=267755.

## Lesson 2: Using the WebSocket API
### Lesson objectives
After completing this lesson, you will be able to write JavaScript code in a web page that:
- Connects to and disconnects from a web server by using a WebSocket.
- Sends messages to a server by using a WebSocket.
- Receives messages from a server by using a WebSocket.

### Demonstration: Performing Real-time Communication by Using WebSockets
####Demonstration steps
You will find the steps in the “Demonstration: Performing Real-time Communication by Using WebSockets“ section 
on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD13_DEMO.md.

## Lab: Performing Real-time Communication by Using WebSockets
### Objectives
After completing this lab, you will be able to:
- Create a WebSocket that connects to a server and receives messages.
- Serialize and send messages to a WebSocket.
- Send and receive different types of messages by using a WebSocket.

#### Lab setup
Estimated Time: 90 minutes

You will find the high-level steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD13_LAB_MANUAL.md.

You will find the detailed steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD13_LAK.md.

### Exercise 1: Receiving Messages from a WebSocket
#### live.js
``` jsx
import {LivePage} from "../LivePage.js";
// TODO: Create a web socket connection to ws://localhost:55981/live/socket.ashx
const socket = new WebSocket("ws://localhost:55981/live/socket.ashx");
new LivePage(
    socket,
    document.querySelector("section.live")
);

// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr
```

### Exercise 2: Sending Messages to a WebSocket

### Exercise 3: Handling Different WebSocket Message Types
#### LivePage.js
``` jsx
export class LivePage {

    constructor(socket, sectionElement) {
        this.initializeSocket(socket);
        this.initializeUI(sectionElement);
    }

    initializeSocket(socket) {
        this.socket = socket;
        // TODO: Assign a callback to handle messages from the socket.
        this.socket.onmessage = this.handleSocketMessage.bind(this);
    }

    initializeUI(sectionElement) {
        this.questionListElement = sectionElement.querySelector("ul");
        this.questionInput = sectionElement.querySelector("input");

        const form = sectionElement.querySelector("form");
        form.addEventListener("click", this.handleFormSubmit.bind(this), false);

        this.questionListElement.addEventListener("click", this.handleQuestionsClick.bind(this), false);
    }

    handleFormSubmit(event) {
        // Prevent the form actually submitting.
        event.preventDefault();

        const text = this.questionInput.value;
        if (text) {
            this.askQuestion(text);
        }
    }

    askQuestion(text) {
        // TODO: Create a message object with the format { ask: text }

        // TODO: Convert the message object into a JSON string

        // TODO: Send the message to the socket

        // Clear the input ready for another question.
        this.questionInput.value = "";
    }

    handleSocketMessage(event) {
        // TODO: Parse the event data into message object.
        const message = JSON.parse(event.data);

        // TODO: Check if message has a `questions` property, before calling handleQuestionsMessage
        if (message.questions) {
            this.handleQuestionsMessage(message);
        }
    }

    handleQuestionsMessage(message) {
        // message has the form:
        //   { questions: [
        //         { text: "...", id: 1 },
        //         { text: "...", id: 2 }
        //   ] }

        // TODO: Display each question in the page, using the displayQuestion function.
        message.questions.forEach(this.displayQuestion, this);
    }

    handleRemoveMessage(message) {
        const listItems = this.questionListElement.querySelectorAll("li");
        for (let i = 0; i < listItems.length; i++) {
            if (listItems[i].questionId === message.remove) {
                this.questionListElement.removeChild(listItems[i]);
                break;
            }
        }
    }

    displayQuestion(question) {
        const item = this.createQuestionItem(question);
        //item.appendChild(this.createReportLink());
        this.questionListElement.appendChild(item);
    }

    createQuestionItem(question) {
        const item = document.createElement("li");
        item.textContent = question.text + " ";
        item.questionId = question.id;
        return item;
    }

    createReportLink() {
        const report = document.createElement("a");
        report.textContent = "Report";
        report.setAttribute("href", "#");
        report.setAttribute("class", "report");
        return report;
    }

    handleQuestionsClick(event) {
        event.preventDefault();

        const clickedElement = event.srcElement || event.target;
        if (this.isReportLink(clickedElement)) {
            const questionId = clickedElement.parentNode.questionId;
            this.reportQuestion(questionId);
            clickedElement.textContent = "Reported";
        }
    }

    isReportLink(element) {
        return element.classList && element.classList.contains("report");
    }

    reportQuestion(questionId) {
        // TODO: Send socket message { report: questionId }
    }
}
// SIG // Begin signature block
// SIG // MIIdkAYJKoZIhvcNAQcCoIIdgTCCHX0CAQExCzAJBgUr
```


## Module review and takeaways
In this module, you have learned how WebSockets provide a fast, robust and efficient solution for real-time 
communication between a web page and its server. You have also learned how to connect to a WebSocket from 
a client application by using the WebSocket API, and how to send and receive messages over a WebSocket.
