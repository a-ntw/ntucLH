package bankacc;

import corebanking.sqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.LogUtil;

public class BankAccDao {

    /**
     * ********** get the next id from mySql of table *****************
     */
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

    //* >>  inSAacc() >> Crud 1 >> Create Account -  */
    public static boolean insertSAacc(BankAcc c) throws Exception {
        //System.out.println("First Part: " + c.toString() );
        Statement stmt = sqlConnect.init();
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
        int result = stmt.executeUpdate(insStmt);

        if (result > 0) {
            System.out.println(" Insert Success ");
            int txcode = 18; // Saving Created for history
            txhistory.HistDAO.insTxNow(c.getIdSA(), txcode, c.getMinBal());
        } else {
            System.out.println(" Insert Fail ");
        }

        return true;
    }

    //* >> listByAccNo() >> Crud 2 >> List data by Account no.  */
    public static List<BankAcc> getList(String accNo) throws Exception {
        Connection conn = sqlConnect.initConn();
        List<BankAcc> infoList = new ArrayList<>();
        String qStmt = "Select * from coreBanking.SA where accNo = ? ";

        PreparedStatement pStmt = conn.prepareStatement(qStmt);
        pStmt.setString(1, accNo);
        ResultSet rs = pStmt.executeQuery();

        while (rs.next()) {
            infoList.add(new BankAcc(
                    rs.getInt("idSA"),
                    rs.getString("accNo"),
                    rs.getDouble("balance"),
                    rs.getDouble("intRate"),
                    rs.getDate("accOpenDate").toLocalDate(),
                    //rs.getDate("accClosedDate").toLocalDate(),
                    rs.getDouble("minBal")
            ));
        }

        return infoList;

    }

    //* >> delByAccID >>Crud 4 >> Delete Account]. */
    public static boolean delAcc(BankAcc s) throws Exception {
        LogUtil.SL.info(" Severe Message From >> delAcc(SavingAcc s)");
        Statement stmt = sqlConnect.init();
        String delStmt = "delete from coreBanking.SA where idSA = " + s.getIdSA() + ";";

        int result = stmt.executeUpdate(delStmt);
        if (result > 0) {
            System.out.println(" Delete Success ");
            int txcode = 19; // Saving Delete for history
            txhistory.HistDAO.insTxNow(s.getIdSA(), txcode, 0); // for history
        } else {
            System.out.println(" Delete  Fail ");
        }
        return true;
    }

    //* >> infoByAccNo() >> Crud 3 >> Account detail..  */
    //* >> balanceByAccID() >> Crud 4 >> Acc Balance */
    //* >> accnoByAccid() >> Crud 5 >> List AccNo by AccID. */
    /**
     * ********** using row to manipulate data via SQL
     *
     ***********
     * @param idSA
     */
    public static BankAcc accRow(int idSA) throws Exception {
        LogUtil.IL.info(" Info Message From >> SavingAccDao.accInfo");
        Statement stmt = sqlConnect.init();
        BankAcc accInfo = null;
        String qStmt = "Select * from coreBanking.SA where idSA = " + idSA + ";";

        ResultSet rs = stmt.executeQuery(qStmt);
        while (rs.next()) {
            accInfo = (new BankAcc(
                    rs.getInt("idSA"),
                    rs.getString("accNo"),
                    rs.getDouble("balance"),
                    rs.getDouble("intRate"),
                    rs.getDate("accOpenDate").toLocalDate(),
                    //rs.getDate("accClosedDate").toLocalDate(),
                    rs.getDouble("minBal")
            ));
        }
        return accInfo;

    }

    //* >> updAcc() >> Crud 6 >> Update Account  */
    //* >> updBal() >> Crud 7 >> Update Balance  */
    public static boolean updateAcc(BankAcc s) throws Exception {
        Statement stmt = sqlConnect.init();

        //UPDATE `coreBanking`.`SA` SET `balance` = '3500', `intRate` = '0.0700',
        //`minBal` = '500' WHERE (`accNo` = '112-666-777-8');
        String updStmt = "Update coreBanking.SA set balance = " + s.getBalance()
                + ", intRate = " + s.getIntRate() + ", minBal = " + s.getMinBal()
                + " where (idSA = " + s.getIdSA() + ");";

        if (stmt.executeUpdate(updStmt) > 0) {
            System.out.println(" Update Success ");
        } else {
            System.out.println(" Update Failed ");
        }
        return true;
    }

    public static String getAccnoByID(int idSA) throws Exception {
        Statement stmt = sqlConnect.init();
        String accSNo = null;
        String qStmt = "Select accNo from coreBanking.SA where idSA = " + idSA + ";";
        ResultSet rs = stmt.executeQuery(qStmt);
        while (rs.next()) {
            accSNo = (new String(rs.getString("accNo")));
        }
        return accSNo;
    }

    //* >> listAllAcc() >> Crud 9 >> List all accounts details */
    public static List<BankAcc> listSA() throws Exception {
        Statement stmt = sqlConnect.init();

        List<BankAcc> saList = new ArrayList<>();
        String qStmt = "Select * from coreBanking.SA";

        ResultSet rs = stmt.executeQuery(qStmt);

        while (rs.next()) {
            saList.add(new BankAcc(
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

    public static void main(String[] args) throws Exception {

        System.out.println("First Part: " + BankAccDao.listSA().get(0));
        System.out.println("Secnd Part: " + BankAccDao.listSA().get(1));
        //SavingAccDao.listSA().stream().forEach(System.out::println);
        System.out.println("Account No by ID=1\t" + getAccnoByID(1));
    }
}
