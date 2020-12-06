SET SERVEROUTPUT ON;

DECLARE
    v_hiredate  DATE DEFAULT sysdate - 2;
    v_location  VARCHAR2(13) := 'Atlanta';
    v_deptno    NUMBER(2) NOT NULL := 10;
    c_comm      CONSTANT NUMBER := 1400;
    v_fullname  VARCHAR2(100) := 'John Doe';
    v_text      v_location%TYPE;
BEGIN
    v_text := q'[How're you]';
    dbms_output.put_line(v_text);
    v_text := 'How''re you';
    dbms_output.put_line(v_text);
    v_hiredate := '27-jan-2004';
    SELECT
        first_name || ' ' || last_name
    INTO v_fullname
    FROM
        employees
    WHERE employee_id = 100
        AND hire_date < v_hiredate;

    dbms_output.put_line('emp full name:' || v_fullname);
END;
/
variable v_outerVar1 number;
variable v_outerVar2 number;
begin
   :v_outerVar1 := 100;
   :v_outerVar2 := 200;
   select department_id into :v_outervar2
   from employees where employee_id = :v_outerVar1;
end;
/
print v_outervar1;
print v_outerVar2;
print;
/
set autoprint on

variable v_outerVar3 number
variable v_outerVar4 number
begin
   :v_outerVar3 := 100;
   :v_outerVar4 := 200;
   select department_id into :v_outervar3
   from employees where employee_id = :v_outerVar4;
end;
/