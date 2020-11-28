package txhistory;

import java.time.LocalDateTime;

public class TxHist {

    public TxHist(int id, int accid, LocalDateTime txdate, int txcode, double txamt) {
        this.id = id;
        this.accid = accid;
        this.txdate = txdate;
        this.txcode = txcode;
        this.txamt = txamt;
    }

    public TxHist(int accid, LocalDateTime txdate, int txcode, double txamt) {
        this.accid = accid;
        this.txdate = txdate;
        this.txcode = txcode;
        this.txamt = txamt;
    }

    public TxHist(int accid, LocalDateTime txdate, int txcode, double txamt, String desc) {
        this.accid = accid;
        this.txdate = txdate;
        this.txcode = txcode;
        this.txamt = txamt;
        this.desc = desc;
    }

    public TxHist(LocalDateTime txdate, int txcode, double txamt, String desc) {
        this.txdate = txdate;
        this.txcode = txcode;
        this.txamt = txamt;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "\n\t" + accid + "\t" + txdate + "\t" + txcode + "\t" + txamt;
    }

    public String toStringV2() {
        return "\n\t" + accid + "\t" + txdate + "\t" + txcode + "\t" + desc + "\t" + txamt;
    }

    public String toStringV3() {
        return "\n\t" + txdate + "\t" + txcode + "\t" + desc + "\t" + txamt;
    }
    private int id;
    private int accid;
    private LocalDateTime txdate;
    private int txcode;
    private double txamt;
    private String desc;

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

    public LocalDateTime getTxdate() {
        return txdate;
    }

    public void setTxdate(LocalDateTime txdate) {
        this.txdate = txdate;
    }

    public int getTxtype() {
        return txcode;
    }

    public void setTxtype(int txcode) {
        this.txcode = txcode;
    }

    public double getTxamt() {
        return txamt;
    }

    public void setTxamt(double txamt) {
        this.txamt = txamt;
    }

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

    public static String varName = "this can be used globally;";
    public static int glovalVarInt;

}

/*
CREATE TABLE `history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `accid` int DEFAULT NULL,
  `txdate` datetime DEFAULT NULL,
  `txcode` int DEFAULT NULL,
  `txamt` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
*/
