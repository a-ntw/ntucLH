CREATE SEQUENCE itemSeq
INCREMENT BY 1
START WITH 1
NOMAXVALUE;

create sequence autonum
increment by 1
start with 1
maxvalue 100;

create sequence autonum2
increment by 1
start with 1
maxvalue 100 cycle;

drop sequence autonum2;

set serveroutput on;
declare 
    seq number;
begin
    seq := itemSeq.nextval;
    dbms_output.put_line(seq);
    dbms_output.put_line(itemSeq.currval); 
    dbms_output.put_line(itemSeq.nextval);
end;
/
insert into items values (itemSeq.nextval, 'Table');

insert into items (itemname) values ('Chair');
select * from items;

alter table items
modify itemid number(5) default itemSeq.nextval;

select * from user_Sequences;
