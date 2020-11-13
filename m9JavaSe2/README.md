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
### Lesson 2
A Simple Java Class
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

### Lesson 3
Exception Handling - BankingApp9Nov2020.java
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

### Lesson 4
Interfaces - bankingappicationmaven_201109/ITransaction.java
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
### Lesson 5
Arraylist
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
### Lesson 6
Lambda Solution: bankingappicationmaven/BankingApp9Nov2020.java   
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

### Lesson 7
Collection Iteration and Lambdas
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

### Lesson 09 
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

### Lesson 09
Quick Streams with `Stream.of`
``` java
    public static void main(String[] args) {
        Stream.of("Monday", "Tuesday", "Wednesday", "Thursday")
                .filter(s -> s.startsWith("T"))
                .forEach(s -> System.out.println("Matching Days: " + s));
    }
```

### Lesson 10
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

### lesson 10
Finding the Right Platform Module
```
/home/oracle$ java --describe-module java.base
```
Using `jlink` to Create a Runtime Image

* `jlink [option]` --module-path `modulepath` --add-modules `mods` --output `path`
``` console
/Hello$ jlink
--module-path dist/Hello.jar:/usr/java/jdk-9-jmods
--add-modules com.greeting
--output myimage
```
Running the Application
``` console
$ myimage/bin/ java --module com.greeting

$ myimage/bin/ java -m com.greeting

```



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
