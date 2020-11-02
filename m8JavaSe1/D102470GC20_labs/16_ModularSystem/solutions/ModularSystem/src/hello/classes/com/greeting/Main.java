/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package com.greeting;

import com.question.Questions;
import com.name.Names;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello " +Names.getName() +" " +Questions.getQuestion());
    }
}