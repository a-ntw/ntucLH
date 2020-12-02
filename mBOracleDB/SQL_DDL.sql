/*CREATE TABLE [schema.]table
      (column datatype [DEFAULT expr]
      [column_constraint],
      ...
      [table_constraint][,...]);
*/
drop table items;
create table items
( itemid number(4) primary key,
    itemName varchar2(30) not null
);

drop table customers;
create table customers(
customerid number(4),
custname varchar2(30) not null,
address varchar2(50),
email varchar2(50),
remarks varchar2(10),
primary key(customerid));

desc items;

desc customers;

drop table invoiceHeaders;
create table invoiceHeaders(
invNo varchar2(5), 
customerid number(4),
trxDate date default sysdate
);

drop table empTemp ;
create table empTemp as select * from employees;
select * from empTemp;

alter table invoiceHeaders
add primary key(invNo)
add foreign key(customerid) references customers(customerid);

drop table invoiceDetails;
create table invoiceDetails(
    invNo varchar2(5),
    itemid number(4) ,
    qty number(3),
    price number(10,2),
    foreign key(itemid) references items(itemid)  on delete set null
);

drop table items;

delete items;
select *
from invoiceDetails;

alter table invoiceDetails
add primary key (invNo, itemid);


/*
alter table tablename
add foreign key(columnname) references reftablename(refcolumnName)
*/

alter table customers
modify email varchar2(30);

alter table customers
drop column remarks;

alter table customers
drop (email);

create table depTemp
as select * from departments where department_id between 70 and 100;

insert into items
values (1, 'Tyre');
insert into items
values (2, 'Wheel');
select * from items;

select * from customers;
insert into customers values (1, 'Jane','Sengkang');
insert into customers values (2, 'Alex','Sengkang');

insert into customers values (3, 'Barney','Sengkang');

select * from invoiceheaders;
insert into invoiceheaders
values ('TS001',1,sysdate);

insert into invoiceheaders (invNo, customerid)
values ('TS002',2);

insert into invoiceheaders (invNo, customerid)
values ('TS003',3);

select * from invoicedetails;
insert into invoicedetails 
values ('TS001',1,10,1000);

insert into invoicedetails 
values ('TS001',2,15,1400);

delete customers
where customerid = 2;

delete items
where itemid = 1;

select * from items;

select * from invoicedetails;
select * from customers;

drop table customers;

select * from DepTEmp;
desc departments;
desc deptemp;