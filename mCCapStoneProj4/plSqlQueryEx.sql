/* ********** SINGLE QUERY PL/SQL. exercise
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
**** note.... ELSIF,  else if without e
*/
set serveroutput on
set verify off
declare
    f_name      emp.first_name%type;
    l_name      emp.last_name%type;
    v_sal       emp.salary%type;
    v_deptid    emp.department_id%type;
    v_newsal    emp.salary%type;
begin

    select first_name, last_name, salary, department_id
    into f_name, l_name, v_sal, v_deptid
    from emp
    where employee_id = &&empid;
   
    IF v_sal < 5000  THEN
        v_newsal := v_sal * 1.18;
    ELSIF v_sal >= 5000 AND v_sal < 10000 THEN
        v_newsal := v_sal * 1.12;
    ELSIF v_sal >=10000 and v_sal < 16000 THEN
        v_newsal := v_sal *1.08;
    END IF;
   

    update emp
    set new_salary = v_newsal
    where employee_id = &empid;
    dbms_output.put_line( f_name || ' ' || l_name || ' '
        || to_char(v_sal) || to_char(v_newsal));

   exception
        when no_data_found then
            dbms_output.put_line('No employee selected.Check with HR');
        
end;
/
set serveroutput off
set verify on
undef empid


