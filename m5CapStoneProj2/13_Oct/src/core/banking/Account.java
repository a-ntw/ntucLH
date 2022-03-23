package core.banking;

import java.util.Objects;

public abstract  class Account implements PDPA_Regulation { // copyrighted 

     String accNo;
    String accHolder;
    //EOL for Inheritance
    String balance;
    String postCode;
    final String country;
   // String somVar;
    
    public abstract  String minBalance(); 
    /**
        return "100";
    }**/
    
   
    public final String withdraw() { // Business Logic

        return "100";
    }
    
    public String withdraw(String amt){
        return " balance - amt";
    }
    
    public String getCountry() {
        return country;
    }
    
    
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Account(String accNo, String accHolder, String balance, String pCode) {
        this.accNo = accNo;
        this.accHolder = accHolder;
        this.balance = balance;
        this.postCode = pCode;
        country="Singapore";
        System.out.println(" 3-Arg Constructor ");
    }
    
    public void bL1() {
    }// gold star

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

   public Account() {  // if you don't specify Public/Private/Protected then you've Package "default" Access Modifier/Specifier 
       country="MY"; 
       System.out.println(" 0-Arg Constructor ");
    }
   

    @Override
    public int hashCode() { // No body can tamper with your Object 
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.accNo);
        hash = 13 * hash + Objects.hashCode(this.accHolder);
        hash = 13 * hash + Objects.hashCode(this.balance);

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
        final Account other = (Account) obj;
        if (!Objects.equals(this.accNo, other.accNo)) {
            return false;
        }
        if (!Objects.equals(this.accHolder, other.accHolder)) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "accNo=" + accNo + ", accHolder=" + accHolder + ", balance=" + balance + '}';
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(String accHolder) {
        this.accHolder = accHolder;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
