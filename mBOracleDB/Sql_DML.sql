/*
INSERT INTO TABLENAME
(COLUMN1, ..., COLUMNn)
VALUES
(VALUE1, ..., VALUEn);
*/
INSERT INTO DEPARTMENTS(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
VALUES (71,'ICT',100,1700);

/*
INSERT INTO TABLENAME
VALUES
(VALUE1, ..., VALUEn);
*/
INSERT INTO DEPARTMENTS
VALUES (69,'CMD',102,1700);
savepoint sp01;

/*
INSERT INTO TABLENAME
(COLUMN1, ..., COLUMNn)
VALUES
(VALUE1, ..., (SELECT VALUEN FROM ANOTHERTABLE));
*/
INSERT INTO DEPARTMENTS(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
VALUES (72,'GA',
    (SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE EMAIL = 'JCHEN')
    ,1700);
savepoint sp02;
INSERT INTO DEPARTMENTS(DEPARTMENT_ID, LOCATION_ID, DEPARTMENT_NAME)
  SELECT DEPARTMENT_ID + 3 ,null ,'HR'
  FROM   employees
  WHERE  EMPLOYEE_ID = 100;

INSERT INTO DEPARTMENTS(DEPARTMENT_ID, LOCATION_ID, DEPARTMENT_NAME)
  SELECT distinct DEPARTMENT_ID + 4, null ,'HR'
  FROM   employees
  where employee_id between 103 and 1108 and department_id is not null;
 savepoint sp03; 
  select * from employees;
  
select * from departments;

/*UPDATE TABLENAME
SET COLUMN1 = VALUE, ..., COLUMNn = VALUE
WHERE CLAUSE*/
UPDATE DEPARTMENTS
SET DEPARTMENT_NAME = 'GENERAL ADMINs'
WHERE DEPARTMENT_ID = 72;
savepoint sp04;
rollback;
rollback to sp02;
commit;
select * from departments
where department_id = 72
for update;

select * from employees e join departments d
on e.department_id = d.department_id
and d.department_id = 90
for update;

update employees 
set first_name = first_name || 's'
where employee_id in (select employee_id from employees e join departments d
on e.department_id = d.department_id
and d.department_id = 90);

select * from employees e join departments d
on e.department_id = d.department_id
and d.department_id = 90
for update of e.first_name;

select * from departments
where department_id = 90;

/*DELETE FROM TABLENAME WHERE CLAUSE;
DELETE TABLENAME WHERE CLAUSE;*/


DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = 72;
DELETE DEPARTMENTS WHERE DEPARTMENT_ID IN (69, 71, 72,93);



