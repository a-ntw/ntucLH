Practice 10-5: Beginning to Modularize an Older Java Application

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
