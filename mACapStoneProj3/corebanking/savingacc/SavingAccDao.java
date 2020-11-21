package savingacc;

import corebanking.sqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SavingAccDao {

    public static int getNextID() {
        int nxtID = 0;
        try {
            Statement stmt = sqlConnect.init();
            String nxID = "select max(idSA) from coreBanking.SA;";
            ResultSet rs = stmt.executeQuery(nxID);
            rs.next();
            nxtID = rs.getInt(1) + 1;
        } catch (Exception e) {
            System.out.println(" Exception from sqlConnect :: " + e.getMessage());
            e.printStackTrace();
        }
        return nxtID;
    }

    public static boolean insertSAacc(SavingAcc c) throws Exception {
        //System.out.println("First Part: " + c.toString() );

        Statement stmt = sqlConnect.init();
        //INSERT INTO coreBanking.SA (idSA, accNo, balance, intRate, accOpenDate, minBal)
        //        VALUES (4, '123-456-789-2', 2001, 0.04, '2010-11-20', 300);        
        String insStmt = "insert into coreBanking.SA (idSA, accNo, balance, "
                + "intRate, accOpenDate, minBal )" + " values("
                + c.getIdSA() + ", '"
                + c.getAccNo() + "', "
                + c.getBalance() + ", "
                + c.getIntRate() + ", '"
                + c.getAccOpenDate().toString() + "', "
                //+ c.getAccClosedDate().toString() + ", "
                + c.getMinBal() + ");";
        // idSA, accNo, balance, intRate, accOpenDate, accClosedDate, minBal
        System.out.println(" +++++++++++++++++= insStmt");
        int result = stmt.executeUpdate(insStmt);

        if (result > 0) {
            System.out.println(" Insert Success ");
        } else {
            System.out.println(" Insert Fail ");
        }

        return true;
    }

    public static List<SavingAcc> listSA() throws Exception {
        Statement stmt = sqlConnect.init();

        List<SavingAcc> saList = new ArrayList<>();
        String qStmt = "Select * from coreBanking.SA";

        ResultSet rs = stmt.executeQuery(qStmt);

        while (rs.next()) {
            saList.add(new SavingAcc(
                    rs.getInt("idSA"),
                    rs.getString("accNo"),
                    rs.getDouble("balance"),
                    rs.getDouble("intRate"),
                    rs.getDate("accOpenDate").toLocalDate(),
                    //rs.getDate("accClosedDate").toLocalDate(),
                    rs.getDouble("minBal")
            ));
        }

        return saList;
    }

    public static List<SavingAcc> getInfo(String accNo) throws Exception {
        Connection conn = sqlConnect.initConn();
        List<SavingAcc> infoList = new ArrayList<>();
        String qStmt = "Select * from coreBanking.SA where accNo = ? ";

        PreparedStatement pStmt = conn.prepareStatement(qStmt);
        pStmt.setString(1, accNo);
        ResultSet rs = pStmt.executeQuery();

        while (rs.next()) {
            infoList.add(new SavingAcc(
                    rs.getInt("idSA"),
                    rs.getString("accNo"),
                    rs.getDouble("balance"),
                    rs.getDouble("intRate"),
                    rs.getDate("accOpenDate").toLocalDate(),
                    rs.getDate("accClosedDate").toLocalDate(),
                    rs.getDouble("minBal")
            ));
        }

        return infoList;

    }

    public static void main(String[] args) throws Exception {

        System.out.println("First Part: " + SavingAccDao.listSA().get(0));

        //SavingAccDao.listSA().stream().forEach(System.out::println);
    }
}
