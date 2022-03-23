package core.banking;

public class StudentAccount extends Account {
                            // is a 
                            // child extends Parent 
    private float OD;

   public String minBalance() {
        return "0";
    }
    
   public void m1() {}
   
   public String pdpaGuidelines() { return ""; }
   
    @Override
    public void bL1(int i, int j) {
        super.bL1(i, j); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double bL1(double c) {
        return super.bL1(c); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int bL1(int b) {
        return super.bL1(b); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String bL1(String a) {
        return super.bL1(a); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bL1() {
        super.bL1(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    public float getOD() {
        return OD;
    }

    public void setOD(float OD) {
        this.OD = OD;
    }

    public float getSpendLimit() {
        return spendLimit;
    }

    public void setSpendLimit(float spendLimit) {
        this.spendLimit = spendLimit;
    }
    private float spendLimit;
    
    public static void main(String [] args){        
       
        
        Account acct = new StudentAccount(1000.0f, 35.0f, "12345", "TA", "450", "47120" ); //how could the compiler allow this?

        StudentAccount stAcc = new StudentAccount(1000.0f, 35.0f, "12345", "TA", "450", "47120" );

        System.out.println(" Min Balance for Student A/c is " );
    }

    public StudentAccount(float OD, float spendLimit, String accNo, String accHolder, String balance, String pCode) {
        super(accNo, accHolder, balance, pCode);
        this.OD = OD;
        this.spendLimit = spendLimit;
    }

    public StudentAccount(float OD, float spendLimit) {
        this.OD = OD;
        this.spendLimit = spendLimit;
    }
 
}

/* console
run:
 3-Arg Constructor 
 3-Arg Constructor 
 Min Balance for Student A/c is 
BUILD SUCCESSFUL (total time: 0 seconds)
*/