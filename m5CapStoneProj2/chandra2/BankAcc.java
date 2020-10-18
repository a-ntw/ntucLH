package com.ubs;

import static com.ubs.BankAcc.minBal;

public class BankAcc {

    public int balance;
    public static final int minBal = 150;

    public BankAcc(int bal) throws Exception { // throws Exception to the Caller 
        setBalance(bal);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) throws Exception { // method is also throw - caller 
        if (balance > minBal) {
            this.balance = balance;
        } else {
            System.out.println(" .......");
            throw new MinBalanceEx(" Min Balance Requirement not fulfilled, MINBAL Expected is :: " + minBal);
        }
    }

    public static void main(String args[]) { // ???? Caller - JVM 
        try {
            //     String i = args[0];
            BankAcc b1 = new BankAcc(1000);
            System.out.println(" Balance in Account " + b1.getBalance()); // create Snake
            BankAcc b3 = new BankAcc(99);
            System.out.println(" Balance in Account " + b3.getBalance()); // create Food
            BankAcc b2 = new BankAcc(151);
            System.out.println(" Balance in Account " + b2.getBalance()); // Draw S & F
        } catch (Exception e) {
              System.out.println(" Exception Caught :::" + e.getMessage());
        }
        finally {
            System.out.println(" You do clean up ");
        }
    }
}
