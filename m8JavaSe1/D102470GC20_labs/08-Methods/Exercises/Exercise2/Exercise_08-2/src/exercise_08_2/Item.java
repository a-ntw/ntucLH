/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_08_2;

public class Item {
    String desc;
    int quantity;
    double price;
    char colorCode = 'U';   //'U' = Undetermined

    public void displayItem() {
        System.out.println("Item: " +desc +", " +quantity +", " +price +", " +colorCode);
    }
    
    // Write a public 3-arg setItemFields method that returns void.

    
    // Write a public 4-arg setItemDisplay method that returns an int.

}


