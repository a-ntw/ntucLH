package com.ubs;

//User Defined Exception 

public class MinBalanceEx extends Exception {

    /**
     * Creates a new instance of <code>MinBalanceEx</code> without detail
     * message.
     */
    public MinBalanceEx() {
    }

    /**
     * Constructs an instance of <code>MinBalanceEx</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MinBalanceEx(String msg) {
        super(msg);
    }
}
