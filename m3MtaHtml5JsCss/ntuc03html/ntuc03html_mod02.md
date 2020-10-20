Module 2: Creating and Styling HTML Pages
===
### Contents:
Module overview
- Lesson 1:	Creating an HTML5 Page
- Lesson 2:	Styling an HTML5 Page
- Lab:	Creating and Styling HTML5 Pages
- Module review and takeaways
- Exercises

HTML5 has several aims:
- Not to "break the web". HTML5 is backwards compatible with previous versions of HTML.
- Add new features that reflect how the web is now used. For example, HTML5 supports form validation and video.
- Specify how every browser should behave when working with HTML. All HTML implementations can be interoperable. 
This behavior includes defining how to handle errors.
- Be universally accessible. Features should work across all devices, in any language, and for the disabled.

Reference Links: You can see these aims explained in full at http://go.microsoft.com/fwlink/?LinkID=267713.

HTML5 defines many other new features, including:
- New elements that improve the semantic structure of a document.
- New form controls and built-in validation.
- Native audio and video support, so users do not have to rely on browser plug-ins.
- The \<**canvas**> element and the associated JavaScript API provide a freeform area in a page to draw on, and 
the JavaScript commands to do the drawing, importing, and exporting.
- Support for uploading files to a web server.
- Support for dragging and dropping elements on the page.
- Support to enable web applications to continue running when the browser is offline.
- Support for local data storage, over and above that provided by cookies.

There are also a number of HTML5-associated specifications authored byW3C that are outside of the wider WHATWG work, including:
- A formalization of the JavaScript object that underpins AJAX by using the **XmlHttpRequest** object.
- Support for continuous communication between browser and web server by using web sockets.
- Support for using multiple threads to handle processing for a web page by using web workers.
- Support for accessing a device's GPS capabilities by using the Geolocation API.

**Reference Links**: You can find the current draft of the W3C HTML5 specification at 
http://go.microsoft.com/fwlink/?LinkID=267714.
(**https://html.spec.whatwg.org/**)

You can find a version of the specification for web developers (minus the browser interoperability instructions) at http://go.microsoft.com/fwlink/?LinkID=267715.

HTML5 provides a much richer semantic structure for documents, including:
- The <**section**> element, which identifies component pieces of content on a page. For example, the ingredients and the method in a recipe displayed by a page could be two separate sections.
- The <**header**> element, which identifies the content in the header of the page. For example, a company website might include its logo, name, and motto in the <**header**>.
- The <**footer**> element, which identifies the content in the footer of the page. For example, links to site maps, privacy statements, and terms and conditions are often included in the <**footer**>.
- The <**nav**> element, which identifies the content providing the main navigation sections of the page. Developers often use this element to implement a menu listing the various features of a web application, organized as a series of web pages.
- The <**article**> element, which identifies standalone pieces of content that would make sense outside of the context of the current page. For example, a blog post, a recipe, or a catalog entry.
- The <**aside**> element, which identifies content related to an <**article**> that isn't part of its main flow. For example, you might use <**aside**> to identify quotes or sidebar content.

##### Content Structure in HTML5
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>My Best Recipes</title>
</head>
<body>
    <nav>
        <a href="/">Home</a>
    </nav>
  
    <header>
        <h1>My Best Recipes</h1>
        <p>My favorite recipes</p>
    </header>
  
    <article>
        <h1>Beans On Toast</h1>
        <section>
            <h1>Ingredients</h1>
            <ul>
                <li>Beans</li>
                <li>Bread</li>
            </ul>
        </section>
        <section>
            <h1>Method</h1>
            <ol>
                <li>Toast bread</li>
                <li>Heat beans</li>
                <li>Put beans on the toast</li>
            </ol>
        </section>
    </article>
    <footer>
        <small>Last updated on <time datetime="2012-08-12">August 12, 2012</time></small>
    </footer>
</body>
</html>
```

HTML5 also defines a number of new elements to improve the semantic context of the document, including:
- The <**hgroup**> element, which indicates that its contents should be treated as a single heading. This element can contain header tags \<h1> to \<h6>.
- The <**time**> element, which enables you to define an unambiguous time, duration, or period that is both human and machine readable. The **datetime** attribute contains the ISO standard representation of the contents of an element.
- The <**mark**> element, which identifies that its contents should be treated as text to be marked or highlighted for reference purposes.
- The <**small**> element, which identifies that its contents should be treated as side comments, such as small print or author attributions.
- The <**figure**> element, which is typically used to identify an image, video, or code listing and its associated descriptive content and other elements. If the content needs a caption, you can nest the <**figcaption**> element inside the <**figure**> element.

Additional Reading: HTML5 also adds to the global attributes defined in HTML4. You can find a full list at http://go.microsoft.com/fwlink/?LinkID=267716.

### Demonstration: Using HTML5 Features in a Simple Contact Form
#### Demonstration steps
You will find the steps in the “Demonstration: Using HTML5 Features in a Simple Contact Form“ section on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD02_DEMO.md.

### Fonts
- font-family
``` css
font-family : Arial, Candara, Verdana, sans-serif;
font-family : Georgia, Corbel, "Times New Roman", serif;
font-family : Consolas, "Courier New", monospaced;
```
- font-size
```css
font-size : 16px;
font-size : 150%;  /* Font-size of the parent element * 150% */
font-size : 1em;   /* 1em = base font-size of the page. Usually 16px */
```
- font-style
```css
font-style : italic;
```
- font-weight
```css
font-weight : bold;
font-weight : normal;
font-weight : 800;
```
CSS also provides a shortcut property simply called font
```css
p { font : bold 16px/1.5 "Arial"; }
/* The above is a shorthand for the following rules The default font-style is used. */
  
p {
  font-weight: bold;
  font-size: 16px;
  line-height : 1.5em;
  font-family: Arial;
}
```
### Colors
- color
```css
/* The following color values are all equivalent. */
color : olive;
color : #808000;
color : rgb(128, 128, 0);
```
- opacity
```css
p {
opacity : 0.6;
filter:alpha(opacity=60);  /* IE8 and earlier */
}
```
- letter-spacing
```css
letter-spacing : 2em;
letter-spacing : -3px;
```
- line-height
```css
line-height : 16px;
line-height : normal; /* This is the default */
line-height : 1.2;
line-height : 120%;
```
- text-align
```css
text-align : left;
```
- text-decoration
```css
text-decoration : underline;
```
- text-transform
```css
text-transform : lowercase;
```
### The CSS Box Model
#### Using the box model properties
```css
h2.highlight {
  height : 100px;
  width : 500px;
  padding : 10px;
  border : 2px dotted blue;
  margin : 25px 0 25px 0;  /* Could also be written 25px 0 */
}
```
- Margin and padding
```css
padding-top: 10px;
padding-right : 10px;
padding-bottom : 10px;
padding-left : 10px;
```
- Border
```css
border-width: 2px;
border-style: dotted;
border-color: blue;
```
Using the border-width, border-style, and border-color properties assumes that you want the set values to be 
the same around all four sides of the box. If this is not the case or you only want to set them for one side of
the border, you can use the border-left-style, border-left-width, border-left-color, border-right-style, border-right-width and so on properties. For example
```css
p.example {
  padding: 10px;
  border-bottom: solid 1px black;
  border-left-style: dotted;
  border-left-width: 2px;
}
```
### Styling Backgrounds in CSS
- background-image 
```css
background-image:url('../images/pattern.jpg');
```
- background-size
```css
background-size: 40px 60px;  /* 40px wide, 60px high */
```
- background-color
```css
background-color : green;
background-color : #00FF00;
background-color : rgb(0, 255, 0);
```
- background-position 
```css
background-position : left top;  /* Image locked into top left corner of element */
background-position : 100% 100%;  /* Image locked into bottom right corner of element */
background-position : 8px 8px; /* Image starts 8px from left and 8px from top of element */
```
- background-origin
```css
background-origin : border-box;
```
- background-repeat
```css
background-repeat : repeat-x; /* Repeat background image only horizontally */
background-repeat : no-repeat;  /* Don't repeat the image */
```
- background-attachment
```css
background-position : fixed;
```
CSS also provides the background shortcut property, which enables you to set some or all of the elements just described. You must set the values for these properties in the following order (only the background-image property is mandatory, the others are optional):
1. background-color
2. background-position
3. background-size
4. background-repeat
5. background-origin
6. background-clip
7. background-attachment
8. background-image
```css
article { background : transparent repeat-x url('fluffycat.jpg'); }
  
/* The above is a shorthand for the following rules */
article {
  background-color : transparent;
  background-repeat : repeat-x;
  background-image : url('fluffycat.jpg');
}
```

### Demonstration: Adding CSS Styles to an HTML Page
#### Demonstration steps
You will find the steps in the “Demonstration: Adding CSS Styles to an HTML Page“ section on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD02_DEMO.md.

### Demonstration: Creating and Styling an HTML5 Page
#### Demonstration steps

#### Lab: Creating and Styling HTML5 Pages
##### Lab setup
Estimated Time: 45 minutes

You will find the high-level steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD02_LAB_MANUAL.md.

You will find the detailed steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD02_LAK.md.

## Exercises

### Exercise 1: Creating HTML5 Pages
#### images
- speakers
- sponsors

#### index.txt
```txt
-- header --

ContosoConf
A two-track conference on the latest HTML5 developments


-- content --

The web keeps evolving. There's a wealth of new technologies to keep up with! ContosoConf is an in-depth exploration of HTML5, CSS3 and JavaScript, in the heart of Seattle, WA.
Don't miss the best speakers in the business, talking about the future of the web.

Featuring these excellent speakers
Melissa Kerr
David Alexander
Mark Hanson
April Meyer

Thanks to our sponsors
Trey Research
Litware, Inc
Fourth Coffee
Graphic Design Institute
Southridge Video


-- footer --

Hosted by Contoso

Conference Center
1234 Main Street
Seattle
WA 98999

© 2012 Contoso
```
#### about.txt
``` txt
ContosoConf brings web designers and developers together


Since the very first Contoso Conf back in 2009, we've been guided by three principles:
Community Matters
Never Stop Learning
Have fun!


Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae enim arcu, vitae aliquet purus. 
Aenean rhoncus diam et orci porttitor fringilla. In porta lacus a turpis pretium placerat. Cras viverra 
enim eu nibh pretium ornare. Praesent et adipiscing turpis. Duis mi risus, ornare at bibendum a, 
ullamcorper vel tellus. Nulla in egestas velit. Aenean consequat mi sed tellus iaculis laoreet. Donec et 
odio vel felis commodo porttitor.

Aenean id ligula est. Pellentesque ut magna ligula. Donec nunc eros, tincidunt sit amet sollicitudin 
in, semper id mauris. Phasellus odio nulla, molestie ac gravida sed, dignissim in nisl. Nunc luctus 
lobortis massa at dapibus. Aenean turpis nibh, hendrerit nec congue et, elementum a justo. Aenean sit 
amet nulla odio. Cras feugiat porta risus nec pretium.


What's It All About?

Donec vel sem ut dui vulputate porta. Phasellus imperdiet sapien a arcu adipiscing vitae adipiscing 
elit pharetra. Donec sed ante ut eros mattis bibendum non in erat. Donec sagittis, massa eu accumsan 
eleifend, eros justo cursus justo, id consequat mauris diam id magna. Vivamus quis tortor massa. Nam ipsum metus, 
dapibus ac facilisis sit amet, ullamcorper quis risus. Integer aliquet eleifend accumsan.

"I had a fantastic time and learnt so much!"

Pellentesque facilisis blandit augue id rhoncus. Sed facilisis varius lectus, eget commodo purus dapibus 
nec. In hac habitasse platea dictumst. Etiam imperdiet facilisis malesuada. Nunc semper venenatis elit ac 
lobortis. Duis lorem lorem, pharetra ut scelerisque nec, consequat sed risus. Morbi rutrum nisl ut ipsum 
consectetur porttitor. Phasellus sed nunc id diam tempus congue in a leo.

Proin feugiat, turpis id tempor tempor, lorem libero malesuada.
```


### Exercise 2: Styling HTML pages
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/tree/master/Allfiles/Mod02/Labfiles/Solution/Exercise%202/ContosoConf/ContosoConf

#### index.htm
``` html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>ContosoConf</title>
    <link href="/styles/site.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <nav>
        <div class="container">
            <a href="/index.htm">Home</a>
            <a href="/about.htm">About</a>
        </div>
    </nav>
    <div class="container">
        <header>
            <h1>ContosoConf</h1>
            <p>A two-track conference on the latest HTML5 developments</p>
        </header>
        <section>
            <p>
                The web keeps evolving. There's a wealth of new technologies to keep up with! ContosoConf is an in-depth exploration of HTML5, CSS3 and JavaScript, in the heart of Seattle, WA.
            </p>
            <p>
                Don't miss the best speakers in the business, talking about the future of the web.
            </p>
        </section>
        <section>
            <h2>Featuring these excellent speakers</h2>
            <ul>
                <li><img src="images/speakers/melissa-kerr.jpg" alt="Melissa Kerr" />Melissa Kerr</li>
                <li><img src="images/speakers/david-alexander.jpg" alt="Melissa Kerr" />David Alexander</li>
                <li><img src="images/speakers/mark-hanson.jpg" alt="Mark Hanson" />Mark Hanson</li>
                <li><img src="images/speakers/david-alexander.jpg" alt="April Meyer" />April Meyer</li>
            </ul>
        </section>
        <section>
            <h2>Thanks to our sponsors</h2>
            <ul>
                <li><img src="images/sponsors/sponsor1.png" alt="Trey Research" />Trey Research</li>
                <li><img src="images/sponsors/sponsor2.png" alt="Litware, Inc" />Litware, Inc</li>
                <li><img src="images/sponsors/sponsor3.png" alt="Fourth Coffee" />Fourth Coffee</li>
                <li><img src="images/sponsors/sponsor4.png" alt="Graphic Design Institute" />Graphic Design Institute</li>
                <li><img src="images/sponsors/sponsor5.png" alt="Southridge Video" />Southridge Video</li>
            </ul>
        </section>
        <footer>
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
        </footer>
    </div>
</body>
</html>
```
#### about.htm
``` html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>About ContosoConf</title>
    <link href="/styles/site.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <nav>
        <div class="container">
            <a href="/index.htm">Home</a>
            <a href="/about.htm">About</a>
        </div>
    </nav>
    <div class="container">
        <header>
            <h1>ContosoConf</h1>
            <p>A two-track conference on the latest HTML5 developments</p>
        </header>
        <article>
            <h1>ContosoConf brings web designers and developers together</h1>
            <section>
                <p>
                    Since the very first Contoso Conf back in 2009, we've been guided by three principles:
                </p>
                <ol>
                    <li>Community Matters</li>
                    <li>Never Stop Learning</li>
                    <li>Have fun!</li>
                </ol>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae enim arcu, vitae aliquet purus. 
                    Aenean rhoncus diam et orci porttitor fringilla. In porta lacus a turpis pretium placerat. Cras viverra 
                    enim eu nibh pretium ornare. Praesent et adipiscing turpis. Duis mi risus, ornare at bibendum a, 
                    ullamcorper vel tellus. Nulla in egestas velit. Aenean consequat mi sed tellus iaculis laoreet. Donec et 
                    odio vel felis commodo porttitor.
                </p>
                <p>
                    Aenean id ligula est. Pellentesque ut magna ligula. Donec nunc eros, tincidunt sit amet sollicitudin 
                    in, semper id mauris. Phasellus odio nulla, molestie ac gravida sed, dignissim in nisl. Nunc luctus 
                    lobortis massa at dapibus. Aenean turpis nibh, hendrerit nec congue et, elementum a justo. Aenean sit 
                    amet nulla odio. Cras feugiat porta risus nec pretium.
                </p>
                <h2>What's It All About?</h2>
                <p>
                    Donec vel sem ut dui vulputate porta. Phasellus imperdiet sapien a arcu adipiscing vitae adipiscing 
                    elit pharetra. Donec sed ante ut eros mattis bibendum non in erat. Donec sagittis, massa eu accumsan 
                    eleifend, eros justo cursus justo, id consequat mauris diam id magna. Vivamus quis tortor massa. Nam ipsum metus, 
                    dapibus ac facilisis sit amet, ullamcorper quis risus. Integer aliquet eleifend accumsan.
                </p>
                <blockquote>I had a fantastic time and learnt so much!</blockquote>
                <p>
                    Pellentesque facilisis blandit augue id rhoncus. Sed facilisis varius lectus, eget commodo purus dapibus 
                    nec. In hac habitasse platea dictumst. Etiam imperdiet facilisis malesuada. Nunc semper venenatis elit ac 
                    lobortis. Duis lorem lorem, pharetra ut scelerisque nec, consequat sed risus. Morbi rutrum nisl ut ipsum 
                    consectetur porttitor. Phasellus sed nunc id diam tempus congue in a leo.
                </p>
                <p>
                    Proin feugiat, turpis id tempor tempor, lorem libero malesuada.
                </p>
            </section>
        </article>
        <footer>
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
        </footer>
    </div>
</body>
</html>
```

#### site.css
``` css

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


---
