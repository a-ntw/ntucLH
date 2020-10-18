/* main: ABank.java  dated Oct16, 2020
* CustAcc.java: Customer: Name, AccCount No, account type, account balance
* BankAcc.java: deposit, withdraw, transfer, balance, bank Minimum, withdrawLimit
* Saving Account, ATM facility, Accumulate interest  // KIV
* Current Account, Cheque facility ,No compount interest  // KIV
*/
package com.bank;

//public class ABank extends java.lang.Object { // copyrighted 
public class ABank {

    public static void main(String[] args) {
        BankAcc bac1 = new BankAcc(0, 0, 0, 1000);
        pr("bac1/" + bac1 + "\n");

        float depositAmont = 200;
        bac1.setBankDep(200);
        pr("Deposit : " + bac1.getBankDep());
        pr("bac1/" + bac1 + "\n");

        /* Demonstrate the Business logic for withdrawal limit, 
           from another file, BankAcc.java */
        float withdrawAmont = 300;
        bac1.withDrawing(bac1, withdrawAmont); // BankAcc Business Logic
        pr("bac1/" + bac1 + "\n");

        withdrawAmont = 1300;
        bac1.withDrawing(bac1, withdrawAmont); // BankAcc Business Logic
        pr("bac1/" + bac1 + "\n");
    }

    /* demonstrate private static variable on the main*/
    private static void pr(String sentences) {
        System.out.println(sentences);
    }
}

/* on Terminal
antw@Mac-mini src % pwd
/Users/antw/ntuc/cp2/ABank/ABank/src
antw@Mac-mini src % javac -d ..\build\classes com/bank/ABank.java 
antw@Mac-mini src % cd ../build/classes                          
antw@Mac-mini classes % java com.bank.ABank                          
CustAcc 3-Arg Constructor 
CustAcc{custName=a, accNo=a, accBal=1000.0}BankAcc{bankDep=100.0,
    bankWdraw=20.0, bankXsfer=200.0, bankChkBal=1000.0}
antw@Mac-mini classes % 
 */
/* run from NetBean
run:
bac1/BankAcc/ Bank Balance: 1000.0

Deposit : 200.0
bac1/BankAcc/ Bank Balance: 1200.0

Withdrawal 300.0
bac1/BankAcc/ Bank Balance: 900.0

Withdrawal 1300.0
Unable to withdraw above Withdrawal Limit!
bac1/BankAcc/ Bank Balance: 900.0
*/