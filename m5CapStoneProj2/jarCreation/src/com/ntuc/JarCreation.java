/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntuc;

/**
 *
 * @author antw
 */
public class JarCreation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("***** Jar Creation *****\n"
                + " classes % jar -cvfm jarCreated.jar META-INF/* com/*  \n"
                + " classes % java -jar jarCreated.jar  ");
    }

}

/*
NetBeans 12.0
Project Name: JayCreation
Main Class: com.ntuc.JarCreation
run on Mac-Mini

antw@Mac-mini build % cd classes
antw@Mac-mini classes % mkdir META-INF
antw@Mac-mini classes % cd MeTA-INF
antw@Mac-mini MeTA-INF % vim MANIFEST.MF
antw@Mac-mini MeTA-INF % cat MANIFEST.MF
Main-Class: com.ntuc.JarCreation


antw@Mac-mini MeTA-INF % 
antw@Mac-mini META-INF % pwd
/Users/antw/ntuc/cp2/jarCreation/build/classes/META-INF
antw@Mac-mini MeTA-INF % cd ..
antw@Mac-mini classes % jar -cvfm jarCreated.jar META-INF/* com/*
added manifest
adding: com/ntuc/(in = 0) (out= 0)(stored 0%)
adding: com/ntuc/JarCreation.class(in = 593) (out= 363)(deflated 38%)
antw@Mac-mini classes % java -jar jarCreated.jar
*** Jar Creation ***
antw@Mac-mini classes % pwd
/Users/antw/ntuc/cp2/jarCreation/build/classes
antw@Mac-mini classes % 
 */
