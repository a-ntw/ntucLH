day1

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
use
## sqlplus sys/oracle as sysdba
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

### select table_name from user_tables
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

others

    SQL> conn hr/oracle
    Connected.
    SQL> show user
    USER is "HR"
    SQL> select table_name
      2  from user_tables;

    SQL> select count(*)
      2  from emp;

---


day2
#### create new connection for system and sys at SQL Developer
For windows:

      Connection: sys_connection
      Username sys
      Password: oracle_4U
      Role: STSDBA
      Port: 1522
      SID: pord1

For my Mac:

      Connection: sys_connection
      Username sys
      Password: oracle
      Role: STSDBA
      Port: 1521
      Service name: oral

Window’s user; if got error, use prompt:

      c:/Users/User>sqlplus / as sysdba
      SQL> alter user sys indentified by oracle_4U

Connection Name: system_connection

      Username: system
      Passeword: oracle_4U
      Role: default
      Port: 1522
      SID: pord1

Form system_connection:

      select username
      from dba_users

SQL> conn savari/savari

      Connected.
      SQL> l
        1  select table_name
        2* from user_tables
      SQL> /
      
 ### SQL Commands     
 #### SQL commands for l, 1, c, i, /, del
 for select line `1`, change `c`, insert `i`, execute `/`, delete last line `del`
 
      SQL> l
        1  select first_name, last_name, selary
        2* from employees
      SQL> 1
        1* select first_name, last_name, selary
      SQL> c/selary/salary/
        1* select first_name, last_name, salary
      SQL> i
        3  where salary > 10000
        4  
      SQL> l
        1  select first_name, last_name, salary
        2  from employees
        3* where salary > 10000
      SQL> /

      SQL> del

#### SQL commands for save, cl buff, get, @f1, save
for save file, clear `cl buff`, get f1, run file @f1, save f1 replace, 

      SQL> l
        1  select first_name
        2* from employees
      SQL> save f1
            Created file f1.sql
      SQL> cl buff
            buffer cleared
      SQL> l
            SP2-0223: No lines in SQL buffer.
      SQL> get f1
        1  select first_name
        2* from employees
      SQL> cl buff
            buffer cleared
      SQL> @f1
      
      SQL> save f1 replace
            Wrote file f1.sql
      
#### host, exit
      SQL> host
                  >> go out to host command
      [oracle@localhost ~]$ dir
      [oracle@localhost ~]$ exit
      exit
      SQL> !
                  >> same as host, for linux
      [oracle@localhost ~]$ exit
      exit
#### ed f1    clear screen  
      SQL> ed f1
            >> go to vim editor
      SQL> @f1

      SQL> def_editor=gedit		>> to change noteeditor

      SQL> cle screen

 
### `exp` `imp` 
#### export to hr_full.dmp
      [oracle@localhost ~]$ exp 

      Username: hr
      Password: oracle

            Connected to: Oracle Database 19c Enterprise Edition Release 19.0.0.0.0
      Enter array fetch buffer size: 4096 > 
      Export file: expdat.dmp > hr_full.dmp
      (2)U(sers), or (3)T(ables): (2)U > 2
      Export grants (yes/no): yes > 
      Export table data (yes/no): yes > 
      Compress extents (yes/no): yes > 
            Export done 
      [oracle@localhost ~]$ ls

#### import from hr_full.dmp
      [oracle@localhost ~]$ imp

      Username: mickey
      Password: mickey

            Connected to: Oracle Database 19c Enterprise Edition Release 19.0.0.0.0
      Import data only (yes/no): no > no
      Import file: expdat.dmp > hr_full.dmp
      Enter insert buffer size (minimum is 8192) 30720> 
            Export file created by EXPORT:V19.00.00 via conventional path
            Warning: the objects were exported by HR, not by you
            import done in US7ASCII character set and AL16UTF16 NCHAR character set
            import server uses AL32UTF8 character set (possible charset conversion)
      List contents of import file only (yes/no): no > 
      Ignore create error due to object existence (yes/no): no > 
      Import grants (yes/no): yes > 
      Import table data (yes/no): yes > 
      Import entire export file (yes/no): no > yes

SQL> conn mickey/mickey

      SQL> select table_name
        2  from user_tables;
      SQL> select count(*)
        2  from employees;
        
#### sqlplus/sqldeveloper
	SQL
		DQL
		DDL
		DML
		DCL
		Trans Control
	SQLPlus
		desc
		set
		show col
	PL/SQL

revision for last week sql
#### to_number(100), 'S__v%'

  1  select first_name
  2  from employees
  3* where employee_id=to_number('100')
  
  1  select first_name fname, last_name lname, salary
  2  from employees
  3* where first_name like 'S__v%'  

#### to off there `&` verification
      SQL> set verify off
      SQL> def deptid
      SQL> Undef detpid
#### &&deptid, pages
      SQL> select first_name, last_name, salary
        2  from employees
        3  where department_id=&&deptid;
      Enter value for deptid: 70 
      
      SQL> show pages
      pagesize 14
      SQL> set pages 24
      SQL> 
#### to_date, sysdate, dual
      1  select first_name, salary
      2  from employees
      3* where hire_date=to_date('17/06/87','dd/mm/rr')
  
      SQL> select sysdate
        2  from dual;
      
      SQL> select user 
        2  from dual;

      SQL> select to_char(sysdate, 'fmddspth Month Year pm')
        2  from dual;

### select, from, where, group by, having, order by
``` sql
        select first_name, last_name, salary
        from employees JOIN departments
        USING (department_id)
        JOIN locations
        USING (location_id)
        JOIN countries
        USING (country_id)
        WHERE country_name='Canada'

      SQL> @f3
```
#### constraint
``` sql
      drop table detail
      /

      drop table master
      /

      create table master
      (id number constraint master_id_pk primary key,
      name            varchar2(10),
      location        varchar2(10))
      /


      create table detail
      (empid number constraint detail_empid_pk primary key,
      name    varchar2(10),
      job     varchar2(10),
      salary  number(9,2),
      deptid number constraint detail_deptid_fk 
            references master(id) on delete set null)
      /
```
      create table t1
      (c1 number,
      c2 number,
      c3 number, constraint t1_c1_c2_pk primary key (c1,c2))
      /

      create table t3
      (id number,
      name varchar2(10),
      region varchar2(10) constraint t3_region_ch check (region in ('North','South')))
      /

constraint_name, ???? 

      select constraint_name, constraint_type
      from user_constraints
      where constraint_name='SYS_C007443'
      /

``` sql
create table t4
(id number,
name varchar2(10),
region varchar2(10) constraint t3_region_pk primary key
constraint t3_region_ck check (region in ('North','South')))
/
```
      SQL> drop table t4;

      Table dropped.

      SQL> @f6

others

      SQL> col constraint_name format a30
      
      SQL> drop table master cascade constraints;

#### Subquery are not great performance
``` sql
select first_name, last_name, salary
from employees
where department_id IN (
        select department_id
        from departments
        where  location_id IN (
                select location_id
                from locations
                where  country_id IN (
                        select country_id
                        from countries
                        where country_name = 'Canada')))
/
```
#### NULL
 `NOT IN` & `IN`, results are the same
``` sql
SELECT employee_id
FROM employees
WHERE commission_pct NOT IN (
select commission_pct from employees where employee_id = 100);

SELECT employee_id
FROM employees
WHERE commission_pct IN (
select commission_pct from employees where employee_id = 100);
```
``` console
no rows selected
no rows selected
```
