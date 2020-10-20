Module 1: Overview of HTML and CSS
=== 
### Contents:
Module overview
- Lesson 1:	Overview of HTML
- Lesson 2:	Overview of CSS
- Lesson 3:	Creating a Web Application by Using Visual Studio 2017
- Lab:	Exploring the Contoso Conference Application
- Module review and takeaways
- coding
## Module overview

## Lesson 1: Over of HTML

This course provides an introduction to HTML5, CSS3, and JavaScript. IT helps students gain basic HTML5/CSS3/JavaScript programming skills. Students will learn how to use HTML5, CSS3, and JavaScript to build responsive and scalable Web applications that can dynamically detect and adapt to different form factors and device capabilities.

HTML is an acronym for Hyper Text Markup Language. 

### The Structure of an HTML Page
##### The minimum maintainable page
```html
<!DOCTYPE html> 
<html lang=”en”> 
  <head> 
    <meta charset=utf-8 /> 
    <title>The Smallest Page</title> 
  </head> 
  <body> 
  </body> 
</html>
````
The code example above uses the DOCTYPE declaration for HTML5.

```html
<!DOCTYPE html>
```
You should write all your new web pages by using HTML5, but you are likely to see many web pages written by using HTML 4.01 or earlier.
Pages that are not based on HTML5 commonly use one of the following classes of DOCTYPE:
* Transitional DOCTYPEs, which allow the use of deprecated, presentation-related elements from previous versions of HTML.
```html
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd>
```
* Frameset DOCTYPEs, which allow the use of frames in addition to the elements allowed by the transitional DOCTYPE.
```html
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" 
"http://www.w3.org/TR/html4/frameset.dtd">
```
* Strict DOCTYPEs, which do not permit the use of frames or deprecated elements from previous versions of HTML.
```html
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" 
"http://www.w3.org/TR/html4/strict.dtd">
```
At all times, if you cannot use the HTML5 DOCTYPE you should use the strict HTML 4.01 DOCTYPE. 
If an HTML file has no DOCTYPE, browsers may use their own value and might render your web page inconsistently, 
so it is important to include the DOCTYPE.

### Tags, Elements, Attributes, and Content
##### The body of a simple document
```html
<body>
  <h1 class="blue">An introduction to elements, tags and contents</h1>
  <p>
    <strong>Elements</strong> consist of <strong>content</strong> bookended by a 
    <em>start</em> tag and an <em>end</em> tag. 
  </p>
  <hr />
  <p>
    Certain elements, such as the horizontal rule element, do not need content however and consist of a 
    single, self-closing element. These are known as empty elements.
  </p>
</body>
```
### Displaying Text in HTML
##### Marking up text
```hmtl
<body>
  <h1>An Introduction to HTML</h1>
  <p>In this module, we look at the history of HTML and CSS.</p>
  <h2>In the Beginning</h2>
  <p>
    WorldWideWeb was a piece of software written by Sir Tim Berners-Lee at CERN as a replacement for 
    Gopher. It and HTML v1 were made open source software in 1993. The World Wide Web as we know it   
    started with this piece of software.
  </p>
  <h3>Browser Wars</h3>
  <p>The openness of WorldWideWeb meant many different web browsers were created early on, including Netscape Navigator and NCSA Mosaic, which later became Microsoft Edge.</p>
</body>
```

#### Emphasis
HTML defines four elements that denote a change in emphasis in the text they surround from the text in which they are nested:
* `<strong>` identifies text that is more important than its surrounding text. The browser usually renders this content in **bold**.
* `<em>` identifies text that needs to be stressed. The browser usually renders this content in *italics*.
* `<b>` and `<i>` identify text to be rendered in bold or in italics, respectively.

##### Adding stress to text
```html
<p>
  To <strong>emphasize</strong> is to give extra weight to (a communication); <em>"Her gesture emphasized her words"</em>.
</p>
```

##### Unordered, ordered, and definition lists
```html
<body> 
  <p>Here’s a small list of HTML editors</p> 
  <ul> 
    <li>Notepad</li> 
    <li>Textmate</li> 
    <li>Visual Studio</li> 
  </ul> 
  <p>Here’s how to write a Web page</p> 
  <ol> 
    <li>Create a new text file</li> 
    <li>Add some HTML</li> 
    <li>Save the file to a website</li> 
  </ol> 
  <p>Here’s a small list of people in the Internet Hall of Fame and what they did</p> 
  <dl> 
    <dt>Sir Tim Berners Lee</dt> 
    <dd>Invented HTML and wrote WorldWideWeb</dd> 
    <dt>Linus Torvalds</dt> 
    <dd>Originator of Linux</dd> 
    <dt>Charles Herzfeld</dt> 
    <dd>Authorized the creation of ARPANET, the predecessor of the Internet</dd> 
  </dl> 
</body>
```
##### Writing nested lists
```html
<body>
  <ol>
    <li>Lesson One: Introduction to HTML
      <ol>
        <li>The structure of an HTML page</li>
        <li>Tags, Elements, Attributes and Content</li>
        <li>Text and Images</li>
        <li>Forms</li>
      </ol>
    </li>
    <li>Lesson Two: Introduction to CSS</li>
    <li>Lesson Three: Using Visual Studio 2017</li>
  </ol>
</body>
```
### Displaying Images and Linking Documents in HTML
You use the HTML <img> tag to insert an image into your web page. It does not require an end tag as it does not contain any content. 
In addition to the global attributes, the <img> tag has a number of attributes to define it:
- The `src` attribute specifies a URL that identifies the location of the image to be displayed
- The `alt` attribute identifies a text alternative for display in place of the image if the browser is still downloading it or 
cannot display it for some reason; for example, if the image file is missing. It typically describes the content of the image.
- The `title` attribute identifies some text to be used in a tool-tip when a user’s cursor hovers over the image
- The `longdesc` attribute identifies another web page that describes the image in more detail
- The `height` and `width` attributes set the dimensions in pixels of the box on the web page that will contain the image; 
if the dimensions are different from those of the image, browsers will resize the image on the fly to fit the box
##### Adding an image to a web page
```html
<body> 
  <p> 
    <img src=”logo.jpg” alt=”My Web site logo” height=”100” width=”100” /> 
  </p> 
  <h1>Welcome to my site!</h1> 
</body>
```
#### Hypertext Links
The main reason for the invention of HTML was to link documents together. The <a> tag, also known as the anchor tag, allows you to identify a section of content in your web page to link to another resource on the web. Typically the target of this hypertext link is another web page, but it could equally be a text file, image, archive file, email, or web service. When you view your web page in a browser, you click the content surrounded by the anchor tags to have the linked document downloaded by the browser.

Anchor tags have the following non-global attributes:
- The `href` attribute identifies the web page or resource to link to
- The `target` attribute identifies where the browser will display the linked page; valid values are _blank, _parent, _self, and _top
- The `rel` attribute identifies what kind of link is being created
- The `hreflang` attribute identifies the language of the linked resource
-  The `type` attribute identifies the MIME type of the linked resource

##### Adding hypertext links to your web page
```html
<body> 
  <ul> 
    <li><a href=”default.html” alt=”Home Page”>Home</a></li> 
    <li><a href=”about.html” alt=”About this Web site”>About</a></li> 
    <li><a href=”essays.html” alt=”A list of my essays”>Essays</a></li> 
  </ul> 
</body>
````
### Gathering User Input by Using Forms in HTML
Use the HTML `<form>` element to identify an area of your web page that will act as an input form. This element has the following attributes:
- The `action` attribute, which identifies the URL of the page to which the form data submitted by the user will be sent for processing.
- The `method` attribute, which defines how the data is sent to the server. Valid values are:
  - `GET` for HTTP GET. This is the default value, but is not secure
  - `POST` for HTTP POST. This is the preferred value
- The `accept-charset` attribute, which identifies the character encoding of the data submitted in the form by the user.
- The `enctype` attribute, which identifies the MIME-type used when encoding the form data for submission when the method is POST.
- The `target` attribute, which identifies where the browser will display the action page; valid values are _blank, _parent, _self, and _top.
#### Form Controls
An `<input>` element represents the main HTML data entry control and has many different forms based on its `type` attribute, 
as shown in the following table. In addition, the `value` attribute sets a default value for numeric or text-based controls, 
and the name attribute to identify the name of the control.

There are four other HTML elements that you can use in a form:
- `<textarea>`, which generates a free-form, multiline, plain text edit box; use the `rows` and `cols` attributes to set its size.
- `<select>`, which defines a list box or drop-down list. Use the `multiple` attribute to indicate if the user can select more than 
  one item from the list and `<option>` elements nested within `<select>` to identify the items. 
  Use the `<option>`’s `selected` attribute to indicate that it is selected by default and its `value` attribute to 
  indicate a value other than its text content to be sent to the server when the form is submitted.
- `<button>`, which defines a button. Use the type attribute to indicate whether it is a `submit`, `reset`, or `button` (does nothing) button. 
The default is `submit`.

#### Form Layout Elements
You can use `<p>` and `<div>` tags to apply a basic layout to a form. HTML also defines two further tags that can help to improve a form’s presentation:
- `<fieldset>`, which identifies a group of controls in a form. 
The browser reflects this by drawing a box around the contents of the `<fieldset>` and labeling the box with a name. 
This name is set by using the `<legend>` element, which must be the first child of the `<fieldset>` element.
- `<label>`, which identifies a text label associated with a form control. 
It does so either by surrounding both the text and the control, or by surrounding the text and 
setting it’s `for` attribute to the `id` of the form control.

##### Using a form to obtain the details of a user
```hmtl
<form method="post" action="/registration/new" id="registration-form"> 
  <label for="first-name">First name:</label><br /> 
  <input type="text" id="first-name" name="FirstName"/><br /> 
  <label for="last-name">Last name:</label><br /> 
  <input type="text" id="last-name" name="LastName"/><br /> 
  <label for="email-address">Email address:</label><br /> 
  <input type="email" id="email-address" name="EmailAddress"/><br /> 
  <label for="password">Choose a password:</label><br /> 
  <input type="password" id="password" name="Password"/><br /> 
  <label for="confirm-password">Confirm your password:</label><br /> 
  <input type="password" id="confirm-password" name="ConfirmPassword"/><br /> 
  <label for="website">Website/blog:</label><br /> 
  <input type="url" id="website" name="WebsiteUrl" /><br /> 
  <button type="submit">Register</button> 
</form>
```
### Demonstration: Creating a Simple Contact Form
```html
<!DOCTYPE HTML> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8" /> 
    <title>Contact Us</title> 
</head> 
    
<body> 
    <h1>Contact Contoso Conferencing</h1>
    <p>Contoso Conferencing Ltd.</p> 
    <p>123 South Street<br /> 
        Somewhere<br /> 
        Over There<br /> 
        <em>USA</em></p>
    <p> 
        <a href="mailto:contact@contoso.com"> 
        contact@contoso.com</a> 
    </p>
    <p> 
        If you would like to contact Contoso Conferencing, whether you're interested in our 
        services or in a conference we're currently organising, don't hesitate to contact us 
        using our enquiry form (<strong>Bold fields</strong> are required). 
    </p>
    
    <form method="Post" action="support.aspx"> 
        <fieldset> 
            <legend> 
                Your Details and Enquiry 
            </legend> 
            
            <ol> 
                <li> 
                    <label> 
                        <strong>Name</strong><br /> 
                        <input type="text" 
                            name="UserName" /> 
                    </label> 
                </li> 
                <li> 
                    <label> 
                        Telephone<br /> 
                        <input type="text" 
                            name="Phone" /> 
                    </label> 
                </li> 
                <li> 
                    <label> 
                        Email Address<br /> 
                        <input type="text" 
                            name="Email" /> 
                    </label> 
                </li> 
                <li> 
                    <label> 
                        <strong>Message</strong><br /> 
                        <textarea name="Message" 
                            cols="30" rows="10">Add your message here 
                        </textarea> 
                    </label> 
                </li> 
            </ol>
        </fieldset> 
        <input type="submit" value="Send" />
    </form>

</body> 
    
</html>
```
#### Attaching Scripts to an HTML Page
```html
<script type="text/javascript">
  alert('I am a line of JavaScript');
</script>
```
```html
<script type="text/javascript" src="alertme.js"></script>
```
```html
<script type="text/javascript" 
  src="http://ajax.contoso.com/ajax/jQuery/jquery-1.7.2.js">
</script>
```
The <script> element has three attributes:
- The **type** attribute, which identifies which script language is used; the default is **text/javascript**.
- The **src** attribute, which identifies a script file for download; do not use src if you are writing script into the content part of the <script> element.
- The **charset** attribute, which identifies the character encoding (for example, utf-8, Shift-JIS) of the external script file; if you are not using the **src** attribute, do not set the **charset** attribute.
- Use the <noscript> element to alert users that your page uses JavaScript, and so the user should enable JavaScript in the browser in order to display your page correctly.

##### The <noscript> element
```html
<body>
  <noscript>This page uses JavaScript. Please enable it in your browser</noscript>
  …
  Rest of page
  …
  <script src="MyScripts.js"></script>
</body>
```

Lesson 2: Overview of CSS
---
### How CSS Selectors Work
##### Introducing the element, class, and id selectors
```css
h2 {
  font-size: 24px;
}
  
.red {
  color: red;
}
  
#alert {
  background-color: red;
  color: white;
}
```
The selector, h2.blue returns the set of \<h2> elements with the class "blue", and h2#toc returns the set of \<h2> elements with id "toc".
##### Combining selectors
```css
h2.blue {
  color: blue;
}
  
h2#toc {
  font-weight: bold;
}
```  
The following table shows examples of the various ways you can concatenate selectors and the set of elements that the browser returns:

|  `________CSS_____` | Return |
| ---: | --- |
| `h2.blue` | Returns any `<h2>` elements of class "blue" |
| `h2#blue` | Returns any `<h2>` elements with id "blue" |
| `section, h2` | Returns any `<h2>` and any `<section>` elements |
| `section h2` | Returns any `<h2>` elements nested within a `<section>` element at any level. |
| `section > h2` | Returns any `<h2>` elements nested immediately under a `<section>` element |
| `section + h2` | Returns any `<h2>` elements immediately following and sharing the same parent element as a `<section>` element |
| `section ~ h2` | Returns any `<h2>` elements following and sharing the same parent element as a `<section>` element |


#### The Attribute Selector
|  `________Atribute_____` | Return |
| ---: | --- |
| `input[type]` | Returns any `<input>` elements that use the type attribute, whatever its value. |
| `input[type="text"]` | Returns any `<input>` elements where the type attribute value is exactly equal to the string "text". |
| `input[foo~="red"]` | Returns any `<input>` elements where the foo attribute (for instance, the class attribute) contains a space-separated list of values, one of which is exactly equal to "red". | 
| `input[type^="sub"]` | Returns any `<input>` elements where the type attribute value begins exactly with the string "sub". |
| `input[type$="mit"]` | Returns any `<input>` elements where the type attribute value ends exactly with the string "mit". |
| `input[type*="ubmi"]` | Returns any `<input>` elements where the type attribute value contains the substring "ubmi".  |
| `input[foo\|="en"]` | Returns any `<input>` elements where the foo attribute value is either exactly "en" or begins exactly with "en-", i.e. the value plus a hyphen. |

You can combine attribute selectors by concatenating them. For example, to return a set of all checkboxes that are checked by default, you would use the following selector:
```html
input[type="checkbox"][selected] {}
```
### How HTML Inheritance and Cascading Styles Affect Styling
https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Cascade_and_inheritance#### HTML Inheritance
#### Cascading Rules
https://youtu.be/Sp9ZfSvpf7A

CSS provides four special universal property values for controlling inheritance. Every CSS property accepts these values.
- inherit:
Sets the property value applied to a selected element to be the same as that of its parent element. Effectively, this "turns on inheritance".
- initial:
Sets the property value applied to a selected element to the initial value of that property.
- unset:
Resets the property to its natural value, which means that if the property is naturally inherited it acts like inherit, otherwise it acts like initial.
#### Cascading Rules
There are three factors that browsers must take into consideration when they apply styling rules:
1. Importance. You can ensure a certain property is always applied to a set of elements by appending the rule with !important.
```html
h2 { font-weight : bold !important; }
```
2. Specificity. Style rules with the least specific selector are applied first, then those for the next specific, and so on until the style rules for the most specific selector are applied.
3. Source order. If styles rules exist for selectors of equal specificity, they are applied in the order given in the style sheet.
### Adding Styles to An HTML Page
HTML enables you to attach your CSS rules to your web page in three ways. You can:
- Write rules specific to an element within its style attribute.
```html
<p style="font-family : Candara; font-size: 12px; "> ... </p>
```
- Write a set of rules specific to a page within its \<head> element by using \<style> tags.
```html
<style type="text/css">
  p {
    font-family : Candara; font-size: 12px;
  }
</style>
```
- Write all your rules in a separate style sheet file with the .css extension, and then reference it in the markup of the page by using a \<link> tag. The most common place to add a \<link> tag is within the \<head> element.
```html
<link rel="stylesheet" type="text/css" href="mystyles.css" media="screen">
```
The \<link> element has four CSS-relevant attributes:
- The **href** attribute specifies a URL that identifies the location of the style sheet file. 
- The **rel** attribute indicates the type of document the <link> element is referencing; set this to **style sheet** when linking to style sheets.
- The **media** attribute indicates the type of device targeted by the style sheet; possible values include **speech** for speech synthesizers, **print** for printers, **handheld** for mobile devices and **all** (the default), indicating the style sheet is all purpose
- The **type** attribute indicates the MIME type of the document being referenced; the correct type for style sheets is **text/css** which is also the default value for this attribute

The **type** and **media** attributes have the same function for the **\<style>** element as their namesakes for the **\<link>** element.

---
Lesson 3: Creating a Web
---
### Demonstration: Exploring the Contoso Conference Applicatio

#### Demonstration steps
You will find the steps in the “Demonstration: Creating a Web Site by Using Visual Studio 2017 “ section on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD01_DEMO.md.

### Lab: Exploring the Contoso Conference Application
#### Lab setup
Estimated Time: 30 minutes

You will find the high-level steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD01_LAB_MANUAL.md.

You will find the detailed steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD01_LAK.md.

### Exercise 1: Exploring the Contoso Conference Application
### Exercise 2: Examining and Modifying the Contoso Conference Application
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/tree/master/Allfiles/Mod01/Labfiles/Solution/ContosoConf


## coding
#### index.htm
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
        
        <link href="/styles/mobile.css" rel="stylesheet" type="text/css" />
        <link href="/styles/print.css" media="print" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <nav class="page-nav">
            <div class="container">
                <a href="/index.htm" class="active">Home</a>
                <a href="/about.htm">About</a>
                <a href="/schedule.htm">Schedule</a>
                <a href="/register.htm">Register</a>
                <a href="/location.htm">Location</a>
                <a href="/live.htm">Live</a>
                <a href="/feedback.htm">Feedback</a>
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

        <script src="/dist/video.bundle.js" type="module"></script>
    </body>
</html>
```
#### about.htm
``` html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>About ContosoConf</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
        <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
        <link href="/styles/header.css" rel="stylesheet" type="text/css" />
        <link href="/styles/footer.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/pages/about.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/mobile.css" rel="stylesheet" type="text/css" />
        <link href="/styles/print.css" media="print" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <nav class="page-nav">
            <div class="container">
                <a href="/index.htm">Home</a>
                <a href="/about.htm" class="active">About</a>
                <a href="/schedule.htm">Schedule</a>
                <a href="/register.htm">Register</a>
                <a href="/location.htm">Location</a>
                <a href="/live.htm">Live</a>
                <a href="/feedback.htm">Feedback</a>
            </div>
        </nav>
        
        <header class="page-header">
            <div class="container">
                <h1>ContosoConf</h1>
                <p class="tag-line">A two-track conference on the latest HTML5 developments</p>
            </div>
        </header>
        
        <section class="page-section about">
            <article class="container">
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
        
        <script src="/dist/offline.bundle.js" type="module"></script>
    </body>
</html>
```
#### schedule.htm
``` html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>ContosoConf Schedule</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
        <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
        <link href="/styles/header.css" rel="stylesheet" type="text/css" />
        <link href="/styles/footer.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/pages/schedule.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/mobile.css" rel="stylesheet" type="text/css" />
        <link href="/styles/print.css" media="print" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <nav class="page-nav">
            <div class="container">
                <a href="/index.htm">Home</a>
                <a href="/about.htm">About</a>
                <a href="/schedule.htm" class="active">Schedule</a>
                <a href="/register.htm">Register</a>
                <a href="/location.htm">Location</a>
                <a href="/live.htm">Live</a>
                <a href="/feedback.htm">Feedback</a>
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

        <script src="/dist/schedule.bundle.js" type="module"></script>
        <script src="/dist/offline.bundle.js" type="module"></script>
    </body>
</html>
```
#### register.htm
``` html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>Register for ContosoConf</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
        <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
        <link href="/styles/header.css" rel="stylesheet" type="text/css" />
        <link href="/styles/footer.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/pages/register.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/mobile.css" rel="stylesheet" type="text/css" />
        <link href="/styles/print.css" media="print" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <nav class="page-nav">
            <div class="container">
                <a href="/index.htm">Home</a>
                <a href="/about.htm">About</a>
                <a href="/schedule.htm">Schedule</a>
                <a href="/register.htm" class="active">Register</a>
                <a href="/location.htm">Location</a>
                <a href="/live.htm">Live</a>
                <a href="/feedback.htm">Feedback</a>
            </div>
        </nav>
        
        <header class="page-header">
            <div class="container">
                <h1>ContosoConf</h1>
                <p class="tag-line">A two-track conference on the latest HTML5 developments</p>
            </div>
        </header>
        
        <section class="page-section register">
            <div class="container">
                <h1>Register for the conference</h1>
                <form method="post" action="/registration/new" id="registration-form">
                    <div class="field">
                        <label for="first-name">First name:</label>
                        <input type="text" id="first-name" name="FirstName" required="required" autofocus="autofocus"/>
                    </div>
                    <div class="field">
                        <label for="last-name">Last name:</label>
                        <input type="text" id="last-name" name="LastName" required="required"/>
                    </div>
                    <div class="field">
                        <label for="email-address">Email address:</label>
                        <input type="email" id="email-address" name="EmailAddress" required="required"/>
                    </div>
                    <div class="field">
                        <label for="password">Choose a password:</label>
                        <input type="password" id="password" name="Password" required="required" pattern="[a-zA-Z0-9]{5,}" title="At least 5 letters and numbers"/>
                    </div>
                    <div class="field">
                        <label for="confirm-password">Confirm your password:</label>
                        <input type="password" id="confirm-password" name="ConfirmPassword" required="required"/>
                    </div>
                    <div class="field">
                        <label for="website">Website/blog:</label>
                        <input type="url" id="website" name="WebsiteUrl" placeholder="http://"/>
                    </div>
                    <div>
                        <button type="submit">Register</button>
                    </div>
                </form>

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
        
        <script src="/dist/register.bundle.js" type="module"></script>
    </body>
</html>
```
#### location.htm
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
                <a href="/live.htm">Live</a>
                <a href="/feedback.htm">Feedback</a>
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

        <script src="/dist/location.bundle.js" type="module"></script>
        <script src="/dist/locationVenue.bundle.js" type="module"></script>
        <script src="/dist/offline.bundle.js" type="module"></script>
    </body>
</html>
``` 
#### live.htm
``` html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>ContosoConf Live</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
        <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
        <link href="/styles/header.css" rel="stylesheet" type="text/css" />
        <link href="/styles/footer.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/pages/live.css" rel="stylesheet" type="text/css" />
        
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
                <a href="/live.htm" class="active">Live</a>
                <a href="/feedback.htm">Feedback</a>
            </div>
        </nav>
        
        <header class="page-header">
            <div class="container">
                <h1>ContosoConf</h1>
                <p class="tag-line">A two-track conference on the latest HTML5 developments</p>
            </div>
        </header>
        
        <section class="page-section live">
            <div class="container">
                <h1>Attending the conference right now? Get involved!</h1>
                <form action="#">
                    <label for="ask-question-text">Ask a question</label>
                    <input id="ask-question-text" type="text" />
                    <button type="submit">Ask</button>
                </form>
                <ul>
                    <!-- Questions will be displayed here when received by the web socket. -->
                </ul>
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

        <script src="/dist/live.bundle.js" type="module"></script>
    </body>
</html>
```
#### feedback.htm
``` html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>ContosoConf Feedback</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
        <link href="/styles/nav.css" rel="stylesheet" type="text/css" />
        <link href="/styles/header.css" rel="stylesheet" type="text/css" />
        <link href="/styles/footer.css" rel="stylesheet" type="text/css" />
        
        <link href="/styles/pages/feedback.css" rel="stylesheet" type="text/css" />
        
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
                <a href="/live.htm">Live</a>
                <a href="/feedback.htm" class="active">Feedback</a>
            </div>
        </nav>
        
        <header class="page-header">
            <div class="container">
                <h1>ContosoConf</h1>
                <p class="tag-line">A two-track conference on the latest HTML5 developments</p>
            </div>
        </header>
        
        <section class="page-section feedback">
            <div class="container">
                <section id="feedback">
                    <h1>Enjoyed the conference? Leave your feedback!</h1>
                    <form method="post" action="/send-feedback">
                        <div class="field feedback-question">
                            <label>How would you rate the speaker's knowledge of the topic?</label>
                            <input name="question" type="range" min="1" max="5"/>
                        </div>
                        <div class="field feedback-question">
                            <label>How well could you hear the speaker?</label>
                            <input name="question" type="range" min="1" max="5"/>
                        </div>
                        <div class="field feedback-question">
                            <label>How useful did you find the information in this talk?</label>
                            <input name="question" type="range" min="1" max="5"/>
                        </div>
                        <div class="field feedback-question">
                            <label>How would you rate the overall session?</label>
                            <input name="question" type="range" min="1" max="5"/>
                        </div>
                        <div class="field comments">
                            <label>Any additional comments?</label>
                            <textarea name="comments" cols="30" rows="5"></textarea>
                        </div>
                        <div class="field actions">
                            <button type="submit">Send Feedback</button>
                        </div>
                    </form>
                </section>
                
                <section id="feedback-sent">
                    <h1>Thanks for the feedback</h1>
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

        <script src="/dist/feedback.bundle.js" type="module"></script>
    </body>
</html>
```


---
