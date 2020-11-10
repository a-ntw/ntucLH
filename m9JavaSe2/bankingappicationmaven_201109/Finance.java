
package com.mycompany.bankingappicationmaven;

public class Finance implements ITransaction{
    /**
     * @return the accountNo
     */
    public int getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) throws Exception {
        if (accountType == "Savings" || accountType == "Current" || accountType == "Gold" )
            this.accountType = accountType;
        else
            throw new Exception("Inalid Account Type");

    }

    /**
     * @return the accountBalance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * @param accountBalance the accountBalance to set
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    private int accountNo = 0;
    private String accountName = "Eva Longgoria";
    private String accountType = "";
    private double accountBalance = 0.0;
   
    public void Deposit(double depositAmount)
    {
        setAccountBalance(getAccountBalance() + depositAmount);
    }
    
    public void Withdrawal(double withdrawalAmount)
    {
        setAccountBalance(getAccountBalance() - withdrawalAmount);
    }
    
    public void DisplayTransaction()
    {
        System.out.println("Account No:" + getAccountNo());
        System.out.println("Account Name:" + getAccountName());
        System.out.println("Account Type:" + getAccountType());
        System.out.println("New Account Balance:" + getAccountBalance());
        System.out.println();
    }
}
