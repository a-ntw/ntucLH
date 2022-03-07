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

#### Inheritance: Accessibility of Overriding Methods
``` java
public class Employee {
    //... other fields and methods
    public String getDetails() { ...}
}
```
``` java
public class BadManager extends Employee {
    private String deptName;
        // lines omited
    @Override
    private String getDetails() { // compile error
    return super.getDetails () + 23 " Dept: " + deptName;
    }
}
```
---
## What is oop?
Iris: "Oop is the 4 pillars!"

### JAVA - Four Pillars
Ref: https://www.geeksforgeeks.org/four-main-object-oriented-programming-concepts-of-java/

Introduction to Object-Oriented Concepts

There are four pillars in Java. Those are;
1. Inheritance
2. Polymorphism
3. Encapsulation
4. Abstraction


#### 1. Inheritance
In inheritance, you can create a new class that is inherited by another class. 
So the new class we can refer to as a child class or subclass and 
the class which already exists refer to a parent or superclass. 
One object acquires all the behaviors and properties of a parent object, and 
when you inherit a child class from a parent class you can reuse fields and methods of that class.


> **Real-life Example**:
>
> The planet Earth and Mars inherits the super class Solar System and Solar system inherits the Milky Way Galaxy. 
So Milky Way Galaxy is the top super class for Class Solar System, Earth and Mars.

``` java
        Parent Class {
        }

        class Child extends Parent
        {
            //methods and fields
        }
```
*Advantages*: Code reusability; Application performance is enhanced.


#### 2. Polymorphism
Simply we can define this concept as this, “having many forms”. 
We can simply explain this concept using a person because a person can be many things at the same time. 
He can be a father, an employer, a husband, etc.

> **Real-life Example**:
> 
> A delivery person delivers items to the user. If it’s a postman he will deliver the letters. 
If it’s a food delivery boy he will deliver the foods to the user. 
Like this polymorphism implemented different ways for the delivery function.

There are two types of polymorphism as listed below:
- Static or Compile-time Polymorphism
- Dynamic or Run-time Polymorphism

#### Static Polymorphism
Static or Compile-time Polymorphism when the compiler is able to determine the actual function, it’s called compile-time polymorphism. Compile-time polymorphism can be achieved by method overloading in java. When different functions in a class have the same name but different signatures, it’s called method overloading. A method signature contains the name and method arguments. So, overloaded methods have different arguments. The arguments might differ in the numbers or the type of arguments.
``` java
        public class Car{

            public void speed() {
            }

            public void speed(String accelerator) {
            }

            public int speed(String accelerator, int speedUp) {
                return carSpeed;
            }
        }
```
#### Dynamic Polymorphism
Dynamic or Run-time Polymorphism occurs when the compiler is not able to determine whether it’s superclass method or sub-class method it’s called run-time polymorphism. The run-time polymorphism is achieved by method overriding. When the superclass method is overridden in the subclass, it’s called method overriding.
``` java
        import java.util.Random;
        class DeliveryBoy {
            public void deliver() { System.out.println("Delivering Item"); }

            public static void main(String[] args) {
                DeliveryBoy deliveryBoy = getDeliveryBoy();
                deliveryBoy.deliver(); }

            private static DeliveryBoy getDeliveryBoy() {
                Random random = new Random(); int number = random.nextInt(5);
                return number % 2 == 0 ? new Postman() : new FoodDeliveryBoy(); }
        }
        class Postman extends DeliveryBoy {
            @Override
            public void deliver() { System.out.println("Delivering Letters"); }
        }
        class FoodDeliveryBoy extends DeliveryBoy {
            @Override
            public void deliver() { System.out.println("Delivering Food"); }
        } /*Output: Delivering Food */
```


*Advantages*: Flexibility; Code reusability

#### 3.Encapsulation
Encapsulation is also known as “data hiding”. This will wrap the code and data into a single unit and be better for unit testing.

> **Real-Life Example**:
> 
> A capsule which is mixed of several medicines. The medicines are hidden data to the end user.

``` java
        public class Encap{
           private String name;
           private int contactNo;

           public int get contactNo() { return contactNo; }
           public String getName() { return name; }
           public void setAge( int newcontactNo) { contactNo = newcontactNo; }
           public void setName(String newName) { name = newName; }
        }
```
*Advantages*: Security; Code reusability


#### 4. Abstraction
Abstraction is a process of hiding implementation details and exposes only the functionality to the user. In abstraction, we deal with ideas and not events. This means the user will only know “what it does” rather than “how it does”.

> **Real-Life Example**: 
> 
> A driver will focus on the car functionality (Start/Stop -> Accelerate/ Break), 
he/she does not bother about how the Accelerate/ brake mechanism works internally. And this is how the abstraction works.

There are two ways to achieve abstraction in Java
- Abstract class (0 to 100%)
- Interface (100%)

``` java
        // Abstract class
        abstract class Car {
            public abstract void stop();
        }

        // Concrete class
        class Honda extends Car {
            // Hiding implementation details
            @Override public void stop() {
                System.out.println("Honda::Stop");
                System.out.println("Mechanism to stop the car using break"); }
        }

        class Main {
            public static void main(String args[]) {
                Car obj = new Honda(); // Car object =>contents of Honda
                obj.stop(); // call the method
            }
        }
```
*Advantages*: Code reusability; Enhancement is easy; Maintainability; Security

---
