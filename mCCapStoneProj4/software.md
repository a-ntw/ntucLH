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
#### ed f1    clear screen  err col
	SQL> ed f1
	    >> go to vim editor
	SQL> @f1

	SQL> def_editor=gedit		>> to change noteeditor

	SQL> cle screen

	SQL> show err
		Errors for TRIGGER TRIG1:

	SQL> clear col 		>> to set back default column width
	SQL> col Manager format a30;
	SQL> set lines 120;
	SQL> set verify off
 
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
----------------------
day 3
#### merge
``` sql
SQL> merge into t1
	2 using t2
	3 on(t1.c1=t2.c1)
	4 when matched then
	5	update set t1.c2 = 1000
	6 when not matched then
	7 	insert values (t2.c1,t2.c2);

SQL> select * from t1;	
SQL> rollback;  — only on ddl command
```
### synonym
``` sql
SQL> conn / as sysdba
SQL> grant create synonym to safari;
SQL> conn safari/savari
SQL> create synonym e for employees;
SQL> desc e
SQL> select first_name  from e;

SQL> create table sav_emp
	2 As
	3 select * from employees;

SQL> conn savari/savari
SQL> grant select, insert, update, delete on save_emp to savari1;
SQL> conn savari1/savari1
SQL> select first_name  from savari.sav_emp;

SQL> conn / as sysdba
SQL> grant create synonym to savari1;
SQL> conn savari1/savari1
SQL> create synonym emp  for savari.sav_emp;

SQL> select first_name  from emp;

SQL> drop synonym emp;
```
#### plus sign(+) to display detail table
``` sql
select e.first_name, e_salary, e.department_id, d.department_name
from employees e, departments d
Where e.department_id = d.department_id(+)
  
SQL> conn savari1/savari1
SQL> create synonym e  for savari.employees;
Synonym created.
```
##### show all synonym
``` sql
SQL> show user
SQL> select object_name, object_type
	2 from user_objects
	3 where object_type=’SYNONYM’
```
#### desc user_synonyms
``` sql
SQL> desc user_synonyms
SQL>  select synonym_name, table_owner, table_name
	2 from user_synonyms;

SQL> desc user_tables;
```
### views
``` sql
SQL> conn savari/savari
SQL> create view v1
	2 as
	3 select * from employees;

SQL> create view v2
	2 as
	3 Select first_name, last_name, salary, department_name
	4 from employees join departments
	5 using(department_id);
View created.

SQL> set lines 120

SQL>  create view v3( sumsal, minsal, maxsal, avgsal)
	2 as
	3 select sum(salary), min(salary), max(salary), round(avg(salary))
	4 from employees
SQL> desc v3
SQL> select * from v3;

SQL> grant select on v2 to savari1;
SQL> conn savari1/savari1
SQL> select * from savari.v2;
SQL> create synonym v2 from savari.v2;
SQL> select * from v2;
 
SQL> drop view v1;
SQL> create v1
	2 as
	2 select * from employees;

SQL>  update v1 set salary =100;

SQL> select salary from v1;
SQL> rollback;
SQL> desc user_views

SQL> show long
SQL> set long 10000
```

### index, execution plan
```
SQL> select rownum, first_name, salary
from employees;
```
#### fetch next 5 row 
``` sql
  1  select first_name, last_name, salary
  2  from employees
  3  order by salary desc
  4* fetch next 5 row only
SQL> /

FIRST_NAME	     LAST_NAME			   SALARY
-------------------- ------------------------- ----------
Steven		     King			    24000
Neena		     Kochhar			    17000
Lex		     De Haan			    17000
Michael 	     Hartstein			    13000
Shelley 	     Higgins			    12000

```
``` sql
SQL> select first_name, last_name, salary
 from (select first_name, last_name, salary from employees order by salary desc)
 where rownum < 6;

SQL> select first_name, rowid
	2 from employees;
— noted that rowid will change
— rowid got base64 digit: a-z A-Z 0-9 / +
— 6363, first 6 digits are object ID, next 3 digits file id, 
— next 6 digits block Id, lst 3 digits are rowid
```
####  select index_name, index_type
``` sql
SQL> create table emp1
	as
	select * from employees;

SQL> select index_name, index_type
	2 from user_indexes
	3 where table_name = ‘EMP1’;

SQL> create index idx1
	2 on emp1(first_name);

SQL> drop index idx1;
```
### plustrace, autot,  execution plan
```
SQL> set autot on
	SP2-0618: .. Check PLUSTRACE ...
	SP2-0611: ERROR ...
SQL> set autot off
SQL> select * from session_roles;

SQL> conn sys/oracle as sysdba

SQL> @/u01/app/oracle/product/version/db_1/sqlplus/admin/plustrce.sql
SQL> drop role plustrace;
drop role plustrace
         *
ERROR at line 1:
ORA-01919: role 'PLUSTRACE' does not exist
SQL> create role plustrace;
Role created.
SQL> grant select on v_$sesstat to plustrace;
Grant succeeded.
SQL> grant select on v_$statname to plustrace;
Grant succeeded.
SQL> grant select on v_$mystat to plustrace;
Grant succeeded.
SQL> grant plustrace to dba with admin option;
Grant succeeded.
SQL> 
SQL> set echo of

SQL> grant plustrace to mickey; ;
Grant succeeded.

SQL> conn mickey/mickey
Connected.
SQL> set autot on
SQL> select first_name, last_name, salary from emp1
  2  where first_name='Steven';

FIRST_NAME	     LAST_NAME			   SALARY
-------------------- ------------------------- ----------
Steven		     King			    24000


Execution Plan
----------------------------------------------------------
Plan hash value: 2226897347

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |	 |     1 |    19 |     3   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| EMP1 |     1 |    19 |     3   (0)| 00:00:01 |
--------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------
   1 - filter("FIRST_NAME"='Steven')

Statistics
----------------------------------------------------------
	 87  recursive calls
	  0  db block gets
	 80  consistent gets
	  9  physical reads
	  0  redo size
	720  bytes sent via SQL*Net to client
	434  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  5  sorts (memory)
	  0  sorts (disk)
	  1  rows processed

SQL> set autoT off
```
```
— show the execution plan
SQL> save f13

SQL>  create index idex1 on emp1 (first_name);
SQL> @f13

hr/hr
Execution PLan show the button on the SQL Developer too
if 'phisical read' very high will be very slow.
Ideally ‘physical read’ should be 0, which all will be in memory.

SQL>  drop index idex1;
```
---------------
day 4
``` 
PROJECT 

From savari:
```
### UNDO. Flashback for Enpterprise edition:
``` sql
SQL> update employees
2 set salary=100;

SQL> select to_char(sysdate, ‘dd/mm/rr hh24:mi:ss’)
from dual

10/12/20 09:17:18

SQL> update emp set salary = 100;
SQL>  commit;  — <<< make a mistake
SQL> flashback table emp
	2 to timestamp to_timestamp(’10–12-20 9:17:18’, ‘dd-mm-rr hh24:mi:ss’);
ERROR … cannot flashback the table becuase row movement is not enabled
SQL> save f16;
SQL> alter table emp enable row movement; — give permission from oracle to change row ID
SQL> get f16
Flashback complete.

SQL> conn / as sysdba
SQL> show parameter undo
SQL>   — retention = 900 —> for period of 900sec.
SQL> alter system set undo_retention=20000;  — set longer
— cannot go thru flashback thru DDL command, sush as create, truncate, drop
— there is only 1 undo space, will be overwrite by 1 transaction.

SQL> alter system checkpoint;  — <<< ???
```
### administration of dba
``` sql
SQL> select flashback_on from v$database
SQL> archive log list
SQL> select log_mode from v$database;
SQL> shutdown immediate  — <<<all memory release ..
SQL> startup mount
SQL> alter database archive log;
SQL> select open_mode from v$database;
SQL> alter database open;
SQL> select open_mode from v$database;
```
### sid is instance name
``` sql
SQL> conn sys/oracle as sysdba

SQL> select instance_name from v$instance;
INSTANCE_NAME: orclcdb

SQL> select name from v$database;
NAME: ORCLCDB

1 dabast assess by mupliple instances.
RAC - real application cluster
Load balancing
```
### user id
``` sql
SQL> hr/hr
SQL> grant select, insert on employees to public;
Grant succeeded.

— create object in schema belong to user
```

	C:\Users\User>sqlplus hr/hr@prod1  —<<. in any where
	SQL> conn hr/hr	 —<< in your local machine


Others
``` sql
SQL> drop table dept;
SQL>  create table dept
2 (id number,
3 name varchar2(10));
SQL> create sequence seq1
2 start with 200
3 increment by 10
4 maxvalue 10000;
SQL>  insert into dept
2 values(seq1.nextval, ’Sales’);
SQL> commit;
SQL> select * from dept;
id: 200  Name:Sales
SQL> select seq1.currval from dual;
currval: 200
SQL> select id, seq1.currval
SQL> select seq1.nextval from dual;
```
### sequence loader, txt file
#### create empty table
``` sql
	SQL> create table loademp
	as
	Select first_name, last_name, salary, department_id
	From employees
	Where 1=2;   —<< structure only, no data
```
#### set verify, head, feed, pages, spool off
``` sql
SQL>  set verify off
SQL> set head off
SQL> set feed off
SQL> set pages 0
SQL> spool d:\emp.dat
SQL> select first_name || ‘,' || last_name || ‘,‘ ||salary|| ‘,‘ || department_id
2 from employees;
…
SQL> spool off
— from d: drive > emp.dat from Notepad++
File save emp_data.dat
```
Notepad
```
load data
infile 'd:\emp_data.dat'
insert into table loademp
fields terminated by ‘,’
(First_name, last_name, salary, department_id)
```
save as emp.ctl

	D:\>sqlldr
	D:\sqlldr userid=hr/hr control=emp.ctl.txt

revise bad data
```
load data
infile 'd:\emp_data.bad'
append into table loademp
fields terminated by ‘,’
(First_name, last_name, salary, department_id)
```
From Savari Uvakaram to Everyone: (11:51 AM)

	load data
	infile 'd:\emp_data.bad'
	append into table loademp
	fields terminated by ','
	(first_name,last_name, salary,department_id)

From Sri Ram Panday to Everyone: (12:06 PM)

	C:\> lsnrctl status
	C:\> lsnrctl start
From Kiat Leong Chua to Everyone: (12:23 PM)

	https://stackoverflow.com/questions/26236967/oracle-listener-not-running-and-wont-sta

Others

	SQL> create table t1
	(id number,
	name varchar2(10)l
	gender char(1) contrraint t1-gender_ck check(gender in (“M”, “F”));
	/
	SQL> desc user_cons_columns
	SQL> select constraint_name, table, column_name 
	from user_cons_columns
	where table_name=’T1’;

	SQL> select table_name
	from dict
	Where table_name like ‘%CONS%'

### check  constraint condition

	SQL> select constraint_name, search_condition
	from user_constraints
	where table_name=’T1’;

SQL> drop user cascade

	SQL> create table emp as select * from employees;
	SQL>  create table dept as select * from departments;
	— — noted that all consitions, PK, FK... are mot copied

	SQL> select constraint_name, constraint_type
	from user_constraints
	where table_name = ‘DEPT’;

### Connection issues

	D:\>lsnrctl
	LSNRCTL> help
	LSNRCTL> stat

	tnsnames.ora

	D:\>sqlplus hr/hr@orcl
	D:\>netca

	[oracle@localhost oracle]$ lsnrctl status listener


ipconfig

	c:\Windows\system21> ping 58.182.132.17
if work than can connect...

#### check for erro ?

	SQL> 
	Rr ora 12560
	D:\>oerr ora 12560

#### uninstall

	universal uninstaller

	dbhome_2 > deinstall.bat


### create empty table

	SQL> create table empty_emp
	As 
	Select * from employees
	Where 1=2;
	
### employees%rowtype
``` sql
set verify off
declare
	emp_rec		employees%rowtype;
	….
begin
end;
```

---

