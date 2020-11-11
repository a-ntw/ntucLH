Practice 10-3: Creating a Modular Application from NetBeans

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
