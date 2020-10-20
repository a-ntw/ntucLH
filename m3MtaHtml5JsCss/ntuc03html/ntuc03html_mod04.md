Module 4: Creating Forms to Collect and Validate User Input
===
Contents:
- Lesson 1:	Creating HTML5 Forms
- Lesson 2:	Validating User Input by Using HTML5 Attributes
- Lesson 3:	Validating User Input by Using JavaScript
- Lab:	Creating a Form and Validating User Input
- Exercise 1: Creating a Form and Validating User Input by Using HTML5 Attributes
- Exercise 2: Validating User Input by Using JavaScript
- Module review and takeaways

## Module overview
### Objectives
After completing this module, you will be able to:
- Create input forms by using HTML5.
- Use HTML5 form attributes to validate data.
- Write JavaScript code to perform validation tasks that cannot easily be implemented by using HTML5 attributes.

---
## Lesson 1:	Creating HTML5 Forms
### Lesson objectives
After completing this lesson, you will be able to:
- Use the HTML5 <form> element and specify its common attributes.
- Explain how to use the new HTML5 input types.
- Describe the attributes available with the new HTML5 input types to improve the user's experience.

### Declaring a Form in HTML5
> Use an HTML5 form to gather user input:
> ``` html
> <form name = "userLogin" method= "post" action= "login.aspx">
>     <fieldset>
>         <legend>Enter your log in details:</legend>
>         <div id= "usernameField" class= "field">
>             <input id= "uname" name= "username" type= "text"
>                 placeholder= "First and Last Name" />
>             <label for= "uname">User's Name:</label>
>         </div>
>         <div id= "passwordField" class= "field">
>             <input id= "pwd" name= "password" type= "password"
>                 placeholder= "Password" />
>             <label for= "pwd">User's Password:</label>
>         </div>
>     </fieldset>
>     <input type= "submit" value= "Send" />
> </form>
> ```
The **<form>** element has the following attributes:
- The **name** of the form. This attribute is used by the server to reference the fields on the form during processing.
- The **action** performed when the user submits the form to the server. This is a URL to which the form will be sent. If you omit the URL, the form is sent to the current URL of the web page.
- The **method** to be used to send the data. When submitting data to the server by using a form, this attribute should normally be set to **post**.
...

Within the **\<div>** element, you add an **\<input>** element to collect the data. An input element should contain the following attributes:
- An **id** and **name** attribute. The **id** attribute is typically used by CSS to style the field and JavaScript code that control the field in the browser; the **name** attribute is used by the server to reference fields on the form when it is submitted.
- A **type** attribute. This attribute specifies the type of the input. The browser uses the **type** attribute to create a visual control suitable for the data-type required. This is covered in greater detail in the next topic.
- A **placeholder** attribute. The placeholder appears on the control as a prompt to help the user know what to type.

### HTML5 Input Types and Elements
HTML5 defines a wide range of new input types and elements, but not all are widely implemented
```html
<select id= "carManufacturer" name= "carManufacturer">
    <optgroup label= "European">
        <option value= "volvo">Volvo</option>
        <option value= "audi">Audi</option>
    </optgroup>
    <optgroup label= "American">
        <option value= "chrysler">Chrysler</option>
        <option value= "ford">Ford</option>
    </optgroup>>
</select>
```
HTML5 provides you with a wide range of input types for forms.

The most generic of all the input types is **text**. 
Specifying <input type="text" /> produces a text box in which the user enters data. 
However, HTML5 provides a range of other types that you can use with the **\<input>** element 
to better define the kind of data that is expected, providing for better client-side validation and formatting.

To change the type of data you wish to collect, specify the **type** attribute of the **\<input>** element, 
providing one of the following values: **button, checkbox, color, date, datetime, datetime-local, email, file, 
hidden, image, month, number, password, radio, range, reset, search, submit, tel, text, time, url**, or **week**. 
Note that not all these types are not yet fully adopted or even implemented by most browsers. 
They are designed to fail back to harmless text fields where they are not implemented.

You can use **\<datalist>** element with text input to provide autocomplete options. 
Note that you do not need to specify the input type, 
you simply indicate that the input is a list and provide the possible options by using the **datalist** element

The **\<textarea>** element is similar to **\<input>** in that it accepts typed input, 
but the control is rendered as a multi-line area using a fixed-width font. 
The attributes **cols** and **rows** control how wide it is and how may rows it has. 
You can set its **maxlength** attribute to set the maximum number of characters it will accept.

The **\<select>** element is a container for a number of fixed **\<option>** elements, 
which predefine inputs the user is allowed to give. This saves the user from typing common data, 
where the options are well understood and can be defined at design time. 
To group options into smaller logical lists, you use the **\<optgroup>** element. 
This will help the user make sense of a longer list. 

### HTML5 Input Attributes
> Input attributes modify the behaviour of input types and forms to provide better feedback and usability:
> * autofocus
> * autocomplete
> * required
> * pattern
> * placeholder
> * manu other input type=specific attributes

... Some attributes are independent of the input type. For example, 
a common requirement is to place the cursor in the first field of the form when the page loads. 
You can achieve this by setting the new **autofocus** attribute on the control. ...

In the following example, the email address field receives the focus when the form loads, and the email address is completed automatically if the user has typed it in before.
``` html
<form id="loginForm" action="login.aspx" method="post" autocomplete="on">
  Email: <input name="email" type="email" placeholder="Email address" autofocus="autofocus"/>
  Password: <input name="password" type="password" autocomplete="off" />
  <input type="submit" />
</form>
```
The **required** attribute indicates that a field is mandatory and that the form should not be submitted if it is left blank.

The **pattern** attribute enables you to apply a regular expression to a text input field to ensure that it conforms to a specific pattern.

The **placeholder** attribute puts temporary content in a text field to prompt the user to enter data.

---
## Lesson 2:	Validating User Input by Using HTML5 Attributes
### Lesson objectives
After completing this lesson, you will be able to:
- Explain the principles of client-side forms validation.
- Add forms validation to ensure that mandatory fields are not left empty.
- Validate numeric input.
- Validate text input.
- Style fields to highlight input requirements.

### Principles of Validation
> * User input can vary in accuracy, quality, and intent
> * Client-side validation improves the user experience
> * Server-side validation is still necessary

Validation is the process of checking the data for obvious errors, so that 
when it is eventually handled at the server, there are as few errors as possible.

Validation occurs in two places:
- On the client. When the user completes the form, some data can be validated by HTML markup and 
JavaScript code running in the browser.
- On the server. When the form is submitted, the back-end process must verify that 
the data is correct before processing it.

### Ensuring that Fields are Not Empty
> User the **required** attribute to indicate mandatory fields
> * The browser checks that they are filled in before submitting the form
> ```html
>     <input id= "contactNo" name= "contactNo" type= "tel"
>     placeholder= "Enter your mobile number" required= "required" />
> ```

The **required** attribute works with the input types **text, search, url, tel, email, password, number, checkbox, 
radio, and file**, and with the input types that pick dates where they are implemented.

### Validating Numeric Input
> Use the **min** and **max** attributes to specify the upper and lower limit for numeric data
> ```html
>     <input id= "percentage" type= "number" min= "0" max "100" />
> ```

### Validating Text Input
> Use the **pattern** attribute to validate text-based input by using a regular expression
> ```html
>     <input id= "orderRef" name= "orderReference" type= "text"
>      pattern= "[0-9]{2}[A-Z]{3}" title= "2 digits and 3 uppercase letters" />
> ```

The **pattern** attribute can be used with the input types **text, search, url, tel, email, and password**.

### Styling Fields to Provide Feedback
> Use CSS to style input fields
> * Use the **valid** and **invalid** pseudo-classes to detect fields that have passed or failed validation
> ``` css
>     input {
>         border: solid 1px;
>     }
>     input: invalid {
>         border-color: #f00;
>     }
>     input: valid {
>         border-color: #0f0;
>     }
> ```

One way to do this is by marking each required field with a text asterisk in the form design. 
In this example, the asterisk is styled red by using inline CSS:
```html
    <form id="registerForm" method="post" action="registration.aspx">
      <div id="firstNameField" class="field">
        <label for="firstName">First name:</label>
        <input id="firstName" name="firstName" required="required" placeholder="Your first name" />
        <span style="color:red">*</span>
      </div>
    ...
    </form>
```

---
## Lesson 3:	Validating User Input by Using JavaScript
### Lesson objectives
After completing this lesson, you will be able to:
- Describe how to use the **onSubmit** event of a form to perform validation and 
    override the default validation messages implemented by the browser.
- Perform complex data validation by using regular expressions.
- Perform additional checks to verify that mandatory fields are not empty.
- Provide dynamic feedback on validation errors.

### Handling Input Events
> * Catch the **submit** event to validate an entire form
>     * Return true if the data is valid, false otherwise
>     * The form is only submitted if the **submit** event handler returns true
> * Catch the **input** event to validate individual fields on a character-by-character basis
>     * If the data is not valid, display an error message by using the **setCustomValidity** function
>     * If the data is valid, reset the error message to an empty string

The following code example shows a form that runs the **validateForm** method when the user submits the data. 
The **onsubmit** attribute of the form specifies the JavaScript code to run when the **submit** event occurs:
``` html
    <form id="registrationForm" method="post" action="registration.aspx"  onsubmit="return validateForm();" >
        ...
      <input type="submit" />
    </form>
```

### Validating Input
> Use JavaScript code to emulate unsupported HTML5 input types and attributes in a browser:
> ``` html
>     <form id= "scoreForm" onsubmit="return validateForm();" >
>         <div id= "scoreField" class= "field" >
>             <input id= "score" name= "score" type= "number"/>
>         </div>
>     </form>
> ```
> ```js
>     function isAnInteger( text ){
>         const intTestRegex = /ˆ\s*(\+|-)?\d+\s*$/;
>         return String(text).search(intTestRegex) != -1;
>     }
>     function validateForm()
>     {
>         if ( ! isAnInteger(document.getElementById('score').value))
>             return false; /* No, it's not a number! Form validate fails */
>         return true;
>     }
> ```

### Ensuring that Fields are Not Empty
> Use JavaScript code to ensure that a required field does not contain only whitespace
> ```html
>     <form id="scoreForm" ...  onsubmit="return validateForm();" >
>       <div id="penaltiesField" class="field" >
>         <input id="penalties" name="penalties" type="text" />
>       </div>
>     </form>
> ```
> ```js
>     function isSignificant( text ){
>       const notWhitespaceTestRegex = /[^\s]{1,}/;
>       return String(text).search(notWhitespaceTestRegex) != -1;
>     }
> 
>     function validateForm() {
>       if( ! isSignificant(document.getElementById('penalties').value))
>         return false;   /* No! Form validation fails */
> 
>       return true;
>     }
> ```

### Providing Feedback to the User
> Provide visual feedback to the user by defining styles and dynamically setting the class if an element:
> ```css
>     .validatedFine {
>       border-color: #0f0; 
>     }
>     .validationError {
>       border-color: #f00;
>     }
> ```
> ``` js
>     function validateForm() {
>       const textbox = document.getElementById("penalties");
> 
>       if( ! isSignificant(textBox.value)) {
>         textbox.className = "validationError";
>         return false;   /* No! Form validation fails */
>       }
>       textbox.className = "validatedFine";
>       return true;
>     }
> ```

### Demonstration: Creating a Form and Validating User Input
#### Demonstration steps
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD04_DEMO.md.


---
## Lab:	Creating a Form and Validating User Input
### Objectives
After completing this lab, you will be able to:
- Create a form by using HTML5 input elements and validate form data by using HTML5 attributes.
- Implement extended data validation by using JavaScript.

##### Lab setup
Estimated Time: 60 minutes

You will find the high-level steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD04_LAB_MANUAL.md.

You will find the detailed steps on the following page: 
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Instructions/20480C_MOD04_LAK.md.

### Exercise 1: Creating a Form and Validating User Input by Using HTML5 Attributes
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod04/Labfiles/Solution/Exercise%201/ContosoConf/register.htm
#### register.html
```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>Register for ContosoConf</title>
        
        <link href="/styles/site.css" rel="stylesheet" type="text/css" />
        <link href="/styles/pages/register.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <nav class="page-nav">
            <div class="container">
                <a href="/index.htm">Home</a>
                <a href="/about.htm">About</a>
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
        
        <section class="page-section register">
            <div class="container">
                <h1>Register for the conference</h1>
                <form method="post" action="/registration/new" id="registration-form">
                    <!--
                        TODO: Add form inputs

                        FirstName - required string
                        LastName - required string
                        EmailAddress - required email address
                        Password - required password string, at least 5 letters and numbers
                        ConfirmPassword
                        WebsiteUrl - optional url string
                    -->
                        
                    <div class="field">
                        <label for="first-name">First name:</label>
                        <input type="text" id="first-name" name="FirstName" required="required" autofocus="autofocus" />
                    </div>
                    <div class="field">
                        <label for="last-name">Last name:</label>
                        <input type="text" id="last-name" name="LastName" required="required" />
                    </div>
                    <div class="field">
                        <label for="email-address">Email address:</label>
                        <input type="email" id="email-address" name="EmailAddress" required="required" />
                    </div>
                    <div class="field">
                        <label for="password">Choose a password:</label>
                        <input type="password" id="password" name="Password" required="required" pattern="[a-zA-Z0-9]{5,}" title="At least 5 letters and numbers" />
                    </div>
                    <div class="field">
                        <label for="confirm-password">Confirm your password:</label>
                        <input type="password" id="confirm-password" name="ConfirmPassword" required="required" />
                    </div>
                    <div class="field">
                        <label for="website">Website/blog:</label>
                        <input type="url" id="website" name="WebsiteUrl" placeholder="http://" />
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
        
        <script src="/scripts/pages/register.js" type="text/javascript"></script>
    </body>
</html>
```


### Exercise 2: Validating User Input by Using JavaScript
https://github.com/MicrosoftLearning/20480-Programming-in-HTML5-with-JavaScript-and-CSS3/blob/master/Allfiles/Mod04/Labfiles/Solution/Exercise%202/ContosoConf/scripts/pages/register.js

#### register.js
```jsx
// Get the registration <form> element from the DOM.
const form = document.getElementById("registration-form");
const submitButton = form.querySelector("button");
    
// TODO: Task 1 - Get the password <input> elements from the DOM by ID
const passwordInput = document.getElementById("password");
const confirmPasswordInput = document.getElementById("confirm-password");

const checkPasswords = function () {
    // TODO: Task 2 - Compare passwordInput value to confirmPasswordInput value
    const passwordsMatch = passwordInput.value === confirmPasswordInput.value;

    // TODO: Task 3 - If passwords don't match then display error message on confirmPasswordInput (using setCustomValidity)
    //                If passwords do match then clear the error message (setCustomValidity with empty string)
    if (passwordsMatch) {
        // Clear any previous error message.
        confirmPasswordInput.setCustomValidity("");
    } else {
        // Setting this error will prevent the from from being submitted.
        confirmPasswordInput.setCustomValidity("Your passwords don't match. Please type the same password again.");
    }
};

const addPasswordInputEventListeners = function () {
    // TODO: Task 4 - Listen for the "input" event on passwordInput and confirmPasswordInput.
    //       Call the checkPasswords function
    passwordInput.addEventListener("input", checkPasswords, false);
    confirmPasswordInput.addEventListener("input", checkPasswords, false);
};

const formSubmissionAttempted = function() {
    form.classList.add("submission-attempted");
};

const addSubmitClickEventListener = function() {
    submitButton.addEventListener("click", formSubmissionAttempted, false);
};

addPasswordInputEventListeners();
addSubmitClickEventListener();
// SIG // Begin signature block
// SIG // MIIaVgYJKoZIhvcNAQcCoIIaRzCCGkMCAQExCzAJBgUr

```


---
## Module review and takeaways
