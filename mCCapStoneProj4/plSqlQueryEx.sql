/*
From Savari Uvakaram to Everyone: (4:58 PM)
 - duplicate employees table into EMP table
- add a column in EMP (new_salary)

-  Query f_n, l_n, salary, department_id (EMP table)
  -  Input employee id at runtime

 -  if salary <5000 then  increase salary by 18%
  -  if salary >=5000 and less than 10000  increase by 12%
 -   if salary >=10000 and <16000  increase by 8%
  -  if salary >= 16000 no increment
-   update EMP table with new salary value
-   Diplay on screen f_n, l_n, salary, and new salary

—

QL> drop table emp;

Table dropped.

SQL> create table emp as select * from employees;

Table created.

SQL> select count(*) from emp;

  COUNT(*)
----------
	20

SQL> alter table emp
2 add new_salary number(9,2);
SQL> select first_name, salarym new_salary
from emp;
SQL> ed f17
**** console output got error
*/

set serveroutput on
set verify off
declare
    f_name      emp.first_name%type;
    l_name      emp.last_name%type;
    f_sal       emp.salary%type;
    f_deptid    emp.department_id%type;
    f_newsal    emp.salary%type;
begin
    select first_name, last_name, salary, department_id
    into f_name, l_name, f_sal, f_deptid
    from emp
    where employee_id = &&empid;
    
    if f_sal < 5000 then
        f_newsal := f_sal * 1.18;
    else if f_sal >= 5000 and f_sal < 10000 then
        f_newsal := f_sal * 1.12;
    else if f_sal >=10000 and f_sal < 16000 then
        f_newsal := f_sal *1.08;
    endif;
    
    update emp
    set new_salary = f_newsal
    where employee_id = &empid;
    dbms_output.put_line( f_name || ' ' || l_name || ' '
        || to_char(f_sal) || to_char(f_newsal));
    exception
        when no_data_found then
            dbms_output.put_line('No employee selected.Check with HR');
end;
/
set serveroutput off
set verify on
undef empid
