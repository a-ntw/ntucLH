package accmap;

public class AccMap {

    public AccMap(int nric, int accid, byte active) {
        this.nric = nric;
        this.accid = accid;
        this.active = active;
    }

    public AccMap(int id, int nric, int accid, byte active) {
        this.id = id;
        this.nric = nric;
        this.accid = accid;
        this.active = active;
    }

    @Override
    public String toString() {
        return id + "\t" + nric + "\t" + accid + "\t" + (active == 1 ? true : false);
    }

    public AccMap(int id, int nric, int accid, String accNo, byte active) {
        this.id = id;
        this.nric = nric;
        this.accid = accid;
        this.accNo = accNo;
        this.active = active;
    }
    private int id;
    private int nric;
    private int accid;
    private String accNo;
    private byte active;

    public int getNric() {
        return nric;
    }

    public void setNric(int nric) {
        this.nric = nric;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }
}
/*
CREATE DATABASE  IF NOT EXISTS `coreBanking` 
USE `coreBanking`;
DROP TABLE IF EXISTS `accmap`;
CREATE TABLE `accmap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nric` int NOT NULL,
  `accid` int DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/