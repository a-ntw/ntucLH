##  Introduction to Software Development Lifecycle (SDLC) and Software Testing

* Module 1 (Introduction to SDLC)
* Module 2 (Quality Processes and Objectives)
* Module 3 (Assessment methods)
* Module 4 (Testing steps and Approaches)
* Module 5 (Re-aligning and Auditing)
* Course Assessment (MCQ) – Set 1
 
### Module 1
### (Introduction to SDLC)
  Software Development Life Cycle
  
#### Waterfall approach
- Credit goes to Production system
- Well defined processes
- Well defined checklists
- Well defined scope
- Well defined tools
- One phase output will be an input to the next process
 
#### Applicability
- For simple systems
- Mission critical systems where phased exits are defined
- Enhancements
 
#### Requirements gathering
- Created in the form of a BRD (business requirements document)
- Business analyst will be involved in this.
- Communicate with the business and elicit requirements
 
#### Analysis
Software requirements specification will be created in the form of
* System Requirements Specification
* Functional Requirements Specifications Defines what is needed from the system?

#### Design
- Converts the requirements specification to a plan Problem solving phase
- Defines the plan for the solution

####  Development
- Execution stage of the project
- Creating the software product
- Involvement of the programming languages

####  Types of Requirements
- Business requirement
- User requirement 
- Functional requirement 
- Non-functional requirement

mynote: eg DBS Bank

####  Testing
- One of the most important phase in SDLC
- Very important in gaining customer’s confidence 
- Helps to check if everything is aligned?
- Helps to discover problems
- Be creative with test processes.

mynote: Testing 85%; use Cases; +ve cases.
Unit Testing, Thread, System, End-2End Integration, Load + Performance + Stress + breakdown.
UPstream, Downstream
 
####  RTM (Requirements Traceability Matrix)
- Document to ensure no requirements are missed
- One stop document for all testing needs
- Captures and traces all the requirements with the test cases
 
####  Types of RTM
- Forward: Mapping of requirements to test cases. Ensures that each requirement is implemented in the product and it is tested thoroughly
- Backward: Mapping of the test cases to requirements. Ensures that end product has met the requirements or not.
- Bidirectional: In order to analyze the impact of a change or assess the current status of the requirements.
- Fault-traceability: Traces each bug to the requirement and its relevant test case.

myNote: Requirements <=> Test cases >> Problems.
99% prefer fault traceability

####  Advantages of RTM
- Document to show an overview of all requirements
- Covers entire 100% of the requirements
- Links them to the test cases
 
####  Ways to prepare an RTM
- Collate all the requirements related documents
- List down all the features / requirements one by one
- Assign a number to the requirements
- Link the test cases to this
 
####  RTM Sample
- Business requirements (BRD):
  - BR104: User must be able to select the product and
enter the quantity (number of pieces) but not more
than 5 pieces
- Functional requirements (FRD):
  - FR57: Choose a product from the drop down
  - FR58: Choose a quantity greater than 0 and less than
or equal to 5
 
####  RTM Sample
- Test scenarios:
- TC01: User is not able to type the product name
- TC02: User is able to choose the value from drop down
- TC03: User is not able to enter a negative value for
quantity
- TC03: User is not able to enter a value more than 5 for
quantity
- etc

myNote: both are mandatory

####  RTM Sample
Requirements Traceability Matrix
Project Name: Online e-commerce
Business Requirements Functional requirements Test cases
| BRD ID | | FRD ID | | Priority |Test Case ID |
| --- |--- | --- | --- | --- |--- |
|BR96 |  Product booking |  FR57 |  Choosing the product |  High |  #TC01 |
| |  | FR58 |  Entering the quantity | High | #TC02 #TC03 #TC04 |
 
####   Group Activity
- Think of the scenario from the previous page and
- List down the Business Requirements
- List down the Functional Requirements
- List down the Test cases
- Create an RTM for the login screen
 
####  Testing
- Helps to ensure the product is of high quality
- Helps the team to stay focused and motivated
- Helps to produce more accurate and reliable results
- Helps to reduce the maintenance cost
- Helps to reduce or eliminate rework
 
####  Common quality issues
- Functional errors
- Nonfunctional errors
- Syntactical errors
- Data mismatch errors

----
### Module 2 
### (Quality Processes and Objectives)

#### V - model
   < Acceptance Test Design >    
< System Test Design > 
< Integration Test Design > 
< Unit Test Design >

####  Advantages of the V-model
• Heavily compliant restricted business.
• Projects with strict time lines
#### Disadvantages of the V-model
Adaptability lacks
“Design by committee” Development approach 
Restrictions on timeline
High risk and uncertainty
 
####  SDLC and V-model
####  Quality Objectives
• Create a sense of urgency
• Get management buy-in
• Be consistent with the overall mission
• But be flexible with the objectives
• Start small and simple
• Expand slowly
 
####  Beginning the Testing Process
• Review the plan
• Plan is the intent
• Check for accuracy
• Anticipate changes
• Never make assumptions
• Evaluate the tools
 
####  Process definition
• Plan the tests
• Version controls
• Asthisisareferencepointalways • Helpsinmeetingthetestinggoals
• Audit controls
 
####  Process definition
• Tasks and tools to execute the tests
• Repeated tasks to ensure quality
• Errorcontrolmechanismshouldbeinplace
• EnablesBughunting
• BecognitiveaboutWhatis“broken”?AndWhatis“fixed”? • Documenttheobservations.
• Automationwillhelpextensively
 
####  Process definition
• Define the test cycles • Ad-hocevaluation
• Plannedcycles
• Brokendownbasedon
• Individual member
• Feature
• Functionality
• Definewhenthetestingmustbeperformed.
• Fixing a bug
• Adding a new feature
• After refactoring
 
####  Process definition
• Define the test cycles (Cont...)
• Developersandtesters–decideonthecycle • Singlesprint
• Wholetestcycle
But treat it as a milestone
 
####  Software Quality Assurance
• Creating an SQA management plan
• Set regular check points
• Applying software engineering techniques
• Executing formal technical reviews
• Having a multi testing strategy
• Enforce process adherence
• Change impact measurement
• Perform audits
 
####  SQA - Elements
• Define the standards for Software engineering
• Perform the technical reviews and audits
• Control quality via software testing
• Error collection and analysis
• Change management
• Vendor management
• Security management
• Safety
• Risk management
 
####  Test Maturity Model integration (TMMi)
####  TMMi – Level 2
• May vary from project to project.
• Test policy and strategy
• Test planning
• Test monitoring and controlling
• Test design and execution
• Test environment are in place
 
####  TMMi – Level 3
• All projects must follow the same standard
• Test organization
• Test training program
• Test lifecycle and integration
• Non functional testing
• Peer review
 
####  TMMi – Level 4
• Measurement of activities are thoroughly applied early in all projects
• Advanced reviews are in use
• Test measurement
• Product quality evaluation
• Advanced reviews
 
####  TMMi – Level 5
• Optimization activities are in place
• Continuous improvement is implemented
• Defect prevention
• Test quality optimization
• Quality control
 
####  Choosing the right technique
• Internal factors
• Development models
• Lifecycle model
• Testers knowledge
• Testers experience
• Level of documentation needed
• Test objectives
 
####  Choosing the right technique
• External factors
• Risk assessment
• Type of system used
• Regulatory requirements
• Customer requirements
• Contractual requirements
• Schedule of the project
• Budget of the project
 
####  Group Activity
• Evaluate and create a quality process that is workable in a banking environment

----
### Module 3
### (Assessment methods)
 
####  Unit Testing
- Performed at the component level
- Check on the sanity of the component
- Done by the programmer

myNote: unit testing tool, JUnit.
Component, Module, SubRoutine, Piece of Func.

####  Integration Testing
- Client and server integration
- Tests are performed to check the combined functionality

####  System Testing
- Combined parts are tested
- Entire system is tested

myNote: End-2-End Testinfg

####  Acceptance Testing
- Usually performed by the users
- Verifies the end to end flow of the system
- Client acceptance and signoff happens

myNote: UAT, User Acceptance Testingt. Intended Audience

####  Regression Testing
- Already executed test cases – re-execution
- To ensure existing features are still in order – after a code change
- Can be functional and non-functional

myNote: 11.major.minor.minu

#### Regression Testing and tracking
- Treat the fixes in a healthy manner
- Evaluate if the bugs are ignored, fixed or closed 
- Use a tool to perform the regression testing

myNote: Bug is reported - Track

####  Test Driven Development
- Testing with a specific flow
- Red test cases are written: to ensure the test is failing
- Green test cases are written: to ensure the test is passing
- Blue test cases are created: to ensure refactoring is incorporated
- This is usually done at the Unit test level
- Doesn’t need a particular format

myNote: Application - FLOW

####  Test Driven Development
- One of the software development process
- **Requirements are translated into test cases**
- Software improved until the test scripts are passed.
- Incorporates the feedback loop

myNote: Approval from Goverment

####  Test Driven Development
- Goal
  - Developers bias is reduced towards the quality of their
code
  - “Is my code working correctly?” is answered with confidence

myNote: Code Review - Peer Review

####  Acceptance Test Driven Development
- An extension of TDD
- Written at the acceptance test level
- Defined at the system behavior level
- Ensures the system has an intended behavior
- Doesn’t require to be in a particular format

myNote: Software - Sign Off

####  Acceptance Test Driven Development
- Goal
  - Requirements focused
  - “What should the system do in order to be useful?” is answered.
 
####  Behavior Driven Development
- Follows a particular format
- Readable by both technical and non-technical stakeholders
- Written in a domain specific language
- Can be combined with TDD or ATDD
- Can be written for a widely accessible tests
 
####  Difference between TDD and BDD
- TDD defines when something works and when it doesn’t work
- BDD describes how and why with examples
 
####  Context driven testing
- Brian Marick
  - The value of any practice depends on its context.
  - There are good practices in context, but there are no best practices.
  - People, working together, are the most important part of any project’s context.
  - Projects unfold overtime in ways that are often not predictable.
  - The product is a solution. If the problem isn’t solved, the product doesn’t work.
  - Good software testing is a challenging, intellectual process.
  - Only through judgment and skill, exercised cooperatively throughout the entire project, are we able to do the right things at the right times to effectively test our products.
 
####  Exploratory testing
> - Exploratory Testing is a style of software testing that emphasizes the personal freedom and responsibility of the individual tester to continually optimize the value of her work by treating test-related learning, test design, test execution, and test result interpretation as mutually supportive activities that run in parallel throughout the project.

Dr. Cem Kaner, co-author of Testing Computer Software
 
####  Exploratory testing
> - Ad hoc testing (AKA exploratory testing) relies on tester intuition. It is unscripted, unrehearsed, and improvisational. How do I, as test manager, understand what’s happening, so I can direct the work and explain it to my clients?
- Jonathan Bach began a presentation at STARWest in 2000 
began with this question

myNote: rare - not so freq approach

####  Scenario-based testing
> “Tests are complex stories that capture how the program will be used in real-life situations.”   
Kaner

####  Definition of Done
- It is a company level definition.
- Defines what “Done” means for the product and the company
- Should include a checklist
- It should mirror shippable
- It should not have any more work.

myNote: Ready to launch. Version is done.

####  Group Activity
- Create a list of advantages and disadvantages in each testing method.

---
### Module 4
### (Testing steps and Approaches)
 
#### Results - Testing
- Two outputs
  - Bugs
  - Successful code
####  Bug handling
- Document the results
- Let the data do the speaking
- Don’t judge the bug
- Help the developer to replicate the bug in their system
 
####  Document the results
- Logs
- Screen shots
- Review the results with developers
- Use simple languages
 
####  Let the data do the speaking
- Identify patterns
- Provide the support to replicate the bug
- Clearly define the steps to replicate the bug
 
####  Don’t judge the bug
- Avoid words like
  - Its “ugly” 
  - Its “silly
  - Its “huge” 
  - Etc
- Some times it could be the environment issues
 
#### Help the developer to replicate the bug
- Provide all support to the developer
- Give them the tool to replicate the bug 
- Walk through the steps with the developers
 
####  Understand the psychology
- Expect resistance
- Opinions can be argued upon, but not with facts
- Don’t make assumptions.
 
####  Review and Report
- Don’t put developers in a defensive position
- Approach objectively that you are monitoring the progress
- Take ownership
 
####  Test Summary Report
- It is a summary of the test report
- At the end of the test completion this report is created
- This helps to evaluate the testing effort against the test plan
 
####  Test Summary Report
Section 1: Introduction
- Project Description:
  - Takenfromtheprojectdocuments.
- Objectives
  - Takenfromtheprojectdocuments 
  - ModulebasedKPI’scanbeincluded
 
####  Test Summary Report
Section 2: Test Scope
- In scope
  - Scope of the test document.
  - Eg. Able to select the product from the drop down.
  - Eg. Able to key in the quantity in the text box.
- Out of scope
  - What is not covered in the test case.
  - Eg. Inventory display
- Additional functions, features that were tested
  - Any linked features that were tested
  - Eg. Able to type in first 2 or 3 characters and get the product displayed.
 
####  Test Summary Report
Section 3: Test Results
- Test Execution Details
  - Attach screen shot
  - Attach reports
  - Attach artefacts
- Any variance to original test plans
  - Gaps in the expectation
 
####  Test Summary Report
Section 4: Quality of software • Test coverage and results
• Random or 100% coverage
• Defect metrics – Defect types and status
• High or medium or low
• Closed or deferred or pending
• Outstanding issues
• If pending, then give reasons (Technical limitation etc)
• Exit criteria
• When can we close the bug
 
####  Test Summary Report
Section 5: Knowledge Management
• Causal analysis and resolution
• Fish bone analysis
• Fault tree analysis
• Lessons learned
• What went wrong?
• What went right?
• What can be done better next time?
• What can be reused?
• Best practice adopted and new improvements implemented
 
####  Test Summary Report
Section 5: Document control • Revision History
• Updatesonthehistory
 
####  Group Activity
• Create a sample Test Summary Report.

---
### Module 5
### (Re-aligning and Auditing)
 
####  Bug tracking
• Important task of documenting the bugs
• Tracking will be easy after documenting
• Can be paper based or tool based
 
####  Bug tracking tool
• Familiarization of the tracking tool
• Configure in such a way that the reports are easy to read
• Alerts when the bugs are fixed or closed
• Helps to keep an eye on the progress of the submission
• Transparent
 
####  Bug tracking
• Documenting the bugs
• Maintaining the logs
• Monitor the progress of the bug after submission
 
####  Quality Assurance Activities
• What steps will you take to ensure that Quality is built into the product?
• How will you ensure that adequate testing is done? How do you define “adequate”?
• Will the test team work from a Test Plan? Do they understand their responsibilities?
• How will you ensure that Requirements are correct, complete and accurately reflect the needs of the Customer?
• How will you verify that Specifications are an accurate representation of the Requirements?
• Describe how Requirement – Specification – Test Plan traceability is managed (or provide Link_To_ Requirements_Traceability_Matrix ):
• What steps will you take to ensure that the project plan (e.g. Risk Management Plan, Change Management Plan, Procurement Plan) is followed?
• What steps will you take to ensure that the Vendor is supplying deliverables of adequate quality?
 
####  Project Monitoring and Control
• What audits and reviews are required and when they will be held?
• How will you report and resolve variances from acceptance criteria?
• What will you measure to determine if the project is out of Scope?
• What will you measure to determine if the project is within budget?
• What will you measure to determine if the project is within schedule?
 
####  Defect Matrix
Defect in phase
Hot
High
Mediu m
Low
Lowest
Total
Cycle 1
2
2
3
1
8
Cycle 2
1
2
1
0
0
4
Totals
1
4
3
3
1
12
 
####  Closed issues
• Developer unable to reproduce
• Fixed the bug by the developer
• No longer relevant to the feature
• Future release will address this issue
 
####  Audit Template

---
### Course Assessment
(MCQ) – Set 1

1. What is true about test management
a) It will complete on time
b) It will start on schedule
c) You will get great results
d) Its unpredictable

2. Who can benefit from learning about test management?
a) Only test engineers
b) Only test managers
c) Anyone wanting to understand the test results
d) Only developers

3. Why do we review the test plan prior to starting test?
a) Input updates to the budget and schedule
b) Verify that the current features match the plan
c) All of the answers
d) Verify that the plan has the right resources documented

4. Which best describes why team alignment is important?
a) Communication helps reduce anxiety and create trust among
your partners and team
b) People need to know what you do and why you do it
c) Alignment makes certain they wont interrupt you when you begin
testing
d) You don’t want to have to keep explaining what you are doing
during testing.

5. What are the three management aspects you need to address to begin
testing?
a) Schedule management, resource management and budget
management
b) Version management, bug management and lab management
c) Hardware management, software management and infrastructure
management
d) Plan management, prep management and launch management

6. At the core of a good regression testing, you are making certain that
________
a) No bugs exist
b) All bugs are fixed
c) Nothing new has been broken
d) New bugs are identified.
7. How can test teams learn the most from seeing your test results?
a) Identify key bugs and hold them accountable until the issues are
addressed
b) Provide pass-fail criteria and tell them whether or not the software
c) Show them every single bug you have discovered in a
spreadsheet
d) Deliver objective overviews of the test cases and assist in
identifying trends

8. What are some of the most important characteristics of a good bug
report?
a) Severe, important, brief
b) Lengthy, unique, factual
c) Clear, objective, detailed
d) Understated, clean qualified
9. What is the blueprint that you will reference throughout your project?
a) Your test plan, cases and cycles
b) Your test cycles
c) Your test plans
d) Your test cases
10. When should you archive a project?
a) Never archive a project
b) Archive when management approves
c) Archive as you each phase of testing is complete
d) Archive a project when all work is complete
11. Which project methodology is the most recent and has all the
buzz right now?
a) Jira
b) SDLC
c) Agile
d) Waterfall
12. If a bug is reported by quality, who owns it after it has been
submitted?
a) The owns the bug
b) Nobody owns the bug
c) Development owns the bug
d) Quality owns every bug they submit

---
