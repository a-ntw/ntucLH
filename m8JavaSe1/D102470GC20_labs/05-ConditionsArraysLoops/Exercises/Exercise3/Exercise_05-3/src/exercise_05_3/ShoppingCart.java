/* Copyright © 2018 Oracle and/or its affiliates. All rights reserved. */

package exercise_05_3;

public class ShoppingCart {
    public static void main(String[] args){
        String custName = "Mary Smith";
        String message;
        
        String[] items = new String[4];
        items[0] = "Shirt";
        items[1] = "Belt";
        items[2] = "Scarf";
        items[3] = "Skirt";
        
        message = custName +" wants to purchase " +items.length +" items.";
        System.out.println(message);
        
        // Iterate through and print out the items from the items array
        
        
    }
}
