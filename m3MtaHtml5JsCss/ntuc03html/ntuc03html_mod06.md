Module 6: Styling HTML5 by Using CSS3
===
Contents:
- Module overview
- Lesson 1:	Styling Text by Using CSS3
- Lesson 2:	Styling Block Elements
- Lesson 3:	Pseudo-Classes and Pseudo-Elements
- Lesson 4:	Enhancing Graphical Effects by Using CSS3
- Lab:	Styling Text and Block Elements by Using CSS3
- coding
    - Exercise 1: Styling the Navigation Bar
    - Exercise 2: Styling the Register Link
    - Exercise 3: Styling the About Page

## Module review and takeaways
### Objectives
After completing this module, you will be able to:
- Use the new features of CSS3 to style text elements.
- Use the new features of CSS3 to style block elements.
- Use CSS3 selectors, pseudo-classes, and pseudo-elements to refine the styling of elements.
- Enhance pages by using CSS3 graphical effects.

## Lesson 1:	Styling Text by Using CSS3
### Lesson objectives
After completing this lesson, you will be able to:
- Explain the different ranges of values you can apply to CSS font and text properties.
- Demonstrate the new CSS3 properties applicable to text and to blocks of text.

### Fonts and Measurements
> CSS3 font and text properties support:
> * External fonts
> ```css
>     @font-face {
>         font-family: newGroovyFont;
>         src: url('CandaraPlus.ttf')
>     }
> ```
> * Absolute text sizes
> ```css
>     font-size: 16pt;
>     line-weight: 0.5in;
>     letter-spacing: 12mm;
> ```
> * Relative text sizes
> ```css
>     font-size: 1em;
>     border-width: 300px;
>     padding: 16rem;
> ```

### Implementing Text Effects
> CSS includes further text styling support for:
> * Paragraph indentation `text-indent= 3rem;`
> * Line wrapping `hyphens:manual; word-wrap`
> * Text spacing `word-spacing: 2rem;`
> * Shadow effects `text-shadow: 2px 2px 0 red;`


---
## Lesson 2:	Styling Block Elements
### Lesson objectives
After completing this lesson, you will be able to
- Describe the new CSS3 properties applicable to the box model.
- Describe how to use these properties to lay out the items on a web page.

### New Block Properties in CSS3
> CSS3 adds enw box-level support for:
> * Outlines
> ``` css
>     outline: 2px soild greens;
>     outline-offset: 5rem;
> ```
> * Presentation
> ``` css
>     border-radius: 50% / 30%;
>     overflow: hidden;
>     resize: horizontal;
> ```
> * Multiple column layouts
> ```css
>     column-count: 3;
>     column-gap: 5rem;
>     column-rule: 1px soild black;
> ```

Reference Links: You can find the latest draft of the CSS3 Multi-Column Layout Module at 
http://go.microsoft.com/fwlink/?LinkID=267727.

### Block Layout Models
> CSS supports several block layout methods:
> * Block     `display:block;`
> * Inline    `display:inline;` `display: inline-block;`
> * Table     `display-table;`
> * Positioned `position:relative;` `position:absolute;` `position:fixed;` 
> * Flexbox   `display: flexbox;`

### Demonstration: Switching Between Cascading Style Sheets (CSS) Layout Models
#### Demonstration steps
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD06_DEMO.md.

---
## Lesson 3:	Pseudo-Classes and Pseudo-Elements
### Lesson objectives
After completing this lesson, you will be able to:
- Use pseudo-elements to add styles to text elements.
- Style hyperlinks and form elements based on their current state.
- Identify elements to style based on their position in a document.

### Text Pseudo-Elements
> CSS pseudo-elements enable you to select:
> * The first letter of a text element    `p::first-letter`
> * The first line of a text element      `p::first-line`
> * The space before or after a text element `p::before` `p::after` 
> * Text selected by the user             `::selection`

### Link and Form Pseudo-Classes
CSS defines two sets of contextual pseudo-classes:
> * Link classes
> ``` css
>     a:link
>     a:visited
>     a:focus
>     a:hover
>     a:active
> ```
> * Form classes
> ```css
>     input:enabled
>     input:diabled
>     input:checked
> ```

### DOM-Related Pseudo-Classes
> Use positional pseudo-classes to select a single element from a set based on:
> * Position
> ```css
>     p:first-child
>     p:nth-child(2)
> ```
> * Position and type
> ```css
>     p:last-of-type
>     p:nth-last-of-type(4)
> ```
> * Document structure
> ```css
>     :empty
>     :root
>     :not(p,h1)
>     :target
> ```

---
## Lesson 4:	Enhancing Graphical Effects by Using CSS3
### Lesson objectives
After completing this lesson, you will be able to:
- Explain how to use the new CSS3 color value sets.
- Use CSS3 to provide gradients and multi-image backgrounds.
- Combine CSS3 properties to create shapes, and use simple transforms to manipulate elements on the page.

### Specifying Color Values
> CSS3 defines several differencet sets of color values:
> * Keywords
> ```css
>     color: red;
>     color: transparent;
>     color: currentColor;
> ```
> * RGB \ RGBA model values
> ```css
>     color: #ff0000;
>     color: rgb(255,0,0);
>     color: rgba(100%,0,0,0.5);
> ```
> * HSL \ HSLA model values
> ```css
>     color: hsl(240, 100%, 50%);
>     color:hsl(120, 100%, 50%, 0.5);
> ```

Additional Reading: For a complete list of valid color names and a more in-depth description of the HSL model, 
read the current CSS3 Color Module Specification at http://go.microsoft.com/fwlink/?LinkID=267728.

### Defining Backgrounds and Effects
> CSS3 supports:
> * Multi-image background
> ```css
> article {
>       background-image: url('bluearrow.png'), url('greenarrow.png');
>       background-repeat: repeat-x, repeat-y;
> }
> ```
> * Gradients
> ``` css
>     background: linear-gradient(direction, start-color, [mid-color-list,] end-color);
>     background: radial-gradient(top right, ellipse, red, blue); 
>  ```

### Implementing Transformations and Graphics
> Using CSS3, you can:
> * Transform, rotate, and skew elements
> ``` css
> article {
>     transform: rotate(30deg);
> }
> ```
> * Generate shapes
> ``` css
> #circle {
>     width"200px;
>     height: 200px;
>     background: blue;
>     border-radius: 50%;
> }
> ```

Additional Reading: For an in-depth discussion of 3D transforms in IE10,
see http://go.microsoft.com/fwlink/?LinkID=267729.

### Demonstration: Styling Text and Block Elements by Using CSS3
#### Demonstration steps
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD06_DEMO.md.


---
## Lab:	Styling Text and Block Elements by Using CSS3
### Objectives
After completing this lab, you will be able to:
- Implement advanced styling for text elements by using CSS
- Style block elements by using CSS.
- Create graphical elements by using CSS.

##### Lab setup
Estimated Time: 60 minutes

You will find the high-level steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD06_LAB_MANUAL.md.

You will find the detailed steps on the following page: https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD06_LAK.md.

### Exercise 1: Styling the Navigation Bar
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod06/Labfiles/Solution/Exercise%201/ContosoConf/index.htm
#### index.html
```html
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

    </body>
</html>
```
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod06/Labfiles/Solution/Exercise%201/ContosoConf/styles/nav.css
#### nav.css
```css
/* Styles for the page navigation bar */

/* TODO: nav.page-nav */
nav.page-nav {
    background-color: #1d1d1d;
    line-height: 6rem;
    font-size: 1.7rem;
}

/* TODO: nav.page-nav .container */
nav.page-nav .container {
    display: -ms-flexbox;
    display: flex;
}

/* TODO: nav.page-nav a */
nav.page-nav a {
    display: block;
    min-width: 9rem;
    padding: 0 1.8rem;
    border-right: 1px dotted #3d3d3d;
    text-decoration: none;
    text-transform: uppercase;
    color: #c3c3c3;
    text-shadow: 0 1px 0 #000;
}
    

/* TODO: nav.page-nav a:first-child */
nav.page-nav a:first-child {
    border-left: 1px dotted #3d3d3d;
}

/* TODO: nav.page-nav a:hover */
nav.page-nav a:hover {
    color: #e4e4e4;
    background-color: black;
}

/* TODO: nav.page-nav .active */
nav.page-nav .active {
    color: #fff;
    background: -ms-linear-gradient(#c95656, #8d0606);
    background: linear-gradient(#c95656, #8d0606);
}

/* TODO: nav.page-nav .active:hover */
nav.page-nav .active:hover {
  /* Override hover effect for active page link */
  color: #fff;
}

/* TODO: nav.page-nav .active:before */
nav.page-nav .active:before {
    position: absolute;
    top: 6rem;
    display: block;
    height: 0;
    width: 0;
    margin-left: -1.9rem;
    border-top: 2rem solid #8d0606;
    border-right: 6.5rem solid transparent;
    content: "";
}

/* TODO: nav.page-nav .active:after */
nav.page-nav .active:after {
    position: absolute;
    display: block;
    height: 0;
    width: 0;
    margin-left: 4.3rem;
    border-top: 2rem solid #8d0606;
    border-left: 6.5rem solid transparent;
    content: "";
}
```

### Exercise 2: Styling the Register Link

#### index.html
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod06/Labfiles/Solution/Exercise%202/ContosoConf/index.htm
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

    </body>
</html>
```
#### header.css
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod06/Labfiles/Solution/Exercise%202/ContosoConf/styles/header.css
``` css
/* Styles for the page header */

header.page-header {
    height: 20rem;
    border-bottom: 4px solid #1d1d1d;
}

header.page-header .container {
    padding: 1rem;
    position: relative;
}

header.page-header h1 {
    margin: 0;
    font-size: 6rem;
    padding-top: 3rem;
}

header.page-header p {
    font-size: 2rem;
    font-style: italic;
}

/* TODO: header.page-header .register */
header.page-header .register {
    display: block;
    position: absolute;
    top: 2rem;
    right: 3.5rem;
    width: 16rem;
    height: 10rem;
    padding-top: 6rem;
    font-size: 2.7rem;
    text-align: center;
    text-decoration: none;
    text-transform: uppercase;
    text-shadow: 0 1px 0 #000;
    color: #fff;
    background: -ms-linear-gradient(#a80000, #740404);
    background: linear-gradient(#a80000, #740404);
    -ms-border-radius: 100%;
    border-radius: 100%;
    -ms-transform: rotate(6deg);
    transform: rotate(6deg);
}

/* TODO: header.page-header .register:hover */
header.page-header .register:hover {
    background: -ms-linear-gradient(#bc0101, #8c0909);
    background: linear-gradient(#bc0101, #8c0909);
}

/* TODO: header.page-header .register:before */
header.page-header .register:before {
    display: block;
    position: absolute;
    top: -.7rem;
    right: -.7rem;
    height: 16.8rem;
    width: 16.8rem;
    content: "";
    border: 3px dotted #740404;
    -ms-border-radius: 100%;
    border-radius: 100%;
}

header.page-header .register .free {
    font-size: 80%;
}
```


### Exercise 3: Styling the About Page
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod06/Labfiles/Solution/Exercise%203/ContosoConf/about.htm
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
    </head>
    <body>
        
        <nav class="page-nav">
            <div class="container">
                <a href="/index.htm">Home</a>
                <a href="/about.htm" class="active">About</a>
                <a href="/schedule.htm">Schedule</a>
                <a href="/register.htm">Register</a>
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
        
    </body>
</html>
```

#### about.css
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod06/Labfiles/Solution/Exercise%203/ContosoConf/styles/pages/about.css
``` css
/* Styles for the about page */

/* TODO: .about > article > section */
.about > article > section {
    column-count: 3;
    column-gap: 5rem;
    text-align: justify;
}

/* TODO: Add drop cap styling */
.about p:first-child:first-letter {
    font-size: 300%;
    float: left;
    margin: 0 0 5rem 0 0;
    line-height: .8;
    color: #aaa;
}

/* TODO: Indent paragraphs */
.about p {
    text-indent: 3rem;
}

.about p:first-child {
    /* Prevents text indenting after drop cap */
    text-indent: 0;
    margin-top: 0;
}

/* TODO: Blockquote */
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

---
