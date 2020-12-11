set serveroutput on
declare
    f_name      emp.first_name%type;
    l_name      emp.last_name%type;
    v_sal       emp.salary%type;
    v_deptid    emp.department_id%type;
    v_newsal    emp.salary%type;
    
    cursor      emp_cursor IS
        select first_name, last_name, salary, department_id
        from emp
        for update;

begin
    OPEN emp_cursor;
    LOOP
        FETCH emp_cursor into f_name, l_name, v_sal, v_deptid;
        EXIT WHEN emp_cursor%NOTFOUND;
   
        IF v_sal < 5000  THEN
            v_newsal := v_sal * 1.18;
        ELSIF v_sal < 10000 THEN
            v_newsal := v_sal * 1.12;
        ELSIF v_sal >=10000 and v_sal < 16000 THEN
            v_newsal := v_sal *1.08;
        END IF;
   
        update emp
        set new_salary = v_newsal
        where current of emp_cursor;
        dbms_output.put_line( f_name || ' ' || l_name || ' '
            || to_char(v_sal) || to_char(v_newsal));

    END LOOP;
    CLOSE emp_cursor;
end;
/
set serveroutput off
