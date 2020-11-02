/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_08_1;

public class Item {
    char color;
        
    // Declare and code the setColor method.
    public boolean setColor(char colorCode){
        if (colorCode == ' '){
            return false;
        }
        else {
            this.color = colorCode;
            return true;
        }   
    }
}

