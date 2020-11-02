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
        if (custType == NONPROFIT){
            if (total > 900){
                discount = 10.00;
            }else discount = 5.00;
        }else if (custType == PRIVATE){
            if (total > 900){
                discount = 7.00;
            }else discount = 0;
        }else if (custType == CORP){
            if (total < 500){
                discount = 8.00;
            }else discount = 5.00;
        }        
    }
}
