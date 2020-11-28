package txhistory;

import corebanking.sqlConnect;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TxCode {

    public TxCode(int txcode, String desc) {
        this.txcode = txcode;
        this.desc = desc;
    }

    public TxCode(int id, int txcode, String desc) {
        this.id = id;
        this.txcode = txcode;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "\t" + id + "\t" + txcode + "\t" + desc;
    }

    private int id;
    private int txcode;
    private String desc;

    public int getTxcode() {
        return txcode;
    }

    public void setTxcode(int txcode) {
        this.txcode = txcode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static List<TxCode> ListCode() throws Exception {
        Statement stmt = sqlConnect.init();
        List<TxCode> codeList = new ArrayList<>();
        String qStmt = "Select * from coreBanking.txcode;";

        ResultSet rs = stmt.executeQuery(qStmt);
        while (rs.next()) {
            codeList.add(new TxCode(
                    rs.getInt("id"),
                    rs.getInt("code"),
                    rs.getString("desc")
            ));
        }
        return codeList;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\tid \ttxcode \tdesc");
        ListCode().stream().forEach(System.out::println);
    }
}
/*
	id 	txcode 	desc
	1	1	SA
	2	2	FD
	3	3	CA
	4	4	CC
	5	11	Saving Deposit
	6	12	Saving Transfer Recd
	7	15	Saving Withdraw
	8	16	Saving Transfer Out
	9	19	Saving Deleted
	10	18	Saving Created
BUILD SUCCESSFUL (total time: 0 seconds)

 */
 /*
LOCK TABLES `txcode` WRITE;

INSERT INTO `txcode` VALUES (1,1,'SA'),(2,2,'FD'),(3,3,'CA'),(4,4,'CC'),
(5,11,'Saving Deposit'),(6,12,'Saving Transfer Recd'),(7,15,'Saving Withdraw'),
(8,16,'Saving Transfer Out'),(9,19,'Saving Deleted'),(10,18,'Saving Created');

UNLOCK TABLES;
 */
/*
CREATE TABLE `txcode` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` int DEFAULT NULL,
  `desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
*/
