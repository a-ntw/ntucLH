Select *
From User_Sequences;

SET SERVEROUTPUT ON;

Declare
    V_Job  Employees.Job_Id%Type := 'ST_CLERK';
    V_Emp  Employees.Employee_Id%Type := 180;
Begin
/*
    Insert Into Employees (
        Employee_Id, First_Name, Last_Name,
        Email, Hire_Date, Job_Id, Salary
    ) Values (
        Employees_Seq.Nextval,'Ruth', 'Cores', 
        'RCORED', Current_Date, 'AD_ASST',4000
    );

    Update Employees
    Set Salary = Nvl2(Commission_Pct, Salary * 1.03, Salary * 1.05)
    Where Job_Id = V_Job;

    Delete From Employees
    Where Employee_Id = V_Emp;
*/
    Merge Into Copy_Emp C
    Using Employees E On ( E.Employee_Id = C.Employee_Id )
    When Matched Then Update
    Set C.First_Name = E.First_Name,
        C.Last_Name = E.Last_Name,
        C.Email = E.Email,
        C.Phone_Number = E.Phone_Number,
        C.Hire_Date = E.Hire_Date,
        C.Job_Id = E.Job_Id,
        C.Salary = E.Salary,
        C.Commission_Pct = E.Commission_Pct,
        C.Manager_Id = E.Manager_Id,
        C.Department_Id = E.Department_Id
    When Not Matched Then Insert
    Values
        ( E.Employee_Id, E.First_Name,
        E.Last_Name, E.Email,
        E.Phone_Number, E.Hire_Date,
        E.Job_Id, E.Salary,
        E.Commission_Pct, E.Manager_Id, E.Department_Id );
        
        if (sql%found) then
            dbms_output.put_line('sql%found = true');
        else
            dbms_output.put_line('sql%found=false');
        end if;
        
        if (sql%notfound) then
            dbms_output.put_line('sql%notfound = true');
        else
            dbms_output.put_line('sql%notfound=false');
        end if;
        DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT);
        
End;
/

select * from employees;

UPDATE EMPLOYEES SET SALARY = SALARY * 1.05 WHERE EMPLOYEE_ID BETWEEN 100 AND 108;
Create Table Copy_Emp As
        Select *
        From Employees
        Where Employee_Id = 1;

Select * From Copy_Emp;

truncate table copy_Emp;



Select * From Employees;