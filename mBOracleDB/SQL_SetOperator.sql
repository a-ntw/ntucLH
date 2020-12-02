/*union*/
SELECT last_name, job_id, salary
FROM   employees
WHERE  salary = (SELECT max(salary)FROM   employees)
union
SELECT last_name, job_id, salary
FROM   employees
WHERE  job_id =  (SELECT job_id FROM   employees WHERE  last_name = 'Davies')
AND    salary > (SELECT salary FROM   employees WHERE  last_name = 'Davies')
union all
SELECT last_name, job_id, salary
FROM   employees where job_id = 'AD_PRES'
order by job_id;


/*intersect*/
SELECT last_name, job_id, salary
FROM   employees
WHERE  salary = (SELECT max(salary)FROM   employees)
union
SELECT last_name, job_id, salary
FROM   employees
WHERE  job_id =  (SELECT job_id FROM   employees WHERE  last_name = 'Davies')
AND    salary > (SELECT salary FROM   employees WHERE  last_name = 'Davies')
INTERSECT
SELECT last_name, job_id, salary
FROM   employees where job_id = 'AD_PRES'
order by job_id;


SELECT last_name, job_id, salary
FROM   employees
WHERE  salary = 
                (SELECT max(salary)
                 FROM   employees)
union
SELECT last_name, job_id, salary
FROM   employees
WHERE  job_id =  
                (SELECT job_id
                 FROM   employees
                 WHERE  last_name = 'Davies')
AND    salary >
                (SELECT salary
                 FROM   employees
                 WHERE  last_name = 'Davies')
MINUS
SELECT last_name, job_id, salary
FROM   employees
where job_id = 'AD_PRES';

/*MATCHING COLUMN-TYPE AND NUMBER OF COLUMNS*/
SELECT location_id, department_name Department, 
   TO_CHAR(NULL) location  
FROM departments
UNION
SELECT location_id, '' Departments, 
   state_province
FROM locations
order by location_id;

desc departments;
desc locations;

SELECT * FROM EMPLOYEES;



/*union*/
select job_id, avg(salary) avgsal
from (
  SELECT last_name, job_id, salary
    FROM   employees
    WHERE  salary = (SELECT max(salary)FROM   employees)
    union
    SELECT last_name, job_id, salary
    FROM   employees
    WHERE  job_id =  (SELECT job_id FROM   employees WHERE  last_name = 'Davies')
    AND    salary > (SELECT salary FROM   employees WHERE  last_name = 'Davies')
    union all
    SELECT last_name, job_id, salary
    FROM   employees where job_id = 'AD_PRES'
    order by job_id)
group by job_id
;

select 1, 'test'
from dual
union 
select null, null
from dual;
