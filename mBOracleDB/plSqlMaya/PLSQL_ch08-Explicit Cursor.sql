/*EXPLICIT CURSOR-QUERY RETURNING 1 ROW*/
DECLARE
  CURSOR c_emp_cursor IS 
   SELECT employee_id, last_name FROM employees
   WHERE department_id =30;
  v_empno employees.employee_id%TYPE;
  v_lname employees.last_name%TYPE;
BEGIN
  OPEN c_emp_cursor;
  FETCH c_emp_cursor INTO v_empno, v_lname;
  dbms_output.put_line( v_empno ||'  '||v_lname);  
END;
/
/*EXPLICIT CURSOR-QUERY MULTIPLE ROW*/
DECLARE
  CURSOR c_emp_cursor IS 
   SELECT employee_id, last_name FROM employees
   WHERE department_id =30;
  v_empno employees.employee_id%TYPE;
  v_lname employees.last_name%TYPE;
BEGIN
  
  IF NOT c_emp_cursor%ISOPEN THEN
	OPEN c_emp_cursor;
  END IF;

  LOOP
    FETCH c_emp_cursor INTO v_empno, v_lname;
    EXIT WHEN c_emp_cursor%notfound;
    dbms_output.put_line( v_empno ||'  '||v_lname);  
  END LOOP;
  CLOSE c_emp_cursor;
  dbms_output.put_line('----');
  FOR rec IN c_emp_cursor LOOP
    dbms_output.put_line( rec.employee_id ||'  '||rec.last_name);
  END LOOP;
END;
/
DECLARE
  CURSOR c_emp_cursor (depid number) IS 
   SELECT employee_id, last_name FROM employees
   WHERE department_id =depid;
  v_empno employees.employee_id%TYPE;
  v_lname employees.last_name%TYPE;
BEGIN
  
  IF NOT c_emp_cursor%ISOPEN THEN
	OPEN c_emp_cursor(30);
  END IF;

  LOOP
    FETCH c_emp_cursor INTO v_empno, v_lname;
    EXIT WHEN c_emp_cursor%notfound;
    dbms_output.put_line( v_empno ||'  '||v_lname);  
  END LOOP;
  CLOSE c_emp_cursor;
  dbms_output.put_line('----');
  FOR rec IN c_emp_cursor(30) LOOP
    dbms_output.put_line( rec.employee_id ||'  '||rec.last_name);
  END LOOP;
END;
/
/*select for update , where current of*/
DECLARE
  CURSOR c_emp_cursor IS 
   SELECT employee_id, salary FROM employees
   WHERE department_id =30 FOR UPDATE; 
BEGIN
   FOR emp_record IN c_emp_cursor 
    LOOP
     DBMS_OUTPUT.PUT_LINE( emp_record.employee_id ||' ' ||emp_record.salary);   
		UPDATE employees
		SET salary = 5000
		WHERE CURRENT OF c_emp_cursor;
    END LOOP; 
END;
/