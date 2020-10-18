package com.book;

import java.util.*;

class PhoneContacts {

    String name;
    String lName;
    String fName;
    String mName;
    ///.....
}

public class myArrayList {

    public static void main(String args[]) {
        //Contacts App - Java 6/8 
        ArrayList<PhoneContacts> listOfContacts = new ArrayList();
        listOfContacts.add(new PhoneContacts());

        ArrayList<String> aList = null;
        aList = new ArrayList();

        aList.add("One");
        aList.add("Two");
        aList.add("Three");
        aList.add(1, "Four");
        aList.add("Five");

        System.out.println(" Size of the Array " + aList.size());
        //   System.out.println(" Array List String values are " + aList);

        aList.add("Six");
        aList.add("Seven");
        aList.add("Eight");
        aList.add(1, "Nine");
        aList.add("Ten");
        System.out.println(" Size of the Array " + aList.size());
        System.out.println(" Array List String values are " + aList);

        System.out.println(" Get Fifth Element of the ArrayList " + aList.get(5));

        for (String aVal : aList) {
            System.out.print(" :: " + aVal);
        }
        System.out.println(" Sorted Array List ");
        Collections.sort(aList);
        for (String aVal : aList) {
            System.out.print(" :: " + aVal);
        }

        List<String> aList1 = aList.subList(2, 6);
        System.out.println(" Sub List ");

        for (String aVal : aList1) {
            System.out.print(" :: " + aVal);
        }

        aList1.clear();

    }
}

/*
run:
 Size of the Array 5
 Size of the Array 10
 Array List String values are [One, Nine, Four, Two, Three, Five, Six, Seven, Eight, Ten]
 Get Fifth Element of the ArrayList Five
 :: One :: Nine :: Four :: Two :: Three :: Five :: Six :: Seven :: Eight :: Ten Sorted Array List 
 :: Eight :: Five :: Four :: Nine :: One :: Seven :: Six :: Ten :: Three :: Two Sub List 
 :: Four :: Nine :: One :: SevenBUILD SUCCESSFUL (total time: 0 seconds)
*/