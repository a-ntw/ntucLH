### Practices for Lesson 16: Understanding Modules
In these practices, you will explore how to create Java modular applications by using both the 
command line and NetBeans.

### Practice 16-1: Creating a Modular Application from the Command Line
In this practice, you create a simple single-class Java application and convert it to a modular 
application.


``` terminals
antw@Mac-mini 16_ModularSystem % cd Practices                                  
antw@Mac-mini Practices % ls                                                   
HelloNetBeans
antw@Mac-mini Practices % mkdir Prac_16_01_ModularSystem                       
antw@Mac-mini Practices % ls                                                   
HelloNetBeans                   Prac_16_01_ModularSystem
antw@Mac-mini Practices % cd Prac_16_01_ModularSystem  
antw@Mac-mini Prac_16_01_ModularSystem % mkdir -p src/com/greeting             
antw@Mac-mini Prac_16_01_ModularSystem % ls  
src
antw@Mac-mini Prac_16_01_ModularSystem % cd src/com/greeting  
antw@Mac-mini greeting % touch Main.java                                       
antw@Mac-mini greeting % gedit Main.java                                       
zsh: command not found: gedit
```
Main.java
``` java
package com.greeting;

public class Main {
   public static void main(String[] args) {
        System.out.println("Hello World!");
      } 
}
```
``` terminals
antw@Mac-mini greeting % cd ..                                                 
antw@Mac-mini com % cd ..                                                      
antw@Mac-mini src % cd ..                                                      
antw@Mac-mini Prac_16_01_ModularSystem % mkdir classes                         
antw@Mac-mini Prac_16_01_ModularSystem % javac -d classes src/com/greeting/Main.java   
antw@Mac-mini Prac_16_01_ModularSystem % tree                                  
zsh: command not found: tree   
antw@Mac-mini Prac_16_01_ModularSystem % java -cp classes com.greeting.Main    
Hello World!
```
Make this simple application a modular Java application.   
Move com to the hello directory
``` terminals
antw@Mac-mini Prac_16_01_ModularSystem % cd src                                
antw@Mac-mini src % mkdir hello                                                
antw@Mac-mini src % mv com hello                                               
antw@Mac-mini src % cd hello                                                   
antw@Mac-mini hello % touch module-info.java                                   
antw@Mac-mini hello %    
```
module-info.java
``` java
module hello {

}
```

``` terminal
antw@Mac-mini hello % cd ..                                                    
antw@Mac-mini src % cd ..  
antw@Mac-mini Prac_16_01_ModularSystem % pwd                                   
/Users/antw/ntuc/m8JavaSe1/D102470GC20_labs/16_ModularSystem/Practices/Prac_16_01_ModularSystem   
antw@Mac-mini Prac_16_01_ModularSystem % javac -d mods/hello src/hello/module-info.java src/hello/com/greeting/Main.java  
antw@Mac-mini Prac_16_01_ModularSystem % java -p mods -m hello/com.greeting.Main                        
Hello World!   
```
### Practice 16-2: Compiling Modules from the Command Line
In this practice, you see a shortcut to compile all modules at once. You don’t need to specify each individual module 
and class for compilation like you saw in the previous practice. For this shortcut to work, it’s important to name 
modules and their directories consistently.

1. Ensure that your terminal is open in the directory    
`~/labs/16_ModularSystem/Practices/Prac_16_01_ModularSystem.`

2. Delete your compiled code by removing the mods directory.    
`rm –r mods`

3. Compile all modules at once.
`javac -d mods --module-source-path src $(find src -name "*.java")`

Note: This automatically creates a directory that is the same as the name given in the module-info file.

4. Run the application. It should work.
`java -p mods -m hello/com.greeting.Main `

``` terminal
antw@Mac-mini Prac_16_01_ModularSystem % rm -r mods                                                     
antw@Mac-mini Prac_16_01_ModularSystem % javac -d mods --module-source-path src $(find src -name "*.java")                                                                                                      
                                                       
antw@Mac-mini Prac_16_01_ModularSystem % java -p mods -m hello/com.greeting.Main                       
Hello World!                                                                                            
antw@Mac-mini Prac_16_01_ModularSystem %  
```
### Practice 16-3: Creating a Modular Application from NetBeans

In this practice, you create a modular Java application using NetBeans. You’ll begin seeing how modules 
read from each other and how NetBeans allows you to compile many modules at once.

console
```
run:
Hello Duke!
BUILD SUCCESSFUL (total time: 0 seconds)
```
HelloNetBeans/hello/classes/com.greeting/Main.java
``` java
package com.greeting;

import com.name.Names;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello NetBeans!");
        System.out.println("Hello " + Names.getName());
    }
    
}

```

HelloNetBeans/people/come.name/Names.java
``` java
package com.name;

public class Names {
          public static String getName(){
               return "Duke!";
          }
}
```
dir tree
```
v HelloNetBeans 
      v hello
          v classes
              v <default package>
                    module-info.java
              v com.greeting/Main.java
                    Main.java
      v people
          v classes
              v <default package>
                    module-info.java
              v come.name
                    Names.java
```
