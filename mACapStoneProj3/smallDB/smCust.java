/*
CREATE TABLE `smallDB`.`cust` (
  `nric` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`nric`),
  UNIQUE INDEX `nric_UNIQUE` (`nric` ASC) VISIBLE);
 */

/*
INSERT INTO `smallDB`.`cust` (`nric`, `name`, `address`, `age`) VALUES ('44332211', 'Tan Ah Cow', 'SomeWhere', '55');
insert into smallDB.cust (nric, name, address, age) VALUES (4334231, "Lim Ah Hia", "NoWhere", 33);
*/
package smallDB;

public class smCust {

    private int nric;
    private String name;
    private String address;
    private int age;

    public smCust(int nric, String name, String address, int age) {
        this.nric = nric;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public int getNric() {
        return nric;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "smCust{" + "nric=" + nric + ", name=" + name + ", address=" + address + ", age=" + age + '}';
    }

}
