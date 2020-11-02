/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_11_4;

import java.util.ArrayList;

public class ShoppingCart {
    public static void main(String[] args) {
        // Declare, instantiate, and initialize an ArrayList of Strings.  Print and test your code.
        ArrayList<String> items = new ArrayList<>();
        items.add("Shirt");
        items.add("WristBand");
        items.add("Pants");
        
        // add (insert) another element at a specific index
        System.out.println(items);
        items.add(2, "Belt");
        System.out.println(items);

	// Check for the existence of a specific String element.  
        // If it exists, remove it.
        if (items.contains ("Shirt")){
            items.remove("Shirt");
        }
        System.out.println(items);
    }
}
