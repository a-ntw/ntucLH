Module 10: Implementing an Adaptive User Interface
===
Contents:
- Module overview
- Lesson 1:	Supporting Multiple Form Factors
- Lesson 2:	Creating an Adaptive User Interface
- Lab:	Implementing an Adaptive User Interface
- Module review and takeaways

## Module overview
### Objectives
After completing this module, you will be able to:
- Describe the requirements in a website for responding to different form factors.
- Create web pages that can adapt their layout to match the form factor of the device on which they are displayed.

## Lesson 1: Supporting Multiple Form Factors
### Lesson objectives
After completing this lesson, you will be able to:
- Explain why a website should be able to respond appropriately to users viewing the site 
  by using different devices.
- Describe the changes that are typically necessary to enable a website to be viewed by using different devices.

## Lesson 2: Creating an Adaptive User Interface
### Lesson objectives
After completing this lesson, you will be able to:
- Use media types to target different types of device, and to apply appropriate style sheet rules.
- Use media queries to identify certain properties of a device, and to apply appropriate style sheet rules.
- Identify the browser version that is Microsoft Edge being used to view a web page, and to 
  apply appropriate style sheet rules.
- Create a style sheet suitable for printing the content displayed by a web page.

### Demonstration: Implementing an Adaptive User Interface
#### Demonstration steps
You will find the steps in the “Demonstration: Implementing an Adaptive User Interface“ section on the 
following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD10_DEMO.md.

## Lab: Implementing an Adaptive User Interface
### Objectives
After completing this lab, you will be able to:
- Create style sheets that apply only when printing a web page.
- Use CSS media queries to enable a web page to adapt to different device form factors.

#### Lab setup
Estimated Time: 60 minutes

You will find the high-level steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD10_LAB_MANUAL.md.

You will find the detailed steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD10_LAK.md.

### Exercise 1: Creating a Print-Friendly Style Sheet
#### about.html
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
        
        <!-- TODO: Add print.css <link> here -->
        <link href="/styles/print.css" media="print" rel="stylesheet" type="text/css" />
        
        <link href="/styles/mobile.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <nav class="page-nav">
            <div class="container">
                <a href="/index.htm">Home</a>
                <a href="/about.htm" class="active">About</a>
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
        
        <script src="/scripts/offline.js" type="module"></script>
    </body>
</html>
```
#### print.css
``` css
nav.page-nav, header.page-header, footer.page-footer {
    display: none;
}

.container {
    padding: 0;
    max-width: none;
}

.about > article > section {
    column-count: 1;
}
```
#### site.css
``` css
/* Styles used throughout the entire web site */

html {
    /* font-size 62.5% makes 1rem equal 10px for easy size calculations. */
    font-size: 62.5%;
    font-family: Calibri, Arial, sans-serif;
    background-color: #EAEEFA;
    height: 100%;
}

body {
    height: 100%;
    margin: 0;
    /* Default font-size to about 18px */
    font-size: 1.8rem;
}

input, button {
    margin: 0;    
    font-size: 1.8rem;
    font-family: Calibri, Arial, sans-serif;
}

.container {
    padding: 0 1rem;
    max-width: 94rem;
    /* Horizontally center containers */
    margin: 0 auto;
}

section.page-section .container {
    padding-bottom: 2rem;
}

h1 {
    font-size: 4rem;
    letter-spacing: -1px;
    margin: 1em 0 .25em 0;
}
```

#### about.css
``` css
/* Styles for the about page */

.about > article > section {
    text-align: justify;

    /* Columns Layout */
    column-count: 3;
    column-gap: 5rem;
}

.about p:first-child:first-letter /* Picks out first letter only for drop cap effect */ {
    font-size: 300%;
    float: left;
    margin: 0 0.5rem 0 0;
    line-height: .8;
    color: #aaa;
}

.about p {
    text-indent: 3rem;
}

.about p:first-child /* Prevents text indenting after drop cap */ {
    text-indent: 0;
    margin-top: 0;
}

.about blockquote {
    font-size: 1.2em;
    padding: 0 0 0 6rem;
    margin: 0;
    font-style: italic;
    position: relative;
}

.about blockquote:before {
    content: '\201C';
    position: absolute;
    font-size: 10rem;
    font-family: serif;
    left: 0;
    top: -1rem;
    line-height: 1;
}
```

### Exercise 2: Adapting Page Layout to Fit Different Form Factors
####  index.htm
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

        <script src="/scripts/offline.js" type="module"></script>
        <script src="/scripts/pages/video.js" type="module"></script>
    </body>
</html>
```
#### mobile.css 
``` css
@media screen and (max-width: 480px) {
    nav.page-nav .container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }

    nav.page-nav .active:before,
    nav.page-nav .active:after {
        display: none;
    }

    nav.page-nav a {
        border: 1px dotted #3d3d3d;
        margin: .5rem;
    }
}

@media screen and (max-width: 720px) {
    header.page-header {
        height: auto;
    }

    header.page-header .register {
        display: none;
    }

    header.page-header h1 {
        font-size: 3rem;
    }
}
```



## Module review and takeaways
In this module you have learned why it is necessary to create websites that can dynamically adapt to 
different devices and browsers. You have seen the main considerations when tailoring a page to different 
form factors and browsers, and you have learned—by using media types, media queries, and conditional 
comments—how to detect the form factor and browser in CSS and HTML5. And finally, you have learned 
how to implement a basic style sheet suitable for printing content.
