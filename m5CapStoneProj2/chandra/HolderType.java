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
public enum HolderType {
    CITIZEN("CZ"),
    PERMANENT_RESIDENT("PR"),
    EP_HODLER("EP"),
    VISITOR("VS");
    
    public String hType;
    
     HolderType(String hType){
        this.hType = hType;
    }
    
    public String getHolderType (){
         return hType;
    }
}
