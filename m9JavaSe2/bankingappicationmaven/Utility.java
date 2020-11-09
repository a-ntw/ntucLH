/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankingappicationmaven;

import java.util.ArrayList;

public class Utility {
    public static ArrayList transactionStorage = new ArrayList();
    
    public static void saveTransaction(ITransaction newRecord) {
        transactionStorage.add(newRecord);
    }
    
}
