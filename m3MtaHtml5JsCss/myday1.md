From NetBean:
- New File ... > Other > Java File
- File Name: HelloWorld2
- Folder: /User/antw/myjava
- > Finish
- edit the file
- ctrl-S to save
- right-click > Run FIle


on Terminal
``` java
public class HelloWorld {

       public static void main(String [] args){
           System.out.println(" Hello World !!!");
       }
}

```

``` terminal
    antw@Mac-mini myjava % javac HiWorld.java
    antw@Mac-mini myjava % java HiWorld
    Hi World :)
    antw@Mac-mini myjava % 
```

### javap
antw@Mac-mini m3w1cp2Java % ls
HelloWorld2.class	HelloWorld2.java
antw@Mac-mini m3w1cp2Java % javap HelloWorld2.class
Compiled from "HelloWorld2.java"
public class HelloWorld2 {
  public HelloWorld2();
  public static void main(java.lang.String[]);
}


``` terminal
antw@Mac-mini m3w1cp2Java % jshell
|  Welcome to JShell -- Version 11.0.8
|  For an introduction type: /help intro

jshell> "Hello World !"
$1 ==> "Hello World !"

jshell> 98
$2 ==> 98

jshell> 17
$3 ==> 17

jshell> $2 % $3
$5 ==> 13

jshell> for(int i = 0; i <= 10; i++)
   ...> 


jshell> /help
|  Type a Java language expression, statement, or declaration.

```
