package com.bank;

// Class - template 
// Object - instance 
public class CoreBankingApp {  // Parent 

    public static final String IDD_CODE = "+65";
    
    private int accNo;
    private String accType;
    private String accHName;
    private float balance;
    private String nominee;
    private String branch;
    private float minBal;
    private String accHType;
    // ...............

    public String getAccHType() {
        return accHType;
    }

    public void setAccHType(String hType) {
        this.accHType = hType;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccHName() {
        return accHName;
    }

    public void setAccHName(String accHName) {
        this.accHName = accHName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    enum AccountType {
        SAVING_ACCOUNT("SVA"),
        SENIORS_ACCOUNT("SNR"),
        CHILD_ACCOUNT("CHA"),
        CURRENT_ACCOUNT("CA"),
        SALARY_ACCOUNT("SLA");

        private final String accType;

        AccountType(String aType) {
            this.accType = aType;
        }

        String shortCode() {
            return accType;
        }
    }

    enum BalanceAmount {
        SAVING_ACCOUNT("500"),
        SENIORS_ACCOUNT("0"),
        CHILD_ACCOUNT("50"),
        CURRENT_ACCOUNT("200"),
        SALARY_ACCOUNT("10");

        private final String balAmt;

        BalanceAmount(String aType) {
            this.balAmt = aType;
        }

        String minBalance() {
            return balAmt;
        }
    }

    // Constructor - which helps me build an Object 
    public CoreBankingApp(String at, String n, String aType, String no, float ba) {
        accType = at;
        accHName = n;
        balance = ba;
        nominee = no;
        minBal = minBal();
        setAccHType(aType) ;
    }

    float minBal() {
        switch (accType) {
            case "SVA":
                return Float.parseFloat(BalanceAmount.SAVING_ACCOUNT.minBalance());
            case "SNR":
                return Float.parseFloat(BalanceAmount.SENIORS_ACCOUNT.minBalance());
            case "CHA":
                return Float.parseFloat(BalanceAmount.CHILD_ACCOUNT.minBalance());
            case "CA":
                return Float.parseFloat(BalanceAmount.CURRENT_ACCOUNT.minBalance());
            case "SLA":
                return Float.parseFloat(BalanceAmount.SALARY_ACCOUNT.minBalance());
            default:
                return 1000f;
        }
    }

    float chkBalance() {
        return balance;
    }

    float deposit(float moneyDep) {
        return balance += moneyDep;
    }

    float withdraw(float moneyWD) throws Exception {
        if( minBal() > (balance - moneyWD))
            throw new MinBalanceException(); 
        return balance -= moneyWD;
    }

    public String toString() {
        return " \n Bank Account :: " + accHName + " \n Holder Type :: " + accHType + " \n of Account type :: " + 
                 accType + " \n with :: " + balance + " balance \n nomiated 2 :: " + nominee + " \n Min Balance Req :: " + minBal;
    }

    public static void main(String args[]) {

        // Opening a new bank account - an Object 
        CoreBankingApp cAccount = new CoreBankingApp(AccountType.CHILD_ACCOUNT.shortCode(),  "CS", HolderType.CITIZEN.getHolderType(), "JY", 1000);
        //CoreBankingApp chandraAccount = new CoreBankingApp();
        System.out.println(cAccount);

        CoreBankingApp gAccount = new CoreBankingApp(AccountType.CURRENT_ACCOUNT.shortCode(),  "GN", HolderType.PERMANENT_RESIDENT.getHolderType(), "daug", 3000);
        System.out.println(gAccount);
        
        try {
            gAccount.withdraw(2700);
            System.out.println(gAccount);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        gAccount.deposit(2000);
        System.out.println(gAccount);

        try {
            gAccount.withdraw(2700);
            System.out.println(gAccount);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
/* console
run:
 
 Bank Account :: CS 
 Holder Type :: CZ 
 of Account type :: CHA 
 with :: 1000.0 balance 
 nomiated 2 :: JY 
 Min Balance Req :: 50.0
 
 Bank Account :: GN 
 Holder Type :: PR 
 of Account type :: CA 
 with :: 3000.0 balance 
 nomiated 2 :: daug 
 Min Balance Req :: 200.0
 
 Bank Account :: GN 
 Holder Type :: PR 
 of Account type :: CA 
 with :: 300.0 balance 
 nomiated 2 :: daug 
 Min Balance Req :: 200.0
 
 Bank Account :: GN 
 Holder Type :: PR 
 of Account type :: CA 
 with :: 2300.0 balance 
 nomiated 2 :: daug 
 Min Balance Req :: 200.0
Uncompilable source code - Erroneous ctor sym type: MinBalanceException.<init>
BUILD SUCCESSFUL (total time: 4 seconds)

*/