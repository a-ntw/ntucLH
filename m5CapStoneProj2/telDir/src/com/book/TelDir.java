/*
Projects for today afternoon session
====================================
==================================================================================

Write a java Application to build Telephone Directory 
	* ability to add new entries
	* modify entries
	* delete entries
	* zipCode to areaCode mapping [enums - zipCode, areaCode ]
	* record Bill Amounts [enums - dail number, duration, charge amount] 
 */
package com.book;

public class TelDir {

    private int accNo;
    private String accType;
    private float totalCharge;

    enum CodeType {
        ZIP_CODE("ZIP"),
        AREA_CODE("ARE");

        private final String coType;

        CodeType(String aType) {
            this.coType = aType;
        }

        String shortCode() {
            return coType;
        }
    }

    enum billAccount {
        DAIL_NUMBER("50050050"),
        CHARGE_DURATION("0"),
        CHARGE_AMOUNT("10");

        private final String balAmt;

        billAccount(String aType) {
            this.balAmt = aType;
        }

        String minBalance() {
            return balAmt;
        }
    }

    // Constructor - which helps me build an Object 
    public TelDir(String at, float tc) {
        accType = at;
        totalCharge = tc;
        // TODO !!!!
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(" CodeType ");

        for (CodeType cName : CodeType.values()) {
            System.out.print(cName + "    ");
        }
        for (billAccount cName : billAccount.values()) {
            System.out.print(cName + "    ");
        }
    }
}
/*
run:
 CodeType 
ZIP_CODE    AREA_CODE    DAIL_NUMBER    CHARGE_DURATION    CHARGE_AMOUNT    BUILD SUCCESSFUL (total time: 0 seconds)

*/