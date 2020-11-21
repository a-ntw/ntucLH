package custinfo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cust {

    @Override
    public String toString() {
        return nric + "\t" + name + "\t" + address + "\t" + email
                + "\t" + mobileNo + "\t" + DOB + "\t" + startDate + "\t"
                + (active == 1 ? true : false);
    }

    public Cust(int nric, String name, String address, String email, String mobileNo) {
        this.nric = nric;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNo = mobileNo;

    }

    public Cust(int nric, String name, String address, String email,
            String mobileNo, LocalDate DOB, LocalDateTime StartDate, byte active) {
        this.nric = nric;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNo = mobileNo;
        this.DOB = DOB;
        this.startDate = StartDate;
        this.active = active;
    }

    private int nric;
    private String name;
    private String address;
    private String email;
    private String mobileNo;
    private LocalDate DOB;
    private LocalDateTime startDate;
    private byte active;

    public int getNric() {
        return nric;
    }

    public void setNric(int nric) {
        this.nric = nric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime StartDate) {
        this.startDate = StartDate;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

}

/*
NRIC (PK)
name
address
MobileNo
PIN (Bank card)
Email ID
Date of Birth
Start DateTime
Status
 */

 /*
CREATE TABLE `customer` (
  `nric` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `email` varchar(20) NOT NULL,
  `mobileNo` varchar(12) NOT NULL,
  `DOB` date DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`nric`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
 */
/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetCust`()
BEGIN
            select nric, name, address, email, mobileNo, DOB, startDate, active
            from coreBanking.customer
            order by name;
    END
*/
