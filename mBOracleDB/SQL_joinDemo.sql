select emp.first_name || ' ' || emp.last_name fullname,
 department_id, dep.department_name
from employees emp natural join departments dep;

select emp.first_name || ' ' || emp.last_name fullname,
 department_id, dep.department_name
from employees emp inner join departments dep
using (department_id);

select emp.first_name || ' ' || emp.last_name fullname,
 department_id, dep.department_name
from employees emp inner join departments dep
on emp.department_id = dep.department_id;

select emp.first_name || ' ' || emp.last_name fullname,
 dep.department_id, dep.department_name
from employees emp join departments dep
on emp.department_id = dep.department_id;

select emp.first_name || ' ' || emp.last_name fullname,
 dep.department_id, dep.department_name
from employees emp, departments dep
where emp.department_id = dep.department_id
    and dep.department_id in (30,40);

select emp.first_name || ' ' || emp.last_name fullname,
 dep.department_id, dep.department_name
from employees emp join departments dep
on emp.department_id = dep.department_id
and dep.department_id in (30,40);


select emp.first_name || ' ' || emp.last_name fullname,
 dep.department_id, dep.department_name
from employees emp left outer join departments dep
on emp.department_id = dep.department_id;


select emp.first_name || ' ' || emp.last_name fullname,
 dep.department_id, dep.department_name
from employees emp right join departments dep
on emp.department_id = dep.department_id;

select emp.first_name || ' ' || emp.last_name fullname,
 dep.department_id, dep.department_name
from employees emp full outer join departments dep
on emp.department_id = dep.department_id;

select staff.first_name || ' ' || staff.last_name stafffullname,
    mgr.first_name || ' ' || mgr.last_name mgrfullname,
    staff.department_id
from employees staff left join employees mgr
on staff.manager_id = mgr.employee_id;


select staff.first_name || ' ' || staff.last_name stafffullname,
    mgr.first_name || ' ' || mgr.last_name mgrfullname,
    staff.department_id, dep.department_name, loc.city
from employees staff left join employees mgr
    on staff.manager_id = mgr.employee_id
  full join departments dep
    on staff.department_id = dep.department_id
  join locations loc
    on dep.location_id = loc.location_id
where dep.department_id in (40, 60, 80);

select mgr.first_name || ' ' || mgr.last_name mgrfullname,
    count(staff.first_name) numOfSubOrdinate,
    listagg(staff.first_name || ' ' || staff.last_name, ',')
        within group (order by staff.first_name) empList01,
    listagg(staff.first_name || ' ' || staff.last_name, ',') empList02
from employees staff left join employees mgr
    on staff.manager_id = mgr.employee_id
  full join departments dep
    on staff.department_id = dep.department_id
  join locations loc
    on dep.location_id = loc.location_id
group by mgr.first_name || ' ' || mgr.last_name
having count(staff.first_name) between 5 and 7;

select * from job_grades;

select first_name || ' ' || last_name fullname,
    grade_level
from employees join job_grades
on salary between lowest_sal and highest_sal;

create table job_grades (grade_level char(1), lowest_sal number(10,2), highest_sal number(10,2));
insert into job_grades (grade_level, lowest_sal, highest_sal) values 
 ('A',1000,3999);
insert into job_grades (grade_level, lowest_sal, highest_sal) values 
 ('B',4000,8999);
 insert into job_grades (grade_level, lowest_sal, highest_sal) values 
 ('C',9000,24999);
 insert into job_grades (grade_level, lowest_sal, highest_sal) values 
 ('D',25000,89999);
 
  

desc employees;
desc departments;