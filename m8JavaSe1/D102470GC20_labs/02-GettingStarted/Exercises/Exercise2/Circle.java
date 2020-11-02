/* Copyright © 2018 Oracle and/or its affiliates. All rights reserved. */

public class Test {
  public static void main(String args[]) {
    double area = Circle.findArea(7.5);
    System.out.print("Area of circle=" +area);
  }  
}  

public class Circle {   
  public static double findArea(double radius){
    return Math.PI * radius * radius;
  } 
}
