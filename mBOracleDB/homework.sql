-- Homework 1 & Homework 2

/****     HomeWork 1          ***/

/*
select all departments and highest salary for that department. 
Exclude any department where the highest salary is less than 4000.
Sort the ouput by department in descending order.
*/
desc employees;

SELECT department_id, MAX(salary)
FROM employees  
WHERE department_id is not null
    group by department_id
    having max(salary) >= 4000
ORDER BY department_id desc;


/*
Display employee full name, manager full name, department name and 
location name who works for department 90.
*/
desc employees;
desc departments;
desc locations;

SELECT  e.first_name || ' ' || e.last_name as employee,
        m.first_name || ' ' || m.last_name as manager,
        d.department_name Department,
        l.state_province location
FROM    employees e JOIN employees m
    ON      ( m.employee_id  = e.manager_id) 
    JOIN    departments d
    ON      (e.department_id =  d.department_id)
    JOIN    locations l
    ON      (d.location_id = l.location_id)
WHERE   e.department_id = 90;

---------------------------------------------------------------------------------------------
/****     HomeWork 2          ***/

-- Create table countries and cities table:
create table    my_Countries (
countryId number(3) PRIMARY KEY,
name   varchar2(10));

create table    Cities (
cityId      number(3) PRIMARY KEY,
countryId   number(3),
CityName    varchar2(10),
Population  number(10));


/*1. After creating cities tables:
	a.	add column region with data type varchar2 and length 10. 
	b.	Make countryid as foreign key with references to countries table, countryid column
Submit all the statement for table creation, alter and display structure of both tables.
*/
-- Alter table
ALTER TABLE Cities
ADD Region  varchar2(10)
ADD foreign key(countryId) references my_Countries(countryId);


desc    my_Countries;
desc    Cities;

/*
 	2.	Insert following data into countries table:
        Insert following data into cities table:
*/
-- Insert datas as by tables

INSERT INTO     my_Countries 
    VALUES (1, 'Singapore');
INSERT INTO     my_Countries 
    VALUES (2, 'Maysia');
INSERT INTO     my_Countries 
    VALUES (3, 'Indonesia');
INSERT INTO     my_Countries 
    VALUES (4, 'Brunei');

INSERT INTO     Cities 
    VALUES (1, 1, 'Singapore', 12345678, null );
INSERT INTO     Cities 
    VALUES (2, 2, 'Kuala Lump', 23456789, '' );
INSERT INTO     Cities 
    VALUES (3, 2, 'Johor', 34567809, '' );


SELECT * FROM my_countries;
SELECT * FROM Cities;


/*
•	3. Amend population of existing city, where cityid is 3, 
    increase the population with following condition:
•	If no region is defined (or null), increase population by 10%.
•	If there is region defined, increase population by 20%.
*/
-- cityId is 3, update population + 10% if region is null, or 20%

UPDATE cities 
SET population = (
    SELECT NVL2(region, population *1.1, population*1.2)
    FROM Cities
    WHERE CityId = 3)
WHERE CityId =3 ;

-- another good version
UPDATE cities 
SET population =  NVL2(region, population *1.1, population*1.2)
    WHERE CityId = 3;


--rollback; -- for TESTING
desc    Cities;
SELECT * FROM Cities;
UPDATE cities 
SET population =  10000000
    WHERE CityId = 3;



/*
•	4. Create pl/sql block to list city name, country name, population where city id is 1.
Format of the output is “<CountryName> - <CityName> population is <population>”.
*/
    
SET SERVEROUTPUT ON

DECLARE
    v_homeName   VARCHAR2(25)    := 'v_homeName';
    v_population    NUMBER(8);
    v_cityId        NUMBER(2)   := 1;

BEGIN
    SELECT ct.name || ' - ' || ci.cityname, population
    INTO v_homeName, v_population
    FROM Cities ci 
        JOIN my_Countries ct
        ON (ci.countryId = ct.countryId)
    WHERE cityId = 1;
        
    dbms_output.put_line(v_homeName 
    || ' - '
    || ' population is '
    || v_population);
   
END;
/ 
-- console: Singapore - Singapore -  population is 12345678

                   
-----------------------------------------------------------------------------------------------

--Testing
/***********************/
select first_name || ' ' || last_name as fullname, job_id, salary,
    CASE JOB_ID
        WHEN 'IT_PROG' THEN 1.1*SALARY
        WHEN 'ST_CLERK' THEN 1.15 * SALARY
        WHEN 'SA_REP' THEN 1.2 * SALARY
        ELSE SALARY
    END NEWSA
FROM  employees
where last_name = 'Hunold';


-----
/*

UPDATE cities 
set population = population * 1.2
    WHERE region IS NOT NULL AND cityid = 3;
*/

/* NVL2 (expr1, expr2, expr3)
    If expr1 is not null, NVL2 returns expr2.
    If expr1 is null, NVL2 return expr3.
    ref: 5-23*/
SELECT population, NVL2(region, population *1.2, population*1.1) newpopu
FROM Cities;
 
    
-- rollback;

-----------------------------------------------------------------------------------------
