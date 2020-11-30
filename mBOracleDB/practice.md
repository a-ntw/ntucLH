labs 2
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
``
labs 3
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

-- 12.
SELECT  last_name
FROM    employees
WHERE   last_name LIKE '__a%' ;

-- 13.
SELECT  last_name
FROM    employees
WHERE   last_name LIKE '%a%'
AND     last_name LIKE '%e%';

-- 14.
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
Lab 4 - still doing
``` sql
SELEct Sysdate FROM DUAL;

Desc employees;

SELECT employee_id, last_name, salary, salary * 1.155 "New Salary"
FROM employees;

SELECT employee_id
, last_name
, salary
, salary * 1.155 "New Salary"
, (salary * 1.155) - salary "Increase"
FROM employees;

-- 5.
SELECT INITCAP(last_name) "Name" 
, LENGTH(last_name) 
FROM employees
WHERE last_name LIKE 'A%'
OR last_name LIKE 'M%';

SELECT INITCAP(last_name) "Name"
, LENGTH(last_name) 
FROM employees
WHERE SUBSTR(last_name, 1, 1) = '&letter';

SELECT INITCAP(last_name) "Name"
, LENGTH(last_name) 
FROM employees
WHERE SUBSTR(last_name, 1, 1) = UPPER('&letter');

-- 6. ???
SELECT Last_name
, ROUND (Sysdate - hire_date) MONTHS_WORKED
FROM employees;

-- 
DESC employees;

SELECT *
FROM employees;
```




