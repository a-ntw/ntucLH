/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localeex;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author chand
 */
public class DataInput_With_Locale {
    public static Scanner myObj = new Scanner(System.in);
    
    public static void main(String [] args){
    
        //String language = args[0];
        //String country = args[1];
        
        myObj.useDelimiter("\n");
        System.out.print("Enter the language [en/es/fr] : ");
        String language = myObj.next();
        System.out.print("Enter the country code [US/ES/FR] : ");
        String country = myObj.next();
        
        Locale locale = new Locale(language, country);
        
        System.out.println(" Locale finalized :::: " + locale.getDisplayLanguage());
        
        ResourceBundle msgs = ResourceBundle.getBundle("bundles.Msg_Bundle", locale);
        
        
        System.out.print(msgs.getObject("fname") + " : "); 
        String fname = "\n\tWelcome 2 Mr/Ms. " + myObj.next();
        
        System.out.print(msgs.getObject("lname") + " : "); 
         fname += "  " + myObj.next();
        
        System.out.print(msgs.getObject("dob") + " : ");
         fname += "\n\tYou were born on, " +  myObj.next();
        
        System.out.print(msgs.getObject("email") + " : ");
         fname += ", we can reach you at " + myObj.next();
        
        System.out.print(msgs.getObject("phone")+ " : ");
         fname += " or at " + myObj.next();
         
         System.out.println(fname);
    }
}
