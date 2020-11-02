/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_10_1;

public class TestClass {
    public static void main(String[] args) {
        int x = 4, y = 9;
        
        if (y / x < 3) {
            x += y;
        }
        else {
            x *= y;
        }
        System.out.println("After if statement, x = " + x);
        
        // Resetting values
        x = 4;
        y = 9;
        
        // Use a ternary operator to perform the same logic as above.

    }    
}
