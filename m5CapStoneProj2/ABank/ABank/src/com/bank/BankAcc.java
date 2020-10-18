/* main: ABank.java */
package com.bank;

import java.util.Objects;

public class BankAcc {
    float bankDep;
    float bankWdraw;
    float bankXsfer;
    float bankBalance;
    float bankMinimum;
    float withdrawlimit = (float) 1000.00;
    boolean withinLimit = true;

    public BankAcc(float bankDep, float bankWdraw, float bankXsfer, float bankBalance) {
        this.bankDep = bankDep;
        this.bankWdraw = bankWdraw;
        this.bankXsfer = bankXsfer;
        this.bankBalance = bankBalance;
    }

    public BankAcc(float bankWdraw, float bankBalance) {
        this.bankWdraw = bankWdraw;
        this.bankBalance = bankBalance;
    }
    
    /** if you don't specify Public/Private/Protected then 
        you've Package "default" Access Modifier/Specifier  */
    BankAcc(){
        System.out.println(" 0-Arg Constructor ");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Float.floatToIntBits(this.bankBalance);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankAcc other = (BankAcc) obj;
        if (!Objects.equals(this.bankDep, other.bankDep)) {
            return false;
        }
        if (!Objects.equals(this.bankWdraw, other.bankWdraw)) {
            return false;
        }
        if (!Objects.equals(this.bankXsfer, other.bankXsfer)) {
            return false;
        }
        if (!Objects.equals(this.bankBalance, other.bankBalance)) {
            return false;
        }
        return true;
    }

    public float getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(float bankBalance) {
        this.bankBalance = bankBalance;
    }

    public float getBankMinimum() {
        return bankMinimum;
    }

    public void setBankMinimum(float bankMinimum) {
        this.bankMinimum = bankMinimum;
    }

    public float getWithdrawlimit() {
        return withdrawlimit;
    }

    public void setWithdrawlimit(float withdrawlimit) {
        this.withdrawlimit = withdrawlimit;
    }

    public boolean isWithinLimit() {
        if (this.bankWdraw > this.withdrawlimit) {
            this.withinLimit = false;
        }
        return withinLimit;
    }

    public void setWithinLimit(boolean withinLimit) {
        this.withinLimit = withinLimit;
    }

    public float getBankDep() {
        return bankDep;
    }

    public void setBankDep(float bankDep) {
        this.bankDep += bankDep;
        this.bankBalance += bankDep; //// add deposit
    }

    public float getBankWdraw() {
        return bankWdraw;
    }

    public void setBankWdraw(float bankWdraw) {
        this.bankWdraw = bankWdraw;
        this.bankBalance -= bankWdraw; //// substract 
    }

    public float getBankXsfer() {
        return bankXsfer;
    }

    public void setBankXsfer(float bankXsfer) {
        this.bankXsfer = bankXsfer;
    }

    public float getBankChkBal() {
        return bankBalance;
    }

    public void setBankChkBal(float bankBalance) {
        this.bankBalance = bankBalance;
    }

    @Override
    public String toString() {
        //return "BankAcc/ Bank Deposit " + bankDep+ ", Withdraw " + bankWdraw 
        // + ", Balance: " + bankBalance;
        return "BankAcc/ Bank Balance: " + bankBalance;
        //return "BankAcc{" + "bankDep=" + bankDep + ", bankWdraw=" + bankWdraw 
        // + ", bankXsfer=" + bankXsfer + ", bankBalance=" + bankBalance + '}';
    }

    /* business logic for checking withdraw limit */
    public static void withDrawing(BankAcc someAcc, float withdrawAmont) {
        someAcc.setBankWdraw(withdrawAmont);
        System.out.println("Withdrawal " + someAcc.getBankWdraw());
        if (someAcc.isWithinLimit()) {
        } else {
            someAcc.setBankDep(withdrawAmont);
            System.out.println("Unable to withdraw above Withdrawal Limit!");
        }
    }

    public static void main(String[] args) {
        BankAcc bac1 = new BankAcc(0, 0, 0, 1000);

        System.out.println("bac1 " + bac1);
        bac1.setBankDep(200);
        System.out.println("bac1 " + bac1);
        bac1.setBankWdraw(300);
        System.out.println("bac1 " + bac1);
        // public BankAcc(float bankWdraw, float bankBalance)
        bac1.withDrawing(bac1, 299);
        System.out.println("bac1 " + bac1);

    }
}
/*
run:
bac1 BankAcc/ Bank Balance: 1000.0
bac1 BankAcc/ Bank Balance: 1200.0
bac1 BankAcc/ Bank Balance: 900.0
Withdrawal 299.0
bac1 BankAcc/ Bank Balance: 601.0
*/