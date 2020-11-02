/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_12_3;

public class ShoppingCart {
    public static void main(String args[]){ 
        // Declare and instantiate a Shirt object using an Item reference type instead
        Item item = new Shirt(25.99, 'M', 'P');
        
        // Test for non-Shirt object type
        //  Item item = new Item();
        
        // Call the display method on the item, then the getColor method
        item.display();
        if (item instanceof Shirt) {
            String color = ((Shirt) item).getColor();
            System.out.println("Color: " +color);
        }
        else{
            System.out.println("Item is not a Shirt.");
        }
    }
}    
