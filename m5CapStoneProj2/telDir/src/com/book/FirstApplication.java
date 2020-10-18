package com.book;

class FirstApplication {

    private static String direction = "steering ..."; // only within appli
    //private String areaLocation; // dont serve SecondAppl
    static String areaLocation; // allow SecondApplication
    //String loginMethods; // dont work for SecondApplication
    static String loginMethods; // Work for SecondAppl

    { // Instance Initializer
        if (areaLocation.equals("North")) {
            loginMethods = "loging using North Control";
        }
        if (areaLocation.equals("East")) {
            loginMethods = "loging using East Control";
        }
    }

    // System.out.println(" Direction ");  // unable to print
    static {
        System.out.println(" Direction " + direction);
    }
}

class SecondApplication {
    //public String loginMethods = "South Control";  // unable to call static
    static String loginMethods = "South Control"; // call within scope

    static {
        String loginMethods = "West Control"; // serve no purpose
        FirstApplication.areaLocation = "North";
        FirstApplication northGate = new FirstApplication();
        System.out.println(" North Logic " + FirstApplication.loginMethods);
    }

    {
        loginMethods = "West Control"; // serve no purpose
    }

    public static void main(String args[]) {

        FirstApplication.areaLocation = "East";
        FirstApplication eastGate = new FirstApplication();
        System.out.println(" East Logic " + FirstApplication.loginMethods);

        FirstApplication.areaLocation = "South";
        FirstApplication southGate = new FirstApplication();
        System.out.println(" South Logic " + loginMethods);

        loginMethods = "West Control"; // local scope
        FirstApplication.areaLocation = "West";
        FirstApplication westGate = new FirstApplication();
        System.out.println(" West Logic " + loginMethods);
    }
}
/*
run:
 Direction steering ...
 North Logic loging using North Control
 East Logic loging using East Control
 South Logic South Control
 West Logic West Control
BUILD SUCCESSFUL (total time: 0 seconds)

*/