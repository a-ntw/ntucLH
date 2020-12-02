SELECT hire_date 
                    FROM   employees
                    WHERE  last_name = 'Davies';

SELECT last_name, hire_date
FROM   employees 
WHERE  hire_date > '29/01/05';

SELECT last_name, hire_date
FROM   employees 
WHERE  hire_date > (SELECT hire_date 
                    FROM   employees
                    WHERE  last_name = 'Davies');

SELECT last_name, job_id, salary
FROM   employees
WHERE  salary = 
                (SELECT max(salary)
                 FROM   employees);
                    
SELECT last_name, job_id, salary
FROM   employees
WHERE  job_id =  
                (SELECT job_id
                 FROM   employees
                 WHERE  last_name = 'Davies')
AND    salary >
                (SELECT salary
                 FROM   employees
                 WHERE  last_name = 'Davies');  
                 
SELECT   department_id, MIN(salary)
FROM     employees
GROUP BY department_id
HAVING   MIN(salary) >
                       (SELECT MIN(salary)
                        FROM   employees
                        WHERE  department_id = 50);
      

SELECT first_name, department_id, salary
FROM employees
WHERE salary IN
      (SELECT max(salary)
       FROM employees
       GROUP BY department_id)
ORDER BY department_id;

SELECT first_name, department_id, salary
FROM employees
WHERE (department_id, salary) in
      (SELECT department_id, max(salary)
       FROM employees
       GROUP BY department_id)
ORDER BY department_id;
                  
select *
from departments
where department_id not in (select distinct department_id from employees);

select *
from departments
where department_id not in 
(select distinct department_id from employees where department_id is not null);

select *
from departments
where department_id not in (select distinct nvl(department_id,0) from employees);

SELECT employee_id, last_name, job_id, salary
FROM   employees
WHERE  salary < ANY
                    (SELECT salary
                     FROM   employees
                     WHERE  job_id = 'IT_PROG')
AND    job_id <> 'IT_PROG';

select *
from employees e join (
    select department_id 
    from departments 
    where location_id =1700
    ) tempTable
on e.department_id = tempTable.department_id
where e.department_id between 100 and 160;

;
select * from departments ;


SELECT DEPARTMENT_NAME, (SELECT TO_CHAR(SYSDATE,'DD-MON-RR HH24:MI:SS') FROM DUAL) 
FROM DEPARTMENTS;

SELECT DEPARTMENT_NAME, (SELECT LISTAGG(FIRST_NAME,',') FROM EMPLOYEES E 
        WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID) 
FROM DEPARTMENTS D;

SELECT DEPARTMENT_NAME,  LISTAGG(FIRST_NAME,',') 
FROM DEPARTMENTS D LEFT JOIN  EMPLOYEES E 
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
GROUP BY DEPARTMENT_NAME

