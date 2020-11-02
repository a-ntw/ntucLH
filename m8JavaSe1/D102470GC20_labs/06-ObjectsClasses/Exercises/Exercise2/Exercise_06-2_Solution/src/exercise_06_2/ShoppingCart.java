/* Copyright © 2018 Oracle and/or its affiliates. All rights reserved. */

package exercise_06_2;

public class ShoppingCart {

    public static void main(String[] args) {
        // Declare and initialize 2 Item objects
        Item item1, item2;
        item1 = new Item();
        item2 = new Item();
        
        // Print both item descriptions and run code
        item1.desc = "Shirt";
        item2.desc = "Pants";

        // Assign one item to another and run it again.
        item1 = item2;
        System.out.println("Item1: " + item1.desc);
        System.out.println("Item2: " + item2.desc);
     }
} 
