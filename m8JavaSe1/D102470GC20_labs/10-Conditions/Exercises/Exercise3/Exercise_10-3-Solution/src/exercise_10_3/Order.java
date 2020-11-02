/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */

package exercise_10_3;

public class Order {
    static final char CORP = 'C';
    static final char PRIVATE = 'P';
    static final char NONPROFIT = 'N';
    String name, stateCode;
    double total, discount;
    char custType;

    public Order(String name, double total, String state, char custType) {
        this.name = name;
        this.total = total;
        this.stateCode = state;
        this.custType = custType;
        calcDiscount();
    }
    
    public String getDiscount(){
        return Double.toString(discount) + "%";
    }

    // Code the calcDiscount method.
    final void calcDiscount() {
        // Replace the if logic with a switch statement.
        switch(custType){
            case NONPROFIT:
                discount = (total > 900)? 10.00 : 5.00;
                break;
            case PRIVATE:
                discount = (total > 900)? 7.00 : 0;
                break;
            case (CORP):
                discount = (total < 500)? 8.00 : 5.00;
                break;
            default:
                System.out.println("Invalid custType");
        }         
    }
}
