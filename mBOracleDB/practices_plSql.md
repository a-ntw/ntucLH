PL/SQL

---
practice 2
``` sql

SET SERVEROUTPUT ON

BEGIN
    DBMS_OUTPUT.PUT_LINE(' Hello World ');
    dbms_output.put_line(' Hello World ');
END;

```
---
practice 3
``` sql

/*
SET SERVEROUTPUT ON

BEGIN
    DBMS_OUTPUT.PUT_LINE(' Hello World ');
END;
*/

/** Practices 3 . Declaring PL/SQL Variables  ***/

-- 3.

DECLARE
    v_fname   VARCHAR2(20);
    v_lname   VARCHAR2(15) DEFAULT 'fernandez';
BEGIN
    dbms_output.put_line(v_fname || ' ' || v_lname);
END;
    
-- 4.
SET SERVEROUTPUT ON

DECLARE
    v_today      DATE := SYSDATE;
    v_tomorrow   v_today%TYPE;
BEGIN
    v_tomorrow := v_today + 1;
    dbms_output.put_line(' Hello World ');
    dbms_output.put_line('TODAY IS :    ' || v_today);
    dbms_output.put_line('TODMORROW IS :' || v_tomorrow);
END;
/


-- 5..
--SET SERVEROUTPUT ON

VARIABLE    b_basic_percent number;
VARIABLE    b_pf_percent number;

DECLARE
    v_today      DATE := SYSDATE;
    v_tomorrow   v_today%TYPE;
    
BEGIN
    v_tomorrow := v_today + 1;
    dbms_output.put_line(' Hello World ');
    dbms_output.put_line('TODAY IS :    ' || v_today);
    dbms_output.put_line('TODMORROW IS :' || v_tomorrow);
    :b_basic_percent := 45;
    :b_pf_percent := 12;
END;
/ -- ended for the PL-SQL
PRINT b_basic_percent;
PRINT b_pf_percent;

-- 




```
---
practice 4
``` sql
/*
SET SERVEROUTPUT ON

BEGIN
    DBMS_OUTPUT.PUT_LINE(' Hello World ');
END;
*/

/* Practices 4  Writing Executive Statements  */

SET SERVEROUTPUT ON

BEGIN
    dbms_output.put_line(' Hello World ');
END;

--- 1.  q&a

--SET SERVEROUTPUT ON

declare
    v_weight number(3) := 600;
    v_message varchar2(255) := 'Product 10012';
begin
    declare
        v_weight number(3) := 1;
        v_message varchar2(255) := 'Product 11011';
        v_new_locn varchar2 := 'Europe';
    begin
        v_weight :=  v_weight + 1;
        v_new_locn := 'Western ' || v_new_locn;
    END;
        v_weight :=  v_weight + 1;
        v_message := v_message || ' is on stock';
        v_new_locn := 'Western ' || v_new_locn;
END;
/


-- 2. q&a
/*
DECLARE
    v_customer varchar2(50) := "Womansport';            
    v_credit_rating varchar2(50) := 'EXCELLENT';    
BEGIN
    DECLARE
        v_customer number(7) := 201;
        v_name varchar2(25) := 'Unispores';
    BEGIN
        v_credit_rating := 'GOOD';
        ...
    END;
    ...
END; */
-- 


-- 3.

--SET SERVEROUTPUT ON

DECLARE
    v_basic_percent number := 45;
    v_pf_percent number := 12;
    v_fname VARCHAR2(15);
    v_emp_sal NUMBER(10);
BEGIN
    SELECT first_name, salary INTO v_fname, v_emp_sal
    FROM employees WHERE employee_id = 110;
    DBMS_OUTPUT.PUT_LINE('YOUR SALARY IS: ' || v_emp_sal);
    DBMS_OUTPUT.PUT_LINE('YOUR CONTRIBUTION TOWARDS PF: '
    || v_emp_sal* v_basic_percent/ 100* v_pf_percent/100); 
END;
/                   
/* console:
YOUR SALARY IS: 8200
YOUR CONTRIBUTION TOWARDS PF: 442.8
*/

```
---
practice 5
``` sql
/*
SET SERVEROUTPUT ON

BEGIN
    DBMS_OUTPUT.PUT_LINE(' Hello World ');
END;
*/

/** Practice 5. Using SQL Statements Within a PL/SQL ***/
-- Data Definition Language (DDL0
-- Data Manipulation Language (DML)
-- Data Control Language (DCL)


DROP table employees2;
DROP table copy_emp;

-- 5.1
SET SERVEROUTPUT ON
DECLARE
    v_max_deptno NUMBER;
BEGIN
    SELECT  MAX(department_id)
    INTO    v_max_deptno
    FROM    departments;

    DBMS_OUTPUT.PUT_LINE('The maximum department_id is : ' || v_max_deptno);
END;


-- 5.2
-- SET SERVEROUTPUT ON
DECLARE
    v_max_deptno NUMBER;
    v_dept_name departments.department_name%TYPE := 'Education';
    v_dept_id NUMBER;
BEGIN

    SELECT  MAX(department_id)
    INTO    v_max_deptno
    FROM    departments;
    v_dept_id := 10 + v_max_deptno;
    INSERT INTO departments (department_id, department_name, location_id)
    VALUES (v_dept_id, v_dept_name, NULL);

    DBMS_OUTPUT.PUT_LINE('The maximum department_id is : ' || v_max_deptno);
    DBMS_OUTPUT.PUT_LINE(' SQL%ROWCOUNT gives ' || SQL%ROWCOUNT);
END;
/
SELECT * FROM departments WHERE department_id = 280;


--  5.3
BEGIN
    UPDATE departments SET location_id=3000
    WHERE department_id =280;
END;
/
SELECT * FROM departments WHERE department_id = 280;
DELETE FROM departments WHERE department_id = 280;



/* from 5 - 9: Retrieving Data in PL/SQL */
--SET SERVEROUTPUT ON

DECLARE
    v_emp_hiredate   employees.hire_date%TYPE;
    v_emp_salary     employees.salary%TYPE;
BEGIN
    SELECT hire_date, salary
    INTO v_emp_hiredate, v_emp_salary
    FROM employees
    WHERE  employee_id = 100;

    dbms_output.put_line('Hire date is :' || v_emp_hiredate);
    dbms_output.put_line('Salary is :' || v_emp_salary);
END;
/

/*  from 5-23 SQL Cursor Attriutes for Implicit Cursors
SQL%FOUND, SQL%NOTFOUND, SQL%ROWCOUNT*/
```
---
practice 6
``` sql
/*
SET SERVEROUTPUT ON

BEGIN
    DBMS_OUTPUT.PUT_LINE(' Hello World ');
END;
*/

/** Practice 6. Writing Control Structures  ***/



/*
DROP TABLE messages;
CREATE TABLE messages (results VARCHAR2(80));
--for 6.1


DROP TABLE emp;

CREATE TABLE emp AS SELECT * FROM employees;

ALTER TABLE    emp  ADD stars	VARCHAR2(50);
-- for 6.2
*/

-- 6.1
BEGIN
    FOR i IN 1..10 LOOP IF i = 6 OR i = 8 THEN
        NULL;
    ELSE
        INSERT INTO messages ( results ) VALUES (i);

    END IF;
    END LOOP;

    COMMIT;
END;
/

SELECT  *
FROM messages;

-- 6.2
desc emp;
select * from emp;

SET SERVEROUTPUT ON

DECLARE
    v_empno      emp.employee_id%TYPE := 176;
    v_asterisk   emp.stars%TYPE := NULL;
    v_sal        emp.salary%type;
begin
    SELECT nvl(round(salary/1000), 0)
    INTO v_sal
    FROM  emp
    WHERE employee_id = v_empno;

    FOR i IN 1..v_sal
        loop 
        v_asterisk := v_asterisk || '*';
    END LOOP;
    UPDATE emp
    SET stars = v_asterisk
WHERE employee_id = v_empno;
END;
/

SELECT
    employee_id,
    salary,
    stars
FROM emp where employee_id = 176;

-- console -- 176	8600	*********


/* Student Guide 6-34  PL/SQl CONTINUS Statement ex1  */
DECLARE
    v_total SIMPLE_INTEGER := 0;
BEGIN
    FOR i IN 1..10 LOOP
        v_total := v_total + i;
        dbms_output.put_line('Total is: ' || v_total);
        CONTINUE WHEN i > 5;
        v_total := v_total + i;
        dbms_output.put_line('Out of Loop Total is: ' || v_total);
    END LOOP;
END;
/
```
---
practice 7
``` sql
/** Practics 7. Working with Composite Data Types **/

/*
SET SERVEROUTPUT ON

BEGIN
    DBMS_OUTPUT.PUT_LINE(' Hello World ');
END;
*/

DROP table retired_emps;
DROP table emp1;


-- 7.1 PL/SQl record %ROWTYPE, print info about a given country
SET SERVEROUTPUT ON
SET VERIFY OFF
DECLARE 
    v_countryid  varchar2(20) := 'CA'; -- assign CA
    v_country_record   countries%ROWTYPE; -- %ROWTYPE attributes

BEGIN
    SELECT  *
    INTO v_country_record
    FROM countries
    WHERE country_id = UPPER(v_countryid);
    DBMS_OUTPUT.PUT_LINE('Country Id; ' ||
    v_country_record.country_id ||
    ' Country Name: ' || v_country_record.country_name
    || ' Region: ' || v_country_record.region_id);
END;
/

desc countries;


-- 7.2  TYPE <> IS TABLE OF ...<>%TYPE INDEX BY ...
SET SERVEROUTPUT ON
SET VERIFY OFF
DECLARE
    TYPE dept_table_type IS TABLE OF 
        departments.department_name%TYPE 
    INDEX BY PLS_INTEGER;
    my_dept_table   dept_table_type;

    f_loop_count    NUMBER(2) := 10;
    v_deptno        NUMBER(4) := 0;

BEGIN
    FOR i IN 1..f_loop_count LOOP
        v_deptno := v_deptno +10;
        SELECT  department_name
        INTO    my_dept_table(i)
        FROM    departments
        WHERE   department_id = v_deptno;
    END LOOP;
    
    FOR i IN 1..f_loop_count LOOP 
        dbms_output.put_line(my_dept_table(i));
    END LOOP;
END;
/


-- 3. Associative arrays are also know as INDEX By tables
--  Using Collection Methods with Associative Arrays
--SET SERVEROUTPUT ON

DECLARE
    TYPE dept_table_type IS TABLE OF departments%ROWTYPE
    INDEX BY PLS_INTEGER;
    my_dept_table   dept_table_type;
    f_loop_count    NUMBER(2) := 10;
    v_deptno        NUMBER(4) := 0;

BEGIN
    FOR i IN 1..f_loop_count LOOP
        v_deptno := v_deptno +10;
        SELECT  *
        INTO    my_dept_table(i)
        FROM    departments
        WHERE   department_id = v_deptno;
    END LOOP;

    FOR i IN 1..f_loop_count LOOP 
        dbms_output.put_line('Department Number: ' || my_dept_table(i).department_id
        || ', Department Name: ' || my_dept_table(i).department_name
        || ', Manager ID : ' || my_dept_table(i).manager_id
        || ', Location Id: ' || my_dept_table(i).location_id);
    END LOOP; 
END;
/


/* Student guide Creating a PL/SQL record 7-11 */
--SET SERVEROUTPUT ON

DECLARE type t_rec is RECORD ( 
    v_first_name    employees.first_name%TYPE, 
    v_sal           NUMBER(8),
    v_hire_date     employees.hire_date%TYPE );
    v_myrec t_rec;
BEGIN
    SELECT  first_name, salary, hire_date
    INTO    v_myrec
    FROM    employees
    WHERE   employee_id = 100;

    DBMS_OUTPUT.PUT_LINE('
        First Name: '|| v_myrec.v_first_name     || '
        Salary: ' || v_myrec.v_sal    || '
        Hire Date: '|| v_myrec.v_hire_date);
END;

```
---
practice 8
``` sql
```
practice 9
``` sql
```
