
### Creating JAR from Spring

In STS, right-click the project and select ‘Run As’ - Maven Build

Run As > 5 Maven Build >  Goals, enter `package`, the word `package`

The rest leave as default, then click Run


### Running this JAR file


This Jar file at the project folder /target/<filename>.jar
eg. Log_Sample-001-SNAPPSHOT.jar 31.2MB

Run in Terminal
`java -jar <filename.jar>`

run as such, which also output to browser, localhost:8082
```
antw@Mac-mini target % java -version
java version "11.0.8" 2020-07-14 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.8+10-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.8+10-LTS, mixed mode)

antw@Mac-mini target % java -jar Log-Sample-001-SNAPSHOT.jar --server.port=8082
``` 

**Ctrl-C**› in Terminal to quit the running. 