select count(*) count01, count(manager_id) count02, 
    max(salary) max01, min(salary) min01, 
    round(avg(salary),2) avg01, sum(salary) sum01,
    round(stddev(salary),2) stdDeviation,
    round(variance(salary),2) variance01
    from employees;

select listagg(first_name,',') emplist01,
    listagg(first_name,',') within group (order by first_name) emplist2
from employees;

select department_id, count(employee_id) numOfEmp, 
    to_char(round(avg(Salary),2),'fmL999,999.00') avgSal
    from employees
    group by department_id;
    

select department_id, job_id, count(employee_id) numOfEmp, 
    to_char(round(avg(Salary),2),'fmL999,999.00') avgSal
    from employees
    group by department_id, job_id;
    
    
select department_id, job_id, count(employee_id) numOfEmp, 
    to_char(round(avg(Salary),2),'fmL999,999.00') avgSal
    from employees
    group by department_id, job_id
    order by department_id desc, job_id;
    
    
select department_id, job_id, count(employee_id) numOfEmp, 
    to_char(round(avg(Salary),2),'fmL999,999.00') avgSal
    from employees
    group by department_id, job_id
    having avg(Salary) > 12000
    order by department_id desc, job_id;
    