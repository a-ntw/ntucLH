Oracle Database 12c R2: SQL Workshop 1
* Lab 2 - SELECT
* Lab 3 - WHERE, ORDER BY, LIKE '%a%'
* Lab 4 - Single-Row functions - sysdate, ROUND, INITCAP, LENGTH, LPAD
* Lab 5 - Conversion and Conditional - TO_CHAR, TO_DATE, CASE, DECODE - 'fmL', 'fmDdsp', NVL
* Lab 6 - Group Function - COUNT(* ), GROUP BY, HAVING
* Lab 7 - multiple table using JOIN, self-join - FROM NATURAL JOIN, ON, LEFT JOIN 
* Lab 8 - using subqueries - WHERE <> = ( SELECT ...
* Lab 9 - Set Operators - UNION, INTERSECY, MINUS
* Lab 10 - DML - DESCRIBE, INSERT INTO ... VALUES, COMMIT, UPDATE SET, DELETE, SAVEPOINT
* Lab 11 - Data Definition Language - CREATE TABLE AS, ALTER ADD/MODIFY/SET UNUSED, ADD, DROP

---

#### Lab 2 - SELECT
``` sql
DESC departments

SELECT *
FROM departments;

DESC employees;

SELECT employee_id, last_name, job_id, hire_date startdate
FROM employees;

SELECT DISTINCT job_id
FROM employees;

SELECT employee_id "Emp #"
, last_name "Employee"
, job_id "job"
, hire_date "Hire Date"
FROM employees;

SELECT first_name || ', ' || job_id
AS "Employee and Title"
FROM employees;

SELECT employee_id ||', '|| 
first_name ||', '|| 
last_name ||', '|| 
email ||', '|| 
phone_number ||', '|| 
job_id ||', '|| 
manager_id ||', '|| 
hire_date ||', '|| 
salary ||', '|| 
commission_pct ||', '|| 
DEPARTMENT_ID
the_output
FROM employees;
```
---
#### Lab 3 - WHERE, ORDER BY, LIKE '%a%'
``` sql
-- 3-1

SELECT *
FROM    employees;

-- 1.
SELECT  last_name, salary
FROM    employees
WHERE   salary > 12000;

-- 2.
SELECT  last_name, department_id
FROM    employees
where   employee_id = 176;

-- 3.
SELECT  last_name, salary
FROM    employees
WHERE   salary NOT BETWEEN 5000 AND 12000;

-- 4.
SELECT  last_name, job_id, hire_date
FROM    employees
WHERE   last_name IN ('Matos', 'Taylor')
ORDER BY hire_date asc;

-- 5.
SELECT  last_name, department_id
FROM    employees
WHERE   department_id in (20, 50)
ORDER BY last_name ASC;

-- 6.
SELECT  last_name, salary
FROM    employees
WHERE   salary BETWEEN 5000 AND 12000 
AND     department_id IN (20, 50);

-- 7.
SELECT  last_name, hire_date
FROM    employees
WHERE   hire_date >= '01-JAN-10' AND hire_date <= '01-JAN-11';

-- 8.
SELECT  last_name, job_id
FROM    employees
WHERE   Manager_id IS NULL;

-- 9.
SELECT  last_name, salary, commission_pct
FROM    employees
WHERE   commission_pct IS NOT NULL
ORDER BY 2 DESC, 3 DESC;

-- 10.
SELECT  last_name, salary
FROM    employees
WHERE   salary > &amt ;

-- 11.
SELECT  employee_id, last_name, salary, department_id
FROM    employees
WHERE   manager_id = &mgrID
ORDER   BY &col;

-- 12. Display where the third letter of the name is "a".
SELECT  last_name
FROM    employees
WHERE   last_name LIKE '__a%' ;

-- 13. Who have both an "a" and an "e" in their last name.
SELECT  last_name
FROM    employees
WHERE   last_name LIKE '%a%'
AND     last_name LIKE '%e%';

-- 14. job IN () AND salary not equal to $
SELECT  last_name, job_id, salary
FROM    employees
WHERE   job_id IN ('SA_REP', 'ST_CLERK')
AND     salary NOT IN (2500, 3500, 7000);

-- 15.
SELECT  last_name "Employee", salary "Montyly Salary", commission_pct
FROM    employees
WHERE   commission_pct = .20;


desc employees;
```
#### Lab 4 - Single-Row functions - sysdate, ROUND, INITCAP, LENGTH, LPAD
``` sql
--  Lab 4, potentail test
Desc    employees;

-- 1.
SELEct  Sysdate "Date"
FROM    DUAL;

-- 2.
SELECT  employee_id, last_name, salary, 
        ROUND(salary * 1.155, 0) "New Salary"
FROM    employees;

-- 3.
SELECT  employee_id, last_name, salary, 
        ROUND(salary * 1.155, 0) "New Salary"
FROM    employees;

-- 4.
SELECT  employee_id, last_name, salary,
        ROUND(salary * 1.155, 0) "New Salary", 
        ROUND(salary * 1.155, 0) - salary "Increase"
FROM    employees;

-- 5a.
SELECT  INITCAP(last_name) "Name", 
        LENGTH(last_name) "Length" 
FROM    employees
WHERE   last_name LIKE 'A%'
OR      last_name LIKE 'M%'
ORDER BY last_name;

-- 5b.
SELECT  INITCAP(last_name) "Name", 
        LENGTH(last_name) "Length" 
FROM    employees
WHERE   last_name LIKE '&start_letter%';

-- 5c
SELECT  INITCAP(last_name) "Name", 
        LENGTH(last_name) "Length" 
FROM    employees
WHERE   last_name LIKE UPPER ('&start_letter%' )
ORDER BY    last_name;

-- 6. MONTHD_BETWEEN
SELECT  Last_name, ROUND(MONTHS_BETWEEN(
        Sysdate, hire_date)) MONTHS_WORKED
FROM employees
ORDER BY months_worked;

-- 7. salary 15chars, left-padded w $
SELECT  last_name, 
        LPAD(salary,15,'$') salary
FROM    employees;

-- 8.  indicates the amounts if thier salaries with asterisks
SELECT  last_name, 
        RPAD(' ' ,(salary/1000)+1,'*') 
            salaries_in_asterisl
FROM    employees
ORDER BY salary DESC;

-- 9. TRUNCATE to 0 decimal places
SELECT  last_name, trunc((SYSDATE - hire_date)/7) AS tenure
FROM    employees
WHERE   department_id = 90
ORDER BY tenure ASC;

-- 
DESC employees;

SELECT *
FROM employees;
```
---
#### Lab 5 - Conversion and Conditional - TO_CHAR, TO_DATE, CASE, DECODE - 'fmL', 'fmDdsp', NVL
``` sql
desc employees;

-- 5-1. 1.
SELECT  last_name || ' earns ' 
        || TO_CHAR(salary, 'fmL99,999.00') 
        || ' monthly but wants ' 
        || TO_CHAR(salary * 3, 'fmL99,999.00') 
        || '.' "Dream Salaries"
FROM    employees;

-- 5-1. 2.
SELECT  last_name, hire_date, 
        ('Monday, the ' ||
        TO_CHAR(hire_date, 'fmDdsp "of" Month YYYY')) review
FROM    employees;

-- 5-1, 2. from SOLUTION --- date not correct ??
SELECT  last_name, hire_date, 
        TO_CHAR(NEXT_DAY(ADD_MONTHS(hire_date, 6), 'MONDAY'),
        'fmDay, "the" Ddspth "of" Month YYYY') review
FROM    employees;

-- 5-1. 3.  NOT WORKING -  use null
SELECT last_name, 
    NVL (TO_CHAR(commission_pct), 'No Commission') comm
FROM employees;

-- 5-1. 4.  
SELECT job_id, 
    CASE job_id WHEN 'AD_PRES' THEn 'A'
                WHEN 'ST_MAN' THEN 'B'
                WHEN 'IT_PROG' THEN 'C'
                WHEN 'SA_REP' THEN 'D'
                WHEN 'ST_CLERK' THEN 'E'
    ELSE    '0' END  "Grade"           
FROM employees;

--- 5-1 5.
SELECT job_id, CASE
                WHEN job_id = 'AD_PRES' THEn 'A'
                WHEN job_id = 'ST_MAN' THEN 'B'
                WHEN job_id = 'IT_PROG' THEN 'C'
                WHEN job_id = 'SA_REP' THEN 'D'
                WHEN job_id = 'ST_CLERK' THEN 'E'
                ELSE    '0' END  "Grade"           
FROM employees;

-- 5-1. 6.  
SELECT job_id, 
    DECODE(job_id,
    'AD_PRES', 'A',
                'ST_MAN', 'B',
                'IT_PROG', 'C',
                'SA_REP', 'D',
                'ST_CLERK', 'E',
   '0'  ) "Grade"           
FROM employees;
```
--- 
#### Lab 6 - Group Function - COUNT(* ), GROUP BY, HAVING
``` sql
desc employees;


-- 4. MAX, MIN, SUM, AVG
SELECT
    round(MAX(salary)) "Maximun",
    round(MIN(salary)) "Minimum",
    round(SUM(salary)) "Sum",
    round(AVG(salary), 0) "Average"
FROM    employees;

-- 5.
SELECT
    job_id,
    round(MAX(salary)) "Maximun",
    round(MIN(salary)) "Minimum",
    round(SUM(salary)) "Sum",
    round(AVG(salary), 0) "Average"
FROM    employees
GROUP BY    job_id;

-- 6. Write a query to display the number of people with the same job.
SELECT  job_id,
    COUNT(*)
FROM    employees
GROUP BY  job_id;

-- 6. B
SELECT  job_id,
    COUNT(*)
FROM    employees
WHERE   job_id = '&job_title'
GROUP BY job_id;

-- 7. The number of managers without listing them
SELECT
    COUNT(DISTINCT manager_id) "Number of Managers"
FROM    employees;

-- 8. the difference between the highest and lowest salaries
SELECT
    MAX(salary) - MIN(salary)  difference
FROM    employees;

-- 9. Excude anyone whose manager is not known.
--      excude anu groups where the minimum salary is $6,000.  Sort desc
SELECT  manager_id, MIN(salary)
FROM    employees
WHERE   manager_id IS NOT NULL
GROUP BY    manager_id
HAVING  MIN(salary) > 6000
ORDER BY    MIN(salary) DESC;

-- 10. Create a query that display the total number of employees and,
-- of that total, the number of employees hired in 2009,2010, 2011 & 2012.
SELECT COUNT(*) total,
    SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 1997,1,0))"1997",
    SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 1998,1,0))"1998",
    SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 1999,1,0))"1999",
    SUM(DECODE(TO_CHAR(hire_date, 'YYYY'), 2000,1,0))"2000"
FROM    employees;

-- 11. Create a matrix query to display the job,
-- the salary for that job based on the department numbers 20,50,80,and 90,
-- and the totalsalary for that job.
SELECT job_id "Job",
    SUM(DECODE(department_id , 20, salary)) "Dept 20",
    SUM(DECODE(department_id , 50, salary)) "Dept 50",
    SUM(DECODE(department_id , 80, salary)) "Dept 80",
    SUM(DECODE(department_id , 90, salary)) "Dept 90",
    SUM(salary) "Total"
FROM    employees
GROUP BY    job_id;

desc employees;
```
--- 
#### Lab 7 - multiple table using JOIN, self-join - FROM NATURAL JOIN, ON, LEFT JOIN 
``` sql
--- Lab 07 - potentail assessmenrt!


desc employees;

desc locations;  -- country_id// 

desc countries;

desc departments;

-- 1.
SELECT  location_id, street_address, city, state_province, country_name
FROM    locations
NATURAL JOIN countries;

-- 2.
SELECT  last_name, department_id, department_name
FROM    employees
JOIN    departments USING (department_id);

-- 3. 3-ways join
SELECT  e.last_name, e.job_id, e.department_id, d.department_name
FROM    employees   e
        JOIN departments   d ON ( e.department_id = d.department_id )
        JOIN locations     loc USING ( location_id ) 
WHERE   lower(loc.city) = 'toronto';

/*** JOIN tables to itsellf ****/
-- 4.  Create a report to display employees' last names and employee numbers along with their managers' 
--      last names and manager numbers. 
SELECT  w.last_name "Employee", w.employee_id "Emp#",
        m.last_name "Manager", m.employee_id "Mgr#"
FROM    employees w
        JOIN employees   m ON ( w.manager_id = m.employee_id );
    
-- 5.  to display all employees, including King, who has no manager.
SELECT  w.last_name "Employee", w.employee_id "Emp#",
        m.last_name "Manager", m.employee_id "Mgr#"
FROM    employees w
        LEFT JOIN employees   m ON ( w.manager_id = m.employee_id ) 
ORDER by 2; /* solution use LEFT OUTER JOIN*/
    
-- 6. from Solution - on same department
SELECT  e.department_id department, e.last_name employee, c.last_name colleague
FROM    employees e join employees c
ON      (e.department_id = c.department_id)
WHERE   e.employee_id <> c.employee_id
order by e.department_id, e.last_name, c.last_name;

-- 7.
CREATE TABLE job_grades (
   GRADE_level VARCHAR(2),
   LOWEST_SAL  NUMBER,
   HIGHEST_SAL NUMBER
   );   
insert into job_grades (grade_level, lowest_sal, highest_sal) values ('A',1000,3999);
insert into job_grades (grade_level, lowest_sal, highest_sal) values ('B',4000,8999);
insert into job_grades (grade_level, lowest_sal, highest_sal) values ('C',9000,24999);
insert into job_grades (grade_level, lowest_sal, highest_sal) values ('D',25000,89999);

desc job_grades;

/*  ON BETWEEN AND  */
SELECT  e.last_name, e.job_id, department_name, e.salary, j.grade_level
FROM    employees e
    JOIN departments USING (department_id) /* solution use ON */
    JOIN job_grades j ON ( e.salary BETWEEN lowest_sal AND highest_sal)
ORDER BY salary DESC;


-- 8. Solution, hired afte Davies
SELECT  e.last_name, e.hire_date
FROM    employees e
    JOIN    employees d ON (d.last_name =  'Davies')
WHERE d.hire_date < e.hire_date;

-- 9. employees who were hired before their managers
SELECT  e.last_name, e.hire_date, m.last_name manager, m.hire_date "Manager_hire_date"
FROM    employees e
    JOIN    employees m ON (m.employee_id =  e.manager_id)
WHERE e.hire_date < m.hire_date;


-- test
desc employees;

desc departments;

SELECT department_id
From employees;
    
SELECT last_name, department_name, department_id
from employees natural join departments /* natural join only work for complete matching column */
Where department_name = 'Executive'; /* 2 results*/

SELECT last_name, department_name, department_id
from employees join departments USING (department_id) /* USING Clause match only one column */
Where department_name = 'Executive'; /* 3 results */

SELECT e.last_name, d.department_name, e.department_id
from employees e join departments d ON e.department_id = d.department_id
Where department_name = 'Executive'; /* 3 results */
```
--- 
#### Lab 8 - using subqueries - WHERE <> = ( SELECT ...
``` sql

desc employees;

-- 1.

UNDEFINE name
SELECT  last_name, hire_date 
FROM    employees
WHERE   department_id = (   SELECT  department_id
                            FROM    employees
                            Where   last_name = '&&name')
AND     last_name <> '&name';


-- 2.
SELECT  employee_id, last_name, salary
FROM    employees
WHERE   salary > (  SELECT AVG(salary)
                    FROM employees)
ORDER BY salary;

-- 3. 
SELECT  employee_id, last_name
FROM    employees
WHERE   department_id IN (  SELECT  department_id
                            FROM    employees
                            WHERE   last_name LIKE '%u%');

-- 4. 
SELECT  last_name, department_id, job_id
FROM    employees
WHERE   department_id IN (  SELECT  department_id
                            FROM    departments
                            WHERE   location_id = 1700);

-- 5. 
SELECT  last_name, salary
FROM    employees
WHERE   manager_id IN ( SELECT  employee_id
                        FROM    employees
                        WHERE   last_name = 'King');

-- 6. Create a report for HR that display the department number, last name, and job ID for 
--      every employee in the Executive department
SELECT  department_id, last_name, job_id
FROM    employees
WHERE   department_id IN (  SELECT  department_id
                            FROM    departments
                            WHERE   department_name = 'Executive');

-- 7. Create a report that display a list of all employees whose salary is more than the
--      salary of any employee from department 60.
SELECT  last_name
FROM    employees
WHERE   salary > ANY (  SELECT MIN(salary)
                        FROM    employees
                        WHERE   department_id = 60 );

-- 8.
-- where earn more that average
-- work in departmnt, whose emp u
SELECT  employee_id, last_name, salary
FROM    employees
WHERE salary > (SELECT AVG(salary)
                FROM employees)
AND department_id IN (
                SELECT department_id
                FROM employees
                WHERE last_name LIKE '%u%');

-- 8. from solution
-- where earn more that average
-- work in departmnt, whose emp u
SELECT  employee_id, last_name, salary
FROM    employees
WHERE   department_id IN (  SELECT department_id
                            FROM employees
                            WHERE last_name LIKE '%u%')
AND     salary > (  SELECT AVG(salary)
                    FROM    employees);


desc employees;
desc locations;
desc countries;
desc departments;
```
--- 
#### Lab 9 - Set Operators - UNION, INTERSECY, MINUS
``` sql
desc employees;

desc jobs;
desc departments;
desc countries;
desc locations;

-- 1.
SELECT department_id
FROM employees
INTERSECT
SELECT department_id
FROM employees
WHERE job_id <> 'ST_CLERK';

-- 1. from Solution
SELECT department_id
FROM departments
MINUS
SELECT department_id
FROM employees
WHERE job_id = 'ST_CLERK';

-- 2. Solution - a list if countries, no departments (MINUS off countries w departments)
SELECT country_id, country_name
FROM countries
MINUS
SELECT l.country_id, c.country_name
FROM locations l JOIN countries c
ON (l.country_id = c.country_id)
JOIN departments d
ON d.location_id = l.location_id;

-- 3. employees, department_id 50 and 80, using setOperators
SELECT employee_id, job_id, department_id
FROM employees
WHERE department_id = 50
UNION
SELECT employee_id, job_id, department_id
FROM employees
WHERE department_id = 80;

-- 4. sales, sales departments.
desc departments;
desc employees;

SELECT e.employee_id
FROM employees e JOIN departments d
ON e.department_id = d.department_id
WHERE d.department_name = 'Sales';

-- 4. SOLUTION -- job are sales Rep
SELECT employee_id
FROM employees
WHERE job_id = 'SA_REP'
INTERSECT
SELECT employee_id
FROM employees
WHERE department_id = 80;

-- 5. 
SELECT last_name, department_id, TO_CHAR(NULL) department_name
FROM employees
UNION
SELECT TO_CHAR(NULL) last_name, department_id, department_name
FROM departments;

```
---
#### Lab 10 - DML - DESCRIBE, INSERT INTO ... VALUES, COMMIT, UPDATE SET, DELETE, SAVEPOINT
``` sql

desc    employees;

-- 1.
--From Maya Novelita to Everyone: (12:11 PM)
create table    my_employee
(id number(4) not null,
last_name   varchar2(25),
first_name  varchar2(25),
userid      varchar2(8),
salary  number(9,2));

-- 1. Solution
desc    my_employee;


-- 2.
INSERT INTO     my_employee
VALUES (1, 'Patel', 'Ralph', 'rpatel', 895);


-- 3. 
INSERT INTO     my_employee (id, last_name, first_name, userid, salary)
VALUES (2, 'Dance', 'Betty', 'bdance', 860);

-- 4.
SELECT  *
FROM    my_employee;


-- 5. Dynamic 
INSERT INTO     my_employee 
VALUES  (&id, '&last_name', '&first_name', '&userid', &salary);


-- 6.
INSERT INTO     my_employee 
VALUES  (&id, '&last_name', '&first_name', '&userid', &salary);

INSERT INTO     my_employee
VALUES  (3, 'Biri', 'Ben', 'bbiri', 1100);
INSERT INTO     my_employee
VALUES  (4, 'Newman', 'Chad', 'cnewman', 750);
INSERT INTO     my_employee
VALUES  (5, 'Ropeburn', 'Audrey', 'aropebur', 1150);

-- 7.
SELECT  *
FROM    my_employee;

-- 8.  make the data additions permament. update and delete
COMMIT;

----  update my_employee and delete data ------

desc    my_employee;
SELECT  *
FROM    my_employee;

-- 9.
UPDATE  my_employee
SET     last_name = 'Drexler'
WHERE   id = 3;

-- 10. 
UPDATE  my_employee
SET     salary = 1000
WHERE   salary < 900;

-- 11.
SELECT  *
FROM    my_employee;

-- 12
DELETE  my_employee
WHERE   last_name = 'Dance';

-- 12 Solution
DELETE  
FROM    my_employee
WHERE   last_name = 'Dance';

-- 13.
SELECT  *
FROM    my_employee;

-- 14
COMMIT;

-- 15. Dynamic 
INSERT INTO     my_employee
VALUES  (5, 'Ropeburn', 'Audrey', 'aropebur', 1150);

-- 16.
SELECT  *
FROM    my_employee;

-- 17. MARK an transaction
SAVEPOINT   sp01;

-- 18. delete all rows
DELETE  my_employee;

-- 18. from Solution
DELETE  
FROM    my_employee;

-- 19.
SELECT  *
FROM    my_employee;

-- 20  Discard the most recent DELETE operation
ROLLBACK TO     sp01;

-- 21 
desc my_employee;

SELECT  *
FROM    my_employee;

-- 22
COMMIT;

-- 23. modify from -- 6.
-- userid is gemenrate automated by cancaternating
-- the first letter of the first name and 
-- the first seven char of the lastname.
-- The useid must be lowercase.
-- should not prompt for userid
INSERT INTO     my_employee 
VALUES  (&id, '&&last_name', '&&first_name', 
    lower(substr(   '&first_name', 1, 1) || 
    substr( '&last_name', 1, 7)), &salary);

UNDEFINE first_name
UNDEFINE last_name

-- 24 
-- id= 6, last_name= Anthony, fisrt_name= Mark, userid= manthony, sal=1230

-- 25
SELECT *
FROM    my_employee
WHERE   id = 6;
```
---
#### Lab 11 - Data Definition Language - CREATE TABLE AS, ALTER ADD/MODIFY/SET UNUSED, ADD, DROP
``` sql
-- lab 11

-- 1.0 diff from solution
/*CTREATE TABLE DEPT (
customerid number(4),
custname varchar2(30),
emaul varchar2(50,
primary key(customerid)); */

CREATE TABLE    dept( 
    id number(7) PRIMARY KEY,
    name varchar2(25));

-- 1. from solution 
/*
CREATE TABLE    dept
    (id NUMBER(7) CONSTRAINT department_id_pk PRIMARY KEY,
    name varchar2(25));
*/
desc dept;

-- 2. diff from solution
CREATE TABLE    emp (
    id number(7),
    last_name varchar2(25),
    first_name varchar2(25),
    dept_id number(7),
    foreign key (dept_id) REFERENCES dept(id));

desc emp;
    
-- 3. 
ALTER TABLE     emp 
    ADD commision NUMBER(2, 2);

DESCRIBE    emp;

-- 4. 
ALTER TABLE     emp
    modify  last_name vanchar2(50);
        
DESC    emp;

-- 5.
ALTER TABLE     emp 
    DROP COLUMN first_name;

DESC    emp;

-- 6.
ALTER TABLE     emp
    SET UNUSED  (dept_id);

desc    emp;

-- 7.
ALTER TABLE     emp
    drop unused column;

desc    emp;

--  8. Create employees2 based on the structure if the Employees table.
-- include employee_id, first_name, last_name, salary, and department_id.
-- Name the columns in your ne table ID, first_name, last_name,salary, dept_id.
CREATE TABLE employees2
    AS
        SELECT
            employee_id     id,
            firsst_name,
            last_name,
            salary,
            department_id   dept_id
        FROM
            employees;


desc employees2;

-- 9. table READ ONLY
ALTER TABLE     employees2   READ ONLY;

-- 10. delete all rows
TRUNCATE TABLE  employees2; -- delete not allow, as readonly

-- 11, revert to READ WRITE status
ALTER TABLE     employees2   READ WRITE;

TRUNCATE TABLE  employees2;
SELECT  *   FROM    employees2;

-- 12. Drop the emp, dept, amd employees2
DROP TABLE emp;

DROP TABLE dept;

DROP TABLE employees2;


```

---
