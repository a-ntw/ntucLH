package com.bank;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author antw
 */
public class catchException {

    public static void main(String[] args) {

        String userHomePath = System.getProperty("user.home"); // for Mac

        try {
            File f = new File(userHomePath + "/ntuc/capStone2/test.txt");
            FileInputStream fis = new FileInputStream(f);
        } catch (FileNotFoundException fnfEx) {
            System.out.println("ERROR msg: " + fnfEx.getMessage());
            fnfEx.printStackTrace();
        }
    }
}
/*
run:
ERROR msg: /Users/antw/ntuc/cp2/text.txt (No such file or directory)
java.io.FileNotFoundException: /Users/antw/ntuc/cp2/text.txt (No such file or directory)
	at java.base/java.io.FileInputStream.open0(Native Method)
	at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
	at com.bank.catchException.main(catchException.java:24)
BUILD SUCCESSFUL (total time: 0 seconds)
*/
