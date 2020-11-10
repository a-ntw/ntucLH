/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankingappicationmaven;

/**
 *
 * @author antw
 */
public class BankingApp9Nov2020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // create a runtime error
        //String aString = "A";
        //int aNumber = Integer.parseInt(aString);
        try {
            UOBBank firstUOBCustomer = new UOBBank();
            DoTransaction(firstUOBCustomer, 1001, "Eva Longoria", "Savings", 10000, 2000);

            UOBBank secondUOBCustomer = new UOBBank();
            DoTransaction(secondUOBCustomer, 1002, "Micheal Shepard", "Current", 12000, 2000);

            CitiBank firstCTCustomer = new CitiBank();
            DoTransaction(firstCTCustomer, 2001, "John Steven", "Gold", 200000, 10000);
            
            Finance firstFinCustomer = new Finance();
            DoTransaction(firstFinCustomer, 3001, "Eric Lee", "Current", 30000, 20000);

            Utility.saveTransaction(firstUOBCustomer);
            Utility.saveTransaction(secondUOBCustomer);
            Utility.saveTransaction(firstCTCustomer);
            Utility.saveTransaction(firstFinCustomer);
            
            
        } catch (Exception e) {
            System.out.println("Something went wrong, contact the admin..");
            System.out.println("Report this error:" + e.toString());
        }

    }

    private static void DoTransaction(ITransaction customer, int acctNo, String acctName,
            String acctType, double depAmount, double withAmount) throws Exception {
        customer.setAccountNo(acctNo);
        customer.setAccountName(acctName);
        customer.setAccountType(acctType);
        customer.Deposit(depAmount);
        customer.Withdrawal(withAmount);
        customer.DisplayTransaction();
    }

    
}
