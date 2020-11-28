/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localeex;

import java.util.Locale;

/**
 *
 * @author chand
 */
public class LocaleEx1 {
    public static void main(String [] args){
        
        Locale locale = new Locale("fr");
        System.out.println(" Locale :: " + locale);
        
        
         locale = new Locale("en", "US");
        System.out.println(" Locale :: " + locale);
        
        
         locale = new Locale("en", "US", "NY");
        System.out.println(" Locale :: " + locale);
    }
}
