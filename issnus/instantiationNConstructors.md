## Classes. Structire
``` java
public class HistoricEvent {                /* Start of class block */

    private Date    dateOccurred;           /* Instance Variable (attributes) */
    private Place   placeOccured;
    private String  description;
    
    public HistoricEvent    (Date when, Place, where, String what) {    /* Constructor */
        [... code omitted...]
    }
    
    public boolean occursAt (Place p) {             /* Methods */
        [... code omitted...]
    }
    
    public int getCentury() {
        [... code omitted...]
    }
    [... code omitted...]           /* More Methods and attributes (order is irrelevant) */
}                                   /* End of class block. Nothing after this */
```
---
## Instantiation and Constructors
02 Classes Instances.pdf
* To instantiate an object, use the **new** operator
  * invokes a constructor method (same name as the class)
  * a class can have several constructors with different argument lists
* Constructor's objective is to make the object _usable_
  * object is instantiated by allocating memory for object's instance variables
  * the function of the constructor is to initialise this memory
  * any manipulation (by method) can commence
``` java
public class MyClass {
    public MyClass() {              // No argument constructor
        [... Set up the object ...]
    }
    public MyClass(int X) {         // constructor with int arg
        [... Set up the object]
    }
    [... code omitted ...]
}
```
### :star: Example
``` java
public class Bank {

	MortgageList mortgages = new MortgageList();            // Declaration and Instantiation
	
	public void addNewMortgage (Customer requester, float amount) {
		Mortgage m = null;                                // Initially not bound (set to null)
		
		float rate = getCurrentInterestRate ();
		m = new Mortgage (requester, amount, rate);       // Mortgage object instantiation
		mortgages.add (m);
	}

	private float getCurrentInterestRate() {
		// ... code ommited ...
		return 0;
	}
	
	// ... code ommited ...
}
```
### Default Constructor-1
* Every class has at least one constructor
    * If you do not write one, java provides a default constructor
    * Default constructor has no arguments and an empty body
    * All the member variables are assigned default values
* You can write constructors with arguments
    * If you do, the default constructor must be explicitly declared if you need it
``` java
public class CountApp {
	// Default constructor implicitly inserted
	private int a, b;
	public void printMessage( ) {
		System.out.println("a=" + a + " b=" + b);
	}
	public static void main (String args[]) {
		CountApp app = new CountApp();
		app.printMessage();
	}

}
// a=0 b=0
```
### Default Constructor-2
``` java
public class CountApp2 {
	private int a;
	private int b;
	
	// Can define multiple constructors to create and initialize instances of the class
	public CountApp2(int a, int b) {
		a = 1;
		b = 1;	
	}
	public CountApp2(int a) {
		a = 1;
	}	
	public void printMessage( ) {
		System.out.println("a=" + a + " b=" + b);
	}
	public static void main (String args[]) {
		//X CountApp2 app = new CountApp2(); //if you create multiple constuctors, you will lost the default constructor
		//app.printMessage();
	}
}
```
### `this` keyword
* Keyword **`this`** references the current instance
    * i.e. the instance containing the method being executed
    * used to resolve naming conflicts, or to pass a self-reference
``` java
public class Manager {
	private String 		department;
	private Employee	subs[];
	private int		numEmployees;
	
	public Manager(String department) {
		this.department = department;	// Differentiate between parameter and variable
		this.subs = new Employee[10];
	}
	public void manage (Employee e) {
		subs[numEmployees++] = e;
		e.setManager (this);	// Pass to the Employee object a reference to the Manager itself
	}
}
```
### `this ()`
* `this()` may be used to refer to a constructor of the current class
    * must be used in the first line in the constructor
``` java
public class Employee {

	public Employee(String name, float salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(String name) {
		this(name, 0);	// Using `this()` to refer to another constructor in the same class
	}

```

---
