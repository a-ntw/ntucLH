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
public interface ITransaction {

    void Deposit(double depositAmount);

    void DisplayTransaction();

    void Withdrawal(double withdrawalAmount);

    /**
     * @return the accountBalance
     */
    double getAccountBalance();

    /**
     * @return the accountName
     */
    String getAccountName();

    /**
     * @return the accountNo
     */
    int getAccountNo();

    /**
     * @return the accountType
     */
    String getAccountType();

    /**
     * @param accountBalance the accountBalance to set
     */
    void setAccountBalance(double accountBalance);

    /**
     * @param accountName the accountName to set
     */
    void setAccountName(String accountName);

    /**
     * @param accountNo the accountNo to set
     */
    void setAccountNo(int accountNo);

    /**
     * @param accountType the accountType to set
     */
    void setAccountType(String accountType) throws Exception;
    
}
