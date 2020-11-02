/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_12_3;

public class ShoppingCart {
    public static void main(String args[]){ 
        // Declare and instantiate a Shirt object using an Item reference type instead
        Shirt shirt = new Shirt(25.99, 'M', 'P');
        
        // Call the display method on the object, then the getColor method
        shirt.display();
        
            
    }
}    
