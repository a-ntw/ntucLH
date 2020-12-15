drop table products;
drop sequence pid_seq ;
create table products (
   id           INT PRIMARY KEY,
   name         VARCHAR (40) NOT NULL,
   price        NUMERIC (6,2) NOT NULL,
   best_before  DATE,
   version      INT DEFAULT 1);
CREATE SEQUENCE pid_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;




insert into products values (pid_seq.NEXTVAL, 'Cookie', 2.99, TO_DATE(sysdate, 'dd/mm/yyyy'), 1);
insert into products values (pid_seq.NEXTVAL, 'Cake', 3.99, TO_DATE(sysdate, 'dd/mm/yyyy'), 1);
insert into products values (pid_seq.NEXTVAL, 'Tea', 1.99, TO_DATE(sysdate, 'dd/mm/yyyy'), 1);
insert into products values (pid_seq.NEXTVAL, 'Coffee', 1.99, null, 1);



select * from hr.products;
