file: Oracle SQL Project 2

``` sql
### Project
From Savari Uvakaram to Everyone: (2:05 PM)
 create table regions
(region_id number constraint regions_region_id_pk primary key,
region_name varchar2(25))

From Savari Uvakaram to Everyone: (2:23 PM)
 Set the default value for hire_date in emplyees table to sysdate 
Salary in employees table must be between 1000 and 50000 

From Savari Uvakaram to Everyone: (2:43 PM)
 Spelling mistake on table JOB_HISTORY. Please correct it

From Savari Uvakaram to Everyone: (2:55 PM)
 select constraint_name, constraint_type
 from user_constraints
 where table_name='COUNTRIES’ 
Try to name constraint with meaningful name <tablename>_<column_name>_<constraint_type> Constraint type PK, UK, NN, FK, CK

From Savari Uvakaram to Everyone: (3:11 PM)
 alter table t1 rename constraint  abc to xyz 

From Savari Uvakaram to Everyone: (3:23 PM)
 select constraint_name, column_name 
from user_cons_columns
 where table_name=‘T1'

select a.constraint_name, a.constraint_type, b.column_name
from user_constraints a, user_cons_columns b
where a.constraint_name=b.constraint_name

From Savari Uvakaram to Everyone: (5:30 PM)
 select table_name, read_only
 from user_tables 
where table_name='ABC’;
 —————————
object names in data dictionary are upper case 
```
#### select object_name, object_type from user_objects;
``` sql
SQL> conn savari1/savari1
Connected.
SQL> set pages 24
SQL> select object_name, object_type
  2  from user_objects;

no rows selected

SQL> show user 
USER is “SAVARI1"
```
#### job_grades
``` sql
SQL> create table job_grades
  2  (grade_level varchar2(3) constraint job_grades_id_pk primary key,
  3  lowest_sal number,
  4  highest_sal number)
  5   

SQL> save pJobGradesT  
```
#### regions
``` sql
create table regions 
	(region_id number constraint region_id_pk primary key, 
	region_name varchar2(25)) 
/ 

 SQL> save pregionT 
``` sql
#### countries
``` sql
  1  create table countries
  2  (country_id char(2) constraint countries_id_pk primary key,
  3  country_name varchar2(40),
  4  region_id number constraint couuntries_region_id_fk
  5* references regions(region_id) on delete set null)

SQL> save pcountriesT
``` sql
#### locations
``` sql
  1  create table locations
  2  (location_id number constraint location_id_pk primary key,
  3  street_address varchar2(40),
  4  postal_code varchar2(12),
  5  city varchar2(30) not null,
  6  state_province varchar2(25),
  7  country_id char(2) constraint country_id_fk
  8* references countries(country_id) on delete set null)

SQL> save plocationsT
``` sql
#### departments
``` sql
  1  create table departments
  2  (department_id number(4) constraint department_id_pk primary key,
  3  department_name varchar2(30) not null,
  4  manager_id number(6),
  5  location_id number(4) constraint location_id_fk
  6* references locations(location_id) on delete set null)

SQL> save pdepartmentsT
``` sql
#### jobs
``` sql
  1  create table jobs
  2  (job_id varchar2(10) constraint job_id_pk primary key,
  3  job_title varchar2(25),
  4  min_salary number(6),
  5* max_salary number(6))

SQL> save pjobsT
``` sql
#### employees
``` sql
create table employees
(employee_id number(6) constraint employee_id_pk primary key,
first_name varchar2(20),
last_name varchar2(25) NOT NULL,
email varchar2(25) NOT NULL,
phone_number varchar2(20),
hire_date date NOT NULL,
job_id varchar2(10) constraint job_id_fk NOT NULL
        references jobs(job_id) on delete set null,
salary number(8,2),
commission_pct number(2,2),
manager_id number(6),
department_id number(4) constraint department_id_fk
        references departments(department_id) on delete set null
)
/

SQL> save pemployeesT
``` sql
#### job_history
``` sql
  1  create table job_history
  2  (employee_id number(6) NOT NULL,
  3  start_date date NOT NULL,
  4  end_date date NOT NULL,
  5  job_id varchar2(10) constraint job_hisId_fk NOT NULL
  6  	references jobs(job_id) on delete set null,
  7  department_id number(4) constraint department_hisId_fk
  8* 	references departments(department_id) on delete set null)

SQL> save pjobhistoryT replace

Others

check constraint

  1  select constraint_name, column_name
  2  from user_cons_columns
  3* where table_name='EMPLOYEES'
SQL> /
``` sql
#### alter
``` sql
SQL> alter table employees
  2  modify hire_date date default sysdate;

  1  alter table employees
  2  modify salary number(8,2) constraint empsalary_ck check(salary
  3* 	between 1000 AND 50000)
SQL> /

SQL> alter table jobs
  2  modify job_title varchar2(35);

``` sql
#### insert
``` sql
insert into regions values ( &id, '&na')

insert into countries values ('&code', '&Name', &id)


``` sql
#### Duplicate table with data
``` sql
SQL> create table empTemp as select * from employees;

Table created.

SQL> select * from empTemp;

```

Create a view to display the employee_id, fisrt_name, last_name, salary from employees table
``` sqj
   1 create view v1 
 2 as 
 3 select employee_id, first_name, last_name, salary
 4* from employees 
SQL> save pempv1 Created file pempv1.sql 

SQL> conn sys/oracle as sysdba
Connected.
SQL> grant connect, resource to savari1;

Grant succeeded.

SQL> grant create view to savari1;

Grant succeeded.

SQL> conn savari1/savari1
Connected.
SQL> @pempv1

View created.

SQL> select * from v1;
```
Create another view to display the first_name, last_name, salary, department_name (complex view- view based on multiple tables)


Create the following table in your schema. Name the table DEPT
``` sql
SQL> ed
Wrote file afiedt.buf

  1  create table dept
  2  (id NUmber(7) Primary Key,
  3* Name varchar2(25) unique)
SQL> /

Table created.

insert into dept values (&id, '&name')
SQL> select * from dept; 

	ID NAME
---------- -------------------------
	 1 One
	 2 Two
	 3 Three
	 4 four
	 5 Five

SQL> 

SQL> update dept set Name = 'NoFive'
  2  where id = 5;

SQL> l
  1* select * from dept
SQL> 
SQL> delete dept where id = 6;

1 row deleted.

SQL> select count(*) from dept;

  COUNT(*)
----------
	 5
SQL> commit;             

Commit complete.

```
