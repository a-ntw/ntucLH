PROGRAMMING IN HTML5 WITH JAVASCRIPT AND CSS3, 2nd Edition 
===
[top]: topOfThePage
- [index.html](#indexhtml) New html, appcache, productandservices, video, MAP, accordion, SVG img, animated eml
- [Registration.html](#registrationhtml) Form, auto generate EmpNo, Password, DragAndDrop.js
- [Animation.css](#animationcss)
- [PortalStyle.css](#portalstylecss) standard styles for index & Registration, product, multimedia
- [Print.css](#printcss) hide when print
- [ResponsiveUI.css](#responsiveuicss) RESPONSIVE screen index
- [appcache.manifest](#appcachemanifest) CAHCE memory index
- [LocationService.js](#locationservicejs) MAP location index
- [PortalLogic.js](#portallogicjs) random generate, VALIDATE f Registration, OffLine
- [NTUCEmployee.js](#ntucemployeejs) Employee No generate, 
- [ProgressBar.js](#progressbarjs)
- [UploadProfilePhoto.js](#uploadprofilephotojs)  upload photo toi index
- [AnimationLogic.js](#animationlogicjs) 
- [DragAndDrop.js](#draganddropjs) drap image to index

Reference
- drag and drop w3schools - Google Search
- math w3schools - Google Search
- input dom w3schools - Google Search
- regex - Regular Expression for NRIC/FIN in Singapore 
- SVG - google: image to SVG converter, www.pngtosvg.com. Download from NuGet folder
- Font - google font
- Canvas API - google canvas clock w3schools
- Keyframe - google keyframe w3schools
- Accordance - JqueryUI.com.accordia
- transformation - google transformation w3schools
- transition - google transition w3schools
- swipe - google swipe w3schools
- css box model 
- REGEX - google regex Singapore

Visual Studio cheatsheet
- Solution Explorer > Right0Click > Add > HTML file
- To create folder > Right-Click at the folder
- Drag-And-Drop css to html
- To run, Right-Click on coding > View in Browser
- IIS Express > Browser with
- View > Error List

Note:
- UI = user indentifier
- API = Applicationn Programme Interface

Learning
- `$("#EmpPinInput").val(); // jquery`   same as   `document.getElementById("EmpPinInput").value`  

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)


### index.html
File > New Project > 
```html
<!-- Project as: NTUCCorporatePortal.  -->
<!-- Visual Studio > Visual C# > ASP.NET Web, location drive: E: -->
<!-- ASP.NET 4.6.1 Templates > Empty -->
<!-- add folders: Styles, Scripts -->
<!DOCTYPE html>
<!-- Right-Click at NTUCCorr at Explorer to ADDindex new HTML page -->
<html manifest="appcache1.manifest"> <!-- appcache.manifest, CACHE -->
<head>
    <meta charset="utf-8" />
    <title></title>
    <!-- accordion, need h1 for every Sections -->
    <script src="Scripts/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#accordion").accordion();
        });
    </script>
    
    <!-- google font -->
    <link href='https://fonts.googleapis.com/css?family=Ranchers' rel='stylesheet' />    
    <!-- STANDARD style-->
    <link href="Styles/PortalStyle.css" rel="stylesheet" />
    <!-- map openlayer -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.4.3/css/ol.css" type="text/css">
    <style>
        .map {
            height: 400px;
            width: 100%;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.4.3/build/ol.js"></script>
    <script src="Scripts/LocationService.js"></script>
    
    <!-- for hideWhenOffline and others -->
    <script src="Scripts/PortalLogic.js"></script>
    <link href="Styles/ResponsiveUI.css" rel="stylesheet" />
    <link href="Styles/Animation.css" rel="stylesheet" />
    <!-- <link href="Styles/Print.css" rel="stylesheet" />  NOT work -->
</head>
<!-- function @PortalLogic -->
<body onoffline="hideWhenOffline();">
     <nav class="hidewhenprinted">
         <!-- no Print.css linked?? -->
         <a href="Index.html">Home</a>
         <a href="Registration.html">Registration Page</a>
     </nav>
    <header class="hidewhenprinted">
        <!-- SNG ntuc Logo -->
        <svg id="svg" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="400" height="400" viewBox="0, 0, 400,400"><g id="svgg"><path id="path0" d="M163.291 133.110 C 145.055 139.697,140.922 142.669,138.879 150.662 C 114.336 246.703,121.944 265.684,185.778 267.661 C 207.169 268.324,208.349 268.196,201.629 265.942 C 166.553 254.181,162.847 238.573,178.448 168.335 C 182.968 147.986,186.667 130.586,186.667 129.669 C 186.667 126.693,177.198 128.087,163.291 133.110 M250.004 134.119 C 241.328 137.419,233.064 141.285,231.639 142.710 C 228.535 145.814,215.225 203.926,215.158 214.667 C 215.029 235.395,244.774 236.879,255.227 216.665 C 257.681 211.920,275.556 136.046,275.556 130.376 C 275.556 126.443,266.816 127.723,250.004 134.119 " stroke="none" fill="red" fill-rule="evenodd"></path></g></svg>
        <!--  WAS <img src="Images/ntuclogo.png" /> -->
        <p>NTUC Corporate Portal</p>
    </header>
    <article id="accordion">
        <h1>Promotion</h1>
        <section id="promotion">
            <p>Free Ipads!</p>
        </section>
        
        <!-- display images -->
        <h1>Products and Services</h1>
        <section id="productandservices">
            <p>Product and Services:</p>
            <ul>
                <li>
                    <img src="Images/product1.png" />
                </li>
                <li>
                    <img src="Images/product2.png" />
                </li>
                <li>
                    <img src="Images/product3.png" />
                </li>
            </ul>
        </section>
        
        <!-- display images -->
        <h1>Multimedia</h1>
        <section class="hidewhenprinted" id="multimedia">
            <p>NTUC on the news:</p>
            <video width="400" controls autoplay>
                <source src="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4" type="video/mp4">
                Your browser does not support HTML video.
            </video>
        </section>
        
        <!-- display Open Map, see above css links -->
        <h1>Map</h1>
        <section id="map" class="map">
            <input id="displayMap" type="button" value="Display Map" onclick="getLocation();" />
        </section>
    </article>
    <footer class="hidewhenprinted">
        <!-- Animated Email -->
        <div>
            <p>Click the logo to send a support email</p>
            <img style ="width:150px; height:150px" id="emailSupport" src="Images/emaillogo.png" onclick="sendMail();"/>
        </div>
        <p>Contact Info:</p>
        <ul>
            <li>Email: support@ntuc.sg</li>
            <li>Contact Number: +6581327645</li>
        </ul>
    </footer>
    <script src="Scripts/AnimationLogic.js"></script>

    </body>
</html>
```


[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

### Registration.html
``` html
<!DOCTYPE html>
<!-- Right-Click at NTUCCorr at Explorer to ADD new HTML page -->
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <link href="Styles/PortalStyle.css" rel="stylesheet" />
    <script src="Scripts/PortalLogic.js"></script>
    <script src="Scripts/jquery-3.5.1.min.js"></script>
    <script src="Scripts/NTUCEmployee.js"></script>
    <script src="Scripts/UploadProfilePhoto.js"></script>
    <script src="Scripts/ProgressBar.js"></script>
</head>
<body id="dropOff" onload="NTUCLhubEmployee.detectCountry()">
    <!-- add in HTML5 stylesU(); -->
    <article> 
        <!-- animation progress bar on top -->
        <section>
            <canvas id="inputProgressBar" width="1000">

            </canvas>
        </section>
        
        <!-- KICK-OFF with create form<p> -->
        <form method="post" action="www.google.com" onsubmit="return validateForm()">
            <p>Profile Photo:</p>
            <img id="ProfilePhoto" src="" alt="" />
            <input id="SelectPhoto" type="file" multiple />
            <input id="UploadPhoto" type="button" value="Upload Photo" onclick="uploadProfilePhoto();" />
            
            <!-- add FORM inputs -->
            <!-- auto generate EmpNo via PortalLogic.js, NTUCEmployee.js -->
            <p>Employee No:</p>
            <input id="EmpNoInput" type="text" />
            <p>Employee Name:</p>
            <input id="EmpNameInput" type="text" required onchange="displayProgress(100)"/>
            <p>Employee Type:</p>
            <select id="EmpTypeInput" onchange="NTUCLhubEmployee.generateEmpNo(); displayProgress(300)">
                <option value="Regular">Regular</option>
                <option value="Temporary">Temporary</option>
                <option value="Contract">Contract</option>
            </select>
            <p>Employee Email:</p>
            <input id="EmpEmailInput" type="email" onchange="displayProgress(400)"/>
            
            <!-- Country detect  -->
            <p>Country:</p>
            <input id="EmpCountryInput" type="text" />
            <p>Employee NRIC:</p>
            <input id="EmpNRICInput" type="text" pattern="^[SFTG]\d{7}[A-Z]$" title="Wrong input, use an IC format" onchange="displayProgress(500)"/>
            
            <!-- PASSWORD input, PortalLogic.js -->
            <p>Employee PIN:</p>
            <input id="EmpPinInput" type="password" />
            <p>Confirm PIN:</p>
            <input id="ConfirmPinInput" type="password" />
            <input id="Button1" type="submit" value="Submit" />
            <input id="Button2" type="button" value="button" onclick="alert('The page complies with the PDPA policy..')" />
            
            <!-- SAVE and restore data -->
            <input id="SaveToLocal" type="button" value="Save To Local" onclick="NTUCLhubEmployee.saveToLocalStorage();" />
            <input id="GetFromLocal" type="button" value="Get From Local" onclick="NTUCLhubEmployee.getFromLocalStorage();" />
        </form>
    </article>
    <!-- this drag script need to place at end -->
    <script src="Scripts/DragAndDrop.js"></script>
</body>
</html>
```

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)
#### Registration Initial version
``` html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
</head>
<body>
    <form method="post" action="www.google.com" >
        <!-- add FORM inputs -->
        <!-- auto generate EmpNo via PortalLogic.js, NTUCEmployee.js -->
        <p>Employee No:</p>
        <input id="EmpNoInput" type="text" />
        <p>Employee Name:</p>
        <input id="EmpNameInput" type="text" required />
        <p>Employee Type:</p>
        <select id="EmpTypeInput">
            <option value="Regular">Regular</option>
            <option value="Temporary">Temporary</option>
        </select>
        <p>Employee Email:</p>
        <input id="EmpEmailInput" type="email" />
        <p>Employee NRIC:</p>
        <input id="EmpNRICInput" type="text" pattern="^[SFTG]\d{7}[A-Z]$" title="Wrong input, use an IC format" />
        <input id="Button1" type="submit" value="button" />
    </form>
</body>
</html>
```

---
[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)
### Animation.css
``` css
/* animated email click for index */
.clickEmail {
    position: relative;
    animation: sendmail 2s;
}

@keyframes sendmail {
    0% {
        transform: scale(1);
    }

    50% {
        transform: scale(.8);
    }

    100% {
        transform: translate(0, -3000px);
    }
}
```

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

### PortalStyle.css
``` css
/* standard styles ay folder: Styles */
p {
   margin: 0px 0px 0px 0px;
}
article {
    background-color:red;
}

header, footer {
    background-color:black;
    color:red;
}

header p {
    font-size: 40px;
}

nav {
    background-color:yellow;
    font-size: 20px;
    height: 100px;
}

/* @ index.html, article, section */
#productandservices {
    background-color:aquamarine;
}
#multimedia {
    background-color:aqua;
}

#productandservices img {
    width: 400px;
    height: 200px;
}

#productandservices ul li {
     display:inline;
     padding-right:20px;
}

/* animated FREE IPAD image */
#promotion {
    float: right;
    background: linear-gradient(red, yellow);
    border-radius: 100px;
    width: 150px;
    height: 150px;
    transform: rotate(30deg);
    display: table;
    transition: transform 2s;  /* for p and hover */
}

    #promotion p {
        font-family: Ranchers;
        font-size: 40px;
        color: white;
        text-align: center;
        display: table-cell;
        vertical-align: middle;
    }

    #promotion:hover {
        transform: scale(1.5) rotate(60deg);
     }

    a {
        text-decoration:none;
        padding: 30px 30px 30px 30px;
        background-color:blue;
        color:white;
        transition: font-size 1s, font-weight 1s; /* a:hover */
    }

        a:hover {
            font-size: 30px;
            font-weight:bold;
        }
```

---
[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)
### Print.css
``` css
.hidewhenprinted {
    display:none;
}

```


### ResponsiveUI.css
``` css
@media screen and (max-width: 600px) {
    video, #productandservices img {
        width: 200px;
        height: 200px;
    }

    a, #productandservices ul li {
        display: block;
    }
}
/* link ref to index.html */
``` 

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

### appcache.manifest
``` yaml
CACHE MANIFEST
# version 2
/Index.html
/Registration.html
/Scripts/PortalLogic.js
/Scripts/NTUCEmployee.js
/Styles/PortalStyle.css
/Images/ntuclogo.png
/Images/product1.png
/Images/product2.png
/Images/product3.png
```

---
[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

### LocationService.js
``` jsx
/* Map location, at Index.html */
function renderMap(long, lat) {
    var map = new ol.Map({
        target: 'map',
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM()
            })
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([long, lat]),
            zoom: 4
        })
    });
}

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        alert("Geolocation is not supported by this browser.");
    }
}

function showPosition(position) {
    renderMap(position.coords.longitude, position.coords.latitude);
}
```

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

### PortalLogic.js
validateForm : standard must use
``` js
"use strict"    /* can not use undeclared variables. */

/* Employee No. random generate */
function generateEmpNo() {
    var vaempId = 0;
    var vaempNoPrefix = "";
    var vaempType = document.getElementById("EmpTypeInput").value;
    switch (vaempType) {
        case "Regular":
            vaempNoPrefix = "R";
            break;
        case "Temporary":
            vaempNoPrefix = "T";
            break;
        default:
            vaempNoPrefix = "C";
    }
    vaempId = vaempNoPrefix + Math.round(Math.random() * 100 + 1000); //concatenation
    document.getElementById("EmpNoInput").value = vaempId;
}

/* validate form from registration.html */
function validateForm() {
    var pinInput = $("#EmpPinInput").val();
    var confPinInput = $("#ConfirmPinInput").val();
    if (pinInput != confPinInput) {
        //var confPinError = document.getElementById("empCPinInput");
       // confPinError.setCustomValidity("PIN inputs don't match...");
        alert("PIN inputs don't match...");
        return false;
    }
   return true;
}

/* OffLine, @index,html <body onoffline="hideWhenOffline();"> */
function hideWhenOffline() {
    document.getElementById("multimedia").style.display = "none";
}

```

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

### NTUCEmployee.js
``` js
/* Employee No generate, for Registration.html */
var Employee = function () { };
Employee.prototype.empNo = 0;
Employee.prototype.empName = " ";
Employee.prototype.empType = " ";
Employee.prototype.nric = " ";
Employee.prototype.emailAdd = " ";
Employee.prototype.generateEmpNo = function () {
    var vaempNoPrefix = "";
    Employee.prototype.empType = document.getElementById("EmpTypeInput").value;
    switch (Employee.prototype.empType) {
        case "Regular":
            vaempNoPrefix = "R";
            break;
        case "Temporary":
            vaempNoPrefix = "T";
            break;
        default:
            vaempNoPrefix = "C";
    }
    Employee.prototype.empNo  = vaempNoPrefix + Math.round(Math.random() * 100 + 1000); //concatenation
    document.getElementById("EmpNoInput").value = Employee.prototype.empNo ;
}

/* Counttry detect, for Registration.html */
Employee.prototype.detectCountry = function () {
    $.ajax({
        url: "https://ipapi.co/json"
    }).then(function (data) {
        $("#EmpCountryInput").val(data.country_name);
        //$("#empRegion").val(data.region);
        //$("#empTimeZone").val(data.timezone);
    });
}

/*  SAVE and restore data, for Registration.html */
Employee.prototype.saveToLocalStorage = function () {
    NTUCLhubEmployeeJson.empNo = $("#EmpNoInput").val();
    NTUCLhubEmployeeJson.empName = $("#EmpNameInput").val();
    NTUCLhubEmployeeJson.empType = $("#EmpTypeInput").val();
    NTUCLhubEmployeeJson.nric = $("#EmpNRICInput").val();
    NTUCLhubEmployeeJson.emailAdd = $("#EmpEmailInput").val();
    NTUCLhubEmployeeJson.country = $("#EmpCountryInput").val();

    if (typeof (Storage) !== "undefined") {
        localStorage.setItem("Employee", JSON.stringify(NTUCLhubEmployeeJson));
        alert("Records has been saved...");
    } else {
        alert("Sorry, your browser does not support Web Storage...");
    }
}

Employee.prototype.getFromLocalStorage = function () {
    var savedEmpRec = JSON.parse(localStorage.getItem("Employee"));
    $("#EmpNoInput").val(savedEmpRec.empNo);
    $("#EmpNameInput").val(savedEmpRec.empName);
    $("#EmpTypeInput").val(savedEmpRec.empType);
    $("#EmpNRICInput").val(savedEmpRec.nric);
    $("#EmpEmailInput").val(savedEmpRec.emailAdd);
    $("#EmpCountryInput").val(savedEmpRec.country);
}

/* create NEW object  */
var NTUCEmployee = function () { };
NTUCEmployee.prototype = Object.create(Employee.prototype); //inheritance
var NTUCLhubEmployee = new NTUCEmployee(); //instantiation

NTUCLhubEmployeeJson = {
    empNo: 0,
    empName: " ",
    empType: " ",
    nric: " ",
    emailAdd: " ",
    country: " "
};
```

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

### ProgressBar.js
``` jsx
/* display animated bar at top of Registration  */
function displayProgress(progress) {
    var c = document.getElementById("inputProgressBar");
    var ctx = c.getContext("2d");
    // Create gradient
    var grd = ctx.createLinearGradient(0, 0, progress, 0);
    grd.addColorStop(0, "red");
    grd.addColorStop(1, "white");
    // Fill with gradient
    ctx.fillStyle = grd;
    ctx.fillRect(10, 10, 1000, 80);
}
```

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

### UploadProfilePhoto.js
``` js
/* upload photo via Registration.html */
function uploadProfilePhoto() {
    var preview = document.getElementById('ProfilePhoto');
    var file = document.getElementById("SelectPhoto").files[0];
    var reader = new FileReader(); //instantiation

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "";
    }

    reader.onloadend = function () {
        preview.src = reader.result;
    }
    reader.onerror = function () {
        alert("Something went wrong upon image upload...");
    }
}

```

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

### AnimationLogic.js
``` jsx
/* animate Email click at index.html, script at bottom */
var inquiryElement = document.getElementById("emailSupport");
inquiryElement.addEventListener("animationend", onAnimationend, true);

function sendMail() {
    inquiryElement.className = "clickEmail";
}


function onAnimationend(e) {
    inquiryElement.className = " ";
}
```

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

### DragAndDrop.js
``` jsx
/* photo transfer, @ end of Registration.html*/
var dropzone;
dropzone = document.getElementById("dropOff");
dropzone.addEventListener("dragenter", dragenter, false);
dropzone.addEventListener("dragover", dragover, false);
dropzone.addEventListener("drop", drop, false);


//
function dragenter(e) {
    e.stopPropagation();
    e.preventDefault();
}
//

function dragover(e) {
    e.stopPropagation();
    e.preventDefault();
}

//
function drop(e) {
    e.stopPropagation();
    e.preventDefault();
    var preview = document.getElementById('ProfilePhoto');
    preview.style.backgroundColor = "blue";
    var dt = e.dataTransfer;
    var files = dt.files;
    var file = files[0];

    var reader = new FileReader(); //instantiation

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "";
    }

    reader.onloadend = function () {
        preview.src = reader.result; //actual image in binary format
    }

    reader.onerror = function () {
        alert("Something went wrong contact the admin...");
    }

}
``` 

[:top: Top](#top) | [index.html](#indexhtml) | [Registration.html](#registrationhtml)

---
