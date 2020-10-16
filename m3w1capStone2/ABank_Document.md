ABank.java
===
ABank.java companied files:
* CustAcc.java
* BankAcc.java
* CustomerInfo.java
* PDPAinterface.java

Description
---
Using Java OOPs, (Object-Oriented Programming) technique to demonstrate transfered of data from different files.

Concept of State and Behaviour ideas:
```
        Account [Parent] state + behaviour (Main object)
        State:
          - cash handling
          - foreign currency handling
        behaviour:
          - fund deposit
          - fund withdraw
          - fund transfer
          - Check balance

        Accounts [children] state & behaviour (sub Objects)
          - Saving Account
            - minimum balance
            - ATM facility
            - Accumulate interest
          - Current Account
            - Minimum balance
            - Cheque facility
            - No compount interest 

        Customer
            - Name
            - AccCount No
```

### Design Aspect
#### CustAcc.java
State of Customer information, Customer Name, AccCount No, account type, account balance.  
This file will performance bank withdrawal, check on bank balance.

#### BankAcc.java
Bank code for variable for deposit, withdraw, transfer, balance, bank Minimum, withdrawLimit.  
This file contain business logic for checking withdraw limit, `withDrawing`, and print out 
the withdrawal amount, or alert if above the limit.

#### CustomerInfo.java
- **Emun** on Customer infomarion. Not linked to main yet.

#### PDPAinterface.java
- **Interface** files. Not linked to any file

#### Terminals run and shown:
```
    run:
    bac1/BankAcc/ Bank Balance: 1000.0

    Deposit : 200.0
    bac1/BankAcc/ Bank Balance: 1200.0

    Withdrawal 300.0
    bac1/BankAcc/ Bank Balance: 900.0

    Withdrawal 1300.0
    Unable to withdraw above Withdrawal Limit!
    bac1/BankAcc/ Bank Balance: 900.0

    BUILD SUCCESSFUL (total time: 0 seconds)
```

### Issues yet to resolve
- yet to implement console key-in value. 

### Scope for improvement
- to add other account, such as Saving Account
- to Current Account with Cheque facility.
- to create logic for bank Interest to added
- to create new account of difference users
---
