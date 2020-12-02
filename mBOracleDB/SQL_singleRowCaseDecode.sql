select *
from employees
where salary = 24000;

select *
from employees
where hire_Date = '17/06/03';

where job_id = 'I' || '&job';

select first_name, initcap(last_name) "Name", length(last_name) length
from employees
where first_name like '%' || chr(38) || 'X%' /*'&start_letter%'*/
order by last_name;

select first_name, initcap(last_name) "Name", length(last_name) length
from employees
where first_name like '%&%' /*'&start_letter%'*/
order by last_name;

update employees
set first_name = 'Alexander'||chr(38)||'X'
where employee_id = 103

create table temp
(col1 varchar2(10));

insert into temp (col1) values (1);

create table temp2
(col1 varchar2(5), col2 char(5));

insert into temp2 (col1, col2)
values( 'abc', 'abc');


select first_name || ' ' || last_name as fullname,
    hire_date,
    to_char(hire_Date, 'dd-mon-rrrr') hire01,
    to_char(hire_Date, 'ddsp month rrrr') hire02,
    to_char(hire_Date, 'ddspth "of" month rrrr') hire03,     
    to_char(hire_Date, 'fmddspth "of" month rrrrsp') hire04
    from employees;
    
select first_name || ' ' || last_name as fullname,
    to_char(hire_Date, 'ddspth "of" month rrrr') hire03,to_char(salary, 'L099,999.00') num01
from employees
where to_char(hire_date, 'dd-mon-rrrr') = '17-jun-2003';


select first_name || ' ' || last_name as fullname,
salary, commission_pct, salary * commission_pct comm
, nvl(commission_pct, 0) comm_pct /*, salary + salary * nvl(commission_pct,0) comm,
nvl2(commission_pct, salary + salary * commission_pct, salary) income
*/
, nullif(length(first_name), length(last_name)) nullif01,
manager_id, employee_id, department_id,
coalesce(manager_id, employee_id, department_id) coalesce01
from employees;

select *
from employees
where commission_pct is null;

select first_name || ' ' || last_name as fullname, job_id, salary,
    CASE JOB_ID
        WHEN 'IT_PROG' THEN 1.1*SALARY
        WHEN 'ST_CLERK' THEN 1.15 * SALARY
        WHEN 'SA_REP' THEN 1.2 * SALARY
        ELSE SALARY
    END NEWSAL,
    DECODE(JOB_ID, 
        'IT_PROG', 1.1*SALARY,
        'ST_CLERK', 1.15 * SALARY,
        'SA_REP', 1.2 * SALARY,
        SALARY
    ) NEWSAL02,    
    CASE 
        WHEN DEPARTMENT_ID = 90 THEN 1.1*SALARY
        WHEN DEPARTMENT_ID BETWEEN 100 AND 140 THEN 1.15 * SALARY
        WHEN DEPARTMENT_ID < 90 THEN 1.2 * SALARY
        ELSE SALARY
    END AS NEWSAL03     
FROM EMPLOYEES;