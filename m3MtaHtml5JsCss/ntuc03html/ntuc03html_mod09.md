Module 9: Adding Offline Support to Web Applications
===
Contents:
Module overview
- Lesson 1:	Reading and Writing Data Locally
- Lesson 2:	Adding Offline Support by Using the Application Cache
- Lab:	Adding Offline Support to Web Applications
- Module review and takeaways

---
## Module overview
### Objectives
After completing this module, you will be able to:
- Save data locally on the user's device, and access this data from a web application.
- Configure a web application to support offline operations by using the Application Cache.

## Lesson 1: Reading and Writing Data Locally
### Lesson objectives
After completing this lesson, you will be able to:
- Explain how a web application can use cookies to maintain simple state information.
- Use the Session Storage API to save session state information in a web application.
- Use the Local Storage API to persist information between sessions.
- Use storage events to notify an application of changes made to stored data.
- Describe how the Indexed Database API can implement a structured data store on the user's device.

## Lesson 2: Adding Offline Support by Using the Application Cache
### Lesson objectives
After completing this lesson, you will be able to:
- Configure the application cache.
- Detect the state of the application cache.
- Refresh the application cache.
- Test for network connectivity.

## Demonstration: Adding Offline Support to Web Applications
### Demonstration steps
You will find the steps in the “Demonstration: Adding Offline Support to Web Applications“ section on the 
following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD09_DEMO.md.

## Lab: Adding Offline Support to Web Applications
### Objectives
After completing this lab, you will be able to:
- Use the Application Cache API to make webpages available offline.
- Use the Local Storage API to persist user data locally between browser sessions.

#### Lab setup
Estimated Time: 60 minutes

You will find the high-level steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD09_LAB_MANUAL.md.

You will find the detailed steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD09_LAK.md.

### Exercise 1: Caching Offline Data by Using the Application Cache API

#### offline.js
``` jsx
const offlinePages = /^\/(index|about|schedule|location).htm$/;

function hideLinksThatRequireOnline() {
    const allNavLinks = document.querySelectorAll("nav.page-nav a");
    for (let i = 0; i < allNavLinks.length; i++) {
        const href = allNavLinks[i].getAttribute("href");
        if (!offlinePages.test(href)) {
            allNavLinks[i].style.display = "none";
        }
    }
};

function showLinks() {
    const allNavLinks = document.querySelectorAll("nav.page-nav a");
    for (let i = 0; i < allNavLinks.length; i++) {
        allNavLinks[i].style.display = "";
    }
};


// TODO: if currently offline, hide navigation links that require online
if (!navigator.onLine) {
    hideLinksThatRequireOnline();
}

// TODO: add onoffline and ononline events to document.body,
//       which either hide or show navigation links.
document.body.onoffline = hideLinksThatRequireOnline;
document.body.ononline = showLinks;

// TODO: also handle the applicationCache error event to hide links
applicationCache.addEventListener("error", hideLinksThatRequireOnline, false);
// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr
```

### Exercise 2: Persisting User Data by Using the Local Storage API
#### schedule.html
``` html
<!DOCTYPE html>
<html lang="en" manifest="/appcache.manifest">
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
                <a href="/location.htm">Location</a>
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
        <script src="/scripts/offline.js" type="module"></script>
    </body>
</html>
```
#### LocalStarStorage.js
``` jsx
export class LocalStarStorage {
    constructor(localStorage) {
        /// <summary>Encapsulates the browser's localStorage API to make saving a list of starred sessions easy.</summary>
        this.localStorage = localStorage;
        this.load();
    }

    addStar(sessionId) {
        /// <summary>Stars the given session.</summary>
        if (this.isStarred(sessionId)) return;

        this.sessions.push(sessionId);
        this.save();
    }

    removeStar(sessionId) {
        /// <summary>Removes the star from the given session.</summary>
        const index = this.sessions.indexOf(sessionId);
        if (index >= 0) {
            this.sessions.splice(index, 1);
            this.save();
        }
    }

    isStarred(sessionId) {
        /// <summary>Returns true if the given session is starred.</summary>
        return this.sessions.indexOf(sessionId) >= 0;
    }

    load() {
        /// <summary>Loads the starred sessions from storage.</summary>

        // TODO: get the "stars" from local storage
        const json = this.localStorage.getItem("stars");
        
        // TODO: parse the JSON string into this.sessions
        // TODO: handle failures due to missing data, etc
        if (json) {
            try {
                this.sessions = JSON.parse(json) || [];
            } catch (exception) {
                this.sessions = [];
            }
        } else {
            this.sessions = [];
        }
    }

    save() {
        /// <summary>Saves the starred sessions to storage.</summary>
        // TODO: convert this.sessions into a JSON string
        // TODO: save this JSON string into local storage as "stars"
        this.localStorage.setItem("stars", JSON.stringify(this.sessions));
    }
}
// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr
```
####  ScheduleItem.js
``` jsx
import { HtmlTemplate } from "./HtmlTemplate.js";
import { parseTimeAsTotalMinutes } from "./datetime.js";

export class ScheduleItem {
    constructor(data, localStarStorage) {
        this.id = data.id;
        this.tracks = data.tracks;
        this.localStarStorage = localStarStorage;
        this.scheduleItemTemplate = new HtmlTemplate("schedule-item");
        this.starredClass = "starred";

        this.element = this.scheduleItemTemplate.createElement(data);

        // TODO: Check if item is starred
        if (localStarStorage.isStarred(this.id)) {
            this.element.classList.add(this.starredClass);
        }

        this.initializeElementClass();
        this.initializeElementPosition(data.start, data.end);
        this.addStarClickEventHandler();
    }

    initializeElementClass() {
        if (this.isInTrack(1) && this.isInTrack(2)) {
            this.element.classList.add("both-tracks");
        } else if (this.isInTrack(1)) {
            this.element.classList.add("track-1");
        } else if (this.isInTrack(2)) {
            this.element.classList.add("track-2");
        }
    }

    initializeElementPosition(start, end) {
        const startTimeInMinutes = parseTimeAsTotalMinutes(start);
        const endTimeInMinutes = parseTimeAsTotalMinutes(end);
        const pixelsPerMinute = 2;
        const conferenceStartTimeInMinutes = 8 * 60 + 30;
        this.element.style.top = pixelsPerMinute * (startTimeInMinutes - conferenceStartTimeInMinutes) + "px";
        this.element.style.height = pixelsPerMinute * (endTimeInMinutes - startTimeInMinutes) + "px";
    }

    addStarClickEventHandler() {
        const starElement = this.element.querySelector(".star");
        starElement.addEventListener("click", this.toggleStar.bind(this), false);
    }

    isInTrack(track) {
        return this.tracks.indexOf(track) >= 0;
    }

    toggleStar() {
        if (this.isStarred()) {
            this.unsetStar();
        } else {
            this.setStar();
        }
    }

    isStarred() {
        return this.element.classList.contains(this.starredClass);
    }

    unsetStar() {
        this.element.classList.remove(this.starredClass);
        this.postStarChange(false);
        // TODO: remove the star from the item
        this.localStarStorage.removeStar(this.id);
    }

    setStar() {
        this.element.classList.add(this.starredClass);
        this.postStarChange(true);
        // TODO: add a star to the item
        this.localStarStorage.addStar(this.id);
    }

    async postStarChange(isStarred) {
        const headers = new Headers({
            "Content-Type": "application/x-www-form-urlencoded"
        })

        const options = {
            method: 'POST',
            headers: headers,
            body: "starred=" + isStarred
        }

        const response = await fetch("/schedule/star/" + this.id, options);

        if (isStarred) {
            if (response.ok) {
                const data = await response.json();
                this.updateStarCount(data.starCount);
                if (data.starCount > 50)
                    alert("This session is very popular! Be sure to arrive early to get a seat.");
            }
        }
    }

    updateStarCount(starCount) {
        const starCountElement = this.element.querySelector(".star-count");
        starCountElement.textContent = starCount.toString();
    }

    show() {
        this.element.style.display = "block";
    }

    hide() {
        this.element.style.display = "none";
    }
}
// SIG // Begin signature block
// SIG // MIIdkAYJKoZIhvcNAQcCoIIdgTCCHX0CAQExCzAJBgUr
```
#### appcache.manifest
``` manifest
CACHE MANIFEST
# version 2

/index.htm
/about.htm
/location.htm
/schedule.htm

/schedule/list

/images/speakers/april-meyer.jpg
/images/speakers/david-alexander.jpg
/images/speakers/mark-hanson.jpg
/images/speakers/melissa-kerr.jpg

/images/sponsors/sponsor1.png
/images/sponsors/sponsor2.png
/images/sponsors/sponsor3.png
/images/sponsors/sponsor4.png
/images/sponsors/sponsor5.png

#/scripts/_namespace.js
/scripts/datetime.js
/scripts/geometry.js
/scripts/HtmlTemplate.js
/scripts/LocalStarStorage.js
/scripts/ScheduleItem.js
/scripts/ScheduleList.js
/scripts/offline.js

/scripts/pages/location.js
/scripts/pages/schedule.js

/styles/footer.css
/styles/header.css
/styles/nav.css
/styles/site.css

/styles/images/stars.png

/styles/pages/about.css
/styles/pages/index.css
/styles/pages/location.css
/styles/pages/schedule.css


NETWORK:
*
```
## Module review and takeaways
In this module, you have seen several techniques that you can use to store data locally on the device 
that is running the browser. These techniques include session storage for storing session data that is 
automatically removed when the user's browsing session completes; local storage, which provides for more 
persistent data on the user's device; and the Indexed Database API, which enables the browser to store 
and retrieve data in a more structured manner.

You have also learned how to use the application cache of HTML5 to configure web pages and to enable them 
to cache resources locally on the user's device.

