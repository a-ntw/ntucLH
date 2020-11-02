/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */
package exercise_13_2;

import java.util.ArrayList;
import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) {
        String[] days = {"monday", "saturday", "tuesday", "sunday", "friday"};
        // Convert the days array into an ArrayList

        ArrayList<String> dayList = new ArrayList(Arrays.asList(days));
        /* Loop through the ArrayList, printing out "sunday" elements in 
           upper case (use toUpperCase() method of String class) 
         Print all other days in lower case  */
        for (String s : dayList) {
            if (s.equals("sunday")) {
                System.out.println(s.toUpperCase());
            } else {
                System.out.println(s);
            }
        }
        // Print out the ArrayList  
        System.out.println(dayList);

    }
}
