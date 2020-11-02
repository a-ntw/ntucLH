/* Copyright © 2018 Oracle and/or its affiliates. All rights reserved. */

package exercise_13_1;

import java.util.ArrayList;

public class TestClass {

    public static void main(String[] args) {
        //As a local variable
        String name = "Dan Smith";
        System.out.println("Hello " + name);

        //As a reference to a collection
        ArrayList cities = new ArrayList<String>();
        cities.add("Chicago");
        cities.add("Bangalore");
        cities.add("SanFrancisco");

        System.out.println("********** As iteration variable in enhanced for-loop ***************");
        for (Object object : cities) {
            System.out.println(object);
        }

        System.out.println("********** As looping index in for-loop ***************");
        for (int i = 0; i < cities.size(); i++) {
            String object = (String) cities.get(i);
            System.out.println(object);
        }

        System.out.println("********** As a return value from another method ***************");
        int num = testMethod();
        System.out.println("value returned from method " + num);

    }

    //As a return value in a method
    public static int testMethod() {
        int value = 12;
        return value;
    }
}
