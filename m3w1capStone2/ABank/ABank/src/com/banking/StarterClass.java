/*
Shown the effect of adding 
    public boolean equals(Object obj) 
at CustAcc.java;

note that package different, need to import com.bank.CustAcc
 */
package com.banking;

import com.bank.CustAcc;

public class StarterClass extends CustAcc {

    final String thisObject; // need constructor

    public StarterClass(String thisObject, String custName, String accNo, float accBal, String accType, String country, float bankDep, float bankWdraw, float bankXsfer, float bankBalance) {
        super(custName, accNo, accBal, accType, country, bankDep, bankWdraw, bankXsfer, bankBalance);
        this.thisObject = thisObject;
    }



    public void bL1() {
    }// gold star

    // OVERLOADING
    public String bL1(String a) {
        return "";
    }

    public int bL1(int b) {
        return 0;
    }

    public double bL1(double c) {
        return 0.0d;
    }

    public void bL1(int i, int j) {
    }

    public final String withdraw() { // Business Logic
        return "100";
    }

    public static void main(String[] args) {

        //CustAcc(float bankWdraw, float bankBalance)
        CustAcc acc1 = new CustAcc(1234, 120) {
            @Override
            public String detailCust() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }; // not a good practice !!!!!!
        CustAcc acc2 = new CustAcc(1234, 120) {
            @Override
            public String detailCust() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }; // not a good practice !!!!!!

        // acc1 & acc2 are Reference variables 
        if (acc1.equals(acc2)) {
            System.out.println(" Same Accounts " + acc1);
        } else {
            System.out.println(" Different Accounts ");

        }

        System.out.println(acc1);
    }

    @Override
    public String toString() {
        return "StarterClass{" + "thisObject=" + thisObject + '}';
    }

    @Override
    public String detailCust() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
/*
CustAcc 3-Arg Constructor 
CustAcc 3-Arg Constructor 
 Different Accounts 
BUILD SUCCESSFUL (total time: 0 seconds)
 */
 /* add CustAcc.java @Override public boolean equals(Object obj) 

CustAcc 3-Arg Constructor 
CustAcc 3-Arg Constructor 
 Same Accounts CustAcc{custName=Apple, accNo=1234, accBal=120.0}
BUILD SUCCESSFUL (total time: 0 seconds)
 */
