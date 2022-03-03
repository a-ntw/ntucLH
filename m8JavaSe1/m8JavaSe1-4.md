### note from 201105 m8JavaSe1-4

#### Inheritance
* Inheritance allows one class to be derived from another.
* Fields and methods are written in one class, and then inherited by other classes.
    * There is less code duplication.
    * Edits are done in one location

#### Inheritance Terminology
*   The term inheritance is inspired by biology
    *   A child inherits properties and behaviours of the parent.
    *   A child class inherits the fields and method of a parent class.
*   The parent class is know as the **superclass**.
    *   A superclass is the common location for fields and methods.
*   The child class is known as the **subclass**. A subclass extends its superclass.
    *   Subclasses share the same methods as the superclass.
    *   Subclasses may have additional methods that aren't found in their superclass.
    *   Subclasses may override the methods they inherit from their superclass.

#### Implementing Inheritance
``` java
public class Clothing {
    public void display() {...}
    public void setSize(char size){...}         // *
}
```
``` java
public class Shirt extends Clothing {...}       // use the 'extends' keyword.
```
``` java
Shirt myShirt = new Shirt();
myShirt.setSize ('M');                          // *
```
#### More Inheritance Facts
* A subclass has access to all of the public fields and methods of its superclass.
* A subclass may have unique fields and methods not found in the superclass.
``` java
public class Shirt extends Clothing {       // Shirt : subclass; Clothing : superclass
    private int neckSize;
    public int getNeckSize() {
        return neckSize;
    }
    public void setNeckSize(int Size) {
        this.neckSize = nSize;
    }
}
```
#### Clothing Class: Part 1
``` java
public class Clothing {
    // fields given default values
    private int itemID = 0;
    private String desc = "-description required-";
    private char colorCode = 'U';
    private double price = 0.0;
    
    // constructor
    public Clothing (int itemID, String desc, char color, double price ) {
        this.itemID = itemID;
        this.desc = desc;
        this.colorCode = color;
        this.price = price;
    }
}
```

#### Shirt Class: Part 1
``` java
public class Shirt extends Clothing {                 // 'extends'
    private char fit = 'U';
    
    public Shirt(int itemID, String description, char colorCode, double price, char fit) {
        super(itemID, description, colorCode, price); // Reference to the superclass constructure
        this.fit = fit;                               // Reference to this object
    }
    public char getFit() {
        return fit;
    }
    public void setFit(char fit) {
        this.fit = fit;
    }
}
```
#### Constructor Calls with Inheritance
``` java
public statuc void main(String[] args){
    Shirt shirt01 = new Shirt(20.00, 'M');  }
```
``` java
public class Shirt extends Clothing {
    private char fit = 'U';
    public Shirt (double price, char fit) {
        super(price);   // MUST call superclass constructor
        this.fit = fit;      }}
```
``` java
public class Clothing {
    private double price;
    public Clothing(double price) {
        this.price = price;     }}
```
#### Inheritance amd Overloaded Constructor
``` java
public class Shirt extends Clothing {
    private char fit = 'U';
    public Shirt (char fit) {
        this(15.00, fit);   // Call constructor in same class   // <
    }                       // Constructor is overloaded
    public Shirt (double price, char fit) {                     // <
        super(price);   // MUST call superclass constructor     // <<
        this.fit = fit;      }}
```
``` java
public class Clothing {
    private double price;
    public Clothing(double price) {             // <<
        this.price = price;     }}
```
#### More on access Control
Access level modifiers determine whether other classes can use a particular field or invoke a
particular method
* At the top level - public, or *package-private* (no explicit modifier).
* At the member level - public, private, protected, or *package-private* (no explicit modifier).

    Modifier        | Class | Package   | Subclass  | World
    ---             | ---   | ---       | ---       | ---
    public          | Y     | Y         | Y         | Y
    protected       | Y     | Y         | Y         | N
    *No modifier*   | Y     | Y         | N         | N
    private         | Y     | N         | N         | N

#### Overriding Methods
**Overriding**: A subclass implements a method that already has an implementation in the
superclass.

**Access Modifiers**:
*   The method can only be overridden if it is accessible from the subclass
*   The method signature in the subclasss cannot have a more restrictive (stronger) access
    modifier than the one on the superclass.

#### Clothing Class: Part 2
``` java
public void display() {
    System.out.println("Item ID: " + getItemID());
    System.out.println("Item description: " + getDesc());
    System.out.println("Item price: " + getPrice());
    System.out.println("Color code: " + getColorCode());
}
public String getDesc () {
    return desc;
}
public double getPrice() {
    return price;
}
public int getItemID() {
    return itemID;
}
protected void setColorCode(char color) {
    this.colorCode = color; }
// Assume that the remaining get/set methods are included in the class.
```
#### Polymorphism
* Polymorphism means that the same message to two different objects can have different results:
    * "Good night" to a child means "Start getting ready for bed."
    * "Good night" to a parent means "Read a bedtime story."
* In Java, it means the same method is implemented differently by different classes.
    * This is especially powerful in the context of inheritance.
    * It relies upon the "**is a**" relationship.

    ```
    *Polymorphism*
    CurrentAccount is a CurrentAccount              --> CurrentAccount ca = new CurrentAccount();
    CurrentAccount is an Account                    --> Account acc = new CurrentAccount();
    CurrebtAccount is an Object(java.lang.object)   --> Object o = new CurrentAccount();
    ```

#### polymorphism Applied
``` java
    Clothing c1 = new ??();
    
    c1.display();   // c1 could be a Shirt, Trousers, or Socks object.
    c1.setColorCode('P');
```
The method will be implemented differenly on different types of objects. For example:
* Trousers objects show more fields in the display method.
* Different subclasses accept a different subset of valid color codes.

#### `instanceof` Operator
Possible casting error:
``` java
public static void displayDetails(Clothing c1) {
    c1.display();
    char fitCode = ((Trousers)c1).getFit();     // What if c1 is not a Trousers object?
    System.out.println("Fit: " + firCode);
}
```
`instanceof` operator used to ensure there is no casting error
``` java
public static void displayDetails(Clothing c1) {
    c1.display();
    if (c1 instanceof Trousers) {               // instanceof returns true if c1 is a Trousers object.
        char firCode = ((Trousers)c1).getFit();
        System.out.println("Fit: " + fitCode);
    }
    else { // Take some other action 
    }}
```

#### Abstract Classes
Use the `abstract` keyword to create a special class that:
*   Cannot be instantiated
*   May contain concrete methods
*   May contain abstract methods that **must** be implemented later by any non-abstract subclasses
``` java
public abstract class Clothing {
    private int id;
    
    public int getId {                      // Concrete method
        return id;
    }
    
    public abstract double getPrice();      // Abstract methods
    public abstract void display();
}
```

#### Extending Abstract Classes
``` java
public abstract class Clothing {
    private int id;
    public int getId() {
        return id;
    }
    protected abstract double getPrice();       // MUST be implemented
    public abstract void display();   }         // MUST be implemented
```
``` java
public class Socks extends Clothing {
    private double price;
    protected double getPrice() {
        return price;
    }
    public void display() {
        System.out.println("ID: " + getID());
        System.out.println("Price: $" + getPrice());
} }
```

#### Overriding `toString` in Your Classes
Shirt class example
``` java
public String toString() {
    return "This shirt is a " + desc + ";"
        + " price: " + getPrice() + ","
        + " color: " + getColor(getColorCode());
}
```
Output of `System.out.println(shirt)`
*   Without overriding `toString`:
   `examples.Shirt@73d16e93`
*   After overriding `toString` as show above:
    `This shirt is a T Shirt: price: 29.99, color: Green`

#### The Java Interface
*   An interface is similar to an abstract class, except that:
    * Methods are implicitly abstract (except default, static, and private methods)
    * A class does not *extend* it, but *implements* it
    * A class may implement more than one interface
*   All abstract methods from the interface must be implemented by the class,
``` java
public interface Printable {
    public void print();        // implicitly abstract
}
```
``` java
public class Shirt implements Printable {
    ...
    public void print() {
        System.out.println("Shirt description");    // Implements the print() method.
    }
}
```
Screetshot
``` java
package common;
public interface Rate {
    public abstract double calcInterest(double rate);
    double adminFee();
    public static String sText = "Aloha";
}
```

#### Implementing the `Returnable` **Interface**
`Returnable` interface
``` java
public interface Returnable {
    public String doReturn();       // implicitly abstract method
}
```
`Shirt` class
``` java 
                                       // Now, Shirt 'is a' Returnable
public class Shirt extends Clothing implements Returnable {
    public Shirt(int itemID, String description, char colorCode,
                double price, char fit) {
        super(itemID, description, colorCode, price);
        this.fit = fit;
    }
    public String doReturn() {      // Shirt implements the method declared in Returnable.
        // See notes nelow
        return "Suit returns must be within 3 days";
    }
... < other methods not shown > ... }       // end of class
```
#### Casting an Interface Reference
``` java
Clothing c1 = new Trousers();
Trousers t1 = new Trousers();
Returnable r1 = new Trousers();
```
*   The `Returnable` interface does not know about `Trousers` methods:
    ``` java
    r1.getFit()     // Not allowed
    ```
*   Use casting to access methods defined outside the interface.
    ``` java
    ((Trousers)r1).getFit();
    ```
*   Use `instanceof` to avoid inappropriate casts.
    ``` java
    if(r1 instanceof Trousers) {
        ((Trousers)r1).getFit();
    }
    ```

#### What is This Feature?
Before Java 10
``` java
ArrayList list = new ArrayList<String>();           // Datatype declared twice
```
Now
``` java
vat list = new ArrayList<String>();                 // Datatype declared once
```
Before Java 10
``` java
String desc = "shirt";
ArrayList<String> list = new ArrayList<String>();
int price = 20;
double tax = 0.05;
```
Now
``` java
var desc = "shirt";
var list  = new ArrayList<String>();
var price = 20;
var tax = 0.05;
```

#### Where Can it be User?
Yes
* Local variables. eg.   `var x = shirt1.toString();`
* for loop. eg.          `for (var i-0; i<10; i++)`
* for-each loop . eg.    `for (var x : shirtArray)`

**No**
* Declaration without an initial value. eg. `var price;`
* Declaration and initialization with a null value . eg.`var price = null;`
* Fields. eg. `public var price`
* Parameters . eg.`public void setPrice(var price){}`
* Method return types. eg. `public var getPrice() { return price;}`

#### `List` Interface
All of these object types can be assigned to a `List` variable:
``` java
ArrayList words = new ArrayList<String>();
List myList = words;
```
``` java
    var words = new ArrayList();
    var myList = words;
```


---
