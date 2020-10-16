/* main: ABank.java */
package com.bank;

import java.util.Objects;

/* Demonstrate ABSTRACT class */
public abstract class CustAcc extends BankAcc {
    private String custName; //kiv
    private String accNo;
    private float accBal;
    private String accType; // kiv
    final String country; /* final String */

    public CustAcc(String custName, String accNo, float accBal, String accType, String country, float bankDep, float bankWdraw, float bankXsfer, float bankBalance) {
        super(bankDep, bankWdraw, bankXsfer, bankBalance);
        this.custName = custName;
        this.accNo = accNo;
        this.accBal = accBal;
        this.accType = accType;
        this.country = country;
    }

    public CustAcc(float bankWdraw, float bankBalance) {
        super(bankWdraw, bankBalance);
        country = "Sg";
    }

    /* ABSTRACT , force CustAcc to abstract */
    public abstract String detailCust();

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public float getAccBal() {
        return accBal;
    }

    public void setAccBal(float accBal) {
        this.accBal = this.bankBalance  ;
        //this.accBal = accBal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public String getCountry() {
        return country;
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
        final CustAcc other = (CustAcc) obj;
        if (Float.floatToIntBits(this.accBal) != Float.floatToIntBits(other.accBal)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "CustAcc{" + "custName=" + custName + ", accNo=" + accNo + ", accBal=" + accBal  + '}';
    }

    public static void main(String[] args) {
      //     public CustAcc(float bankWdraw, float bankBalance) {
        CustAcc a1 = new CustAcc((float) 100.0, 1000) {
            @Override // due to PDPAinterface.java 
            public String detailCust() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        System.out.println(" Country :" + a1.getCountry());

        CustAcc acc2 = new CustAcc((float) 100.0, 1000) {
            @Override  // due to PDPAinterface.java 
            public String detailCust() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        System.out.println(acc2); 
    }
}
/*
run:
 Country :Sg
CustAcc{custName=null, accNo=null, accBal=0.0}
*/