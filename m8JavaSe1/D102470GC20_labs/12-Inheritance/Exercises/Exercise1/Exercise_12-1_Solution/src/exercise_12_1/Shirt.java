/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_12_1;

public class Shirt extends Item {
    private char size;
    private char colorCode;
    
    public Shirt(double price, char size, char colorCode){
        super ("Shirt", price);
        this.size = size;
        this.colorCode = colorCode;
    } 
}
