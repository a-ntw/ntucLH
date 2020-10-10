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
public enum CountryCodes {
    SINGAPORE ("SG"),
    MALAYSIA ("MY"),
    INDONESIA ("ID"),
    THAILAND ("TH"),
    CHINA ("CN"),
    INDIA ("IN"),
    SRILANKA ("SL");
    
    String cCode ;
    
    CountryCodes(String code){
        cCode = code;
    }
    
    public String getCountryCode(){
        return cCode;
    }
  
}


