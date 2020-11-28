package txhistory;

import util.LogUtil2;
import java.time.LocalDateTime;
import corebanking.sqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.time.LocalDateTime.now;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HistDAO {

    public static int getNextID() {
        int nxtID = 0;
        try {
            Statement stmt = sqlConnect.init();
            String nxID = "select max(id) from coreBanking.history;";
            ResultSet rs = stmt.executeQuery(nxID);
            rs.next();
            nxtID = rs.getInt(1) + 1;
        } catch (Exception e) {
            System.out.println(" Exception from CustomerDAO :: " + e.getMessage());
            e.printStackTrace();
        }
        return nxtID;
    }

    public static boolean insTxNow(int accid, int txcode, double txamt) throws Exception {
        LogUtil2.doInfoLog(" Info Message From >> HistDAO.insTx()");
        Statement stmt = sqlConnect.init();
        // insert into coreBanking.history (accid, txdate, txcode,
        //txamt) values (1, '2010-01-02', 2, 200);
        String insStmt = "insert into coreBanking.history (accid, txdate, txcode, txamt) values ("
                + accid + ", '" + now() + "', " + txcode + ", " + txamt + ");";

        int result = stmt.executeUpdate(insStmt);

        if (result > 0) {
            System.out.println(" Insert Success ");
        } else {
            System.out.println(" Insert Fail ");
        }

        return true;
    }
//TxHist(int accid, LocalDateTime txdate, int txcode, double txamt, String desc) 

    public static List<TxHist> getHistDescList() throws Exception {
        Statement stmt = sqlConnect.init();
        List<TxHist> histDesc = new ArrayList<>();
        String qStmt = "Select * from coreBanking.history INNER JOIN coreBanking.txcode "
                + "on coreBanking.history.txcode = coreBanking.txcode.code";

        ResultSet rs = stmt.executeQuery(qStmt);
        while (rs.next()) {
            histDesc.add(new TxHist(
                    rs.getInt("accid"),
                    rs.getObject("txdate", LocalDateTime.class),
                    rs.getInt("txcode"),
                    rs.getDouble("txamt"),
                    rs.getString("desc")
            ));
        }
        return histDesc;
    }

    /**
     * ******* for FX Scene      ***********
     */
    // convert ArrayList to ObservableList
    public static ObservableList<TxHist> oHistByAccid(int accid) throws Exception {
        List<TxHist> rs = HistDAO.getHistByAccid(accid);
        ObservableList<TxHist> ors = FXCollections.observableArrayList();
        for (TxHist row : rs) {
            ors.add(row);
//            System.out.println("Row" + row.toStringV3());
        }
        return ors;
    }

    /* pending on NOT sorted in order*/
    public static List<TxHist> getHistByAccid(int accid) throws Exception {
        Connection conn = sqlConnect.initConn();
        List<TxHist> histList = new ArrayList<>();
        String qStmt = "Select * from coreBanking.history INNER JOIN coreBanking.txcode on"
                + " coreBanking.history.txcode = coreBanking.txcode.code where accid = ? ";

        PreparedStatement pStmt = conn.prepareStatement(qStmt);
        pStmt.setInt(1, accid);

        ResultSet rs = pStmt.executeQuery();
        while (rs.next()) {
            histList.add(new TxHist(
                    rs.getInt("accid"),
                    rs.getObject("txdate", LocalDateTime.class),
                    rs.getInt("txcode"),
                    rs.getDouble("txamt"),
                    rs.getString("desc")
            ));
        }
//        // not working
//        System.out.println(rs.toString());
//        if (rs.wasNull()) {
//            System.out.println("");
//        }

        return histList;
    }

    public static boolean delHist(int histid) throws Exception {
        Statement stmt = sqlConnect.init();
        String delStmt = "delete from CoreBanking.history where id = " + histid + ";";

        int result = stmt.executeUpdate(delStmt);
        if (result > 0) {
            System.out.println(" Delete Success ");
        } else {
            System.out.println(" Delete  Fail ");
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        /* get will be next id*/
        int nextID = getNextID();
        System.out.println("nextID \t:" + nextID);

        int accid = 10;

        getHistDescList().stream().forEach(ea -> System.out.println(ea.toStringV2()));
        getHistByAccid(accid).stream().forEach(ea
                -> System.out.println(ea.toStringV3()));
        
        System.out.println("Need to add in CRUD & DAO for convenience.. ");

        // System.exit(0);   // DO NOT DO THIS
    }
}

/*        
Select * from coreBanking.history INNER JOIN coreBanking.txcode 
on coreBanking.history.txcode = coreBanking.txcode.code

Select * from coreBanking.history inner join coreBanking.txcode on coreBanking.history.txcode = reBanking.txcode.txcode
	id 	txcode 	desc
	1	1	SA
	2	2	FD
	3	3	CA
	4	4	CC
	5	11	Saving Deposit
	6	12	Saving Transfer Recd
	7	15	Saving Withdrawal
	8	16	Saving Transfer Out
 */
