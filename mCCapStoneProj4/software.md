week1

### To install java 12c


 1. Go to START. 

2. Click on OracleDB12Home1. > I use Window8's command prompt > c:\orac;e12c> dbca, 

3. Click on Database Configuration Assistant.

4. Select Database Operation - select Create a Database.

5. Database Creation Mode - Select Advanced configuration.

6. Database Deployment Type - 
      --> Database type: Oracle Single Instance 
      --> Template name: General Purpose or Transaction Processing

7. Specify Database Identification Details -
      --> Global database name : prod.oracle.com
      --> SID: prod
      --> UNCHECK Create a Container Database

8. Select Database Storage Option - No change.

9. Select Fast Recovery Option - Don't select anything.

10. Specify Network Configuration Details -
       --> CHECK Create a new listener
           --> Listener name: LISTENER1
           --> Listener port: 1522

11. Specify Configuration Options - 
       --> At Memory Tab
          --> Set SGA size = 1000
          --> Set PGA size = 400
       --> At Sample Schemas Tan
          --> CHECK Add sample schemas to the database 
From Sri Ram Panday to Everyone: (12:46 PM)
 12. Specify Management Options - 
         --> UNCHECK Configure Enterprise Manager (EM) database express

13. Specify Database User Credentials
       --> CHECK Use the same administrative password for all accounts
          --> Password: oracle_4U
          --> Confirm Password: oracle_4U

14. Select Database Creation Option - No change

15. Summary - Click Finish

On window, to stop from previous oracle, search for ’services’, and change to manual mode

Others:
    c:\Users\Users>set oracle_sid=prod1
    c:\Users\Users>sqlplus / as sysdba

    D:\app\tohch\virtual\product\12.2.0\dbhome_1\bin>sqlplus
    Enter user-name: / as sysdba

Others:
``` sql
    SQL> conn system/oracle_4U
    SQL> show user
    USER is "SYSTEM"
    SQL> conn / as sysdba
    Connected.
    
    SQL> conn hr/hr@prod
    
    SQL> alter user savari
      2  identified by savari1
      3  ;
```


### mac virtual machine

#### to start sql
```
[oracle@localhost oracle]$ sqlplus sys/oracle as sysdba
```
#### To check any others users

    SQL> conn sys/oracle as sysdba

    SQL> select username from dba_users;


To create new user
``` sql
SQL> conn sys/oracle as sysdba
SQL>  create user savari1
      identified by savari1
      default tablespace users
      temporary tablespace temp
      quota unlimited on users
      password expire;

User created.
```
grant connection, resource, view for users
```
SQL> grant connect, resource to savari;

Grant succeeded.

SQL> grant create view to dockey;

Grant succeeded.

```

conn to user
``` sql
SQL> conn savari/savari
SQL> show user
USER is "savari"
```

[oracle@localhost oracle]$ sqlplus hr/oracle

    SQL> select table_name
      2  from user_tables;
  
   Conn system/oracle 

``` sql
SQL> conn sys/oracle as sysdba
Connected.
SQL> show user
USER is "SYS"
SQL> select * 
  2  from session_privs;

```
#### show user privilege
``` sql
SQL> conn mickey/mickey
Connected.
SQL> show user 
USER is "MICKEY"
SQL> select *
  2  from session_privs;

PRIVILEGE
----------------------------------------
CREATE SESSION
CREATE TABLE
CREATE CLUSTER
CREATE VIEW
CREATE SEQUENCE
CREATE PROCEDURE
CREATE TRIGGER
CREATE TYPE
CREATE OPERATOR
CREATE INDEXTYPE
SET CONTAINER

11 rows selected.

SQL> 

```
Others
``` sql
SQL> alter user hr identified by hr account unlock;

SQL> revoke create session from dockey;

SQL> create sequence s1;

SQL> conn dockey/dockey
Connected.
SQL> create sequence s1;

Sequence created.

SQL> create table t1
  2  (c1 number);

Table created.

SQL> create view v1
  2  as 
  3  select *
  4  from t1;
view created.
            
SQL> select name
  2  from v$database;
from v$database
     *
ERROR at line 2:
ORA-00942: table or view does not exist

```


### To set connection in Mac's virtualBox SQL Developer 
    sqlDeveloper =>
    Name: hr
    Username hr
    Password: oracle
    Service name: orcl

    sqlDeveloper =>
    Name: savari
    Username savari
    Password: savari
    Service name: orcl

for windows

    sqlDeveloper =>
    Name: hr
    Username hr
    Password: hr
    SID: prod
    
---

    SQL> conn hr/oracle
    Connected.
    SQL> show user
    USER is "HR"
    SQL> select table_name
      2  from user_tables;

    SQL> select count(*)
      2  from emp;

