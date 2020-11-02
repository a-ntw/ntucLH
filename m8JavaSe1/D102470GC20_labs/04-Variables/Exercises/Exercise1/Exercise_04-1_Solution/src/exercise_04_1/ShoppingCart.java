/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */
package exercise_04_1;

public class ShoppingCart {

    public static void main(String[] args) {
        // Declare and initialize two String variables: custName and itemDesc.
        String custName = "Mary Smith";
        String itemDesc = "Shirt";
        
        // Declare a String variable called message. Do not initialize it.
        String message;

      // Assign the message variable with a concatenation of the custName and itemDesc. 
        message = custName + " wants to purchase a " + itemDesc;

        // Print message to the System output.
        System.out.println(message);
    }
}
