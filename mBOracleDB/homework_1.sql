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


