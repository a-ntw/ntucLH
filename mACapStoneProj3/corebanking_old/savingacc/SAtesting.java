/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savingacc;

import java.time.LocalDate;
import static java.time.LocalDate.now;

public class SAtesting {

    public static void main(String[] args) throws Exception {

         SavingAccDao.listSA().stream().forEach(System.out::println);       
        
//        double intRate = 0.0752342424;
//        String s = String.format("%.3f", intRate);
//        System.out.println("s = " + s);

        //int idSA = 11;
//        String AccNo = "112-666-777-9";
//        double balance = 3000;
//        double intRate = 0.075;
//        LocalDate accOpenDate = now();
//        //LocalDate accOpenDate = LocalDate.parse("2000-10-02");
//        LocalDate accClosedDate = null; // not necessayr
//        double minBal = 200;
//
//        int nxtID = SavingAccDao.getNextID();
//
//        System.out.println("==== S A Testing ====== ");
//        
//        SavingAccDao.insertSAacc(new SavingAcc(nxtID, AccNo, balance,
//                intRate, accOpenDate, accClosedDate, minBal));



    }
}
