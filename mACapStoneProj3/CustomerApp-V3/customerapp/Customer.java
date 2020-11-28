/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp;

import java.time.LocalDate;
import java.util.function.Consumer;

/**
 *
 * @author chand
 */
public class Customer {

    private String custName;
    private LocalDate DOB;
    private byte active;
    private String email;
    private int custID;
    private String phoneNo;
    private boolean isActive;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Customer(int custID, String custName, LocalDate DOB, String email, String phoneNo, byte active) {
        this.custName = custName;
        this.DOB = DOB;
        this.active = active;
        this.email = email;
        this.custID = custID;
        this.phoneNo = phoneNo;
        isActive = (this.active == 1 ? true : false);
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    @Override
    public String toString() {
        return "\t" + custID + "\t " + custName + "\t\t" + DOB + "\t" + email + " \t " + phoneNo + " \t" + (active == 1 ? true : false);
    }

    public void toStringv1() {
        System.out.println("\t" + custID + "\t\t" + DOB + "\t" + email + " \t " + phoneNo);
    }

  
    public String toStringv2() {
        return ("\t" + custID + "\t\t" + DOB + "\t" + email + " \t " + phoneNo);
    }

  

}
