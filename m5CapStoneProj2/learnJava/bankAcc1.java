
/**
 *
 * @author antw
 */
// Class - template
// Object - instance
public class bankAcc1 {  // Parent
    // Savings Bank Account
    // Curretn Bank Account
    // Kids Bank Account
    // HL Linked BA
    // FD Linked BA
    // .....

    int accNo;
    String accType;
    String accHName;
    float balance;
    String nominee;
    String branch;
    // ......

    // constructor - which hepls me build an object
    public bankAcc1(String at, String n, String no, float ba) {
        accType = at;
        accHName = n;
        balance = ba;
        nominee = no;
    }

    //behavior
    float deposit(float moneyDep) {
        return balance += moneyDep;
    }

    float withdraw(float moneyWD) {
        return balance -= moneyWD;
    }

    // default to toString
    public String toString() {
        return "Bank Account Details of " + accHName + " of type"
                + accType + " with " + balance + " nomiated for " + nominee;

    }

    public static void main(String args[]) {

        // Opening a new bank account - an Object
        bankAcc1 cAccount = new bankAcc1("SA", "CS", "JY", 1000);
        //  bankAcc1 chandraAccount = new bankAcc1();

        System.out.println(cAccount);

        bankAcc1 gAccount = new bankAcc1("CA", "GN", "daug", 3000);
        System.out.println(gAccount);
        gAccount.deposit(2000);
        System.out.println(gAccount);
        gAccount.withdraw(500);
        System.out.println(gAccount);

    }
}

/*
antw@Mac-mini cp2Java % java bankAcc1     
Bank Account Details of CS of typeSA with 1000.0 nomiated for JY
Bank Account Details of GN of typeCA with 3000.0 nomiated for daug
Bank Account Details of GN of typeCA with 5000.0 nomiated for daug
Bank Account Details of GN of typeCA with 4500.0 nomiated for daug
antw@Mac-mini cp2Java % 

 */
