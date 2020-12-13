### capstone project 4,  PL/SQL
* [Assessment_questions_w_Ans.txt](Assessment_Questions_w_Ans.txt)
* [Assessment_questionsPlSql.txt](assessmentQuestionsPlSql.txt)
* [del_data.sql](del_data.sql)
  * To remove rows, constraints, and code from the hr sample schema
* [extraPractices.md](extraPractices.md)
  * Extra
    * Create index
    * Create sequence
    * create full table w privs
    * Create new user
    * SQL Developer: new connection
    * Procedure in plSql
  * using elsIf, exception, &&empid
* [oracleWorkshop.md](oracleWorkshop.md)
  * project: oracle_sql_project.docx
    - install oracle 12c
    - install configuration
    - configuration assistant
    - connecting to Oracle Database
    - Create a new Oracle Database
    - Human Resources Data Set
  * Oracle SQL Project 2 
    - Create a view to display the employee_id, fisrt_name, last_name, salary from employees table
    
* [plSqlQueryEx.sql](plSqlQueryEx.sql)
  * SINGLE QUERY PL/SQL exercise
    * Query f_n, l_n, salary, department_id (EMP table)
  
* [plSqlExplicit.sql](plSqlExplicit.sql)
  * queries which loop thru table
    *     cursor      emp_cursor IS
    *     OPEN emp_cursor; LOOP
    *   FETCH emp_cursor into f_name, l_name, v_sal, v_deptid; 
    *     END LOOP; CLOSE emp_cursor;
  
* [software.md](software.md)
  * day1
    - install java 12c on windows
    - sqlplus sys/oracle as sysdba
    - To set connection in Mac's virtualBox SQL Developer
  * day2
    - create new connection for system, sys at SQL Developer
    - **SQL Commands**
    - import, export, hr_full.dmp
    - constraint, constraint_name
    - NULL
  * day3
    - merge
    - synonym
    - views
    - index, execution plan
    - plustrace, autot, execution plan
  * day4
    - UNDO. Flashback for Enpterprise edition:
    - Connection issues
    - sequence loader, SQLLDR, txt file
    - LSTNRCTL, listener
    - create empty table
* [trigger.md](trigger.md)
   * trig.sql
     * demo
     * audit.emp
     * grant select, insert, update, delete
> Trigger: A trigger is a stored procedure in database which automatically invokes whenever a special event in the database occurs.

* [](# )

