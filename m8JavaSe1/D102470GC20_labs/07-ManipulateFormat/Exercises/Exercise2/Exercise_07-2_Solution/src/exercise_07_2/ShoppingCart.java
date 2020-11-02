/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_07_2;

public class ShoppingCart {
    public static void main(String[] args) {
        String custName = "Steve Smith";
        String firstName;
        int spaceIdx;
        
        spaceIdx = custName.indexOf(" ");
        firstName = custName.substring(0, spaceIdx);
        System.out.println(firstName);
        
        //Instantiate and initialize sb to firstName.
        StringBuilder sb = new StringBuilder(firstName);

	// Put the full name back together, using StringBuilder append method.
	// You can just enter the String literal for the last name.
	// Print the full name.
        sb.append(" Smith");
	
	// (Optional) Can you append the last name without using a String literal?
 	sb.append(custName.substring(spaceIdx));
        System.out.println(sb);
    }
}