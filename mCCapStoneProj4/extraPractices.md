.LOG mCCS4 extra questions
wk1 dec10

Extra Questions
-------------------------------------------------

1)  Create index on first_name and another index on last_name (EMPLOYEES table)
####  Create index
```SQL
    /* create index idx on employees(first_name) */
    SQL> create index idx2
     2 on employees(first_name, last_name)
        Index created.
    
    SQL> select index_name, index_type
     2  from user_indexes
     3  where table_name = 'EMPLOYEES';
  
    SQL> col index_name format a30
    SQL> @e1

    INDEX_NAME		       INDEX_TYPE
    ------------------------------ ---------------------------
    EMP_EMAIL_UK		       NORMAL
    EMP_EMP_ID_PK		       NORMAL
    EMP_DEPARTMENT_IX	       NORMAL
    EMP_JOB_IX		       NORMAL
    EMP_MANAGER_IX		       NORMAL
    EMP_NAME_IX		       NORMAL
    IDX2			       NORMAL

    7 rows selected.

    SQL> 
```

2)  Create a sequence to generate department id in DEPARTMENTS table. 
    Start with 200 and increment by 10 and maximum value 10000. Insert a row in the
    DEPARTMENTS table using the sequence and confirm the insert.
#### create sequence
    create sequence seq1
    start with 200
    increment by 10
    maxvalue 10000
    
    SQL> save e2 replace
    Wrote file e2.sql
    SQL> @e2
        Sequence created.

    SQL> insert into dept
      2  values(seq1.nextval, 'Sales');
        1 row created.

    SQL> select * from dept;
    SQL> select seq1.nextval from dept;
    SQL> select seq1.currval from dual;


3)  Update the salary of any one employee by 10%. Input the employee id at runtime

4)  Make a copy of your EMPLOYEES table to MYEMP table. Give all the privileges to
    your first user.
### create full table w privs
    SQL> create table myemp as select * from employees;
        Table created.
    SQL> select count(*) from myemp;

    SQL> conn sys/oracle as sysdba
        Connected.
    SQL> grant connect, resource to savari1;
        Grant succeeded.

    SQL> conn savari1/savari1
        Connected.
    SQL> show user
        USER is "SAVARI1"
    SQL> select * from session_privs;

5)  Connect to your first user and ensure you can access the MYEMP table

6)  While connected to first user, create a synonym for MYEMP table.Insert a new row
    using the synonym and confirm the row added.
#### create synonym    

    SQL> conn sys/oracle as sysdba
        Connected.
    SQL> grant create synonym to savari1;
        Grant succeeded.

    SQL> conn savari1/savari1
        Connected.
    SQL> create synonym d for dept;
        Synonym created.
    SQL> insert into d values(7,'Seven')
        1 row created.

    SQL> create synonym e for employees;
        Synonym created.
    SQL> desc e
          1* grant select, insert, update, delete on myemp to savari1

    SQL> create synonym synemp for myemp;
        Synonym created.
    SQL> select synonym_name, table_owner, table_name
      2  from user_synonyms;


7)  Change the precision of first_name and last_name in the EMPLOYEES table to 50 characters

8)  Display the first_name, last_name, salary, department_name, and grade of all the
    employees

9)  Create a view to display first_name, last_name, salary, job_id, department_name,
    City, and country_name. Query the view and confirm the output


10) Create another table :

        customer_id        number       (PK)
        cust_first_name    varchar2     (NN)
        cust_last_name     varchar2     (NN)
        cust_address       varchar2
        phone_number       varchar2
        cust_email         varchar2
        credit_limit       number       Between 0 and 100000      
        date_of_birth      date        
        marital_status     varchar2
        gender             char(1)      Only 'M' or 'F'
        acc_mgr_id         number       (FK)  - Primary key is employee_id in EMPLOYEES table


11) export all the data from HR schema and import it in the tables you have created.
    You have to import it from one user to another user
    Ignore the create error. Check if the tables contain your data and the inported one

—
From Savari Uvakaram to Everyone: (2:22 PM)
 After finishing all the exercises, create a new user and import all the objects from HR schema
THis new user will be used for PL/SQL practices

#### Create new user
``` sql
      create user newuser
      identified by newuser
      default tablespace users
      temporary tablespace temp
      quota unlimited on users
    SQL> /

    User created.
    SQL> conn sys/oracle as sysdba
        Connected.
    SQL> grant connect, resource to newuser;
    SQL> grant connect, resource, create view, create synonym to newuser;
        Grant succeeded.
```
#### export all data from hr
[oracle@localhost oracle]$ exp

    Username: hr
    Password: 

    Connected to: Oracle Database 19c Enterprise Edition Release 19.0.0.0.0
    Enter array fetch buffer size: 4096 > 
    Export file: expdat.dmp > hr_full.dmp
    (2)U(sers), or (3)T(ables): (2)U > 2
    Export grants (yes/no): yes > 
    Export table data (yes/no): yes > 
    Compress extents (yes/no): yes > 
...
#### import all data to new user
[oracle@localhost oracle]$ imp

    Username: newuser
    Password: 

    Import data only (yes/no): no > 
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
...

    IMP-00003: ORACLE error 1031 encountered
    ORA-01031: insufficient privileges
    About to enable constraints...
    Import terminated successfully with warnings.
    
[[oracle@localhost oracle]$ sqlplus sys/oracle as sysdba

    SQL> conn newuser/newuser
        Connected.
    SQL> select table_name from user_tables;
    
#### SQL Developer: new connection

    SQL Developer: new connection
        Name: newuser_conn
        Username: newuser
        Password: newuser
        Service name: oracle

SQL> @ ?? /home/oracle/Desktop/ntucLH/[del_data.sql](#del_data.sql)

### PlSql
From Savari Uvakaram to Everyone: (4:58 PM)
    - duplicate employees table into EMP table
    - add a column in EMP (new_salary)

    -  Query f_n, l_n, salary, department_id (EMP table)
    -  Input employee id at runtime

    -  if salary <5000 then  increase salary by 18%
    -  if salary >=5000 and less than 10000  increase by 12%
    -   if salary >=10000 and <16000  increase by 8%
    -  if salary >= 16000 no increment
    -   update EMP table with new salary value
    -   Diplay on screen f_n, l_n, salary, and new salary

#### create full table
    QL> drop table emp;
        Table dropped.
    SQL> create table emp as select * from employees;
        Table created.
    SQL> select count(*) from emp;

    SQL> alter table emp
    2 add new_salary number(9,2);
    SQL> select first_name, salarym new_salary
    from emp;
    SQL> ed f18
#### f18 using elsIf, exception, &&empid
``` sql
set serveroutput on
set verify off
declare
    f_name      emp.first_name%type;
    l_name      emp.last_name%type;
    v_sal       emp.salary%type;
    v_deptid    emp.department_id%type;
    v_newsal    emp.salary%type;
    
begin
    select first_name, last_name, salary, department_id
    into f_name, l_name, v_sal, v_deptid
    from emp
    where employee_id = &&empid;
   
       IF v_sal < 5000  THEN
       v_newsal := v_sal * 1.18;
    ELSIF v_sal >= 5000 AND v_sal < 10000 THEN
        v_newsal := v_sal * 1.12;
    ELSIF v_sal >=10000 and v_sal < 16000 THEN
        v_newsal := v_sal *1.08;
    END IF;
 
    update emp
    set new_salary = v_newsal
    where employee_id = &empid;
    dbms_output.put_line( f_name || ' ' || l_name || ' '
        || to_char(v_sal) || to_char(v_newsal));

   exception
        when no_data_found then
            dbms_output.put_line('No employee selected.Check with HR');
        
end;
/
set serveroutput off
set verify on
undef empid
```
console
```
Steven King 24000

PL/SQL procedure successfully completed.
```

Question 11. Create a function that takes a manager ID and return the names of employees who report to this manager. The names must be returned as a string with comma separating names

#### function for employee and manager
From Savari Uvakaram to Everyone: (5:47 PM)
get_employees
``` sql
 create or replace function get_employees(manager in number) return clob
is
   v_employees clob := '';
   cursor emp_cur is
      select  first_name from employees 
      where   manager_id = manager;
begin

     for emp_rec in emp_cur
     loop
         v_employees :=  v_employees ||  ',' || emp_rec.first_name;
     end loop;
    return  ltrim(v_employees,',');
end;
/ 
```
plQ11.sql
``` sql
begin
        for emp_rec in emp_cur
        loop
                v_employees := v_employees || ',' || emp_rec.first_name;
        end loop;
        return ltrim(v_employees,',');
end;
/

set serveroutput on
set verify off
begin
        dbms_output.put_line(get_employees(&mr_id));
end;

set serveroutput off
set verify on
```
console
```
Function GET_EMPLOYEES compiled

Lex,Michael,Neena,Kevin,Eleni

PL/SQL procedure successfully completed.
```
```
/* sql
col employee format a30;
col Manager format a30;

select  e.manager_id,
        e.first_name ||' '|| e.last_name employee,
        m.first_name ||' '|| m.last_name manager
from employees e join employees m
on (e.manager_id = m.employee_id);
*/

```
#### Q11 Procedure in plSql
procedure upd_emp_sal()
``` sql
create or replace procedure upd_emp_sal (v_sal in employees.salary%type,
v_newsal out employees.salary%type) is
begin
        IF v_sal < 5000  THEN
           v_newsal := v_sal * 1.18;
        ELSIF v_sal < 10000 THEN
            v_newsal := v_sal * 1.12;
        ELSIF v_sal >=10000 and v_sal < 16000 THEN
            v_newsal := v_sal *1.08;
        END IF;
    end;
/
```
f19.sql
``` sql
set serveroutput on
declare
    f_name      emp.first_name%type;
    l_name      emp.last_name%type;
    v_sal       emp.salary%type;
    v_deptid    emp.department_id%type;
    v_newsal    emp.salary%type;
    
    cursor      emp_cursor IS
        select first_name, last_name, salary, department_id
        from emp
        for update;

begin
    OPEN emp_cursor;
    LOOP
        fetch emp_cursor into f_name, l_name, v_sal, v_deptid;
        EXIT WHEN emp_cursor%NOTFOUND;
        
        upd_emp_sal(v_sal, v_newsal);

        update emp
        set new_salary = v_newsal
        where current of emp_cursor;
        dbms_output.put_line( f_name || ' ' || l_name || ' '
            || to_char(v_sal) ||' '|| to_char(v_newsal));

    END LOOP;
    CLOSE emp_cursor;
end;
/
set serveroutput off

/*
select salary, new_salary from emp;
update emp set new_salary = null;
*/

```
console
```
PL/SQL procedure successfully completed.

20 rows updated.

Steven King 24000 
Neena Kochhar 17000 
Lex De Haan 17000 
Alexander Hunold 9000 10080
Bruce Ernst 6000 6720
Diana Lorentz 4200 4956
...
William Gietz 8300 9296

PL/SQL procedure successfully completed.

```
