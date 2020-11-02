/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_13_3;

public class Shirt extends Item {
    private char size;
    
    public Shirt(double price, char size, char colorCode){
        super ("Shirt", price, colorCode);
        this.setSize(size);
    }
    
    public void display(){
        super.display();
        System.out.println("\tSize: "+getSize());
    } 

    public char getSize() {
        return size;
    }
    public void setSize(char size) {
        this.size = size;
    }
}
