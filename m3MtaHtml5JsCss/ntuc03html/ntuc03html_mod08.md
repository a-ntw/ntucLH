Module 8: Creating Interactive Pages by Using HTML5 APIs
===
Contents:
- Module overview
- Lesson 1:	Interacting with Files
- Lesson 2:	Incorporating Multimedia
- Lesson 3:	Reacting to Browser Location and Context
- Lesson 4:	Debugging and Profiling a Web Application
- Lab:	Creating Interactive Pages with HTML5 APIs
    - Exercise 1: Dragging and Dropping Images
    - Exercise 2: Incorporating Video
    - Exercise 3: Using the Geolocation API to Report the User's Current Location
- Module review and takeaways

---
## Module overview
### Objectives
After completing this module, you will be able to:
- Access the local file system and add drag-and-drop support to web pages.
- Play video and audio files in a web page, without the need for plugins.
- Obtain information about the current location of the user.
- Use the F12 Developer Tools in Microsoft Edge to debug and profile a web application.

---
## Lesson 1:	Interacting with Files
HTML5 enables a web application to interact with the local file system, and supports drag-and-drop operations that enable the user to drag files or HTML elements onto a web page. In this lesson, you will learn how to use the HTML5 File APIs and how to add drag-and-drop support to a web page.

### Lesson objectives
After completing this lesson, you will be able to:
- Describe the HTML5 file types.
- Describe the FileReader interface for reading files on the local file system.
- Use FileReader to read a text file.
- Use FileReader to read a binary file.
- Add drag-and-drop support to a web page.

### HTML5 File Interfaces
> * The HTML5 File API enables a web application to access the local file system
> * There are four key interfaces:
>   * **Blob** - immutable raw binary data 
>   * **File** - readonly information about a file
>   * **FileList** - an array of files
>   * **FileReader** - methods for reading data from a file or blob

:point_right: Additional Reading: For detailed information about the HTML5 File API, see http://go.microsoft.com/fwlink/?LinkID=267731.

### The FileReader Interface
> * The FileReader Interface provides methods for reading a file or blob:
>   * readAsText() - used for reading text files
>   * readAsDataURL() - use for reading binary files
>   * readAsArrayBuffer() - used for reading data into a buffer array
> * FileReader reads data asynchronously and fires events:
>   * `progress`, `load`, `abort`, `error`, `loadend`

### Reading a Text File
> To read a text file:
> 1. Get a File or Blob object, either by using an **\<input type= "field">** element 
    or by drag-and-drop.
> 2. Create a **FileReader** object and handle events such as **load** and **error**.
> 3. Invoke **readAsText()** on the **FileReader** object.
> 4. In the **load** event handler function, assess the text content in the **result** property 
    of the event target.
> 5. In the **error** event handler function, implement appropriate error handling.

#### Reading a Text File
``` html
<input type="file" id="theTextFile" onchange="onLoadTextFile()" /> 
<textarea id="theMessageArea" rows="30" cols="40"></textarea>
  
<script type="text/javascript">
    function onLoadTextFile() {
        const theFileElem = document.getElementById("theTextFile");
        // Get the File object selected by the user, and make sure it is a text file.
        if (theFileElem.files.length != 0 && theFileElem.files[0].type.match(/text.*/)) {
            // Create a FileReader and handle the onload and onerror events.
            const reader = new FileReader();
            reader.onload = function(e){
                const theMessageAreaElem = document.getElementById("theMessageArea");
                theMessageAreaElem.value = e.target.result;
            };
            reader.onerror = function(e){
                alert("cannot load text file");
            };
            // Read text file (the second parameter is optional - the default encoding is "UTF-8").
            reader.readAsText(theFileElem.files[0], "ISO-8859-1");
        } else {
            alert("Please select a text file");
      }
    }
</script>
```
### Reading a Binary File
> To read a binary file:
> 1. Get a File or Blob object, either by using an **\<inout type= "file">** element
    or by drag and drop.
> 2. Create a **FileReader** object and handle events such as **load** and **error**.
> 3. Invoke **readAsDataURL()** on the **FileReader** object.
> 4. In the **load** event handle function, access the text content in the **result**
    property of the event target.
> 5. In the **error** event handler function, implement appropriate error handling.

##### Reading a Binary File
``` jsx
<input type="file" id="theBinaryFile" onchange="onLoadBinaryFile()" />
<img id="theImage"></img>
  
<script type="text/javascript">
    function onLoadBinaryFile() {
        const theFileElem = document.getElementById("theBinaryFile");
        // Get the File object selected by the user (and make sure it is an image file).
        if (theFileElem.files.length != 0 && theFileElem.files[0].type.match(/image.*/)) {
            // Create a FileReader and handle the onload and onerror events.
            const reader = new FileReader();
            reader.onload = function(e){
                const theImgElem = document.getElementById("theImage");
                theImgElem.src = e.target.result;
            };
            reader.onerror = function(e){
                alert("cannot load binary file");
            };
            // Read the binary file.
            reader.readAsDataURL(theFileElem.files[0]);
        } else {
            alert("Please select a binary file");
        }
    }
</script>
```

### Implementing Drag-and-Drop
> * HTML5 supports drag-and-drop
>     * The user can drag HTML elements, or files from the local file system
>     * The user can drop items onto drop-enabled target elements
> * To support drag and drop operations
>     * Enable drag support on HTML elements, if required
>     * Enable drop support on HTML drop target elements
>     * Handle dragover and drop events on HTML drop target elements

The following example shows how to make a <div> element draggable:

##### Making a **\<div>** Element Draggable
``` jsx
<div draggable="true" ondrag="handleDrag(event)">
    <b>Some content</b> to be dragged.
</div>
  
<script type="text/javascript">
    function handleDrag(event) {
        event.dataTransfer.effectAllowed = "copy";
        event.dataTransfer.setData("text/plain", event.target.innerHTML);
    }
</script>
```    
##### Dropping Content on a \<div> Element
``` jsx
<input ondragover="handleDragOver(event)" ondrop="handleDrop(event)" />
  
<script type="text/javascript">
    function handleDragOver(event) {
        event.stopPropagation();
        event.preventDefault();
        event.dataTransfer.dropEffect = "copy";   // Display a "copy" cursor
    }
  
    function handleDrop(event) {
        event.stopPropagation();
        event.preventDefault();
        event.target.innerHTML = e.dataTransfer.getData("text/plain");
    }
</script>
```

---
## Lesson 2:	Incorporating Multimedia
### Lesson Objectives
After completing this lesson, you will be able to:
- Describe how to play video files.
- Support multiple video formats.
- Interact with a video in code.
- Describe how to play audio files.

### Playing Video Content by Using the <video> Tag
> * HTML5 enables a web application to play video files natively, without requiring plugins:
> * Use the \**<video>** tag and set the attributes:
>     * src
>     * width and height
>     * poster
>     * controls
>     * autoplay
>     * loop
>     * muted
#### Creating a Video Player
```  jsx
<video src="MyVideo.mp4" 
            width="300" height="200" 
            poster="MyPoster.jpg" 
            autoplay muted controls loop />
```
### Supporting Multiple Video Formats
> * A \<video> element can support multiple video formats:
> * You can embed Silverlight or Flash content in a \<video> tag as a fall-back
#### Supporting Multiple Formats in a Video Player
``` jsx
<video poster="MyPoster.jpg" autoplay controls> 
    <source src="MyVideos/MyVideo.mp4"  type='video/mp4' /> 
    <source src="MyVideos/MyVideo.webm" type='video/webm' /> 
    <source src="MyVideos/MyVideo.ogv"  type='video/ogg' /> 
    <!-- You can embed Flash or Silverlight content here, as a fallback --> 
    <!-- You can also display some simple text in case the browser does not support the 
video tag --> 
    Cannot play video. Download video <a href="MyVideos/MyVideo.webm">here</a> 
</video>
```
### Interacting with Video in JavaScript Code
> * An application can interact with a **video** object in JavaScript code:
#### Creating a Video Player by Using JavaScript Code
``` jsx
function 
createVideoElement(nameOfVideoFile, 
nameOfHostElement) { 
    // Create a video object and set its properties. 
    var newVideo = document.createElement("video"); 
    newVideo.src = nameOfVideo; 
    newVideo.loop = true; 
    newVideo.autoplay = true; 
    newVideo.controls = true; 
    newVideo.poster = "ImageLoading.png"; 
    // Add the video object to an existing element on the web page. 
    var hostElem = document.getElementById("videoDir"); 
    hostElem.appendChild(newVideo); 
}
```    
    
---
## Lesson 3:	Reacting to Browser Location and Context

---
## Lesson 4:	Debugging and Profiling a Web Application

### Demonstration: Using the F12 Developer Tools to Debug JavaScript Code
#### Demonstration steps
You will find the steps in the “Demonstration: Using the F12 Developer Tools to Debug JavaScript Code“ section on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD08_DEMO.md.

### Demonstration: Using the F12 Developer Tools to Profile a Web Application
#### Demonstration steps
You will find the steps in the “Demonstration: Using the F12 Developer Tools to Profile a Web Application“ section on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD08_DEMO.md.

### Demonstration: Creating Interactive Pages with HTML5 APIs
#### Demonstration steps
You will find the steps in the “Demonstration: Creating Interactive Pages with HTML5 APIs“ section on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD08_DEMO.md.


---
## Lab:	Creating Interactive Pages with HTML5 APIs
### Objectives
After completing this lab, you will be able to:
- Add a video to an HTML page.
- Create interactive pages by using a drag-and-drop operation.
- Read files by using the File API.
- Get the location of the user by using the Geolocation API.
#### Lab setup
Estimated Time: 60 minutes

You will find the high-level steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD08_LAB_MANUAL.md.

You will find the detailed steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD08_LAK.md.

### Exercise 1: Dragging and Dropping Images
#### speaker-bagge.html
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod08/Labfiles/Solution/Exercise%201/ContosoConf/speaker-badge.htm
``` html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>Speaker badge for ContosoConf</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
        <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
        <link href="/styles/header.css" rel="stylesheet" type="text/css" />
        <link href="/styles/footer.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/pages/speaker-badge.css" rel="stylesheet" type="text/css" />
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
                <p>Drag and drop your profile picture here...</p>
                <img style="width: 300px; height: 300px; border: 1px solid #000"/>
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

        <script src="/scripts/pages/speaker-badge.js" type="module"></script>
    </body>
</html>
```
#### speaker-badge.js
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod08/Labfiles/Solution/Exercise%201/ContosoConf/scripts/pages/speaker-badge.js
``` jsx
import { SpeakerBadgePage } from "../SpeakerBadgePage.js";

const badgeElement = document.querySelector(".badge");
new SpeakerBadgePage(badgeElement);

// SIG // Begin signature block
// ...
```
#### SpeakerBadgePage.js
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod08/Labfiles/Solution/Exercise%201/ContosoConf/scripts/SpeakerBadgePage.js
``` jsx
export class SpeakerBadgePage {
    constructor(element) {
        this.imageElement = element.querySelector("img");

        // TODO: Add event listeners for element "dragover" and "drop" events.
        //       handle with this.handleDragOver.bind(this) and this.handleDrop.bind(this)
        element.addEventListener("dragover", this.handleDragOver.bind(this), false);
        element.addEventListener("drop", this.handleDrop.bind(this), false);
    }

    handleDragOver(event) {
        event.stopPropagation();
        event.preventDefault();
        event.dataTransfer.dropEffect = 'copy'; // Makes the browser display a "copy" cursor.
    }

    handleDrop(event) {
        event.stopPropagation();
        event.preventDefault();

        // TODO: Get the files from the event
        const files = event.dataTransfer.files;

        if (files.length == 0) return;

        // TODO: Read the first file in the array
        const file = files[0];
        //       Check the file type is an image
        if (this.isImageType(file.type)) {
            //       Use this.readFile to read the file, then display the image
            //       (Note that this.readFile returns a Promise, so chain ((file)=> this.displayImage(file)) using the "then" method.)
            this.readFile(file).then((file)=> this.displayImage(file));
        } else {
            alert("Please drop an image file.");
        }
    }

    isImageType(type) {
        const imageTypes = ["image/jpeg", "image/jpg", "image/png"];
        return imageTypes.indexOf(type) >= 0;
    }

    readFile(file) {

        // Return a new promise.
        return new Promise(function (resolve, reject) {
            // TODO: Create a new FileReader
            const reader = new FileReader();

            // TODO: Assign a callback function for reader.onload
            // TODO: In the callback use resolve([fileDataUrl]); to return the file data URL.
            reader.onload = function (loadEvent) {
                const fileDataUrl = loadEvent.target.result;
                
                resolve([fileDataUrl]);
            };

            // TODO: Start reading the file as a DataURL
            reader.readAsDataURL(file);
        });
    }

    displayImage(imageUrl) {
        this.imageElement.src = imageUrl;
    }
}
// SIG // Begin signature block
// ...
```

### Exercise 2: Incorporating Video
#### index.htm
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod08/Labfiles/Solution/Exercise%202/ContosoConf/index.htm
``` html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>ContosoConf</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
        <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
        <link href="/styles/header.css" rel="stylesheet" type="text/css" />
        <link href="/styles/footer.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/pages/index.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <nav class="page-nav">
            <div class="container">
                <a href="/index.htm" class="active">Home</a>
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
                
                <a class="register" href="/register.htm">
                    Register<br />
                    <span class="free">&#183; Free &#183;</span>                
                </a>
            </div>
        </header>
        
        <section class="page-section">
            <div class="container">
                <section class="introduction">
                    <p>
                        The web keeps evolving. There's a wealth of new technologies to keep up with! ContosoConf is an in-depth exploration of HTML5, 
                        CSS3 and JavaScript, in the heart of Seattle, WA.    
                    </p>
                    <p>
                        Don't miss the best speakers in the business, talking about the future of the web.
                    </p>
                </section>
                <section class="speakers">
                    <h2>Featuring these excellent speakers</h2>
                    <ul>
                        <li>
                            <img src="/images/speakers/melissa-kerr.jpg" alt="Melissa Kerr"/>
                            <span class="name">Melissa Kerr</span>
                        </li>
                        <li>
                            <img src="/images/speakers/david-alexander.jpg" alt="David Alexander"/>
                            <span class="name">David Alexander</span>
                        </li>
                        <li>
                            <img src="/images/speakers/mark-hanson.jpg" alt="Mark Hanson"/>
                            <span class="name">Mark Hanson</span>
                        </li>
                        <li>
                            <img src="/images/speakers/april-meyer.jpg" alt="April Meyer"/>
                            <span class="name">April Meyer</span>
                        </li>
                    </ul>
                </section>
                <section class="sponsors">
                    <h2>Thanks to our sponsors</h2>
                    <ul>
                        <li><img src="/images/sponsors/sponsor1.png" alt="Trey Research"/></li>
                        <li><img src="/images/sponsors/sponsor2.png" alt="Litware, Inc"/></li>
                        <li><img src="/images/sponsors/sponsor3.png" alt="Fourth Coffee"/></li>
                        <li><img src="/images/sponsors/sponsor4.png" alt="Graphic Design Institute"/></li>
                        <li><img src="/images/sponsors/sponsor5.png" alt="Southridge Video"/></li>
                    </ul>
                </section>
                <section class="video">
                    <h2>Video from last year</h2>
                    <!-- TODO: Add video tag here -->
                    <!-- Use this video source: http://ak.channel9.msdn.com/ch9/265b/9a76fccd-941e-4285-ad00-9ea200aa265b/MIX09KEY01_high_ch9.mp4 -->
                    <video src="http://ak.channel9.msdn.com/ch9/265b/9a76fccd-941e-4285-ad00-9ea200aa265b/MIX09KEY01_high_ch9.mp4"></video>
                    <div class="video-controls" style="display: none">
                        <button class="video-play">Play</button>
                        <button class="video-pause">Pause</button>
                        <span class="video-time"></span>
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

        <script src="/scripts/pages/video.js" type="module"></script>
    </body>
</html>
```
#### video.js
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod08/Labfiles/Solution/Exercise%202/ContosoConf/scripts/pages/video.js
``` jsx
/// <reference path="../datetime.js" />
import { formatTime } from "../datetime.js";

// TODO: Make sure the element class attributes in index.htm match these selectors.
const videoSection = document.querySelector(".video");
const video = videoSection.querySelector("video");
const controls = videoSection.querySelector(".video-controls");
const playButton = videoSection.querySelector(".video-play");
const pauseButton = videoSection.querySelector(".video-pause");
const time = videoSection.querySelector(".video-time");

function ready() {
    // TODO: display the video controls
    controls.style.display = "block";
};

function play() {
    // TODO: play the video
    video.play();
    playButton.style.display = "none";
    pauseButton.style.display = "";
};

function pause() {
    // TODO: pause the video
    video.pause();
    pauseButton.style.display = "none";
    playButton.style.display = "";
};

function updateTime() {
    // TODO: Set time.textContent using video.current time.
    //       Use the formatTime function to convert raw seconds into HH:MM:SS format.
    time.textContent = formatTime(video.currentTime);
};

pauseButton.style.display = "none";

// TODO: Add event listeners for:
//       video loaddata
video.addEventListener("loadeddata", ready, false);
//       video timeupdate
video.addEventListener("timeupdate", updateTime, false);
//       play click
//       pause click
playButton.addEventListener("click", play, false);
pauseButton.addEventListener("click", pause, false);

// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr
```

### Exercise 3: Using the Geolocation API to Report the User's Current Location
#### location.htm
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod08/Labfiles/Solution/Exercise%203/ContosoConf/location.htm
``` html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>ContosoConf location and venue map</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
        <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
        <link href="/styles/header.css" rel="stylesheet" type="text/css" />
        <link href="/styles/footer.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/pages/location.css" rel="stylesheet" type="text/css" />
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
                        Conference Center<br/>
                        1234 Main Street<br/>
                        Seattle<br/>
                        WA 98999
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
                        </div>
                        <div id="room-b-info" style="display: none">
                            <h2>Room B</h2>
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

        <script src="/scripts/pages/location.js" type="module"></script>
    </body>
</html>
```
#### location.js
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod08/Labfiles/Solution/Exercise%203/ContosoConf/scripts/pages/location.js
``` jsx
import { distanceInMiles } from "../geometry.js";

const conferenceLocation = {
    latitude: 47.6097,  // decimal degrees
    longitude: 122.3331 // decimal degrees
};

const maximumDistanceInMilesFromConferenceToShowVenue = 10;

const distanceElement = document.getElementById("distance");
const travelSection = document.querySelector("section.travel");
const venueSection = document.querySelector("section.venue");

function distanceFromConference(coords) {
    return Math.floor(distanceInMiles(coords, conferenceLocation));
};

function showDistanceMessage(distance) {
    const message = "You are " + distance + " miles from the conference";
    distanceElement.textContent = message;
};

function moveVenueSectionToTop() {
    travelSection.parentNode.insertBefore(venueSection, travelSection);
};

function updateUIForPosition(position) {
    // TODO: Calculate the distance from the conference
    const distance = distanceFromConference(position.coords);

    showDistanceMessage(distance);
    const isNearToConference = distance < maximumDistanceInMilesFromConferenceToShowVenue;
    if (isNearToConference) {
        moveVenueSectionToTop();
    }
};

function error() {
    distanceElement.textContent = "Could not detect your current location.";
};

// TODO: Get current position from the geolocation API.
//       Call updateUIForPosition for success and error for failure.
navigator.geolocation.getCurrentPosition(updateUIForPosition, error);

// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr
```

---
## Module review and takeaways
