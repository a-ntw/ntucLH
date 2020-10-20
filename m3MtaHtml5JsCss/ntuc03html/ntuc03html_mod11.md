Module 11: Creating Advanced Graphics
===
Contents:
- Module overview
- Lesson 1:	Creating Interactive Graphics by Using SVG
- Lesson 2:	Drawing Graphics by Using the Canvas API
- Lab:	Creating Advanced Graphics
- Module review and takeaways

## Module overview
### Objectives
After completing this module, you will be able to:
- Use SVG to create interactive graphical content.
- Use the Canvas API to generate graphical content programmatically.

## Lesson 1: Creating Interactive Graphics by Using SVG
### Lesson objectives
After completing this lesson, you will be able to:
- Describe the elements of SVG.
- Create an <svg> element and embed simple graphical elements inside it.
- Use SVG to draw circles and ellipses.
- Use SVG to draw complex shapes.
- Apply fill styles and strokes to SVG elements.
- Use gradients and patterns to fill SVG elements.
- Use SVG to draw text.
- Apply transformations to SVG elements.

### Demonstration: Using Scalable Vector Graphics (SVG) Transformations and Events
#### Demonstration steps
You will find the steps in the “Demonstration: Using Scalable Vector Graphics (SVG) Transformations and 
Events“ section on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD11_DEMO.md

## Lesson 2: Drawing Graphics by Using the Canvas API
### Lesson objectives
After completing this lesson, you will be able to:
- Describe how the Canvas API works.
- Create a <canvas> element on a web page and use the Canvas API to draw simple shapes and lines.
- Use the Canvas API to draw complex shapes.
- Fill shapes by using gradients and patterns.
- Apply transformations and animations to canvas drawings.

### Demonstration: Performing Transformations by Using the Canvas API
#### Demonstration steps
You will find the steps in the “Demonstration: Performing Transformations by Using the Canvas API“ section o
n the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD11_DEMO.md.

### Demonstration: Creating Advanced Graphics
#### Demonstration steps
You will find the steps in the “Demonstration: Creating Advanced Graphics“ section on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD11_DEMO.md.

## Lab: Creating Advanced Graphics
### Objectives
After completing this lab, you will be able to:
- Create graphics by using Scalable Vector Graphics (SVG), interactively style SVG graphics, and 
handle SVG graphics events.
- Draw graphics by using the Canvas API.

#### Lab setup
Estimated Time: 60 minutes

You will find the high-level steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD11_LAB_MANUAL.md.

You will find the detailed steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD11_LAK.md.

### Exercise 1: Creating an Interactive Venue Map by Using SVG
#### location.htm
``` html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>ContosoConf location and venue map</title>

    <link href="/styles/site.css" rel="stylesheet" type="text/css" />
    <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
    <link href="/styles/header.css" rel="stylesheet" type="text/css" />
    <link href="/styles/footer.css" rel="stylesheet" type="text/css" />

    <link href="/styles/pages/location.css" rel="stylesheet" type="text/css" />

    <link href="/styles/mobile.css" rel="stylesheet" type="text/css" />
    <link href="/styles/print.css" media="print" rel="stylesheet" type="text/css" />
</head>

<body>

    <nav class="page-nav">
        <div class="container">
            <a href="/index.htm">Home</a>
            <a href="/about.htm">About</a>
            <a href="/schedule.htm">Schedule</a>
            <a href="/register.htm">Register</a>
            <a href="/location.htm" class="active">Location</a>
        </div>
    </nav>

    <header class="page-header">
        <div class="container">
            <h1>ContosoConf</h1>
            <p class="tag-line">A two-track conference on the latest HTML5 developments</p>
        </div>
    </header>

    <section class="page-section location">
        <div class="container">
            <section class="travel">
                <h1>Travelling to ContosoConf</h1>
                <h2 id="distance"></h2>
                <h2>Address</h2>
                <address>
                    Conference Center
                    <br/> 1234 Main Street
                    <br/> Seattle
                    <br/> WA 98999
                </address>
                <h2>Hotels</h2>
                <p>...</p>
            </section>

            <section class="venue">
                <h1>Interactive conference venue map</h1>
                <div id="venue-map">
                    <svg viewBox="-1 -1 302 102" width="100%" height="230">
                        <!-- Room A -->
                        <g id="room-a" class="room">
                            <rect fill="#fff" x="0" y="0" width="100" height="100"></rect>
                            <text x="13" y="55" font-weight="bold" font-size="20">ROOM A</text>
                        </g>
                        <!-- Room B -->
                        <g id="room-b" class="room">
                            <rect fill="#fff" x="200" y="0" width="100" height="100"></rect>
                            <text x="213" y="55" font-weight="bold" font-size="20">ROOM B</text>
                        </g>

                        <!-- The outline of the building -->
                        <polyline fill="none" stroke="#000" points="135,95 140,100 0,100 0,0 100,0 100,80 130,80 130,70 110,70 110,30 190,30 190,70 170,70 170,80 200,80 200,0 300,0 300,100 160,100 165,95"></polyline>
                        <text x="150" y="55" font-size="12" style="text-anchor: middle">Registration</text>
                    </svg>

                    <div id="instruction">
                        <p>Click a room on the map to see more information.</p>
                    </div>
                    <div id="room-a-info" style="display: none">
                        <h2>Room A</h2>
                        <p>Capacity: 250</p>
                        <p>Popular sessions in here:</p>
                        <ul>
                            <li>Diving in at the deep end with Canvas</li>
                            <li>Real-world Applications of HTML5 APIs</li>
                            <li>Transforms and Animations</li>
                        </ul>
                    </div>
                    <div id="room-b-info" style="display: none">
                        <h2>Room B</h2>
                        <p>Capacity: 230</p>
                        <p>Popular sessions in here:</p>
                        <ul>
                            <li>Building Responsive UIs</li>
                            <li>Getting to Grips with JavaScript</li>
                            <li>A Fresh Look at Layouts</li>
                        </ul>
                    </div>
                </div>
            </section>
        </div>
    </section>

    <footer class="page-footer">
        <div class="container">
            <p>
                Hosted by Contoso
            </p>
            <address>
                Conference Center
                <br /> 1234 Main Street
                <br /> Seattle
                <br /> WA 98999
            </address>
            <p>
                &#169; 2012 Contoso
            </p>
        </div>
    </footer>

    <script src="/scripts/pages/location.js" type="module"></script>
    <script src="/scripts/pages/location-venue.js" type="module"></script>
</body>

</html>
```
#### location.css
``` css
/* Styles for the location page */

#venue-map {
    display: -ms-grid;
    -ms-grid-columns: 75% 25%;
}

#venue-map svg {
    display: block;
    -ms-grid-row: 1;
    -ms-grid-column: 1;
}

#venue-map div {
    padding-left: 3rem;
    -ms-grid-row: 1;
    -ms-grid-column: 2;
}

.room {
    cursor: pointer;
}

.room:hover rect {
    fill: #b1f8b0;
}
```

### Exercise 2: Creating a Speaker Badge by Using the Canvas API
#### speaker-badge.htm
``` html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>Speaker badge for ContosoConf</title>

    <link href="/styles/site.css" rel="stylesheet" type="text/css" />
    <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
    <link href="/styles/header.css" rel="stylesheet" type="text/css" />
    <link href="/styles/footer.css" rel="stylesheet" type="text/css" />

    <link href="/styles/pages/speaker-badge.css" rel="stylesheet" type="text/css" />

    <link href="/styles/mobile.css" rel="stylesheet" type="text/css" />
    <link href="/styles/print.css" media="print" rel="stylesheet" type="text/css" />
</head>

<body>

    <nav class="page-nav">
        <div class="container">
            <a href="/index.htm">Home</a>
            <a href="/about.htm">About</a>
            <a href="/schedule.htm">Schedule</a>
            <a href="/register.htm">Register</a>
            <a href="/location.htm">Location</a>
        </div>
    </nav>

    <header class="page-header">
        <div class="container">
            <h1>ContosoConf</h1>
            <p class="tag-line">A two-track conference on the latest HTML5 developments</p>
        </div>
    </header>

    <section class="page-section badge">
        <div class="container">
            <h1>Create your speaker badge for ContosoConf</h1>
            <!-- TODO: Add canvas here -->
        </div>
    </section>

    <footer class="page-footer">
        <div class="container">
            <p>
                Hosted by Contoso
            </p>
            <address>
                Conference Center
                <br /> 1234 Main Street
                <br /> Seattle
                <br /> WA 98999
            </address>
            <p>
                &#169; 2012 Contoso
            </p>
        </div>
    </footer>

    <script src="/scripts/pages/speaker-badge.js" type="module"></script>
</body>

</html>
```
####  speakerbadgePage.js
``` jsx
export class speakerBadgePage {

    constructor(element) {
        this.canvas = element.querySelector("canvas");

        this.speakerId = this.canvas.getAttribute("data-speaker-id");
        this.speakerName = this.canvas.getAttribute("data-speaker-name");
        this.canvas.addEventListener("dragover", this.handleDragOver.bind(this));
        this.canvas.addEventListener("drop", this.handleDrop.bind(this));

        this.drawBadge();
    }

    handleDragOver(event) {
        event.stopPropagation();
        event.preventDefault();
        event.dataTransfer.dropEffect = 'copy'; // Makes the browser display a "copy" cursor.
    }

    handleDrop(event) {
        event.stopPropagation();
        event.preventDefault();

        const files = event.dataTransfer.files;
        if (files.length == 0) return;

        // More than one file could have been dropped, we'll just use the first.
        const file = files[0];
        if (this.isImageType(file.type)) {
            this.readFile(file)
                .then((file) => this.loadImage(file))
                .then((file) => this.drawBadge(file));
        } else {
            alert("Please drop an image file.");
        }
    }

    drawBadge(image) {
        // TODO: Get the canvas's (this.canvas) context and assign to this.context

        // TODO: Draw the following by calling the helper methods of `this`
        //       background
        //       top text
        //       speaker name
        //       image (or placeholder if no image)
        //       bar code (passing this.speakerId)
    }

    drawBackground() {
        // TODO: Fill the canvas with a white rectangle
    }

    drawSpeakerImage(image) {
        // TODO: Draw the image on the canvas
        //       Draw only the center square of the image
        //       Draw at:
        //       x, y = 20, 20
        //       w, h = 160, 160
    }

    drawImagePlaceholder() {
        this.context.strokeStyle = "2px #888";
        this.context.strokeRect(20, 20, 160, 160);
        this.context.font = "12px sans-serif";
        this.context.textBaseline = "middle";
        this.context.textAlign = "center";
        this.context.fillStyle = "black";
        this.context.fillText("Drag your profile photo here", 100, 100);
    }

    drawTopText() {
        this.context.font = "20px sans-serif";
        this.context.fillStyle = "black";
        this.context.textBaseline = "top";
        this.context.textAlign = "left";
        this.context.fillText("ContosoConf 2013 Speaker:", 200, 20);
    }

    drawSpeakerName() {
        // TODO: Draw this.speakerName on the canvas
        //       x, y = 200, 60
        //       font = 40px sans-serif
        //       fill style = black
        //       text baseline = top
        //       text align = left
    }

    drawBarCode(text) {
        text = "*" + text + "*"; // Wrap in "*" deliminators.
        const encodings = {
            "0": "bwbWBwBwb",
            "1": "BwbWbwbwB",
            "2": "bwBWbwbwB",
            "3": "BwBWbwbwb",
            "4": "bwbWBwbwB",
            "5": "BwbWBwbwb",
            "6": "bwBWBwbwb",
            "7": "bwbWbwBwB",
            "8": "BwbWbwBwb",
            "9": "bwBWbwBwb",
            "*": "bWbwBwBwb"
        };
        let x = 200, y = 140, height = 40, thick = 6, thin = 2;
        for (let charIndex = 0; charIndex < text.length; charIndex++) {
            const code = encodings[text[charIndex]];
            for (let stripeIndex = 0; stripeIndex < code.length; stripeIndex++) {
                if (stripeIndex % 2 === 0) {
                    this.context.fillStyle = "black";
                } else {
                    this.context.fillStyle = "white";
                }
                const isWideStripe = code.charCodeAt(stripeIndex) < 91;
                if (isWideStripe) {
                    this.context.fillRect(x, y, thick, height);
                    x += thick;
                } else {
                    this.context.fillRect(x, y, thin, height);
                    x += thin;
                }
            }

            if (charIndex < text.length - 1) {
                // Space between each
                this.context.fillStyle = "white";
                this.context.fillRect(x, y, thin, height);
                x += thin;
            }
        }
    }

    isImageType(type) {
        const imageTypes = ["image/jpeg", "image/jpg", "image/png"];
        return imageTypes.indexOf(type) === 0;
    }

    readFile(file) {
        // Return a new promise.
        return new Promise(function (resolve, reject) {

            const reader = new FileReader();

            reader.onload = function (loadEvent) {
                const fileDataUrl = loadEvent.target.result;

                resolve([fileDataUrl]);
            };

            reader.readAsDataURL(file);
        });
    }

    loadImage(imageUrl) {
        // Return a new promise.
        return new Promise(function (resolve, reject) {
            const image = new Image();

            image.onload = function () {
                resolve(image);
            };

            image.src = imageUrl; // This starts the image loading
        });
        
    }
}
// SIG // Begin signature block
// SIG // MIIdkAYJKoZIhvcNAQcCoIIdgTCCHX0CAQExCzAJBgUr
```

## Module review and takeaways
In this module, you have seen how to use SVG and the Canvas API to draw graphical content in a web page.

SVG uses a retained drawing model, which means SVG elements are retained in the DOM tree. You can access 
SVG elements by using DOM functions, you can style SVG elements by using CSS style rules, and you can 
handle user-interaction events on SVG elements.

The Canvas API uses a fire-and-forget drawing model, which means shapes are drawn on the canvas 
but are not retained in the DOM tree. You cannot access shapes in a canvas by using DOM functions, 
or style the shapes, or handle any events on them. Nonetheless, the Canvas API is very useful 
if you need to draw static graphical images on the web page.
