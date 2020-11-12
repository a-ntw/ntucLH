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

### Lesson 12 - Services in a Modular Application
Using the Service Type in `competition`
``` java

```
