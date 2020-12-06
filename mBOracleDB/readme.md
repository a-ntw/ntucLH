

Assessment

Part 1, Q1

---
Part 2, Q1
``` sql
/*
The HR department needs a report of employees in Toronto. 
Display the employee 
name with format “last name/first name”, job description, department number, 
and department name for all employees who work in Toronto.

Write sql statement to create the required report.
*/

SELECT  e.last_name || ' ' || e.first_name employee,
        j.job_title as "Job Description",
        d.department_id "Department Number",
        d.department_name "Department Name"
FROM    employees e JOIN jobs j
    ON      ( e.job_id  = j.job_id) 
    JOIN    departments d
    ON      (e.department_id =  d.department_id)
    JOIN    locations l
    ON (d.location_id = l.location_id)
WHERE   l.state_province  = 'Toronto';



/*
desc employees;
desc locations;
desc departments;
select * From locations
order by state_province;
*/
```
---
Part 2, Q2
``` sql
/****    Q 2          ***/

/*
Write sql statement to display 
the manager number and 
the salary of the lowest-paid employee 
for that manager. 

Exclude anyone whose manager is not known. 

Exclude any departments where the minimum salary is $5,500 or less. 

Sort the output in descending order of salary.
*/

select manager_id, MIN(salary) Minimum
from employees
WHERE (department_id, salary) IN  
      (SELECT department_id, MIN(salary)
       FROM employees
       GROUP BY department_id)
GROUP BY    manager_id 
HAVING      MIN(salary) > 5500 
AND         manager_id IS NOT NULL 
ORDER BY    Minimum desc ;

/* console
100	17000
205	8300
148	6100
201	6000
*/

/*
select employee_id, manager_id, department_id, salary
from employees
--WHERE manager_id = 201 OR manager_id = 148 OR manager_id = 205;
WHERE department_id >= 60 AND  department_id <= 110;

desc employees;
*/
```
---
Part 2, Q3
``` sql
/*
Practical Performance 3

Write insert statement to insert new hire with following information:
*/


INSERT INTO     employees (first_name, last_name, email, job_id, 
                department_id, salary, commission_pct, manager_id)
VALUES  ('Jane', 'Doe', 'Jane.Doe@mail.com', 
        (SELECT job_id FROM jobs WHERE job_title = 'IT_PROG'), 
        (SELECT department_id FROM departments WHERE department_name = 'IT'), 
        5000, NULL,
        (SELECT manager_id FROM employees WHERE last_name = 'Higgins') );




desc employees;
```
---
Part 2, Q4
``` sql
/*
Practical Performance 4

Amend salary of existing employee, where his id is 113, 
to increase based on following condition:

If he has commission, then increase by 5%
If he has no commission, then increase by 10%
*/
/*

UPDATE cities 
set population = population * 1.2
    WHERE region IS NOT NULL AND cityid = 3;
*/

/* NVL2 (expr1, expr2, expr3)
    If expr1 is not null, NVL2 returns expr2.
    If expr1 is null, NVL2 return expr3.
    ref: 5-23*/


UPDATE  employees
SET     salary = NVL2(commission_pct, salary * 1.05, salary * 1.1)
WHERE   employee_id =  113;


/*
desc employees;

SELECT last_name, salary, commission_pct
FROM employees
WHERE employee_id =  113;

*/

```
---
Part 2, Q5
``` sql

SET SERVEROUTPUT ON

BEGIN
    DBMS_OUTPUT.PUT_LINE(' Hello World ');
    dbms_output.put_line(' Hello World ');
END;

/*
Practical Performance 5

Write PL/SQL block to list down employee’s first and last name, 
hire date, salary and annual salary.

Annual salary for employee:

without commission will be “salary * 12”
with commission will be “(salary + commission) * 12
*/


set serveroutput on;

declare
    v_fName varchar2(50);
    v_lName varchar2(50);
    v_hireDate DATE;
    v_salary NUMBER;
    v_annualSal NUMBER;
    
begin
   select first_name, last_name, hire_date, salary,
   NVL2(commission_pct, (salary * (1+ commission_pct)), (salary * 12) ) 
   into v_fName, v_lname, v_hireDate, v_salary,v_annualSal
   from employees where employee_id = 100;
   dbms_output.put_line(
   v_fName || ' ' || v_lname || ' joined on '
   || v_hireDate || '. Monthly salary is ' || v_salary 
   || ' and annual salary is ' || v_annualSal || '.');
end;
/


/*
desc employees;

SELECT last_name, salary, commission_pct, 
NVL2(commission_pct, (salary * (1+ commission_pct)), (salary * 12) ) AnnualSal
FROM employees
WHERE employee_id =  100; --113;

*/
```
---
Part 2, Q6
``` sql
/*
After employee table creation:

Add commission column with data type Number and precision 2 and scale 2.
Make dept_id as foreign key with reference table to department and 
reference column to department.ID.
Submit the statement of table creation, table alteration and display 
the structure of Employee and Department tables.
*/

DROP TABLE Department;
DROP TABLE Employee;

create table Department
(   dept_id      number(7)       primary key,
    name    varchar2(25)    not null
);

create table Employee
(   emp_id          number(7)       primary key,
    last_name   varchar2(25)    not null,
    first_name  varchar2(25)    not null,
    dept_id     number(7)    null
);


ALTER TABLE     Employee
    ADD commission NUMBER(4,2)
    ADD foreign key(dept_id) references Department(dept_id);


desc Department;

desc Employee;

/* console

Table DEPARTMENT dropped.


Table EMPLOYEE dropped.


Table DEPARTMENT created.


Table EMPLOYEE created.


Table EMPLOYEE altered.

Name    Null?    Type         
------- -------- ------------ 
DEPT_ID NOT NULL NUMBER(7)    
NAME    NOT NULL VARCHAR2(25) 
Name       Null?    Type         
---------- -------- ------------ 
EMP_ID     NOT NULL NUMBER(7)    
LAST_NAME  NOT NULL VARCHAR2(25) 
FIRST_NAME NOT NULL VARCHAR2(25) 
DEPT_ID             NUMBER(7)    
COMMISSION          NUMBER(4,2)  

*/
```
---
