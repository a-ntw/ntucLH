/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localeex;

import java.util.Scanner;

/**
 *
 * @author chand
 */
public class DataInput_WO_Locale {
    public static Scanner myObj = new Scanner(System.in);
    
    public static void main(String [] args){
    
        myObj.useDelimiter("\n");
        
        
        System.out.print(" Enter you First Name "); 
        String fname = "\n\tWelcome 2 Mr/Ms. " + myObj.next();
        
        System.out.print(" Enter you Last Name "); 
         fname += "  " + myObj.next();
        
        System.out.print(" Date Of Birth  "); 
         fname += "\n\tYou were born on, " +  myObj.next();
        
        System.out.print(" Enter your Email "); 
         fname += ", we can reach you at " + myObj.next();
        
        System.out.print(" Phone Number "); 
         fname += " or at " + myObj.next();
         
         System.out.println(fname);
    }
}
