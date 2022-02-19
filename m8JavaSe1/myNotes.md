notes from JavaSe ProgrammingII vol1

#### A Simple Java Class: `Employee` (pg 2-4)
``` java
package com.example.domain;         // Package declaration
public class Employee {             // Class declaration
    public  int empId;              // Fields
    public  String name;            //  "
    public  String ssn;             //  "
    public  double salary;          //  "
    
    public Employee ()  {           // Constructor
    }
    
    public  int getEmpId  ()  {     // Method
        return empId;
    }
} 
```

#### Encapsulation: Private Data, Public Methods
One way to hide implementation details is to declare all the filed `private`.
``` java
public class Employee {
    private  int empId;              // Declaring fields private prevents direct access
    private  String name;            // to this data from a class instance,
    private  String ssn;             // 
    private  double salary;          // 
    
// ... constrcutor and methods
    }
```

#### Using Access Control (pg 2-9)

| Modifier  | Same Class  | Same Package  | Subclass in Another Package | Universe |
| ---       | ---         | --- | --- | --- |
| private   | Yes         | | | |
| default   | Yes         | Yes           | | |       
| protected | Yes         | Yes           | Yes | |
| public    | Yes         | Yes           | Yes                         | Yes |

#### Applying Polymorphism (pg 2 -15)
A good practice is to pass parameters and write methods that use the most generic possible form of your object.
``` java
public class GoodBonus {
  public static double getBonusPercent(Employee e) {
    // code here
  }
```
``` java
// In the Employee class
  public double calcBonus() {
    return this.getSalary() * GoodBonus.getBonusPercent(this);
  }
```

