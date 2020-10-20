Module 12: Animating the User Interface
===
Contents:
- Module overview
- Lesson 1:	Applying CSS Transitions
- Lesson 2:	Transforming Elements
- Lesson 3:	Applying CSS Keyframe Animations
- Lab:	Animating the User Interface
- Module review and takeaways

## Module overview
### Objectives
After completing this module, you will be able to:
- Apply transitions to animate property values to HTML elements.
- Apply 2D and 3D transformations to HTML elements.
- Apply keyframe animations to HTML elements.

## Lesson 1: Applying CSS Transitions
### Lesson objectives
After completing this lesson, you will be able to:
- Apply simple transitions to element property values by using CSS.
- Configure transition information.
- Detect the end of a transition.

### Demonstration: Using CSS Transitions
#### Demonstration steps
You will find the steps in the “Demonstration: Using CSS Transitions“ section on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD12_DEMO.md.

## Lesson 2: Transforming Elements
### Lesson objectives
After completing this lesson, you will be able to:
- Describe how CSS implements transformations.
- Apply 2D transformations to elements by using CSS.
- Apply 3D transformations to elements by using CSS.
- Apply transitions to CSS transformations.

### Demonstration: Performing 3D Transformations
#### Demonstration steps
You will find the steps in the “Demonstration: Performing 3D Transformations“ section on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD12_DEMO.md.

## Lesson 3: Applying CSS Keyframe Animations
### Lesson objectives
After completing this lesson, you will be able to:
- Define keyframes for CSS animations.
- Configure keyframe animation properties.
- Start keyframe animations programmatically.
- Handle the events that occur during a keyframe animation.

### Demonstration: Implementing KeyFrame Animations
### Demonstration steps
You will find the steps in the “Demonstration: Implementing KeyFrame Animations“ section on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD12_DEMO.md.

### Demonstration: Animating the User Interface
#### Demonstration steps
You will find the steps in the “Demonstration: Animating the User Interface“ section on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD12_DEMO.md.

## Lab: Animating the User Interface
### Objectives
After completing this lab, you will be able to:
- Animate HTML elements by using CSS transitions.
- Animate HTML elements using CSS keyframes, and trigger animations and handle animation events by using JavaScript code.

#### Lab setup
Estimated Time: 60 minutes

You will find the high-level steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD12_LAB_MANUAL.md.

You will find the detailed steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD12_LAK.md.

### Exercise 1: Applying CSS Transitions
#### feedback.htm
``` html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
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
                        <input name="question" type="range" min="1" max="5" />
                    </div>
                    <div class="field feedback-question">
                        <label>How well could you hear the speaker?</label>
                        <input name="question" type="range" min="1" max="5" />
                    </div>
                    <div class="field feedback-question">
                        <label>How useful did you find the information in this talk?</label>
                        <input name="question" type="range" min="1" max="5" />
                    </div>
                    <div class="field feedback-question">
                        <label>How would you rate the overall session?</label>
                        <input name="question" type="range" min="1" max="5" />
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

    <script src="/scripts/pages/feedback.js" type="module"></script>
</body>

</html>
```

### Exercise 2: Applying Keyframe Animations
#### feedback.css
``` css
/* Styles for the feedback page */

#feedback-sent {
    display: none; /* Will be displayed using JavaScript, see feedback.js */
}

.feedback form {
    max-width: 60rem;    
}

.feedback .comments {
    margin: 1rem 0;
}

.feedback label {
    display: block;
}

.feedback textarea {
    display: block;
    padding: .5rem;
    width: 100%;
    box-sizing: border-box;
}

.feedback button {
    padding: .5rem;
}

.feedback-question {
    display: -ms-flexbox;
    display: flex;
    -ms-flex-align: center;
    flex-align: center;
    -ms-flex-pack: justify;
    flex-pack: justify;
    -ms-flex: 1;
    flex: 1;
    
    padding: .5rem 0;
}

.feedback-question:nth-child(even) {
    background-color: #f5f4ff;
}

.feedback-question label {
    display: block;
    padding-right: 1rem;
    -ms-flex: 1 0 auto;
    flex: 1 0 auto;
}

.star {
    background-image: url(../images/stars.png);
    width: 15px;
    height: 15px;
    cursor: pointer;
    margin: .1rem;
    -ms-flex: 0 0 15px;
    flex: 0 0 15px;
    
    /* TODO: Transition the transform property over 0.5 seconds */
    transition: transform .5s;
}

.star:hover,
.star.hover {
    background-position: 0 -15px;
    
    /* TODO: Scale transform by 1.3 */
    transform: scale(1.3, 1.3);
    
    /* TODO: Transition the transform property over 0.5 seconds */
    transition: transform .5s;
}

.star.selected {
    background-position: 0 -30px;
    
    /* TODO: Scale transform by 1.3 */
    transform: scale(1.3, 1.3);
}

/* TODO: Add key frame animation named "send"
         At 0% scale(1)
         At 50% scale(.8)
         At 100% translate(0, -1000px)
*/

.sending {
    background-color: #EAEEFA;
    border: 1px solid #888;
    -ms-box-shadow: 0px 3px 3px rgba(0,0,0,.8);
    box-shadow: 0px 3px 3px rgba(0,0,0,.8);

    /* TODO: Use the "send" animation
             iteration-count: 1
             fill-mode: forwards
    */
}
```
#### feedback.js
``` jsx
import { StarRatingView } from "../StarRatingView.js";

const section = document.getElementById("feedback");
const form = section.querySelector("form");
const sent = document.getElementById("feedback-sent");

function formSubmitting(event) {
    event.preventDefault();
    // TODO: Trigger the animation by adding the "sending" CSS class to the form
};

function animationEnded() {
    section.style.display = "none";
    sent.style.display = "block";
};

form.addEventListener("submit", formSubmitting, false);

// TODO: Add listener for the animationend event,
//       calling the animationEnded function.
const questions = form.querySelectorAll(".feedback-question");
for (let i = 0; i < questions.length; i++) {
    new StarRatingView(questions[i]);
}
// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr
```

## Module review and takeaways
In this module, you have learned how to create animated content by using CSS3 transitions, transformations, 
and keyframe animations.

CSS transitions enable you to define a time span for property changes. The browser interpolates the property 
from its initial value to its final value over the specified time span, to give the user the effect of a 
smooth transition from the original property value to the new property value.

CSS transformations enable you to translate, scale, rotate, or skew an element. CSS supports 2D transformations 
in the X and Y directions, and 3D transformations in the X, Y, and Z directions.

CSS keyframe animations enable you to specify a set of property values to apply to a target element at distinct 
steps in the animation. You express the steps as percentages of the elapsed time for the animation. You can 
start animations programmatically and handle events that occur as the animation progresses.

