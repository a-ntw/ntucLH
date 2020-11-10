package com.mycompany.bankingappicationmaven;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    //public static ArrayList transactionStorage = new ArrayList();
    public static List<ITransaction> transactionStorage = new ArrayList<>(); //Pbject type

    public static void saveTransaction(ITransaction newRecord) {
        transactionStorage.add(newRecord);
    }

}
