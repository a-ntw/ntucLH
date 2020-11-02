/* Copyright © 2018 Oracle and/or its affiliates. All rights reserved. */

package exercise_05_1;

public class ShoppingCart {
    public static void main(String[] args){
        String custName = "Mary Smith";
        String itemDesc = "Shirt";
        String message;

        double price = 29.99;
        int quantity = 2;
        double tax = 1.04;
        double total;        

        message = custName +" wants to purchase " +quantity +" " +itemDesc;
        total = quantity * price * tax;
        
        // Test quantity and modify message if quantity > 1.
        
        // Declare outOfStock variable and initialize it.
        
        // Test outOfStock and notify user in either case.

        
    }
}
