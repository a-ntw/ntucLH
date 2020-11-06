``` java
package packageName;
import packageName.subPackageName.ClassName;

[modifier] class ClassName [extends ParentClass] [implements interface1, interface2, .....] {
    /*fields*/
    [modifier] datatype varID [=value] ;
    
    /*method*/
    [modifier] returntype methodName( [datatype argID1, ..., datatype argIDn ]){
    }

    /*constructor*/
    [modifier] ClassName( [datatype argID1, ..., datatype argIDn ]){
          this(arg1, ..., argN); 
    }

    [modifier] ClassName( [datatype argID1, ..., datatype argIDn ]){ 
        super(arg1, ..., argN); 
        //necessary to explicitly call parent's constructor if parent's constructor have arguments at least 1
      }
      
      /*main method*/
      public static void main(String[] args) {
          if (booleanExpression) {
              //action
              } else {
              //action 
              }
                datatype varID2;
                varID2 = (booleanExpression) ? valueIfTrue: valueIfFalse ;

    //multistep approach
    datatype[] varIDArr1;
    varIDArr1 = new datatype[length];
        datatype[] varIDArr2 = new datatype[length]; varIDArr1[index] = value;
    
    //singlestep approach
    datatype[] varIDArr3 = {value1, ...., valueN };
    
    //get value from array
    //standard for loop
    for (index initialization; booleanExpression; index updater){
        //action for e.g. varIDArr3[index]; 
    }
    
    //for-each loop / enhanced for loop
    for (elementdatatype varValue: arrayName ){
        //action 
    }
    
    //catch exception
    try{
        //code that may throw checked exception
    } catch (ExceptionType e){
       //action to handle the exception
    }
  } 
}
----

/*interface extends interfaces*/
public interface InterfaceName extends interface1, ..., interfaceN {
}
-----
modifier:
1. class: public, default
2. fields and methods: public, protected, default, private, static, final
--------------

/*Polymorphism*/ 
e.g. public class CurrentAccount extends Account { }
CurrentAccount is a CurrentAccount --> CurrentAccount ca = new CurrentAccount();
CurrentAccount is an Account      --> Account acc = new SavingCurrent();
CurrentAccount is an Object (java.lang.Object) --> Object o = new CurrentAccount();
```
