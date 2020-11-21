package savingacc;

import java.time.LocalDate;

public class SavingAcc {

    public SavingAcc(int idSA, String AccNo, double balance, double intRate,
            LocalDate accOpenDate, LocalDate accClosedDate, double minBal) {

        this.idSA = idSA;
        this.AccNo = AccNo;
        this.balance = balance;
        this.intRate = intRate;
        this.accOpenDate = accOpenDate;
        this.accClosedDate = accClosedDate;
        this.minBal = minBal;
    }

    public SavingAcc(int idSA, String AccNo, double balance, double intRate,
            LocalDate accOpenDate, double minBal) {
        this.idSA = idSA;
        this.AccNo = AccNo;
        this.balance = balance;
        this.intRate = intRate;
        this.accOpenDate = accOpenDate;
        this.accClosedDate = accClosedDate;
        this.minBal = minBal;
    }

    @Override
    public String toString() {
        String s = String.format("%.3f", intRate);
        return idSA + "\t" + AccNo + "\t" + balance + "\t\t" + s
                + "\t\t" + accOpenDate + "\t" + accClosedDate + "\t\t" + minBal;
    }

    private int idSA;
    private String AccNo;
    private double balance;
    private double intRate;
    private LocalDate accOpenDate;
    private LocalDate accClosedDate;
    private double minBal;

    public int getIdSA() {
        return idSA;
    }

    public void setIdSA(int idSA) {
        this.idSA = idSA;
    }

    public String getAccNo() {
        return AccNo;
    }

    public void setAccNo(String AccNo) {
        this.AccNo = AccNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getIntRate() {
        return intRate;
    }

    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }

    public LocalDate getAccOpenDate() {
        return accOpenDate;
    }

    public void setAccOpenDate(LocalDate accOpenDate) {
        this.accOpenDate = accOpenDate;
    }

    public LocalDate getAccClosedDate() {
        return accClosedDate;
    }

    public void setAccClosedDate(LocalDate accClosedDate) {
        this.accClosedDate = accClosedDate;
    }

    public double getMinBal() {
        return minBal;
    }

    public void setMinBal(double minBal) {
        this.minBal = minBal;
    }

}

/*
CREATE TABLE `SA` (
  `idSA` int NOT NULL,
  `accNo` varchar(45) NOT NULL,
  `balance` double DEFAULT '1000',
  `intRate` double DEFAULT '0.05',
  `accOpenDate` date DEFAULT NULL,
  `accClosedDate` date DEFAULT NULL,
  `minBal` double DEFAULT '200',
  PRIMARY KEY (`accNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
*/