# Snippet
### Constructor
``` java
package com.example;

public class CountRunnable implements Runnable{

    /*** NetBeans shortcut: Add the field first, then right-click and select Insert Code ***/
    final int count;
    final String threadName;

    // Setup Constructor to initialize variables
    public CountRunnable(int count, String threadName) {
        this.count = count;
        this.threadName = threadName;
    }

    public void run() {
        // Count with for loop
        for (int i = 1; i   <= count ; i++) {
            System.out.println("Thread " + threadName
                    + ": " + i);
        }
    }
}
```
### Lesson 2 A Simple Java Class
``` java
    package com.example.domain; // Package declaratopm
    public class Employee { // Class declaration
        public int emId; // Field
        public String name;
        public String ssn;
        public double salary;
        
        public Employee () {    // constructor
        }
        
        public int getEmpld() {
            return empId; // method
        }
    }
```
Applying Polymorphism
``` java
    public class GoodBonus {
        public static double getBonusPercent(Employee e) {
        /* Code here*/  }
    }
    
    // in the Employee class
    public double calcBonus() {
        return this.getSalary() * GoodBonus.getBonusPercent(this);
    }
```
Overriding methods of Object Class: toString Method
``` java
    public String toString() {
        return "Employee id: " + emId + "\n"
                + "Employee name: " | name;
    }
```
Methods Using Variable Arguments
``` java
    public class Statistics {
        public float average(int... nums) {
            int sum = 0;
            for (int x : nums) { // iterate int array nums
                sum += x;
            }
            return ((float) sum / nums.length);
        }
    }
```

### Lesson 3 Exception Handling
BankingApp9Nov2020.java
``` java
    public static void main(String[] args) {
        try {
            UOBBank firstUOBCustomer = new UOBBank();
            DoTransaction(firstUOBCustomer, 1001, "Eva Longoria", "Savings", 10000, 2000);
//
            Utility.saveTransaction(firstFinCustomer);

        } catch (Exception e) {
            System.out.println("Something went wrong, contact the admin..");
            System.out.println("Report this error:" + e.toString());
        }
    }
```
Exception Hanndling Techniques: Declaring Exceptions
``` java
    public class int readByteFromFile() throws IOExceptiom {
        try (InputStream in = new FileInputStream("a.txt")) {
            System.out.println("File open");
            return in.read();
        }
    }
```
``` java
    public void setAccountType(String accountType) throws Exception {
        if (accountType == "Savings" || accountType == "Current" || accountType == "Gold") {
            this.accountType = accountType;
        } else {
            throw new Exception("Inalid Account Type");
        }
    }
```

### Lesson 4 Interfaces
bankingappicationmaven_201109/ITransaction.java
``` java
public interface ITransaction {
    void Deposit(double depositAmount);
    void DisplayTransaction();
    void Withdrawal(double withdrawalAmount);
}
```
Implementing default Methods - bankingappicationmaven_201109/
``` java
public class Bank implements ITransaction {
    @Override
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
}
```
### Lesson 5 Arraylist
``` java
    public static void main(String args[]) {
        List<Integer> partList = new ArrayList<>(3);
        partList.add(1111);
        partList.add(2222);
        partList.add(3333);
        partList.add(4444);
        System.out.println("First Part: " + partList.get(0));
        partList.add(0, 5555);
    };
```
TreeSet: Implementation of Set ???
``` java
    public static void main(String args[]) {
        Set <String> set = new TreeSet<> ();
        
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("three"); // not added
        
        for (String item: set) {
            System.out.println("Item: " + item);
        }
    }
```
Comparable Test:Example - bankingappicationmaven/SortByAccountNo.java
``` java
public class BankingApp9Nov2020 {
  public static void main(String[] args) {
//--
            SortByAccountNo accountNoSort = new SortByAccountNo();
            Collections.sort(Utility.transactionStorage, accountNoSort);
//---
}}
//--
public class SortByAccountNo  implements Comparator<ITransaction>{
    public int compare(ITransaction o1, ITransaction o2) {
        if (o1.getAccountNo() < o2.getAccountNo()) { return -1;} 
        else if (o1.getAccountNo() > o2.getAccountNo()) { return 1; } 
        else { return 0;}
    }
}
```
### Lesson 6 Lambda Solution
bankingappicationmaven/BankingApp9Nov2020.java   
``` java
    System.out.println("Lambda expression retriving collection items:");
    Utility.transactionStorage.forEach(bankAccount -> {
        System.out.print(((ITransaction) bankAccount).getAccountNo());
        System.out.print("-");
        System.out.println(((ITransaction) bankAccount).getAccountName());
    });
```
#### Examples of Lambdas
- A boolean expression - `(List<String> list) -> list.isEmpty() // Predicate`
- Creating objects - `() -> new Person(10) // Supplier`
- Consuming from an object - `(Person p) -> {System.out.println(p.getSurName());} //Consumer`
- Select/extract from an object - `(String s) -> s.length()`
- Combine two values - `(int a, int b) -> a*b // Function`
- Compare two objects - `(Person p1, Person p2) -> p1.getAge().compareTo(p2.getAge())`

### Lesson 7 Collection Iteration and Lambdas
``` java
    public static void main(String args[]) {
        List<Person> p1 = Person.createShortList();
        System.out.println("\n=== Print List ===");
        p1.forEach(p -> System.out.println(p));
    }
```
The Filter Method, Method Reference
``` java
        System.out.println("\n=== CA Transations Lambda ==");
        tList.stream()
                .filter(t -> t.getState().equals("CA"))
                .forEach(SalesTxn::printSummary);
```
- Reference to a static method - `ContainingClass::staticMethodName`
- Reference to an instance method
- Reference to an instance method of an arbitrary object of a particular type (for example, `String::compareToIgnoreCase`)
- Reference to a constructor - `ClassName::new`

### Lesson 8 Lambda Built-in
Predicate
``` java
package java.util.function;

public interface Predicate<T> {
    public boolean test(T t);
}
```
A `Predicate` takes a generic class and returns a `boolean`. It has a single method, namely `test`.

Predicate: Example
``` java
        Predicate<SalesTxn> massSales =
                t -> t.getState().equals(State.MA);
        
        System.out.println("\n== Sales - Stream");
        tList.stream()
                .filter(massSales)
                .forEach(t -> t.printSummary());
        
        System.out.println("\n== Sales - Method Call");
        for(SalesTxn t:List) {
            if (massSales.test(t)) {
                t.printSummary();
            }
        }
```

Predicate:- bankingappicationmaven/BankingApp9Nov2020.java
``` java
            System.out.println("List of all transactions:");
            Predicate<ITransaction> allRecords = (ITransaction trans) -> true;
            displayAccounts(allRecords);
```

### Lesson 9 Lambda Operations
Quick Streams with `Stream.of`
``` java
    public static void main(String[] args) {
        Stream.of("Monday", "Tuesday", "Wednesday", "Thursday")
                .filter(s -> s.startsWith("T"))
                .forEach(s -> System.out.println("Matching Days: " + s));
    }
```

### Lesson 10 The Module Syste,
Example Hello World Modular Application Code

Module hello, people, conversation
``` java
//hello/class/<>/module-info.java
module hello {
    requires people;
}

// hello/com.greeting/Main.java
package com.greeting;

import com.question.Questions;
import com.name.Names;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello " +Names.getName() + " "
        + Questions.getQuestion());
    }
}

//people/class/<>/module-info.java
module people {
    exports com.name;
    requires transitive conversation;
}

//people/com.name/Names.java
package com.name;

public class Names {
    public static String getName(){
        return "Duke!";
    }
}

//conversation/class/<>/module-info.java
module conversation {
    exports com.question;
}

//conversation/com.question/Questions.java
package com.question;

public class Questions {
    public static String getQuestion() {
        return "How are you?";
    }
    
}
```
Creating a Modular JAR
``` 
```

compiling, directory, running
``` console
antw@Mac-mini Prac10_01_ModularSystem % javac -d classes src/com/greeting/Main.java
antw@Mac-mini Prac10_01_ModularSystem % ls -R
antw@Mac-mini Prac10_01_ModularSystem % java -cp classes com.greeting.Main
```
comoile the application module by module
``` console
javac -d mods/world src/world/module-info.java src/world/world/World.java
javac -d mods/greeting --module-path mods src/greeting/module-info.java \
src/greeting/greeting/Hello.java
```
command prompt break
``` console
antw@Mac-mini Prac_10_03_ModularSystem % java \                      
> --version                                                          
java 11.0.8 2020-07-14 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.8+10-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.8+10-LTS, mixed mode)
antw@Mac-mini Prac_10_03_ModularSystem % 
```
Passing all source filenames ??
``` console
javac -d mods --module-source-path src $(find src -name "*.java")
```
Checking module contents ??
``` console
java --module-path mods --describe-module greeting
```


Finding the Right Platform Module
```
/home/oracle$ java --describe-module java.base
```
Using `jlink` to Create a Runtime Image . it don't work, jlink path is not link!

* `jlink [option]` --module-path `modulepath` --add-modules `mods` --output `path`
``` console
/Hello$ jlink
--module-path dist/Hello.jar:/usr/java/jdk-9-jmods
--add-modules com.greeting
--output myimage
```
can use NetBeans to create jlink image. right-click and properties> ..

Running the Application
``` console
antw@Mac-mini bin % ./java --list-modules                            
com.greeting                                                         
java.base@11.0.8                                                     
java.logging@11.0.8                                                  
antw@Mac-mini bin % ./java -m com.greeting                           
Nov 15, 2020 2:12:41 PM com.greeting.Main main                       
INFO: HelloWorld App says hello!  
```
Creating a Modular JAR ??
``` console
jar --create -f <path and name of JAR file>
    --main-class <package name> <main class name>
    -C <path to compiled module code>

jar --create -f jars/world.jar -C mods/world
jar --create -f jars/hello.jar --main-class greeting.Hello -C mods/greeting/
```
Running a Modular Application
``` console
java --module-path <path to JARs> --module <module name>
java -p jars -m greeting
```
describe-module
``` console
antw@Mac-mini src % java --describe-module java.base                      
java.base@11.0.8                                                          
exports java.io                                                           
exports java.lang                                                         
exports java.lang.annotation                                              
exports java.lang.invoke     
...
```
``` console
antw@Mac-mini Hello % java --describe-module java.logging            
java.logging@11.0.8                                                  
exports java.util.logging                                            
...                                 
 ```

### Migrating to a Modular App

### Lesson 12 - Services in a Modular Application
Using the Service Type in `competition`

module-info.java for competition module
``` java
module competition {
    requires transitive gameapi;

    exports game;
    exports utils;
    
    uses gameapi.GameProvider;
    
    uses gameapi.TournamentType;
    provides gameapi.TournamentType with game.League, game.Knockout;
}
```
module-info.java for soccer
``` java
module soccer {
    requires gameapi;
    requires java.logging;
    exports soccer;
    opens soccer to jackson.databind;
    
    provides gameapi.GameProvider with soccer.SoccerProvider;
    
}
```
module-info.java for basketball
``` java
module basketball {
    requires gameapi;
    requires java.logging;
    exports basketball to competition, gameapi;
    opens basketball to jackson.databind;
    
    provides gameapi.GameProvider with basketball.BasketballProvider;
}
```
### Lesson 13 Concurrency

### Lesson 14 Parallel Streams
``` java
        result = eList.Stream()
                .filter(e -> e.getState().equls("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .parallel() // default is sequential
                .sum();

        System.out.println("TotalCO Executive Pay: $%,9.2f %n", result);
```
To save the results after a pipeline completes, use the collect method and Collectors class
``` java
List<Employee> newList02 = new ArrayList<>();
    newList02 = eList.parallelStream() // Good Parallel
        .filter(e -> e.getDept().equals("Eng");
        .collect(Collectors.toList());
```

Illustrating Parallel Execution
``` java
        int r2 = IntStream.rangeClosed(1,8).parallel()
            .reduce(0, (sum, element) -> sum + element);
```

### Lesson 15 Collector
The collect Method: Collect to an ArrayList Example

``` java
        List<Person> myPpl = people.stream()
            // Supplier: creates an ArrayList as the new result type.
            .collect(ArrayList::new.
            
            //Accumulator: adds Person elements to the result ArrayList.
            ArrayList::add,
            
            // Combiner: if parallel stream, takes two ArrayList objecs and combines them.
            ArrayList::addAll );
            
            System.out.println(myPpl);

            [Joe, Amy, Bill, Eric, Eric]
```
---
### Type of objects
``` java
		Integer one = 1;
		System.out.println(one.getClass());		// class java.lang.Integer
		
		String hello = "Hello";
		System.out.println(hello.getClass());	// class java.lang.String
		
		LocalDate tomorrow = LocalDate.parse("2021-05-01");
		System.out.println(tomorrow.getClass()); // class java.time.LocalDate
```
