Practice 10-7: Using NetBeans yo Create and Optimize a Runtime Image

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
```

KIV
