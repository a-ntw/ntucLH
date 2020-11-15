* Practice 10-1: Creating a Modular Application from the Command Line
* Practice 10-2: Compiling Modules from the Command Line
* Practice 10-3: Creating a Modular Application from NetBeans
* Practice 10-4: Requiring a Module Transitively
* Practice 10-5: Beginning to Modularize an Older Java Application
* Practice 10-06: Creating and Optimizing a Custom Runtime Image by Using jlink
* Practice 10-7: Using NetBeans yo Create and Optimize a Runtime Image

#### Practice 10-1: Creating a Modular Application from the Command Line
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

#### Practice 10-2: Compiling Modules from the Command Line
``` console
antw@Mac-mini Prac10_01_ModularSystem % pwd
/Users/antw/ntuc/java2_Labs/Prac10_01_ModularSystem
antw@Mac-mini Prac10_01_ModularSystem % ls        
classes	mods	src
antw@Mac-mini Prac10_01_ModularSystem % rm -r mods
antw@Mac-mini Prac10_01_ModularSystem % ls
classes	src
antw@Mac-mini Prac10_01_ModularSystem % javac -d mods --module-source-path src $(find src -name "*.java")
antw@Mac-mini Prac10_01_ModularSystem % java -p mods -m hello/com.greeting.Main
Hello World

antw@Mac-mini Prac10_01_ModularSystem % cd src/hello
antw@Mac-mini hello % vim module-info.java
antw@Mac-mini hello % cat module-info.java
module test{

}
antw@Mac-mini hello % cd .. 
antw@Mac-mini src % cd ..
antw@Mac-mini Prac10_01_ModularSystem % javac -d mods --module-source-path src $(find src -name "*.java")
src/hello/module-info.java:1: error: module name test does not match expected name hello
module test{
       ^
src/hello/module-info.java:1: error: module name test does not match expected name hello
module test{
^
error: cannot access module-info
  cannot resolve modules
3 errors
antw@Mac-mini Prac10_01_ModularSystem % 
```

#### Practice 10-3: Creating a Modular Application from NetBeans

1. Opem NetBeans and create a new project for a modular Java application
- File > New Project > Java Modular Project
- Project Name: HelloNetBeans
- Project Location: ... java2_Labs/Prac_10_03_ModularSystem
2. Create the `hello` module within the project
- Right click on project > select New > Module
- Module Name: hello
- module-info class is automatically created
- package com.greeting within the hello module
- new Java Main Class within the com.greeting

Main.java
``` java
package com.greeting;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello NetBeans!");
    }
}
```
- output: Hello NetBeans!

- Create new module: people
- Create the package com.name within the people module
- new Java Class witnin the com.name

Names.java
``` java
package com.name;

public class Names {
    public static String getName(){
        return "Duke!";
    }
}
```
- Modify the module-info class of the people module
``` java
module people {
    exports com.name;
}
```
- Modify the module-info class of the hello module
``` java
module hello {
    requires people;
}

```
- Modify the main
``` java
package com.name;

public class Names {
    public static String getName(){
        return "Duke!";
    }
}
```
Output:
``` console
run:
Hello Duke!
BUILD SUCCESSFUL (total time: 0 seconds)
```

#### Practice 10-4: Requiring a Module Transitively

- Create a new module called `conversation`
- Create a package com.question within the conversation module
- Create a new Java Class within the com.question package.

Questions.java
``` java
package com.question;

public class Questions {
    public static String getQuestion() {
        return "How are you?";
    }
    
}
```
5. Append the returned String from callinf getQuestion() to the print statement in the main method.
Main.java
``` java
package com.greeting;

import com.question.Questions;
import com.name.Names;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello " +Names.getName() + " "
        + Questions.getQuestion());
    }
}
```
- Modify the module-info class of the conversation
module-info.java
``` java
module conversation {
    exports com.question;
}
```
- Modify the module-info class of the people require transitively
``` java
module people {
    exports com.name;
    requires transitive conversation;
}
```
output:
``` console
run:
Hello Duke! How are you?
BUILD SUCCESSFUL (total time: 0 seconds)

```

#### Practice 10-5: Beginning to Modularize an Older Java Application

Before 
``` console 
antw@Mac-mini Prac10_05 % ls -R
build.xml	manifest.mf	nbproject	src		test

./nbproject:
build-impl.xml		private			project.xml
genfiles.properties	project.properties

./nbproject/private:
private.properties

./src:
com

./src/com:
example

./src/com/example:
Main.java

./test:
antw@Mac-mini Prac10_05 % 
```
``` java
package com.example;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.info("HelloWorld App says hello!");
    }
    
}

```
---
- the program won't run because it doesn't yet recognize the Logger object type.
- import java.util.logging.Logger;
- Run the program, output:
``` console
run:
Nov 11, 2020 11:27:20 PM com.example.Main main
INFO: HelloWorld App says hello!
BUILD SUCCESSFUL (total time: 0 seconds)
```
- A simple wat to start modularizing the project is to introduce a module-info class into the default package.
- right click Source Packages folder > New > Other > Java Module Info > finish

module-info.java
``` java
module Prac10_05 {
    requires java.logging;
}
```
output
``` console
run:
Nov 11, 2020 11:31:40 PM com.example.Main main
INFO: HelloWorld App says hello!
BUILD SUCCESSFUL (total time: 0 seconds)
```

#### Practice 10-6: Creating and Optimizing a Custom Runtime Image by Using jlink
To creat a custom runtime image using the jlink tool
``` console
antw@Mac-mini Hello % jlink --module-path dist/Hello.jar:/usr/java/jdk-11.0.1/jmods --add-modules com.greeting --output myimage           
zsh: command not found: jlink                                        
antw@Mac-mini Hello %                                                
                          
```

- Open terminal and navigate to the Hello direcrory, for my case is Prac10_06_ModularSystem 
``` console
antw@Mac-mini Prac10_06_ModularSystem % /Library/Java/JavaVirtualMachines/jdk-11.0.8.jdk/Contents/Home/bin/jlink                                                        
Error: --output must be specified
Usage: jlink <options> --module-path <modulepath> --add-modules <module>[,<module>...]
Use --help for a list of possible options
antw@Mac-mini Prac10_06_ModularSystem % 
antw@Mac-mini Hello % /Library/Java/JavaVirtualMachines/jdk-11.0.8.jdk/Contents/Home/bin/jlink --module-path dist/Hello.jar:/usr/java/jdk-11.0.1/jmods --add-modules com.greeting --output myimage             
antw@Mac-mini Hello % ls -l                                          
total 16                                                             
drwxr-xr-x  6 antw  staff   192 Nov 15 13:46 build                   
-rw-r--r--  1 antw  staff  3527 Nov 13 23:47 build.xml               
drwxr-xr-x  4 antw  staff   128 Nov 15 13:46 dist                    
-rw-r--r--  1 antw  staff    82 Nov 13 23:47 manifest.mf             
drwxr-xr-x  8 antw  staff   256 Nov 15 14:37 myimage                 
drwxr-xr-x  7 antw  staff   224 Nov 13 23:47 nbproject               
drwxr-xr-x  4 antw  staff   128 Nov 13 23:49 src                     
drwxr-xr-x  2 antw  staff    64 Nov 13 23:51 test  
```
Check the runtime of the custom runtime image created
``` console
antw@Mac-mini Hello % cd myimage/                                    
antw@Mac-mini myimage % cd bin                                       
antw@Mac-mini bin % ./java -version                                  
java version "11.0.8" 2020-07-14 LTS                                 
Java(TM) SE Runtime Environment 18.9 (build 11.0.8+10-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.8+10-LTS, mixed mode)
antw@Mac-mini bin % ./java --list-modules                            
com.greeting
java.base@11.0.8
java.logging@11.0.8
antw@Mac-mini bin % 
```
the size of the JDK 11, and myimage
``` console
antw@Mac-mini bin % du -sh /usr/java/jdk-11.0.8                      
du: /usr/java/jdk-11.0.8: No such file or directory   // ????               
antw@Mac-mini bin % cd ..                                            
antw@Mac-mini myimage % du -sh                                       
 38M    .                                                            
antw@Mac-mini myimage %   
```
Execute the application, Hello
``` console
antw@Mac-mini myimage % cd bin                                       
antw@Mac-mini bin % ./java --module com.greeting                     
Nov 15, 2020 2:48:44 PM com.greeting.Main main                       
INFO: HelloWorld App says hello!                                     
antw@Mac-mini bin %    
```

#### Practice 10-7: Using NetBeans yo Create and Optimize a Runtime Image

Right-click the project and select Properties > Build > Packaging

Select Compress JAR, Build JAR, Creak JLINK, Launcher Name: Accept the default name, Strip Debug info, and OK. 

Right-click the project, and `Clean and Build`.

In NetBeans > Files > Hello/dist//jlink contains the custom runtime image, Hello

Check the modules
``` console
antw@Mac-mini Prac10_06_ModularSystem % cd /Users/antw/ntuc/java2_Labs/Prac10_06_ModularSystem/Hello/dist/jlink/Hello/bin 
antw@Mac-mini bin % ./java --list-modules  
com.greeting
java.base@11.0.8
java.logging@11.0.8
antw@Mac-mini bin %    
```

To run the application from the custom runtime image created.
``` console
antw@Mac-mini bin % ./java --list-modules                            
com.greeting                                                         
java.base@11.0.8                                                     
java.logging@11.0.8                                                  
antw@Mac-mini bin % ./java -m com.greeting                           
Nov 15, 2020 2:12:41 PM com.greeting.Main main                       
INFO: HelloWorld App says hello!  
```

#### 
