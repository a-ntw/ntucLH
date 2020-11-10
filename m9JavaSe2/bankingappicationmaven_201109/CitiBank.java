
package com.mycompany.bankingappicationmaven;

public class CitiBank extends Bank {
    
    @Override
    public void Deposit(double depositAmount)
    {
        double bonasPercentage = 0;
        if (depositAmount >= 100000)
            bonasPercentage = 0.10;
        setAccountBalance(getAccountBalance() + depositAmount + (depositAmount * bonasPercentage));
    }
    
}
