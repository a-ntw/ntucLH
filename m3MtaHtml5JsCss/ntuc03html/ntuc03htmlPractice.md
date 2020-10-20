PROGRAMMING IN HTML5 WITH JAVASCRIPT AND CSS3 
===
- [index.html](#indexhtml)
- [Registration.html](#registrationhtml)
- [PortalStyle.css](#portalstylecss)
- [Print.css](#printcss)
- [ResponsiveUI.css](#responsiveuicss)
- [appcache.manifest](#appcachemanifest)
- [LocationService.js](#locationservicejs)
- [PortalLogic.js](#portallogicjs)
- [NTUCEmployee.js](#ntucemployeejs)
- [UploadProfilePhoto.js](#uploadprofilephotojs)
- [DragAndDrop.js](#draganddropjs)

Reference
- drag and drop w3schools - Google Search
- math w3schools - Google Search
- input dom w3schools - Google Search
- regex - Regular Expression for NRIC/FIN in Singapore 


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

### index.html
File > New Project > 
```html
<!DOCTYPE html>
<html manifest="appcache1.manifest">
<head>
    <meta charset="utf-8" />
    <title></title>
    <link href="Styles/PortalStyle.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.4.3/css/ol.css" type="text/css">
    <style>
        .map {
            height: 400px;
            width: 100%;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.4.3/build/ol.js"></script>
    <script src="Scripts/LocationService.js"></script>
    <script src="Scripts/PortalLogic.js"></script>
    <link href="Styles/ResponsiveUI.css" rel="stylesheet" />
</head>
<body onoffline="hideWhenOffline();">
     <nav class="hidewhenprinted">
         <a href="Index.html">Home</a>
         <a href="Registration.html">Registration Page</a>
     </nav>
    <header class="hidewhenprinted">
        <img src="Images/ntuclogo.png" />
        <p>NTUC Corporate Portal</p>
    </header>
    <article>
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
        <section class="hidewhenprinted" id="multimedia">
            <p>NTUC on the news:</p>
            <video width="400" controls autoplay>
                <source src="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4" type="video/mp4">
                 Your browser does not support HTML video.
            </video>
        </section>
        <section id="map" class="map">
            <input id="displayMap" type="button" value="Display Map" onclick="getLocation();" />

        </section>
    </article>
    <footer class="hidewhenprinted">
        <p>Contact Info:</p>
        <ul>
            <li>Email: support@ntuc.sg</li>
            <li>Contact Number: +6581327645</li>
        </ul>
    </footer>
</body>
</html>
```


### Registration.html
``` html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <link href="Styles/PortalStyle.css" rel="stylesheet" />
    <script src="Scripts/PortalLogic.js"></script>
    <script src="Scripts/jquery-3.5.1.min.js"></script>
    <script src="Scripts/NTUCEmployee.js"></script>
    <script src="Scripts/UploadProfilePhoto.js"></script>
   
</head>
<body id="dropOff" onload="NTUCLhubEmployee.detectCountry()">
    <article>
        <form method="post" action="www.google.com" onsubmit="return validateForm()">
            <p>Profile Photo:</p>
            <img id="ProfilePhoto" src="" alt="" />
            <input id="SelectPhoto" type="file" multiple />
            <input id="UploadPhoto" type="button" value="Upload Photo" onclick="uploadProfilePhoto();" />
            <p>Employee No:</p>
            <input id="EmpNoInput" type="text" />
            <p>Employee Name:</p>
            <input id="EmpNameInput" type="text" required />
            <p>Employee Type:</p>
            <select id="EmpTypeInput" onchange="NTUCLhubEmployee.generateEmpNo();">
                <option value="Regular">Regular</option>
                <option value="Temporary">Temporary</option>
                <option value="Contract">Contract</option>
            </select>
            <p>Employee Email:</p>
            <input id="EmpEmailInput" type="email" />
            <p>Country:</p>
            <input id="EmpCountryInput" type="text" />
            <p>Employee NRIC:</p>
            <input id="EmpNRICInput" type="text" pattern="^[SFTG]\d{7}[A-Z]$" title="Wrong input, use an IC format" />
            <p>Employee PIN:</p>
            <input id="EmpPinInput" type="password" />
            <p>Confirm PIN:</p>
            <input id="ConfirmPinInput" type="password" />
            <input id="Button1" type="submit" value="Submit" />
            <input id="Button2" type="button" value="button" onclick="alert('The page complies with the PDPA policy..')" />
            <input id="SaveToLocal" type="button" value="Save To Local" onclick="NTUCLhubEmployee.saveToLocalStorage();" />
            <input id="GetFromLocal" type="button" value="Get From Local" onclick="NTUCLhubEmployee.getFromLocalStorage();" />
        </form>
    </article>
    <script src="Scripts/DragAndDrop.js"></script>
</body>
</html>
```
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


### PortalStyle.css
``` css
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
}

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

```
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

``` 

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

### LocationService.js
``` jsx
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

### PortalLogic.js
validateForm : standard must use
``` js
"use strict"
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

function hideWhenOffline() {
    document.getElementById("multimedia").style.display = "none";
}


```

### NTUCEmployee.js
``` js
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
Employee.prototype.detectCountry = function () {
    $.ajax({
        url: "https://ipapi.co/json"
    }).then(function (data) {
        $("#EmpCountryInput").val(data.country_name);
        //$("#empRegion").val(data.region);
        //$("#empTimeZone").val(data.timezone);
    });
}
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

### UploadProfilePhoto.js
``` js
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

### DragAndDrop.js
``` jsx
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
