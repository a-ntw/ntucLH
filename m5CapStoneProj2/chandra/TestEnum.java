/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank;

/**
 *
 * @author chand
 */
public class TestEnum {
    public static void main(String [] args) {
        
        System.out.println(" Country Codes ");
        
        for (CountryCodes cName : CountryCodes.values()){
            System.out.print(cName + "    ");
        }
       
    }
}
/*
run:
 Country Codes 
SINGAPORE    MALAYSIA    INDONESIA    THAILAND    CHINA    INDIA    SRILANKA    BUILD SUCCESSFUL (total time: 4 seconds)

*/