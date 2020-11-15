#### Main.java
``` java

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<Employee> loadEmpFromFile() {
        List<Employee> employees = new ArrayList<>();
        //String fileName = "C:\\SGUS\\Java_SE_II\\Collectors\\src\\empDetails.txt"; // Windows version
        String fileName = "/Users/antw/ntuc/m9JavaSe2/ConcurrencyNStreams/Collectors/src/empDetails.txt"; //??
        File f = new File(fileName);
        if (f.exists()) {
            System.out.println(" File Indeed exists !!!!");
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

                stream.forEach(System.out::println);
            } catch (IOException e) {
                System.out.println(" Exception in reading from file " + e.getMessage());
            }
        }

        return employees;
    }

    public static List<Employee> loadEmp() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Doe", "HR", 4000, "SE", 4.8));
        employees.add(new Employee("Mark", "Doe", "PR", 5000, "SSE", 2.8));
        employees.add(new Employee("Thor", "Doe", "SE", 6000, "MG", 1.8));
        employees.add(new Employee("Tony", "Stark", "MK", 7000, "CEO", 3.8));
        employees.add(new Employee("Thor", "Rogers", "IT", 1000, "CXO", 5.8));
        employees.add(new Employee("Ant", "Man", "SE", 3000, "COO", 4.8));
        employees.add(new Employee("Spider", "Man", "MK", 2000, "CFO", 7.8));
        employees.add(new Employee("Rocket", "Racoon", "IT", 8000, "SE", 8.8));
        employees.add(new Employee("John", "Doe", "HR", 4000, "SE", 6.8));
        employees.add(new Employee("Mark", "Doe", "PR", 5000, "SSE", 4.8));
        employees.add(new Employee("Wonder", "Woman", "SE", 6000, "MG", 2.8));
        employees.add(new Employee("Tony", "Stark", "MK", 7000, "CEO", 1.8));
        employees.add(new Employee("Steve", "Rogers", "IT", 1000, "CXO", 0.8));
        return employees;
    }

    public static void main(String[] args) {
        System.out.println(" Starting here ......");

        //loadEmpFromFile();
        //System.out.println(" Employees whose salary is more than 7k ......");
        System.out.println(loadEmp().stream().collect(Collectors.counting()));

        System.out.println(loadEmp()
                .stream()
                .map(e -> e.getlName())
                .collect(Collectors.toList()));

        System.out.println(loadEmp()
                .stream()
                .filter(e -> e.getSalary() >= 7000)
                .map(e -> e.getlName())
                .collect(Collectors.toList()));

        // Fetch all LNames and create a list 
        System.out.println(loadEmp()
                .stream()
                .map(e -> e.getlName())
                .collect(Collectors.toList()));

        // Fetch all LNames and create a set with no duplicate values
        System.out.println(" \n\n Employee listed by Last Name   ::: " + loadEmp()
                .stream()
                .map(e -> e.getlName())
                .collect(Collectors.toSet()));

        // Fetch number of employees working for a department 
        System.out.println(" \n\n Employee by dept ::: " + loadEmp()
                .stream()
                .collect(
                        Collectors.groupingBy(Employee::getDept,
                                Collectors.collectingAndThen(Collectors.counting(), f -> f.intValue())
                        )));

        // Average Years of Experience 
        System.out.println(" \n\n Avg Exp ::: " + loadEmp()
                .stream()
                .collect(Collectors.averagingDouble(e -> e.getYoe()))
        );

        // Average Years of Experience 
        System.out.println(" \n\n Employee by years of exp  ::: " + loadEmp()
                .stream()
                .collect(Collectors.groupingBy(Employee::getYoe))
        );

        // Get full name of emplyees 
        System.out.println(" \n\n Employee Fullname "
                + loadEmp()
                        .stream()
                        .map(e -> (e.getfName() + " " + e.getlName()))
                        .collect(Collectors.joining("\t;;\t"))
        );

        // Total Salary of all Employees 
        System.out.println(" \n\n Total Salary of all Employees \t\t"
                + loadEmp()
                        .stream()
                        .collect(Collectors.summarizingInt(Employee::getSalary)));

        // Summary of Experience 
        // Total Salary of all Employees
        System.out.println(" \n\n Experience Report of all Employees \t\t"
                + loadEmp()
                        .stream()
                        .collect(Collectors.summarizingDouble(Employee::getYoe)));

        // Max Salary among Employees 
        System.out.println(" \n\n Max salary \t\t"
                + loadEmp().stream()
                        .collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toList()))
                        .firstEntry()
                        .getValue());

        Stream.of("Monday", "Tuesday", "Wednesday", "Thursday")
                .filter(s -> s.startsWith("T"))
                .forEach(s -> System.out.println("Matching Days: " + s));

    }
}

```

#### Streams.java
``` java

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(" a stream fixed number of elements ");
        stream.forEach(p -> System.out.println(p + ","));

        stream = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(" a stream on a array of elements ");
        stream.forEach(p -> System.out.println(p + " "));

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        stream = list.stream();
        List<Integer> evenNumbersList = stream.filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Event Number List  " + evenNumbersList);
        System.out.println(" a stream on a list of elements ");

        stream = list.stream();
        stream.forEach(p -> System.out.println(p));

        Stream<Integer> randomNumbers = Stream
                .generate(() -> (new Random()).nextInt(100));

        System.out.println(" a stream on a random number of elements ");
        randomNumbers.limit(100)
                .forEach(System.out::println);

        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        memberNames.stream().filter((s) -> s.startsWith("A"))
                .forEach(System.out::println);

        memberNames.stream().filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        memberNames.stream().sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        boolean matchedResult = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);

        matchedResult = memberNames.stream()
                .allMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);

        matchedResult = memberNames.stream()
                .noneMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);

        Optional<String> reduced = memberNames.stream()
                .reduce((s1, s2) -> s1 + "#" + s2); 

        reduced.ifPresent(System.out::println); // Amitabh#Shekhar#Aman#Rahul#Shahrukh#Salman#Yana#Lokesh

        System.out.println(" \n\n EOP");
    }

}

```

#### CustomStream.java
``` java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomStream {

    public static void main(String[] args) {

        // Step 01 - Start
        String[] stringArray = new String[100];

        // Let’s fill this Array by some Strings, for the sack of putting different
        // String Objects 
        // I am putting Basics on even location and Strong on odd locations of the
        // Arrays
        for (int i = 0; i < stringArray.length; i++) {
            if (i % 2 == 0) {
                stringArray[i] = "Basics";
            } else {
                stringArray[i] = "Strong";
            }
        }

        // Step 01 Ends
        // Step 02 Starts
        // Here we are defining our own splitrator
        Spliterator<String> mySpliterator = new arraySpliterator(stringArray);

        // Here we are Defining our own stream using stream support
        // and passing the Splitiratir above.
        Stream<String> myStream = StreamSupport.stream(mySpliterator, false);

        // Step 02 Ends
        // Step 04 Starts
        // Let’s try calling some classic stream methods one by one
        // Try only one method at a time as stream goes through only once and then
        // closed.
        //myStream.forEach(System.out::println);
        //myStream.filter(st -> st.startsWith("B")).forEach(System.out::println);
        System.out.println(myStream.count()); // 100
        //System.out.println(myStream.distinct().count()); // 2
        // Step 04 Ends
    }

}

//Step 03 Starts
// creating arraySpliterator from an Array Implementing Spliterator Interface 
class arraySpliterator implements Spliterator<String> {

    private String[] arrayToSplit;
    int count = 0;
    // Constructor to access Array this is the source

    public arraySpliterator(String[] arrayToSplit) {
        this.arrayToSplit = arrayToSplit;
    }

    @Override
    public boolean tryAdvance(Consumer<? super String> action) {

        if (count <= arrayToSplit.length - 1) {
            action.accept(arrayToSplit[count]);
            count++;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Spliterator<String> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return arrayToSplit.length;
    }

    @Override
    public int characteristics() {
        // For Simplicity lets use the characteristics of a List as base
        return Arrays.asList(arrayToSplit).stream().spliterator().characteristics();
    }

}

// Step 03 Ends

```
