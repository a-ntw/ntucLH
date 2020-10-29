 Module 1 (Introduction to SDLC)
 ---
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
BRD ID | | FRD ID | | Priority |Test Case ID
BR96
Product booking
FR57
Choosing the product
High
# TC01
FR58
Entering the quantity
High
# TC02 # TC03 # TC04
 
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
 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
#### 
