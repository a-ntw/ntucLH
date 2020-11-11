Practice 10-02: Compiling Modules from the Command Line
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
