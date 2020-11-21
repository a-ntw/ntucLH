package smallDB;

public class smCust {

    private int nric;
    private String cname;
    private String address;
    private int age;

    public smCust(int nric, String cname, String address, int age) {
        this.nric = nric;
        this.cname = cname;
        this.address = address;
        this.age = age;
    }

    public int getNric() {
        return nric;
    }

    public String getName() {
        return cname;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        
        return nric + "\t" + cname + "\t" + address + "\t" + age ;
    }

}

/* mySQl
CREATE TABLE `cust` (
  `nric` int NOT NULL,
  `cname` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`nric`),
  UNIQUE KEY `nric_UNIQUE` (`nric`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
 */

 /*
INSERT INTO `smallDB`.`cust` (`nric`, `cname`, `address`, `age`) 
VALUES ('44332211', 'Tan Ah Cow', 'SomeWhere', '55');
insert into smallDB.cust (nric, cname, address, age) VALUES (4334231
, "Lim Ah Hia", "NoWhere", 33);
 */
