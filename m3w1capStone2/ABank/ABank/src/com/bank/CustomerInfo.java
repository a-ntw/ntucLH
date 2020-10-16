/* main: ABank.java */
package com.bank;

public enum CustomerInfo {
    //    //Customer: Name, AccCount No,  minimum balance
    CUSTOMER_NAME("CN"),
    ACCOUNT_NO("AC"),
    MINIMUM_BALANCE("MB"),
    ACCOUNT_TYPE("AT");

    String cCode;

    CustomerInfo(String code) {
        cCode = code;
    }

    public String CustomerInfo() {
        return cCode;
    }
}
