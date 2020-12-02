set serveroutput on;
declare
   v_eName varchar2(50);
begin
   select first_name into v_eName
   from employees where employee_id = 100;
   dbms_output.put_line('First name:' || v_eName);
end;
/
set serveroutput on;
declare
   v_fName varchar2(50);
    v_lName varchar2(50);
begin
   select first_name, last_name into v_fName, v_lname
   from employees where employee_id = 100;
   dbms_output.put_line('Full name:' || v_fName || ' ' || v_lname);
end;