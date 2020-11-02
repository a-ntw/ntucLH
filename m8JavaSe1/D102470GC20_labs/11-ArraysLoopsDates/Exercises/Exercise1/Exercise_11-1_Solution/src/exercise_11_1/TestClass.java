/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_11_1;

// import statements here:
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestClass {
    public static void main(String[] args) {
        // Declare a LocalDateTime object
        LocalDateTime orderDate;
        
	// Initialize the LocalDateTime object and print it.
        orderDate = LocalDateTime.now();
        System.out.println("Order date: " +orderDate);

	// Format the object using ISO_LOCAL_DATE; Print it.
        String fDate = orderDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("Formatted order date: " +fDate);    
    }    
}
