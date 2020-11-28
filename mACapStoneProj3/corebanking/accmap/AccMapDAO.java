package accmap;

import corebanking.sqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.LogUtil;

public class AccMapDAO {

    public static int getNextID() {
        int nxtID = 0;
        try {
            Statement stmt = sqlConnect.init();
            String nxID = "select max(nric) from coreBanking.customer;";
            ResultSet rs = stmt.executeQuery(nxID);
            rs.next();
            nxtID = rs.getInt(1) + 1;
        } catch (Exception e) {
            System.out.println(" Exception from CustomerDAO :: " + e.getMessage());
            e.printStackTrace();
        }
        return nxtID;
    }

    public static List<AccMap> accMapRow(int nric) throws Exception {
        LogUtil.IL.info(" Info Message From >> AccMapDAO.getIcAccMap()");
        Connection conn = sqlConnect.initConn();
        List<AccMap> mapList = new ArrayList<>();
        String qStmt = "Select * from coreBanking.accmap where nric = ? ";

        PreparedStatement pStmt = conn.prepareStatement(qStmt);
        pStmt.setInt(1, nric);

        ResultSet rs = pStmt.executeQuery();
        while (rs.next()) {
            mapList.add(new AccMap(
                    rs.getInt("id"),
                    rs.getInt("nric"),
                    rs.getInt("accid"),
                    rs.getByte("active")
            ));
        }
        return mapList;
    }

    public static boolean insertMap(AccMap c) throws Exception {
        LogUtil.IL.info(" Info Message From >> AccMapDAO.insertMap()");
        Statement stmt = sqlConnect.init();
        String insStmt = "insert into coreBanking.accmap (nric, accid, active) VALUES("
                + c.getNric() + ", '" + c.getAccid() + "', '" + c.getActive() + "');";

        int result = stmt.executeUpdate(insStmt);

        if (result > 0) {
            System.out.println(" Insert Success ");
        } else {
            System.out.println(" Insert Fail ");
        }

        return true;
    }

    /******* to check any available row in mySql before insert ********/
    public static boolean noMapAccNo(int accid) throws Exception {
        LogUtil.IL.info(" Info Message From >> AccMapDAO.noMapAccNo()");
        Statement stmt = sqlConnect.init();
        String qStmt = "Select count(*) from coreBanking.accmap where accid = '"
                + accid + "';";

        ResultSet rs = stmt.executeQuery(qStmt);
        if (rs.next() && rs.getInt(1) == 1) {       // **********
            System.out.println(" Already in database... ");
            return false;
        } else {
            System.out.println(" available ");
        }
        return true;
    }

    public static List<AccMap> ListMap() throws Exception {
        LogUtil.IL.info(" Info Message From >> AccMapDAO.ListMap()");
        Statement stmt = sqlConnect.init();
        List<AccMap> mapList = new ArrayList<>();
        String qStmt = "Select * from coreBanking.accMap;";

        ResultSet rs = stmt.executeQuery(qStmt);
        while (rs.next()) {
            mapList.add(new AccMap(rs.getInt("id"),
                    rs.getInt("nric"),
                    rs.getInt("accid"),
                    rs.getByte("active")
            ));

        }
        return mapList;

    }

    public static void main(String[] args) throws Exception {
        LogUtil.IL.info(" Info Message From >> AccMapDAO.main()");
        int nric = 1234567; // example, gpt twp row
        List s = accMapRow(nric); 
        System.out.println("First Part: " + s.get(0) );
        //getIcAccNo(nric).stream().forEach(System.out::println);
    }
}
/*
//    List<AccMap> testList = new ArrayList<>();
//        testList = [
//	9	2020-11-25T23:33:07	11	1000.0, 
//	9	2020-11-25T23:33:21	11	1000.0, 
//	9	2020-11-25T23:33:29	15	-200.0]
*/