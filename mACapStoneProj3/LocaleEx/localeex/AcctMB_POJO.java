/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localeex;

import java.time.LocalDate;

/**
 *
 * @author chand
 */
public class AcctMB_POJO {
    private int acctNo;
    private String hName;
    private LocalDate openDate;
    private double minBalance;
    private LocalDate closeDate;

    public AcctMB_POJO(int acctNo, String hName, LocalDate openDate, double minBalance, LocalDate closeDate) {
        this.acctNo = acctNo;
        this.hName = hName;
        this.openDate = openDate;
        this.minBalance = minBalance;
        this.closeDate = closeDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }
    
    

    

    public int getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(int acctNo) {
        this.acctNo = acctNo;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    @Override
    public String toString() {
        return "AcctMB_POJO{" + "acctNo=" + acctNo + ", hName=" + hName + ", openDate=" + openDate + ", minBalance=" + minBalance + ", closeDate=" + closeDate + '}';
    }

}

