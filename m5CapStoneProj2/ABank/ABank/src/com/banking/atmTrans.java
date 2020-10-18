/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banking;

/**
 *
 * @author antw
 */
public class atmTrans {
    //Saving Account, ATM facility, Accumulate interest

    private float atmWithdraw;

    private float withdrawlimit = (float) 1000.00;

    private boolean withinLimit = true;

    public boolean isWithinLimit() {
        if (this.atmWithdraw > this.withdrawlimit) {
            this.withinLimit = false;
        }
        return withinLimit;
    }

    public void setWithinLimit(boolean withinLimit) {
        this.withinLimit = withinLimit;
    }

    public float getAtmWithdraw() {
        return atmWithdraw;
    }

    public void setAtmWithdraw(float atmWithdraw) {
        this.atmWithdraw = atmWithdraw;
    }

    public float getWithdrawlimit() {
        return withdrawlimit;
    }

    public void setWithdrawlimit(float withdrawlimit) {
        this.withdrawlimit = withdrawlimit;
    }
/*
    public atmTrans(float atmWithdraw, String custName, String accNo, float accBal) {
        super(custName, accNo, accBal);
        this.atmWithdraw = atmWithdraw;
    }

    public atmTrans(float atmWithdraw, float withdrawlimit, String custName, String accNo, float accBal) {
        super(custName, accNo, accBal);
        this.atmWithdraw = atmWithdraw;
        this.withdrawlimit = withdrawlimit;
    }
*/
    @Override
    public String toString() {
        return "atmTrans{" + "atmWithdraw=" + atmWithdraw + ", withdrawlimit=" + withdrawlimit + '}';
    }


    public static void main(String[] args) {

    }
}
