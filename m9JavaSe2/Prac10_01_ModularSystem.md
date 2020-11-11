Practice 10-1: Creating a Modular Application from the Command Line
``` console
antw@Mac-mini java2_Labs % ls
BankingApp9Nov2020	BankingAppicationMaven
antw@Mac-mini java2_Labs % mkdir Prac10_01_ModularSystem
antw@Mac-mini java2_Labs % cd Prac10_01_ModularSystem
antw@Mac-mini Prac10_01_ModularSystem % ls
antw@Mac-mini Prac10_01_ModularSystem % mkdir -p src/com/greeting
antw@Mac-mini Prac10_01_ModularSystem % cd src/com/greeting
antw@Mac-mini greeting % touch Main.java
```
antw@Mac-mini greeting % cat Main.java
``` java
package com.greeting;

public class Main {
    public static void main(String[] args) {
      System.out.println("Hello World");
    }
}

```
``` console
antw@Mac-mini greeting % cd ../../..
antw@Mac-mini Prac10_01_ModularSystem % mkdir classes
antw@Mac-mini Prac10_01_ModularSystem % javac -d classes src/com/greeting/Main.java
antw@Mac-mini Prac10_01_ModularSystem % ls -R
classes	src

./classes:
com

./classes/com:
greeting

./classes/com/greeting:
Main.class

./src:
com

./src/com:
greeting

./src/com/greeting:
Main.java
antw@Mac-mini Prac10_01_ModularSystem % java -cp classes com.greeting.Main
Hello World
antw@Mac-mini Prac10_01_ModularSystem % 

```
8 . Make this simple application a modular java application
``` console
antw@Mac-mini Prac10_01_ModularSystem % cd src
antw@Mac-mini src % mkdir hello
antw@Mac-mini src % mv com hello
antw@Mac-mini src % cd ..
antw@Mac-mini Prac10_01_ModularSystem % ls -R
classes	src

./classes:
com

./classes/com:
greeting

./classes/com/greeting:
Main.class

./src:
hello

./src/hello:
com

./src/hello/com:
greeting

./src/hello/com/greeting:
Main.java

antw@Mac-mini Prac10_01_ModularSystem % ls
classes	src
antw@Mac-mini Prac10_01_ModularSystem % cd src/hello
antw@Mac-mini hello % touch module-info.java
antw@Mac-mini hello % vim module-info.java 
```
antw@Mac-mini hello % vim module-info.java 
``` java
module hello{

}
```

``` console
antw@Mac-mini hello % cd ../..
antw@Mac-mini Prac10_01_ModularSystem % javac -d mods/hello src/hello/module-info.java src/hello/com/greeting/Main.java
antw@Mac-mini Prac10_01_ModularSystem % ls -R
classes	mods	src

./classes:
com

./classes/com:
greeting

./classes/com/greeting:
Main.class

./mods:
hello

./mods/hello:
com			module-info.class

./mods/hello/com:
greeting

./mods/hello/com/greeting:
Main.class

./src:
hello

./src/hello:
com			module-info.java

./src/hello/com:
greeting

./src/hello/com/greeting:
Main.java
antw@Mac-mini Prac10_01_ModularSystem % java -p mods -m hello/com.greeting.Main
Hello World
antw@Mac-mini Prac10_01_ModularSystem % 
```
