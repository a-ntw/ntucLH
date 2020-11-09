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
public class Bank implements ITransaction {

    /**
     * @return the accountNo
     */
    @Override
    public int getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    @Override
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the accountName
     */
    @Override
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName the accountName to set
     */
    @Override
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return the accountType
     */
    @Override
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    @Override
    public void setAccountType(String accountType) throws Exception {
        if (accountType == "Savings" || accountType == "Current" || accountType == "Gold") {
            this.accountType = accountType;
        } else {
            throw new Exception("Inalid Account Type");
        }

    }

    /**
     * @return the accountBalance
     */
    @Override
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * @param accountBalance the accountBalance to set
     */
    @Override
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    private int accountNo = 0;
    private String accountName = "Eva Longgoria";
    private String accountType = "";
    private double accountBalance = 0.0;

    @Override
    public void Deposit(double depositAmount) {
        setAccountBalance(getAccountBalance() + depositAmount);
    }

    @Override
    public void Withdrawal(double withdrawalAmount) {
        setAccountBalance(getAccountBalance() - withdrawalAmount);
    }

    @Override
    public void DisplayTransaction() {
        System.out.println("Account No:" + getAccountNo());
        System.out.println("Account Name:" + getAccountName());
        System.out.println("Account Type:" + getAccountType());
        System.out.println("New Account Balance:" + getAccountBalance());
        System.out.println();
    }
}
