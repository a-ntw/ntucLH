Module 14: Performing Background Processing by Using Web Workers
===
Contents:
- Module overview
- Lesson 1:	Understanding Web Workers
- Lesson 2:	Performing Asynchronous Processing by Using Web Workers
- Lab:	Creating a Web Worker Process
- Module review and takeaways

## Module overview
### Objectives
After completing this module, you will be able to:
- Explain how web workers can be used to implement multithreading and improve the responsiveness of a web 
application.
- Perform processing by using a web worker, communicate with a web worker, and control a web worker.

## Lesson 1: Understanding Web Workers
### Lesson objectives
After completing this lesson, you will be able to:
- Describe the purpose of web workers.
- List some common scenarios for using web workers.
- Explain how web workers run in an isolated environment.
- Describe the different types of web workers that HTML5 supports.

## Lesson 2: Performing Asynchronous Processing by Using Web Workers
### Lesson objectives
After completing this lesson, you will be able to:
- Create and terminate a dedicated web worker.
- Send messages to a web worker, and receive messages from a dedicated web worker.
- Explain how to implement the structure of a web worker.
- Explain how to create a shared web worker.

### Demonstration: Creating a Web Worker Process
#### Demonstration steps
You will find the steps in the “Demonstration: Creating a Web Worker Process“ section on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD14_DEMO.md.

## Lab: Creating a Web Worker Process
### Objectives
After completing this lab, you will be able to:
- Create a web worker and implement a web worker script.
- Send messages to and receive messages from a web worker.

#### Lab setup
Estimated Time: 60 minutes

You will find the high-level steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD14_LAB_MANUAL.md.

You will find the detailed steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD14_LAK.md.

### Exercise 1: Improving Responsiveness by Using a Web Worker
#### grayscale.js
``` jsx
function createCanvas(size) {
    /// <summary>Creates a canvas used for image manipulation.</summary>

    const temporaryCanvas = document.createElement("canvas");
    temporaryCanvas.setAttribute("width", size.width);
    temporaryCanvas.setAttribute("height", size.height);
    return temporaryCanvas;
};

function getImageData(context, image) {
    /// <summary>Draws the image onto the canvas context, then returns the resulting image data.</summary>

    context.drawImage(image, 0, 0);
    return context.getImageData(0, 0, image.width, image.height);
};



export function grayscaleImage(image) {
    // Converts a colour image into gray scale.

    // Return a new promise.
    return new Promise(function (resolve, reject) {   
        const canvas = createCanvas(image);
        const context = canvas.getContext("2d");
        const imageData = getImageData(context, image);

        // TODO: Create a Worker that runs /scripts/grayscale-worker.js
        const worker = new Worker("/scripts/grayscale-worker.js");
        const handleMessage = function (event) {
            // Update the canvas with the gray scaled image data.
            context.clearRect(0, 0, canvas.width, canvas.height);
            context.putImageData(event.data.done, 0, 0);

            // Returning a Promise makes this function easy to chain together with other deferred operations.
            // The canvas object is returned as this can be used like an image.
            resolve(canvas);
        };
        worker.addEventListener("message", handleMessage.bind(this));
        worker.postMessage(imageData);

       
    });
};
// SIG // Begin signature block
// SIG // MIIaaAYJKoZIhvcNAQcCoIIaWTCCGlUCAQExCzAJBgUr
```
#### speaker-badge.js
``` jsx
import { SpeakerBadgePage } from "../SpeakerBadgePage.js";

const badgeElement = document.querySelector(".badge");
new SpeakerBadgePage(badgeElement);

// SIG // Begin signature block
// SIG // MIIaaAYJKoZIhvcNAQcCoIIaWTCCGlUCAQExCzAJBgUr
```
#### grayscale-worker.js 
``` jsx
// This script is for a Web Worker.
addEventListener("message", function (event) {
    const imageData = event.data;
    let pixels = imageData.data;
    for (let i = 0; i < pixels.length; i += 4) {
        grayscalePixel(pixels, i);
    }
    postMessage({ done: imageData });
});

function grayscalePixel(pixels, index) {
    /// <summary>Updates the pixel, starting at the given index, to be gray scale.</summary>

    const brightness = 0.34 * pixels[index] + 0.5 * pixels[index + 1] + 0.16 * pixels[index + 2];

    pixels[index] = brightness; // red
    pixels[index + 1] = brightness; // green
    pixels[index + 2] = brightness; // blue
};

// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr
```

## Module review and takeaways
In this module, you have learned how to use web workers to implement parallel processing in a web application. 
A web worker runs a piece of JavaScript code in parallel to the web page; they may be implemented as separate 
threads or processes. A web page communicates with a web worker by sending and receiving messages.

There are two forms of web worker:

A dedicated web worker can only be referenced by the page that created it, and its lifetime is tied to that 
of the web page.

A shared web worker can be accessed by any web page in the web application that created it.

