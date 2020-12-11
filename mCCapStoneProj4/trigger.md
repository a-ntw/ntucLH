### TRIGGER
SQL> conn newuser/newuser
Connected.

SQL> drop table emp1;

Table dropped.

SQL> drop table audit_emp;

Table dropped.

SQL> show user
USER is "NEWUSER"
#### SQL> create table emp1
  2  as select first_name, last_name, salary, job_id, department_id
  3  from employees;

Table created.

#### SQL> desc emp1
 Name					   Null?    Type
 ----------------------------------------- -------- ----------------------------
 FIRST_NAME					    VARCHAR2(20)
 LAST_NAME				   NOT NULL VARCHAR2(25)
 SALARY 					    NUMBER(8,2)
 JOB_ID 				   NOT NULL VARCHAR2(10)
 DEPARTMENT_ID					    NUMBER(4)


#### create table audit_emp
``` sql
create table audit_emp
(userid         varchar2(10),
trans_date      timestamp,
emp_name        varchar2(10),
inserts number,
updates number,
deletes number,
old_salary number(9,2),
new_salary number(9,2))
/
```

#### SQL> desc audit_emp

   Name					   Null?    Type
   -------------------------------------------
   USERID 					    VARCHAR2(10)
   TRANS_DATE					    TIMESTAMP(6)
   EMP_NAME					    VARCHAR2(10)
   INSERTS					    NUMBER
   UPDATES					    NUMBER
   DELETES					    NUMBER
   OLD_SALARY					    NUMBER(9,2)
   NEW_SALARY					    NUMBER(9,2)

SQL> 
```
SQL> conn sys/oracle as sysdba
Connected.
  1* grant select, insert, update, delete on newuser.emp1 to newuser
SQL> /

Grant succeeded.
SQL> conn newuser/newuser
Connected.
SQL> @trig

Trigger created.

SQL> insert into emp1
  2  values('savari','Uvak',2000,'Manager',20);

1 row created.

SQL> col trans_date format a30
SQL> set lines 120
SQL> select * from audit_emp;

USERID	   TRANS_DATE			  EMP_NAME	INSERTS    UPDATES    DELETES OLD_SALARY NEW_SALARY
---------- ------------------------------ ---------- ---------- ---------- ---------- ---------- ----------
NEWUSER    11-DEC-20 05.18.02.000000 AM   savariUvak	      1 	 0	    0		       2000

SQL> update newuser.emp1 set salary=3333 where first_name='savari';

1 row updated.

SQL> select * from audit_emp;

USERID	   TRANS_DATE			  EMP_NAME	INSERTS    UPDATES    DELETES OLD_SALARY NEW_SALARY
---------- ------------------------------ ---------- ---------- ---------- ---------- ---------- ----------
NEWUSER    11-DEC-20 05.18.02.000000 AM   savariUvak	      1 	 0	    0		       2000
NEWUSER    11-DEC-20 05.21.19.000000 AM   savariUvak	      0 	 1	    0	    2000       3333

SQL> 







