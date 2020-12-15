* MW_HOME=\wls12214
* WLS_HOME = \wls12214\wlserver
* WL_HOME = \wls12214\wlserver
* JAVA_HOME = /Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/bin
* DOMAIN_HOME: /Users/antw/wls12214/domain1

antw@Mac-mini domain1 % . ./startWebLogic.sh

http://localhost:7001/console

### installation of software

    https://www.oracle.com/middleware/technologies/weblogic-server-installers-downloads.html

    https://www.oracle.com/java/technologies/oracle-java-archive-downloads.html

    https://www.oracle.com/database/technologies/appdev/jdbc-ucp-183-downloads.html

    https://netbeans.org/downloads/old/8.1/

    https://www.oracle.com/middleware/technologies/weblogic-server-installers-downloads.html 
        Generic Installer for Oracle WebLogic Server and Oracle Coherence

    Java SE 8 JDSK 8u211, NetBeanIDE 8.1

    https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html

    for mac-user, should have and run as such:
    1. Java SE Development Kit 8u211: jdk-8u211-macosx-x64.dmg
    2. NetBeans IDE 8.1: netbeans-8.1-javaee-macosy.dmg
    3. Oracle WebLogic Server: fmw_12.2.1.4.0_wls_lite_Disk1_1of1.zip
    fmw_12.2.1.4.0_wls_lite_generic.jar

Server install

    antw@Mac-mini fmw_12.2.1.4.0_wls_lite_Disk1_1of1 % /Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/bin/java -jar fmw_12.2.1.4.0_wls_lite_generic.jar   

    Launcher log file is /private/var/folders/x_/kc6ltsxd455gmxjn3b7lh87m0000gn/T/OraInstall2020-12-14_11-28-21AM/launcher2020-12-14_11-28-21AM.log.
      Extracting the installer . . . . . Done
      Checking if CPU speed is above 300 MHz.   Actual 3686.4 MHz    Passed
      Checking swap space: must be greater than 512 MB.   Actual 54137 MB    Passed
      Checking if this platform requires a 64-bit JVM.   Actual 64    Passed
      Checking temp space: must be greater than 300 MB.   Actual 54137 MB    Passed

wls12214, new folder

    antw@Mac-mini wls12214 % ls -l
    total 8
    drwxr-x---  19 antw  staff  608 Dec 14 11:44 OPatch
    drwxr-x---   7 antw  staff  224 Dec 14 11:44 coherence
    drwxr-x---  17 antw  staff  544 Dec 14 11:44 inventory
    -rw-r-----   1 antw  staff  127 Dec 14 11:44 oraInst.loc
    drwxr-x---  10 antw  staff  320 Dec 14 11:44 oracle_common
    drwxr-x---   9 antw  staff  288 Dec 14 11:44 oui
    drwxr-x---   8 antw  staff  256 Dec 14 11:44 wlserver
    antw@Mac-mini wls12214 % 

    antw@Mac-mini / % cd /Users/antw/wls12214/oracle_common/common/bin

    antw@Mac-mini bin % . ./config.sh

Oracle Fusuib Middlware

    Create a new domain
    Domain Locaiton: /Users/antw/wls12214/domain1
    next > next > next > next > next > next > finish

    antw@Mac-mini domain1% . ./startWebLogic.sh

Oracle WebLogic Server

DataSource > Generic Data Source > 
Create a New JDBC Data Source
    NameL ds1
    JNDI Namew: com.ubs.DS 
    <do not hit enter>
    Database Driver: *Oracle's Driver (Thin) for Service Connections; Versions: Any
    > next



#### Connected to Oracle SQL, VirtualBox
    database name: orcl
    Database User: hr
    Password: o.....

    https://www.oracle.com/database/technologies/appdev/jdbc-ucp-183-downloads.html 
    Driver: ojdbc8.jar

    Test Configuration =>> Connection test succeeded

     https://github.com/CohortOne/Java_EE/blob/main/ojdbc8.jar

#### Connected to mySQL ...

### trobleshoot Netbean 8.2
    antw@Mac-mini / % cd Applications/NetBeans/NetBeans\ 8.2\ RC.app/Contents/Resources/NetBeans/etc
    
    edit netbeans.conf via vim , add line 50:
        antw@Mac-mini etc % vim netbean.conf
    
    netbeans_jdkhome="/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home"


